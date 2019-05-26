package br.com.mercadodonajoana.control;

import br.com.mercadodonajoana.dao.CategoriaDao;
import br.com.mercadodonajoana.dao.FornecedorDao;
import br.com.mercadodonajoana.model.Categoria;
import br.com.mercadodonajoana.model.Fornecedor;
import br.com.mercadodonajoana.view.TelaPrincipal;
import br.com.mercadodonajoana.view.TelaProdutoGerenciar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author William
 */
public class TelaProdutoGerenciarControl {

    TelaProdutoGerenciar telaProdutoGerenciar;
    private List<Fornecedor> listFornecedores;
    private List<Categoria> listCategorias;
    private FornecedorDao fornecedorDao;
    private CategoriaDao categoriaDao;

    public TelaProdutoGerenciarControl() {
        fornecedorDao = new FornecedorDao();
        categoriaDao = new CategoriaDao();
        carregarFornecedoresNaCombo();
        carregarCategoriasNaCombo();
    }

    public void chamarTelaProdutoGerenciar() {
        if (telaProdutoGerenciar == null) { // se tiver nulo chama janela normalmente
            telaProdutoGerenciar = new TelaProdutoGerenciar(this);
            TelaPrincipal.desktopPane.add(telaProdutoGerenciar);
            telaProdutoGerenciar.setVisible(true);
        } else {//se ele estiver criado
            if (telaProdutoGerenciar.isVisible()) {
                telaProdutoGerenciar.pack();//Redimensiona ao Quadro Original
            } else {
                TelaPrincipal.desktopPane.add(telaProdutoGerenciar);
                telaProdutoGerenciar.setVisible(true);
            }
        }
    }

    private void carregarFornecedoresNaCombo() {
        listFornecedores = fornecedorDao.pesquisar();
        DefaultComboBoxModel<Fornecedor> model = new DefaultComboBoxModel(listFornecedores.toArray());
        telaProdutoGerenciar.getCbFornecedor().setModel(model);
    }

    private void carregarCategoriasNaCombo() {
        listCategorias = categoriaDao.pesquisar();
        DefaultComboBoxModel<Categoria> model = new DefaultComboBoxModel(listCategorias.toArray());
        telaProdutoGerenciar.getCbCategoria().setModel(model);
    }
}
