package dbConnexion;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
/**
 *
 * @author soumb
 */
public class SQLiteJDBConnection {
    
    final private String url = "jdbc:sqlite:hotelmanagement.db";
    /**
     * Connect to database
     */
    public SQLiteJDBConnection(){}
    
    public static void connexion() {
        String url = "jdbc:sqlite:hotelmanagement.db";
        Connection conn = null;
        try {           
            conn = DriverManager.getConnection(url);            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    /**
     * Connect to the HSM database
     * @return the Connection object
     */
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Connexion error: "+e.getMessage());
        }
        return conn;
    }
    
}
