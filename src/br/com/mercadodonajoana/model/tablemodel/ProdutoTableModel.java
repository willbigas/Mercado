
package br.com.mercadodonajoana.model.tablemodel;

import br.com.mercadodonajoana.model.Produto;
import br.com.mercadodonajoana.interfaces.AcoesTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author William
 */
public class ProdutoTableModel extends AbstractTableModel implements AcoesTableModel<Produto> {

    private static final int CODIGO = 0;
    private static final int NOME = 1;
    private static final int EAN13 = 2;
    private static final int QUANTIDADE = 3;
    private static final int VALOR = 4;
    private static final int CATEGORIA = 5;

    private List<Produto> linhas;
    private String[] COLUNAS = {"Código", "Nome", "Ean13", "Quantidade", "Valor", "Categoria"};

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
            case EAN13:
                return String.class;
            case QUANTIDADE:
                return Integer.class;
            case VALOR:
                return Double.class;
            case CATEGORIA:
                return String.class;
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
            case EAN13:
                return produto.getCodBarras();
            case QUANTIDADE:
                return produto.getQuantidade();
            case VALOR:
                return produto.getValor();
            case CATEGORIA:
                return produto.getCategoria().getNome();
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
            case EAN13:
                produto.setCodBarras((Integer) valor);
                break;
            case QUANTIDADE:
                produto.setQuantidade((Integer) valor);
                break;
            case VALOR:
                produto.setValor(Double.valueOf((String) valor));
                break;
            case CATEGORIA:
                produto.getCategoria().setNome((String) valor);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
        this.fireTableCellUpdated(linha, coluna); // Atualiza Celula da tabela

    }

    @Override
    public Produto pegaObjeto(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    @Override
    public void adicionar(Produto produto) {
        linhas.add(produto);
        int ultimoIndice = getRowCount() - 1; // linhas -1
        fireTableRowsInserted(ultimoIndice, ultimoIndice); // atualiza insert
    }

    @Override
    public void adicionar(List<Produto> produtos) {
        int indice = getRowCount();
        linhas.addAll(produtos);
        fireTableRowsInserted(indice, indice + produtos.size());
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
    public void atualizar(int indiceLinha, Produto p) {
        linhas.set(indiceLinha, p);
        fireTableRowsUpdated(indiceLinha, indiceLinha); // atualiza delete
    }

    @Override
    public void limpar() {
        linhas.clear();
        fireTableDataChanged(); // atualiza toda tabela.
    }

}
