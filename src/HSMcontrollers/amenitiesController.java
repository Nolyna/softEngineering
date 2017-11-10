package HSMcontrollers;

import HSMmodel.Amenities;
import dbConnexion.SQLiteJDBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



/**
 *
 * @author Noria Soumbou
 */
public class amenitiesController {
    
    final private SQLiteJDBConnection db = new SQLiteJDBConnection();
    private Amenities model;
    /*
     // SQL statement for creating a new table
        String sql1 = "CREATE TABLE IF NOT EXISTS amenities ( "
                +"idAmenity INTEGER PRIMARY KEY AUTOINCREMENT, "
                +"title text NOT NULL,"
                +"desc_amenity text NOT NULL,"
                +"hoursOperation text NOT NULL,"
                +"reserveFee varchar(10) DEFAULT NULL,"
                +"maxOccupancy int(11) DEFAULT NULL"
                +") ;";
    
    */
    
    public void add( amenities model){
        String sql = "INSERT INTO amnities(title,desc_amenity,hoursOperation,reserveFee,maxOccupancy) VALUES(?,?,?,?,?)";
        
        try (Connection conn = db.connect();
                model.
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, mode. );
            pstmt.setString(2, lname);
            pstmt.setString(3, email);
            pstmt.setString(4, pass);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
