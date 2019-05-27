package br.com.mercado.control;

import br.com.mercado.view.TelaPrincipal;
import br.com.mercado.view.TelaVenda;

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
