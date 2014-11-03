/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jarves.formularios;


import br.com.jarves.bancodedados.AnimalDAO;
import br.com.jarves.bancodedados.EspecieDAO;
import br.com.jarves.bancodedados.RacaDAO;
import br.com.jarves.classes.Animal;
import br.com.jarves.classes.Cliente;
import br.com.jarves.classes.Especie;
import br.com.jarves.classes.Raca;
import br.com.jarves.classes.Util;
import br.com.jarves.util.Global;
import br.com.jarves.util.LimiteDigitos;
import java.awt.Dimension;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;



/**
 *
 * @author Humberto
 */
public class jifCadAnimal extends javax.swing.JInternalFrame  {

    public static String cpf;
    public jifCadAnimal() {
        initComponents();
        
        jtfNCliente.setDocument(new LimiteDigitos(60));
        jtfPeso.setDocument(new LimiteDigitos(60));
        carregaEspecie();
        Global.jtfCliente = jtfNCliente;
        Global.cpf = jblCpf;
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jtfNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jcbStatus = new javax.swing.JComboBox();
        jbtInserir = new javax.swing.JButton();
        jbtVoltar = new javax.swing.JButton();
        jtfPeso = new javax.swing.JTextField();
        jdcNasc = new com.toedter.calendar.JDateChooser();
        jcbSexo = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jtfNCliente = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jtfObs1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jbtPesEnd1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jcbEspecie = new javax.swing.JComboBox();
        jcbRaca = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        jblCpf = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setForeground(java.awt.Color.red);
        setName(""); // NOI18N
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Animais"));
        jPanel2.setToolTipText("Cadastro de Animal");
        jPanel2.setLayout(null);

        jtfNome.setToolTipText("Informe o Nome do Cliente");
        jtfNome.setNextFocusableComponent(jdcNasc);
        jPanel2.add(jtfNome);
        jtfNome.setBounds(120, 90, 240, 30);

        jLabel1.setText("Dt Nascimento:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(30, 170, 80, 30);

        jButton1.setText("jButton1");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(460, 120, 110, 40);

        jLabel7.setText("Status:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(200, 130, 80, 30);

        jLabel8.setText("Nome:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(70, 90, 80, 30);

        jLabel13.setText("Sexo:");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(70, 210, 50, 30);

        jcbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Ativo", "Inativo" }));
        jcbStatus.setToolTipText("Selecione o Sexo");
        jcbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbStatusActionPerformed(evt);
            }
        });
        jPanel2.add(jcbStatus);
        jcbStatus.setBounds(250, 130, 110, 30);

        jbtInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jarves/icones/inserir.png.png"))); // NOI18N
        jbtInserir.setMnemonic('i');
        jbtInserir.setText("Inserir");
        jbtInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtInserirActionPerformed(evt);
            }
        });
        jPanel2.add(jbtInserir);
        jbtInserir.setBounds(460, 20, 110, 40);

        jbtVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jarves/icones/voltar.png.jpg"))); // NOI18N
        jbtVoltar.setText("Voltar");
        jbtVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtVoltarActionPerformed(evt);
            }
        });
        jPanel2.add(jbtVoltar);
        jbtVoltar.setBounds(460, 70, 110, 40);

        jtfPeso.setNextFocusableComponent(jtfNome);
        jtfPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfPesoKeyTyped(evt);
            }
        });
        jPanel2.add(jtfPeso);
        jtfPeso.setBounds(120, 130, 70, 30);

        jdcNasc.setNextFocusableComponent(jcbStatus);
        jPanel2.add(jdcNasc);
        jdcNasc.setBounds(120, 170, 160, 30);

        jcbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Masculino", "Feminino" }));
        jcbSexo.setToolTipText("Selecione o Sexo");
        jPanel2.add(jcbSexo);
        jcbSexo.setBounds(120, 210, 160, 30);

        jLabel15.setText("Peso:");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(70, 130, 80, 30);

        jtfNCliente.setEditable(false);
        jtfNCliente.setToolTipText("Informe o Nome do Cliente");
        jtfNCliente.setNextFocusableComponent(jdcNasc);
        jPanel2.add(jtfNCliente);
        jtfNCliente.setBounds(120, 50, 240, 30);

        jLabel17.setText("Proprietário:");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(40, 50, 80, 30);

        jtfObs1.setNextFocusableComponent(jbtInserir);
        jPanel2.add(jtfObs1);
        jtfObs1.setBounds(120, 330, 320, 30);

        jLabel18.setText("Observações:");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(40, 330, 80, 30);

        jbtPesEnd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jarves/icones/lupa_16x16.png"))); // NOI18N
        jbtPesEnd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPesEnd1ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtPesEnd1);
        jbtPesEnd1.setBounds(370, 50, 30, 30);

        jLabel19.setText("Espécie:");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(70, 250, 50, 30);

        jcbEspecie.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));
        jcbEspecie.setToolTipText("Selecione o Sexo");
        jcbEspecie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbEspecieMouseClicked(evt);
            }
        });
        jcbEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEspecieActionPerformed(evt);
            }
        });
        jcbEspecie.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jcbEspeciePropertyChange(evt);
            }
        });
        jPanel2.add(jcbEspecie);
        jcbEspecie.setBounds(120, 250, 160, 30);

        jcbRaca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));
        jcbRaca.setToolTipText("Selecione o Sexo");
        jPanel2.add(jcbRaca);
        jcbRaca.setBounds(120, 290, 160, 30);

        jLabel20.setText("Raça:");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(70, 290, 50, 30);
        jPanel2.add(jblCpf);
        jblCpf.setBounds(120, 24, 150, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 10, 580, 480);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 650, 510);

        setBounds(0, 0, 610, 526);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println(cpf);
        /*if (jdcNasc.getDate() != null) {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String data = formato.format(jdcNasc.getDate());
            System.out.println(data);
            Date d = new Date();
            
            if(jdcNasc.getDate().after(d)){System.out.println("não pode porra");}
            System.out.println(d + "\n"+ jdcNasc.getDate());
        } else {
            JOptionPane.showMessageDialog(null, "Malucão");
        }*/
    }//GEN-LAST:event_jButton1ActionPerformed
    

    private void jdcNascPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcNascPropertyChange

    }//GEN-LAST:event_jdcNascPropertyChange
 
    private void jbtInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtInserirActionPerformed

        Util u = new Util();
        
       
        if(validaDados()){
            Animal animal = new Animal();
            AnimalDAO ad = new AnimalDAO();
            Raca raca = new Raca();
            Cliente c = new Cliente();
            
            animal.setNome(jtfNome.getText().toLowerCase().trim());
            animal.setPeso(Double.parseDouble(jtfPeso.getText().trim()));
            animal.setStatus(jcbStatus.getSelectedItem().toString().toLowerCase());
            animal.setObs(jtfObs1.getText().trim());
            animal.setSexo(jcbSexo.getSelectedItem().toString().toLowerCase());
            
            try {
                animal.setDtNasc(u.data(jdcNasc.getDate()));
            } catch (ParseException ex) {
                Logger.getLogger(jifCadAnimal.class.getName()).log(Level.SEVERE, null, ex);
            }
            c.setCpf(u.formataCpf(cpf));
            raca.setIdRaca(jcbRaca.getSelectedIndex());
            
            animal.setCliente(c);
            
            animal.setRaca(raca);
            System.out.println(animal.getRaca().getIdRaca());
            JOptionPane.showMessageDialog(null, ad.insereAnimal(animal));
            limparCampos(); 
        }
    
    }//GEN-LAST:event_jbtInserirActionPerformed
    /**
     * Método para limpar todos os campos
     */
    public void limparCampos() {
        
        jblCpf.setText("");
        jtfNCliente.setText("");
        jtfNome.setText("");
        jtfPeso.setText("");
        jdcNasc.setDate(null);
        jcbStatus.setSelectedIndex(0);
        jcbSexo.setSelectedIndex(0);
        jcbEspecie.setSelectedIndex(0);
        jcbRaca.setSelectedIndex(0);
        jtfObs1.setText("");
          
    }
    

    private void jbtVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtVoltarActionPerformed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        
    }//GEN-LAST:event_jPanel1KeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
      
    }//GEN-LAST:event_formKeyPressed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
         
    }//GEN-LAST:event_formKeyTyped

    private void jbtPesEnd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPesEnd1ActionPerformed
        JifConCliente jie = new JifConCliente();
        Global.jdpPrincipal.add(jie);
        ((BasicInternalFrameUI) jie.getUI()).setNorthPane(null);
        jie.setPosicao();
        jie.flag = 1;
        jie.setVisible(true);
    }//GEN-LAST:event_jbtPesEnd1ActionPerformed

    private void jcbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbStatusActionPerformed

    private void jcbEspecieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbEspecieMouseClicked
       
    }//GEN-LAST:event_jcbEspecieMouseClicked

    private void jcbEspeciePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jcbEspeciePropertyChange
      
    }//GEN-LAST:event_jcbEspeciePropertyChange

    private void jcbEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEspecieActionPerformed
        if(jcbEspecie.getSelectedIndex()>0){
            carregaRaca();
        }else{
            jcbRaca.removeAllItems();
            jcbRaca.addItem("Selecione...");
        }
    }//GEN-LAST:event_jcbEspecieActionPerformed

    private void jtfPesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesoKeyTyped
        String caracteres="0987654321.";
        if(!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
    }//GEN-LAST:event_jtfPesoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jblCpf;
    private javax.swing.JButton jbtInserir;
    private javax.swing.JButton jbtPesEnd1;
    private javax.swing.JButton jbtVoltar;
    private javax.swing.JComboBox jcbEspecie;
    private javax.swing.JComboBox jcbRaca;
    private javax.swing.JComboBox jcbSexo;
    private javax.swing.JComboBox jcbStatus;
    private com.toedter.calendar.JDateChooser jdcNasc;
    private javax.swing.JTextField jtfNCliente;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfObs1;
    private javax.swing.JTextField jtfPeso;
    // End of variables declaration//GEN-END:variables

    /**
     * Abre a tela no meio do formulário
     */
    public void setPosicao() {        
        Dimension d = this.getDesktopPane().getSize();        
        this.setLocation((d.width - this.getSize().width) / 2, 0);
    }
    public void carregaEspecie(){
                    
        ArrayList<Especie> lista = new EspecieDAO().listarEspecie();
               
        for (Especie lista1 : lista) {
            jcbEspecie.addItem(lista1.getEspecie());
        }
        
    }
      public void carregaRaca(){
                    
        ArrayList<Raca> lista = new RacaDAO().listarRacas(jcbEspecie.getSelectedIndex());
        jcbRaca.removeAllItems();
        jcbRaca.addItem("Selecione...");
        for (Raca lista1 : lista) {
            jcbRaca.addItem(lista1.getRaca());
        }
        
    }
    public boolean validaDados(){
        boolean retorno = false;
        Date d = new Date();
        if(jtfNCliente.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Por Favor Selecione um Proprietário");
        }else if(jtfNome.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Por Favor Informe o Nome do Animal");
        }else if(jtfPeso.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Por Favor Informe um Peso Válido");
        }else if(jcbStatus.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Por Favor Selecione um Status");
        }else if(jdcNasc.getDate() == null){
            JOptionPane.showMessageDialog(null, "Por Favor Selecione Uma Data de Nascimento");
        }else if (jcbSexo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Por Favor Selecione o Sexo");
        }else if(jcbEspecie.getSelectedIndex() ==0){
            JOptionPane.showMessageDialog(null, "Por Favor Selecione a Espécie");  
        }else if(jcbRaca.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Por Favor Selecione a Raça");
        }else if(jdcNasc.getDate().after(d)){
            JOptionPane.showMessageDialog(null, "Data de Nascimento Não Pode Ser Superior a Data Atual");
        }else{
           retorno = true;
        } 
        return  retorno;

    }   
 
}