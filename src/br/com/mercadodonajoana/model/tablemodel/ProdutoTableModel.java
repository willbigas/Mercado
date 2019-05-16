/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mercadodonajoana.model.tablemodel;

import br.com.mercadodonajoana.model.Produto;
import br.com.mercadojoana.interfaces.AcoesTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author William
 */
public class ProdutoTableModel extends AbstractTableModel implements AcoesTableModel<Produto>{

    private static final int CODIGO = 0;
    private static final int NOME = 1;
    private static final int EAN13 = 2;
    private static final int VALOR = 3;

    private List<Produto> linhas;
    private String[] COLUNAS = {"Código", "Nome", "Ean13", "Valor"};

    public ProdutoTableModel() {
        linhas = new ArrayList<>();
    }

    public ProdutoTableModel(List<Produto> listProdutos) {
        linhas = new ArrayList<>(listProdutos);
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return COLUNAS.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return COLUNAS[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case CODIGO:
                return Integer.class;
            case NOME:
                return String.class;
            case VALOR:
                return Double.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Produto produto = linhas.get(linha);
        switch (coluna) {
            case CODIGO:
                return produto.getId();
            case NOME:
                return produto.getNome();
            case VALOR:
                return produto.getValor();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        Produto produto = linhas.get(linha);
        switch (coluna) {
            case CODIGO:
                produto.setId(Integer.valueOf((String) valor));
                break;
            case NOME:
                produto.setNome((String) valor);
                break;
            case VALOR:
                produto.setValor(Double.valueOf((String) valor));
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
        this.fireTableCellUpdated(linha, coluna); // Atualiza Celula da tabela

    }

    public Produto pegaObjeto(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    public void adicionar(Produto produto) {
        linhas.add(produto);
        int ultimoIndice = getRowCount() - 1; // linhas -1
        fireTableRowsInserted(ultimoIndice, ultimoIndice); // atualiza insert
    }

    public void adicionar(List<Produto> produtos) {
        int indice = getRowCount();
        linhas.addAll(produtos);
        fireTableRowsInserted(indice, indice + produtos.size());
        fireTableDataChanged();
    }

    public void remover(int indiceLinha) {
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha); // atualiza delete
    }

    public void remover(int linhaInicio, int linhaFim) {

        for (int i = linhaInicio; i <= linhaFim; i++) {
            linhas.remove(i);
            fireTableRowsDeleted(linhaInicio, linhaFim); // atualiza delete
        }

    }

    public void atualizar(int indiceLinha, Produto p) {
        linhas.set(indiceLinha, p);
        fireTableRowsUpdated(indiceLinha, indiceLinha); // atualiza delete
    }

    public void limpar() {
        linhas.clear();
        fireTableDataChanged(); // atualiza toda tabela.
    }

}