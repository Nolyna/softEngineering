/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HSMmodel;

/**
 *
 * cameron wright
 */
public class maintenance {
   private String name, time, room;
    
    public maintenance(){}
    
    
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
            
    

  
  

}
