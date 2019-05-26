package br.com.mercadodonajoana.control;

import br.com.mercadodonajoana.dao.CategoriaDao;
import br.com.mercadodonajoana.model.Categoria;
import br.com.mercadodonajoana.model.tablemodel.CategoriaTableModel;
import br.com.mercadodonajoana.uteis.Mensagem;
import br.com.mercadodonajoana.uteis.Texto;
import br.com.mercadodonajoana.view.TelaCategoriaGerenciar;
import br.com.mercadodonajoana.view.TelaPrincipal;
import java.beans.PropertyVetoException;

/**
 *
 * @author Will
 */
public class TelaCategoriaGerenciarControl {

    TelaCategoriaGerenciar telaCategoriaGerenciar;
    Categoria categoria;
    CategoriaDao categoriaDao;
    CategoriaTableModel tableModelCategoria;
    Integer linhaSelecionada;

    public TelaCategoriaGerenciarControl() {
        categoriaDao = new CategoriaDao();
        tableModelCategoria = new CategoriaTableModel();
        tableModelCategoria.adicionar(categoriaDao.pesquisar());
    }

    public void chamarTelaCategoriaGerenciar() {
        if (telaCategoriaGerenciar == null) { // se tiver nulo chama janela normalmente
            telaCategoriaGerenciar = new TelaCategoriaGerenciar(this);
            TelaPrincipal.desktopPane.add(telaCategoriaGerenciar);
            telaCategoriaGerenciar.setVisible(true);
        } else {//se ele estiver criado
            if (telaCategoriaGerenciar.isVisible()) {
                telaCategoriaGerenciar.pack();//Redimensiona ao Quadro Original
            } else {
                TelaPrincipal.desktopPane.add(telaCategoriaGerenciar);
                telaCategoriaGerenciar.setVisible(true);
            }
        }
        telaCategoriaGerenciar.getTblCategoria().setModel(tableModelCategoria);
    }

    private void cadastrarCategoria() {
        if (validarCampos()) {
            Mensagem.erro(Texto.ERRO_CADASTRAR);
            return;
        }
        categoria = new Categoria();
        categoria.setNome(telaCategoriaGerenciar.getTfNome().getText());
        if (telaCategoriaGerenciar.getCheckAtivo().isSelected()) {
            categoria.setAtivo(true);
        } else {
            categoria.setAtivo(false);
        }

        Integer idInserido = categoriaDao.inserir(categoria);
        if (idInserido != 0) {
            categoria.setId(idInserido);
            tableModelCategoria.adicionar(categoria);
            limparCampos();
            Mensagem.info(Texto.SUCESSO_CADASTRAR);
        } else {
            Mensagem.info(Texto.ERRO_CADASTRAR);
        }
        categoria = null;
    }

    public void carregarCategoriaAction() throws PropertyVetoException {
        categoria = tableModelCategoria.pegaObjeto(telaCategoriaGerenciar.getTblCategoria().getSelectedRow());
        telaCategoriaGerenciar.getTfNome().setText(categoria.getNome());
        if (categoria.getAtivo() == true) {
            telaCategoriaGerenciar.getCheckAtivo().setSelected(true);
        } else {
            telaCategoriaGerenciar.getCheckAtivo().setSelected(false);
        }

    }

    private void alterarViagem() {
        categoria.setNome(telaCategoriaGerenciar.getTfNome().getText());
        if (telaCategoriaGerenciar.getCheckAtivo().isSelected()) {
            categoria.setAtivo(true);
        } else {
            categoria.setAtivo(false);
        }
        boolean alterado = categoriaDao.alterar(categoria);
        linhaSelecionada = telaCategoriaGerenciar.getTblCategoria().getSelectedRow();
        if (alterado) {
            tableModelCategoria.atualizar(linhaSelecionada, categoria);
            Mensagem.info(Texto.SUCESSO_EDITAR);
            limparCampos();
        } else {
            Mensagem.erro(Texto.ERRO_EDITAR);
        }
        categoria = null;
    }

    public void gravarAction() {
        if (categoria == null) {
            cadastrarCategoria();
        } else {
            alterarViagem();
        }
    }

    private void limparCampos() {
        telaCategoriaGerenciar.getTfNome().setText("");
        telaCategoriaGerenciar.getTfPesquisar().setText("");
        telaCategoriaGerenciar.getCheckAtivo().setSelected(false);
        telaCategoriaGerenciar.getTfNome().requestFocus();
    }

    private boolean validarCampos() {
        if (telaCategoriaGerenciar.getTfNome().getText().isEmpty()) {
            telaCategoriaGerenciar.getTfNome().requestFocus();
            return true;
        }
        return false;
    }
}
