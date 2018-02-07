/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_POSTIT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author int105
 */
public class Connectionbuilder {
    public static int count=0;

    public static Connection connect() throws ClassNotFoundException, SQLException {
        final String host = "jdbc:derby://localhost:1527/postItdb";
        final String uName = "postit";
        final String uPass = " ";
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        System.out.println("Driver loaded");

        Connection con = DriverManager.getConnection(host, uName, uPass);
        System.out.println("Connection created");
        count++;
        System.out.println(count);
        return con;
    }

}
