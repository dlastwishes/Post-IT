/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_POSTIT;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dlastwishes
 */
public class Edit_Program extends javax.swing.JFrame {

    Login_Program loginPanel = new Login_Program();
    long userId = loginPanel.userId;
//    long userId = 104;
    ArrayList<String> alPostId = new ArrayList<String>();
    Process process = new Process();
    static String postId = "";
    static int countClick = 0;

    /**
     * Creates new form Edit_Program
     */
    public Edit_Program() throws ClassNotFoundException, SQLException {
        initComponents();
       
        if (process.chechStatus(userId)) {
            getEventToComboList("select * from APP.postit");
        }
        else {
             getEventToComboList("select * from APP.postit where userid =" + userId + "");
        }
    }

    public void getEventToComboList(String sql) throws ClassNotFoundException, SQLException {

        ArrayList<PostEvent> results = Process.execute(sql);

        if (results != null) {
            for (int i = 0; i < results.size(); i++) {
                this.eventList.addItem(results.get(i).getPostName());
                alPostId.add(String.valueOf(results.get(i).getPostId()));
//                System.out.println(i + " " + alPostId.get(i));
            }
        }

    }

    public void getEventList(long userId, String sql) throws ClassNotFoundException, SQLException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Process process = new Process();
        String username = process.checkUsername(userId);
        ArrayList<PostEvent> results = Process.execute(sql);
        if (results != null) {
            
            for (int i = 0; i < results.size(); i++) {
                if (this.eventList.getSelectedIndex() == (i + 1)) {
                    postId = alPostId.get(i);
                    this.nameEventTf.setText(results.get(i).getPostName());
                    this.infoTextArea.setText(results.get(i).getPostInfo());
                    int imp = results.get(i).getImportant();
                    switch (imp) {
                        case 5:
                            this.jRadioButton1.setSelected(true);
                            break;
                        case 4:
                            this.jRadioButton2.setSelected(true);
                            break;
                        case 3:
                            this.jRadioButton3.setSelected(true);
                            break;
                        case 2:
                            this.jRadioButton4.setSelected(true);
                            break;
                        case 1:
                            this.jRadioButton5.setSelected(true);
                            break;
                    }

                    this.dateTextField.setText(dateFormat.format(results.get(i).getDate()));

                } else if (this.eventList.getSelectedIndex() == 0) {
                    this.nameEventTf.setText("");
                    this.dateTextField.setText("");
                    this.infoTextArea.setText("");
                    this.eventList.setSelectedIndex(0);
                    this.buttonGroup1.clearSelection();
                }
            }

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

        buttonGroup1 = new javax.swing.ButtonGroup();
        cancelButton = new javax.swing.JButton();
        eventList = new javax.swing.JComboBox();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        nameEventTf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        dateTextField = new javax.swing.JTextField();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        resetButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Edit Event : POST IT");

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        eventList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose your event" }));
        eventList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventListActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setMnemonic('1');
        jRadioButton5.setText("1");

        jLabel3.setText("Date :");

        jLabel4.setText("Info :");

        infoTextArea.setColumns(20);
        infoTextArea.setLineWrap(true);
        infoTextArea.setRows(5);
        jScrollPane1.setViewportView(infoTextArea);

        jLabel1.setText("Name Event  :");

        nameEventTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameEventTfActionPerformed(evt);
            }
        });

        jLabel2.setText("Important :");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setMnemonic('5');
        jRadioButton1.setText("5");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setMnemonic('4');
        jRadioButton2.setText("4");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setMnemonic('3');
        jRadioButton3.setText("3");

        jLabel5.setText("Ex: 23/07/2559");

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setMnemonic('2');
        jRadioButton4.setText("2");

        jLabel6.setText("Choose Event :");

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Angsana New", 0, 36)); // NOI18N
        jLabel7.setText("                        Edit Event");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nameEventTf, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eventList, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(jRadioButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButton3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton5)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameEventTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resetButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void nameEventTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameEventTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameEventTfActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void eventListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventListActionPerformed
        // TODO add your handling code here:

//        if(countClick == 0){
//            this.eventList.removeItemAt(0);
//            countClick++;
//        }
        String sql = "";
        try {
            if (process.chechStatus(userId)) {
                sql = "select * from APP.postit";
                getEventList(userId, sql);
            } else{
                sql = "select * from APP.postit where userid = " + userId + "";
                getEventList(userId, sql);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Edit_Program.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Edit_Program.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_eventListActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        this.nameEventTf.setText("");
        this.dateTextField.setText("");
        this.infoTextArea.setText("");
        this.eventList.setSelectedIndex(0);
        this.buttonGroup1.clearSelection();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            // TODO add your handling code here:

            Process process = new Process();
            Connection conn = Connectionbuilder.connect();

            if (String.valueOf(this.eventList.getSelectedItem()).equalsIgnoreCase("Choose your event")
                    && this.dateTextField.getText().equalsIgnoreCase("")
                    && this.nameEventTf.getText().equalsIgnoreCase("")
                    && this.infoTextArea.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Please,Choose your event.");
            } else {
//                System.out.println("Income to");
                String inputDate = String.valueOf(this.dateTextField.getText());
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date date = dateFormat.parse(inputDate);
                int getImpEdit = this.buttonGroup1.getSelection().getMnemonic();
//                System.out.println("getImpEdit : " + getImpEdit);
//                System.out.println(postId);

                int imp = process.checkImportant(getImpEdit);
                System.out.println(imp);
                PreparedStatement std = conn.prepareStatement("update APP.postit set postname = ? , postinfo = ? , important =? , date = ? where postid = " + postId + "");
                std.setString(1, this.nameEventTf.getText());
                std.setString(2, this.infoTextArea.getText());
                std.setInt(3, imp);
                std.setDate(4, new java.sql.Date(date.getTime()));
                std.executeUpdate();
                JOptionPane.showMessageDialog(null, "Save Complete");
                //เมื่อแก้ไข เสร็จแล้ว ก็คืนกลับไปที่ค่าเริ่มต้นทั้งหมด
                this.nameEventTf.setText("");
                this.dateTextField.setText("");
                this.infoTextArea.setText("");
                this.eventList.setSelectedIndex(0);
                this.buttonGroup1.clearSelection();
            }

            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Edit_Program.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Edit_Program.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Edit_Program.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            Connection conn = Connectionbuilder.connect();
            if (this.nameEventTf.getText().equalsIgnoreCase("") && this.infoTextArea.getText().equalsIgnoreCase("") & this.dateTextField.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Please,choose your event");
            } else {
                JOptionPane.showInternalConfirmDialog(this.rootPane.getContentPane(), "Are you sure you want to delete this event?");
                String sql = "delete from APP.postit where postid =" + postId;
                Statement std = conn.createStatement();
                boolean isSelectCmd = std.execute(sql);
                if (isSelectCmd) {
                    JOptionPane.showMessageDialog(null, "Delete not complete");
                } else {
                    JOptionPane.showMessageDialog(null, "Deleted");
                    this.setVisible(false);
                }
                conn.close();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Edit_Program.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Edit_Program.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Edit_Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit_Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit_Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit_Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Edit_Program().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Edit_Program.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Edit_Program.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField dateTextField;
    private javax.swing.JComboBox eventList;
    private javax.swing.JTextArea infoTextArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameEventTf;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}