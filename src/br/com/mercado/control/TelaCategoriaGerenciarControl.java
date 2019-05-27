package br.com.mercado.control;

import br.com.mercado.dao.CategoriaDao;
import br.com.mercado.model.Categoria;
import br.com.mercado.model.tablemodel.CategoriaTableModel;
import br.com.mercado.uteis.Mensagem;
import br.com.mercado.uteis.Texto;
import br.com.mercado.view.TelaCategoriaGerenciar;
import br.com.mercado.view.TelaPrincipal;
import java.util.List;

/**
 *
 * @author Will
 */
public class TelaCategoriaGerenciarControl {

    private TelaCategoriaGerenciar telaCategoriaGerenciar;
    private Categoria categoria;
    private CategoriaDao categoriaDao;
    private CategoriaTableModel tableModelCategoria;
    private Integer linhaSelecionada;

    public TelaCategoriaGerenciarControl() {
        categoriaDao = new CategoriaDao();
        tableModelCategoria = new CategoriaTableModel();
        tableModelCategoria.adicionar(categoriaDao.pesquisar());
    }

    public void chamarTelaCategoriaGerenciar() {
        if (telaCategoriaGerenciar == null) {
            telaCategoriaGerenciar = new TelaCategoriaGerenciar(this);
            TelaPrincipal.desktopPane.add(telaCategoriaGerenciar);
            telaCategoriaGerenciar.setVisible(true);
        } else {
            if (telaCategoriaGerenciar.isVisible()) {
                telaCategoriaGerenciar.pack();
            } else {
                TelaPrincipal.desktopPane.add(telaCategoriaGerenciar);
                telaCategoriaGerenciar.setVisible(true);
            }
        }
        telaCategoriaGerenciar.getTblCategoria().setModel(tableModelCategoria);
    }

    private void cadastrarCategoria() {
        if (validarCampos()) {
            Mensagem.erro(Texto.VAZIO_CAMPOS);
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

    public void carregarCategoriaAction(){
        categoria = tableModelCategoria.pegaObjeto(telaCategoriaGerenciar.getTblCategoria().getSelectedRow());
        telaCategoriaGerenciar.getTfNome().setText(categoria.getNome());
        if (categoria.getAtivo() == true) {
            telaCategoriaGerenciar.getCheckAtivo().setSelected(true);
        } else {
            telaCategoriaGerenciar.getCheckAtivo().setSelected(false);
        }
    }

    private void alterarCategoria() {
        if (validarCampos()) {
            Mensagem.erro(Texto.VAZIO_CAMPOS);
            return;
        }
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

    public void gravarCategoriaAction() {
        if (categoria == null) {
            cadastrarCategoria();
        } else {
            alterarCategoria();
        }
    }

    public void pesquisarCategoriaAction() {
        List<Categoria> categoriasPesquisadas = categoriaDao.pesquisar(telaCategoriaGerenciar.getTfPesquisar().getText());
        if (categoriasPesquisadas == null) {
            tableModelCategoria.limpar();
            categoriasPesquisadas = categoriaDao.pesquisar();
        } else {
            tableModelCategoria.limpar();
            tableModelCategoria.adicionar(categoriasPesquisadas);
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
