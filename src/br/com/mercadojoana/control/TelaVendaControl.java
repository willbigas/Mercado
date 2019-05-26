package br.com.mercadojoana.control;

import br.com.mercadojoana.view.TelaPrincipal;
import br.com.mercadojoana.view.TelaVenda;

/**
 *
 * @author Will
 */
public class TelaVendaControl {

    TelaVenda telaVenda;

    public TelaVendaControl() {
    }

    public void chamarTelaVenda() {
        if (telaVenda == null) { // se tiver nulo chama janela normalmente
            telaVenda = new TelaVenda(this);
            TelaPrincipal.desktopPane.add(telaVenda);
            telaVenda.setVisible(true);
        } else {//se ele estiver criado
            if (telaVenda.isVisible()) {
                telaVenda.pack();//Redimensiona ao Quadro Original
            } else {
                TelaPrincipal.desktopPane.add(telaVenda);
                telaVenda.setVisible(true);
            }
        }
    }
    
}
