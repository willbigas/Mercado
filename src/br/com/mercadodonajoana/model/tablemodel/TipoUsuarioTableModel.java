package br.com.mercadodonajoana.model.tablemodel;

import br.com.mercadodonajoana.model.TipoUsuario;
import br.com.mercadodonajoana.interfaces.AcoesTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
// *
// * @author Will
// */
//public class TipoUsuarioTableModel extends AbstractTableModel implements AcoesTableModel<TipoUsuario> {
    
//     private static final int CODIGO = 0;
//    private static final int NOME = 1;
//    private static final int PERMISSAO = 2;
//    private static final int ATIVO = 3;
//
//    private List<TipoUsuario> linhas;
//    private String[] COLUNAS = {"Código", "Nome", "Permissão", "Ativo"};
//
//    public TipoUsuarioTableModel() {
//        linhas = new ArrayList<>();
//    }
//
//    public TipoUsuarioTableModel(List<TipoUsuario> listTipoUsuarios) {
//        linhas = new ArrayList<>(listTipoUsuarios);
//    }
//
//    @Override
//    public int getRowCount() {
//        return linhas.size();
//    }
//
//    @Override
//    public int getColumnCount() {
//        return COLUNAS.length;
//    }
//
//    @Override
//    public String getColumnName(int columnIndex) {
//        return COLUNAS[columnIndex];
//    }
//
//    @Override
//    public Class<?> getColumnClass(int columnIndex) {
//        switch (columnIndex) {
//            case CODIGO:
//                return Integer.class;
//            case NOME:
//                return String.class;
//            case ATIVO:
//                return String.class;
//            default:
//                throw new IndexOutOfBoundsException("columnIndex out of bounds");
//        }
//    }
//
//    @Override
//    public Object getValueAt(int linha, int coluna) {
//        TipoUsuario tipoUsuario = linhas.get(linha);
//        switch (coluna) {
//            case CODIGO:
//                return tipoUsuario.getId();
//            case NOME:
//                return tipoUsuario.getNome();
//            case PERMISSAO:
////                return tipoUsuario.get();
//            case ATIVO:
//                if (tipoUsuario.getAtivo() == true) {
//                    return "Ativado";
//                } else {
//                    return "Desativado";
//                }
//            default:
//                throw new IndexOutOfBoundsException("columnIndex out of bounds");
//        }
//    }
//
//    @Override
//    public void setValueAt(Object valor, int linha, int coluna) {
//        Categoria categoria = linhas.get(linha);
//        switch (coluna) {
//            case CODIGO:
//                categoria.setId(Integer.valueOf((String) valor));
//                break;
//            case NOME:
//                categoria.setNome((String) valor);
//                break;
//            case ATIVO:
//                if (valor.equals("Ativado")) {
//                    categoria.setAtivo(true);
//                } else {
//                    categoria.setAtivo(false);
//                };
//                break;
//            default:
//                throw new IndexOutOfBoundsException("columnIndex out of bounds");
//
//        }
//        this.fireTableCellUpdated(linha, coluna); // Atualiza Celula da tabela
//
//    }
//
//    @Override
//    public Categoria pegaObjeto(int indiceLinha) {
//        return linhas.get(indiceLinha);
//    }
//
//    @Override
//    public void adicionar(Categoria categoria) {
//        linhas.add(categoria);
//        int ultimoIndice = getRowCount() - 1; // linhas -1
//        fireTableRowsInserted(ultimoIndice, ultimoIndice); // atualiza insert
//    }
//
//    @Override
//    public void adicionar(List<Categoria> categorias) {
//        int indice = getRowCount();
//        linhas.addAll(categorias);
//        fireTableRowsInserted(indice, indice + categorias.size());
//        fireTableDataChanged();
//    }
//
//    @Override
//    public void remover(int indiceLinha) {
//        linhas.remove(indiceLinha);
//        fireTableRowsDeleted(indiceLinha, indiceLinha); // atualiza delete
//    }
//
//    @Override
//    public void remover(int linhaInicio, int linhaFim) {
//        for (int i = linhaInicio; i <= linhaFim; i++) {
//            linhas.remove(i);
//            fireTableRowsDeleted(linhaInicio, linhaFim); // atualiza delete
//        }
//    }
//
//    @Override
//    public void atualizar(int indiceLinha, Categoria categoria) {
//        linhas.set(indiceLinha, categoria);
//        fireTableRowsUpdated(indiceLinha, indiceLinha); // atualiza delete
//    }
//
//    @Override
//    public void limpar() {
//        linhas.clear();
//        fireTableDataChanged(); // atualiza toda tabela.
//    }
//    
//}
