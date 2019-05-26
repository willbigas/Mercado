package br.com.mercadodonajoana.control;

import br.com.mercadodonajoana.dao.FornecedorDao;
import br.com.mercadodonajoana.model.Fornecedor;
import br.com.mercadodonajoana.view.TelaEntradaGerenciar;
import br.com.mercadodonajoana.view.TelaPrincipal;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author William
 */
public class TelaEntradaGerenciarControl {

    TelaEntradaGerenciar telaEntradaGerenciar = null;
    private List<Fornecedor> listFornecedores;
    private FornecedorDao fornecedorDao;

    public TelaEntradaGerenciarControl() {
        fornecedorDao = new FornecedorDao();
        carregarFornecedores();
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
    }

    private void carregarFornecedores() {
        listFornecedores = fornecedorDao.pesquisar();
        DefaultComboBoxModel<Fornecedor> model = new DefaultComboBoxModel(listFornecedores.toArray());
        telaEntradaGerenciar.getCbFornecedor().setModel(model);
    }
}
