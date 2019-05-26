package br.com.mercadodonajoana.control;

import br.com.mercadodonajoana.dao.FornecedorDao;
import br.com.mercadodonajoana.model.Fornecedor;
import br.com.mercadodonajoana.view.TelaPrincipal;
import br.com.mercadodonajoana.view.TelaProdutoGerenciar;
import java.util.List;

/**
 *
 * @author William
 */
public class TelaProdutoGerenciarControl {

    TelaProdutoGerenciar telaProdutoGerenciar;
    private List<Fornecedor> listFornecedores;
    private FornecedorDao fornecedorDao;

    public TelaProdutoGerenciarControl() {

    }

    public void chamarTelaProdutoGerenciar() {
        if (telaProdutoGerenciar == null) { // se tiver nulo chama janela normalmente
            telaProdutoGerenciar = new TelaProdutoGerenciar(this);
            TelaPrincipal.desktopPane.add(telaProdutoGerenciar);
            telaProdutoGerenciar.setVisible(true);
        } else {//se ele estiver criado
            if (telaProdutoGerenciar.isVisible()) {
                telaProdutoGerenciar.pack();//Redimensiona ao Quadro Original
            } else {
                TelaPrincipal.desktopPane.add(telaProdutoGerenciar);
                telaProdutoGerenciar.setVisible(true);
            }
        }
    }

}
