package br.com.mercado.view;

import br.com.mercado.control.TelaPrincipalControl;
import br.com.mercado.uteis.Relatorio;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 *
 * @author William
 */
public class TelaPrincipal extends javax.swing.JFrame {

    TelaPrincipalControl telaPrincipalControl;

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        telaPrincipalControl = new TelaPrincipalControl();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuClientes = new javax.swing.JMenu();
        menuItemGerenciarCliente = new javax.swing.JMenuItem();
        menuItemVenda = new javax.swing.JMenuItem();
        menuProdutos = new javax.swing.JMenu();
        menuItemGerenciarProduto = new javax.swing.JMenuItem();
        menuItemGerenciarCategoria = new javax.swing.JMenuItem();
        menuItemEntradaProduto = new javax.swing.JMenuItem();
        menuFornecedores = new javax.swing.JMenu();
        menuItemGerenciarFornecedor = new javax.swing.JMenuItem();
        menuUsuario = new javax.swing.JMenu();
        menuItemGerenciarFuncionario = new javax.swing.JMenuItem();
        menuItemGerenciarTipoUsuario = new javax.swing.JMenuItem();
        menuFinanceiro = new javax.swing.JMenu();
        menuItemReceita = new javax.swing.JMenuItem();
        menuItemDespesa = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuItemRelatorioClientes = new javax.swing.JMenuItem();
        menuItemRelatorioFornecedores = new javax.swing.JMenuItem();
        menuItemRelatorioProdutos = new javax.swing.JMenuItem();
        menuItemRelatorioCategorias = new javax.swing.JMenuItem();
        menuItemRelatorioReceitas = new javax.swing.JMenuItem();
        menuItemRelatorioDespesas = new javax.swing.JMenuItem();
        menuSobre = new javax.swing.JMenu();
        menuItemAjuda = new javax.swing.JMenuItem();
        menuItemSobre = new javax.swing.JMenuItem();
        menuConfiguracao = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");

        desktopPane.setBackground(new java.awt.Color(204, 204, 204));
        desktopPane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        desktopPane.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 848, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(235, 193, 11));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mercado");

        menuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/clientes_32x32.png"))); // NOI18N
        menuClientes.setText("Clientes");
        menuClientes.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        menuItemGerenciarCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menuItemGerenciarCliente.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        menuItemGerenciarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/gerenciar_32x32.png"))); // NOI18N
        menuItemGerenciarCliente.setText("Gerenciar Clientes");
        menuItemGerenciarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGerenciarClienteActionPerformed(evt);
            }
        });
        menuClientes.add(menuItemGerenciarCliente);

        menuItemVenda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        menuItemVenda.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        menuItemVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/venda_32x32.png"))); // NOI18N
        menuItemVenda.setText("Efetuar Venda");
        menuItemVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemVendaActionPerformed(evt);
            }
        });
        menuClientes.add(menuItemVenda);

        jMenuBar1.add(menuClientes);

        menuProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/produto_32x32.png"))); // NOI18N
        menuProdutos.setText("Produtos");
        menuProdutos.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        menuItemGerenciarProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        menuItemGerenciarProduto.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        menuItemGerenciarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/gerenciar_32x32.png"))); // NOI18N
        menuItemGerenciarProduto.setText("Gerenciar Produtos");
        menuItemGerenciarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGerenciarProdutoActionPerformed(evt);
            }
        });
        menuProdutos.add(menuItemGerenciarProduto);

        menuItemGerenciarCategoria.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        menuItemGerenciarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/categoria_32x32.png"))); // NOI18N
        menuItemGerenciarCategoria.setText("Categoria de Produtos");
        menuItemGerenciarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGerenciarCategoriaActionPerformed(evt);
            }
        });
        menuProdutos.add(menuItemGerenciarCategoria);

        menuItemEntradaProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        menuItemEntradaProduto.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        menuItemEntradaProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/down_32x32.png"))); // NOI18N
        menuItemEntradaProduto.setText("Entrada de Produtos");
        menuItemEntradaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEntradaProdutoActionPerformed(evt);
            }
        });
        menuProdutos.add(menuItemEntradaProduto);

        jMenuBar1.add(menuProdutos);

        menuFornecedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/truck_32x32.png"))); // NOI18N
        menuFornecedores.setText("Fornecedores");
        menuFornecedores.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        menuItemGerenciarFornecedor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        menuItemGerenciarFornecedor.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        menuItemGerenciarFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/gerenciar_32x32.png"))); // NOI18N
        menuItemGerenciarFornecedor.setText("Gerenciar Fornecedores");
        menuItemGerenciarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGerenciarFornecedorActionPerformed(evt);
            }
        });
        menuFornecedores.add(menuItemGerenciarFornecedor);

        jMenuBar1.add(menuFornecedores);

        menuUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/people_32x32.png"))); // NOI18N
        menuUsuario.setText("Usuários");
        menuUsuario.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        menuItemGerenciarFuncionario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        menuItemGerenciarFuncionario.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        menuItemGerenciarFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/gerenciar_32x32.png"))); // NOI18N
        menuItemGerenciarFuncionario.setText("Gerenciar Usuários");
        menuItemGerenciarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGerenciarFuncionarioActionPerformed(evt);
            }
        });
        menuUsuario.add(menuItemGerenciarFuncionario);

        menuItemGerenciarTipoUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        menuItemGerenciarTipoUsuario.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        menuItemGerenciarTipoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/cardUser_32x32.png"))); // NOI18N
        menuItemGerenciarTipoUsuario.setText("Tipo de Usuário");
        menuItemGerenciarTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGerenciarTipoUsuarioActionPerformed(evt);
            }
        });
        menuUsuario.add(menuItemGerenciarTipoUsuario);

        jMenuBar1.add(menuUsuario);

        menuFinanceiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/money_32x32.png"))); // NOI18N
        menuFinanceiro.setText("Financeiro");
        menuFinanceiro.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        menuItemReceita.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        menuItemReceita.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        menuItemReceita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/receita_32x32.png"))); // NOI18N
        menuItemReceita.setText("Receitas");
        menuItemReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemReceitaActionPerformed(evt);
            }
        });
        menuFinanceiro.add(menuItemReceita);

        menuItemDespesa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        menuItemDespesa.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        menuItemDespesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/despesa_32x32.png"))); // NOI18N
        menuItemDespesa.setText("Despesas");
        menuItemDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDespesaActionPerformed(evt);
            }
        });
        menuFinanceiro.add(menuItemDespesa);

        jMenuBar1.add(menuFinanceiro);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/relatorio_32x32.png"))); // NOI18N
        jMenu1.setText("Relatórios");
        jMenu1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        menuItemRelatorioClientes.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        menuItemRelatorioClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/clientes_32x32.png"))); // NOI18N
        menuItemRelatorioClientes.setText("Clientes");
        menuItemRelatorioClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRelatorioClientesActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemRelatorioClientes);

        menuItemRelatorioFornecedores.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        menuItemRelatorioFornecedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/truck_32x32.png"))); // NOI18N
        menuItemRelatorioFornecedores.setText("Fornecedores");
        menuItemRelatorioFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRelatorioFornecedoresActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemRelatorioFornecedores);

        menuItemRelatorioProdutos.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        menuItemRelatorioProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/produto_32x32.png"))); // NOI18N
        menuItemRelatorioProdutos.setText("Produtos");
        menuItemRelatorioProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRelatorioProdutosActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemRelatorioProdutos);

        menuItemRelatorioCategorias.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        menuItemRelatorioCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/categoria_32x32.png"))); // NOI18N
        menuItemRelatorioCategorias.setText("Categorias");
        menuItemRelatorioCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRelatorioCategoriasActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemRelatorioCategorias);

        menuItemRelatorioReceitas.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        menuItemRelatorioReceitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/receita_32x32.png"))); // NOI18N
        menuItemRelatorioReceitas.setText("Receitas");
        menuItemRelatorioReceitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRelatorioReceitasActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemRelatorioReceitas);

        menuItemRelatorioDespesas.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        menuItemRelatorioDespesas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/despesa_32x32.png"))); // NOI18N
        menuItemRelatorioDespesas.setText("Despesas");
        menuItemRelatorioDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRelatorioDespesasActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemRelatorioDespesas);

        jMenuBar1.add(jMenu1);

        menuSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/info_32x32.png"))); // NOI18N
        menuSobre.setText("Sobre");
        menuSobre.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        menuItemAjuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        menuItemAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/ajuda_32x32.png"))); // NOI18N
        menuItemAjuda.setText("Ajuda");
        menuSobre.add(menuItemAjuda);

        menuItemSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuItemSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/developer_32x32.png"))); // NOI18N
        menuItemSobre.setText("Sobre");
        menuItemSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSobreActionPerformed(evt);
            }
        });
        menuSobre.add(menuItemSobre);

        jMenuBar1.add(menuSobre);

        menuConfiguracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/settings_32x32.png"))); // NOI18N
        menuConfiguracao.setText("Configurações");
        menuConfiguracao.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        menuConfiguracao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                menuConfiguracaoMouseReleased(evt);
            }
        });
        menuConfiguracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConfiguracaoActionPerformed(evt);
            }
        });

        jMenuItem1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jMenuItem1.setText("Parametros");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuConfiguracao.add(jMenuItem1);

        jMenuBar1.add(menuConfiguracao);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemGerenciarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGerenciarFuncionarioActionPerformed
        telaPrincipalControl.chamarTelaGerenciarFuncionarioAction();
    }//GEN-LAST:event_menuItemGerenciarFuncionarioActionPerformed

    private void menuItemGerenciarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGerenciarProdutoActionPerformed
        telaPrincipalControl.chamarTelaProdutoGerenciarAction();
    }//GEN-LAST:event_menuItemGerenciarProdutoActionPerformed

    private void menuItemEntradaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEntradaProdutoActionPerformed
        telaPrincipalControl.chamarTelaEntradaProdutoGerenciarAction();
    }//GEN-LAST:event_menuItemEntradaProdutoActionPerformed

    private void menuItemGerenciarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGerenciarCategoriaActionPerformed
        telaPrincipalControl.chamarTelaCategoriaGerenciarAction();
    }//GEN-LAST:event_menuItemGerenciarCategoriaActionPerformed

    private void menuItemGerenciarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGerenciarClienteActionPerformed
        telaPrincipalControl.chamarTelaClienteGerenciarAction();
    }//GEN-LAST:event_menuItemGerenciarClienteActionPerformed

    private void menuItemGerenciarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGerenciarFornecedorActionPerformed
        telaPrincipalControl.chamarTelaFornecedorGerenciarAction();
    }//GEN-LAST:event_menuItemGerenciarFornecedorActionPerformed

    private void menuItemGerenciarTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGerenciarTipoUsuarioActionPerformed
        telaPrincipalControl.chamarTelaTipoUsuarioGerenciarAction();
    }//GEN-LAST:event_menuItemGerenciarTipoUsuarioActionPerformed

    private void menuItemVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVendaActionPerformed
        telaPrincipalControl.chamarTelaVendaAction();
    }//GEN-LAST:event_menuItemVendaActionPerformed

    private void menuItemSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSobreActionPerformed
        // TODO add your handling code here:
        telaPrincipalControl.chamarTelaSobreAction();
    }//GEN-LAST:event_menuItemSobreActionPerformed

    private void menuItemReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemReceitaActionPerformed
        // TODO add your handling code here:
        telaPrincipalControl.chamarTelaReceitaGerenciarAction();

    }//GEN-LAST:event_menuItemReceitaActionPerformed

    private void menuItemDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDespesaActionPerformed
        // TODO add your handling code here:
        telaPrincipalControl.chamarTelaDespesaGerenciarAction();
    }//GEN-LAST:event_menuItemDespesaActionPerformed

    private void menuItemRelatorioClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRelatorioClientesActionPerformed
        // TODO add your handling code here:
        URL jasperFile = getClass().getResource("/br/com/mercado/reports/MyReports/clientes.jasper");
        Relatorio.chamarRelatorio(jasperFile.getPath());

    }//GEN-LAST:event_menuItemRelatorioClientesActionPerformed

    private void menuItemRelatorioCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRelatorioCategoriasActionPerformed
        // TODO add your handling code here:
        URL jasperFile = getClass().getResource("/br/com/mercado/reports/MyReports/clientes.jasper");
        Relatorio.chamarRelatorio(jasperFile.getPath());
    }//GEN-LAST:event_menuItemRelatorioCategoriasActionPerformed

    private void menuItemRelatorioReceitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRelatorioReceitasActionPerformed
        // TODO add your handling code here:
        URL jasperFile = getClass().getResource("/br/com/mercado/reports/MyReports/receitas.jasper");
        Relatorio.chamarRelatorio(jasperFile.getPath());
    }//GEN-LAST:event_menuItemRelatorioReceitasActionPerformed

    private void menuItemRelatorioDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRelatorioDespesasActionPerformed
        // TODO add your handling code here:
        URL jasperFile = getClass().getResource("/br/com/mercado/reports/MyReports/despesas.jasper");
        Relatorio.chamarRelatorio(jasperFile.getPath());
    }//GEN-LAST:event_menuItemRelatorioDespesasActionPerformed

    private void menuItemRelatorioFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRelatorioFornecedoresActionPerformed
        // TODO add your handling code here:
        URL jasperFile = getClass().getResource("/br/com/mercado/reports/MyReports/fornecedores.jasper");
        Relatorio.chamarRelatorio(jasperFile.getPath());
    }//GEN-LAST:event_menuItemRelatorioFornecedoresActionPerformed

    private void menuItemRelatorioProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRelatorioProdutosActionPerformed
        // TODO add your handling code here:
        URL jasperFile = getClass().getResource("/br/com/mercado/reports/MyReports/produtos.jasper");
        Relatorio.chamarRelatorio(jasperFile.getPath());
    }//GEN-LAST:event_menuItemRelatorioProdutosActionPerformed

    private void menuConfiguracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConfiguracaoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_menuConfiguracaoActionPerformed

    private void menuConfiguracaoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuConfiguracaoMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_menuConfiguracaoMouseReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        telaPrincipalControl.chamarTelaConfiguracaoGerenciarAction();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final javax.swing.JDesktopPane desktopPane = new javax.swing.JDesktopPane();
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu menuClientes;
    private javax.swing.JMenu menuConfiguracao;
    private javax.swing.JMenu menuFinanceiro;
    private javax.swing.JMenu menuFornecedores;
    private javax.swing.JMenuItem menuItemAjuda;
    private javax.swing.JMenuItem menuItemDespesa;
    private javax.swing.JMenuItem menuItemEntradaProduto;
    private javax.swing.JMenuItem menuItemGerenciarCategoria;
    private javax.swing.JMenuItem menuItemGerenciarCliente;
    private javax.swing.JMenuItem menuItemGerenciarFornecedor;
    private javax.swing.JMenuItem menuItemGerenciarFuncionario;
    private javax.swing.JMenuItem menuItemGerenciarProduto;
    private javax.swing.JMenuItem menuItemGerenciarTipoUsuario;
    private javax.swing.JMenuItem menuItemReceita;
    private javax.swing.JMenuItem menuItemRelatorioCategorias;
    private javax.swing.JMenuItem menuItemRelatorioClientes;
    private javax.swing.JMenuItem menuItemRelatorioDespesas;
    private javax.swing.JMenuItem menuItemRelatorioFornecedores;
    private javax.swing.JMenuItem menuItemRelatorioProdutos;
    private javax.swing.JMenuItem menuItemRelatorioReceitas;
    private javax.swing.JMenuItem menuItemSobre;
    private javax.swing.JMenuItem menuItemVenda;
    private javax.swing.JMenu menuProdutos;
    private javax.swing.JMenu menuSobre;
    private javax.swing.JMenu menuUsuario;
    // End of variables declaration//GEN-END:variables
}
