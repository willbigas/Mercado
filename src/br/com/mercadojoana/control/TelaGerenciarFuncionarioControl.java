package br.com.mercadojoana.control;

import br.com.mercadojoana.view.TelaPrincipal;
import br.com.mercadojoana.view.TelaFuncionarioGerenciar;

/**
 *
 * @author William
 */
public class TelaGerenciarFuncionarioControl {

    TelaFuncionarioGerenciar frameGerenciarFuncionario;
    
    public TelaGerenciarFuncionarioControl() {
        frameGerenciarFuncionario = new TelaFuncionarioGerenciar();
        TelaPrincipal.desktopPane.add(frameGerenciarFuncionario);
        frameGerenciarFuncionario.setVisible(true);
        
    }

    
    
}
