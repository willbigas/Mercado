package br.com.mercadojoana.control;

/**
 *
 * @author William
 */
public class TelaPrincipalControl {

    TelaFuncionarioGerenciarControl telaFuncionarioGerenciarControl = null;
    TelaGerenciarProdutoControl telaGerenciarProdutoControl;
    TelaEntradaGerenciarControl entradaGerenciarControl = null;

    public void chamarTelaGerenciarFuncionarioAction() {
        if (telaFuncionarioGerenciarControl != null) {
            telaFuncionarioGerenciarControl.chamarTelaFuncionarioGerenciar();
        } else {
            telaFuncionarioGerenciarControl = new TelaFuncionarioGerenciarControl();
            telaFuncionarioGerenciarControl.chamarTelaFuncionarioGerenciar();
        }
    }

    public void chamarTelaGerenciarProdutoAction() {
        telaGerenciarProdutoControl = new TelaGerenciarProdutoControl();
    }

    public void chamarTelaEntradaProdutoGerenciarAction() {
        if (entradaGerenciarControl != null) {
            entradaGerenciarControl.chamarTelaEntradaGerenciar();
        } else {
            entradaGerenciarControl = new TelaEntradaGerenciarControl();
            entradaGerenciarControl.chamarTelaEntradaGerenciar();
        }

    }

}
