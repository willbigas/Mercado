package br.com.mercadojoana.control;

import br.com.mercadojoana.view.TelaPrincipal;
import br.com.mercadojoana.view.TelaProdutoGerenciar;

/**
 *
 * @author William
 */
public class TelaGerenciarProdutoControl {
    
    TelaProdutoGerenciar  frameGerenciarProduto;

    public TelaGerenciarProdutoControl() {
        frameGerenciarProduto = new TelaProdutoGerenciar();
        TelaPrincipal.desktopPane.add(frameGerenciarProduto);
        frameGerenciarProduto.setVisible(true);
    }
    
    
    
    
}
