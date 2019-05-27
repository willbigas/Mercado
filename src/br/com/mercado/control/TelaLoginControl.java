package br.com.mercado.control;

import br.com.mercado.dao.UsuarioDao;
import br.com.mercado.model.Usuario;
import br.com.mercado.uteis.Mensagem;
import br.com.mercado.uteis.Texto;
import br.com.mercado.view.TelaLogin;

/**
 *
 * @author William
 */
public class TelaLoginControl {
    
    TelaLogin telaLogin; 
    TelaPrincipalControl telaPrincipalControl;
    TelaPrincipalCaixaControl telaPrincipalCaixaControl;
    UsuarioDao funcionarioDao;
    Usuario funcionario;
    
    public static final int ADMINISTRADOR = 1;
    public static final int CAIXA = 2;

    public TelaLoginControl() {
        funcionarioDao = new UsuarioDao();
    }
    
    public void chamarTelaLoginAction() {
        telaLogin = new TelaLogin(this);
        telaLogin.setLocationRelativeTo(null);
        telaLogin.setVisible(true);
    }

    private void chamarTelaPrincipal() {
        telaPrincipalControl = new TelaPrincipalControl();
        telaPrincipalControl.chamarTelaPrincipal();
    }
    private void chamarTelaPrincipalCaixa() {
        telaPrincipalCaixaControl = new TelaPrincipalCaixaControl();
        telaPrincipalCaixaControl.chamarTelaPrincipalCaixa();
    }
    
    public void acessarTelaPrincipalAction() {
        funcionario = funcionarioDao.pesquisarLogin(telaLogin.getTfLogin().getText());
        if (funcionario == null) {
            Mensagem.info(Texto.ERRO_USUARIO);
            return;
        }
        /**
         * Get password retorna Char[] String então deve se instanciar uma nova string com os caracteres.
         */
        if (!funcionario.getSenha().equals(new String(telaLogin.getTfSenha().getPassword()))) { 
            Mensagem.atencao(Texto.SENHA_USUARIO);
            return;
        }
        
        if (funcionario.getTipoUsuario().getTipoPermissao() == ADMINISTRADOR) {
            chamarTelaPrincipal();
        } 
        
        if (funcionario.getTipoUsuario().getTipoPermissao() == CAIXA) {
            chamarTelaPrincipalCaixa();
        }
        telaLogin.dispose();
    }
    
    
    
    
}
