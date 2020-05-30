package br.laramara.ti.sislaraclient.telas;

import br.laramara.ti.sislaraclient.controladores.ControladorTelaUtilizar;
import javax.swing.JDialog;

public abstract class TelaUtilizar extends TelaPesquisar {

    /** Creates new form TelaUtilizar */
    public TelaUtilizar(String titulo, JDialog parent) {
        super(parent);
        initComponents();
        setLocationRelativeTo(parent);
        configurarTituloETabela(titulo);
        controlador = obterControlador();
        controlador.abrirTela();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpaTelaUtilizar = new javax.swing.JPanel();
        jpaSuperior = new javax.swing.JPanel();
        jlaTitulo = new javax.swing.JLabel();
        jbuFecharTitulo = new javax.swing.JButton();
        jlaPesquisarPor = new javax.swing.JLabel();
        jcbTipoPesquisa = new javax.swing.JComboBox();
        jlaDadosPesquisar = new javax.swing.JLabel();
        jtfDadosPesquisar = new javax.swing.JTextField();
        jbuPesquisar = new javax.swing.JButton();
        jlaListagem = new javax.swing.JLabel();
        jspListagem = new javax.swing.JScrollPane();
        jtaListagem = new javax.swing.JTable();
        jbuUtilizar = new javax.swing.JButton();
        jbuFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(br.laramara.ti.sislaraclient.telas.SisLaraClient.class).getContext().getResourceMap(TelaUtilizar.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        jpaTelaUtilizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpaTelaUtilizar.setName("jpaTelaUtilizar"); // NOI18N
        jpaTelaUtilizar.setLayout(null);

        jpaSuperior.setBackground(resourceMap.getColor("jpaSuperior.background")); // NOI18N
        jpaSuperior.setName("jpaSuperior"); // NOI18N
        jpaSuperior.setPreferredSize(new java.awt.Dimension(400, 36));

        jlaTitulo.setBackground(resourceMap.getColor("jlaTitulo.background")); // NOI18N
        jlaTitulo.setFont(resourceMap.getFont("jlaTitulo.font")); // NOI18N
        jlaTitulo.setForeground(resourceMap.getColor("jlaTitulo.foreground")); // NOI18N
        jlaTitulo.setText(resourceMap.getString("jlaTitulo.text")); // NOI18N
        jlaTitulo.setName("jlaTitulo"); // NOI18N

        jbuFecharTitulo.setBackground(resourceMap.getColor("jbuFecharTitulo.background")); // NOI18N
        jbuFecharTitulo.setIcon(resourceMap.getIcon("jbuFecharTitulo.icon")); // NOI18N
        jbuFecharTitulo.setText(resourceMap.getString("jbuFecharTitulo.text")); // NOI18N
        jbuFecharTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbuFecharTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbuFecharTitulo.setFocusable(false);
        jbuFecharTitulo.setName("jbuFecharTitulo"); // NOI18N
        jbuFecharTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuFecharTituloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpaSuperiorLayout = new javax.swing.GroupLayout(jpaSuperior);
        jpaSuperior.setLayout(jpaSuperiorLayout);
        jpaSuperiorLayout.setHorizontalGroup(
            jpaSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpaSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlaTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 530, Short.MAX_VALUE)
                .addComponent(jbuFecharTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpaSuperiorLayout.setVerticalGroup(
            jpaSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpaSuperiorLayout.createSequentialGroup()
                .addGroup(jpaSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlaTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jbuFecharTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, Short.MAX_VALUE))
                .addContainerGap())
        );

        jpaTelaUtilizar.add(jpaSuperior);
        jpaSuperior.setBounds(1, 1, 780, 27);

        jlaPesquisarPor.setFont(resourceMap.getFont("jlaPesquisarPor.font")); // NOI18N
        jlaPesquisarPor.setText(resourceMap.getString("jlaPesquisarPor.text")); // NOI18N
        jlaPesquisarPor.setName("jlaPesquisarPor"); // NOI18N
        jpaTelaUtilizar.add(jlaPesquisarPor);
        jlaPesquisarPor.setBounds(10, 40, 200, 17);
        jlaPesquisarPor.getAccessibleContext().setAccessibleName(resourceMap.getString("jlaPesquisarPor.AccessibleContext.accessibleName")); // NOI18N

        jcbTipoPesquisa.setFont(resourceMap.getFont("jlaPesquisarPor.font")); // NOI18N
        jcbTipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jcbTipoPesquisa.setName("jcbTipoPesquisa"); // NOI18N
        jpaTelaUtilizar.add(jcbTipoPesquisa);
        jcbTipoPesquisa.setBounds(10, 60, 200, 25);
        jcbTipoPesquisa.getAccessibleContext().setAccessibleName(resourceMap.getString("jcbPesquisarPor.AccessibleContext.accessibleName")); // NOI18N

        jlaDadosPesquisar.setFont(resourceMap.getFont("jlaPesquisarPor.font")); // NOI18N
        jlaDadosPesquisar.setText(resourceMap.getString("jlaDadosPesquisar.text")); // NOI18N
        jlaDadosPesquisar.setName("jlaDadosPesquisar"); // NOI18N
        jpaTelaUtilizar.add(jlaDadosPesquisar);
        jlaDadosPesquisar.setBounds(220, 40, 151, 17);

        jtfDadosPesquisar.setFont(resourceMap.getFont("jlaPesquisarPor.font")); // NOI18N
        jtfDadosPesquisar.setText(resourceMap.getString("jtfDadosPesquisar.text")); // NOI18N
        jtfDadosPesquisar.setName("jtfDadosPesquisar"); // NOI18N
        jpaTelaUtilizar.add(jtfDadosPesquisar);
        jtfDadosPesquisar.setBounds(220, 60, 400, 23);
        jtfDadosPesquisar.getAccessibleContext().setAccessibleName(resourceMap.getString("jtfDadosPesquisar.AccessibleContext.accessibleName")); // NOI18N

        jbuPesquisar.setFont(resourceMap.getFont("jlaPesquisarPor.font")); // NOI18N
        jbuPesquisar.setIcon(resourceMap.getIcon("jbuPesquisar.icon")); // NOI18N
        jbuPesquisar.setMnemonic('P');
        jbuPesquisar.setText(resourceMap.getString("jbuPesquisar.text")); // NOI18N
        jbuPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbuPesquisar.setName("jbuPesquisar"); // NOI18N
        jbuPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuPesquisarActionPerformed(evt);
            }
        });
        jpaTelaUtilizar.add(jbuPesquisar);
        jbuPesquisar.setBounds(633, 60, 140, 33);

        jlaListagem.setFont(resourceMap.getFont("jlaListagem.font")); // NOI18N
        jlaListagem.setText(resourceMap.getString("jlaListagem.text")); // NOI18N
        jlaListagem.setName("jlaListagem"); // NOI18N
        jpaTelaUtilizar.add(jlaListagem);
        jlaListagem.setBounds(10, 90, 190, 17);

        jspListagem.setName("jspListagem"); // NOI18N

        jtaListagem.setAutoCreateRowSorter(true);
        jtaListagem.setFont(resourceMap.getFont("jtaListagem.font")); // NOI18N
        jtaListagem.setModel(obterModeloTabela());
        jtaListagem.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtaListagem.setName("jtaListagem"); // NOI18N
        jtaListagem.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtaListagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtaListagemKeyPressed(evt);
            }
        });
        jspListagem.setViewportView(jtaListagem);
        jtaListagem.getAccessibleContext().setAccessibleName(resourceMap.getString("jtaListagem.AccessibleContext.accessibleName")); // NOI18N

        jpaTelaUtilizar.add(jspListagem);
        jspListagem.setBounds(10, 110, 760, 160);

        jbuUtilizar.setFont(resourceMap.getFont("jbuUtilizar.font")); // NOI18N
        jbuUtilizar.setIcon(resourceMap.getIcon("jbuUtilizar.icon")); // NOI18N
        jbuUtilizar.setMnemonic('U');
        jbuUtilizar.setText(resourceMap.getString("jbuUtilizar.text")); // NOI18N
        jbuUtilizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbuUtilizar.setName("jbuUtilizar"); // NOI18N
        jbuUtilizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuUtilizarActionPerformed(evt);
            }
        });
        jpaTelaUtilizar.add(jbuUtilizar);
        jbuUtilizar.setBounds(10, 280, 150, 33);
        jbuUtilizar.getAccessibleContext().setAccessibleName(resourceMap.getString("jbuUtilizar.AccessibleContext.accessibleName")); // NOI18N

        jbuFechar.setFont(resourceMap.getFont("jbuFechar.font")); // NOI18N
        jbuFechar.setIcon(resourceMap.getIcon("jbuFechar.icon")); // NOI18N
        jbuFechar.setMnemonic('F');
        jbuFechar.setText(resourceMap.getString("jbuFechar.text")); // NOI18N
        jbuFechar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbuFechar.setName("jbuFechar"); // NOI18N
        jbuFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuFecharActionPerformed(evt);
            }
        });
        jpaTelaUtilizar.add(jbuFechar);
        jbuFechar.setBounds(653, 280, 120, 33);
        jbuFechar.getAccessibleContext().setAccessibleName(resourceMap.getString("jbuFechar.AccessibleContext.accessibleName")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpaTelaUtilizar, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpaTelaUtilizar, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jbuFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuFecharActionPerformed
        controlador.fecharTela();
}//GEN-LAST:event_jbuFecharActionPerformed

private void jbuFecharTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuFecharTituloActionPerformed
        controlador.fecharTela();
}//GEN-LAST:event_jbuFecharTituloActionPerformed

private void jbuPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuPesquisarActionPerformed
        controlador.efetuarPesquisa();
}//GEN-LAST:event_jbuPesquisarActionPerformed

private void jtaListagemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtaListagemKeyPressed
        controlador.moverFocoNaTabulacaoOuUtilizar(evt);
}//GEN-LAST:event_jtaListagemKeyPressed

private void jbuUtilizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuUtilizarActionPerformed
        controlador.utilizar();
}//GEN-LAST:event_jbuUtilizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbuFechar;
    private javax.swing.JButton jbuFecharTitulo;
    private javax.swing.JButton jbuPesquisar;
    private javax.swing.JButton jbuUtilizar;
    protected javax.swing.JComboBox jcbTipoPesquisa;
    private javax.swing.JLabel jlaDadosPesquisar;
    private javax.swing.JLabel jlaListagem;
    private javax.swing.JLabel jlaPesquisarPor;
    private javax.swing.JLabel jlaTitulo;
    private javax.swing.JPanel jpaSuperior;
    private javax.swing.JPanel jpaTelaUtilizar;
    private javax.swing.JScrollPane jspListagem;
    protected javax.swing.JTable jtaListagem;
    protected javax.swing.JTextField jtfDadosPesquisar;
    // End of variables declaration//GEN-END:variables
    private ControladorTelaUtilizar controlador;

    private void configurarTituloETabela(String titulo){
        jlaTitulo.setText("Utilizar Informações de " + titulo);
        jtaListagem.getAccessibleContext().setAccessibleName("Resultado da pesquisa de " + titulo);
        jbuUtilizar.getAccessibleContext().setAccessibleName("Utilizar " + titulo);
    }
    
    protected abstract ControladorTelaUtilizar obterControlador();
}
