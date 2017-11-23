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
public class room {
    private String description, location;
    private int typeID, roomID;
    
    public room(){}
    public room( int  roomID, String desc, String location, int typeID){
        this.description = desc;
        this.location = location;
        this.typeID = typeID;
        this.roomID =  roomID;
    }
    
    public void setDescription(String desc){
        this.description = desc;
    }
    public void setLocation( String location){
        this.location = location;
    }
    public void setRoomID(int id){
        this.roomID = id;
    }
    public void setTypeID(int typeID){
        this.typeID = typeID;
    }
    
    public String getDescription(){
        return this.description;
    }
    public String getLocation(){
        return this.location;
    }
    public int getTypeID(){
        return this.typeID ;
    }
    
    public int getroomID(){
        return this. roomID;
    }
    
    //public String getRoomType(){}
            
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
