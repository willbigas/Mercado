package br.com.mercado.control;

import br.com.mercado.dao.EntradaDao;
import br.com.mercado.dao.FornecedorDao;
import br.com.mercado.dao.ItemEntradaDao;
import br.com.mercado.dao.ProdutoDao;
import br.com.mercado.model.Entrada;
import br.com.mercado.model.Fornecedor;
import br.com.mercado.model.ItemEntrada;
import br.com.mercado.model.Produto;
import br.com.mercado.model.tablemodel.EntradaProdutoTableModel;
import br.com.mercado.model.tablemodel.EntradaTableModel;
import br.com.mercado.uteis.Mensagem;
import br.com.mercado.uteis.Texto;
import br.com.mercado.view.TelaEntradaGerenciar;
import br.com.mercado.view.TelaPrincipal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class TelaEntradaGerenciarControl {

    private TelaEntradaGerenciar telaEntradaGerenciar = null;
    private EntradaProdutoTableModel entradaProdutoTableModel;
    private EntradaTableModel entradaTableModel;
    private List<Fornecedor> listFornecedores;
    private List<ItemEntrada> listItemEntradas;
    private FornecedorDao fornecedorDao;
    private ProdutoDao produtoDao;
    private EntradaDao entradaDao;
    private ItemEntradaDao itemEntradaDao;
    private ItemEntrada itemEntrada;
    private Entrada entrada;

    public TelaEntradaGerenciarControl() {
        fornecedorDao = new FornecedorDao();
        entradaDao = new EntradaDao();
        produtoDao = new ProdutoDao();
        itemEntradaDao = new ItemEntradaDao();
        entradaProdutoTableModel = new EntradaProdutoTableModel();
        entradaTableModel = new EntradaTableModel();
        listItemEntradas = new ArrayList<>();
    }

    public void chamarTelaEntradaGerenciar() {
        if (telaEntradaGerenciar == null) { // se tiver nulo chama janela normalmente
            telaEntradaGerenciar = new TelaEntradaGerenciar(this);
            TelaPrincipal.desktopPane.add(telaEntradaGerenciar);
            telaEntradaGerenciar.setVisible(true);
        } else {//se ele estiver criado
            if (telaEntradaGerenciar.isVisible()) {
                telaEntradaGerenciar.pack();//Redimensiona ao Quadro Original
            } else {
                TelaPrincipal.desktopPane.add(telaEntradaGerenciar);
                telaEntradaGerenciar.setVisible(true);
            }
        }
        carregarFornecedoresNaCombo();
        telaEntradaGerenciar.getTblProduto().setModel(entradaProdutoTableModel);
        entradaProdutoTableModel.limpar();
        entradaProdutoTableModel.adicionar(produtoDao.pesquisar());
        telaEntradaGerenciar.getTblEntrada().setModel(entradaTableModel);
    }

    private void carregarFornecedoresNaCombo() {
        listFornecedores = fornecedorDao.pesquisar();
        DefaultComboBoxModel<Fornecedor> model = new DefaultComboBoxModel(listFornecedores.toArray());
        telaEntradaGerenciar.getCbFornecedor().setModel(model);
    }

    /**
     * Adiciona os itens de entrada somente em memoria e na interface do usuário
     */
    public void adicionarItemEntradaAction() {

        itemEntrada = new ItemEntrada();
        itemEntrada.setId(1);
        itemEntrada.setNumeroLote(Integer.valueOf(telaEntradaGerenciar.getTfLote().getText()));
        itemEntrada.setQuantidade(Integer.valueOf(telaEntradaGerenciar.getTfQuantidade().getText()));
        itemEntrada.setValorProduto(Double.valueOf(telaEntradaGerenciar.getTfValor().getText()));
        itemEntrada.setProduto(entradaProdutoTableModel.pegaObjeto(telaEntradaGerenciar.getTblProduto().getSelectedRow()));
        listItemEntradas.add(itemEntrada);
        entradaTableModel.adicionar(itemEntrada);

        itemEntrada = null;
    }

    public void removerItemEntradaAction() {
        int retorno = Mensagem.confirmacao(Texto.PERGUNTA_REMOVER_ITEM_ENTRADA);
        if (retorno == JOptionPane.NO_OPTION) {
            return;
        }
        
        itemEntrada = entradaTableModel.pegaObjeto(telaEntradaGerenciar.getTblEntrada().getSelectedRow());
        listItemEntradas.remove(itemEntrada);
        entradaTableModel.remover(telaEntradaGerenciar.getTblEntrada().getSelectedRow());
        Mensagem.info(Texto.SUCESSO_REMOVER);
        itemEntrada = null;

    }

    /**
     * Itens de Entrada em memória (Atenção!)
     *
     * Nesta função eu recupero os itens da tabela pré inseridos em memória e
     * insiro uma entrada no banco e adiciono aos itens o id da entrada inserida
     * logo depois eu pesquiso o produto do Item entrada no banco.
     *
     * Desta forma consigo recuperar pelos itens de entrada a entrada realizada
     * e o produto deste item , permitindo assim alterar qualquer coisa prevista
     * como quantidade do estoque e preço do item
     *
     */
    public void adicionarEntrada() {
        entrada = new Entrada();
        entrada.setDataEntrada(LocalDateTime.now());
        entrada.setFornecedor((Fornecedor) telaEntradaGerenciar.getCbFornecedor().getSelectedItem());
        Integer idEntradaInserida = entradaDao.inserir(entrada);

        if (idEntradaInserida == 0) {
            Mensagem.erro(Texto.ERRO_CADASTRAR);
            return;
        }

        entrada.setId(idEntradaInserida);
        for (int i = 0; i < listItemEntradas.size(); i++) {
            ItemEntrada umItemEntradaDaTabela = listItemEntradas.get(i);
            umItemEntradaDaTabela.setEntrada(entrada);

            Produto produtoDoItemEntrada = produtoDao.pesquisar(umItemEntradaDaTabela.getProduto().getId());

            produtoDoItemEntrada.setQuantidade(produtoDoItemEntrada.getQuantidade() + umItemEntradaDaTabela.getQuantidade()); // soma a quantidade do item
            produtoDoItemEntrada.setValor(umItemEntradaDaTabela.getValorProduto()); // modifica preço do produto pela entrada
            produtoDoItemEntrada.setFornecedor(entrada.getFornecedor()); // modifica fornecedor , se houver mudança de CNPJ (Viabilizar lista de fornecedores depois)
            produtoDao.alterar(produtoDoItemEntrada);

            umItemEntradaDaTabela.setProduto(produtoDoItemEntrada);
            itemEntradaDao.inserir(umItemEntradaDaTabela);

        }
        
        

        JOptionPane.showMessageDialog(null, "Itens gravados com sucesso");

        entrada.setItensEntrada(listItemEntradas);
    }

}
