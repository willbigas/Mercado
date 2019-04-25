package br.com.mercadodonajoana.dao;

import br.com.mercadojoana.factory.Conexao;
import java.sql.Connection;

/**
 *
 * @author William
 */
public class Dao {

    protected Connection conexao;

    public Dao() {
        conexao = Conexao.getConexao();
    }
}
