package HSMmodel;

/**
 *
 * @author soumbou
 */
public class employee extends person{   
    String bdate;
    String gender;
    
    /**
     * Constructor for employee
     */
    public employee(){}
    public employee( String fname, String lname){
        this.firstname = fname;
        this.lastname = lname;
    }    
    
    /* get Employee date of birth
     * @return Employee date of birth
    */
    public String getBirthday(){
        String full = this.firstname + " " + this.lastname;
        return full;
    }
    
    
}
