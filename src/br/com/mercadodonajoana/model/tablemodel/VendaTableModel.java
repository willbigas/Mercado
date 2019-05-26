package br.com.mercadodonajoana.model.tablemodel;

import br.com.mercadodonajoana.model.Venda;
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
public class VendaTableModel extends AbstractTableModel implements AcoesTableModel<Venda> {

    private static final int CODIGO = 0;
    private static final int CLIENTE = 1;
    private static final int FUNCIONARIO = 2;
    private static final int DATA_VENDA = 3;

    private List<Venda> linhas;
    private String[] COLUNAS = {"Código", "Cliente", "Funcionário", "DataVenda"};

    public VendaTableModel() {
        linhas = new ArrayList<>();
    }

    public VendaTableModel(List<Venda> listVendas) {
        linhas = new ArrayList<>(listVendas);
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
            case CLIENTE:
                return String.class;
            case FUNCIONARIO:
                return String.class;
            case DATA_VENDA:
                return Date.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Venda venda = linhas.get(linha);
        switch (coluna) {
            case CODIGO:
                return venda.getId();
            case CLIENTE:
                return venda.getCliente().getNome();
            case FUNCIONARIO:
                return venda.getFuncionario().getNome();
            case DATA_VENDA:
                return venda.getDataVenda();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        Venda venda = linhas.get(linha);
        switch (coluna) {
            case CODIGO:
                venda.setId(Integer.valueOf((String) valor));
                break;
            case CLIENTE:
                venda.getCliente().setNome((String) valor);
                break;
            case FUNCIONARIO:
                venda.getFuncionario().setNome((String) valor);
                break;
            case DATA_VENDA:
                venda.setDataVenda((LocalDateTime) valor);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
        this.fireTableCellUpdated(linha, coluna); // Atualiza Celula da tabela

    }

    @Override
    public Venda pegaObjeto(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    @Override
    public void adicionar(Venda venda) {
        linhas.add(venda);
        int ultimoIndice = getRowCount() - 1; // linhas -1
        fireTableRowsInserted(ultimoIndice, ultimoIndice); // atualiza insert
    }

    @Override
    public void adicionar(List<Venda> vendas) {
        int indice = getRowCount();
        linhas.addAll(vendas);
        fireTableRowsInserted(indice, indice + vendas.size());
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
    public void atualizar(int indiceLinha, Venda venda) {
        linhas.set(indiceLinha, venda);
        fireTableRowsUpdated(indiceLinha, indiceLinha); // atualiza delete
    }

    @Override
    public void limpar() {
        linhas.clear();
        fireTableDataChanged(); // atualiza toda tabela.
    }

}
