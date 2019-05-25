/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mercadodonajoana.dao;

import br.com.mercadodonajoana.model.Endereco;
import br.com.mercadodonajoana.model.Fornecedor;
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
public class FornecedorDao extends Dao implements DaoI<Fornecedor> {

    public FornecedorDao() {
        super();
    }

    @Override
    public int inserir(Fornecedor fornecedor) {
        String queryInsert = "INSERT INTO fornecedores(NOME, TELEFONE, FK_ENDERECO) VALUES(?, ?, ?)";
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(queryInsert, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getTelefone());
            stmt.setInt(3, fornecedor.getEndereco().getId());
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
    public boolean alterar(Fornecedor fornecedor) {
        String queryUpdate = "UPDATE fornecedores SET nome = ?, telefone = ?, fk_endereco = ? WHERE ID = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(queryUpdate);
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getTelefone());
            stmt.setInt(3, fornecedor.getEndereco().getId());
            stmt.setInt(4, fornecedor.getId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deletar(Fornecedor obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean desativar(Fornecedor fornecedor) {
        String sql = "UPDATE fornecedores SET ativo = false WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, fornecedor.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean desativar(int id) {
        String sql = "UPDATE fornecedores SET ativo = false WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Fornecedor> pesquisar() {
        String querySelect = "SELECT * FROM FORNECEDORES";
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(querySelect);
            ResultSet result = stmt.executeQuery();
            List<Fornecedor> lista = new ArrayList<>();
            while (result.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(result.getInt("id"));
                fornecedor.setTelefone(result.getString("telefone"));
                fornecedor.setNome(result.getString("nome"));
                Endereco endereco = new Endereco();
                endereco.setId(result.getInt("fk_endereco"));
                lista.add(fornecedor);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Fornecedor> pesquisar(String termo) {
        String querySelectComTermo = "SELECT * FROM fornecedores WHERE (nome LIKE ?, telefone LIKE ?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(querySelectComTermo);
            stmt.setString(1, "%" + termo + "%");
            stmt.setString(2, "%" + termo + "%");
            ResultSet result = stmt.executeQuery();
            List<Fornecedor> lista = new ArrayList<>();
            while (result.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(result.getInt("id"));
                fornecedor.setNome(result.getString("nome"));
                fornecedor.setTelefone(result.getString("telefone"));
                lista.add(fornecedor);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Fornecedor pesquisar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
