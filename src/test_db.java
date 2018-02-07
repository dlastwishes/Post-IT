/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author dlastwishes
 */
public class test_db {
    public static void main(String args[]){
        try{
            final String host = "jdbc:derby://localhost:1527/postItdb";
            final String uName = "postit";
            final String uPass= " ";
             
             Connection con = DriverManager.getConnection(host, uName, uPass);
             System.out.println("Connected Database");
             Statement std = con.createStatement();
             String sql = "select * from APP.postuser";
             std.executeQuery(sql);
             ResultSet rs = std.executeQuery(sql);
             int i =0;
             while(rs.next()){
                 i++;
                 System.out.println(i);
                 String name = rs.getString("username");
                 String password = rs.getString("userpassword");
             System.out.println(name);
                 System.out.println(password);
             }
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }
}
