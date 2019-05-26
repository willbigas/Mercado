package br.com.mercadodonajoana.control;

import br.com.mercadodonajoana.view.TelaLogin;

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
