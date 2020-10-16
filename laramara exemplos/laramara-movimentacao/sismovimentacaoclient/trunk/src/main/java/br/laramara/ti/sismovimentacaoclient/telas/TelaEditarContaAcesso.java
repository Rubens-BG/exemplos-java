package br.laramara.ti.sismovimentacaoclient.telas;

import br.laramara.ti.sismovimentacaoclient.controladores.ControladorTelaEditarContaAcesso;
import br.laramara.ti.sismovimentacaoclient.infra.PermissaoDeTelas;
import br.laramara.ti.sismovimentacaocommons.dtos.seguranca.ContaAcessoDTO;
import javax.swing.JDialog;

public class TelaEditarContaAcesso extends JDialog {

    /** Creates new form TelaEditarContaAcesso */
    public TelaEditarContaAcesso(JDialog telaPai, ContaAcessoDTO contaAcessoDto) {
        super(telaPai, true);
        initComponents();
        setLocationRelativeTo(telaPai);
        controlador = new ControladorTelaEditarContaAcesso(this, contaAcessoDto, jtfLogin, jtfSenha, jcbPerfil, jchBloqueado, jcbProfissional, jepChaves);
        controlador.abrirSomenteSeHouverPermissao(PermissaoDeTelas.CONTA_ACESSO_TELA_EDICAO_VISUALIZAR);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpaEditarContaAcesso = new javax.swing.JPanel();
        jlaLogin = new javax.swing.JLabel();
        jtfLogin = new javax.swing.JTextField();
        jlaPerfil = new javax.swing.JLabel();
        jcbPerfil = new javax.swing.JComboBox();
        jchBloqueado = new javax.swing.JCheckBox();
        jbuSalvar = new javax.swing.JButton();
        jbuFechar = new javax.swing.JButton();
        jlaSenha = new javax.swing.JLabel();
        jtfSenha = new javax.swing.JTextField();
        jlaProfissional = new javax.swing.JLabel();
        jcbProfissional = new javax.swing.JComboBox();
        jlaChaves = new javax.swing.JLabel();
        jspChaves = new javax.swing.JScrollPane();
        jepChaves = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(br.laramara.ti.sismovimentacaoclient.telas.SisMovimentacaoClient.class).getContext().getResourceMap(TelaEditarContaAcesso.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setModal(true);
        setName("Form"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jpaEditarContaAcesso.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("jpaEditarContaAcesso.border.lineColor"))); // NOI18N
        jpaEditarContaAcesso.setName("jpaEditarContaAcesso"); // NOI18N
        jpaEditarContaAcesso.setLayout(null);

        jlaLogin.setText(resourceMap.getString("jlaLogin.text")); // NOI18N
        jlaLogin.setName("jlaLogin"); // NOI18N
        jpaEditarContaAcesso.add(jlaLogin);
        jlaLogin.setBounds(10, 30, 90, 14);

        jtfLogin.setText(resourceMap.getString("jtfLogin.text")); // NOI18N
        jtfLogin.setName("jtfLogin"); // NOI18N
        jpaEditarContaAcesso.add(jtfLogin);
        jtfLogin.setBounds(10, 50, 260, 20);
        jtfLogin.getAccessibleContext().setAccessibleName(resourceMap.getString("jtfLogin.AccessibleContext.accessibleName")); // NOI18N

        jlaPerfil.setText(resourceMap.getString("jlaPerfil.text")); // NOI18N
        jlaPerfil.setName("jlaPerfil"); // NOI18N
        jpaEditarContaAcesso.add(jlaPerfil);
        jlaPerfil.setBounds(10, 80, 110, 14);

        jcbPerfil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jcbPerfil.setName("jcbPerfil"); // NOI18N
        jpaEditarContaAcesso.add(jcbPerfil);
        jcbPerfil.setBounds(10, 100, 260, 22);
        jcbPerfil.getAccessibleContext().setAccessibleName(resourceMap.getString("jComboBox1.AccessibleContext.accessibleName")); // NOI18N

        jchBloqueado.setText(resourceMap.getString("jchBloqueado.text")); // NOI18N
        jchBloqueado.setName("jchBloqueado"); // NOI18N
        jpaEditarContaAcesso.add(jchBloqueado);
        jchBloqueado.setBounds(280, 100, 120, 23);

        jbuSalvar.setIcon(resourceMap.getIcon("jbuSalvar.icon")); // NOI18N
        jbuSalvar.setMnemonic('s');
        jbuSalvar.setText(resourceMap.getString("jbuSalvar.text")); // NOI18N
        jbuSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbuSalvar.setName("jbuSalvar"); // NOI18N
        jbuSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuSalvarActionPerformed(evt);
            }
        });
        jpaEditarContaAcesso.add(jbuSalvar);
        jbuSalvar.setBounds(10, 310, 130, 40);

        jbuFechar.setIcon(resourceMap.getIcon("jbuFechar.icon")); // NOI18N
        jbuFechar.setMnemonic('f');
        jbuFechar.setText(resourceMap.getString("jbuFechar.text")); // NOI18N
        jbuFechar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbuFechar.setName("jbuFechar"); // NOI18N
        jbuFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuFecharActionPerformed(evt);
            }
        });
        jpaEditarContaAcesso.add(jbuFechar);
        jbuFechar.setBounds(420, 310, 120, 40);

        jlaSenha.setText(resourceMap.getString("jlaSenha.text")); // NOI18N
        jlaSenha.setName("jlaSenha"); // NOI18N
        jpaEditarContaAcesso.add(jlaSenha);
        jlaSenha.setBounds(280, 30, 70, 14);

        jtfSenha.setText(resourceMap.getString("jtfSenha.text")); // NOI18N
        jtfSenha.setName("jtfSenha"); // NOI18N
        jpaEditarContaAcesso.add(jtfSenha);
        jtfSenha.setBounds(280, 50, 260, 20);
        jtfSenha.getAccessibleContext().setAccessibleName(resourceMap.getString("jTextField1.AccessibleContext.accessibleName")); // NOI18N

        jlaProfissional.setText(resourceMap.getString("jlaProfissional.text")); // NOI18N
        jlaProfissional.setName("jlaProfissional"); // NOI18N
        jpaEditarContaAcesso.add(jlaProfissional);
        jlaProfissional.setBounds(10, 130, 110, 14);

        jcbProfissional.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jcbProfissional.setName("jcbProfissional"); // NOI18N
        jpaEditarContaAcesso.add(jcbProfissional);
        jcbProfissional.setBounds(10, 150, 530, 22);

        jlaChaves.setText(resourceMap.getString("jlaChaves.text")); // NOI18N
        jlaChaves.setName("jlaChaves"); // NOI18N
        jpaEditarContaAcesso.add(jlaChaves);
        jlaChaves.setBounds(10, 180, 520, 14);

        jspChaves.setName("jspChaves"); // NOI18N

        jepChaves.setName("jepChaves"); // NOI18N
        jspChaves.setViewportView(jepChaves);

        jpaEditarContaAcesso.add(jspChaves);
        jspChaves.setBounds(10, 200, 530, 100);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpaEditarContaAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpaEditarContaAcesso, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbuFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuFecharActionPerformed
        controlador.fecharTela();
    }//GEN-LAST:event_jbuFecharActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controlador.fecharTela();
    }//GEN-LAST:event_formWindowClosing

    private void jbuSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuSalvarActionPerformed
        controlador.salvar();
    }//GEN-LAST:event_jbuSalvarActionPerformed
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbuFechar;
    private javax.swing.JButton jbuSalvar;
    private javax.swing.JComboBox jcbPerfil;
    private javax.swing.JComboBox jcbProfissional;
    private javax.swing.JCheckBox jchBloqueado;
    private javax.swing.JEditorPane jepChaves;
    private javax.swing.JLabel jlaChaves;
    private javax.swing.JLabel jlaLogin;
    private javax.swing.JLabel jlaPerfil;
    private javax.swing.JLabel jlaProfissional;
    private javax.swing.JLabel jlaSenha;
    private javax.swing.JPanel jpaEditarContaAcesso;
    private javax.swing.JScrollPane jspChaves;
    private javax.swing.JTextField jtfLogin;
    private javax.swing.JTextField jtfSenha;
    // End of variables declaration//GEN-END:variables
    private ControladorTelaEditarContaAcesso controlador;
}
