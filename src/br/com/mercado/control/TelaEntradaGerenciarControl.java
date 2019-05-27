package br.com.mercado.control;

import br.com.mercado.dao.FornecedorDao;
import br.com.mercado.model.Fornecedor;
import br.com.mercado.view.TelaEntradaGerenciar;
import br.com.mercado.view.TelaPrincipal;
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
    }

    private void carregarFornecedoresNaCombo() {
        listFornecedores = fornecedorDao.pesquisar();
        DefaultComboBoxModel<Fornecedor> model = new DefaultComboBoxModel(listFornecedores.toArray());
        telaEntradaGerenciar.getCbFornecedor().setModel(model);
    }
}
