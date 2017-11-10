/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HSMmodel;

/**
 *
 * @author soumb
 */
public class events {
    /*
     +"idEvent int(11) NOT NULL DEFAULT '0',"
            +"Title varchar(50) NOT NULL,"
            +"Description text NOT NULL,"
            +"date date NOT NULL,"
            +"timeBegin time NOT NULL,"
            +"timeEnd time NOT NULL,"
            +"fee int(11) NOT NULL"
            //+"KEY Title (Title,date)"
    */
    
    private String name, description, date, timeBegin, timeEnd;
    private int id, fee;
    
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
     * @param name 
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
     
     //////////////////////////////////////////////
    
    /**
     *  get the id of the event
     * @param name 
     */
    public int getId(){
           return this.id;
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
     * @param description 
     */
    public String getDescription(){
           return this.description;
    }
    /**
     *  get the date of the event
     * @param date 
     */
    public String getDate(){
           return this.date;
    }
    /**
     * get the time of the start of the event
     * @param begin 
     */
    public String getBeginTime(){
           return this.timeBegin;
    }
    
    /**
     * get the time of end of the event
     * @param end 
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
    
    
    
}
