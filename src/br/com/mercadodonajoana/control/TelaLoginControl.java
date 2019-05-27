package br.com.mercadodonajoana.control;

import br.com.mercadodonajoana.view.TelaLogin;

/**
 *
 * @author William
 */
public class TelaLoginControl {
    
    TelaLogin telaLogin; 
    TelaPrincipalControl telaPrincipalControl;
    TelaPrincipalCaixaControl telaPrincipalCaixaControl;

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
    public void chamarTelaPrincipalCaixaAction() {
        telaPrincipalCaixaControl = new TelaPrincipalCaixaControl();
        telaPrincipalCaixaControl.chamarTelaPrincipalCaixa();
    }
    
    public void verificarPemissoesDeAcessoAction() {
        
    }
    
    
    
    
}
