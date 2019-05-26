package br.com.mercadojoana.control;

import br.com.mercadojoana.view.TelaCategoriaGerenciar;
import br.com.mercadojoana.view.TelaPrincipal;

/**
 *
 * @author Will
 */
public class TelaCategoriaGerenciarControl {
    
    TelaCategoriaGerenciar telaCategoriaGerenciar;

    public TelaCategoriaGerenciarControl() {
    }
    
    
    public void chamarTelaCategoriaGerenciar() {
        if (telaCategoriaGerenciar == null) { // se tiver nulo chama janela normalmente
            telaCategoriaGerenciar = new TelaCategoriaGerenciar(this);
            TelaPrincipal.desktopPane.add(telaCategoriaGerenciar);
            telaCategoriaGerenciar.setVisible(true);
        } else {//se ele estiver criado
            if (telaCategoriaGerenciar.isVisible()) {
                telaCategoriaGerenciar.pack();//Redimensiona ao Quadro Original
            } else {
                TelaPrincipal.desktopPane.add(telaCategoriaGerenciar);
                telaCategoriaGerenciar.setVisible(true);
            }
        }
    }
    
}
