/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HSMcontrollers;

import HSMmodel.events;
import dbConnexion.SQLiteJDBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author Noria Soumbou
 */
public class eventController {
    final private SQLiteJDBConnection db = new SQLiteJDBConnection();
    private events model;
    
    public eventController(events model){
        this.model = model;
    }
    
    public void create(){
        String sql = "INSERT INTO event(title,description, date,timeBegin, timeEnd, fee ) "
                + "VALUES(?,?,?,?,?,?)";
        
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.model.getName() );
            pstmt.setString(2, this.model.getDescription());
            pstmt.setString(3, this.model.getDate());
            pstmt.setString(4, this.model.getBeginTime());
            pstmt.setString(5, this.model.getEndTime());
            pstmt.setInt(6, this.model.getFee());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void update(){
         String sql = "UPDATE event set "
                 + "title = ? , description = ?, date = ?, "
                 + "timeBegin = ?, timeEnd = ?, fee = ?"
                 +" WHERE idEvent = ? ";
 
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.model.getName());
            pstmt.setString(2, this.model.getDescription());
            pstmt.setString(3, this.model.getDate());
            pstmt.setString(4, this.model.getBeginTime());
            pstmt.setString(5, this.model.getEndTime());
            pstmt.setInt(6, this.model.getFee());
            pstmt.setInt(7, this.model.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteDepartment(){
         String sql = "DELETE FROM event WHERE idEvent = ?"; 
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.model.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    

    public eventController() {
    }
    public void insert( String title, String description, String date, int Shours, int Ehours, String fee){
        String sql = "INSERT INTO event(title,description,date,timeBegin,timeEnd, fee) VALUES(?,?,?,?,?,?)";        
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title );
            pstmt.setString(2, description);
            pstmt.setString(3, date);
            pstmt.setInt(4, Shours);
            pstmt.setInt(5, Ehours);
            pstmt.setString(6, fee);
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }    
    }
        
     /*public int getEvent(int id ){
        String sql = "SELECT * FROM event where idEvent = ?";
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                     
                }
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(" error "+e.getMessage());
        }        
        return rs;
    }*/
}

    
