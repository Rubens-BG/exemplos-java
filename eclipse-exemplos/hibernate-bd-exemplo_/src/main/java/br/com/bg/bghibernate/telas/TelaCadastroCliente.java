/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bg.bghibernate.telas;

import br.com.bg.bghibernate.controladores.ControladorTelaCliente;

/**
 *
 * @author 5448
 */
public class TelaCadastroCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaCadastroCliente
     */
    public TelaCadastroCliente() {
        initComponents();
       controladorCliente = new ControladorTelaCliente(jtfNome,jtfCpf,jtfRg,jcbSexo,jtfEMail);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnDadosCliente = new javax.swing.JPanel();
        jbtSalvar = new javax.swing.JButton();
        jbtCancelar = new javax.swing.JButton();
        jlbCpf = new javax.swing.JLabel();
        jtfCpf = new javax.swing.JTextField();
        jlbRG = new javax.swing.JLabel();
        jtfRg = new javax.swing.JTextField();
        jlbSexo = new javax.swing.JLabel();
        jcbSexo = new javax.swing.JComboBox<>();
        jtfNome = new javax.swing.JTextField();
        jlbNome = new javax.swing.JLabel();
        jtfEMail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Tela Cadatro de Cliente");
        setName("jifTelaCadastroCliente"); // NOI18N

        jpnDadosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Cliente"));

        jbtSalvar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jbtSalvar.setText("Salvar");
        jbtSalvar.setPreferredSize(new java.awt.Dimension(110, 30));
        jbtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSalvarActionPerformed(evt);
            }
        });

        jbtCancelar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jbtCancelar.setText("Cancelar");
        jbtCancelar.setPreferredSize(new java.awt.Dimension(110, 30));

        jlbCpf.setText("CPF:");

        jlbRG.setText("RG:");

        jlbSexo.setText("Sexo:");

        jcbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "F", "M" }));

        jlbNome.setText("Nome:");

        jLabel1.setText("E-Mail:");

        javax.swing.GroupLayout jpnDadosClienteLayout = new javax.swing.GroupLayout(jpnDadosCliente);
        jpnDadosCliente.setLayout(jpnDadosClienteLayout);
        jpnDadosClienteLayout.setHorizontalGroup(
            jpnDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDadosClienteLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jbtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 522, Short.MAX_VALUE)
                .addComponent(jbtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
            .addGroup(jpnDadosClienteLayout.createSequentialGroup()
                .addGroup(jpnDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnDadosClienteLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jpnDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbNome)
                            .addComponent(jlbCpf))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnDadosClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)))
                .addGroup(jpnDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpnDadosClienteLayout.createSequentialGroup()
                        .addGroup(jpnDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jpnDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbSexo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlbRG, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfRg)
                            .addComponent(jcbSexo, 0, 140, Short.MAX_VALUE)))
                    .addComponent(jtfEMail))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnDadosClienteLayout.setVerticalGroup(
            jpnDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDadosClienteLayout.createSequentialGroup()
                .addGroup(jpnDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnDadosClienteLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jpnDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jpnDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnDadosClienteLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jlbRG))
                    .addGroup(jpnDadosClienteLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jpnDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbNome)
                            .addComponent(jlbSexo)))
                    .addGroup(jpnDadosClienteLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jlbCpf)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfEMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(jpnDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jpnDadosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnDadosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSalvarActionPerformed
      controladorCliente.salvar();
    }//GEN-LAST:event_jbtSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbtCancelar;
    private javax.swing.JButton jbtSalvar;
    private javax.swing.JComboBox<String> jcbSexo;
    private javax.swing.JLabel jlbCpf;
    private javax.swing.JLabel jlbNome;
    private javax.swing.JLabel jlbRG;
    private javax.swing.JLabel jlbSexo;
    private javax.swing.JPanel jpnDadosCliente;
    private javax.swing.JTextField jtfCpf;
    private javax.swing.JTextField jtfEMail;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfRg;
    // End of variables declaration//GEN-END:variables
ControladorTelaCliente controladorCliente;
}