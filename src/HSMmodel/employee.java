package HSMmodel;

/**
 *
 * @author soumbou
 */
public class employee extends person{   
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
    
    public void setBirthday( String date){
        this.bdate = date;
    }
    
    public void setSSN( String ssn){
        this.ssn = ssn;
    }
    
    public void setGender( String gender){
        this.gender = gender;
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
    
    
}
