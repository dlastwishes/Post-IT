/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_POSTIT;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author dlastwishes
 */
public class Admin_Menu extends javax.swing.JFrame {

    Login_Program loginPanel = new Login_Program();
    Process process = new Process();

    long userId = loginPanel.userId;
    int top = 5;
    static String res = "";

    public Admin_Menu() throws ClassNotFoundException, SQLException {
        initComponents();
        checkUser();

    }

    private void checkUser() throws ClassNotFoundException, SQLException {
        if (process.chechStatus(userId)) {
            this.showAll.setText("Welcome to Admin.");
        } else {
            JOptionPane.showMessageDialog(null, "You are not admin.");
            System.exit(0);
        }
    }

    private String getResult(String check) throws ClassNotFoundException, SQLException {
        String result = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/yyyy");
        String thisDate = String.valueOf(dateFormat.getCalendar().getTime());
        if (check.equalsIgnoreCase("post")) {
            ArrayList<PostEvent> results = Process.execute("select * from APP.postit");
            if (results != null) {
                result += "\nCurrent Time is " + thisDate + "\n\n";
                for (int j = top; j >= 1; j--) {
                    for (int i = 0; i < results.size(); i++) {
                        if (results.get(i).getImportant() == j | String.valueOf(results.get(i).getDate()) == thisDate) {
                            result += results.get(i);

                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "You don't have any event. Please,Add your event.");
            }
        } else if (check.equalsIgnoreCase("user")) {
            Connection conn = Connectionbuilder.connect();
            Statement std = conn.createStatement();
            ResultSet rs = std.executeQuery("select * from APP.postuser");
            while(rs.next()){
                result += "User ID : "+rs.getLong("userid");
                result += "   Username : "+rs.getString("username")+"\n";
                result += "Password : "+rs.getString("userpassword");
                result += "Name : "+rs.getString("name")+"\n";
                result += "-----------------------------\n\n";
                
            }
            
            
            }
        

        return result;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        editUser = new javax.swing.JButton();
        viewMember = new javax.swing.JButton();
        editEvent = new javax.swing.JButton();
        viewEvent = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        showAll = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Admin Menu");

        editUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editUser.setText("Edit event");
        editUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserActionPerformed(evt);
            }
        });

        viewMember.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        viewMember.setText("View member");
        viewMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewMemberActionPerformed(evt);
            }
        });

        editEvent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editEvent.setText("Edit user");
        editEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEventActionPerformed(evt);
            }
        });

        viewEvent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        viewEvent.setText("View event");
        viewEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewEventActionPerformed(evt);
            }
        });

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        showAll.setEditable(false);
        showAll.setColumns(20);
        showAll.setLineWrap(true);
        showAll.setRows(5);
        jScrollPane1.setViewportView(showAll);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(viewEvent, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editEvent, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewMember, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewMember, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewEventActionPerformed
        // TODO add your handling code here:
        String showPost = "";
        try {
            if (process.chechStatus(userId)) {
                showPost += "All the POST IT\n\n";
                showPost += getResult("post");
                this.showAll.setText(showPost);
            } else {
                JOptionPane.showMessageDialog(null, "You are not admin.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_viewEventActionPerformed

    private void viewMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewMemberActionPerformed
        // TODO add your handling code here:
        String showUser = "";
        try{
        if(process.chechStatus(userId)){
            showUser += "All the POST IT\n\n";
            showUser += getResult("user");
            this.showAll.setText(showUser);
        }
        else {
            JOptionPane.showMessageDialog(null, "You are not admin.");
        }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_viewMemberActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void editUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserActionPerformed
        // TODO add your handling code here:
        Edit_Program edit;
        try {
            edit = new Edit_Program();
            edit.setVisible(true);
            edit.setLocationRelativeTo(null);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_editUserActionPerformed

    private void editEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEventActionPerformed
        try {
            // TODO add your handling code here:
            if(process.chechStatus(userId)){
                Edit_User editUser = new Edit_User();
                editUser.setVisible(true);
                editUser.setLocationRelativeTo(null);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editEventActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Admin_Menu().setVisible(true);
                    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Admin_Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editEvent;
    private javax.swing.JButton editUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea showAll;
    private javax.swing.JButton viewEvent;
    private javax.swing.JButton viewMember;
    // End of variables declaration//GEN-END:variables
}
