package br.laramara.ti.sislaraclient.telas;

import br.laramara.ti.sislaraclient.controladores.ControladorTelaAgendaEditar;
import br.laramara.ti.sislaraclient.utilitarios.JOptionPanePersonalizado;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;

public abstract class TelaAgendaEditar extends javax.swing.JDialog {

    /** Creates new form TelaAgendaEditar */
    public TelaAgendaEditar(JDialog parent, boolean exibirAssociacaoPreCadastro) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(parent);
        jtpUsuarioGrupoPreCadastro.setVisible(exibirAssociacaoPreCadastro);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpaTelaAgendaEditarAgendamento = new javax.swing.JPanel();
        jpaTitulo = new javax.swing.JPanel();
        jlaTitulo = new javax.swing.JLabel();
        jbuFecharTitulo = new javax.swing.JButton();
        jtpUsuarioGrupoPreCadastro = new javax.swing.JTabbedPane();
        jpaPreCadastro = new javax.swing.JPanel();
        jlaNome = new javax.swing.JLabel();
        jtfNomePreCadastro = new javax.swing.JTextField();
        jbuUtilizarPreCadastro = new javax.swing.JButton();
        jbuSalvar = new javax.swing.JButton();
        jbuFechar = new javax.swing.JButton();
        jpaDadosAgendamento = new javax.swing.JPanel();
        jlaProfissional = new javax.swing.JLabel();
        jcbProfissional = new javax.swing.JComboBox();
        jbuAdicionarProfissional = new javax.swing.JButton();
        jlaProfissionaisAgendados = new javax.swing.JLabel();
        jspProfissionalAgendados = new javax.swing.JScrollPane();
        jliProfissionalAgendados = new javax.swing.JList();
        jbuRemoverProfissional = new javax.swing.JButton();
        jlaTipoAtendimento = new javax.swing.JLabel();
        jcbTipoAtendimento = new javax.swing.JComboBox();
        jlaDescricaoTipoAtendimento = new javax.swing.JLabel();
        jcbDescricaoTipoAtendimento = new javax.swing.JComboBox();
        jlaSetor = new javax.swing.JLabel();
        jcbSetor = new javax.swing.JComboBox();
        jlaModulo = new javax.swing.JLabel();
        jcbModuloAtividade = new javax.swing.JComboBox();
        jlaLocalAtendimento = new javax.swing.JLabel();
        jcbLocalAtendimento = new javax.swing.JComboBox();
        jlaReservaPara = new javax.swing.JLabel();
        jcbReservaPara = new javax.swing.JComboBox();
        jpaDatas = new javax.swing.JPanel();
        jlaDataInicio = new javax.swing.JLabel();
        jftDataInicio = new javax.swing.JFormattedTextField();
        jbuSelecionarDataInicial = new javax.swing.JButton();
        jlaDataTerminol = new javax.swing.JLabel();
        jftDataTermino = new javax.swing.JFormattedTextField();
        jbuSelecionarDataTermino = new javax.swing.JButton();
        jpaHora = new javax.swing.JPanel();
        jlaHoaraInicio = new javax.swing.JLabel();
        jftHoraInicio = new javax.swing.JFormattedTextField();
        jlaHoraTermino = new javax.swing.JLabel();
        jftHoraTermino = new javax.swing.JFormattedTextField();
        jlaDiaSemana = new javax.swing.JLabel();
        jcbDiaSemana = new javax.swing.JComboBox();
        jpaDadosObservacoes = new javax.swing.JPanel();
        jlaObservacoes = new javax.swing.JLabel();
        jspObservacoes = new javax.swing.JScrollPane();
        jepObservacoes = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(TelaAgendaEditar.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        setUndecorated(true);

        jpaTelaAgendaEditarAgendamento.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("jpaTelaAgendaEditarAgendamento.border.lineColor"))); // NOI18N
        jpaTelaAgendaEditarAgendamento.setName("jpaTelaAgendaEditarAgendamento"); // NOI18N
        jpaTelaAgendaEditarAgendamento.setOpaque(false);
        jpaTelaAgendaEditarAgendamento.setLayout(null);

        jpaTitulo.setBackground(resourceMap.getColor("jpaTitulo.background")); // NOI18N
        jpaTitulo.setName("jpaTitulo"); // NOI18N
        jpaTitulo.setLayout(null);

        jlaTitulo.setFont(resourceMap.getFont("jlaTitulo.font")); // NOI18N
        jlaTitulo.setForeground(resourceMap.getColor("jlaTitulo.foreground")); // NOI18N
        jlaTitulo.setText(resourceMap.getString("jlaTitulo.text")); // NOI18N
        jlaTitulo.setName("jlaTitulo"); // NOI18N
        jpaTitulo.add(jlaTitulo);
        jlaTitulo.setBounds(10, 0, 160, 26);

        jbuFecharTitulo.setBackground(resourceMap.getColor("jbuFecharTitulo.background")); // NOI18N
        jbuFecharTitulo.setIcon(resourceMap.getIcon("jbuFecharTitulo.icon")); // NOI18N
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
        jbuFecharTitulo.setBounds(1003, 1, 25, 25);

        jpaTelaAgendaEditarAgendamento.add(jpaTitulo);
        jpaTitulo.setBounds(1, 1, 1027, 26);

        jtpUsuarioGrupoPreCadastro.setFont(resourceMap.getFont("jtpUsuarioGrupoPreCadastro.font")); // NOI18N
        jtpUsuarioGrupoPreCadastro.setName("jtpUsuarioGrupoPreCadastro"); // NOI18N

        jpaPreCadastro.setName("jpaPreCadastro"); // NOI18N
        jpaPreCadastro.setLayout(null);

        jlaNome.setFont(resourceMap.getFont("jlaNome.font")); // NOI18N
        jlaNome.setText(resourceMap.getString("jlaNome.text")); // NOI18N
        jlaNome.setName("jlaNome"); // NOI18N
        jpaPreCadastro.add(jlaNome);
        jlaNome.setBounds(10, 0, 120, 17);

        jtfNomePreCadastro.setEditable(false);
        jtfNomePreCadastro.setFont(resourceMap.getFont("jtfNomePreCadastro.font")); // NOI18N
        jtfNomePreCadastro.setText(resourceMap.getString("jtfNomePreCadastro.text")); // NOI18N
        jtfNomePreCadastro.setName("jtfNomePreCadastro"); // NOI18N
        jpaPreCadastro.add(jtfNomePreCadastro);
        jtfNomePreCadastro.setBounds(10, 20, 430, 23);
        jtfNomePreCadastro.getAccessibleContext().setAccessibleName(resourceMap.getString("jtfNome.AccessibleContext.accessibleName")); // NOI18N

        jbuUtilizarPreCadastro.setFont(resourceMap.getFont("jbuUtilizarPreCadastro.font")); // NOI18N
        jbuUtilizarPreCadastro.setIcon(resourceMap.getIcon("jbuUtilizarPreCadastro.icon")); // NOI18N
        jbuUtilizarPreCadastro.setMnemonic('U');
        jbuUtilizarPreCadastro.setText(resourceMap.getString("jbuUtilizarPreCadastro.text")); // NOI18N
        jbuUtilizarPreCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbuUtilizarPreCadastro.setName("jbuUtilizarPreCadastro"); // NOI18N
        jbuUtilizarPreCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuUtilizarPreCadastroActionPerformed(evt);
            }
        });
        jpaPreCadastro.add(jbuUtilizarPreCadastro);
        jbuUtilizarPreCadastro.setBounds(450, 20, 130, 33);
        jbuUtilizarPreCadastro.getAccessibleContext().setAccessibleName(resourceMap.getString("jbuUtilizarPreCadastro.AccessibleContext.accessibleName")); // NOI18N

        jtpUsuarioGrupoPreCadastro.addTab(resourceMap.getString("jpaPreCadastro.TabConstraints.tabTitle"), jpaPreCadastro); // NOI18N

        jpaTelaAgendaEditarAgendamento.add(jtpUsuarioGrupoPreCadastro);
        jtpUsuarioGrupoPreCadastro.setBounds(10, 30, 1009, 180);

        jbuSalvar.setFont(resourceMap.getFont("jbuSalvar.font")); // NOI18N
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
        jpaTelaAgendaEditarAgendamento.add(jbuSalvar);
        jbuSalvar.setBounds(10, 670, 110, 33);
        jbuSalvar.getAccessibleContext().setAccessibleName(resourceMap.getString("jbuSalvar.AccessibleContext.accessibleName")); // NOI18N

        jbuFechar.setFont(resourceMap.getFont("jbuSalvar.font")); // NOI18N
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
        jpaTelaAgendaEditarAgendamento.add(jbuFechar);
        jbuFechar.setBounds(900, 670, 120, 33);
        jbuFechar.getAccessibleContext().setAccessibleName(resourceMap.getString("jbuFechar.AccessibleContext.accessibleName")); // NOI18N

        jpaDadosAgendamento.setName("jpaDadosAgendamento"); // NOI18N
        jpaDadosAgendamento.setOpaque(false);
        jpaDadosAgendamento.setLayout(null);

        jlaProfissional.setFont(resourceMap.getFont("jlaProfissional.font")); // NOI18N
        jlaProfissional.setText(resourceMap.getString("jlaProfissional.text")); // NOI18N
        jlaProfissional.setName("jlaProfissional"); // NOI18N
        jpaDadosAgendamento.add(jlaProfissional);
        jlaProfissional.setBounds(10, 0, 110, 20);

        jcbProfissional.setFont(resourceMap.getFont("jcbProfissional.font")); // NOI18N
        jcbProfissional.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jcbProfissional.setName("jcbProfissional"); // NOI18N
        jpaDadosAgendamento.add(jcbProfissional);
        jcbProfissional.setBounds(10, 20, 750, 25);
        jcbProfissional.getAccessibleContext().setAccessibleName(resourceMap.getString("jcbProfissional.AccessibleContext.accessibleName")); // NOI18N

        jbuAdicionarProfissional.setFont(resourceMap.getFont("jbuAdicionarProfissional.font")); // NOI18N
        jbuAdicionarProfissional.setIcon(resourceMap.getIcon("jbuAdicionarProfissional.icon")); // NOI18N
        jbuAdicionarProfissional.setMnemonic('A');
        jbuAdicionarProfissional.setText(resourceMap.getString("jbuAdicionarProfissional.text")); // NOI18N
        jbuAdicionarProfissional.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbuAdicionarProfissional.setName("jbuAdicionarProfissional"); // NOI18N
        jbuAdicionarProfissional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuAdicionarProfissionalActionPerformed(evt);
            }
        });
        jpaDadosAgendamento.add(jbuAdicionarProfissional);
        jbuAdicionarProfissional.setBounds(770, 20, 160, 33);
        jbuAdicionarProfissional.getAccessibleContext().setAccessibleName(resourceMap.getString("jbuAdicionarProfissional.AccessibleContext.accessibleName")); // NOI18N

        jlaProfissionaisAgendados.setFont(resourceMap.getFont("jlaProfissionaisAgendados.font")); // NOI18N
        jlaProfissionaisAgendados.setText(resourceMap.getString("jlaProfissionaisAgendados.text")); // NOI18N
        jlaProfissionaisAgendados.setName("jlaProfissionaisAgendados"); // NOI18N
        jpaDadosAgendamento.add(jlaProfissionaisAgendados);
        jlaProfissionaisAgendados.setBounds(10, 50, 210, 17);

        jspProfissionalAgendados.setName("jspProfissionalAgendados"); // NOI18N

        jliProfissionalAgendados.setFont(resourceMap.getFont("jliProfissionalAgendados.font")); // NOI18N
        jliProfissionalAgendados.setModel(new DefaultListModel());
        jliProfissionalAgendados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jliProfissionalAgendados.setName("jliProfissionalAgendados"); // NOI18N
        jspProfissionalAgendados.setViewportView(jliProfissionalAgendados);

        jpaDadosAgendamento.add(jspProfissionalAgendados);
        jspProfissionalAgendados.setBounds(10, 70, 750, 80);

        jbuRemoverProfissional.setFont(resourceMap.getFont("jbuRemoverProfissional.font")); // NOI18N
        jbuRemoverProfissional.setIcon(resourceMap.getIcon("jbuRemoverProfissional.icon")); // NOI18N
        jbuRemoverProfissional.setMnemonic('R');
        jbuRemoverProfissional.setText(resourceMap.getString("jbuRemoverProfissional.text")); // NOI18N
        jbuRemoverProfissional.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbuRemoverProfissional.setName("jbuRemoverProfissional"); // NOI18N
        jbuRemoverProfissional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuRemoverProfissionalActionPerformed(evt);
            }
        });
        jpaDadosAgendamento.add(jbuRemoverProfissional);
        jbuRemoverProfissional.setBounds(770, 70, 160, 33);
        jbuRemoverProfissional.getAccessibleContext().setAccessibleName(resourceMap.getString("jbuRemoverProfissional.AccessibleContext.accessibleName")); // NOI18N

        jlaTipoAtendimento.setFont(resourceMap.getFont("jlaTipoAtendimento.font")); // NOI18N
        jlaTipoAtendimento.setText(resourceMap.getString("jlaTipoAtendimento.text")); // NOI18N
        jlaTipoAtendimento.setName("jlaTipoAtendimento"); // NOI18N
        jpaDadosAgendamento.add(jlaTipoAtendimento);
        jlaTipoAtendimento.setBounds(10, 150, 290, 17);

        jcbTipoAtendimento.setFont(resourceMap.getFont("jcbTipoAtendimento.font")); // NOI18N
        jcbTipoAtendimento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jcbTipoAtendimento.setName("jcbTipoAtendimento"); // NOI18N
        jcbTipoAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoAtendimentoActionPerformed(evt);
            }
        });
        jpaDadosAgendamento.add(jcbTipoAtendimento);
        jcbTipoAtendimento.setBounds(10, 170, 750, 25);
        jcbTipoAtendimento.getAccessibleContext().setAccessibleName(resourceMap.getString("jcbTipoAtendimento.AccessibleContext.accessibleName")); // NOI18N

        jlaDescricaoTipoAtendimento.setFont(resourceMap.getFont("jlaDescricaoTipoAtendimento.font")); // NOI18N
        jlaDescricaoTipoAtendimento.setText(resourceMap.getString("jlaDescricaoTipoAtendimento.text")); // NOI18N
        jlaDescricaoTipoAtendimento.setName("jlaDescricaoTipoAtendimento"); // NOI18N
        jpaDadosAgendamento.add(jlaDescricaoTipoAtendimento);
        jlaDescricaoTipoAtendimento.setBounds(10, 200, 270, 17);

        jcbDescricaoTipoAtendimento.setFont(resourceMap.getFont("jcbDescricaoTipoAtendimento.font")); // NOI18N
        jcbDescricaoTipoAtendimento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jcbDescricaoTipoAtendimento.setName("jcbDescricaoTipoAtendimento"); // NOI18N
        jcbDescricaoTipoAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDescricaoTipoAtendimentoActionPerformed(evt);
            }
        });
        jpaDadosAgendamento.add(jcbDescricaoTipoAtendimento);
        jcbDescricaoTipoAtendimento.setBounds(10, 220, 750, 25);

        jlaSetor.setFont(resourceMap.getFont("jlaSetor.font")); // NOI18N
        jlaSetor.setText(resourceMap.getString("jlaSetor.text")); // NOI18N
        jlaSetor.setName("jlaSetor"); // NOI18N
        jpaDadosAgendamento.add(jlaSetor);
        jlaSetor.setBounds(770, 200, 39, 17);

        jcbSetor.setFont(resourceMap.getFont("jcbSetor.font")); // NOI18N
        jcbSetor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jcbSetor.setName("jcbSetor"); // NOI18N
        jpaDadosAgendamento.add(jcbSetor);
        jcbSetor.setBounds(770, 220, 250, 25);
        jcbSetor.getAccessibleContext().setAccessibleName(resourceMap.getString("jComboBox1.AccessibleContext.accessibleName")); // NOI18N

        jlaModulo.setFont(resourceMap.getFont("jlaModulo.font")); // NOI18N
        jlaModulo.setText(resourceMap.getString("jlaModulo.text")); // NOI18N
        jlaModulo.setName("jlaModulo"); // NOI18N
        jpaDadosAgendamento.add(jlaModulo);
        jlaModulo.setBounds(10, 250, 150, 17);

        jcbModuloAtividade.setFont(resourceMap.getFont("jcbModuloAtividade.font")); // NOI18N
        jcbModuloAtividade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jcbModuloAtividade.setName("jcbModuloAtividade"); // NOI18N
        jpaDadosAgendamento.add(jcbModuloAtividade);
        jcbModuloAtividade.setBounds(10, 270, 750, 25);

        jlaLocalAtendimento.setFont(resourceMap.getFont("jlaLocalAtendimento.font")); // NOI18N
        jlaLocalAtendimento.setText(resourceMap.getString("jlaLocalAtendimento.text")); // NOI18N
        jlaLocalAtendimento.setName("jlaLocalAtendimento"); // NOI18N
        jpaDadosAgendamento.add(jlaLocalAtendimento);
        jlaLocalAtendimento.setBounds(10, 300, 240, 17);

        jcbLocalAtendimento.setFont(resourceMap.getFont("jcbLocalAtendimento.font")); // NOI18N
        jcbLocalAtendimento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jcbLocalAtendimento.setName("jcbLocalAtendimento"); // NOI18N
        jpaDadosAgendamento.add(jcbLocalAtendimento);
        jcbLocalAtendimento.setBounds(10, 320, 510, 25);
        jcbLocalAtendimento.getAccessibleContext().setAccessibleName(resourceMap.getString("jcbLocalAtendimento.AccessibleContext.accessibleName")); // NOI18N

        jlaReservaPara.setFont(resourceMap.getFont("jlaReservaPara.font")); // NOI18N
        jlaReservaPara.setText(resourceMap.getString("jlaReservaPara.text")); // NOI18N
        jlaReservaPara.setName("jlaReservaPara"); // NOI18N
        jpaDadosAgendamento.add(jlaReservaPara);
        jlaReservaPara.setBounds(770, 250, 140, 17);

        jcbReservaPara.setFont(resourceMap.getFont("jcbReservaPara.font")); // NOI18N
        jcbReservaPara.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jcbReservaPara.setName("jcbReservaPara"); // NOI18N
        jpaDadosAgendamento.add(jcbReservaPara);
        jcbReservaPara.setBounds(770, 270, 250, 25);

        jpaDatas.setName("jpaDatas"); // NOI18N

        jlaDataInicio.setFont(resourceMap.getFont("jlaDataInicio.font")); // NOI18N
        jlaDataInicio.setText(resourceMap.getString("jlaDataInicio.text")); // NOI18N
        jlaDataInicio.setName("jlaDataInicio"); // NOI18N

        try {
            jftDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftDataInicio.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jftDataInicio.setFont(resourceMap.getFont("jftDataInicio.font")); // NOI18N
        jftDataInicio.setName("jftDataInicio"); // NOI18N

        jbuSelecionarDataInicial.setIcon(resourceMap.getIcon("jbuSelecionarDataInicial.icon")); // NOI18N
        jbuSelecionarDataInicial.setText(resourceMap.getString("jbuSelecionarDataInicial.text")); // NOI18N
        jbuSelecionarDataInicial.setBorderPainted(false);
        jbuSelecionarDataInicial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbuSelecionarDataInicial.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jbuSelecionarDataInicial.setMaximumSize(new java.awt.Dimension(25, 25));
        jbuSelecionarDataInicial.setMinimumSize(new java.awt.Dimension(25, 25));
        jbuSelecionarDataInicial.setName("jbuSelecionarDataInicial"); // NOI18N
        jbuSelecionarDataInicial.setPreferredSize(new java.awt.Dimension(25, 25));
        jbuSelecionarDataInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuSelecionarDataInicialActionPerformed(evt);
            }
        });

        jlaDataTerminol.setFont(resourceMap.getFont("jlaDataTerminol.font")); // NOI18N
        jlaDataTerminol.setText(resourceMap.getString("jlaDataTerminol.text")); // NOI18N
        jlaDataTerminol.setName("jlaDataTerminol"); // NOI18N

        try {
            jftDataTermino.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftDataTermino.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jftDataTermino.setFont(resourceMap.getFont("jftDataTermino.font")); // NOI18N
        jftDataTermino.setName("jftDataTermino"); // NOI18N

        jbuSelecionarDataTermino.setIcon(resourceMap.getIcon("jbuSelecionarDataTermino.icon")); // NOI18N
        jbuSelecionarDataTermino.setText(resourceMap.getString("jbuSelecionarDataTermino.text")); // NOI18N
        jbuSelecionarDataTermino.setBorderPainted(false);
        jbuSelecionarDataTermino.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbuSelecionarDataTermino.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jbuSelecionarDataTermino.setMaximumSize(new java.awt.Dimension(25, 25));
        jbuSelecionarDataTermino.setMinimumSize(new java.awt.Dimension(25, 25));
        jbuSelecionarDataTermino.setName("jbuSelecionarDataTermino"); // NOI18N
        jbuSelecionarDataTermino.setPreferredSize(new java.awt.Dimension(25, 25));
        jbuSelecionarDataTermino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuSelecionarDataTerminoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpaDatasLayout = new javax.swing.GroupLayout(jpaDatas);
        jpaDatas.setLayout(jpaDatasLayout);
        jpaDatasLayout.setHorizontalGroup(
            jpaDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
            .addGroup(jpaDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpaDatasLayout.createSequentialGroup()
                    .addGap(0, 12, Short.MAX_VALUE)
                    .addGroup(jpaDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlaDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jpaDatasLayout.createSequentialGroup()
                            .addComponent(jftDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jbuSelecionarDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jlaDataTerminol, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jpaDatasLayout.createSequentialGroup()
                            .addComponent(jftDataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jbuSelecionarDataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 13, Short.MAX_VALUE)))
        );
        jpaDatasLayout.setVerticalGroup(
            jpaDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jpaDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpaDatasLayout.createSequentialGroup()
                    .addGap(0, 2, Short.MAX_VALUE)
                    .addComponent(jlaDataInicio)
                    .addGap(3, 3, 3)
                    .addGroup(jpaDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jftDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbuSelecionarDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(5, 5, 5)
                    .addComponent(jlaDataTerminol)
                    .addGap(3, 3, 3)
                    .addGroup(jpaDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jftDataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbuSelecionarDataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 3, Short.MAX_VALUE)))
        );

        jftDataInicio.getAccessibleContext().setAccessibleName(resourceMap.getString("jftData.AccessibleContext.accessibleName")); // NOI18N
        jftDataInicio.getAccessibleContext().setAccessibleDescription(resourceMap.getString("jftDataInicio.AccessibleContext.accessibleDescription")); // NOI18N
        jbuSelecionarDataInicial.getAccessibleContext().setAccessibleName(resourceMap.getString("jbuData.AccessibleContext.accessibleName")); // NOI18N
        jftDataTermino.getAccessibleContext().setAccessibleName(resourceMap.getString("jftDataFinal.AccessibleContext.accessibleName")); // NOI18N
        jftDataTermino.getAccessibleContext().setAccessibleDescription(resourceMap.getString("jftDataTermino.AccessibleContext.accessibleDescription")); // NOI18N
        jbuSelecionarDataTermino.getAccessibleContext().setAccessibleName(resourceMap.getString("jbuSelecionarDataFinal.AccessibleContext.accessibleName")); // NOI18N

        jpaDadosAgendamento.add(jpaDatas);
        jpaDatas.setBounds(1, 350, 160, 100);

        jpaHora.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), resourceMap.getString("jpaHora.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, resourceMap.getFont("jpaHora.border.titleFont"))); // NOI18N
        jpaHora.setName("jpaHora"); // NOI18N
        jpaHora.setLayout(null);

        jlaHoaraInicio.setFont(resourceMap.getFont("jlaHoraTermino.font")); // NOI18N
        jlaHoaraInicio.setText(resourceMap.getString("jlaHoaraInicio.text")); // NOI18N
        jlaHoaraInicio.setName("jlaHoaraInicio"); // NOI18N
        jpaHora.add(jlaHoaraInicio);
        jlaHoaraInicio.setBounds(10, 30, 60, 17);

        try {
            jftHoraInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftHoraInicio.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jftHoraInicio.setFont(resourceMap.getFont("jftHoraTermino.font")); // NOI18N
        jftHoraInicio.setName("jftHoraInicio"); // NOI18N
        jpaHora.add(jftHoraInicio);
        jftHoraInicio.setBounds(10, 50, 60, 23);
        jftHoraInicio.getAccessibleContext().setAccessibleName(resourceMap.getString("jftHoraInicio.AccessibleContext.accessibleName")); // NOI18N

        jlaHoraTermino.setFont(resourceMap.getFont("jlaHoraTermino.font")); // NOI18N
        jlaHoraTermino.setText(resourceMap.getString("jlaHoraTermino.text")); // NOI18N
        jlaHoraTermino.setName("jlaHoraTermino"); // NOI18N
        jpaHora.add(jlaHoraTermino);
        jlaHoraTermino.setBounds(80, 30, 60, 17);

        try {
            jftHoraTermino.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftHoraTermino.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jftHoraTermino.setFont(resourceMap.getFont("jftHoraTermino.font")); // NOI18N
        jftHoraTermino.setName("jftHoraTermino"); // NOI18N
        jpaHora.add(jftHoraTermino);
        jftHoraTermino.setBounds(80, 50, 60, 23);
        jftHoraTermino.getAccessibleContext().setAccessibleName(resourceMap.getString("jftHoraTermino.AccessibleContext.accessibleName")); // NOI18N

        jpaDadosAgendamento.add(jpaHora);
        jpaHora.setBounds(160, 360, 150, 90);

        jlaDiaSemana.setFont(resourceMap.getFont("jlaDiaSemana.font")); // NOI18N
        jlaDiaSemana.setText(resourceMap.getString("jlaDiaSemana.text")); // NOI18N
        jlaDiaSemana.setName("jlaDiaSemana"); // NOI18N
        jpaDadosAgendamento.add(jlaDiaSemana);
        jlaDiaSemana.setBounds(320, 350, 200, 17);

        jcbDiaSemana.setFont(resourceMap.getFont("jcbDiaSemana.font")); // NOI18N
        jcbDiaSemana.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jcbDiaSemana.setName("jcbDiaSemana"); // NOI18N
        jpaDadosAgendamento.add(jcbDiaSemana);
        jcbDiaSemana.setBounds(320, 370, 200, 25);
        jcbDiaSemana.getAccessibleContext().setAccessibleName(resourceMap.getString("jcbDiaSemana.AccessibleContext.accessibleName")); // NOI18N

        jpaTelaAgendaEditarAgendamento.add(jpaDadosAgendamento);
        jpaDadosAgendamento.setBounds(0, 210, 1023, 450);

        jpaDadosObservacoes.setName("jpaDadosObservacoes"); // NOI18N
        jpaDadosObservacoes.setOpaque(false);
        jpaDadosObservacoes.setLayout(null);

        jlaObservacoes.setFont(resourceMap.getFont("jlaObservacoes.font")); // NOI18N
        jlaObservacoes.setText(resourceMap.getString("jlaObservacoes.text")); // NOI18N
        jlaObservacoes.setName("jlaObservacoes"); // NOI18N
        jpaDadosObservacoes.add(jlaObservacoes);
        jlaObservacoes.setBounds(0, 10, 110, 17);

        jspObservacoes.setName("jspObservacoes"); // NOI18N

        jepObservacoes.setFont(resourceMap.getFont("jepObservacoes.font")); // NOI18N
        jepObservacoes.setName("jepObservacoes"); // NOI18N
        jspObservacoes.setViewportView(jepObservacoes);
        jepObservacoes.getAccessibleContext().setAccessibleName(resourceMap.getString("jEditorPane1.AccessibleContext.accessibleName")); // NOI18N
        jepObservacoes.getAccessibleContext().setAccessibleDescription(resourceMap.getString("jepObservacoes.AccessibleContext.accessibleDescription")); // NOI18N

        jpaDadosObservacoes.add(jspObservacoes);
        jspObservacoes.setBounds(0, 30, 490, 130);

        jpaTelaAgendaEditarAgendamento.add(jpaDadosObservacoes);
        jpaDadosObservacoes.setBounds(530, 500, 490, 160);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpaTelaAgendaEditarAgendamento, javax.swing.GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpaTelaAgendaEditarAgendamento, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbuFecharTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuFecharTituloActionPerformed
        controlador.fecharTela();
    }//GEN-LAST:event_jbuFecharTituloActionPerformed

    private void jbuFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuFecharActionPerformed
        controlador.fecharTela();
    }//GEN-LAST:event_jbuFecharActionPerformed

    private void jcbTipoAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoAtendimentoActionPerformed
        controlador.inicializarDescricaoTipoAtendimento();
    }//GEN-LAST:event_jcbTipoAtendimentoActionPerformed

    private void jcbDescricaoTipoAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDescricaoTipoAtendimentoActionPerformed
        controlador.inicializarSetor();
    }//GEN-LAST:event_jcbDescricaoTipoAtendimentoActionPerformed

    private void jbuSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuSalvarActionPerformed
        controlador.salvar();
    }//GEN-LAST:event_jbuSalvarActionPerformed

    private void jbuSelecionarDataInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuSelecionarDataInicialActionPerformed
        JOptionPanePersonalizado.mostrarTelaSelecionarData(this, jftDataInicio);
    }//GEN-LAST:event_jbuSelecionarDataInicialActionPerformed

    private void jbuSelecionarDataTerminoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuSelecionarDataTerminoActionPerformed
        JOptionPanePersonalizado.mostrarTelaSelecionarData(this, jftDataTermino);
    }//GEN-LAST:event_jbuSelecionarDataTerminoActionPerformed

    private void jbuAdicionarProfissionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuAdicionarProfissionalActionPerformed
        controlador.adicionarProfissional();
    }//GEN-LAST:event_jbuAdicionarProfissionalActionPerformed

    private void jbuRemoverProfissionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuRemoverProfissionalActionPerformed
        controlador.removerProfissionalSelecionado();
    }//GEN-LAST:event_jbuRemoverProfissionalActionPerformed

    private void jbuUtilizarPreCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuUtilizarPreCadastroActionPerformed
        controlador.abrirTelaUtilizarPreCadastro();
    }//GEN-LAST:event_jbuUtilizarPreCadastroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbuAdicionarProfissional;
    private javax.swing.JButton jbuFechar;
    private javax.swing.JButton jbuFecharTitulo;
    private javax.swing.JButton jbuRemoverProfissional;
    private javax.swing.JButton jbuSalvar;
    private javax.swing.JButton jbuSelecionarDataInicial;
    private javax.swing.JButton jbuSelecionarDataTermino;
    protected javax.swing.JButton jbuUtilizarPreCadastro;
    protected javax.swing.JComboBox jcbDescricaoTipoAtendimento;
    protected javax.swing.JComboBox jcbDiaSemana;
    protected javax.swing.JComboBox jcbLocalAtendimento;
    protected javax.swing.JComboBox jcbModuloAtividade;
    protected javax.swing.JComboBox jcbProfissional;
    protected javax.swing.JComboBox jcbReservaPara;
    protected javax.swing.JComboBox jcbSetor;
    protected javax.swing.JComboBox jcbTipoAtendimento;
    protected javax.swing.JEditorPane jepObservacoes;
    protected javax.swing.JFormattedTextField jftDataInicio;
    protected javax.swing.JFormattedTextField jftDataTermino;
    protected javax.swing.JFormattedTextField jftHoraInicio;
    protected javax.swing.JFormattedTextField jftHoraTermino;
    private javax.swing.JLabel jlaDataInicio;
    private javax.swing.JLabel jlaDataTerminol;
    private javax.swing.JLabel jlaDescricaoTipoAtendimento;
    private javax.swing.JLabel jlaDiaSemana;
    private javax.swing.JLabel jlaHoaraInicio;
    private javax.swing.JLabel jlaHoraTermino;
    private javax.swing.JLabel jlaLocalAtendimento;
    private javax.swing.JLabel jlaModulo;
    private javax.swing.JLabel jlaNome;
    private javax.swing.JLabel jlaObservacoes;
    private javax.swing.JLabel jlaProfissionaisAgendados;
    private javax.swing.JLabel jlaProfissional;
    private javax.swing.JLabel jlaReservaPara;
    private javax.swing.JLabel jlaSetor;
    private javax.swing.JLabel jlaTipoAtendimento;
    private javax.swing.JLabel jlaTitulo;
    protected javax.swing.JList jliProfissionalAgendados;
    protected javax.swing.JPanel jpaDadosAgendamento;
    protected javax.swing.JPanel jpaDadosObservacoes;
    private javax.swing.JPanel jpaDatas;
    private javax.swing.JPanel jpaHora;
    private javax.swing.JPanel jpaPreCadastro;
    private javax.swing.JPanel jpaTelaAgendaEditarAgendamento;
    private javax.swing.JPanel jpaTitulo;
    private javax.swing.JScrollPane jspObservacoes;
    private javax.swing.JScrollPane jspProfissionalAgendados;
    protected javax.swing.JTextField jtfNomePreCadastro;
    private javax.swing.JTabbedPane jtpUsuarioGrupoPreCadastro;
    // End of variables declaration//GEN-END:variables
    protected ControladorTelaAgendaEditar controlador;
}
