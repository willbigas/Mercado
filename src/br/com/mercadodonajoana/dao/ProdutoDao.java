package br.com.mercadodonajoana.dao;

import br.com.mercadodonajoana.model.Categoria;
import br.com.mercadodonajoana.model.Fornecedor;
import br.com.mercadodonajoana.model.Produto;
import br.com.mercadodonajoana.interfaces.DaoI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author William
 */
public class ProdutoDao extends Dao implements DaoI<Produto> {

    public ProdutoDao() {
        super();
    }

    @Override
    public List<Produto> pesquisar() {
        String querySelect = "SELECT * FROM PRODUTOS";
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(querySelect);
            ResultSet result = stmt.executeQuery();
            List<Produto> lista = new ArrayList<>();
            while (result.next()) {
                Produto produto = new Produto();
                produto.setId(result.getInt("id"));
                produto.setNome(result.getString("nome"));
                produto.setCodBarras(result.getInt("CODBARRAS"));
                produto.setValor(result.getDouble("valor"));
                produto.setQuantidade(result.getInt("quantidade"));
                Categoria categoria = new Categoria();
                categoria.setId(result.getInt("fk_categoria"));
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(result.getInt("fk_fornecedor"));
                lista.add(produto);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public int inserir(Produto produto) {
        String queryInsert = "INSERT INTO PRODUTOS (NOME, CODBARRAS, VALOR, QUANTIDADE, FK_CATEGORIA, FK_FORNECEDOR) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(queryInsert, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getCodBarras());
            stmt.setDouble(3, produto.getValor());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setInt(5, produto.getCategoria().getId());
            stmt.setInt(6, produto.getFornecedor().getId());
            ResultSet res;
            if (stmt.executeUpdate() > 0) {
                res = stmt.getGeneratedKeys();
                res.next();
                return res.getInt(1);
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }

    @Override
    public boolean alterar(Produto produto) {
        String queryUpdate = "UPDATE PRODUTOS SET NOME = ?, CODBARRAS = ?, VALOR = ?, "
                + "QUANTIDADE = ?, FK_CATEGORIA = ?, FK_FORNECEDOR = ? "
                + "WHERE ID = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(queryUpdate);
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getCodBarras());
            stmt.setDouble(3, produto.getValor());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setInt(5, produto.getCategoria().getId());
            stmt.setInt(6, produto.getFornecedor().getId());
            stmt.setInt(7, produto.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deletar(Produto obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> pesquisar(String termo) {
        String querySelectComTermo = "SELECT * FROM PRODUTOS WHERE (NOME like ?, CODBARRAS like?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(querySelectComTermo);
            stmt.setString(1, "%" + termo + "%");
            stmt.setString(2, "%" + termo + "%");
            ResultSet result = stmt.executeQuery();
            List<Produto> lista = new ArrayList<>();
            while (result.next()) {
                Produto produto = new Produto();
                produto.setId(result.getInt("id"));
                produto.setNome(result.getString("nome"));
                produto.setCodBarras(result.getInt("CODBARRAS"));
                lista.add(produto);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    @Override
    public Produto pesquisar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean desativar(Produto produto) {
        String sql = "UPDATE PRODUTOS SET ativo = false WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, produto.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean desativar(int id) {
        String sql = "UPDATE PRODUTOS SET ativo = false WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

}
