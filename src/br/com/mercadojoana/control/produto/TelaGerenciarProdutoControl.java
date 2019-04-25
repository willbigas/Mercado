package br.com.mercadojoana.control.produto;

import br.com.mercadojoana.view.TelaPrincipal;
import br.com.mercadojoana.view.produto.TelaGerenciarProduto;

/**
 *
 * @author William
 */
public class TelaGerenciarProdutoControl {
    
    TelaGerenciarProduto  frameGerenciarProduto;

    public TelaGerenciarProdutoControl() {
        frameGerenciarProduto = new TelaGerenciarProduto();
        TelaPrincipal.desktopPane.add(frameGerenciarProduto);
        frameGerenciarProduto.setVisible(true);
    }
    
    
    
    
}
