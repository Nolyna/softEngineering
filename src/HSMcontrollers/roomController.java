package HSMcontrollers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Noria Soumbou
 */
public class roomController {
    final private static String URL = "jdbc:sqlite:hotelmanagement.db";
    
    /**
     * Add a new room in the database
     * @param desc description of the room
     * @param locate floor where is located the room
     * @param roomType id of the room type
     */
    public void newroom(String desc, String locate, int roomType){
         String sql = "INSERT INTO rooms(description,location,idRoomType) VALUES(?,?,?)";
        try (Connection conn = DriverManager.getConnection(URL);
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
        try (Connection conn = DriverManager.getConnection(URL);
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
        try (Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
        
    public void roomNewType(String a, int b, int c){
         String sql = "INSERT INTO room_type(nameType,pricePerNight,beds) VALUES(?,?,?)";
        try (Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, a);
            pstmt.setInt(2, b);
            pstmt.setInt(3, c);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void roomUpdateType(int id, String name, int bed, int price){
         String sql = "UPDATE room_type"
                 + "SET nameType = ? , beds = ?, pricePerNight = ?"
                 + "WHERE idRoomType = ?";
        try (Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, bed);
            pstmt.setInt(3, price);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void roomDeleteType(int id){
         String sql = "DELETE FROM room_type"
                 + "WHERE idRoomType = ?";
        try (Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
