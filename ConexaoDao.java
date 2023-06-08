/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ajp tech
 */
public class ConexaoDao {
    
    public static Connection Conexao () throws ClassNotFoundException{
         Connection conn = null;
        try {
            String driver="com.mysql.jdbc.Driver";
            Class.forName(driver);
            String ur1 = "jdbc:mysql://localhost:3306/trabalho?user=root&password=";
            conn = DriverManager.getConnection(ur1);

        } catch (SQLException erro) {
              erro.printStackTrace();
        }
        return conn;
    }
    
}
