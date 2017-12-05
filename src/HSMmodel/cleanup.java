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
public class cleanup {
   private String status;
   private int roomNumber;

   
           
    
    public cleanup(int RoomNumber, String Status){
        this.roomNumber = RoomNumber;
        this.status =Status;
    
    }
            
   public int getRoomNumber(){
       return roomNumber;
   }


    public String getStatus(){
       return status;
   }
    
  

}

