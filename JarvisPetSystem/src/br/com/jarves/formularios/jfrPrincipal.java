/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jarves.formularios;

import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Humberto
 */
public class jfrPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form jfrPrincipal
     */
     
    public jfrPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpPrincipal = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmnCadastro = new javax.swing.JMenu();
        jmiCadCliente = new javax.swing.JMenuItem();
        jmiSair = new javax.swing.JMenuItem();
        jmnConsulta = new javax.swing.JMenu();
        jmiConsCli = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jarvis Pet System");

        jdpPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jarves/imagens/principal.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(930, 1024));
        jdpPrincipal.add(jLabel1);
        jLabel1.setBounds(360, 30, 940, 740);

        jmnCadastro.setText("Cadastro");

        jmiCadCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jmiCadCliente.setText("Clientes");
        jmiCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadClienteActionPerformed(evt);
            }
        });
        jmnCadastro.add(jmiCadCliente);

        jmiSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jmiSair.setText("Sair");
        jmiSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSairActionPerformed(evt);
            }
        });
        jmnCadastro.add(jmiSair);

        jMenuBar1.add(jmnCadastro);

        jmnConsulta.setText("Consultas");

        jmiConsCli.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jmiConsCli.setText("Endereços");
        jmiConsCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConsCliActionPerformed(evt);
            }
        });
        jmnConsulta.add(jmiConsCli);

        jMenuBar1.add(jmnConsulta);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(416, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmiCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadClienteActionPerformed
       jifCadClie jic = new jifCadClie();
       jdpPrincipal.add(jic);
       ((BasicInternalFrameUI)jic.getUI()).setNorthPane(null);
       //jic.setBorder(null); insere bordas no formulário
       jic.setPosicao();
       jic.setVisible(true);
       
    }//GEN-LAST:event_jmiCadClienteActionPerformed

    private void jmiConsCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConsCliActionPerformed
        jifConEnd jie = new jifConEnd();
        jdpPrincipal.add(jie);
        
        
        //jifCadCli jic = new jifCadCli();
       //jdpPrincipal.add(jic);
       ((BasicInternalFrameUI)jie.getUI()).setNorthPane(null);
       //jie.setBorder(null); //insere bordas no formulário
       jie.setPosicao();
       jie.setVisible(true);
    }//GEN-LAST:event_jmiConsCliActionPerformed

    private void jmiSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSairActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Encerrar o Programa?", "Pergunta",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
      
    }//GEN-LAST:event_jmiSairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jfrPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfrPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JDesktopPane jdpPrincipal;
    private javax.swing.JMenuItem jmiCadCliente;
    private javax.swing.JMenuItem jmiConsCli;
    private javax.swing.JMenuItem jmiSair;
    private javax.swing.JMenu jmnCadastro;
    private javax.swing.JMenu jmnConsulta;
    // End of variables declaration//GEN-END:variables
}
