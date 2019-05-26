package br.com.mercadojoana.control;

import br.com.mercadojoana.view.TelaLogin;

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
