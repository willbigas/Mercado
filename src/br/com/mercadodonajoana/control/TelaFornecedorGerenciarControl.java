package br.com.mercadodonajoana.control;

import br.com.mercadodonajoana.dao.EnderecoDao;
import br.com.mercadodonajoana.dao.FornecedorDao;
import br.com.mercadodonajoana.model.Endereco;
import br.com.mercadodonajoana.model.Fornecedor;
import br.com.mercadodonajoana.model.tablemodel.FornecedorTableModel;
import br.com.mercadodonajoana.uteis.Mensagem;
import br.com.mercadodonajoana.uteis.Texto;
import br.com.mercadodonajoana.view.TelaFornecedorGerenciar;
import br.com.mercadodonajoana.view.TelaPrincipal;
import java.beans.PropertyVetoException;

/**
 *
 * @author Will
 */
public class TelaFornecedorGerenciarControl {

    TelaFornecedorGerenciar telaFornecedorGerenciar;
    Fornecedor fornecedor;
    FornecedorDao fornecedorDao;
    FornecedorTableModel tableModelFornecedor;
    EnderecoDao enderecoDao;

    public TelaFornecedorGerenciarControl() {
        fornecedorDao = new FornecedorDao();
        enderecoDao = new EnderecoDao();
        tableModelFornecedor = new FornecedorTableModel();
        tableModelFornecedor.adicionar(fornecedorDao.pesquisar());
    }

    public void chamarTelaFornecedorGerenciar() {
        if (telaFornecedorGerenciar == null) { // se tiver nulo chama janela normalmente
            telaFornecedorGerenciar = new TelaFornecedorGerenciar(this);
            TelaPrincipal.desktopPane.add(telaFornecedorGerenciar);
            telaFornecedorGerenciar.setVisible(true);
        } else {//se ele estiver criado
            if (telaFornecedorGerenciar.isVisible()) {
                telaFornecedorGerenciar.pack();//Redimensiona ao Quadro Original
            } else {
                TelaPrincipal.desktopPane.add(telaFornecedorGerenciar);
                telaFornecedorGerenciar.setVisible(true);
            }
        }
        telaFornecedorGerenciar.getTblFornecedor().setModel(tableModelFornecedor);
    }

    public void cadastrarFornecedor() {
        if (validarCampos()) {
            Mensagem.erro(Texto.ERRO_CADASTRAR);
            return;
        }
        fornecedor = new Fornecedor();
        fornecedor.setNome(telaFornecedorGerenciar.getTfNome().getText());
        fornecedor.setTelefone(telaFornecedorGerenciar.getTfTelefone().getText());
        Endereco endereco = new Endereco();
        endereco.setBairro(telaFornecedorGerenciar.getTfBairro().getText());
        endereco.setCep(Integer.valueOf(telaFornecedorGerenciar.getTfCep().getText()));
        endereco.setCidade(telaFornecedorGerenciar.getTfCidade().getText());
        endereco.setComplemento(telaFornecedorGerenciar.getTfComplemento().getText());
        endereco.setEstado(telaFornecedorGerenciar.getTfEstado().getText());
        endereco.setNumero(telaFornecedorGerenciar.getTfNumero().getText());
        endereco.setRua(telaFornecedorGerenciar.getTfRua().getText());
        Integer idEndereco = enderecoDao.inserir(endereco);
        endereco.setId(idEndereco);
        fornecedor.setEndereco(endereco);

        if (telaFornecedorGerenciar.getCheckAtivo().isSelected()) {
            fornecedor.setAtivo(true);
        } else {
            fornecedor.setAtivo(false);
        }

        Integer idInserido = fornecedorDao.inserir(fornecedor);
        if (idInserido != 0) {
            fornecedor.setId(idInserido);
            tableModelFornecedor.adicionar(fornecedor);
            limparCampos();
            Mensagem.info(Texto.SUCESSO_CADASTRAR);
        } else {
            Mensagem.info(Texto.ERRO_CADASTRAR);
        }
        fornecedor = null;
    }

    public void carregarFornecedorAction() throws PropertyVetoException {
        fornecedor = tableModelFornecedor.pegaObjeto(telaFornecedorGerenciar.getTblFornecedor().getSelectedRow());
        telaFornecedorGerenciar.getTfNome().setText(fornecedor.getNome());
        telaFornecedorGerenciar.getTfBairro().setText(fornecedor.getEndereco().getBairro());
        telaFornecedorGerenciar.getTfCidade().setText(fornecedor.getEndereco().getCidade());
        telaFornecedorGerenciar.getTfComplemento().setText(fornecedor.getEndereco().getComplemento());
        telaFornecedorGerenciar.getTfEstado().setText(fornecedor.getEndereco().getEstado());
        telaFornecedorGerenciar.getTfNumero().setText(fornecedor.getEndereco().getNumero());
        telaFornecedorGerenciar.getTfRua().setText(fornecedor.getEndereco().getRua());
        telaFornecedorGerenciar.getTfTelefone().setText(fornecedor.getTelefone());
        telaFornecedorGerenciar.getTfCep().setText(String.valueOf(fornecedor.getEndereco().getCep()));

        if (fornecedor.getAtivo() == true) {
            telaFornecedorGerenciar.getCheckAtivo().setSelected(true);
        } else {
            telaFornecedorGerenciar.getCheckAtivo().setSelected(false);
        }

    }

    private void limparCampos() {
        telaFornecedorGerenciar.getTfNome().setText("");
        telaFornecedorGerenciar.getTfBairro().setText("");
        telaFornecedorGerenciar.getTfCep().setText("");
        telaFornecedorGerenciar.getTfCidade().setText("");
        telaFornecedorGerenciar.getTfComplemento().setText("");
        telaFornecedorGerenciar.getTfEstado().setText("");
        telaFornecedorGerenciar.getTfNumero().setText("");
        telaFornecedorGerenciar.getTfTelefone().setText("");
        telaFornecedorGerenciar.getTfPesquisar().setText("");
        telaFornecedorGerenciar.getTfRua().setText("");
        telaFornecedorGerenciar.getCheckAtivo().setSelected(false);
        telaFornecedorGerenciar.getTfNome().requestFocus();
    }

    private boolean validarCampos() {
        if (telaFornecedorGerenciar.getTfNome().getText().isEmpty() || telaFornecedorGerenciar.getTfBairro().getText().isEmpty()
                || telaFornecedorGerenciar.getTfCep().getText().isEmpty() || telaFornecedorGerenciar.getTfCidade().getText().isEmpty()
                || telaFornecedorGerenciar.getTfEstado().getText().isEmpty() || telaFornecedorGerenciar.getTfNumero().getText().isEmpty()
                || telaFornecedorGerenciar.getTfNumero().getText().isEmpty() || telaFornecedorGerenciar.getTfTelefone().getText().isEmpty()
                || telaFornecedorGerenciar.getTfRua().getText().isEmpty()) {
            telaFornecedorGerenciar.getTfNome().requestFocus();
            return true;
        }
        return false;
    }
}
