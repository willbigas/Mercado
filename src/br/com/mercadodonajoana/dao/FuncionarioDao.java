/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mercadodonajoana.dao;

import br.com.mercadodonajoana.model.Funcionario;
import br.com.mercadodonajoana.interfaces.DaoI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author william.mauro
 */
public class FuncionarioDao extends Dao implements DaoI<Funcionario> {

    EnderecoDao enderecoDao;
    TipoUsuarioDao tipoUsuarioDao;

    public FuncionarioDao() {
        super();
        enderecoDao = new EnderecoDao();
        tipoUsuarioDao = new TipoUsuarioDao();
    }

    @Override
    public int inserir(Funcionario funcionario) {
        String queryInsert = "INSERT INTO funcionarios (NOME, PIS, SALARIO, TELEFONE, SENHA, EMAIL, FK_TIPOUSUARIO, FK_ENDERECO, ATIVO) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(queryInsert, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, funcionario.getNome());
            stmt.setInt(2, funcionario.getPis());
            stmt.setDouble(3, funcionario.getSalario());
            stmt.setString(4, funcionario.getTelefone());
            stmt.setString(5, funcionario.getSenha());
            stmt.setString(6, funcionario.getEmail());
            stmt.setInt(7, funcionario.getTipoUsuario().getId());
            stmt.setInt(8, funcionario.getEndereco().getId());
            stmt.setBoolean(9, funcionario.getAtivo());
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
    public boolean alterar(Funcionario funcionario) {
        String queryUpdate = "UPDATE funcionarios SET nome = ?, PIS = ?, SALARIO = ?, TELEFONE = ?, SENHA = ?, EMAIL = ?, FK_TIPOUSUARIO = ?,  FK_USUARIO = ?, ATIVO = ?  WHERE ID = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(queryUpdate);
            stmt.setString(1, funcionario.getNome());
            stmt.setInt(2, funcionario.getPis());
            stmt.setDouble(3, funcionario.getSalario());
            stmt.setString(4, funcionario.getTelefone());
            stmt.setString(5, funcionario.getSenha());
            stmt.setString(6, funcionario.getEmail());
            stmt.setInt(7, funcionario.getTipoUsuario().getId());
            stmt.setInt(8, funcionario.getEndereco().getId());
            stmt.setInt(9, funcionario.getId());
            stmt.setBoolean(10, funcionario.getAtivo());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deletar(Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean desativar(Funcionario funcionario) {
        String sql = "UPDATE funcionarios SET ativo = false WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, funcionario.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean desativar(int id) {
        String sql = "UPDATE funcionarios SET ativo = false WHERE id = ?";
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
    public List<Funcionario> pesquisar() {
        String querySelect = "SELECT * FROM FUNCIONARIOS";
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(querySelect);
            ResultSet result = stmt.executeQuery();
            List<Funcionario> lista = new ArrayList<>();
            while (result.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(result.getInt("id"));
                funcionario.setNome(result.getString("nome"));
                funcionario.setEmail(result.getString("email"));
                funcionario.setTelefone(result.getString("telefone"));
                funcionario.setPis(result.getInt("pis"));
                funcionario.setSalario(result.getDouble("salario"));
                funcionario.setSenha(result.getString("senha"));
                funcionario.setAtivo(result.getBoolean("ativo"));
                funcionario.setEndereco(enderecoDao.pesquisar(result.getInt("fk_endereco")));
                funcionario.setTipoUsuario(tipoUsuarioDao.pesquisar(result.getInt("fk_tipoUsuario")));
                lista.add(funcionario);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Funcionario> pesquisar(String termo) {
        String querySelectComTermo = "SELECT * FROM funcionarios WHERE (nome LIKE ?, email LIKE ?, telefone LIKE ?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(querySelectComTermo);
            stmt.setString(1, "%" + termo + "%");
            stmt.setString(2, "%" + termo + "%");
            stmt.setString(3, "%" + termo + "%");
            ResultSet result = stmt.executeQuery();
            List<Funcionario> lista = new ArrayList<>();
            while (result.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(result.getInt("id"));
                funcionario.setNome(result.getString("nome"));
                funcionario.setEmail(result.getString("email"));
                funcionario.setTelefone(result.getString("telefone"));
                lista.add(funcionario);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Funcionario pesquisar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
