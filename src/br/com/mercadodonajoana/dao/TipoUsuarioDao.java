/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mercadodonajoana.dao;

import br.com.mercadodonajoana.model.TipoUsuario;
import br.com.mercadojoana.interfaces.DaoI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author william.mauro
 */
public class TipoUsuarioDao extends Dao implements DaoI<TipoUsuario> {

    public TipoUsuarioDao() {
        super();
    }

    @Override
    public int inserir(TipoUsuario tipoUsuario) {
        String queryInsert = "INSERT INTO tipoUsuario (NOME) VALUES(?)";
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(queryInsert, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, tipoUsuario.getNome());
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
    public boolean alterar(TipoUsuario tipoUsuario) {
        String queryUpdate = "UPDATE tipoUsuario SET NOME = ? WHERE ID = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(queryUpdate);
            stmt.setString(1, tipoUsuario.getNome());
            stmt.setInt(2, tipoUsuario.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deletar(TipoUsuario tipoUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoUsuario> pesquisar() {
        String querySelect = "SELECT * FROM TIPOUSUARIO";
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(querySelect);
            ResultSet result = stmt.executeQuery();
            List<TipoUsuario> lista = new ArrayList<>();
            while (result.next()) {
                TipoUsuario tipoUsuario = new TipoUsuario();
                tipoUsuario.setId(result.getInt("id"));
                tipoUsuario.setNome(result.getString("nome"));
                lista.add(tipoUsuario);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<TipoUsuario> pesquisar(String termo) {
        String querySelectComTermo = "SELECT * FROM TIPOUSUARIO WHERE (NOME like ?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(querySelectComTermo);
            stmt.setString(1, "%" + termo + "%");
            ResultSet result = stmt.executeQuery();
            List<TipoUsuario> lista = new ArrayList<>();
            while (result.next()) {
                TipoUsuario tipoUsuario = new TipoUsuario();
                tipoUsuario.setId(result.getInt("id"));
                tipoUsuario.setNome(result.getString("nome"));
                lista.add(tipoUsuario);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public TipoUsuario pesquisar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean desativar(TipoUsuario obj) {
        String sql = "UPDATE tipoUsuario SET ativo = false WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean desativar(int id) {
        String sql = "UPDATE tipoUsuario SET ativo = false WHERE id = ?";
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
