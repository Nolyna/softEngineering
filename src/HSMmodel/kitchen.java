/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HSMmodel;

/**
 *
 * @author jermaine anderson
 */
public class kitchen {
    
       private String foodname;
   private int quantity;
           
    
    public kitchen(String FoodName,int Quantity){
        this.foodname = FoodName;
        this.quantity = Quantity;
    
    }
            
   public String getFoodName(){
       return foodname;
   }


    public int getQuantity(){
       return quantity;
   }
    
}
