package br.com.mercadodonajoana.control;

import br.com.mercadodonajoana.dao.CategoriaDao;
import br.com.mercadodonajoana.dao.FornecedorDao;
import br.com.mercadodonajoana.dao.FuncionarioDao;
import br.com.mercadodonajoana.dao.ProdutoDao;
import br.com.mercadodonajoana.model.Categoria;
import br.com.mercadodonajoana.model.Fornecedor;
import br.com.mercadodonajoana.model.Funcionario;
import br.com.mercadodonajoana.model.Produto;
import br.com.mercadodonajoana.model.tablemodel.ProdutoTableModel;
import br.com.mercadodonajoana.uteis.Mensagem;
import br.com.mercadodonajoana.uteis.Texto;
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
    List<Fornecedor> listFornecedor;
    List<Categoria> listCategorias;
    ProdutoTableModel tableModelProduto;
    FornecedorDao fornecedorDao;
    CategoriaDao categoriaDao;
    ProdutoDao produtoDao;
    Produto produto;

    public TelaProdutoGerenciarControl() {
        fornecedorDao = new FornecedorDao();
        categoriaDao = new CategoriaDao();
        produtoDao = new ProdutoDao();
        tableModelProduto = new ProdutoTableModel();
        tableModelProduto.adicionar(produtoDao.pesquisar());
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
        telaProdutoGerenciar.getTblProduto().setModel(tableModelProduto);
        carregarFornecedoresNaCombo();
        carregarCategoriasNaCombo();
    }

    private void carregarFornecedoresNaCombo() {
        listFornecedor = fornecedorDao.pesquisar();
        System.out.println(listFornecedor);
        DefaultComboBoxModel<Fornecedor> model = new DefaultComboBoxModel(listFornecedor.toArray());
        TelaProdutoGerenciar.cbFornecedor.setModel(model);
    }

    private void carregarCategoriasNaCombo() {
        listCategorias = categoriaDao.pesquisar();
        DefaultComboBoxModel<Categoria> model = new DefaultComboBoxModel(listCategorias.toArray());
        TelaProdutoGerenciar.cbCategoria.setModel(model);
    }

    public void cadastrarProdutoAction() {
        produto = new Produto();
        produto.setCodBarras(Integer.valueOf(telaProdutoGerenciar.getTfCodigoBarras().getText()));
        produto.setNome(telaProdutoGerenciar.getTfNome().getText());
        produto.setQuantidade(Integer.valueOf(telaProdutoGerenciar.getTfQuantidade().getText()));
        produto.setValor(Double.valueOf(telaProdutoGerenciar.getTfQuantidade().getText()));
        produto.setCategoria((Categoria) telaProdutoGerenciar.getCbCategoria().getSelectedItem());
        produto.setFornecedor((Fornecedor) telaProdutoGerenciar.getCbFornecedor().getSelectedItem());
        if (telaProdutoGerenciar.getCheckAtivo().isSelected()) {
            produto.setAtivo(true);
        } else {
            produto.setAtivo(false);
        }
        Integer idInserido = produtoDao.inserir(produto);
        if (idInserido != 0) {
            produto.setId(idInserido);
            tableModelProduto.adicionar(produto);
            Mensagem.info(Texto.SUCESSO_CADASTRAR);
        } else {
            Mensagem.info(Texto.ERRO_CADASTRAR);
        }
        produto = null;
    }
}
