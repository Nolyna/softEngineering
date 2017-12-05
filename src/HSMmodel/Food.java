/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HSMmodel;

import dbConnexion.SQLiteJDBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;

/**
 *
 * @author Noria Soumbou
 */
public class Food {
    final private SQLiteJDBConnection db = new SQLiteJDBConnection();
    int id;
    
   public  Food(){}
    /**
     * new order
     * @param eid client id 
     */
    public void newOrder(int eid){
        String sql = "INSERT INTO foodorder(idClient, status) VALUES(?,?)";
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, eid);
            pstmt.setString(2, "pending");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Get last order created by client
     * @param eid
     * @return 
     */
    public int getOrderId(int eid){
        int ide = 0;
        String sql = "Select MAX(idOrder) from foodorder where idClient = ? ";
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {   
            pstmt.setInt(1, eid);
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    ide = rs.getInt(1);
                }
            }catch (SQLException e) { System.out.println(" error getorderid "+e.getMessage());}  
            
        } catch (SQLException e) {
            System.out.println(" error getorderid "+e.getMessage());
        }          
        return ide;
    }
    
    /**
     * count number of food in order
     * @param oid order id
     * @return count
     */
    public int countItemInOrder(int oid){
        int ide = 0;
        String sql = "Select COUNT(idOrder) from orderhas where idOrder = ? ";
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {   
            pstmt.setInt(1, oid);
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    ide = rs.getInt(1);
                }
            }catch (SQLException e) { System.out.println(" error getorderid "+e.getMessage());}  
            
        } catch (SQLException e) {
            System.out.println(" error getorderid "+e.getMessage());
        }          
        return ide;
    }
    
    /**
     *  get food Id from specific order
     * @param oid order Id
     * @return food id
     */
    public int[] getItemIdInOrder(int oid){
        int[] ide = new int[countItemInOrder(oid)];
        int i = 0;
        String sql = "Select idMenuItem from orderhas where idOrder = ? ";
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {   
            pstmt.setInt(1, oid);
            try (ResultSet rs = pstmt.executeQuery()) {
                while(rs.next()) {
                    ide[i] = rs.getInt(1);
                    i++;
                }
            }catch (SQLException e) { System.out.println(" error getorderid "+e.getMessage());}  
            
        } catch (SQLException e) {
            System.out.println(" error getorderid "+e.getMessage());
        }          
        return ide;
    }
    
    /**
     * Get name of food
     * @param iid food id
     * @return name of food
     */
    public String getItemNameById(int iid){
        String x = "";
        String sql = "Select nameItem from menu_items where idMenuItem = ? ";
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {   
            pstmt.setInt(1, iid);
            try (ResultSet rs = pstmt.executeQuery()) {
                while(rs.next()) {
                    x = rs.getString(1);
                }
            }catch (SQLException e) { System.out.println(" error getorderid "+e.getMessage());}  
            
        } catch (SQLException e) {
            System.out.println(" error getorderid "+e.getMessage());
        }          
        return x;
    }
    
    /**
     * get price of food item
     * @param iid item id
     * @return price
     */
    public Double getItemPriceById(int iid){
       Double x = 0.0;
        String sql = "Select price from menu_items where idMenuItem = ? ";
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {   
            pstmt.setInt(1, iid);
            try (ResultSet rs = pstmt.executeQuery()) {
                while(rs.next()) {
                    x = rs.getDouble(1);
                }
            }catch (SQLException e) { System.out.println(" error getorderid "+e.getMessage());}  
            
        } catch (SQLException e) {
            System.out.println(" error getorderid "+e.getMessage());
        }          
        return x;
    }
    
    public void addProductToOrder(int mid, int oid){
        String sql = "INSERT INTO orderhas(idMenuItem, idOrder) VALUES(?,?)";
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, mid);
            pstmt.setInt(2, oid);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteOrder(int eid, int oid){
        String sql = "DELETE FROM foodorder WHERE idClient = ?";
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, eid);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        sql = "DELETE FROM orderhas WHERE idOrder = ?";
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, oid);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
