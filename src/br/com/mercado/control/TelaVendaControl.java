package br.com.mercado.control;

import br.com.mercado.dao.ClienteDao;
import br.com.mercado.dao.ProdutoDao;
import br.com.mercado.dao.UsuarioDao;
import br.com.mercado.model.Cliente;
import br.com.mercado.model.Usuario;
import br.com.mercado.model.tablemodel.ProdutoTableModel;
import br.com.mercado.view.TelaPrincipal;
import br.com.mercado.view.TelaVenda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Will
 */
public class TelaVendaControl {

    TelaVenda telaVenda;
    ClienteDao clienteDao;
    UsuarioDao usuarioDao;
    ProdutoDao produtoDao;
    List<Cliente> listClientes;
    List<Usuario> listUsuarios;
    ProdutoTableModel produtoTableModel;

    public TelaVendaControl() {
        clienteDao = new ClienteDao();
        usuarioDao = new UsuarioDao();
        produtoDao = new ProdutoDao();
        listClientes = new ArrayList<>();
        listUsuarios = new ArrayList<>();
        produtoTableModel = new ProdutoTableModel();
        
    }

    public void chamarTelaVenda() {
        if (telaVenda == null) {
            telaVenda = new TelaVenda(this);
            TelaPrincipal.desktopPane.add(telaVenda);
            telaVenda.setVisible(true);
        } else {
            if (telaVenda.isVisible()) {
                telaVenda.pack();
            } else {
                TelaPrincipal.desktopPane.add(telaVenda);
                telaVenda.setVisible(true);
            }
        }
        carregarClientesNaCombo();
        carregarUsuariosNaCombo();
        telaVenda.getTblProduto().setModel(produtoTableModel);
         produtoTableModel.limpar();
        produtoTableModel.adicionar(produtoDao.pesquisar());
    }
    
    private void carregarClientesNaCombo() {
        listClientes = clienteDao.pesquisar();
        DefaultComboBoxModel<Cliente> model = new DefaultComboBoxModel(listClientes.toArray());
        telaVenda.getCbCliente().setModel(model);
    }
    
     private void carregarUsuariosNaCombo() {
        listUsuarios = usuarioDao.pesquisar();
        DefaultComboBoxModel<Usuario> model = new DefaultComboBoxModel(listUsuarios.toArray());
        telaVenda.getCbUsuario().setModel(model);
    }
    
}
