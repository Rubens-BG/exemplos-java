package br.laramara.ti.sislaraclient.telas;

import br.laramara.ti.sislaraclient.controladores.ControladorTelaAgendaEditarJustificativa;
import br.laramara.ti.sislaracommons.dtos.agenda.AgendamentoDTO;
import javax.swing.JDialog;

public abstract class TelaAgendaEditarJustificativa extends JDialog {

    public TelaAgendaEditarJustificativa (JDialog telaPai, AgendamentoDTO agendamentoDto) {
        super(telaPai, true);
        initComponents();
        setLocationRelativeTo(telaPai);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpaTelaAgendaEditarCancelar = new javax.swing.JPanel();
        jpaTitulo = new javax.swing.JPanel();
        jlaTitulo = new javax.swing.JLabel();
        jbuFecharTitulo = new javax.swing.JButton();
        jlaDataAgendamento = new javax.swing.JLabel();
        jtfDataAgendamento = new javax.swing.JTextField();
        jlaHoraInicio = new javax.swing.JLabel();
        jtfHoraInicio = new javax.swing.JTextField();
        jlaHoraTermino = new javax.swing.JLabel();
        jtfHoraTermino = new javax.swing.JTextField();
        jlaProfissional = new javax.swing.JLabel();
        jtfProfissional = new javax.swing.JTextField();
        jlaMotivo = new javax.swing.JLabel();
        jcbMotivo = new javax.swing.JComboBox();
        jlaJustificativa = new javax.swing.JLabel();
        jspJustificativa = new javax.swing.JScrollPane();
        jepJustificativa = new javax.swing.JEditorPane();
        jbuSalvar = new javax.swing.JButton();
        jbuFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(br.laramara.ti.sislaraclient.telas.SisLaraClient.class).getContext().getResourceMap(TelaAgendaEditarJustificativa.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        setUndecorated(true);

        jpaTelaAgendaEditarCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpaTelaAgendaEditarCancelar.setName("jpaTelaAgendaEditarCancelar"); // NOI18N
        jpaTelaAgendaEditarCancelar.setLayout(null);

        jpaTitulo.setBackground(resourceMap.getColor("jpaTitulo.background")); // NOI18N
        jpaTitulo.setName("jpaTitulo"); // NOI18N
        jpaTitulo.setLayout(null);

        jlaTitulo.setFont(resourceMap.getFont("jlaTitulo.font")); // NOI18N
        jlaTitulo.setForeground(resourceMap.getColor("jlaTitulo.foreground")); // NOI18N
        jlaTitulo.setText(resourceMap.getString("jlaTitulo.text")); // NOI18N
        jlaTitulo.setName("jlaTitulo"); // NOI18N
        jpaTitulo.add(jlaTitulo);
        jlaTitulo.setBounds(10, 0, 270, 26);

        jbuFecharTitulo.setBackground(resourceMap.getColor("jbuFecharTitulo.background")); // NOI18N
        jbuFecharTitulo.setIcon(resourceMap.getIcon("jbuFecharTitulo.icon")); // NOI18N
        jbuFecharTitulo.setText(resourceMap.getString("jbuFecharTitulo.text")); // NOI18N
        jbuFecharTitulo.setBorder(null);
        jbuFecharTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbuFecharTitulo.setFocusable(false);
        jbuFecharTitulo.setName("jbuFecharTitulo"); // NOI18N
        jbuFecharTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuFecharTituloActionPerformed(evt);
            }
        });
        jpaTitulo.add(jbuFecharTitulo);
        jbuFecharTitulo.setBounds(675, 0, 25, 25);

        jpaTelaAgendaEditarCancelar.add(jpaTitulo);
        jpaTitulo.setBounds(1, 1, 699, 26);

        jlaDataAgendamento.setFont(resourceMap.getFont("jlaDataAgendamento.font")); // NOI18N
        jlaDataAgendamento.setText(resourceMap.getString("jlaDataAgendamento.text")); // NOI18N
        jlaDataAgendamento.setName("jlaDataAgendamento"); // NOI18N
        jpaTelaAgendaEditarCancelar.add(jlaDataAgendamento);
        jlaDataAgendamento.setBounds(10, 30, 170, 17);

        jtfDataAgendamento.setEditable(false);
        jtfDataAgendamento.setFont(resourceMap.getFont("jtfDataAgendamento.font")); // NOI18N
        jtfDataAgendamento.setText(resourceMap.getString("jtfDataAgendamento.text")); // NOI18N
        jtfDataAgendamento.setName("jtfDataAgendamento"); // NOI18N
        jpaTelaAgendaEditarCancelar.add(jtfDataAgendamento);
        jtfDataAgendamento.setBounds(10, 50, 160, 23);
        jtfDataAgendamento.getAccessibleContext().setAccessibleName(resourceMap.getString("jtfDataAgendamento.AccessibleContext.accessibleName")); // NOI18N

        jlaHoraInicio.setFont(resourceMap.getFont("jlaDataAgendamento.font")); // NOI18N
        jlaHoraInicio.setText(resourceMap.getString("jlaHoraInicio.text")); // NOI18N
        jlaHoraInicio.setName("jlaHoraInicio"); // NOI18N
        jpaTelaAgendaEditarCancelar.add(jlaHoraInicio);
        jlaHoraInicio.setBounds(190, 30, 105, 17);

        jtfHoraInicio.setEditable(false);
        jtfHoraInicio.setFont(resourceMap.getFont("jtfDataAgendamento.font")); // NOI18N
        jtfHoraInicio.setText(resourceMap.getString("jtfHoraInicio.text")); // NOI18N
        jtfHoraInicio.setName("jtfHoraInicio"); // NOI18N
        jpaTelaAgendaEditarCancelar.add(jtfHoraInicio);
        jtfHoraInicio.setBounds(190, 50, 105, 23);
        jtfHoraInicio.getAccessibleContext().setAccessibleName(resourceMap.getString("jtfHoraInicial.AccessibleContext.accessibleName")); // NOI18N

        jlaHoraTermino.setFont(resourceMap.getFont("jlaDataAgendamento.font")); // NOI18N
        jlaHoraTermino.setText(resourceMap.getString("jlaHoraTermino.text")); // NOI18N
        jlaHoraTermino.setName("jlaHoraTermino"); // NOI18N
        jpaTelaAgendaEditarCancelar.add(jlaHoraTermino);
        jlaHoraTermino.setBounds(305, 30, 105, 17);

        jtfHoraTermino.setEditable(false);
        jtfHoraTermino.setFont(resourceMap.getFont("jtfDataAgendamento.font")); // NOI18N
        jtfHoraTermino.setText(resourceMap.getString("jtfHoraTermino.text")); // NOI18N
        jtfHoraTermino.setName("jtfHoraTermino"); // NOI18N
        jpaTelaAgendaEditarCancelar.add(jtfHoraTermino);
        jtfHoraTermino.setBounds(305, 50, 105, 23);
        jtfHoraTermino.getAccessibleContext().setAccessibleName(resourceMap.getString("jtfHoraTermino.AccessibleContext.accessibleName")); // NOI18N

        jlaProfissional.setFont(resourceMap.getFont("jlaDataAgendamento.font")); // NOI18N
        jlaProfissional.setText(resourceMap.getString("jlaProfissional.text")); // NOI18N
        jlaProfissional.setName("jlaProfissional"); // NOI18N
        jpaTelaAgendaEditarCancelar.add(jlaProfissional);
        jlaProfissional.setBounds(10, 90, 110, 17);

        jtfProfissional.setEditable(false);
        jtfProfissional.setFont(resourceMap.getFont("jtfDataAgendamento.font")); // NOI18N
        jtfProfissional.setText(resourceMap.getString("jtfProfissional.text")); // NOI18N
        jtfProfissional.setName("jtfProfissional"); // NOI18N
        jpaTelaAgendaEditarCancelar.add(jtfProfissional);
        jtfProfissional.setBounds(10, 110, 680, 23);
        jtfProfissional.getAccessibleContext().setAccessibleName(resourceMap.getString("jtfProfissional.AccessibleContext.accessibleName")); // NOI18N

        jlaMotivo.setFont(resourceMap.getFont("jlaMotivo.font")); // NOI18N
        jlaMotivo.setText(resourceMap.getString("jlaMotivo.text")); // NOI18N
        jlaMotivo.setName("jlaMotivo"); // NOI18N
        jpaTelaAgendaEditarCancelar.add(jlaMotivo);
        jlaMotivo.setBounds(10, 140, 290, 17);

        jcbMotivo.setFont(resourceMap.getFont("jcbMotivo.font")); // NOI18N
        jcbMotivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jcbMotivo.setName("jcbMotivo"); // NOI18N
        jpaTelaAgendaEditarCancelar.add(jcbMotivo);
        jcbMotivo.setBounds(10, 160, 680, 25);
        jcbMotivo.getAccessibleContext().setAccessibleName(resourceMap.getString("jcbMotivo.AccessibleContext.accessibleName")); // NOI18N

        jlaJustificativa.setFont(resourceMap.getFont("jlaJustificativa.font")); // NOI18N
        jlaJustificativa.setText(resourceMap.getString("jlaJustificativa.text")); // NOI18N
        jlaJustificativa.setName("jlaJustificativa"); // NOI18N
        jpaTelaAgendaEditarCancelar.add(jlaJustificativa);
        jlaJustificativa.setBounds(10, 190, 230, 17);

        jspJustificativa.setName("jspJustificativa"); // NOI18N

        jepJustificativa.setFont(resourceMap.getFont("jepJustificativa.font")); // NOI18N
        jepJustificativa.setName("jepJustificativa"); // NOI18N
        jspJustificativa.setViewportView(jepJustificativa);
        jepJustificativa.getAccessibleContext().setAccessibleName(resourceMap.getString("jepJustificativa.AccessibleContext.accessibleName")); // NOI18N
        jepJustificativa.getAccessibleContext().setAccessibleDescription(resourceMap.getString("jepJustificativa.AccessibleContext.accessibleDescription")); // NOI18N

        jpaTelaAgendaEditarCancelar.add(jspJustificativa);
        jspJustificativa.setBounds(10, 210, 680, 140);

        jbuSalvar.setFont(resourceMap.getFont("jbuFechar.font")); // NOI18N
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
        jpaTelaAgendaEditarCancelar.add(jbuSalvar);
        jbuSalvar.setBounds(10, 360, 120, 30);
        jbuSalvar.getAccessibleContext().setAccessibleName(resourceMap.getString("jbuSalvar.AccessibleContext.accessibleName")); // NOI18N

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
        jpaTelaAgendaEditarCancelar.add(jbuFechar);
        jbuFechar.setBounds(570, 360, 120, 30);
        jbuFechar.getAccessibleContext().setAccessibleName(resourceMap.getString("jbuFechar.AccessibleContext.accessibleName")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpaTelaAgendaEditarCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpaTelaAgendaEditarCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbuFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuFecharActionPerformed
        controlador.fecharTela();
    }//GEN-LAST:event_jbuFecharActionPerformed

    private void jbuFecharTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuFecharTituloActionPerformed
        controlador.fecharTela();
    }//GEN-LAST:event_jbuFecharTituloActionPerformed

    private void jbuSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuSalvarActionPerformed
        controlador.salvar();        
    }//GEN-LAST:event_jbuSalvarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbuFechar;
    private javax.swing.JButton jbuFecharTitulo;
    private javax.swing.JButton jbuSalvar;
    protected javax.swing.JComboBox jcbMotivo;
    protected javax.swing.JEditorPane jepJustificativa;
    private javax.swing.JLabel jlaDataAgendamento;
    private javax.swing.JLabel jlaHoraInicio;
    private javax.swing.JLabel jlaHoraTermino;
    private javax.swing.JLabel jlaJustificativa;
    private javax.swing.JLabel jlaMotivo;
    private javax.swing.JLabel jlaProfissional;
    private javax.swing.JLabel jlaTitulo;
    private javax.swing.JPanel jpaTelaAgendaEditarCancelar;
    private javax.swing.JPanel jpaTitulo;
    private javax.swing.JScrollPane jspJustificativa;
    protected javax.swing.JTextField jtfDataAgendamento;
    protected javax.swing.JTextField jtfHoraInicio;
    protected javax.swing.JTextField jtfHoraTermino;
    protected javax.swing.JTextField jtfProfissional;
    // End of variables declaration//GEN-END:variables
    protected ControladorTelaAgendaEditarJustificativa controlador;
}
