package br.com.mercado.control;

import br.com.mercado.dao.EntradaDao;
import br.com.mercado.dao.FornecedorDao;
import br.com.mercado.dao.ProdutoDao;
import br.com.mercado.model.Fornecedor;
import br.com.mercado.model.tablemodel.EntradaProdutoTableModel;
import br.com.mercado.model.tablemodel.EntradaTableModel;
import br.com.mercado.view.TelaEntradaGerenciar;
import br.com.mercado.view.TelaPrincipal;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author William
 */
public class TelaEntradaGerenciarControl {

    private TelaEntradaGerenciar telaEntradaGerenciar = null;
    EntradaProdutoTableModel entradaProdutoTableModel;
    EntradaTableModel entradaTableModel;
    private List<Fornecedor> listFornecedores;
    private FornecedorDao fornecedorDao;
    private ProdutoDao produtoDao;
    private EntradaDao entradaDao;

    public TelaEntradaGerenciarControl() {
        fornecedorDao = new FornecedorDao();
        produtoDao = new ProdutoDao();
        entradaDao = new EntradaDao();
        entradaProdutoTableModel = new EntradaProdutoTableModel();
        entradaTableModel = new EntradaTableModel();
    }

    public void chamarTelaEntradaGerenciar() {
        if (telaEntradaGerenciar == null) { // se tiver nulo chama janela normalmente
            telaEntradaGerenciar = new TelaEntradaGerenciar(this);
            TelaPrincipal.desktopPane.add(telaEntradaGerenciar);
            telaEntradaGerenciar.setVisible(true);
        } else {//se ele estiver criado
            if (telaEntradaGerenciar.isVisible()) {
                telaEntradaGerenciar.pack();//Redimensiona ao Quadro Original
            } else {
                TelaPrincipal.desktopPane.add(telaEntradaGerenciar);
                telaEntradaGerenciar.setVisible(true);
            }
        }
        carregarFornecedoresNaCombo();
        telaEntradaGerenciar.getTblProduto().setModel(entradaProdutoTableModel);
        entradaProdutoTableModel.adicionar(produtoDao.pesquisar());
        telaEntradaGerenciar.getTblEntrada().setModel(entradaTableModel);
        entradaTableModel.adicionar(entradaDao.pesquisar());
    }

    private void carregarFornecedoresNaCombo() {
        listFornecedores = fornecedorDao.pesquisar();
        DefaultComboBoxModel<Fornecedor> model = new DefaultComboBoxModel(listFornecedores.toArray());
        telaEntradaGerenciar.getCbFornecedor().setModel(model);
    }
}
