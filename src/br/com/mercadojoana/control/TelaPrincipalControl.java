package br.com.mercadojoana.control;

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
