package br.com.mercadojoana.control;

import br.com.mercadojoana.view.TelaPrincipal;
import br.com.mercadojoana.view.TelaEntradaGerenciar;

/**
 *
 * @author William
 */
public class TelaEntradaControl {
    
    TelaEntradaGerenciar frameEntradaProduto;

    public TelaEntradaControl() {
        frameEntradaProduto = new TelaEntradaGerenciar();
        TelaPrincipal.desktopPane.add(frameEntradaProduto);
        frameEntradaProduto.setVisible(true);
    }
    
    
    
}
