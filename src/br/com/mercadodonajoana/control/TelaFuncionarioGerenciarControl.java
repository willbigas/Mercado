package br.com.mercadodonajoana.control;

import br.com.mercadodonajoana.api.buscacep.control.BuscaCep;
import br.com.mercadodonajoana.api.buscacep.exceptions.BuscaCepException;
import br.com.mercadodonajoana.api.buscacep.interfaces.BuscaCepEventos;
import br.com.mercadodonajoana.api.buscacep.interfaces.BuscaCepEventosImpl;
import br.com.mercadodonajoana.dao.EnderecoDao;
import br.com.mercadodonajoana.dao.FuncionarioDao;
import br.com.mercadodonajoana.dao.TipoUsuarioDao;
import br.com.mercadodonajoana.model.Endereco;
import br.com.mercadodonajoana.model.Funcionario;
import br.com.mercadodonajoana.model.TipoUsuario;
import br.com.mercadodonajoana.model.tablemodel.FuncionarioTableModel;
import br.com.mercadodonajoana.uteis.Enderecos;
import br.com.mercadodonajoana.uteis.Mensagem;
import br.com.mercadodonajoana.uteis.Texto;
import br.com.mercadodonajoana.view.TelaPrincipal;
import br.com.mercadodonajoana.view.TelaFuncionarioGerenciar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class TelaFuncionarioGerenciarControl {

    TelaFuncionarioGerenciar telaFuncionarioGerenciar;
    List<TipoUsuario> listTiposUsuarios;
    TipoUsuarioDao tipoUsuarioDao;
    FuncionarioDao funcionarioDao;
    FuncionarioTableModel tableModelFuncionarios;
    Funcionario funcionario;
    EnderecoDao enderecoDao;
    Integer linhaSelecionada;
    Endereco endereco;

    public TelaFuncionarioGerenciarControl() {
        tipoUsuarioDao = new TipoUsuarioDao();
        funcionarioDao = new FuncionarioDao();
        enderecoDao = new EnderecoDao();
        tableModelFuncionarios = new FuncionarioTableModel();
    }

    public void carregarEstadosNaComboBox() {
        telaFuncionarioGerenciar.getCbEstado().setModel(new DefaultComboBoxModel<>(Enderecos.ESTADOS_BRASILEIROS));
    }

    public void chamarTelaFuncionarioGerenciar() {
        if (telaFuncionarioGerenciar == null) { // se tiver nulo chama janela normalmente
            telaFuncionarioGerenciar = new TelaFuncionarioGerenciar(this);
            TelaPrincipal.desktopPane.add(telaFuncionarioGerenciar);
            telaFuncionarioGerenciar.setVisible(true);
        } else {//se ele estiver criado
            if (telaFuncionarioGerenciar.isVisible()) {
                telaFuncionarioGerenciar.pack();//Redimensiona ao Quadro Original
            } else {
                TelaPrincipal.desktopPane.add(telaFuncionarioGerenciar);
                telaFuncionarioGerenciar.setVisible(true);
            }
        }
        carregarTiposUsuariosNaCombo();
        carregarEstadosNaComboBox();
        telaFuncionarioGerenciar.getTblFuncionario().setModel(tableModelFuncionarios);
        tableModelFuncionarios.adicionar(funcionarioDao.pesquisar());
    }

    private void carregarTiposUsuariosNaCombo() {
        listTiposUsuarios = tipoUsuarioDao.pesquisar();
        DefaultComboBoxModel<TipoUsuario> model = new DefaultComboBoxModel(listTiposUsuarios.toArray());
        telaFuncionarioGerenciar.getCbTipoUsuario().setModel(model);
    }

    private void inserirFuncionario() {
        funcionario = new Funcionario();
        criarFuncionario();
        Integer idInserido = funcionarioDao.inserir(funcionario);
        if (idInserido != 0) {
            funcionario.setId(idInserido);
            tableModelFuncionarios.adicionar(funcionario);
            limparCampos();
            Mensagem.info(Texto.SUCESSO_CADASTRAR);
        } else {
            Mensagem.info(Texto.ERRO_CADASTRAR);
        }
        funcionario = null;
    }

    private void alterarFuncionario() {
        criarFuncionario();
        boolean alterado = funcionarioDao.alterar(funcionario);
        linhaSelecionada = telaFuncionarioGerenciar.getTblFuncionario().getSelectedRow();
        if (alterado) {
            tableModelFuncionarios.atualizar(linhaSelecionada, funcionario);
            Mensagem.info(Texto.SUCESSO_EDITAR);
            limparCampos();
        } else {
            Mensagem.erro(Texto.ERRO_EDITAR);
        }
        funcionario = null;
        endereco = null;
    }

    private void criarFuncionario() throws NumberFormatException {
        funcionario.setNome(telaFuncionarioGerenciar.getTfNome().getText());
        funcionario.setTelefone(telaFuncionarioGerenciar.getTfTelefone().getText());
        funcionario.setEmail(telaFuncionarioGerenciar.getTfEmail().getText());
        funcionario.setPis(Integer.valueOf(telaFuncionarioGerenciar.getTfPis().getText()));
        funcionario.setSalario(Double.valueOf(telaFuncionarioGerenciar.getTfSalario().getText()));
        funcionario.setSenha(telaFuncionarioGerenciar.getTfSenha().getText());
        funcionario.setTipoUsuario((TipoUsuario) telaFuncionarioGerenciar.getCbTipoUsuario().getSelectedItem());

        // modifica os atributos baseado no que o usuario modificar.
        endereco.setBairro(telaFuncionarioGerenciar.getTfBairro().getText());
        endereco.setCep(Integer.valueOf(telaFuncionarioGerenciar.getTfCep().getText()));
        endereco.setCidade(telaFuncionarioGerenciar.getTfCidade().getText());
        endereco.setComplemento(telaFuncionarioGerenciar.getTfComplemento().getText());
        endereco.setEstado((String) telaFuncionarioGerenciar.getCbEstado().getSelectedItem());
        endereco.setNumero(telaFuncionarioGerenciar.getTfNumero().getText());
        endereco.setRua(telaFuncionarioGerenciar.getTfRua().getText());
        Integer idEndereco = enderecoDao.inserir(endereco);
        endereco.setId(idEndereco);
        funcionario.setEndereco(endereco);

        if (telaFuncionarioGerenciar.getCheckAtivo().isSelected()) {
            funcionario.setAtivo(true);
        } else {
            funcionario.setAtivo(false);
        }
    }

    public void buscaCepEMostraNaTela() {
        BuscaCepEventos buscaCepEvents = new BuscaCepEventosImpl();
        BuscaCep buscadorDeCep = new BuscaCep();
        try {
            buscadorDeCep.buscar(telaFuncionarioGerenciar.getTfCep().getText());
            Endereco endereco = new Endereco();
//            endereco.setCep(Integer.valueOf(buscadorDeCep.getCep()));
            endereco.setBairro(buscadorDeCep.getBairro());
            endereco.setCidade(buscadorDeCep.getCidade());
            endereco.setRua(buscadorDeCep.getLogradouro());
            endereco.setComplemento(buscadorDeCep.getComplemento());
            System.out.println("Endereco encontrado" + endereco);

            // mostra na tela o cep pesquisado
            telaFuncionarioGerenciar.getTfBairro().setText(endereco.getBairro());
            telaFuncionarioGerenciar.getTfCidade().setText(endereco.getCidade());
            telaFuncionarioGerenciar.getTfComplemento().setText(endereco.getComplemento());
            telaFuncionarioGerenciar.getTfRua().setText(endereco.getRua());
            telaFuncionarioGerenciar.getTfCep().setText(telaFuncionarioGerenciar.getTfCep().getText());
        } catch (BuscaCepException buscaCepException) {
            System.out.println(buscaCepException.getMessage());
            buscaCepException.printStackTrace();
        } catch (NumberFormatException numberFormatException) {
            System.out.println(numberFormatException.getMessage());
            numberFormatException.printStackTrace();
        }
    }

    public void gravarFuncionarioAction() {
        if (funcionario == null) {
            inserirFuncionario();
        } else {
            alterarFuncionario();
        }
    }

    public void desativarFuncionarioAction() {
        int retorno = Mensagem.confirmacao(Texto.PERGUNTA_DESATIVAR);

        if (retorno == JOptionPane.NO_OPTION) {
            return;
        }
        if (retorno == JOptionPane.YES_OPTION) {
            funcionario = tableModelFuncionarios.pegaObjeto(telaFuncionarioGerenciar.getTblFuncionario().getSelectedRow());
            boolean deletado = funcionarioDao.desativar(funcionario.getId());
            if (deletado) {
                tableModelFuncionarios.remover(telaFuncionarioGerenciar.getTblFuncionario().getSelectedRow());
                telaFuncionarioGerenciar.getTblFuncionario().clearSelection();
                Mensagem.info(Texto.SUCESSO_DESATIVAR);
            } else {
                Mensagem.erro(Texto.ERRO_DESATIVAR);
            }
        }
        funcionario = null;
    }

    public void carregarFuncionariosAction() {
        funcionario = tableModelFuncionarios.pegaObjeto(telaFuncionarioGerenciar.getTblFuncionario().getSelectedRow());
        telaFuncionarioGerenciar.getTfNome().setText(funcionario.getNome());
        telaFuncionarioGerenciar.getTfTelefone().setText(funcionario.getTelefone());
        telaFuncionarioGerenciar.getTfEmail().setText(funcionario.getEmail());
        telaFuncionarioGerenciar.getTfPis().setText(String.valueOf(funcionario.getPis()));
        telaFuncionarioGerenciar.getTfSalario().setText(String.valueOf(funcionario.getSalario()));
        telaFuncionarioGerenciar.getTfSenha().setText(funcionario.getSenha());

        telaFuncionarioGerenciar.getTfBairro().setText(funcionario.getEndereco().getBairro());
        telaFuncionarioGerenciar.getTfCidade().setText(funcionario.getEndereco().getCidade());
        telaFuncionarioGerenciar.getTfComplemento().setText(funcionario.getEndereco().getComplemento());
        telaFuncionarioGerenciar.getCbEstado().getModel().setSelectedItem(funcionario.getEndereco().getEstado());
        telaFuncionarioGerenciar.getTfNumero().setText(funcionario.getEndereco().getNumero());
        telaFuncionarioGerenciar.getTfRua().setText(funcionario.getEndereco().getRua());
        telaFuncionarioGerenciar.getTfCep().setText(String.valueOf(funcionario.getEndereco().getCep()));

        if (funcionario.getAtivo() == true) {
            telaFuncionarioGerenciar.getCheckAtivo().setSelected(true);
        } else {
            telaFuncionarioGerenciar.getCheckAtivo().setSelected(false);
        }

    }

    private void limparCampos() {
        telaFuncionarioGerenciar.getTfNome().setText("");
        telaFuncionarioGerenciar.getTfTelefone().setText("");
        telaFuncionarioGerenciar.getTfEmail().setText("");
        telaFuncionarioGerenciar.getTfPis().setText("");
        telaFuncionarioGerenciar.getTfSalario().setText("");
        telaFuncionarioGerenciar.getTfSenha().setText("");
        telaFuncionarioGerenciar.getTfPesquisar().setText("");
        telaFuncionarioGerenciar.getTfCidade().setText("");
        telaFuncionarioGerenciar.getTfBairro().setText("");
        telaFuncionarioGerenciar.getTfComplemento().setText("");
        telaFuncionarioGerenciar.getTfRua().setText("");
        telaFuncionarioGerenciar.getTfCep().setText("");
        telaFuncionarioGerenciar.getTfNumero().setText("");
        telaFuncionarioGerenciar.getCheckAtivo().setSelected(false);
        telaFuncionarioGerenciar.getCbTipoUsuario().setSelectedItem(0);
        telaFuncionarioGerenciar.getCbEstado().setSelectedItem(0);
        telaFuncionarioGerenciar.getTfNome().requestFocus();
    }
}
