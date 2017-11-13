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
public class person {
    public String firstname;
    public String lastname;
    private String email;
    private String password;
    /**
     * Constructor for person
     */
    public person(){}
    public person( String fname, String lname){
        this.firstname = fname;
        this.lastname = lname;
    }
    public void setfirstname(String fname){
        this.firstname = fname;
    }
    public void setlastname(String lname){
        this.lastname = lname;
    }
    public void setemail(String mail){
        this.email = mail;
    }
    public void setpassword(String pass){
        this.password = pass;
    }
    
    public String getfirstname(){
        return this.firstname ;
    }
    public String getlastname(){
        return this.lastname;
    }
    public String getemail(){
        return this.email;
    }
    public String getpassword(){
        return this.password;
    }
    
    /* get person full name
     * @return person full name
    */
    public String getfullname(){
        String full = this.firstname + " " + this.lastname;
        return full;
    }

}
