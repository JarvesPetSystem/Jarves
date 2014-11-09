/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jarves.formularios;

import br.com.jarves.bancodedados.CategoriaDAO;
import br.com.jarves.classes.Categoria;
import br.com.jarves.classes.TableFormat;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Humberto
 */
public class jifCadCategoria extends javax.swing.JInternalFrame {

    int idCategoria;
    public jifCadCategoria() {
        initComponents();
        carregaLista();
        jbtAlterar.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfCategoria = new javax.swing.JTextField();
        jbtVoltar = new javax.swing.JButton();
        jbtGravar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCategoria = new javax.swing.JTable();
        jbtAlterar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setTitle("Registro de Categoria");
        getContentPane().setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Categorias"));
        jPanel2.setLayout(null);

        jLabel1.setText("Categoria:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(30, 80, 80, 20);

        jtfCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCategoriaActionPerformed(evt);
            }
        });
        jtfCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCategoriaKeyReleased(evt);
            }
        });
        jPanel2.add(jtfCategoria);
        jtfCategoria.setBounds(120, 70, 230, 30);

        jbtVoltar.setText("Voltar");
        jbtVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtVoltarActionPerformed(evt);
            }
        });
        jPanel2.add(jbtVoltar);
        jbtVoltar.setBounds(400, 90, 100, 40);

        jbtGravar.setText("Gravar");
        jbtGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtGravarActionPerformed(evt);
            }
        });
        jPanel2.add(jbtGravar);
        jbtGravar.setBounds(400, 40, 100, 40);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(20, 160, 500, 10);

        jtbCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbCategoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbCategoria);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 190, 500, 140);

        jbtAlterar.setText("Alterar");
        jbtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAlterarActionPerformed(evt);
            }
        });
        jPanel2.add(jbtAlterar);
        jbtAlterar.setBounds(400, 40, 100, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 0, 550, 350);

        setBounds(0, 0, 575, 404);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtVoltarActionPerformed

    private void jtfCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCategoriaKeyReleased


    }//GEN-LAST:event_jtfCategoriaKeyReleased

    private void jtfCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCategoriaActionPerformed

    private void jbtGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtGravarActionPerformed
        if (jtfCategoria.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Por Favor Informe o Nome da Categoria!");
        } else {
            CategoriaDAO cd = new CategoriaDAO();
            Categoria categoria = new Categoria();
            categoria.setNomeCategoria(jtfCategoria.getText().trim().toLowerCase());
            JOptionPane.showMessageDialog(null, cd.insereCategoria(categoria));
            jtfCategoria.setText("");
            jtfCategoria.grabFocus();

            carregaLista();
        }
    }//GEN-LAST:event_jbtGravarActionPerformed

    private void jtbCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCategoriaMouseClicked
        if(evt.getClickCount()>1){
            int indiceLinha = jtbCategoria.getSelectedRow();
            idCategoria = (int)jtbCategoria.getValueAt(indiceLinha, 0);
            Object cate = jtbCategoria.getValueAt(indiceLinha, 1);
            jtfCategoria.setText(cate.toString());
            jbtGravar.setVisible(false);
            jbtAlterar.setVisible(true);
        }
    }//GEN-LAST:event_jtbCategoriaMouseClicked

    private void jbtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAlterarActionPerformed
       if(jtfCategoria.getText().trim().equals("")){
           JOptionPane.showMessageDialog(null, "Por Favor Informe o Nome da Categoria!");
       }else{
           CategoriaDAO cd = new CategoriaDAO();
           Categoria categoria = new Categoria();
           categoria.setIdCategoria(idCategoria);
           categoria.setNomeCategoria(jtfCategoria.getText().trim().toLowerCase());
           JOptionPane.showMessageDialog(null, cd.alteraCategoria(categoria));
           jtfCategoria.setText("");
           jtfCategoria.grabFocus();
           jbtAlterar.setVisible(false);
           jbtGravar.setVisible(true);
           carregaLista();
       }
    }//GEN-LAST:event_jbtAlterarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbtAlterar;
    private javax.swing.JButton jbtGravar;
    private javax.swing.JButton jbtVoltar;
    private javax.swing.JTable jtbCategoria;
    private javax.swing.JTextField jtfCategoria;
    // End of variables declaration//GEN-END:variables

    /**
     * Método para alinhar o internal frame no meio da tela
     */
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, 0);
    }

    /**
     * Método para alimentar lista de categorias
     */
    public void carregaLista() {

        String titulopessoais[] = {"Código", "Categoria"};

        Object dados[][] = {};

        DefaultTableModel modelo = new DefaultTableModel(dados, titulopessoais) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        jtbCategoria.setDefaultRenderer(Object.class, new TableFormat());
        jtbCategoria.setModel(modelo);

        ArrayList<Categoria> lista = new CategoriaDAO().listarCategoria();

        for (Categoria lista1 : lista) {

            lista1.getIdCategoria();
            modelo.addRow(new Object[]{lista1.getIdCategoria(), lista1.getNomeCategoria()});
        }

    }

}