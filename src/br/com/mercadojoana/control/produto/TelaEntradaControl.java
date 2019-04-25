package br.com.mercadojoana.control.produto;

import br.com.mercadojoana.view.TelaPrincipal;
import br.com.mercadojoana.view.produto.TelaEntradaProduto;

/**
 *
 * @author William
 */
public class TelaEntradaControl {
    
    TelaEntradaProduto frameEntradaProduto;

    public TelaEntradaControl() {
        frameEntradaProduto = new TelaEntradaProduto();
        TelaPrincipal.desktopPane.add(frameEntradaProduto);
        frameEntradaProduto.setVisible(true);
    }
    
    
    
}
