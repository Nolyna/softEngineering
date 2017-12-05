/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HSMcontrollers;

import HSMmodel.Client;
import dbConnexion.SQLiteJDBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Noria Soumbou
 */
public class clientController {
    
    final private SQLiteJDBConnection db = new SQLiteJDBConnection();
    private Client model = new Client();
    
    public clientController(){}
    public clientController(Client client){
        this.model = client;
    }
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
    
    public String fullName(){
        return this.model.getName();
    }
    
    public void getClientByEmail(String email){
        String sql = "SELECT * FROM client where email = ? ";
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                   this.model.setid(rs.getInt(1));
                   this.model.setfirst(rs.getString(2));
                   this.model.setlast(rs.getString(3));
                   this.model.setphone(rs.getString(4));
                   this.model.setemails(email);
                }
                rs.close();
            }catch(SQLException e){ System.out.println("client by email controller: "+e.getMessage()); }            
            pstmt.close();
            //conn.close();
        } catch (SQLException e) {
            System.out.println("client by email controller db"+e.getMessage());
        }        
    }
    
    public void getClientById(int id){
        String sql = "SELECT * FROM client where idClient = ? ";
       try (Connection conn = db.connect();
               PreparedStatement pstmt = conn.prepareStatement(sql)) {
           pstmt.setInt(1, id);
           try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                   this.model.setid(rs.getInt(1));
                   this.model.setfirst(rs.getString(2));
                   this.model.setlast(rs.getString(3));
                   this.model.setphone(rs.getString(4));
                   this.model.setemails(rs.getString(5));
                }
                rs.close();
           }catch(SQLException e){ System.out.println("client by id controller: "+e.getMessage()); }            
           pstmt.close();
           //conn.close();
       } catch (SQLException e) {
           System.out.println("client by id controller db"+e.getMessage());
       }   
    }
}
