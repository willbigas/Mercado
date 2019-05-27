package br.com.mercado.control;

import br.com.mercado.uteis.Enderecos;
import br.com.mercado.view.TelaClienteGerenciar;
import br.com.mercado.view.TelaPrincipal;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Will
 */
public class TelaClienteGerenciarControl {

    private TelaClienteGerenciar telaClienteGerenciar;

    public TelaClienteGerenciarControl() {
    }

    public void chamarTelaClienteGerenciar() {
        if (telaClienteGerenciar == null) {
            telaClienteGerenciar = new TelaClienteGerenciar(this);
            TelaPrincipal.desktopPane.add(telaClienteGerenciar);
            telaClienteGerenciar.setVisible(true);
        } else {
            if (telaClienteGerenciar.isVisible()) {
                telaClienteGerenciar.pack();
            } else {
                TelaPrincipal.desktopPane.add(telaClienteGerenciar);
                telaClienteGerenciar.setVisible(true);
            }
        }
        carregarEstadosNaComboBox();
    }
    
    public void carregarEstadosNaComboBox() {
        telaClienteGerenciar.getCbEstado().setModel(new DefaultComboBoxModel<>(Enderecos.ESTADOS_BRASILEIROS));

    }

    

}
