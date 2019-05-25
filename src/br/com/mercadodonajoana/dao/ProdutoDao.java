package br.com.mercadodonajoana.dao;

import br.com.mercadodonajoana.model.Produto;
import br.com.mercadojoana.interfaces.DaoI;
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
        // Faz a conexão.
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
//                p.setCategoria(result.getInt("categoria"); // pesquisar categoria
//                p.setFornecedor(result.getInt("fornecedor")); // pesquisar fornecedor
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
        String queryInsert = "INSERT INTO PRODUTOS(NOME, CODBARRAS, VALOR, QUANTIDADE, FK_CATEGORIA, FK_FORNECEDOR) VALUES(?, ?, ?, ?, ?, ?)";
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
        String queryDelete = "DELETE FROM PRODUTOS WHERE ID = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(queryDelete);
            stmt.setInt(1, obj.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deletar(int id) {
        String queryDelete = "DELETE FROM PRODUTOS WHERE ID = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(queryDelete);
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Produto> pesquisar(String termo) {
        String querySelectComTermo = "SELECT * FROM PRODUTOS WHERE (NOME like ?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(querySelectComTermo);
            stmt.setString(1, "%" + termo + "%");
            ResultSet result = stmt.executeQuery();
            List<Produto> lista = new ArrayList<>();
            while (result.next()) {
                Produto produto = new Produto();
                produto.setId(result.getInt("id"));
                produto.setNome(result.getString("nome"));
                produto.setCodBarras(result.getInt("CODBARRAS"));
                produto.setValor(result.getDouble("valor"));
                produto.setQuantidade(result.getInt("quantidade"));
//                p.setCategoria(result.getInt("categoria"); // pesquisar categoria
//                p.setFornecedor(result.getInt("fornecedor")); // pesquisar fornecedor
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
        String querySelectPorId = "SELECT * FROM PRODUTOS WHERE ID = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(querySelectPorId);
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                Produto produto = new Produto();
                produto.setId(result.getInt("id"));
                produto.setNome(result.getString("nome"));
                produto.setCodBarras(result.getInt("codBarras"));
                produto.setValor(result.getDouble("valor"));
                produto.setQuantidade(result.getInt("quantidade"));
//                p.setCategoria(result.getInt("categoria"); // pesquisar categoria
//                p.setFornecedor(result.getInt("fornecedor")); // pesquisar fornecedor
                return produto;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean desativar(Produto obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean desativar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
