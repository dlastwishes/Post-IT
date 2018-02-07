/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_POSTIT;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author dlastwishes
 */
public class Intro_Program extends JFrame {
    
    public Intro_Program(){
        add(new ImagePanel());
        
    }
    public static void main(String[] args) {
        JFrame frame = new Intro_Program();
        frame.setTitle("Welcome to POST IT");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
            
}

class ImagePanel extends JPanel{
    private ImageIcon imi = new ImageIcon("mission.jpg"); 
    private Image pic = imi.getImage();
    
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(pic != null){
            g.drawImage(pic,0,0,getWidth(), getHeight(), this);
            try {
                Login_Program login = new Login_Program();
                Thread.sleep(3000);
                this.setVisible(false);
                login.setVisible(true);
            } catch (InterruptedException ex) {
                Logger.getLogger(ImagePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
