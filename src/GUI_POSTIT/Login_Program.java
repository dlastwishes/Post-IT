/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_POSTIT;

import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dlastwishes
 */
public class Login_Program extends javax.swing.JFrame {

    public static long userId;

    /**
     * Creates new form Login_Program
     */
    public Login_Program() {
        initComponents();
        this.setSize(600, 290);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        resetButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        passwordTextField = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login : POST IT");
        setBackground(new java.awt.Color(102, 153, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.white);
        setName("LoginFrame"); // NOI18N
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Username");
        jLabel1.setPreferredSize(new java.awt.Dimension(58, 17));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(350, 110, 72, 31);

        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(usernameTextField);
        usernameTextField.setBounds(430, 110, 134, 31);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(352, 148, 70, 33);
        jLabel2.getAccessibleContext().setAccessibleDescription("");

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        getContentPane().add(resetButton);
        resetButton.setBounds(470, 200, 84, 44);

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        loginButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginButtonKeyPressed(evt);
            }
        });
        getContentPane().add(loginButton);
        loginButton.setBounds(380, 200, 76, 44);

        passwordTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordTextFieldKeyPressed(evt);
            }
        });
        getContentPane().add(passwordTextField);
        passwordTextField.setBounds(430, 150, 134, 30);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 146, 200, 32);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\dlastwishes\\OneDrive\\Java\\PostIt\\src\\GUI_POSTIT\\New folder\\renkjeb,je.png")); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 170, 250, 80);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI_POSTIT/intro.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 590, 280);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextFieldActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed

        int i = 0;
        boolean checkLogin = true;
        try {
            Connection con = Connectionbuilder.connect();
            String sql = "select * from APP.postuser";
            Statement std = con.createStatement();
            std.executeQuery(sql);
            ResultSet rs = std.getResultSet();

            if (this.usernameTextField.getText().equalsIgnoreCase("") & this.passwordTextField.getText().equalsIgnoreCase("")) {

                JOptionPane.showMessageDialog(null, "Please,Enter your username or password");
            } else {

                while (rs.next()) {

                    if (rs.getString("username").equalsIgnoreCase(this.usernameTextField.getText())
                            & rs.getString("userpassword").equalsIgnoreCase(this.passwordTextField.getText())) {
                        userId = rs.getLong("userid");
                        checkLogin = false;
                        this.setVisible(false);

                        Main_Program main_panel = new Main_Program();

                        main_panel.setVisible(true);
                        main_panel.setLocationRelativeTo(null);
                        main_panel.alert();

                    } 
                }
                if(checkLogin){
                    JOptionPane.showMessageDialog(null,"You aren't member.");
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException err) {
            err.printStackTrace();
        }

    }//GEN-LAST:event_loginButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        this.usernameTextField.setText("");
        this.passwordTextField.setText("");
    }//GEN-LAST:event_resetButtonActionPerformed

    private void loginButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginButtonKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_loginButtonKeyPressed

    private void passwordTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordTextFieldKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_passwordTextFieldKeyPressed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
            this.setVisible(false);
        Register_Program regis_panel = new Register_Program();
        regis_panel.setVisible(true);
        regis_panel.setLocationRelativeTo(null);
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(Login_Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Login_Program().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JButton resetButton;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
