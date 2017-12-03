/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HSMmodel;

import dbConnexion.SQLiteJDBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author soumb
 */
public class Client {
    
    final private SQLiteJDBConnection db = new SQLiteJDBConnection();
    private String firstName, lastName, phone, email, password;
    private int id;
    
    public Client(){}
    public Client( String firstName, String lastName, String phone,String email,String password ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
    public Client( String firstName, String lastName, String phone,String email ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
     public void setid(int id){
        this.id =id;
    }
    public void setfirst(String firstName){
        this.firstName = firstName;
    }
    public void setlast(String lastName){
        this.lastName = lastName;
    }
    public void setemails(String email){
        this.email = email;
    }
    public void setphone(String phone){
        this.phone = phone;
    }
    public void setpassword(String password){
        this.password = password;
    }
    
    public int getid(){
        return this.id;
    }
    
    public String getfirst(){
        return this.firstName;
    }
    public String getlast(){
        return this.lastName;
    }
    public String getphone(){
        return this.phone;
    }
    public String getemail(){
        return this.email;
    }
    public String getpassword(){
        return this.password;
    }
    
    public void printName(){
        System.out.println( firstName+""+lastName);
    }
    public String getName(){
        return this.firstName+ " "+this.lastName;
    }
    
    public void getClientByEmail(){
        String sql = "SELECT * FROM client where email = ? ";
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.email);
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                   this.id = rs.getInt(1);
                   this.firstName = rs.getString("firstName");
                   this.lastName = rs.getString("LastName");
                   this.phone= rs.getString("phone");
                   this.password = rs.getString("password");
                }
                rs.close();
            }catch(SQLException e){ System.out.println("getClientByEmail: "+e.getMessage()); }            
            pstmt.close();
            //conn.close();
        } catch (SQLException e) {
            System.out.println("getClientByEmail"+e.getMessage());
        }        
    }
    
    public int getRoomId(){
        int idr = 0;
        String sql = "SELECT idRoom FROM room_reserve where idClient = ? ";
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                   idr = rs.getInt(1);
                }
                rs.close();
            }catch(SQLException e){ System.out.println("getRoomID: "+e.getMessage()); }            
            pstmt.close();
            //conn.close();
        } catch (SQLException e) {
            System.out.println("getRoomID db"+e.getMessage());
        }    
        return idr;
    }
}


