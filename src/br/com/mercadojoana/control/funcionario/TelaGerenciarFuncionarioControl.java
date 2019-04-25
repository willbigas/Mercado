package br.com.mercadojoana.control.funcionario;

import br.com.mercadojoana.view.TelaPrincipal;
import br.com.mercadojoana.view.funcionario.TelaGerenciarFuncionario;

/**
 *
 * @author William
 */
public class TelaGerenciarFuncionarioControl {

    TelaGerenciarFuncionario frameGerenciarFuncionario;
    
    public TelaGerenciarFuncionarioControl() {
        frameGerenciarFuncionario = new TelaGerenciarFuncionario();
        TelaPrincipal.desktopPane.add(frameGerenciarFuncionario);
        frameGerenciarFuncionario.setVisible(true);
        
    }

    
    
}
