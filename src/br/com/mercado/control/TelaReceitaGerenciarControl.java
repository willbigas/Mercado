/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mercado.control;

import br.com.mercado.view.TelaPrincipal;
import br.com.mercado.view.TelaReceitaGerenciar;

/**
 *
 * @author William
 */
public class TelaReceitaGerenciarControl {
    
    
    TelaReceitaGerenciar telaReceitaGerenciar;

    public TelaReceitaGerenciarControl() {
    }
    
    
    public void chamarTelaReceitaGerenciar() {
        if (telaReceitaGerenciar == null) { // se tiver nulo chama janela normalmente
            telaReceitaGerenciar = new TelaReceitaGerenciar(this);
            TelaPrincipal.desktopPane.add(telaReceitaGerenciar);
            telaReceitaGerenciar.setVisible(true);
        } else {//se ele estiver criado
            if (telaReceitaGerenciar.isVisible()) {
                telaReceitaGerenciar.pack();//Redimensiona ao Quadro Original
            } else {
                TelaPrincipal.desktopPane.add(telaReceitaGerenciar);
                telaReceitaGerenciar.setVisible(true);
            }
        }
    }
}
