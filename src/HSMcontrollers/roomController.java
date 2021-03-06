package HSMcontrollers;

import HSMmodel.RoomType;
import HSMmodel.room;
import dbConnexion.SQLiteJDBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

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
     
    public void getRoomById(int id){
        String sql = "SELECT * FROM rooms where idRoom = ? ";
       try (Connection conn = db.connect();
               PreparedStatement pstmt = conn.prepareStatement(sql)) {
           pstmt.setInt(1, id);
           try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                   this.model.setRoomID(rs.getInt("idRoom"));
                   this.model.setDescription(rs.getString("description"));
                   this.model.setLocation(rs.getString("location"));
                   this.model.setTypeID(rs.getInt("idRoomType"));
                }
                rs.close();
           }catch(SQLException e){ System.out.println("roo by id : "+e.getMessage()); }            
           pstmt.close();
           //conn.close();
       } catch (SQLException e) {
           System.out.println("room by id  db"+e.getMessage());
       }   
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
    /**
     * Make a room reservation
     * @param idr Room ID
     * @param idc Client ID
     * @param din Date Entry
     * @param dout Date out
     * @param status Reservation status
     */
    public void roomReservation(int idr, int idc, Date din, Date dout, String status){
        String sql = "INSERT INTO room_reserve(idRoom,idClient, dateIn, dateOut, status) VALUES(?,?,?,?,?)"; 
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idr);
            pstmt.setInt(2, idc);
            pstmt.setDate(3, new java.sql.Date(din.getTime()));
            pstmt.setDate(4, new java.sql.Date(dout.getTime()));
            pstmt.setString(5, status);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("roomReservation: "+e.getMessage());
        }
    }
    
    /**
     * get the status of the room reservation 
     * @return status
     */
    public String roomReservationStatus(){
        String status = "Avalaible", sql = "SELECT status FROM room_reserve where idRoom = ?"; 
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.model.getroomID());
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    status = (rs.getString("status"));       
                }
                rs.close();
            }catch(SQLException e){ System.out.println("roomReservationStatus: "+e.getMessage()); }  
        } catch (SQLException e) {
            System.out.println("roomReservationStatus: "+e.getMessage());
        }
        return status;
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
     * need to have data room fetch in controller
     * @return 
     */
    public String getRoomLocation(){
        return this.model.getLocation();
    }
    /**
     * need to have data room fetch in controller
     * @return 
     */
    public String getRoomDEscription(){
        return this.model.getDescription();
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
    
    /**
     * get the status of the room reservation 
     * @param id idRoom
     * @return status
     */
    public String roomReservationStatus(int id){
        String status = "Avalaible", sql = "SELECT status FROM room_reserve where idRoom = ?"; 
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    status = (rs.getString("status"));       
                }
                rs.close();
            }catch(SQLException e){ System.out.println("roomReservationStatus: "+e.getMessage()); }  
        } catch (SQLException e) {
            System.out.println("roomReservationStatus: "+e.getMessage());
        }
        return status;
    }
    
    public String GetRoom(int id){
        RoomType rt = new RoomType();
        String status = "", sql = "SELECT * FROM rooms where idRoom = ?"; 
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    rt.setTypeID(rs.getInt("idRoomType"));
                    String nt = rt.getRoomTypeName();
                    status = (nt +" "+rs.getString("location"));       
                }
                rs.close();
            }catch(SQLException e){ System.out.println("roomReservationStatus: "+e.getMessage()); }  
        } catch (SQLException e) {
            System.out.println("roomReservationStatus: "+e.getMessage());
        }
        return status;
    }
    
    /**
     * 
     * @param id room type id
     * @return name of type of room
     */
    public String GetRoomName(int id){
        String status = "", sql = "SELECT nameType  FROM room_type where idRoomType = ?"; 
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    status = (rs.getString(1));       
                }
                rs.close();
            }catch(SQLException e){ System.out.println("roomName: "+e.getMessage()); }  
        } catch (SQLException e) {
            System.out.println("roomName: "+e.getMessage());
        }
        return status;
    }
    
    /**
     * 
     * @param id room type
     * @return room price
     */
    public Double GetRoomPriceByType(int id){
        Double status = 0.0;
        String sql = "SELECT pricePerNight  FROM room_type where idRoomType = ?"; 
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    status = (rs.getDouble(1));       
                }
                rs.close();
            }catch(SQLException e){ System.out.println("roomName: "+e.getMessage()); }  
        } catch (SQLException e) {
            System.out.println("roomName: "+e.getMessage());
        }
        return status;
    }
        
    
}
