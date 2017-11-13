/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HSMcontrollers;

import dbConnexion.SQLiteJDBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Noria Soumbou
 */
public class clientController {
    
    final private SQLiteJDBConnection db = new SQLiteJDBConnection();
    
    /**
     * Create a new client in the database
     * @param fname
     * @param lname
     * @param email
     * @param pass 
     */
    public void newClient(String fname,String lname, String email, String pass) {
        String sql = "INSERT INTO client(firstName,lastName, email, password) VALUES(?,?,?,?)";
        
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fname);
            pstmt.setString(2, lname);
            pstmt.setString(3, email);
            pstmt.setString(4, pass);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
