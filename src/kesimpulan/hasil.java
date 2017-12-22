/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kesimpulan;

import java.util.ArrayList;
import javax.swing.JOptionPane; 
import metode.ARM;
import metode.AssociationRuleMining;
import pola_kompetensi.dashboard;
import pola_kompetensi.kelola_data;
/**
 *
 * @author Supandi Doank
 */
public class hasil extends javax.swing.JFrame {

    /**
     * Creates new form hasil
     */
    String[] hasil;
    String[] itemSet;
    char[] abjad = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
            'O','P','Q','R','S','T','U','V','W','X','Y','Z'
        };
    public ArrayList<Object[]> listsHasil = new ArrayList<Object[]>();
    public AssociationRuleMining associationRuleMining = new AssociationRuleMining();
    
    public hasil() {
        initComponents();
    }
    
    public void setAttribute(ArrayList<Object[]> listsHasil){
        this.listsHasil = (ArrayList<Object[]>)listsHasil.clone();
    }
    
    public void buildConclusion(){
        int i;
        
        for(i=0;i<listsHasil.size();i++){
            String text = (String)listsHasil.get(i)[0];
            String conclusion = associationRuleMining.getConclusionText(text.split(","));
            System.out.println(text+" "+conclusion);
            jTextArea1.append((i+1)+". "+conclusion+"\n\n");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bcg1 = new pola_kompetensi.bcg();
        panelWarnaTransparan1 = new Tampilan.PanelWarnaTransparan();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        SubHome = new javax.swing.JMenuItem();
        SubKD = new javax.swing.JMenuItem();
        SubExit = new javax.swing.JMenuItem();
        Menu_View = new javax.swing.JMenu();
        SubMenu_ARM = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        submenu_result = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Result ARM");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout panelWarnaTransparan1Layout = new javax.swing.GroupLayout(panelWarnaTransparan1);
        panelWarnaTransparan1.setLayout(panelWarnaTransparan1Layout);
        panelWarnaTransparan1Layout.setHorizontalGroup(
            panelWarnaTransparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        panelWarnaTransparan1Layout.setVerticalGroup(
            panelWarnaTransparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
        );

        jLabel14.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Kesimpulan Identifikasi Pola Kompetensi");

        javax.swing.GroupLayout bcg1Layout = new javax.swing.GroupLayout(bcg1);
        bcg1.setLayout(bcg1Layout);
        bcg1Layout.setHorizontalGroup(
            bcg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bcg1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(bcg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(panelWarnaTransparan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        bcg1Layout.setVerticalGroup(
            bcg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bcg1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel14)
                .addGap(29, 29, 29)
                .addComponent(panelWarnaTransparan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(277, Short.MAX_VALUE))
        );

        jMenu1.setText("Identifikasi Pola");

        SubHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/homepage.png"))); // NOI18N
        SubHome.setText("Home");
        SubHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubHomeActionPerformed(evt);
            }
        });
        jMenu1.add(SubHome);

        SubKD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/checklist-with-a-pencil.png"))); // NOI18N
        SubKD.setText("Kelola Data");
        SubKD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubKDActionPerformed(evt);
            }
        });
        jMenu1.add(SubKD);

        SubExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/exit.png"))); // NOI18N
        SubExit.setText("Exit");
        SubExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubExitActionPerformed(evt);
            }
        });
        jMenu1.add(SubExit);

        jMenuBar1.add(jMenu1);

        Menu_View.setText("Association");
        Menu_View.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_ViewActionPerformed(evt);
            }
        });

        SubMenu_ARM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/calculator.png"))); // NOI18N
        SubMenu_ARM.setText("ARM");
        SubMenu_ARM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenu_ARMActionPerformed(evt);
            }
        });
        Menu_View.add(SubMenu_ARM);

        jMenuBar1.add(Menu_View);

        jMenu2.setText("Hasil Asosiasi");

        submenu_result.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/text-documents.png"))); // NOI18N
        submenu_result.setText("Lihat Kesimpulan");
        submenu_result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenu_resultActionPerformed(evt);
            }
        });
        jMenu2.add(submenu_result);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bcg1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bcg1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SubHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubHomeActionPerformed
        this.setVisible(false);
        new dashboard().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_SubHomeActionPerformed

    private void SubKDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubKDActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new kelola_data().setVisible(true);
    }//GEN-LAST:event_SubKDActionPerformed

    private void SubExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubExitActionPerformed
        // TODO add your handling code here:
        int ok=JOptionPane.showConfirmDialog(null,"Apakah anda mau keluar ?","Konfirmasi Keluar",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            dispose();
        }
    }//GEN-LAST:event_SubExitActionPerformed

    private void SubMenu_ARMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenu_ARMActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ARM().setVisible(true);
    }//GEN-LAST:event_SubMenu_ARMActionPerformed

    private void Menu_ViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_ViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Menu_ViewActionPerformed

    private void submenu_resultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenu_resultActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new hasil().setVisible(true);
    }//GEN-LAST:event_submenu_resultActionPerformed

    public void setHasil(String[] hasil){
        this.hasil = hasil;
    }
    
    public void setItemSet(String[] itemSet){
        this.itemSet = itemSet;
    }
    
    public void kesimpulan(){
        for(int i=0;i<hasil.length;i++){
            char[] temp = hasil[i].toCharArray();
            String t = "Jika kompetensi yang dibutuhkannya  ";
            for(int j=0;j<temp.length;j++){
                if(j==temp.length-2){
                        t = t + " dan ";
                }
                if(j==temp.length-1){
                        t = t + " maka dibutuhkan kompetensi ";
                }
                for(int k=0;k<abjad.length;k++){   
                    if(temp[j]==abjad[k]){
                        t = t + itemSet[k];
                    }                    
                }
                if(j+1!=temp.length-2&&j+1!=temp.length-1&&j!=temp.length-1){
                        t = t +", ";
                }
            }
            jTextArea1.append(t+"\n\n");
        }
    }
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
            java.util.logging.Logger.getLogger(hasil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hasil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hasil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hasil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hasil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Menu_View;
    private javax.swing.JMenuItem SubExit;
    private javax.swing.JMenuItem SubHome;
    private javax.swing.JMenuItem SubKD;
    private javax.swing.JMenuItem SubMenu_ARM;
    private pola_kompetensi.bcg bcg1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private Tampilan.PanelWarnaTransparan panelWarnaTransparan1;
    private javax.swing.JMenuItem submenu_result;
    // End of variables declaration//GEN-END:variables
}
