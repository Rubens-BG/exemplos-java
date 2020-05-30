package br.laramara.ti.sismovimentacaoclient.telas;

import br.laramara.ti.sismovimentacaoclient.controladores.ControladorTelaEditarSenha;
import javax.swing.JFrame;

public class TelaEditarSenha extends javax.swing.JDialog {

    /** Creates new form TelaEditarSenha */
    public TelaEditarSenha(JFrame parent) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(parent);
        controlador = new ControladorTelaEditarSenha(this, jpfNovaSenha, jpfConfirmacaoSenha);
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

        jpaEditarSenha = new javax.swing.JPanel();
        jlaNovaSenha = new javax.swing.JLabel();
        jpfNovaSenha = new javax.swing.JPasswordField();
        jlaConfirmacaoSenha = new javax.swing.JLabel();
        jpfConfirmacaoSenha = new javax.swing.JPasswordField();
        jbuSalvar = new javax.swing.JButton();
        jbuFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(br.laramara.ti.sismovimentacaoclient.telas.SisMovimentacaoClient.class).getContext().getResourceMap(TelaEditarSenha.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setModal(true);
        setName("Form"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jpaEditarSenha.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("jpaEditarSenha.border.lineColor"))); // NOI18N
        jpaEditarSenha.setName("jpaEditarSenha"); // NOI18N

        jlaNovaSenha.setText(resourceMap.getString("jlaNovaSenha.text")); // NOI18N
        jlaNovaSenha.setName("jlaNovaSenha"); // NOI18N

        jpfNovaSenha.setText(resourceMap.getString("jpfNovaSenha.text")); // NOI18N
        jpfNovaSenha.setName("jpfNovaSenha"); // NOI18N

        jlaConfirmacaoSenha.setText(resourceMap.getString("jlaConfirmacaoSenha.text")); // NOI18N
        jlaConfirmacaoSenha.setName("jlaConfirmacaoSenha"); // NOI18N

        jpfConfirmacaoSenha.setText(resourceMap.getString("jpfConfirmacaoSenha.text")); // NOI18N
        jpfConfirmacaoSenha.setName("jpfConfirmacaoSenha"); // NOI18N

        jbuSalvar.setIcon(resourceMap.getIcon("jbuSalvar.icon")); // NOI18N
        jbuSalvar.setMnemonic('S');
        jbuSalvar.setText(resourceMap.getString("jbuSalvar.text")); // NOI18N
        jbuSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbuSalvar.setName("jbuSalvar"); // NOI18N
        jbuSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuSalvarActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jpaEditarSenhaLayout = new javax.swing.GroupLayout(jpaEditarSenha);
        jpaEditarSenha.setLayout(jpaEditarSenhaLayout);
        jpaEditarSenhaLayout.setHorizontalGroup(
            jpaEditarSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpaEditarSenhaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpaEditarSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpaEditarSenhaLayout.createSequentialGroup()
                        .addComponent(jlaConfirmacaoSenha)
                        .addGap(184, 184, 184))
                    .addGroup(jpaEditarSenhaLayout.createSequentialGroup()
                        .addGroup(jpaEditarSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpaEditarSenhaLayout.createSequentialGroup()
                                .addComponent(jlaNovaSenha)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jpaEditarSenhaLayout.createSequentialGroup()
                                .addComponent(jbuSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                                .addComponent(jbuFechar))
                            .addComponent(jpfNovaSenha)
                            .addComponent(jpfConfirmacaoSenha, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        jpaEditarSenhaLayout.setVerticalGroup(
            jpaEditarSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpaEditarSenhaLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jlaNovaSenha)
                .addGap(4, 4, 4)
                .addComponent(jpfNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlaConfirmacaoSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpfConfirmacaoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jpaEditarSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbuFechar)
                    .addComponent(jbuSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpaEditarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpaEditarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbuFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuFecharActionPerformed
        controlador.fecharTela();        // TODO add your handling code here:
    }//GEN-LAST:event_jbuFecharActionPerformed

    private void jbuSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuSalvarActionPerformed
        controlador.alterarSenha();
    }//GEN-LAST:event_jbuSalvarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        controlador.fecharTela();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbuFechar;
    private javax.swing.JButton jbuSalvar;
    private javax.swing.JLabel jlaConfirmacaoSenha;
    private javax.swing.JLabel jlaNovaSenha;
    private javax.swing.JPanel jpaEditarSenha;
    private javax.swing.JPasswordField jpfConfirmacaoSenha;
    private javax.swing.JPasswordField jpfNovaSenha;
    // End of variables declaration//GEN-END:variables
    private ControladorTelaEditarSenha controlador;
}
