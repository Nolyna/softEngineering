/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelGUI.employeeGUI;

import dbConnexion.SQLiteJDBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Noria Soumbou
 */
public class kitchenFoodPanel extends javax.swing.JPanel {
    ArrayList  menuid = new ArrayList();
    ArrayList  entryid = new ArrayList(), entryqte = new ArrayList(),entryprice = new ArrayList();
    ArrayList  dessertid = new ArrayList(),dessertqte = new ArrayList(),dessertprice = new ArrayList();
    ArrayList  drinkid = new ArrayList(),drinkqte = new ArrayList(),drinkprice = new ArrayList();
    ArrayList  sideid = new ArrayList(),sideqte = new ArrayList(),sideprice = new ArrayList() ;
    final private SQLiteJDBConnection db = new SQLiteJDBConnection();
    /**
     * Creates new form kitchenFoodPanel
     */
    public kitchenFoodPanel() {
        initComponents();
        updatelists();
        idT.setVisible(false);
    }
    
   
    
    private void fillMenuBox(){
        menuBox.removeAllItems();
        String sql = "Select * from menu ";
        
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {          
            try (ResultSet rs = pstmt.executeQuery()) {
                while(rs.next()) {
                    menuBox.addItem(rs.getString("nameMenu"));
                    menuid.add(rs.getInt("idMenu"));
                }
            }catch (SQLException e) { System.out.println(" error "+e.getMessage());}  
            
        } catch (SQLException e) {
            System.out.println(" error "+e.getMessage());
        }              
    }
    
    private void fillEntryList(){
        entryList.removeAll();
        entryid.clear();
        entryqte.clear();
        entryprice.clear();
        
        String sql = "Select * from menu_items where idMenu = 1 ";
        DefaultListModel model = new DefaultListModel ();
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {          
            try (ResultSet rs = pstmt.executeQuery()) {
                while(rs.next()) {
                    model.addElement ( rs.getString("nameItem"));
                    entryid.add(rs.getInt("idMenuItem"));
                    entryqte.add(rs.getInt("qte"));
                    entryprice.add(rs.getDouble("price"));
                }
            }catch (SQLException e) { System.out.println(" error "+e.getMessage());}  
            
        } catch (SQLException e) {
            System.out.println(" error "+e.getMessage());
        }          
        entryList.setModel(model);        
    }
    
    private void fillSideList(){
        sideList.removeAll();
        sideid.clear();
        sideqte.clear();
        sideprice.clear();
        
        String sql = "Select * from menu_items where idMenu = 2 ";
        DefaultListModel model = new DefaultListModel ();
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {          
            try (ResultSet rs = pstmt.executeQuery()) {
                while(rs.next()) {
                    model.addElement ( rs.getString("nameItem"));
                    sideid.add(rs.getInt("idMenuItem"));
                    sideqte.add(rs.getInt("qte"));
                    sideprice.add(rs.getDouble("price"));
                }
            }catch (SQLException e) { System.out.println(" error "+e.getMessage());}  
            
        } catch (SQLException e) {
            System.out.println(" error "+e.getMessage());
        }          
       sideList.setModel(model);        
    }
    
    private void fillDessertList(){
        dessertList.removeAll();
        dessertid.clear();
        dessertqte.clear();
        dessertprice.clear();
        
        String sql = "Select * from menu_items where idMenu = 3 ";
        DefaultListModel model = new DefaultListModel ();
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {          
            try (ResultSet rs = pstmt.executeQuery()) {
                while(rs.next()) {
                    model.addElement ( rs.getString("nameItem"));
                    dessertid.add(rs.getInt("idMenuItem"));
                    dessertqte.add(rs.getInt("qte"));
                    dessertprice.add(rs.getDouble("price"));
                }
            }catch (SQLException e) { System.out.println(" error "+e.getMessage());}  
            
        } catch (SQLException e) {
            System.out.println(" error "+e.getMessage());
        }          
       dessertList.setModel(model);        
    }
    
    private void fillDrinkList(){
        drinkList.removeAll();
        drinkid.clear();
        drinkqte.clear();
        drinkprice.clear();
        
        String sql = "Select * from menu_items where idMenu = 4 ";
        DefaultListModel model = new DefaultListModel ();
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {          
            try (ResultSet rs = pstmt.executeQuery()) {
                while(rs.next()) {
                    model.addElement ( rs.getString("nameItem"));
                    drinkid.add(rs.getInt("idMenuItem"));
                    drinkqte.add(rs.getInt("qte"));
                    drinkprice.add(rs.getDouble("price"));
                }
            }catch (SQLException e) { System.out.println(" error "+e.getMessage());}  
            
        } catch (SQLException e) {
            System.out.println(" error "+e.getMessage());
        }          
       drinkList.setModel(model);        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        entryList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        drinkList = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        dessertList = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        menuBox = new javax.swing.JComboBox<>();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        nameT = new javax.swing.JTextField();
        priceT = new javax.swing.JTextField();
        idT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        qteT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        sideList = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        entryList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        entryList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        entryList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                entryListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(entryList);

        drinkList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        drinkList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                drinkListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(drinkList);

        dessertList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        dessertList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        dessertList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dessertListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(dessertList);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        jPanel1.setAutoscrolls(true);

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Remove");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        priceT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTActionPerformed(evt);
            }
        });

        idT.setEditable(false);
        idT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTActionPerformed(evt);
            }
        });

        jLabel2.setText("Name:");

        jLabel3.setText("Price:");

        jLabel4.setText("$");

        jLabel9.setText("Menu:");

        jLabel10.setText("Quantity:");

        qteT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qteTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameT, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(qteT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idT, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(2, 2, 2)
                        .addComponent(priceT, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(menuBox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(menuBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addButton)
                        .addComponent(deleteButton)
                        .addComponent(idT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(qteT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jLabel5.setText("Entrees");

        jLabel6.setText("Side");

        jLabel7.setText("Beverage");

        sideList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        sideList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sideListMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(sideList);

        jLabel8.setText("Dessert");

        jLabel1.setFont(new java.awt.Font("Bodoni MT", 3, 24)); // NOI18N
        jLabel1.setText("Your Kitchen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(55, 55, 55)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(74, 74, 74)
                        .addComponent(jLabel8)
                        .addGap(71, 71, 71)
                        .addComponent(jLabel7)
                        .addGap(102, 102, 102))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void priceTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceTActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if( "".equals(qteT.getText()) || "".equals(priceT.getText()) || "".equals(nameT.getText())){
            JOptionPane.showMessageDialog(null," Fill all the fields");
        }else{
            int id = (int) menuid.get(menuBox.getSelectedIndex());
            String sql = "INSERT INTO menu_items(idMenu,nameItem, price, qte) VALUES(?,?,?,?)"; 
            try (Connection conn = db.connect();
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1,  id);
                pstmt.setString(2, nameT.getText());
                pstmt.setDouble(3, Double.parseDouble(priceT.getText()));
                pstmt.setInt(4,Integer.parseInt(qteT.getText()));
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println("kitchen G: "+e.getMessage());
            }
            empty();
            updatelists();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void idTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        if("".equals(idT.getText())){
            JOptionPane.showConfirmDialog (null, "Select in list");
        } else {
            int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure ?","Warning",dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION){          
                String sql = "DELETE FROM menu_items where idMenuItem = ?"; 
                try (Connection conn = db.connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setInt(1,  Integer.parseInt(idT.getText()));
                    pstmt.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("KITCHEN: "+e.getMessage());
                }
            }
        }
        empty();
        updatelists();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void qteTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qteTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qteTActionPerformed

    private void entryListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entryListMouseClicked
        int x = entryList.getSelectedIndex();
        if(x >= 0){
            idT.setText(String.valueOf(entryid.get(x)));
            nameT.setText(entryList.getSelectedValue());
            priceT.setText(String.valueOf(entryprice.get(x)));
            qteT.setText(String.valueOf( entryqte.get(x)));
        }else{
            empty();
        }
    }//GEN-LAST:event_entryListMouseClicked

    private void sideListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideListMouseClicked
        int x = sideList.getSelectedIndex();
        if(x >= 0){
            idT.setText(String.valueOf(sideid.get(x)));
            nameT.setText(sideList.getSelectedValue());
            priceT.setText(String.valueOf(sideprice.get(x)));
            qteT.setText(String.valueOf(sideqte.get(x)));
        }else{
            empty();
        }
    }//GEN-LAST:event_sideListMouseClicked

    private void dessertListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dessertListMouseClicked
       int x = dessertList.getSelectedIndex();
        if(x >= 0){
            idT.setText(String.valueOf(dessertid.get(x)));
            nameT.setText(dessertList.getSelectedValue());
            priceT.setText(String.valueOf(dessertprice.get(x)));
            qteT.setText(String.valueOf(dessertqte.get(x)));
        }else{
            empty();
        }
    }//GEN-LAST:event_dessertListMouseClicked

    private void drinkListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drinkListMouseClicked
        int x = drinkList.getSelectedIndex();
        if(x >= 0){
            idT.setText(String.valueOf(drinkid.get(x)));
            nameT.setText(drinkList.getSelectedValue());
            priceT.setText(String.valueOf(drinkprice.get(x)));
            qteT.setText(String.valueOf(drinkqte.get(x)));
        }else{
            empty();
        }
    }//GEN-LAST:event_drinkListMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JList<String> dessertList;
    private javax.swing.JList<String> drinkList;
    private javax.swing.JList<String> entryList;
    private javax.swing.JTextField idT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JComboBox<String> menuBox;
    private javax.swing.JTextField nameT;
    private javax.swing.JTextField priceT;
    private javax.swing.JTextField qteT;
    private javax.swing.JList<String> sideList;
    // End of variables declaration//GEN-END:variables

    private void updatelists() {
        fillMenuBox();
        fillEntryList();
        fillDessertList();
        fillDrinkList();
        fillSideList();
    }
    
    private void empty(){
        nameT.setText("");
        priceT.setText("");
        qteT.setText("");
        menuBox.setSelectedIndex(1);
        idT.setText("");
    }
}
