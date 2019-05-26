package br.com.mercadodonajoana.model.tablemodel;

import br.com.mercadodonajoana.model.Entrada;
import br.com.mercadodonajoana.interfaces.AcoesTableModel;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author william.mauro
 */
public class EntradaTableModel extends AbstractTableModel implements AcoesTableModel<Entrada>{
    
    private static final int CODIGO = 0;
    private static final int FORNECEDOR = 1;
    private static final int DATA_ENTRADA = 2;

    private List<Entrada> linhas;
    private String[] COLUNAS = {"Código", "Fornecedor", "DataEntrada"};

    public EntradaTableModel() {
        linhas = new ArrayList<>();
    }

    public EntradaTableModel(List<Entrada> listEntradas) {
        linhas = new ArrayList<>(listEntradas);
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
            case FORNECEDOR:
                return String.class;
            case DATA_ENTRADA:
                return Date.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Entrada entrada = linhas.get(linha);
        switch (coluna) {
            case CODIGO:
                return entrada.getId();
            case FORNECEDOR:
                return entrada.getFornecedor().getNome();
            case DATA_ENTRADA:
                return entrada.getDataEntrada();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        Entrada entrada = linhas.get(linha);
        switch (coluna) {
            case CODIGO:
                entrada.setId(Integer.valueOf((String) valor));
                break;
            case FORNECEDOR:
                entrada.getFornecedor().setNome((String) valor);
                break;
            case DATA_ENTRADA:
                entrada.setDataEntrada((LocalDateTime) valor);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
        this.fireTableCellUpdated(linha, coluna); // Atualiza Celula da tabela

    }

    @Override
    public Entrada pegaObjeto(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    @Override
    public void adicionar(Entrada entrada) {
        linhas.add(entrada);
        int ultimoIndice = getRowCount() - 1; // linhas -1
        fireTableRowsInserted(ultimoIndice, ultimoIndice); // atualiza insert
    }

    @Override
    public void adicionar(List<Entrada> entradas) {
        int indice = getRowCount();
        linhas.addAll(entradas);
        fireTableRowsInserted(indice, indice + entradas.size());
        fireTableDataChanged();
    }

    @Override
    public void remover(int indiceLinha) {
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha); // atualiza delete
    }

    @Override
    public void remover(int linhaInicio, int linhaFim) {
        for (int i = linhaInicio; i <= linhaFim; i++) {
            linhas.remove(i);
            fireTableRowsDeleted(linhaInicio, linhaFim); // atualiza delete
        }
    }

    @Override
    public void atualizar(int indiceLinha, Entrada entrada) {
        linhas.set(indiceLinha, entrada);
        fireTableRowsUpdated(indiceLinha, indiceLinha); // atualiza delete
    }

    @Override
    public void limpar() {
        linhas.clear();
        fireTableDataChanged(); // atualiza toda tabela.
    }
    
}
