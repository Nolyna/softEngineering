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
public class events {
    
    
    private String name, description, date, timeBegin, timeEnd, hours;
    private int id, fee;
    final private SQLiteJDBConnection db = new SQLiteJDBConnection();
    private int occupancy;

    
    public events(){}
    public events( int id, String name,  String description,  String date,  String begin,  String end, int fee){
        this.date = date;
        this.description =  description;
        this.name =  name;
        this.fee =  fee;
        this.timeBegin =  begin;
        this.timeEnd = end;
        this.id = id;
    }
    
    public String printEvents(){
           return "events";
    }
    
    
    /**
     *  set the id of the event 
     * @param id
     */
    public void setId( int id){
           this.id =  id;
    }
    
    /**
     *  set the description of the event
     * @param name 
     */
    public void setName( String name){
           this.name =  name;
    }
    
    /**
     * set the description of the event
     * @param description 
     */
    public void setDescription(String description){
           this.description =  description;
    }
    /**
     *  set the date of the event
     * @param date 
     */
    public void setDate( String date){
           this.date = date;
    }
    /**
     * set the time of the start of the event
     * @param begin 
     */
    public void setBeginTime(String begin){
           this.timeBegin =  begin;
    }
    
    /**
     * set the time of end of the event
     * @param end 
     */
    public void setEndTime(String end){
           this.timeEnd =  end;
    }
    
    /**
     * set the fee of the event
     * @param fee 
     */
    public void setName(int fee){
           this.fee =  fee;
    }
    
    public String getHours(){
        return this.hours;
    }
    
     
     //////////////////////////////////////////////
    
    /**
     *  get the id of the event 
     * @return 
     */
    public int getId(){
           return this.id;
    }
    
    public void setHours(String hour){
        this.hours =  hour;
    }
    
    /**
     *  get the name of the event
     * @return 
     */
    public String getName(){
           return this.name;
    }
    
    /**
     * get the description of the event
     * @return 
     */
    public String getDescription(){
           return this.description;
    }
    /**
     *  get the date of the event
     * @return  
     */
    public String getDate(){
           return this.date;
    }
    /**
     * get the time of the start of the event
     * @return  
     */
    public String getBeginTime(){
           return this.timeBegin;
    }
    
    /**
     * get the time of end of the event
     * @return  
     */
    public String getEndTime(){
           return this.timeEnd ;
    }
    
    /**
     * get the fee of the event
     * @return  
     */
    public int getFee(){
           return this.fee ;
    }
    
            
    public void getEventByName(String name){
        String sql = "Select * FROM Events where title LIKE ? ";        
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                   this.id = rs.getInt("idEvent");
                   this.description = rs.getString("desc_event");
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
    public void getEventById(int id){
        String sql = "Select * FROM event where idEvent = ? ";        
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                   this.id = rs.getInt("idEvent");
                   this.description = rs.getString("desc_event");
                   this.fee = rs.getInt("reserveFee");
                   this.hours= rs.getString("hoursOperation");
                   this.name= rs.getString("title");
                   this.occupancy = rs.getInt("maxOccupancy");
                   System.out.println("getEventbyid: "+ rs.getString("title")); // remove later
                }
                rs.close();
            }catch(SQLException e){ System.out.println("getEventbyid: "+e.getMessage()); }   
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    public void reserve(int idclient, String date, String begin, String end, int amount, String Pstatus, String Rstatus, int price, int guest, int idEvent){
        String sql = "INSERT INTO events_reserve(date,hoursBegin,hoursEnd,amountPaid,PayStatus,reserveStatus,idClient,TotalPrice,nbrGuest,idEvent) VALUES(?,?,?,?,?,?,?,?,?,?)";        
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
            pstmt.setInt(10, idEvent);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
        
    
    
    
    
}
