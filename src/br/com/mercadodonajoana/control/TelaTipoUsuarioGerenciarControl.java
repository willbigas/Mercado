package br.com.mercadodonajoana.control;

import br.com.mercadodonajoana.view.TelaPrincipal;
import br.com.mercadodonajoana.view.TelaTipoUsuarioGerenciar;

/**
 *
 * @author Will
 */
public class TelaTipoUsuarioGerenciarControl {
    
    TelaTipoUsuarioGerenciar telaTipoUsuarioGerenciar;

    public TelaTipoUsuarioGerenciarControl() {
    }
    
    public void chamarTelaTipoUsuarioGerenciar() {
        if (telaTipoUsuarioGerenciar == null) { // se tiver nulo chama janela normalmente
            telaTipoUsuarioGerenciar = new TelaTipoUsuarioGerenciar(this);
            TelaPrincipal.desktopPane.add(telaTipoUsuarioGerenciar);
            telaTipoUsuarioGerenciar.setVisible(true);
        } else {//se ele estiver criado
            if (telaTipoUsuarioGerenciar.isVisible()) {
                telaTipoUsuarioGerenciar.pack();//Redimensiona ao Quadro Original
            } else {
                TelaPrincipal.desktopPane.add(telaTipoUsuarioGerenciar);
                telaTipoUsuarioGerenciar.setVisible(true);
            }
        }
    }
    
}
