/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jarves.formularios;

import br.com.jarves.bancodedados.EnderecoDAO;
import br.com.jarves.classes.Logradouro;
import br.com.jarves.classes.TableFormat;
import br.com.jarves.classes.Util;
import br.com.jarves.util.Global;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
//import net.proteanit.sql.DbUtils;

/**
 *
 * @author Humberto
 */
public class jifConEnd extends javax.swing.JInternalFrame {

    /**
     * Creates new form jifConEnd
     */
    public jifConEnd() {
        initComponents();
        carregaLista();
        
        //jtbEndereco.setModel(DbUtils.resultSetToTableModel(EnderecoDAO.listarEnderecos()));
    }
   
public int flag;
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
        jtfEndereco = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbEndereco = new javax.swing.JTable();
        jbtVoltar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setTitle("Consulta de Endereços");
        getContentPane().setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta de Endereços"));
        jPanel2.setLayout(null);

        jLabel1.setText("Endereço:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(30, 80, 80, 20);

        jtfEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfEnderecoActionPerformed(evt);
            }
        });
        jtfEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfEnderecoKeyReleased(evt);
            }
        });
        jPanel2.add(jtfEndereco);
        jtfEndereco.setBounds(100, 70, 410, 30);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(10, 130, 760, 20);

        jtbEndereco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbEndereco.setToolTipText("Lista de Endereços");
        jtbEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbEnderecoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbEndereco);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 160, 760, 170);

        jbtVoltar.setText("Voltar");
        jbtVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtVoltarActionPerformed(evt);
            }
        });
        jPanel2.add(jbtVoltar);
        jbtVoltar.setBounds(530, 60, 100, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 780, 340);

        setBounds(0, 0, 791, 377);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtVoltarActionPerformed

    private void jtfEnderecoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEnderecoKeyReleased
       
    if(jtfEndereco.getText().length()>4)
        filtraLista();
    else
        carregaLista();
    }//GEN-LAST:event_jtfEnderecoKeyReleased

    private void jtfEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfEnderecoActionPerformed

    private void jtbEnderecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbEnderecoMouseClicked
        if(evt.getClickCount()>1){
            if (flag ==1){
                int indiceLinha = jtbEndereco.getSelectedRow();
                Object cep = jtbEndereco.getValueAt(indiceLinha, 2);
                Global.jtfCep.setText(cep.toString());
                
                Global.jtfCep.grabFocus();
                flag =0;
                this.dispose();
            }
           
       }
      
    }//GEN-LAST:event_jtbEnderecoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbtVoltar;
    private javax.swing.JTable jtbEndereco;
    private javax.swing.JTextField jtfEndereco;
    // End of variables declaration//GEN-END:variables

    /**
     * Método para alinhar o internal frame no meio da tela
     */
    public void setPosicao() {  
        Dimension d = this.getDesktopPane().getSize();  
        this.setLocation((d.width - this.getSize().width) / 2, 0);
    }
    
    public void carregaLista(){
        Util u = new Util();
        String titulo[] = {"Endereço","Bairro","CEP","Cidade"};
        Object dados [][]={};
        DefaultTableModel modelo = new DefaultTableModel(dados,titulo){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        jtbEndereco.setDefaultRenderer(Object.class,new TableFormat());
        jtbEndereco.setModel(modelo);
        
        ArrayList<Logradouro> lista = new EnderecoDAO().listarEnderecos();
        
        for(int i = 0;i<lista.size();i++){
            modelo.addRow(new String[]{lista.get(i).getNomeRua(),lista.get(i).getBairro(),
            u.reformataCep(lista.get(i).getCep()),lista.get(i).getCidade()});
            
        }
        
        
    }
    public void filtraLista(){
        Util u = new Util();
        String titulo[] = {"Endereço","Bairro","CEP","Cidade"};
        Object dados [][]={};
        DefaultTableModel modelo = new DefaultTableModel(dados,titulo){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        jtbEndereco.setDefaultRenderer(Object.class,new TableFormat());
        jtbEndereco.setModel(modelo);
        ArrayList<Logradouro> lista = new EnderecoDAO().pesquisarEnderecos(jtfEndereco.getText().trim().toLowerCase()+"%");
        
        for(int i = 0;i<lista.size();i++){
            modelo.addRow(new String[]{lista.get(i).getNomeRua(),lista.get(i).getBairro(),
            u.reformataCep(lista.get(i).getCep()),lista.get(i).getCidade()});
                       
        }
        
    }
    
    
}

