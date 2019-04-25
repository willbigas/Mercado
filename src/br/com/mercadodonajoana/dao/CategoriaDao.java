package br.com.mercadodonajoana.dao;

import br.com.mercadodonajoana.model.Categoria;
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
public class CategoriaDao extends Dao implements DaoI<Categoria> {
    
    public CategoriaDao() {
        // Faz a conexão.
        super();
    }

    @Override
    public List<Categoria> pesquisar() {
        String querySelect = "SELECT * FROM CATEGORIAS";
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(querySelect);
            ResultSet result = stmt.executeQuery();
            List<Categoria> lista = new ArrayList<>();
            while (result.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(result.getInt("id"));
                categoria.setNome(result.getString("nome"));
                lista.add(categoria);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public int inserir(Categoria categoria) {
            String queryInsert = "INSERT INTO CATEGORIAS(NOME) VALUES(?)";
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(queryInsert, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, categoria.getNome());
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
    public boolean alterar(Categoria categoria) {
        String queryUpdate = "UPDATE CATEGORIAS SET NOME = ? WHERE ID = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(queryUpdate);
            stmt.setString(1, categoria.getNome());
            stmt.setInt(2, categoria.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deletar(Categoria categoria) {
        String queryDelete = "DELETE FROM CATEGORIAS WHERE ID = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(queryDelete);
            stmt.setInt(1, categoria.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    @Override
    public boolean deletar(int id) {
        String queryDelete = "DELETE FROM CATEGORIAS WHERE ID = ?";
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
    public List<Categoria> pesquisar(String termo) {
        String querySelectComTermo = "SELECT * FROM CATEGORIAS WHERE (NOME like ?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(querySelectComTermo);
            stmt.setString(1, "%" + termo + "%");
            ResultSet result = stmt.executeQuery();     
            List<Categoria> lista = new ArrayList<>();
            while (result.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(result.getInt("id"));
                categoria.setNome(result.getString("nome"));
                lista.add(categoria);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    @Override
    public Categoria pesquisar(int id) {
        String querySelectPorId ="SELECT * FROM CATEGORIAS WHERE ID = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(querySelectPorId);
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(result.getInt("id"));
                categoria.setNome(result.getString("nome"));
                return categoria;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
