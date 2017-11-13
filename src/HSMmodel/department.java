package HSMmodel;

/**
 * Purpose:
 * @author Noria soumbou
 */
public class department {
    
    public String name;
    private int id;
    private int manager;
    
    public department(){}
    
    public department(String name){
        this.name = name;
    }
     
    public void setDeptName( String name){
        this.name = name;
    }
    public void setDeptManagerId(int id){
        this.manager = id;
    }
       
    public String getDeptName(){
        return this.name;
    };
        
    public int getDeptManagerId(){
        return this.manager;
    };
}
