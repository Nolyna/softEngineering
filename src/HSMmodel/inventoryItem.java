/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HSMmodel;

/**
 *
 * @author Damasta Altman 
 */
public class inventoryItem {
    public String ItemName;
    public int ItemCount;
    
    
/**
     * Constructor for inventoryItem
     */
    public inventoryItem(){}
    public inventoryItem( String ItemName, int ItemCount){
        this.ItemName = ItemName;
        this.ItemCount = ItemCount;
    }
    public void setItemName(String ItemName){
        this.ItemName = ItemName;
    }
    public void setItemCount(int ItemCount){
        this.ItemCount = ItemCount;
    }
    
    
    public String getItemName(){
        return this.ItemName ;
    }
    public int getItemCount(){
        return this.ItemCount;
    }
     public String getItemDetails(){
        String full = this.ItemName + " " + this.ItemCount;
        return full;
    }
    
    
}
