package HSMcontrollers;

import HSMmodel.room;
import dbConnexion.SQLiteJDBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Noria Soumbou
 */
public class roomController {
    final private SQLiteJDBConnection db = new SQLiteJDBConnection();
    private room model;

    public roomController( room model){
        this.model = model;
    }

    public roomController() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
     
    
    /**
     * Add a new room in the database using room class
     */
    public void newroom(){
        String sql = "INSERT INTO rooms(description,location,idRoomType) VALUES(?,?,?)";
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.model.getDescription());
            pstmt.setString(2, this.model.getLocation());
            pstmt.setInt(3, this.model.getTypeID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * update Room details in database
     */
    public void updateRoom(){
         String sql = "UPDATE rooms "
                 + "SET description=? ,location=?, idRoomType=?"
                 + "WHERE idRoom =?";
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.model.getDescription());
            pstmt.setString(2, this.model.getLocation());
            pstmt.setInt(3, this.model.getTypeID());
            pstmt.setInt(4, this.model.getroomID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Delete a room from database using 
     * NB: room class need to be defined
     */    
    public void deleteRoom(){
         String sql = "DELETE FROM rooms  WHERE idRoom = ?"; 
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.model.getroomID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /***********************************************************************************************************************/
    /**
     * Add a new room in the database
     * @param desc description of the room
     * @param locate floor where is located the room
     * @param roomType id of the room type
     */
    public void newroom(String desc, String locate, int roomType){
         String sql = "INSERT INTO rooms(description,location,idRoomType) VALUES(?,?,?)";
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, desc);
            pstmt.setString(2, locate);
            pstmt.setInt(3, roomType);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * update Room details in database
     * @param desc description of the room
     * @param locate Location of the room
     * @param roomType id Type of room
     * @param room id of Room
     */
    public void updateRoom(String desc, String locate, int roomType, int room){
         String sql = "UPDATE rooms "
                 + "SET description=? ,location=?, idRoomType=?"
                 + "WHERE idRoom =?";
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, desc);
            pstmt.setString(2, locate);
            pstmt.setInt(3, roomType);
            pstmt.setInt(4, room);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Delete a room from database
     * @param id room ID
     */    
    public void deleteRoom( int id){
         String sql = "DELETE FROM rooms  WHERE idRoom = ?"; 
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
        
    
}
