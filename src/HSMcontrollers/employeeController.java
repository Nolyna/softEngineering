package HSMcontrollers;

import HSMmodel.employee;
import dbConnexion.SQLiteJDBConnection;
import hotelGUI.cleaningServicesPage;
import hotelGUI.maintenancePage;
import hotelGUI.managerPg;
import hotelGUI.repPage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;



/**
 *
 * @author Noria Soumbou
 */
public class employeeController {
    
    final private SQLiteJDBConnection db = new SQLiteJDBConnection();
  
    
    public void insertEmployee(employee x) {
        String sql = "INSERT INTO employee(firstName,lastName, email, password) VALUES(?,?,?,?)";
        
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, x.getfirstname());
            pstmt.setString(2, x.getlastname());
            pstmt.setString(3, x.getemail());
            pstmt.setString(4, x.getpassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }    
    
    public void insertEmployee(String fname,String lname, String email, String pass) {
        String sql = "INSERT INTO employee(firstName,lastName, email, password) VALUES(?,?,?,?)";
        
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fname);
            pstmt.setString(2, lname);
            pstmt.setString(3, email);
            pstmt.setString(4, pass);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void clockin(int id) {
        String sql = "INSERT INTO in_out(idEmployee,checkin,dates) VALUES(?,?,?)";
        
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, currentTime());
            pstmt.setString(3, todayDate());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void clockout(int id) {
        String sql = "UPDATE in_out SET checkout= ?"
                + "WHERE idEmployee=? AND dates = ?";
        
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, currentTime());
            pstmt.setInt(2, id);
            pstmt.setString(3, todayDate());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void madeManager(int employee, int dept){
        String sql = "UPDATE department SET idManager = ? "
                + " WHERE idDepartment = ?";
        
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, employee);
            pstmt.setInt(2, dept);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public String todayDate (){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar date = Calendar.getInstance();
        String today = (dateFormat.format(date));
        return today;
    }
    
    public String currentTime (){
        Calendar time = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String today = (dateFormat.format(time.getTime()));
        return today;
    }
    
   public boolean logIn(String username, String password){
       boolean found;
        if ((username.equals("manager")||username.equals("Manager"))&&(password.equals("Password")||password.equals("password"))){
            found = true;
            new managerPg().setVisible(true);
        }
        else if ((username.equals("clean")||username.equals("Clean"))&&(password.equals("Password")||password.equals("password"))){
            found = true;
            new cleaningServicesPage().setVisible(true);
        }
        else if ((username.equals("maintenance")||username.equals("Maintenace"))&&(password.equals("Password")||password.equals("password"))){
            found = true;
            new maintenancePage().setVisible(true);
        }
        else if ((username.equals("receptionist")||username.equals("Receptionist"))&&(password.equals("Password")||password.equals("password"))){
            found = true;
            new repPage().setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Please try again! Email or passord invalid");
            found = false;
        }
    return found;
    }
    
}