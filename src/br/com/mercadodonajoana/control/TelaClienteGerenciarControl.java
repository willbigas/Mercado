package br.com.mercadodonajoana.control;

import br.com.mercadodonajoana.uteis.Enderecos;
import br.com.mercadodonajoana.view.TelaClienteGerenciar;
import br.com.mercadodonajoana.view.TelaPrincipal;
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
