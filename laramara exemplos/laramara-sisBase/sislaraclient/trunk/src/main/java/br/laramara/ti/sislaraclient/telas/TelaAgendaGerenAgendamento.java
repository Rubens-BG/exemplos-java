package br.laramara.ti.sislaraclient.telas;

import br.laramara.ti.sislaraclient.controladores.ControladorTelaAgendaGerenAgendamento;
import br.laramara.ti.sislaraclient.modelos.ModeloTabelaAgendamento;
import br.laramara.ti.sislaraclient.utilitarios.JOptionPanePersonalizado;
import javax.swing.JFrame;

public class TelaAgendaGerenAgendamento extends javax.swing.JDialog {

    /** Creates new form TelaGerenAgenda */
    public TelaAgendaGerenAgendamento(JFrame telaPai) {
        super(telaPai, true);
        initComponents();
        setLocationRelativeTo(telaPai);
        controlador = new ControladorTelaAgendaGerenAgendamento(this, jcbProfissional, jcbTipoAtendimento, jcbDescricaoAtendimento, jcbModuloPeriodo, jftDataInicio, jftDataTermino, jcbStatusAgendamento, jftProntuario, jtfRgPreCadastro, jdcData, jmcData, jycData, jtaAgendamentos);
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

        jpaGerenAgenda = new javax.swing.JPanel();
        jpaTitulo = new javax.swing.JPanel();
        jlaTitulo = new javax.swing.JLabel();
        jbuFecharTitulo = new javax.swing.JButton();
        jpaPesquisa = new javax.swing.JPanel();
        jlaProfissional = new javax.swing.JLabel();
        jcbProfissional = new javax.swing.JComboBox();
        jlaTipoAtendimento = new javax.swing.JLabel();
        jcbTipoAtendimento = new javax.swing.JComboBox();
        jlaDescricaoAtendimento = new javax.swing.JLabel();
        jcbDescricaoAtendimento = new javax.swing.JComboBox();
        jlaModuloPeriodo = new javax.swing.JLabel();
        jcbModuloPeriodo = new javax.swing.JComboBox();
        jlaDataInicio = new javax.swing.JLabel();
        jftDataInicio = new javax.swing.JFormattedTextField();
        jbuSelecionarDataInicial = new javax.swing.JButton();
        jlaDataTermino = new javax.swing.JLabel();
        jftDataTermino = new javax.swing.JFormattedTextField();
        jlaStatusAgendamento = new javax.swing.JLabel();
        jcbStatusAgendamento = new javax.swing.JComboBox();
        jbuSelecionarDataFinal = new javax.swing.JButton();
        jbuPesquisar = new javax.swing.JButton();
        jlaProntuario = new javax.swing.JLabel();
        jftProntuario = new javax.swing.JFormattedTextField();
        jbuUtilizarUsuario = new javax.swing.JButton();
        jlaRgPreCadastro = new javax.swing.JLabel();
        jtfRgPreCadastro = new javax.swing.JTextField();
        jbuUtilizarPreCadastro = new javax.swing.JButton();
        jpaCalendario = new javax.swing.JPanel();
        jdcData = new com.toedter.calendar.JDayChooser();
        jmcData = new com.toedter.calendar.JMonthChooser();
        jycData = new com.toedter.calendar.JYearChooser();
        jlaAgendamentos = new javax.swing.JLabel();
        jspAgendamentos = new javax.swing.JScrollPane();
        jtaAgendamentos = new javax.swing.JTable();
        jbuNovo = new javax.swing.JButton();
        jbuCancelar = new javax.swing.JButton();
        jbuFechar = new javax.swing.JButton();
        jbuAssociar = new javax.swing.JButton();
        jbuCopiar = new javax.swing.JButton();
        jbuLiberar = new javax.swing.JButton();
        jbuReagendar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(TelaAgendaGerenAgendamento.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        setUndecorated(true);

        jpaGerenAgenda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpaGerenAgenda.setName("jpaGerenAgenda"); // NOI18N
        jpaGerenAgenda.setLayout(null);

        jpaTitulo.setBackground(resourceMap.getColor("jpaTitulo.background")); // NOI18N
        jpaTitulo.setName("jpaTitulo"); // NOI18N
        jpaTitulo.setLayout(null);

        jlaTitulo.setFont(resourceMap.getFont("jlaTitulo.font")); // NOI18N
        jlaTitulo.setForeground(resourceMap.getColor("jlaTitulo.foreground")); // NOI18N
        jlaTitulo.setText(resourceMap.getString("jlaTitulo.text")); // NOI18N
        jlaTitulo.setName("jlaTitulo"); // NOI18N
        jpaTitulo.add(jlaTitulo);
        jlaTitulo.setBounds(10, 0, 240, 26);

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
        jbuFecharTitulo.setBounds(1003, 1, 25, 25);

        jpaGerenAgenda.add(jpaTitulo);
        jpaTitulo.setBounds(1, 1, 1027, 26);

        jpaPesquisa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpaPesquisa.setName("jpaPesquisa"); // NOI18N
        jpaPesquisa.setLayout(null);

        jlaProfissional.setFont(resourceMap.getFont("jlaProfissional.font")); // NOI18N
        jlaProfissional.setText(resourceMap.getString("jlaProfissional.text")); // NOI18N
        jlaProfissional.setName("jlaProfissional"); // NOI18N
        jpaPesquisa.add(jlaProfissional);
        jlaProfissional.setBounds(10, 10, 130, 17);

        jcbProfissional.setFont(resourceMap.getFont("jcbProfissional.font")); // NOI18N
        jcbProfissional.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jcbProfissional.setName("jcbProfissional"); // NOI18N
        jpaPesquisa.add(jcbProfissional);
        jcbProfissional.setBounds(10, 30, 670, 25);
        jcbProfissional.getAccessibleContext().setAccessibleName(resourceMap.getString("jcbProfissional.AccessibleContext.accessibleName")); // NOI18N

        jlaTipoAtendimento.setFont(resourceMap.getFont("jlaTipoAtendimento.font")); // NOI18N
        jlaTipoAtendimento.setText(resourceMap.getString("jlaTipoAtendimento.text")); // NOI18N
        jlaTipoAtendimento.setName("jlaTipoAtendimento"); // NOI18N
        jpaPesquisa.add(jlaTipoAtendimento);
        jlaTipoAtendimento.setBounds(10, 60, 230, 17);

        jcbTipoAtendimento.setFont(resourceMap.getFont("jcbProfissional.font")); // NOI18N
        jcbTipoAtendimento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jcbTipoAtendimento.setName("jcbTipoAtendimento"); // NOI18N
        jcbTipoAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoAtendimentoActionPerformed(evt);
            }
        });
        jpaPesquisa.add(jcbTipoAtendimento);
        jcbTipoAtendimento.setBounds(10, 80, 670, 25);
        jcbTipoAtendimento.getAccessibleContext().setAccessibleName(resourceMap.getString("jcbTipoAtendimento.AccessibleContext.accessibleName")); // NOI18N

        jlaDescricaoAtendimento.setFont(resourceMap.getFont("jlaDescricaoAtendimento.font")); // NOI18N
        jlaDescricaoAtendimento.setText(resourceMap.getString("jlaDescricaoAtendimento.text")); // NOI18N
        jlaDescricaoAtendimento.setName("jlaDescricaoAtendimento"); // NOI18N
        jpaPesquisa.add(jlaDescricaoAtendimento);
        jlaDescricaoAtendimento.setBounds(10, 110, 290, 17);

        jcbDescricaoAtendimento.setFont(resourceMap.getFont("jcbDescricaoAtendimento.font")); // NOI18N
        jcbDescricaoAtendimento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jcbDescricaoAtendimento.setName("jcbDescricaoAtendimento"); // NOI18N
        jcbDescricaoAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDescricaoAtendimentoActionPerformed(evt);
            }
        });
        jpaPesquisa.add(jcbDescricaoAtendimento);
        jcbDescricaoAtendimento.setBounds(10, 130, 670, 25);
        jcbDescricaoAtendimento.getAccessibleContext().setAccessibleName(resourceMap.getString("jcbDescricaoAtendimento.AccessibleContext.accessibleName")); // NOI18N

        jlaModuloPeriodo.setFont(resourceMap.getFont("jlaModuloPeriodo.font")); // NOI18N
        jlaModuloPeriodo.setText(resourceMap.getString("jlaModuloPeriodo.text")); // NOI18N
        jlaModuloPeriodo.setToolTipText(resourceMap.getString("jlaModuloPeriodo.toolTipText")); // NOI18N
        jlaModuloPeriodo.setName("jlaModuloPeriodo"); // NOI18N
        jpaPesquisa.add(jlaModuloPeriodo);
        jlaModuloPeriodo.setBounds(10, 160, 160, 17);

        jcbModuloPeriodo.setFont(resourceMap.getFont("jcbModuloPeriodo.font")); // NOI18N
        jcbModuloPeriodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jcbModuloPeriodo.setName("jcbModuloPeriodo"); // NOI18N
        jpaPesquisa.add(jcbModuloPeriodo);
        jcbModuloPeriodo.setBounds(10, 180, 670, 25);

        jlaDataInicio.setFont(resourceMap.getFont("jlaDataInicio.font")); // NOI18N
        jlaDataInicio.setText(resourceMap.getString("jlaDataInicio.text")); // NOI18N
        jlaDataInicio.setName("jlaDataInicio"); // NOI18N
        jpaPesquisa.add(jlaDataInicio);
        jlaDataInicio.setBounds(10, 210, 90, 17);

        try {
            jftDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftDataInicio.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jftDataInicio.setFont(resourceMap.getFont("jftDataInicio.font")); // NOI18N
        jftDataInicio.setName("jftDataInicio"); // NOI18N
        jpaPesquisa.add(jftDataInicio);
        jftDataInicio.setBounds(10, 230, 100, 23);
        jftDataInicio.getAccessibleContext().setAccessibleName(resourceMap.getString("jftDataInicio.AccessibleContext.accessibleName")); // NOI18N
        jftDataInicio.getAccessibleContext().setAccessibleDescription(resourceMap.getString("jftDataInicio.AccessibleContext.accessibleDescription")); // NOI18N

        jbuSelecionarDataInicial.setFont(resourceMap.getFont("jbuSelecionarDataInicial.font")); // NOI18N
        jbuSelecionarDataInicial.setIcon(resourceMap.getIcon("jbuSelecionarDataInicial.icon")); // NOI18N
        jbuSelecionarDataInicial.setBorderPainted(false);
        jbuSelecionarDataInicial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbuSelecionarDataInicial.setLabel(resourceMap.getString("jbuSelecionarDataInicial.label")); // NOI18N
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
        jpaPesquisa.add(jbuSelecionarDataInicial);
        jbuSelecionarDataInicial.setBounds(112, 230, 25, 25);
        jbuSelecionarDataInicial.getAccessibleContext().setAccessibleName(resourceMap.getString("jbuSelecionarDataInicio.AccessibleContext.accessibleName")); // NOI18N
        jbuSelecionarDataInicial.getAccessibleContext().setAccessibleDescription(resourceMap.getString("jbuSelecionarDataInicio.AccessibleContext.accessibleDescription")); // NOI18N

        jlaDataTermino.setFont(resourceMap.getFont("jlaDataTermino.font")); // NOI18N
        jlaDataTermino.setText(resourceMap.getString("jlaDataTermino.text")); // NOI18N
        jlaDataTermino.setName("jlaDataTermino"); // NOI18N
        jpaPesquisa.add(jlaDataTermino);
        jlaDataTermino.setBounds(160, 210, 100, 17);

        try {
            jftDataTermino.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftDataTermino.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jftDataTermino.setFont(resourceMap.getFont("jftDataTermino.font")); // NOI18N
        jftDataTermino.setName("jftDataTermino"); // NOI18N
        jpaPesquisa.add(jftDataTermino);
        jftDataTermino.setBounds(160, 230, 100, 23);
        jftDataTermino.getAccessibleContext().setAccessibleName(resourceMap.getString("jftDataFinal.AccessibleContext.accessibleName")); // NOI18N
        jftDataTermino.getAccessibleContext().setAccessibleDescription(resourceMap.getString("jftDataTermino.AccessibleContext.accessibleDescription")); // NOI18N

        jlaStatusAgendamento.setFont(resourceMap.getFont("jlaStatusAgendamento.font")); // NOI18N
        jlaStatusAgendamento.setText(resourceMap.getString("jlaStatusAgendamento.text")); // NOI18N
        jlaStatusAgendamento.setName("jlaStatusAgendamento"); // NOI18N
        jpaPesquisa.add(jlaStatusAgendamento);
        jlaStatusAgendamento.setBounds(310, 210, 220, 17);

        jcbStatusAgendamento.setFont(resourceMap.getFont("jcbStatusAgendamento.font")); // NOI18N
        jcbStatusAgendamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jcbStatusAgendamento.setName("jcbStatusAgendamento"); // NOI18N
        jpaPesquisa.add(jcbStatusAgendamento);
        jcbStatusAgendamento.setBounds(310, 230, 220, 25);
        jcbStatusAgendamento.getAccessibleContext().setAccessibleName(resourceMap.getString("jcbStatusAgendamento.AccessibleContext.accessibleName")); // NOI18N

        jbuSelecionarDataFinal.setIcon(resourceMap.getIcon("jbuSelecionarDataFinal.icon")); // NOI18N
        jbuSelecionarDataFinal.setBorderPainted(false);
        jbuSelecionarDataFinal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbuSelecionarDataFinal.setLabel(resourceMap.getString("jbuSelecionarDataFinal.label")); // NOI18N
        jbuSelecionarDataFinal.setName("jbuSelecionarDataFinal"); // NOI18N
        jbuSelecionarDataFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuSelecionarDataFinalActionPerformed(evt);
            }
        });
        jpaPesquisa.add(jbuSelecionarDataFinal);
        jbuSelecionarDataFinal.setBounds(263, 230, 25, 25);
        jbuSelecionarDataFinal.getAccessibleContext().setAccessibleName(resourceMap.getString("jbuSelecionarDataFinal.AccessibleContext.accessibleName")); // NOI18N
        jbuSelecionarDataFinal.getAccessibleContext().setAccessibleDescription(resourceMap.getString("jbuSelecionarDataInicio.AccessibleContext.accessibleDescription")); // NOI18N

        jbuPesquisar.setFont(resourceMap.getFont("jbuPesquisar.font")); // NOI18N
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
        jpaPesquisa.add(jbuPesquisar);
        jbuPesquisar.setBounds(540, 230, 140, 35);
        jbuPesquisar.getAccessibleContext().setAccessibleName(resourceMap.getString("jbuPesquisar.AccessibleContext.accessibleName")); // NOI18N

        jlaProntuario.setFont(resourceMap.getFont("jlaProntuario.font")); // NOI18N
        jlaProntuario.setText(resourceMap.getString("jlaProntuario.text")); // NOI18N
        jlaProntuario.setName("jlaProntuario"); // NOI18N
        jpaPesquisa.add(jlaProntuario);
        jlaProntuario.setBounds(10, 260, 76, 17);

        try {
            jftProntuario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftProntuario.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jftProntuario.setFont(resourceMap.getFont("jftProntuario.font")); // NOI18N
        jftProntuario.setName("jftProntuario"); // NOI18N
        jpaPesquisa.add(jftProntuario);
        jftProntuario.setBounds(10, 280, 100, 23);

        jbuUtilizarUsuario.setFont(resourceMap.getFont("jbuUtilizarUsuario.font")); // NOI18N
        jbuUtilizarUsuario.setIcon(resourceMap.getIcon("jbuUtilizarUsuario.icon")); // NOI18N
        jbuUtilizarUsuario.setText(resourceMap.getString("jbuUtilizarUsuario.text")); // NOI18N
        jbuUtilizarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbuUtilizarUsuario.setName("jbuUtilizarUsuario"); // NOI18N
        jbuUtilizarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuUtilizarUsuarioActionPerformed(evt);
            }
        });
        jpaPesquisa.add(jbuUtilizarUsuario);
        jbuUtilizarUsuario.setBounds(120, 280, 140, 35);
        jbuUtilizarUsuario.getAccessibleContext().setAccessibleName(resourceMap.getString("jbuUtilizar.AccessibleContext.accessibleName")); // NOI18N

        jlaRgPreCadastro.setFont(resourceMap.getFont("jlaRgPreCadastro.font")); // NOI18N
        jlaRgPreCadastro.setText(resourceMap.getString("jlaRgPreCadastro.text")); // NOI18N
        jlaRgPreCadastro.setName("jlaRgPreCadastro"); // NOI18N
        jpaPesquisa.add(jlaRgPreCadastro);
        jlaRgPreCadastro.setBounds(270, 260, 34, 14);

        jtfRgPreCadastro.setFont(resourceMap.getFont("jtfRgPreCadastro.font")); // NOI18N
        jtfRgPreCadastro.setText(resourceMap.getString("jtfRgPreCadastro.text")); // NOI18N
        jtfRgPreCadastro.setName("jtfRgPreCadastro"); // NOI18N
        jpaPesquisa.add(jtfRgPreCadastro);
        jtfRgPreCadastro.setBounds(270, 280, 110, 23);

        jbuUtilizarPreCadastro.setFont(resourceMap.getFont("jbuUtilizarPreCadastro.font")); // NOI18N
        jbuUtilizarPreCadastro.setIcon(resourceMap.getIcon("jbuUtilizarPreCadastro.icon")); // NOI18N
        jbuUtilizarPreCadastro.setText(resourceMap.getString("jbuUtilizarPreCadastro.text")); // NOI18N
        jbuUtilizarPreCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbuUtilizarPreCadastro.setName("jbuUtilizarPreCadastro"); // NOI18N
        jbuUtilizarPreCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuUtilizarPreCadastroActionPerformed(evt);
            }
        });
        jpaPesquisa.add(jbuUtilizarPreCadastro);
        jbuUtilizarPreCadastro.setBounds(390, 280, 140, 35);
        jbuUtilizarPreCadastro.getAccessibleContext().setAccessibleName(resourceMap.getString("jbuUtilizarPreCadastro.AccessibleContext.accessibleName")); // NOI18N

        jpaGerenAgenda.add(jpaPesquisa);
        jpaPesquisa.setBounds(0, 26, 690, 320);

        jpaCalendario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpaCalendario.setName("jpaCalendario"); // NOI18N
        jpaCalendario.setLayout(null);

        jdcData.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("jdcData.border.lineColor"))); // NOI18N
        jdcData.setAlwaysFireDayProperty(true);
        jdcData.setDecorationBackgroundColor(resourceMap.getColor("jdcData.decorationBackgroundColor")); // NOI18N
        jdcData.setFont(resourceMap.getFont("jdcData.font")); // NOI18N
        jdcData.setName("jdcData"); // NOI18N
        jdcData.setSundayForeground(resourceMap.getColor("jdcData.sundayForeground")); // NOI18N
        jdcData.setWeekdayForeground(resourceMap.getColor("jdcData.weekdayForeground")); // NOI18N
        jdcData.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcDataPropertyChange(evt);
            }
        });
        jpaCalendario.add(jdcData);
        jdcData.setBounds(10, 40, 320, 270);

        jmcData.setFont(resourceMap.getFont("jycData.font")); // NOI18N
        jmcData.setName("jmcData"); // NOI18N
        jmcData.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jmcDataPropertyChange(evt);
            }
        });
        jpaCalendario.add(jmcData);
        jmcData.setBounds(10, 10, 120, 25);

        jycData.setFont(resourceMap.getFont("jycData.font")); // NOI18N
        jycData.setName("jycData"); // NOI18N
        jycData.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jycDataPropertyChange(evt);
            }
        });
        jpaCalendario.add(jycData);
        jycData.setBounds(240, 10, 90, 25);

        jpaGerenAgenda.add(jpaCalendario);
        jpaCalendario.setBounds(689, 26, 340, 320);

        jlaAgendamentos.setFont(resourceMap.getFont("jlaAgendamentos.font")); // NOI18N
        jlaAgendamentos.setText(resourceMap.getString("jlaAgendamentos.text")); // NOI18N
        jlaAgendamentos.setName("jlaAgendamentos"); // NOI18N
        jpaGerenAgenda.add(jlaAgendamentos);
        jlaAgendamentos.setBounds(10, 350, 130, 17);

        jspAgendamentos.setName("jspAgendamentos"); // NOI18N

        jtaAgendamentos.setAutoCreateRowSorter(true);
        jtaAgendamentos.setFont(resourceMap.getFont("jtaAgendamentos.font")); // NOI18N
        jtaAgendamentos.setModel(new ModeloTabelaAgendamento());
        jtaAgendamentos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtaAgendamentos.setName("jtaAgendamentos"); // NOI18N
        jtaAgendamentos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtaAgendamentos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtaAgendamentosKeyPressed(evt);
            }
        });
        jspAgendamentos.setViewportView(jtaAgendamentos);
        jtaAgendamentos.getAccessibleContext().setAccessibleName(resourceMap.getString("jtaAgendamentos.AccessibleContext.accessibleName")); // NOI18N

        jpaGerenAgenda.add(jspAgendamentos);
        jspAgendamentos.setBounds(10, 370, 1010, 290);

        jbuNovo.setFont(resourceMap.getFont("jbuNovo.font")); // NOI18N
        jbuNovo.setIcon(resourceMap.getIcon("jbuNovo.icon")); // NOI18N
        jbuNovo.setMnemonic('n');
        jbuNovo.setText(resourceMap.getString("jbuNovo.text")); // NOI18N
        jbuNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbuNovo.setName("jbuNovo"); // NOI18N
        jbuNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuNovoActionPerformed(evt);
            }
        });
        jpaGerenAgenda.add(jbuNovo);
        jbuNovo.setBounds(10, 670, 100, 33);
        jbuNovo.getAccessibleContext().setAccessibleName(resourceMap.getString("jbuNovo.AccessibleContext.accessibleName")); // NOI18N

        jbuCancelar.setFont(resourceMap.getFont("jbuNovo.font")); // NOI18N
        jbuCancelar.setIcon(resourceMap.getIcon("jbuCancelar.icon")); // NOI18N
        jbuCancelar.setMnemonic('C');
        jbuCancelar.setText(resourceMap.getString("jbuCancelar.text")); // NOI18N
        jbuCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbuCancelar.setName("jbuCancelar"); // NOI18N
        jbuCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuCancelarActionPerformed(evt);
            }
        });
        jpaGerenAgenda.add(jbuCancelar);
        jbuCancelar.setBounds(420, 670, 130, 33);
        jbuCancelar.getAccessibleContext().setAccessibleName(resourceMap.getString("jbuCancelar.AccessibleContext.accessibleName")); // NOI18N

        jbuFechar.setFont(resourceMap.getFont("jbuNovo.font")); // NOI18N
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
        jpaGerenAgenda.add(jbuFechar);
        jbuFechar.setBounds(900, 670, 120, 33);
        jbuFechar.getAccessibleContext().setAccessibleName(resourceMap.getString("jbuFechar.AccessibleContext.accessibleName")); // NOI18N

        jbuAssociar.setFont(resourceMap.getFont("jbuAssociar.font")); // NOI18N
        jbuAssociar.setIcon(resourceMap.getIcon("jbuAssociar.icon")); // NOI18N
        jbuAssociar.setMnemonic('A');
        jbuAssociar.setText(resourceMap.getString("jbuAssociar.text")); // NOI18N
        jbuAssociar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbuAssociar.setName("jbuAssociar"); // NOI18N
        jbuAssociar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuAssociarActionPerformed(evt);
            }
        });
        jpaGerenAgenda.add(jbuAssociar);
        jbuAssociar.setBounds(150, 670, 130, 33);
        jbuAssociar.getAccessibleContext().setAccessibleName(resourceMap.getString("jbuAssociar.AccessibleContext.accessibleName")); // NOI18N

        jbuCopiar.setFont(resourceMap.getFont("jbuCopiar.font")); // NOI18N
        jbuCopiar.setIcon(resourceMap.getIcon("jbuCopiar.icon")); // NOI18N
        jbuCopiar.setMnemonic('O');
        jbuCopiar.setText(resourceMap.getString("jbuCopiar.text")); // NOI18N
        jbuCopiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbuCopiar.setName("jbuCopiar"); // NOI18N
        jbuCopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuCopiarActionPerformed(evt);
            }
        });
        jpaGerenAgenda.add(jbuCopiar);
        jbuCopiar.setBounds(290, 670, 120, 33);
        jbuCopiar.getAccessibleContext().setAccessibleName(resourceMap.getString("jbuCopiar.AccessibleContext.accessibleName")); // NOI18N

        jbuLiberar.setFont(resourceMap.getFont("jbuLiberar.font")); // NOI18N
        jbuLiberar.setIcon(resourceMap.getIcon("jbuLiberar.icon")); // NOI18N
        jbuLiberar.setMnemonic('l');
        jbuLiberar.setText(resourceMap.getString("jbuLiberar.text")); // NOI18N
        jbuLiberar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbuLiberar.setName("jbuLiberar"); // NOI18N
        jbuLiberar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuLiberarActionPerformed(evt);
            }
        });
        jpaGerenAgenda.add(jbuLiberar);
        jbuLiberar.setBounds(560, 670, 140, 33);

        jbuReagendar.setFont(resourceMap.getFont("jbuReagendar.font")); // NOI18N
        jbuReagendar.setIcon(resourceMap.getIcon("jbuReagendar.icon")); // NOI18N
        jbuReagendar.setMnemonic('R');
        jbuReagendar.setText(resourceMap.getString("jbuReagendar.text")); // NOI18N
        jbuReagendar.setName("jbuReagendar"); // NOI18N
        jbuReagendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuReagendarActionPerformed(evt);
            }
        });
        jpaGerenAgenda.add(jbuReagendar);
        jbuReagendar.setBounds(710, 670, 141, 33);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpaGerenAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpaGerenAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbuSelecionarDataInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuSelecionarDataInicialActionPerformed
        JOptionPanePersonalizado.mostrarTelaSelecionarData(this, jftDataInicio);
    }//GEN-LAST:event_jbuSelecionarDataInicialActionPerformed

    private void jbuSelecionarDataFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuSelecionarDataFinalActionPerformed
        JOptionPanePersonalizado.mostrarTelaSelecionarData(this, jftDataTermino);
    }//GEN-LAST:event_jbuSelecionarDataFinalActionPerformed

    private void jbuFecharTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuFecharTituloActionPerformed
        controlador.fecharTela();
    }//GEN-LAST:event_jbuFecharTituloActionPerformed

    private void jbuFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuFecharActionPerformed
        controlador.fecharTela();
    }//GEN-LAST:event_jbuFecharActionPerformed

    private void jbuUtilizarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuUtilizarUsuarioActionPerformed
        controlador.localizarUsuario();
    }//GEN-LAST:event_jbuUtilizarUsuarioActionPerformed

    private void jbuNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuNovoActionPerformed
        controlador.novoAgendamento();
    }//GEN-LAST:event_jbuNovoActionPerformed

    private void jbuPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuPesquisarActionPerformed
        controlador.efetuarPesquisa();
    }//GEN-LAST:event_jbuPesquisarActionPerformed

    private void jcbTipoAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoAtendimentoActionPerformed
        controlador.inicializarDescricaoTipoAtendimento();
    }//GEN-LAST:event_jcbTipoAtendimentoActionPerformed

    private void jbuCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuCancelarActionPerformed
        controlador.abrirTelaAgendaEditarCancelamento();
    }//GEN-LAST:event_jbuCancelarActionPerformed

    private void jbuAssociarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuAssociarActionPerformed
        controlador.abrirTelaAgendaEditarAssociacao();
    }//GEN-LAST:event_jbuAssociarActionPerformed

    private void jbuCopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuCopiarActionPerformed
        controlador.efetuarCopiaAgendamento();
    }//GEN-LAST:event_jbuCopiarActionPerformed

    private void jcbDescricaoAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDescricaoAtendimentoActionPerformed
        controlador.inicializarModuloAtividade();
    }//GEN-LAST:event_jcbDescricaoAtendimentoActionPerformed

    private void jbuUtilizarPreCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuUtilizarPreCadastroActionPerformed
        controlador.localizarPreCadastro();
    }//GEN-LAST:event_jbuUtilizarPreCadastroActionPerformed

    private void jdcDataPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcDataPropertyChange
        if (controlador != null){
            controlador.pesquisarAgendamentoUsandoCalendario();
        }
    }//GEN-LAST:event_jdcDataPropertyChange

    private void jmcDataPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jmcDataPropertyChange
        jdcData.setMonth(jmcData.getMonth());
    }//GEN-LAST:event_jmcDataPropertyChange

    private void jycDataPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jycDataPropertyChange
        jdcData.setYear(jycData.getYear());
    }//GEN-LAST:event_jycDataPropertyChange

    private void jbuLiberarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuLiberarActionPerformed
        controlador.liberarAgendamentoSelecionado();
    }//GEN-LAST:event_jbuLiberarActionPerformed

    private void jtaAgendamentosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtaAgendamentosKeyPressed
        controlador.transferirFocoNaTabulacao(evt);
        controlador.copiarDadosTabelaESalvar(evt, jtaAgendamentos);
    }//GEN-LAST:event_jtaAgendamentosKeyPressed

    private void jbuReagendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuReagendarActionPerformed
        controlador.abrirTelaReagendamento();
    }//GEN-LAST:event_jbuReagendarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbuAssociar;
    private javax.swing.JButton jbuCancelar;
    private javax.swing.JButton jbuCopiar;
    private javax.swing.JButton jbuFechar;
    private javax.swing.JButton jbuFecharTitulo;
    private javax.swing.JButton jbuLiberar;
    private javax.swing.JButton jbuNovo;
    private javax.swing.JButton jbuPesquisar;
    private javax.swing.JButton jbuReagendar;
    private javax.swing.JButton jbuSelecionarDataFinal;
    private javax.swing.JButton jbuSelecionarDataInicial;
    private javax.swing.JButton jbuUtilizarPreCadastro;
    private javax.swing.JButton jbuUtilizarUsuario;
    private javax.swing.JComboBox jcbDescricaoAtendimento;
    private javax.swing.JComboBox jcbModuloPeriodo;
    private javax.swing.JComboBox jcbProfissional;
    private javax.swing.JComboBox jcbStatusAgendamento;
    private javax.swing.JComboBox jcbTipoAtendimento;
    private com.toedter.calendar.JDayChooser jdcData;
    private javax.swing.JFormattedTextField jftDataInicio;
    private javax.swing.JFormattedTextField jftDataTermino;
    private javax.swing.JFormattedTextField jftProntuario;
    private javax.swing.JLabel jlaAgendamentos;
    private javax.swing.JLabel jlaDataInicio;
    private javax.swing.JLabel jlaDataTermino;
    private javax.swing.JLabel jlaDescricaoAtendimento;
    private javax.swing.JLabel jlaModuloPeriodo;
    private javax.swing.JLabel jlaProfissional;
    private javax.swing.JLabel jlaProntuario;
    private javax.swing.JLabel jlaRgPreCadastro;
    private javax.swing.JLabel jlaStatusAgendamento;
    private javax.swing.JLabel jlaTipoAtendimento;
    private javax.swing.JLabel jlaTitulo;
    private com.toedter.calendar.JMonthChooser jmcData;
    private javax.swing.JPanel jpaCalendario;
    private javax.swing.JPanel jpaGerenAgenda;
    private javax.swing.JPanel jpaPesquisa;
    private javax.swing.JPanel jpaTitulo;
    private javax.swing.JScrollPane jspAgendamentos;
    private javax.swing.JTable jtaAgendamentos;
    private javax.swing.JTextField jtfRgPreCadastro;
    private com.toedter.calendar.JYearChooser jycData;
    // End of variables declaration//GEN-END:variables
    private ControladorTelaAgendaGerenAgendamento controlador;
}
