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
public class tours {
    public tours( int id, String name,  String description,  String date,  String begin,  String end, int fee){
        this.date = date;
        this.description =  description;
        this.name =  name;
        this.fee =  fee;
        this.timeBegin =  begin;
        this.timeEnd = end;
        this.id = id;
    }
    final private SQLiteJDBConnection db = new SQLiteJDBConnection();
    
    private String name, description, date, timeBegin, timeEnd, hours;
    private int id, fee, occupancy;
    
    public tours(){}
   
    
    public String printtours(){
           return "tours";
    }
    
     public String getHours(){
        return this.hours;
    }
    public void setHours(String hour){
        this.hours =  hour;
    }
    /**
     *  set the id of the tour
     * @param name 
     */
    public void setId( int id){
           this.id =  id;
    }
    
    /**
     *  set the description of the tour
     * @param name 
     */
    public void setName( String name){
           this.name =  name;
    }
    
    /**
     * set the description of the tour
     * @param description 
     */
    public void setDescription(String description){
           this.description =  description;
    }
    /**
     *  set the date of the tour
     * @param date 
     */
    public void setDate( String date){
           this.date = date;
    }
    /**
     * set the time of the start of the tour
     * @param begin 
     */
    public void setBeginTime(String begin){
           this.timeBegin =  begin;
    }
    
    /**
     * set the time of end of the tour
     * @param end 
     */
    public void setEndTime(String end){
           this.timeEnd =  end;
    }
    
    /**
     * set the fee of the tour
     * @param fee 
     */
    public void setName(int fee){
           this.fee =  fee;
    }
     
     //////////////////////////////////////////////
    
    /**
     *  get the id of the tour
     * @param name 
     */
    public int getId(){
           return this.id;
    }
    
    /**
     *  get the name of the tour
     * @return 
     */
    public String getName(){
           return this.name;
    }
    
    /**
     * get the description of the tour
     * @param description 
     */
    public String getDescription(){
           return this.description;
    }
    /**
     *  get the date of the tour
     * @param date 
     */
    public String getDate(){
           return this.date;
    }
    /**
     * get the time of the start of the tour
     * @param begin 
     */
    public String getBeginTime(){
           return this.timeBegin;
    }
    
    /**
     * get the time of end of the tour
     * @param end 
     */
    public String getEndTime(){
           return this.timeEnd ;
    }
    
    /**
     * get the fee of the tour
     * @return  
     */
    public int getFee(){
           return this.fee ;
    }
    public void gettourByName(String name){
        String sql = "Select * FROM tours where title LIKE ? ";        
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                   this.id = rs.getInt("idtour");
                   this.description = rs.getString("desc_tour");
                   this.fee = rs.getInt("reserveFee");
                   this.hours = rs.getString("hoursOperation");
                   this.name= rs.getString("title");
                   this.occupancy = rs.getInt("maxOccupancy");
                }
                rs.close();
            }catch(SQLException e){ System.out.println("getClientByEmail: "+e.getMessage()); }   
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    public void gettourById(int id){
        String sql = "Select * FROM tour where idtour = ? ";        
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                   this.id = rs.getInt("idtour");
                   this.description = rs.getString("desc_tour");
                   this.fee = rs.getInt("reserveFee");
                   this.hours= rs.getString("hoursOperation");
                   this.name= rs.getString("title");
                   this.occupancy = rs.getInt("maxOccupancy");
                   System.out.println("gettourbyid: "+ rs.getString("title")); // remove later
                }
                rs.close();
            }catch(SQLException e){ System.out.println("gettourbyid: "+e.getMessage()); }   
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    public void reserve(int idclient, String date, String begin, String end, int amount, String Pstatus, String Rstatus, int price, int guest, int idtour){
        String sql = "INSERT INTO tours_reserve(date,hoursBegin,hoursEnd,amountPaid,PayStatus,reserveStatus,idClient,TotalPrice,nbrGuest,idtour) VALUES(?,?,?,?,?,?,?,?,?,?)";        
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
            pstmt.setInt(10, idtour);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
