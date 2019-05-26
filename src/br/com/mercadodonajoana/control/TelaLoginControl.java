package br.com.mercadodonajoana.control;

import br.com.mercadodonajoana.view.TelaLogin;
import br.com.mercadodonajoana.view.TelaPrincipal;

/**
 *
 * @author William
 */
public class TelaLoginControl {
    
    TelaLogin telaLogin; 
    TelaPrincipalControl telaPrincipalControl;

    public TelaLoginControl() {
    }
    
    
    public void chamarTelaLoginAction() {
        telaLogin = new TelaLogin(this);
        telaLogin.setLocationRelativeTo(null);
        telaLogin.setVisible(true);
    }

    public void chamarTelaPrincipalAction() {
        telaPrincipalControl = new TelaPrincipalControl();
        telaPrincipalControl.chamarTelaPrincipal();
    }
    
    
    
    
}
