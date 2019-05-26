package br.com.mercadojoana.control;

import br.com.mercadojoana.view.TelaFornecedorGerenciar;
import br.com.mercadojoana.view.TelaPrincipal;

/**
 *
 * @author Will
 */
public class TelaFornecedorGerenciarControl {

    TelaFornecedorGerenciar telaFornecedorGerenciar;

    public TelaFornecedorGerenciarControl() {
    }

    public void chamarTelaFornecedorGerenciar() {
        if (telaFornecedorGerenciar == null) { // se tiver nulo chama janela normalmente
            telaFornecedorGerenciar = new TelaFornecedorGerenciar(this);
            TelaPrincipal.desktopPane.add(telaFornecedorGerenciar);
            telaFornecedorGerenciar.setVisible(true);
        } else {//se ele estiver criado
            if (telaFornecedorGerenciar.isVisible()) {
                telaFornecedorGerenciar.pack();//Redimensiona ao Quadro Original
            } else {
                TelaPrincipal.desktopPane.add(telaFornecedorGerenciar);
                telaFornecedorGerenciar.setVisible(true);
            }
        }
    }

}
