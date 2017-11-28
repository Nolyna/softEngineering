/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HSMmodel;

import dbConnexion.SQLiteJDBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Noria Soumbou
 */
public class RoomType {
    

    private String typeName;
    private int typeID, beds, price;
     final private SQLiteJDBConnection db = new SQLiteJDBConnection();
    
    
    public RoomType(){}
    public RoomType( String typeName, int beds, int price, int typeID){
        this.typeName = typeName;
        this.beds = beds;
        this.price = price;
        this.typeID = typeID;
    }
    
    
    public void setTypeName(String name){
        this.typeName = name;
    }
    public void setTypeID(int typeID){
        this.typeID = typeID;
    }
    public void setBeds( int bed){
        this.beds =  bed;
    }
    public void setprice(int price){
        this.price = price;
    }
    
    
    public int getTypeID(){
        return this.typeID ;
    }
    public String getType(){
        return this.typeName;
    }
    public int getBeds(){
        return this.beds;
    }
    public int getprice(){
        return this.price;
    }
    
    public void roomNewType(){
         String sql = "INSERT INTO room_type(nameType,pricePerNight,beds) VALUES(?,?,?)";
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.typeName);
            pstmt.setInt(2, this.price);
            pstmt.setInt(3, this.beds);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void roomUpdateType(){
         String sql = "UPDATE room_type"
                 + "SET nameType = ? , beds = ?, pricePerNight = ?"
                 + "WHERE idRoomType = ?";
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.typeName);
            pstmt.setInt(2, this.beds);
            pstmt.setInt(3, this.price);
            pstmt.setInt(4, this.getTypeID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void roomDeleteType(int id){
         String sql = "DELETE FROM room_type"
                 + "WHERE idRoomType = ?";
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.typeID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * get the room type data by ID
     */
    public void getRoomType(){
        String sql = "SELECT * FROM room_type where idRoomType = ?";
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, this.typeID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    this.beds = (rs.getInt("beds"));
                    this.price = (rs.getInt("pricePerNight"));
                    this.typeName = (rs.getString("nameType"));       
                }
                rs.close();
            }catch(SQLException e){ System.out.println("all room: "+e.getMessage()); }            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("all room db"+e.getMessage());
        }
    }
    
    public void roomNewType(String name, int price, int beds){
         String sql = "INSERT INTO room_type(nameType,pricePerNight,beds) VALUES(?,?,?)";
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, price);
            pstmt.setInt(3, beds);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
            
    /*String sql24 = "CREATE TABLE IF NOT EXISTS rooms ("
            +"idRoom INTEGER PRIMARY KEY AUTOINCREMENT,"
            +"description text,"
            +"location text NOT NULL,"
            +"idRoomType int(11) NOT NULL"
            //+"KEY idRoomType (idRoomType)"
            +") ; ";

        
                // SQL statement for creating a new table room_reserve	
        String sql27 = "CREATE TABLE IF NOT EXISTS room_reserve ("
            +" idResevation INTEGER PRIMARY KEY AUTOINCREMENT,"
            +" idRoom int(11) NOT NULL,"
            +" idClient int(11) NOT NULL,"
            +" dateReservation timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, "
            +" dateIn date NOT NULL,"
            +" dateOut date NOT NULL,"
            +" status text,"
            +" CONSTRAINT room_reserve_ibfk_1 FOREIGN KEY (idClient) REFERENCES client (idClient) ON DELETE CASCADE ON UPDATE CASCADE, "
            +" CONSTRAINT room_reserve_ibfk_2 FOREIGN KEY (idRoom) REFERENCES rooms (idRoom) ON DELETE CASCADE ON UPDATE CASCADE "
            +") ; ";

                // SQL statement for creating a new table room_type
        String sql25 = "CREATE TABLE IF NOT EXISTS room_type ( "
            +" idRoomType INTEGER PRIMARY KEY AUTOINCREMENT,"
            +" nameType varchar(15) NOT NULL,"
            +" pricePerNight int(11) NOT NULL,"
            +" beds int(11) NOT NULL"
            +") ; ";*/
    


}
