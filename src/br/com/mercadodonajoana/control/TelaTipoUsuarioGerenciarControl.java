package br.com.mercadodonajoana.control;

import br.com.mercadodonajoana.dao.TipoUsuarioDao;
import br.com.mercadodonajoana.model.TipoPermissao;
import br.com.mercadodonajoana.model.tablemodel.TipoUsuarioTableModel;
import br.com.mercadodonajoana.view.TelaPrincipal;
import br.com.mercadodonajoana.view.TelaTipoUsuarioGerenciar;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Will
 */
public class TelaTipoUsuarioGerenciarControl {

    TipoUsuarioDao tipoUsuarioDao;
    TipoUsuarioTableModel tipoUsuarioTableModel;
    List<TipoPermissao> listTipoPermissao;
    TelaTipoUsuarioGerenciar telaTipoUsuarioGerenciar;

    public TelaTipoUsuarioGerenciarControl() {
        tipoUsuarioDao = new TipoUsuarioDao();
        tipoUsuarioTableModel = new TipoUsuarioTableModel();
    }

    public void chamarTelaTipoUsuarioGerenciar() {
        if (telaTipoUsuarioGerenciar == null) { // se tiver nulo chama janela normalmente
            telaTipoUsuarioGerenciar = new TelaTipoUsuarioGerenciar(this);
            TelaPrincipal.desktopPane.add(telaTipoUsuarioGerenciar);
            telaTipoUsuarioGerenciar.setVisible(true);
        } else {//se ele estiver criado
            if (telaTipoUsuarioGerenciar.isVisible()) {
                telaTipoUsuarioGerenciar.pack();//Redimensiona ao Quadro Original
            } else {
                TelaPrincipal.desktopPane.add(telaTipoUsuarioGerenciar);
                telaTipoUsuarioGerenciar.setVisible(true);
            }
        }
        criarListaDePermisssoesDeUsuarios();
        carregarComboBoxDeTipoPermissao();
        telaTipoUsuarioGerenciar.getTblTipoUsuario().setModel(tipoUsuarioTableModel);
        atualizarTabelaTipoUsuario();
    }

    public void atualizarTabelaTipoUsuario() {
        tipoUsuarioTableModel.adicionar(tipoUsuarioDao.pesquisar());
    }

    public void criarListaDePermisssoesDeUsuarios() {
        listTipoPermissao = new ArrayList<>();
        TipoPermissao administrador = new TipoPermissao();
        administrador.setId(1);
        administrador.setNome("Administrador");
        listTipoPermissao.add(administrador);
        TipoPermissao caixa = new TipoPermissao();
        caixa.setId(2);
        caixa.setNome("Caixa");
        listTipoPermissao.add(caixa);
    }

    public void carregarComboBoxDeTipoPermissao() {
        DefaultComboBoxModel<TipoPermissao> model = new DefaultComboBoxModel(listTipoPermissao.toArray());
        telaTipoUsuarioGerenciar.getCbPermissao().setModel(model);
    }

}
