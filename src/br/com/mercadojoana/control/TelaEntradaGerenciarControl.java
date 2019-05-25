package br.com.mercadojoana.control;

import br.com.mercadojoana.view.TelaEntradaGerenciar;
import br.com.mercadojoana.view.TelaPrincipal;

/**
 *
 * @author William
 */
public class TelaEntradaGerenciarControl {
    
    TelaEntradaGerenciar telaEntradaGerenciar = null;

    public TelaEntradaGerenciarControl() {
        
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
    }
}
