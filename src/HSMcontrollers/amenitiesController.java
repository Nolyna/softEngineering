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
    public amenitiesController(){}
    
    public void insert( String title, String description, String hours, int fee, int max){
        String sql = "INSERT INTO amenities(title,desc_amenity,hoursOperation,reserveFee,maxOccupancy) VALUES(?,?,?,?,?)";        
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title );
            pstmt.setString(2, description);
            pstmt.setString(3, hours);
            pstmt.setInt(4, fee);
            pstmt.setInt(5, max);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }    
    }
    
    /*public void add( Amenities model){
        String sql = "SELECT * FROM amenities(title,desc_amenity,hoursOperation,reserveFee,maxOccupancy) VALUES(?,?,?,?,?)";
        
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, model.getName() );
            pstmt.setString(2, model.getDescription());
            pstmt.setString(3, model.getHours());
            pstmt.setInt(4, model. getFee());
            pstmt.setInt(5, model.getMaxOccupancy());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }        
    }*/
}
