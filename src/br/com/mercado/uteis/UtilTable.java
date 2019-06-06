/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mercado.uteis;

import javax.swing.JTable;

/**
 *
 * @author agostinho.junior
 */
public class UtilTable {

    /**
     * Redefinir largura da tabela
     *
     * @param tableModel
     * @param coluna
     * @param largura
     */
    public static void redimensionar(JTable tableModel, Integer coluna, Integer largura) {
        autoResizeOff(tableModel);
        tableModel.getColumnModel().getColumn(coluna).setPreferredWidth(largura);
    }

    /**
     * Desligando o auto resize
     *
     * @param tableModel
     */
    public static void autoResizeOff(JTable tableModel) {
        tableModel.setAutoResizeMode(tableModel.AUTO_RESIZE_OFF);
    }
}
