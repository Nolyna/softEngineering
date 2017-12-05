/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HSMmodel;

/**
 *
 * @author Jermaine Anderson
 */
public class delivery {
   private String status, des, des1;
   private int roomNumber;
           
    
    public delivery(int RoomNumber, String Status, String Des, String Des1){
        this.roomNumber = RoomNumber;
        this.status =Status;
        this.des = Des;
        this.des1 = Des1;
    
    }
 
            
   public int getRoomNumber(){
       return roomNumber;
   }


    public String getStatus(){
       return status;
   }
    
  public String getDes(){
       return des;
   }
  
  public String getDes1(){
       return des1;
   }

}