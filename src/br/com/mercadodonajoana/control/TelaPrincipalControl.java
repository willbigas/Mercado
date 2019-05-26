package br.com.mercadodonajoana.control;

/**
 *
 * @author William
 */
public class TelaPrincipalControl {

    TelaFuncionarioGerenciarControl telaFuncionarioGerenciarControl = null;
    TelaProdutoGerenciarControl telaProdutoGerenciarControl = null;
    TelaEntradaGerenciarControl telaEntradaGerenciarControl = null;
    TelaCategoriaGerenciarControl telaCategoriaGerenciarControl = null;
    TelaClienteGerenciarControl telaClienteGerenciarControl = null;
    TelaFornecedorGerenciarControl telaFornecedorGerenciarControl = null;
    TelaTipoUsuarioGerenciarControl telaTipoUsuarioGerenciarControl = null;
    TelaVendaControl telaVendaControl = null;

    public void chamarTelaGerenciarFuncionarioAction() {
        if (telaFuncionarioGerenciarControl != null) {
            telaFuncionarioGerenciarControl.chamarTelaFuncionarioGerenciar();
        } else {
            telaFuncionarioGerenciarControl = new TelaFuncionarioGerenciarControl();
            telaFuncionarioGerenciarControl.chamarTelaFuncionarioGerenciar();
        }
    }

    public void chamarTelaProdutoGerenciarAction() {
        if (telaProdutoGerenciarControl != null) {
            telaProdutoGerenciarControl.chamarTelaProdutoGerenciar();
        } else {
            telaProdutoGerenciarControl = new TelaProdutoGerenciarControl();
            telaProdutoGerenciarControl.chamarTelaProdutoGerenciar();
        }
    }

    public void chamarTelaEntradaProdutoGerenciarAction() {
        if (telaEntradaGerenciarControl != null) {
            telaEntradaGerenciarControl.chamarTelaEntradaGerenciar();
        } else {
            telaEntradaGerenciarControl = new TelaEntradaGerenciarControl();
            telaEntradaGerenciarControl.chamarTelaEntradaGerenciar();
        }

    }

    public void chamarTelaCategoriaGerenciarAction() {
        if (telaCategoriaGerenciarControl != null) {
            telaCategoriaGerenciarControl.chamarTelaCategoriaGerenciar();
        } else {
            telaCategoriaGerenciarControl = new TelaCategoriaGerenciarControl();
            telaCategoriaGerenciarControl.chamarTelaCategoriaGerenciar();
        }

    }

    public void chamarTelaClienteGerenciarAction() {
        if (telaClienteGerenciarControl != null) {
            telaClienteGerenciarControl.chamarTelaClienteGerenciar();
        } else {
            telaClienteGerenciarControl = new TelaClienteGerenciarControl();
            telaClienteGerenciarControl.chamarTelaClienteGerenciar();
        }
    }

    public void chamarTelaFornecedorGerenciarAction() {
        if (telaFornecedorGerenciarControl != null) {
            telaFornecedorGerenciarControl.chamarTelaFornecedorGerenciar();
        } else {
            telaFornecedorGerenciarControl = new TelaFornecedorGerenciarControl();
            telaFornecedorGerenciarControl.chamarTelaFornecedorGerenciar();
        }
    }

    public void chamarTelaTipoUsuarioGerenciarAction() {
        if (telaTipoUsuarioGerenciarControl != null) {
            telaTipoUsuarioGerenciarControl.chamarTelaTipoUsuarioGerenciar();
        } else {
            telaTipoUsuarioGerenciarControl = new TelaTipoUsuarioGerenciarControl();
            telaTipoUsuarioGerenciarControl.chamarTelaTipoUsuarioGerenciar();
        }
    }
    public void chamarTelaVendaAction() {
        if (telaVendaControl != null) {
            telaVendaControl.chamarTelaVenda();
        } else {
            telaVendaControl = new TelaVendaControl();
            telaVendaControl.chamarTelaVenda();
        }
    }

}
