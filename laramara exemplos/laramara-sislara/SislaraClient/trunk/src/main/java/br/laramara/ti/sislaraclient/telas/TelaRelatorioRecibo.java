
package br.laramara.ti.sislaraclient.telas;

import br.laramara.ti.sislaraclient.controladores.ControladorTelaRelatorioRecibo;
import javax.swing.JFrame;

public class TelaRelatorioRecibo extends javax.swing.JDialog {

    /**
     * Creates new form TelaRelatorioRecibo
     */
    public TelaRelatorioRecibo(JFrame parent) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(parent);
        controlador = new ControladorTelaRelatorioRecibo(this, jtfNumeroRecibo);
        controlador.abrirTela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlaNumeroRecibo = new javax.swing.JLabel();
        jtfNumeroRecibo = new javax.swing.JTextField();
        jbuExibir = new javax.swing.JButton();
        jbuFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Imprimir Recibo");
        setResizable(false);

        jlaNumeroRecibo.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jlaNumeroRecibo.setText("N�mero do recibo");
        jlaNumeroRecibo.setName("jlaNumeroRecibo"); // NOI18N

        jtfNumeroRecibo.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jtfNumeroRecibo.setToolTipText("");
        jtfNumeroRecibo.setName("jtfNumeroRecibo"); // NOI18N

        jbuExibir.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jbuExibir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/laramara/ti/sislaraclient/telas/resources/icones/Relatorio.png"))); // NOI18N
        jbuExibir.setMnemonic('E');
        jbuExibir.setText("Exibir");
        jbuExibir.setName("jbuExibir"); // NOI18N
        jbuExibir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuExibirActionPerformed(evt);
            }
        });

        jbuFechar.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jbuFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/laramara/ti/sislaraclient/telas/resources/icones/Fechar.png"))); // NOI18N
        jbuFechar.setMnemonic('F');
        jbuFechar.setText("Fechar");
        jbuFechar.setName("jbuFechar"); // NOI18N
        jbuFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jlaNumeroRecibo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfNumeroRecibo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbuExibir)
                        .addGap(56, 56, 56)
                        .addComponent(jbuFechar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlaNumeroRecibo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNumeroRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbuExibir)
                    .addComponent(jbuFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbuExibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuExibirActionPerformed
        controlador.exibir();
    }//GEN-LAST:event_jbuExibirActionPerformed

    private void jbuFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuFecharActionPerformed
        controlador.fecharTela();
    }//GEN-LAST:event_jbuFecharActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbuExibir;
    private javax.swing.JButton jbuFechar;
    private javax.swing.JLabel jlaNumeroRecibo;
    private javax.swing.JTextField jtfNumeroRecibo;
    // End of variables declaration//GEN-END:variables
    private ControladorTelaRelatorioRecibo controlador;
}