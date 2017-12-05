/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HSMcontrollers;

import HSMmodel.events;
import HSMmodel.tours;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import dbConnexion.SQLiteJDBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Noria Soumbou
 */
public class tourController {
    final private SQLiteJDBConnection db = new SQLiteJDBConnection();
    private tours model;
    
    public tourController(tours model){
        this.model = model;
    }

    public tourController() {
    }
    public void insert( String title, String description, String date, int Shours, int Ehours, String fee){
        String sql = "INSERT INTO tour(title,description,date,timeBegin,timeEnd, fee) VALUES(?,?,?,?,?,?)";        
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
    public void create(){
        String sql = "INSERT INTO tour(title,description, date,timeBegin, timeEnd, fee ) "
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
         String sql = "UPDATE tour set "
                 + "title = ? , description = ?, date = ?, "
                 + "timeBegin = ?, timeEnd = ?, fee = ?"
                 +" WHERE idtour = ? ";
 
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
         String sql = "DELETE FROM tour WHERE idtour = ?"; 
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.model.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
     /*public int gettour(int id ){
        String sql = "SELECT * FROM tour where idtour = ?";
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


/*
 +"idtour int(11) NOT NULL DEFAULT '0',"
            +"Title varchar(50) NOT NULL,"
            +"Description text NOT NULL,"
            +"date date NOT NULL,"
            +"timeBegin time NOT NULL,"
            +"timeEnd time NOT NULL,"
            +"fee int(11) NOT NULL"
            //+"KEY Title (Title,date)"
*/