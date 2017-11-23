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
 * @author Noria Soumbou
 */
public class Amenities {
    
    final private SQLiteJDBConnection db = new SQLiteJDBConnection();
    private String name, description, hours;
    private int id,fee,occupancy;
    
    public Amenities(){}
    
    /**
     *  set the name of the amenity
     * @param n 
     */
    public void setName(String n){
        this.name = n;
    }
    
    /**
     *  set the ID of the amenity
     * @param id 
     */
    public void setId(int id){
        this.id = id;
    }
    
    /**
     * set the description of the  amenity
     * @param desc 
     */
    public void setDescription(String desc){
        this.description = desc;
    }
    
    /**
     * set the openings hours of the amenity
     * @param hour 
     */
    public void setHours(String hour){
        this.hours =  hour;
    }
    
    /**
     * set the reservation fee of the  amenity
     * @param fee 
     */
    public void setFee(int fee){
        this.fee = fee;
    }
    
    /**
     * set the maximum occupancy of the  amenity
     * @param max 
     */
    public void setMaxOccupancy(int max){
        this.occupancy = max;
    }
    
    /**
     *  set the ID of the amenity
     */
    public int getId(){
        return this.id;
    }
    
    /**
     * get name of the  amenity
     * @return 
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * get the opening hours of the of the  amenity
     * @return 
     */
    public String getHours(){
        return this.hours;
    }
    
    /**
     * get the reservation fee of the of the  amenity
     * @return 
     */
    public int getFee(){
        return this.fee;
    }
    
    /**
     * get the description of the  amenity
     * @return 
     */
    public String getDescription(){
        return this.description;
    }
    
    /** 
     * get the maximum occupancy of the amenity
     * @return 
     */
    public int getMaxOccupancy(){
        return this.occupancy;
    }
    
    public void getAmenityByName(String name){
        String sql = "Select * FROM amenities where title LIKE ? ";        
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                   this.id = rs.getInt("idAmenity");
                   this.description = rs.getString("desc_amenity");
                   this.fee = rs.getInt("reserveFee");
                   this.hours= rs.getString("hoursOperation");
                   this.name= rs.getString("title");
                   this.occupancy = rs.getInt("maxOccupancy");
                }
                rs.close();
            }catch(SQLException e){ System.out.println("getClientByEmail: "+e.getMessage()); }   
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void getAmenityById(int id){
        String sql = "Select * FROM amenities where idAmenity = ? ";        
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                   this.id = rs.getInt("idAmenity");
                   this.description = rs.getString("desc_amenity");
                   this.fee = rs.getInt("reserveFee");
                   this.hours= rs.getString("hoursOperation");
                   this.name= rs.getString("title");
                   this.occupancy = rs.getInt("maxOccupancy");
                   System.out.println("getAmeniybyid: "+ rs.getString("title")); // remove later
                }
                rs.close();
            }catch(SQLException e){ System.out.println("getAmeniybyid: "+e.getMessage()); }   
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    
    public void reserve(int idclient, String date, String begin, String end, int amount, String Pstatus, String Rstatus, int price, int guest, int idamenity){
        String sql = "INSERT INTO amenities_reserve(date,hoursBegin,hoursEnd,amountPaid,PayStatus,reserveStatus,idClient,TotalPrice,nbrGuest,idAmenity) VALUES(?,?,?,?,?,?,?,?,?,?)";        
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            pstmt.setString(1, date);
            pstmt.setString(2, begin);
            pstmt.setString(3, end);
            pstmt.setInt(4, amount);
            pstmt.setString(5, Pstatus);
            pstmt.setString(6, Rstatus);
             pstmt.setInt(7, idclient);
            pstmt.setInt(8, price);
            pstmt.setInt(9, guest);
            pstmt.setInt(10, idamenity);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
