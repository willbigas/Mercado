package br.com.mercadojoana.control;

import br.com.mercadojoana.control.funcionario.TelaGerenciarFuncionarioControl;
import br.com.mercadojoana.control.produto.TelaEntradaControl;
import br.com.mercadojoana.control.produto.TelaGerenciarProdutoControl;

/**
 *
 * @author William
 */
public class TelaPrincipalControl {
    TelaGerenciarFuncionarioControl telaGerenciarFuncionarioControl;
    TelaGerenciarProdutoControl telaGerenciarProdutoControl;
    TelaEntradaControl telaEntradaProdutoControl;
    
    
    public void chamarTelaGerenciarFuncionarioAction() {
        telaGerenciarFuncionarioControl = new TelaGerenciarFuncionarioControl();
    }
    public void chamarTelaGerenciarProdutoAction() {
        telaGerenciarProdutoControl = new TelaGerenciarProdutoControl();
    }
    public void chamarTelaEntradaProdutoAction() {
        telaEntradaProdutoControl = new TelaEntradaControl();
    }
    
    
    
    
}
