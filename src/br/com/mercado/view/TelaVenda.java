package br.com.mercado.view;

import br.com.mercado.control.TelaVendaControl;
import br.com.mercado.model.Usuario;
import br.com.mercado.uteis.InterfaceJanela;
import br.com.mercado.uteis.UtilTable;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author william.mauro
 */
public class TelaVenda extends javax.swing.JInternalFrame {

    TelaVendaControl vendaControl;

    /**
     * Creates new form TelaVenda
     */
    public TelaVenda() {
        initComponents();
    }

    public TelaVenda(TelaVendaControl control) {
        initComponents();
        vendaControl = control;
        InterfaceJanela.centralizarInternalFrame(this);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        cbCliente = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cbUsuario = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVenda = new javax.swing.JTable();
        btRemoverItemVenda = new javax.swing.JButton();
        btGravarVenda = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfPesquisaProduto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        brAdicionarItemVenda = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        tfQuantidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfValor = new javax.swing.JTextField();
        btBuscarProduto = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("CLIENTE:");

        cbCliente.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText("USUÁRIO:");

        cbUsuario.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        tblVenda.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tblVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblVenda);

        btRemoverItemVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/remover_24x24.png"))); // NOI18N
        btRemoverItemVenda.setToolTipText("Remover produto da lista...");
        btRemoverItemVenda.setBorder(null);
        btRemoverItemVenda.setBorderPainted(false);
        btRemoverItemVenda.setContentAreaFilled(false);
        btRemoverItemVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverItemVendaActionPerformed(evt);
            }
        });

        btGravarVenda.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btGravarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/save_32x32.png"))); // NOI18N
        btGravarVenda.setText("Gravar");
        btGravarVenda.setToolTipText("Gravar venda...");
        btGravarVenda.setBorder(null);
        btGravarVenda.setBorderPainted(false);
        btGravarVenda.setContentAreaFilled(false);
        btGravarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarVendaActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Tela de Venda");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(197, 197, 197))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        tfPesquisaProduto.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tfPesquisaProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPesquisaProdutoKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("BUSCAR:");

        tblProduto.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblProdutoMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblProduto);

        brAdicionarItemVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/add_32x32.png"))); // NOI18N
        brAdicionarItemVenda.setBorder(null);
        brAdicionarItemVenda.setBorderPainted(false);
        brAdicionarItemVenda.setContentAreaFilled(false);
        brAdicionarItemVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brAdicionarItemVendaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("QUANTIDADE:");

        tfQuantidade.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setText("VALOR:");

        tfValor.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        btBuscarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/lupa_32x32.png"))); // NOI18N
        btBuscarProduto.setText("Buscar");
        btBuscarProduto.setBorder(null);
        btBuscarProduto.setBorderPainted(false);
        btBuscarProduto.setContentAreaFilled(false);
        btBuscarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarProdutoActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/more_32x32.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mercado/img/more_32x32.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
            .addComponent(jSeparator2)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btGravarVenda)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btRemoverItemVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbCliente, 0, 196, Short.MAX_VALUE)
                            .addComponent(cbUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(brAdicionarItemVenda)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btBuscarProduto)
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarProduto))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(brAdicionarItemVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btRemoverItemVenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btGravarVenda)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void brAdicionarItemVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brAdicionarItemVendaActionPerformed
        vendaControl.adicionarItemVendaAction();
    }//GEN-LAST:event_brAdicionarItemVendaActionPerformed

    private void btRemoverItemVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverItemVendaActionPerformed
        // TODO add your handling code here:
        vendaControl.removerItemVendaAction();
    }//GEN-LAST:event_btRemoverItemVendaActionPerformed

    private void btGravarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarVendaActionPerformed
        // TODO add your handling code here:
        vendaControl.chamarDialogVendaReceitaAction();
    }//GEN-LAST:event_btGravarVendaActionPerformed

    private void tblProdutoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutoMousePressed
        // TODO add your handling code here:
      int row =  UtilTable.pegaLinhaComDoubleClick(evt);
      vendaControl.carregaProdutoSelecionadoAction(row);
    }//GEN-LAST:event_tblProdutoMousePressed

    private void btBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarProdutoActionPerformed
        // TODO add your handling code here:
        vendaControl.pesquisarProdutoAction();
    }//GEN-LAST:event_btBuscarProdutoActionPerformed

    private void tfPesquisaProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaProdutoKeyReleased
        // TODO add your handling code here:
        vendaControl.pesquisarProdutoAction();
    }//GEN-LAST:event_tfPesquisaProdutoKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        vendaControl.chamarDialogClienteAction();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brAdicionarItemVenda;
    private javax.swing.JButton btBuscarProduto;
    private javax.swing.JButton btGravarVenda;
    private javax.swing.JButton btRemoverItemVenda;
    private javax.swing.JComboBox cbCliente;
    private javax.swing.JComboBox<Usuario> cbUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblProduto;
    private javax.swing.JTable tblVenda;
    private javax.swing.JTextField tfPesquisaProduto;
    private javax.swing.JTextField tfQuantidade;
    private javax.swing.JTextField tfValor;
    // End of variables declaration//GEN-END:variables

    public JComboBox getCbCliente() {
        return cbCliente;
    }

    public void setCbCliente(JComboBox cbCliente) {
        this.cbCliente = cbCliente;
    }

    public JTable getTblVenda() {
        return tblVenda;
    }

    public void setTblVenda(JTable tblVenda) {
        this.tblVenda = tblVenda;
    }

    public JComboBox<Usuario> getCbUsuario() {
        return cbUsuario;
    }

    public void setCbUsuario(JComboBox<Usuario> cbUsuario) {
        this.cbUsuario = cbUsuario;
    }

    public JTable getTblProduto() {
        return tblProduto;
    }

    public void setTblProduto(JTable tblProduto) {
        this.tblProduto = tblProduto;
    }

    public JTextField getTfPesquisaProduto() {
        return tfPesquisaProduto;
    }

    public void setTfPesquisaProduto(JTextField tfPesquisaProduto) {
        this.tfPesquisaProduto = tfPesquisaProduto;
    }

    public JTextField getTfQuantidade() {
        return tfQuantidade;
    }

    public void setTfQuantidade(JTextField tfQuantidade) {
        this.tfQuantidade = tfQuantidade;
    }

    public JTextField getTfValor() {
        return tfValor;
    }

    public void setTfValor(JTextField tfValor) {
        this.tfValor = tfValor;
    }
    
}
