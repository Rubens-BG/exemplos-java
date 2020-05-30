package br.laramara.ti.sislaraclient.telas;

import br.laramara.ti.sislaraclient.controladores.ControladorTelaDemandaEditar;
import br.laramara.ti.sislaraclient.infra.PermissaoDeTelas;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;

public class TelaDemandaEditar extends JDialog {

    /**
     * Creates new form TelaDemanda
     */
    public TelaDemandaEditar(JDialog telaPai) {
        super(telaPai, true);
        initComponents();
        setLocationRelativeTo(telaPai);
        controlador = new ControladorTelaDemandaEditar(this, jcbRecurso, jliRecursosAdicionados, jchCartelaSeltos, jtfProntuario, jtfNomeUsuario, jftCpf, jtfNomePreCadastro, jcbNomeDocumentoAAdicionar, jbuAdicionarDocumento, jliDocumentoAdicionados);
        controlador.abrirSomenteSeHouverPermissao(PermissaoDeTelas.DEMANDA_EDICAO_VISUALIZAR);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpaDemandaEditar = new javax.swing.JPanel();
        jlaRecurso = new javax.swing.JLabel();
        jcbRecurso = new javax.swing.JComboBox();
        jspRecursosAdicionados = new javax.swing.JScrollPane();
        jliRecursosAdicionados = new javax.swing.JList<>();
        jlaRecursosAdicionados = new javax.swing.JLabel();
        jbuAdicionarRecurso = new javax.swing.JButton();
        jbuRemoverRecurso = new javax.swing.JButton();
        jchCartelaSeltos = new javax.swing.JCheckBox();
        jpaUsuario = new javax.swing.JPanel();
        jlaProntuario = new javax.swing.JLabel();
        jtfProntuario = new javax.swing.JTextField();
        jlaNomeUsuario = new javax.swing.JLabel();
        jtfNomeUsuario = new javax.swing.JTextField();
        jlaNomePreCadastro = new javax.swing.JLabel();
        jtfNomePreCadastro = new javax.swing.JTextField();
        jbuPesquisarPreCadastro = new javax.swing.JButton();
        jlaDocumento = new javax.swing.JLabel();
        jcbNomeDocumentoAAdicionar = new javax.swing.JComboBox<>();
        jbuAdicionarDocumento = new javax.swing.JButton();
        jlaDocumentosAdicionados = new javax.swing.JLabel();
        jspDocumentosAdicionados = new javax.swing.JScrollPane();
        jliDocumentoAdicionados = new javax.swing.JList();
        jbuAbrirDocumento = new javax.swing.JButton();
        jbuRemoverDocumento = new javax.swing.JButton();
        jbuSalvar = new javax.swing.JButton();
        jbuFechar = new javax.swing.JButton();
        jlaCpf = new javax.swing.JLabel();
        jftCpf = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(TelaDemandaEditar.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        setResizable(false);

        jpaDemandaEditar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpaDemandaEditar.setName("jpaDemandaEditar"); // NOI18N
        jpaDemandaEditar.setPreferredSize(new java.awt.Dimension(1028, 600));
        jpaDemandaEditar.setLayout(null);

        jlaRecurso.setFont(resourceMap.getFont("jlaProntuario.font")); // NOI18N
        jlaRecurso.setText(resourceMap.getString("jlaRecurso.text")); // NOI18N
        jlaRecurso.setName("jlaRecurso"); // NOI18N
        jpaDemandaEditar.add(jlaRecurso);
        jlaRecurso.setBounds(10, 10, 130, 17);

        jcbRecurso.setFont(resourceMap.getFont("jcbRecurso.font")); // NOI18N
        jcbRecurso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jcbRecurso.setName("jcbRecurso"); // NOI18N
        jpaDemandaEditar.add(jcbRecurso);
        jcbRecurso.setBounds(10, 30, 840, 25);
        jcbRecurso.getAccessibleContext().setAccessibleName(resourceMap.getString("jcbRecurso.AccessibleContext.accessibleName")); // NOI18N

        jspRecursosAdicionados.setName("jspRecursosAdicionados"); // NOI18N

        jliRecursosAdicionados.setFont(resourceMap.getFont("jliRecursosAdicionados.font")); // NOI18N
        jliRecursosAdicionados.setModel(new DefaultListModel());
        jliRecursosAdicionados.setName("jliRecursosAdicionados"); // NOI18N
        jspRecursosAdicionados.setViewportView(jliRecursosAdicionados);
        jliRecursosAdicionados.getAccessibleContext().setAccessibleName(resourceMap.getString("jliRecursosAdicionados.AccessibleContext.accessibleName")); // NOI18N

        jpaDemandaEditar.add(jspRecursosAdicionados);
        jspRecursosAdicionados.setBounds(10, 80, 840, 160);

        jlaRecursosAdicionados.setFont(resourceMap.getFont("jlaRecursosAdicionados.font")); // NOI18N
        jlaRecursosAdicionados.setText(resourceMap.getString("jlaRecursosAdicionados.text")); // NOI18N
        jlaRecursosAdicionados.setName("jlaRecursosAdicionados"); // NOI18N
        jpaDemandaEditar.add(jlaRecursosAdicionados);
        jlaRecursosAdicionados.setBounds(10, 60, 160, 17);

        jbuAdicionarRecurso.setFont(resourceMap.getFont("jbuAdicionarRecurso.font")); // NOI18N
        jbuAdicionarRecurso.setIcon(resourceMap.getIcon("jbuAdicionarRecurso.icon")); // NOI18N
        jbuAdicionarRecurso.setText(resourceMap.getString("jbuAdicionarRecurso.text")); // NOI18N
        jbuAdicionarRecurso.setName("jbuAdicionarRecurso"); // NOI18N
        jbuAdicionarRecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuAdicionarRecursoActionPerformed(evt);
            }
        });
        jpaDemandaEditar.add(jbuAdicionarRecurso);
        jbuAdicionarRecurso.setBounds(860, 30, 130, 33);

        jbuRemoverRecurso.setFont(resourceMap.getFont("jbuRemoverRecurso.font")); // NOI18N
        jbuRemoverRecurso.setIcon(resourceMap.getIcon("jbuRemoverRecurso.icon")); // NOI18N
        jbuRemoverRecurso.setText(resourceMap.getString("jbuRemoverRecurso.text")); // NOI18N
        jbuRemoverRecurso.setName("jbuRemoverRecurso"); // NOI18N
        jbuRemoverRecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuRemoverRecursoActionPerformed(evt);
            }
        });
        jpaDemandaEditar.add(jbuRemoverRecurso);
        jbuRemoverRecurso.setBounds(860, 80, 130, 33);

        jchCartelaSeltos.setFont(resourceMap.getFont("jchCartelaSeltos.font")); // NOI18N
        jchCartelaSeltos.setText(resourceMap.getString("jchCartelaSeltos.text")); // NOI18N
        jchCartelaSeltos.setName("jchCartelaSeltos"); // NOI18N
        jpaDemandaEditar.add(jchCartelaSeltos);
        jchCartelaSeltos.setBounds(10, 250, 160, 25);

        jpaUsuario.setName("jpaUsuario"); // NOI18N
        jpaUsuario.setOpaque(false);
        jpaUsuario.setLayout(null);

        jlaProntuario.setFont(resourceMap.getFont("jlaProntuario.font")); // NOI18N
        jlaProntuario.setText(resourceMap.getString("jlaProntuario.text")); // NOI18N
        jlaProntuario.setName("jlaProntuario"); // NOI18N
        jpaUsuario.add(jlaProntuario);
        jlaProntuario.setBounds(10, 0, 90, 17);

        jtfProntuario.setFont(resourceMap.getFont("jtfProntuario.font")); // NOI18N
        jtfProntuario.setText(resourceMap.getString("jtfProntuario.text")); // NOI18N
        jtfProntuario.setName("jtfProntuario"); // NOI18N
        jtfProntuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfProntuarioFocusLost(evt);
            }
        });
        jpaUsuario.add(jtfProntuario);
        jtfProntuario.setBounds(10, 20, 90, 23);
        jtfProntuario.getAccessibleContext().setAccessibleName(resourceMap.getString("jtfProntuario.AccessibleContext.accessibleName")); // NOI18N

        jlaNomeUsuario.setFont(resourceMap.getFont("jlaNomeUsuario.font")); // NOI18N
        jlaNomeUsuario.setText(resourceMap.getString("jlaNomeUsuario.text")); // NOI18N
        jlaNomeUsuario.setName("jlaNomeUsuario"); // NOI18N
        jpaUsuario.add(jlaNomeUsuario);
        jlaNomeUsuario.setBounds(110, 0, 110, 17);

        jtfNomeUsuario.setEditable(false);
        jtfNomeUsuario.setFont(resourceMap.getFont("jtfNomeUsuario.font")); // NOI18N
        jtfNomeUsuario.setText(resourceMap.getString("jtfNomeUsuario.text")); // NOI18N
        jtfNomeUsuario.setName("jtfNomeUsuario"); // NOI18N
        jpaUsuario.add(jtfNomeUsuario);
        jtfNomeUsuario.setBounds(110, 20, 370, 23);
        jtfNomeUsuario.getAccessibleContext().setAccessibleName(resourceMap.getString("jtfNomeUsuario.AccessibleContext.accessibleName")); // NOI18N

        jpaDemandaEditar.add(jpaUsuario);
        jpaUsuario.setBounds(0, 280, 500, 50);

        jlaNomePreCadastro.setFont(resourceMap.getFont("jlaNomePreCadastro.font")); // NOI18N
        jlaNomePreCadastro.setText(resourceMap.getString("jlaNomePreCadastro.text")); // NOI18N
        jlaNomePreCadastro.setName("jlaNomePreCadastro"); // NOI18N
        jpaDemandaEditar.add(jlaNomePreCadastro);
        jlaNomePreCadastro.setBounds(150, 330, 230, 17);

        jtfNomePreCadastro.setEditable(false);
        jtfNomePreCadastro.setFont(resourceMap.getFont("jtfNomePreCadastro.font")); // NOI18N
        jtfNomePreCadastro.setText(resourceMap.getString("jtfNomePreCadastro.text")); // NOI18N
        jtfNomePreCadastro.setName("jtfNomePreCadastro"); // NOI18N
        jpaDemandaEditar.add(jtfNomePreCadastro);
        jtfNomePreCadastro.setBounds(150, 350, 350, 23);
        jtfNomePreCadastro.getAccessibleContext().setAccessibleName(resourceMap.getString("jtfNomePreCadastro.AccessibleContext.accessibleName")); // NOI18N

        jbuPesquisarPreCadastro.setFont(resourceMap.getFont("jbuPesquisarPreCadastro.font")); // NOI18N
        jbuPesquisarPreCadastro.setIcon(resourceMap.getIcon("jbuPesquisarPreCadastro.icon")); // NOI18N
        jbuPesquisarPreCadastro.setText(resourceMap.getString("jbuPesquisarPreCadastro.text")); // NOI18N
        jbuPesquisarPreCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbuPesquisarPreCadastro.setName("jbuPesquisarPreCadastro"); // NOI18N
        jbuPesquisarPreCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuPesquisarPreCadastroActionPerformed(evt);
            }
        });
        jpaDemandaEditar.add(jbuPesquisarPreCadastro);
        jbuPesquisarPreCadastro.setBounds(510, 350, 140, 33);
        jbuPesquisarPreCadastro.getAccessibleContext().setAccessibleName(resourceMap.getString("jbuPesquisarPreCadastro.AccessibleContext.accessibleName")); // NOI18N

        jlaDocumento.setFont(resourceMap.getFont("jlaDocumento.font")); // NOI18N
        jlaDocumento.setText(resourceMap.getString("jlaDocumento.text")); // NOI18N
        jlaDocumento.setName("jlaDocumento"); // NOI18N
        jpaDemandaEditar.add(jlaDocumento);
        jlaDocumento.setBounds(10, 380, 170, 17);

        jcbNomeDocumentoAAdicionar.setFont(resourceMap.getFont("jcbNomeDocumentoAAdicionar.font")); // NOI18N
        jcbNomeDocumentoAAdicionar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jcbNomeDocumentoAAdicionar.setName("jcbNomeDocumentoAAdicionar"); // NOI18N
        jcbNomeDocumentoAAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbNomeDocumentoAAdicionarActionPerformed(evt);
            }
        });
        jpaDemandaEditar.add(jcbNomeDocumentoAAdicionar);
        jcbNomeDocumentoAAdicionar.setBounds(10, 400, 590, 25);

        jbuAdicionarDocumento.setFont(resourceMap.getFont("jbuAdicionarDocumento.font")); // NOI18N
        jbuAdicionarDocumento.setIcon(resourceMap.getIcon("jbuAdicionarDocumento.icon")); // NOI18N
        jbuAdicionarDocumento.setMnemonic('D');
        jbuAdicionarDocumento.setText(resourceMap.getString("jbuAdicionarDocumento.text")); // NOI18N
        jbuAdicionarDocumento.setEnabled(false);
        jbuAdicionarDocumento.setName("jbuAdicionarDocumento"); // NOI18N
        jbuAdicionarDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuAdicionarDocumentoActionPerformed(evt);
            }
        });
        jpaDemandaEditar.add(jbuAdicionarDocumento);
        jbuAdicionarDocumento.setBounds(610, 400, 130, 33);

        jlaDocumentosAdicionados.setFont(resourceMap.getFont("jlaDocumentosAdicionados.font")); // NOI18N
        jlaDocumentosAdicionados.setText(resourceMap.getString("jlaDocumentosAdicionados.text")); // NOI18N
        jlaDocumentosAdicionados.setName("jlaDocumentosAdicionados"); // NOI18N
        jpaDemandaEditar.add(jlaDocumentosAdicionados);
        jlaDocumentosAdicionados.setBounds(10, 430, 190, 17);

        jspDocumentosAdicionados.setName("jspDocumentosAdicionados"); // NOI18N

        jliDocumentoAdicionados.setFont(resourceMap.getFont("jliDocumentoAdicionados.font")); // NOI18N
        jliDocumentoAdicionados.setModel(new DefaultListModel());
        jliDocumentoAdicionados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jliDocumentoAdicionados.setName("jliDocumentoAdicionados"); // NOI18N
        jspDocumentosAdicionados.setViewportView(jliDocumentoAdicionados);

        jpaDemandaEditar.add(jspDocumentosAdicionados);
        jspDocumentosAdicionados.setBounds(10, 450, 590, 170);

        jbuAbrirDocumento.setFont(resourceMap.getFont("jbuAbrirDocumento.font")); // NOI18N
        jbuAbrirDocumento.setIcon(resourceMap.getIcon("jbuAbrirDocumento.icon")); // NOI18N
        jbuAbrirDocumento.setMnemonic('A');
        jbuAbrirDocumento.setText(resourceMap.getString("jbuAbrirDocumento.text")); // NOI18N
        jbuAbrirDocumento.setName("jbuAbrirDocumento"); // NOI18N
        jbuAbrirDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuAbrirDocumentoActionPerformed(evt);
            }
        });
        jpaDemandaEditar.add(jbuAbrirDocumento);
        jbuAbrirDocumento.setBounds(610, 450, 130, 33);

        jbuRemoverDocumento.setFont(resourceMap.getFont("jbuRemoverDocumento.font")); // NOI18N
        jbuRemoverDocumento.setIcon(resourceMap.getIcon("jbuRemoverDocumento.icon")); // NOI18N
        jbuRemoverDocumento.setMnemonic('R');
        jbuRemoverDocumento.setText(resourceMap.getString("jbuRemoverDocumento.text")); // NOI18N
        jbuRemoverDocumento.setToolTipText(resourceMap.getString("jbuRemoverDocumento.toolTipText")); // NOI18N
        jbuRemoverDocumento.setName("jbuRemoverDocumento"); // NOI18N
        jbuRemoverDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuRemoverDocumentoActionPerformed(evt);
            }
        });
        jpaDemandaEditar.add(jbuRemoverDocumento);
        jbuRemoverDocumento.setBounds(610, 490, 130, 33);

        jbuSalvar.setFont(resourceMap.getFont("jbuSalvar.font")); // NOI18N
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
        jpaDemandaEditar.add(jbuSalvar);
        jbuSalvar.setBounds(10, 630, 120, 33);
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
        jpaDemandaEditar.add(jbuFechar);
        jbuFechar.setBounds(890, 630, 120, 33);
        jbuFechar.getAccessibleContext().setAccessibleName(resourceMap.getString("jbuFechar.AccessibleContext.accessibleName")); // NOI18N

        jlaCpf.setFont(resourceMap.getFont("jlaCpf.font")); // NOI18N
        jlaCpf.setText(resourceMap.getString("jlaCpf.text")); // NOI18N
        jlaCpf.setName("jlaCpf"); // NOI18N
        jpaDemandaEditar.add(jlaCpf);
        jlaCpf.setBounds(10, 330, 40, 17);

        try {
            jftCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftCpf.setToolTipText(resourceMap.getString("jftCpf.toolTipText")); // NOI18N
        jftCpf.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jftCpf.setFont(resourceMap.getFont("jftCpf.font")); // NOI18N
        jftCpf.setName("jftCpf"); // NOI18N
        jftCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jftCpfFocusLost(evt);
            }
        });
        jpaDemandaEditar.add(jftCpf);
        jftCpf.setBounds(10, 350, 130, 22);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpaDemandaEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpaDemandaEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbuFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuFecharActionPerformed
        controlador.fecharTela();
    }//GEN-LAST:event_jbuFecharActionPerformed

    private void jbuSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuSalvarActionPerformed
        controlador.salvar();
    }//GEN-LAST:event_jbuSalvarActionPerformed

    private void jtfProntuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfProntuarioFocusLost
        controlador.selecionarProntuario();
    }//GEN-LAST:event_jtfProntuarioFocusLost

    private void jbuPesquisarPreCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuPesquisarPreCadastroActionPerformed
        controlador.abrirTelaUtilizarPreCadastro();
    }//GEN-LAST:event_jbuPesquisarPreCadastroActionPerformed

    private void jbuAdicionarDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuAdicionarDocumentoActionPerformed
        controlador.adicionarDocumento();
    }//GEN-LAST:event_jbuAdicionarDocumentoActionPerformed

    private void jbuAbrirDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuAbrirDocumentoActionPerformed
        controlador.abrirDocumento();
    }//GEN-LAST:event_jbuAbrirDocumentoActionPerformed

    private void jcbNomeDocumentoAAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbNomeDocumentoAAdicionarActionPerformed
        controlador.habilitarAdicionar();
    }//GEN-LAST:event_jcbNomeDocumentoAAdicionarActionPerformed

    private void jbuRemoverDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuRemoverDocumentoActionPerformed
        controlador.removerDocumento();
    }//GEN-LAST:event_jbuRemoverDocumentoActionPerformed

    private void jftCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftCpfFocusLost
        controlador.selecionarPreCadastro();
    }//GEN-LAST:event_jftCpfFocusLost

    private void jbuAdicionarRecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuAdicionarRecursoActionPerformed
        controlador.adicionarRecurso();
    }//GEN-LAST:event_jbuAdicionarRecursoActionPerformed

    private void jbuRemoverRecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuRemoverRecursoActionPerformed
        controlador.removerRecursoAdicionado();
    }//GEN-LAST:event_jbuRemoverRecursoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbuAbrirDocumento;
    private javax.swing.JButton jbuAdicionarDocumento;
    private javax.swing.JButton jbuAdicionarRecurso;
    private javax.swing.JButton jbuFechar;
    private javax.swing.JButton jbuPesquisarPreCadastro;
    private javax.swing.JButton jbuRemoverDocumento;
    private javax.swing.JButton jbuRemoverRecurso;
    private javax.swing.JButton jbuSalvar;
    private javax.swing.JComboBox<String> jcbNomeDocumentoAAdicionar;
    private javax.swing.JComboBox jcbRecurso;
    private javax.swing.JCheckBox jchCartelaSeltos;
    private javax.swing.JFormattedTextField jftCpf;
    private javax.swing.JLabel jlaCpf;
    private javax.swing.JLabel jlaDocumento;
    private javax.swing.JLabel jlaDocumentosAdicionados;
    private javax.swing.JLabel jlaNomePreCadastro;
    private javax.swing.JLabel jlaNomeUsuario;
    private javax.swing.JLabel jlaProntuario;
    private javax.swing.JLabel jlaRecurso;
    private javax.swing.JLabel jlaRecursosAdicionados;
    private javax.swing.JList jliDocumentoAdicionados;
    private javax.swing.JList<String> jliRecursosAdicionados;
    private javax.swing.JPanel jpaDemandaEditar;
    private javax.swing.JPanel jpaUsuario;
    private javax.swing.JScrollPane jspDocumentosAdicionados;
    private javax.swing.JScrollPane jspRecursosAdicionados;
    private javax.swing.JTextField jtfNomePreCadastro;
    private javax.swing.JTextField jtfNomeUsuario;
    private javax.swing.JTextField jtfProntuario;
    // End of variables declaration//GEN-END:variables
    private ControladorTelaDemandaEditar controlador;
}
