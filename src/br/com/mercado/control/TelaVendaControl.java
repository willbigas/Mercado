package br.com.mercado.control;

import br.com.mercado.dao.ClienteDao;
import br.com.mercado.dao.ItemVendaDao;
import br.com.mercado.dao.ProdutoDao;
import br.com.mercado.dao.UsuarioDao;
import br.com.mercado.dao.VendaDao;
import br.com.mercado.model.Cliente;
import br.com.mercado.model.ItemVenda;
import br.com.mercado.model.Produto;
import br.com.mercado.model.Usuario;
import br.com.mercado.model.Venda;
import br.com.mercado.model.tablemodel.ItemVendaTableModel;
import br.com.mercado.model.tablemodel.VendaProdutoTableModel;
import br.com.mercado.uteis.Mensagem;
import br.com.mercado.uteis.Texto;
import br.com.mercado.uteis.UtilDate;
import br.com.mercado.view.TelaPrincipal;
import br.com.mercado.view.TelaVenda;
import br.com.mercado.view.TelaVendaReceita;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Will
 */
public class TelaVendaControl {

    TelaVenda telaVenda;
    TelaVendaReceita telaVendaReceita;
    TelaReceitaGerenciarControl receitaGerenciarControl;
    ClienteDao clienteDao;
    UsuarioDao usuarioDao;
    ProdutoDao produtoDao;
    VendaDao vendaDao;
    ItemVendaDao itemVendaDao;
    List<Cliente> listClientes;
    List<Usuario> listUsuarios;
    List<ItemVenda> listItemVendas;
    VendaProdutoTableModel vendaProdutoTableModel;
    ItemVendaTableModel itemVendaTableModel;
    ItemVenda itemVenda;
    Venda venda;
    

    public TelaVendaControl() {
        clienteDao = new ClienteDao();
        usuarioDao = new UsuarioDao();
        produtoDao = new ProdutoDao();
        vendaDao = new VendaDao();
        itemVendaDao = new ItemVendaDao();
        listClientes = new ArrayList<>();
        listUsuarios = new ArrayList<>();
        vendaProdutoTableModel = new VendaProdutoTableModel();
        itemVendaTableModel = new ItemVendaTableModel();
        listItemVendas = new ArrayList<>();

    }

    public void chamarTelaVenda() {
        if (telaVenda == null) {
            telaVenda = new TelaVenda(this);
            TelaPrincipal.desktopPane.add(telaVenda);
            telaVenda.setVisible(true);
        } else {
            if (telaVenda.isVisible()) {
                telaVenda.pack();
            } else {
                TelaPrincipal.desktopPane.add(telaVenda);
                telaVenda.setVisible(true);
            }
        }
        carregarClientesNaCombo();
        carregarUsuariosNaCombo();
        telaVenda.getTblProduto().setModel(vendaProdutoTableModel);
        vendaProdutoTableModel.limpar();
        vendaProdutoTableModel.adicionar(produtoDao.pesquisar());
        telaVenda.getTblVenda().setModel(itemVendaTableModel);
    }

    private void carregarClientesNaCombo() {
        listClientes = clienteDao.pesquisar();
        DefaultComboBoxModel<Cliente> model = new DefaultComboBoxModel(listClientes.toArray());
        telaVenda.getCbCliente().setModel(model);
    }

    private void carregarUsuariosNaCombo() {
        listUsuarios = usuarioDao.pesquisar();
        DefaultComboBoxModel<Usuario> model = new DefaultComboBoxModel(listUsuarios.toArray());
        telaVenda.getCbUsuario().setModel(model);
    }
    
    
    public void adicionarItemVendaAction () {
        itemVenda = new ItemVenda();
        itemVenda.setId(1);
        itemVenda.setQuantidade(Integer.valueOf(telaVenda.getTfQuantidade().getText()));
        itemVenda.setValorProduto(Double.valueOf(telaVenda.getTfValor().getText()));
        itemVenda.setProduto(vendaProdutoTableModel.pegaObjeto(telaVenda.getTblProduto().getSelectedRow()));
        listItemVendas.add(itemVenda);
        itemVendaTableModel.adicionar(itemVenda);
        itemVenda = null;
    }
    
    public void removerItemVendaAction() {
        int retorno = Mensagem.confirmacao(Texto.PERGUNTA_REMOVER_ITEM_VENDA);
        if (retorno == JOptionPane.NO_OPTION) {
            return;
        }
        itemVenda = itemVendaTableModel.pegaObjeto(telaVenda.getTblVenda().getSelectedRow());
        listItemVendas.remove(itemVenda);
        itemVendaTableModel.remover(telaVenda.getTblVenda().getSelectedRow());
        Mensagem.info(Texto.SUCESSO_REMOVER);
        itemVenda = null;
    }
    
     public void chamarDialogVendaReceitaAction() {
        telaVendaReceita = new TelaVendaReceita(telaVenda, true, this);
        telaVendaReceita.setVisible(true);
    }
    
    
     public void adicionarVendaAction() {
        venda = new Venda();
        venda.setDataVenda(LocalDateTime.now());
        venda.setCliente((Cliente) telaVenda.getCbCliente().getSelectedItem());
        venda.setUsuario((Usuario) telaVenda.getCbUsuario().getSelectedItem());
        Integer idVendaInserida = vendaDao.inserir(venda);

        if (idVendaInserida == 0) {
            Mensagem.erro(Texto.ERRO_CADASTRAR);
            return;
        }

        venda.setId(idVendaInserida);
        for (int i = 0; i < listItemVendas.size(); i++) {
            ItemVenda umItemVendaDaTabela = listItemVendas.get(i);
            umItemVendaDaTabela.setVenda(venda);

            Produto produtoDoItemVenda = produtoDao.pesquisar(umItemVendaDaTabela.getProduto().getId());

            produtoDoItemVenda.setQuantidade(umItemVendaDaTabela.getQuantidade());
            produtoDoItemVenda.setValor(umItemVendaDaTabela.getValorProduto());

            umItemVendaDaTabela.setProduto(produtoDoItemVenda);
            itemVendaDao.inserir(umItemVendaDaTabela);
        }

        try {

            Date dataVencimento = UtilDate.data(telaVendaReceita.getTfDataVencimento().getText());
            Double valorTotalRecebimento = Double.valueOf(telaVendaReceita.getTfValorRecebimento().getText());
            System.out.println("Data de Vencimento " + dataVencimento);
            System.out.println("Valor total para recebimento" + valorTotalRecebimento);

            receitaGerenciarControl = new TelaReceitaGerenciarControl();
            receitaGerenciarControl.criarReceita(idVendaInserida, dataVencimento, valorTotalRecebimento);
        } catch (Exception exception) {
            Mensagem.erro(Texto.ERRO_COVERTER_CAMPO_DATA);
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Itens gravados com sucesso");
        venda.setItemVendas(listItemVendas);
    }

}
