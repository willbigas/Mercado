package br.com.mercadojoana.control;

import br.com.mercadojoana.view.TelaPrincipal;
import br.com.mercadojoana.view.TelaFuncionarioGerenciar;

/**
 *
 * @author William
 */
public class TelaFuncionarioGerenciarControl {

    TelaFuncionarioGerenciar funcionarioGerenciar;
    
    public TelaFuncionarioGerenciarControl() {
    }
    
    public void chamarTelaFuncionarioGerenciar() {
        if (funcionarioGerenciar == null) { // se tiver nulo chama janela normalmente
            funcionarioGerenciar = new TelaFuncionarioGerenciar(this);
          TelaPrincipal.desktopPane.add(funcionarioGerenciar);
            funcionarioGerenciar.setVisible(true);
        } else {//se ele estiver criado
            if (funcionarioGerenciar.isVisible()) {
                funcionarioGerenciar.pack();//Redimensiona ao Quadro Original
            } else {
                TelaPrincipal.desktopPane.add(funcionarioGerenciar);
                funcionarioGerenciar.setVisible(true);
            }
        }
    }

    
    
}
