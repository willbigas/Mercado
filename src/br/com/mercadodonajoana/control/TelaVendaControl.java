package br.com.mercadodonajoana.control;

import br.com.mercadodonajoana.view.TelaPrincipal;
import br.com.mercadodonajoana.view.TelaVenda;

/**
 *
 * @author Will
 */
public class TelaVendaControl {

    TelaVenda telaVenda;

    public TelaVendaControl() {
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
    }
    
}
