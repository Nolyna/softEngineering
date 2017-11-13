package HSMcontrollers;


import HSMmodel.inventoryItem;
import dbConnexion.SQLiteJDBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;




/**
 *
 * @author Damasta Altman 
 */
public class inventoryController {
    
    final private SQLiteJDBConnection db = new SQLiteJDBConnection();

    /**
     *
     * @param x
     */
    public void insertItem(inventoryItem x) {
        String sql = "INSERT INTO inventoryItem(ItemNAme,ItemCount) VALUES(?,?)";
        
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, x.getItemName());
            pstmt.setInt(2, x.getItemCount());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
