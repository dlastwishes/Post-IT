/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_POSTIT;

import java.io.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dlastwishes
 */
public class Print_Program extends javax.swing.JFrame {

    Login_Program loginPanel = new Login_Program();
     long userId = loginPanel.userId;
 //   long userId = 104;

    /**
     * Creates new form Print_Program
     */
    public Print_Program() {
        initComponents();
        showFromChoose();
    }

    public void showFromChoose() {
        try {
            this.preView.setEditable(false);
            Main_Program mainPanel = new Main_Program();
            int top = mainPanel.top;
            String sql = "select * from APP.postit where userid =" + userId + "";
            String res = getEvent(userId, sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Print_Program.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Print_Program.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getEvent(long userId, String sql) throws ClassNotFoundException, SQLException {
        String result = "";
        int top = 5;
        Process process = new Process();
        String username = process.checkUsername(userId);
        ArrayList<PostEvent> results = Process.execute(sql);
        if (results != null) {
            result += "This is the file by " + username + "\n\n";
            for (int j = top; j >= 1; j--) {
                for (int i = 0; i < results.size(); i++) {
                    if (results.get(i).getImportant() == j) {
                        result += results.get(i);
                    }
                }
            }

        }

        return result;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        preView = new javax.swing.JTextArea();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        preViewButton = new javax.swing.JButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        fileNameTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Print : POST IT");

        saveButton.setText("Save");
        saveButton.setToolTipText("");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        preView.setColumns(20);
        preView.setLineWrap(true);
        preView.setRows(5);
        preView.setText("Show preview your post list.");
        jScrollPane1.setViewportView(preView);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setMnemonic('1');
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Save all");
        jRadioButton1.setToolTipText("");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setMnemonic('2');
        jRadioButton2.setText("Save : Important 5");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setMnemonic('3');
        jRadioButton3.setText("Save info");

        preViewButton.setText("Preview");
        preViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preViewButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setText("Save date");

        jLabel1.setText("Files name :");

        fileNameTF.setText("Enter file name...");
        fileNameTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fileNameTFMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Angsana New", 0, 36)); // NOI18N
        jLabel2.setText("           Save Event To File");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fileNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)))
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(preViewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton5)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fileNameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(preViewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            String res = "";
            if(this.fileNameTF.getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Please,Enter file name.");
            }
            else {
                FileWriter fw = new FileWriter(this.fileNameTF.getText()+".txt");
            Main_Program mainPanel = new Main_Program();
            int top = mainPanel.top;

            int getPreView = this.buttonGroup1.getSelection().getMnemonic();
            System.out.println(getPreView);
            if (getPreView == 49) {
                String sql = "select * from APP.postit where userid =" + userId + "";
                res = getEvent(userId, sql);
            } else if (getPreView == 50) {
                String sql = "select * from APP.postit where userid =" + userId + " and important = 5";
                res = getEvent(userId, sql);
            
            } else if (getPreView == 51) {

            } else if (getPreView == 52) {

            }
            fw.write(res);
            fw.close();
            JOptionPane.showMessageDialog(null, "Save completed");
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Print_Program.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Print_Program.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Print_Program.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void preViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preViewButtonActionPerformed

        try {

            int getPreView = this.buttonGroup1.getSelection().getMnemonic();
            boolean isGet = this.buttonGroup1.isSelected(this.buttonGroup1.getSelection());

            System.out.println(getPreView);
            if (isGet) {
                if (getPreView == 49) {
                    String sql = "select * from APP.postit where userid =" + userId + "";
                    String res = getEvent(userId, sql);
                    this.preView.setText(res);
                } else if (getPreView == 50) {
                    String sql = "select * from APP.postit where userid =" + userId + " and important = 5";
                    String res = getEvent(userId, sql);
                    this.preView.setText(res);
                } else if (getPreView == 51) {

                } else if (getPreView == 52) {

                }
            }
            else {
                JOptionPane.showMessageDialog(null,"Please,checking.");
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Print_Program.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Print_Program.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_preViewButtonActionPerformed

    private void fileNameTFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileNameTFMouseClicked
        // TODO add your handling code here:
        this.fileNameTF.setText("");
    }//GEN-LAST:event_fileNameTFMouseClicked

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
            java.util.logging.Logger.getLogger(Print_Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Print_Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Print_Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Print_Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Print_Program().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField fileNameTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea preView;
    private javax.swing.JButton preViewButton;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}