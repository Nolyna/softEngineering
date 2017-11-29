package HSMmodel;

import dbConnexion.SQLiteJDBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author soumbou
 */
public class employee extends person{ 
    final private SQLiteJDBConnection db = new SQLiteJDBConnection();
    private int id;
    String bdate, ssn;
    String gender;
    
    /**
     * Constructor for employee
     */
    public employee(){}
    public employee( String fname, String lname){
        this.firstname = fname;
        this.lastname = lname;
    }    
    
    public void setid(int id){
        this.id =id;
    }
    
    public void setBirthday( String date){
        this.bdate = date;
    }
    
    public void setSSN( String ssn){
        this.ssn = ssn;
    }
    
    public void setGender( String gender){
        this.gender = gender;
    }
    
    public int getid(){
        return this.id;
    }
    
    /* get Employee date of birth
     * @return Employee date of birth
    */
    public String getBirthday(){
        return this.bdate;
    }
    
    public String getSSN(){
        return this.ssn;
    }
    
    /* get Employee gender
     * @return Employee gender
    */
    public String getGender(){
        return this.gender;
    }
    
    public void getEmployeeByEmail(){
        String sql = "SELECT * FROM employee where email = ? ";
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.email);
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                   this.id = rs.getInt("idEmployee");
                   this.firstname = rs.getString("firstName");
                   this.lastname = rs.getString("lastName");
                   this.phone= rs.getString("phone");
                   this.password = rs.getString("password");
                   this.ssn = rs.getString("ssn");
                   this.bdate = rs.getString("bdate");
                   this.gender = rs.getString("gender");
                   this.adress = rs.getString("adress");
                }
                rs.close();
            }catch(SQLException e){ System.out.println("getEmployeeByEmail: "+e.getMessage()); }            
            pstmt.close();
            //conn.close();
        } catch (SQLException e) {
            System.out.println("getEmployeeByEmail"+e.getMessage());
        }        
    }
    
    
}
