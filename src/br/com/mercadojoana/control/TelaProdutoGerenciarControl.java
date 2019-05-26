package br.com.mercadojoana.control;

import br.com.mercadojoana.view.TelaPrincipal;
import br.com.mercadojoana.view.TelaProdutoGerenciar;

/**
 *
 * @author William
 */
public class TelaProdutoGerenciarControl {

    TelaProdutoGerenciar telaProdutoGerenciar;

    public TelaProdutoGerenciarControl() {

    }
    
     public void chamarTelaProdutoGerenciar() {
        if (telaProdutoGerenciar == null) { // se tiver nulo chama janela normalmente
            telaProdutoGerenciar = new TelaProdutoGerenciar(this);
          TelaPrincipal.desktopPane.add(telaProdutoGerenciar);
            telaProdutoGerenciar.setVisible(true);
        } else {//se ele estiver criado
            if (telaProdutoGerenciar.isVisible()) {
                telaProdutoGerenciar.pack();//Redimensiona ao Quadro Original
            } else {
                TelaPrincipal.desktopPane.add(telaProdutoGerenciar);
                telaProdutoGerenciar.setVisible(true);
            }
        }
    }

}
