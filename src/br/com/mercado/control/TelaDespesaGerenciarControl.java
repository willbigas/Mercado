/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mercado.control;

import br.com.mercado.view.TelaDespesaGerenciar;
import br.com.mercado.view.TelaPrincipal;

/**
 *
 * @author William
 */
public class TelaDespesaGerenciarControl {
    
    
    TelaDespesaGerenciar telaDespesaGerenciar;

    public TelaDespesaGerenciarControl() {
    }
    
    public void chamarTelaDespesaGerenciar() {
        if (telaDespesaGerenciar == null) { // se tiver nulo chama janela normalmente
            telaDespesaGerenciar = new TelaDespesaGerenciar(this);
            TelaPrincipal.desktopPane.add(telaDespesaGerenciar);
            telaDespesaGerenciar.setVisible(true);
        } else {//se ele estiver criado
            if (telaDespesaGerenciar.isVisible()) {
                telaDespesaGerenciar.pack();//Redimensiona ao Quadro Original
            } else {
                TelaPrincipal.desktopPane.add(telaDespesaGerenciar);
                telaDespesaGerenciar.setVisible(true);
            }
        }
    }
}
