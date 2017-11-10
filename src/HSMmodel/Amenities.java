/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HSMmodel;

/**
 *
 * @author Noria Soumbou
 */
public class Amenities {
    private String name, description, hours;
    private int fee,occupancy;
    
    public Amenities(){}
    
    /**
     *  set the name of the amenity
     * @param n 
     */
    public void setName(String n){
        this.name = n;
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
    
}
