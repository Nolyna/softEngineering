/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HSMmodel;

/**
 *
 * cameron wright, jermaine anderson
 */
public class maintenance {
   private String name, time, room,type, issue, status;
   private int roomNumber;

   
           
    
    public maintenance(int RoomNumber, String Type, String Issue, String Status){
        this.roomNumber = RoomNumber;
        this.type = Type;
        this.issue =Issue;
        this.status =Status;
    
    }
    
    
    public void setName(String n){
        this.name = n;
    }
    public void setTime(String t){
        this.time = t ;
    }
    public void setroom(String r){
        this.room = r ;
    }
    
    public String getName()
    {
        return this.name;
    }
    public String getTime(){
        return this.time;
    }
    public String getRoom() {
        return this.room;
    }
            
   public int getRoomNumber(){
       return roomNumber;
   }

    public String getType(){
       return type;
   }
    
    public String getIssue(){
       return issue;
   }
    
    public String getStatus(){
       return status;
   }
    
  

}
