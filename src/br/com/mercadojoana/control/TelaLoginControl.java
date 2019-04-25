package br.com.mercadojoana.control;

import br.com.mercadojoana.view.TelaLogin;

/**
 *
 * @author William
 */
public class TelaLoginControl {
    
    TelaLogin frameLogin;   

    public TelaLoginControl() {
        frameLogin = new TelaLogin();
        frameLogin.setLocationRelativeTo(null);
        frameLogin.setVisible(true);
    }
    
    
}
