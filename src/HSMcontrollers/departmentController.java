package HSMcontrollers;

import dbConnexion.SQLiteJDBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Noria Soumbou
 */
public class departmentController {
    
    final private SQLiteJDBConnection db = new SQLiteJDBConnection();
    
    /**
     * Create new department in the database
     * @param name
     */
    public void insertDepartment(String name){        
        String sql = "INSERT INTO department(nameDepartment) VALUES(?)"; 
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Update the name of the department in the database
     * @param name new department name
     * @param id id of department
     */
    public void updateNameDepartment(String name, int id){
        String sql = "UPDATE department set nameDepartment = ?"
                 +" WHERE idDepartment = ? ";
 
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateManageDepartment(int idept, int idman){
         String sql = "UPDATE department set idManager = ?"
                 +" WHERE idDepartment = ? ";
 
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idman);
            pstmt.setInt(2, idept);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * delete a department in the database
     * @param id
     */
    public void deleteDepartment( int id){
         String sql = "DELETE FROM department WHERE idDepartment = ?"; 
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /* TODO get name of manager, change requete
    public void getNameofManagerDepartment(int idept, int idman){
         String sql = "UPDATE department set idManager = ?"
                 +" WHERE idDepartment = ? ";
 
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idman);
            pstmt.setInt(2, idept);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/
}
