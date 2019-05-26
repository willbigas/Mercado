package br.com.mercadojoana.control;

import br.com.mercadojoana.view.TelaClienteGerenciar;
import br.com.mercadojoana.view.TelaPrincipal;

/**
 *
 * @author Will
 */
public class TelaClienteGerenciarControl {

    private TelaClienteGerenciar telaClienteGerenciar;

    public TelaClienteGerenciarControl() {
    }

    public void chamarTelaClienteGerenciar() {
        if (telaClienteGerenciar == null) { // se tiver nulo chama janela normalmente
            telaClienteGerenciar = new TelaClienteGerenciar(this);
            TelaPrincipal.desktopPane.add(telaClienteGerenciar);
            telaClienteGerenciar.setVisible(true);
        } else {//se ele estiver criado
            if (telaClienteGerenciar.isVisible()) {
                telaClienteGerenciar.pack();//Redimensiona ao Quadro Original
            } else {
                TelaPrincipal.desktopPane.add(telaClienteGerenciar);
                telaClienteGerenciar.setVisible(true);
            }
        }
    }

}
