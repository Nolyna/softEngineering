
package hotelGUI.managerGUI;


import dbConnexion.SQLiteJDBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Noria Soumbou
 */
public class TourPanel extends javax.swing.JPanel {
    
  
    final private SQLiteJDBConnection db = new SQLiteJDBConnection();
    private int row, row2;
    
    /**
     * Creates new form tourPanel
     */
    public TourPanel() {
        initComponents();
    }
    private void clearTable(){
    
        DefaultTableModel model = (DefaultTableModel) tourTable.getModel();
        model.setRowCount(0);
    
    }
    private void deleteRow(){
        
           String sql = "DELETE FROM tour WHERE idTour =?" ; 
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, row2);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    
    
    }
    private void fillTable(){
        DefaultTableModel model = (DefaultTableModel) tourTable.getModel();
        
        String sql = "SELECT * FROM tour";
        
        
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while(rs.next()) {
                    //TODO change to date
                  model.addRow(new Object[]{ rs.getInt("idTour"), rs.getString("title"), rs.getString("description"), 
                      rs.getString("date"),rs.getString("timeBegin"),rs.getString("timeEnd"),rs.getInt("fee")});
                  System.out.println("tour: "+ rs.getString("title"));
                }
                rs.close();
            }catch(SQLException e){ System.out.println("all tour: "+e.getMessage()); }            
            pstmt.close();
            //conn.close();
        } catch (SQLException e) {
            System.out.println("all tour db"+e.getMessage());
        }
        
    }
        //System.out.println(tourTable.getValueAt(1, 1));
       // tourTable.removeColumn(tourTable.getColumnModel().getColumn(0)); // hide id
        //tourTable.removeColumn(tourTable.getColumnModel().getColumn(1)); // hide description
        //tourTable.removeColumn(tourTable.getColumnModel().getColumn(4)); // hide fee
     
    
    /**
     * Update the invoice of the client
     * @param id client id
     * @param fee 
     */
    private void updateInvoice( int id, int fee){
        // TODO WRITE CODE
    }
    
    private boolean isRegister( int idc, int ide){
        // TODO WRITE CODE
        return false;
    }
    
    private void empty(){
        evT.setText("tour:");
        descT.setText("Description:");
        dTe.setText("Date:");
        BeginT.setText("Begin:");
        EndT.setText("End:");
        costT.setText("Cost:");
    }
    
    private void tourTableMouseClicked(java.awt.event.MouseEvent evt) {                                        
         row = tourTable.getSelectedRow();
         row2 = (int) tourTable.getModel().getValueAt(row,0);
        System.out.println("select tour row"+tourTable.getModel().getValueAt(row, 4));
        if (row >= 0){
           BeginT.setText(""+tourTable.getModel().getValueAt(row, 4));
           EndT.setText(""+tourTable.getModel().getValueAt(row, 5));
           costT.setText(""+tourTable.getModel().getValueAt(row, 6));
           dTe.setText(""+tourTable.getModel().getValueAt(row, 3));
           descT.setText(""+tourTable.getModel().getValueAt(row, 2));
           evT.setText(""+tourTable.getModel().getValueAt(row, 1));
       }else{
           empty();
       }
        System.out.println("" + row);
        
    }                                       

    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tourTable = new javax.swing.JTable();
        menuPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Name = new javax.swing.JLabel();
        d = new javax.swing.JLabel();
        Price = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        TimeF = new javax.swing.JLabel();
        TimeT = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        evT = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        dTe = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        BeginT = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        EndT = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        costT = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        descT = new javax.swing.JTextPane();
        addButton1 = new javax.swing.JButton();

        tourTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Title", "Decription", "Date", "Begin", "End", "Fee"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tourTable.setColumnSelectionAllowed(true);
        tourTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tourTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tourTable);
        tourTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        addButton.setText("Add tour");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update tour");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Remove tour");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jButton1.setText("see participants");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Name.setText("Name:");

        d.setText("Description:");

        Price.setText("Price");

        Date.setText("Date");

        TimeF.setText("Time:  From");

        TimeT.setText("To");

        jScrollPane2.setViewportView(evT);

        jScrollPane3.setViewportView(dTe);

        jScrollPane4.setViewportView(BeginT);

        jScrollPane5.setViewportView(EndT);

        jScrollPane6.setViewportView(costT);

        jScrollPane7.setViewportView(descT);

        addButton1.setText("Refresh Table");
        addButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(menuPanelLayout.createSequentialGroup()
                                .addComponent(updateButton)
                                .addGap(30, 30, 30)
                                .addComponent(deleteButton)))
                        .addGap(0, 36, Short.MAX_VALUE))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addButton1)
                        .addGap(26, 26, 26))))
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TimeF)
                            .addComponent(Price))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(menuPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TimeT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5))
                            .addComponent(jScrollPane6)))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(d)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane7))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Name)
                            .addComponent(Date))
                        .addGap(34, 34, 34)
                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3)))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(addButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(addButton1))
                .addGap(29, 29, 29)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Name)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Date)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TimeF, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TimeT, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(Price))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane7)
                        .addGap(18, 18, 18))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(d)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(deleteButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:tour_addButtonActionPerformed
        // TODO add your handling code here:
        new AddTourForm().setVisible(true); 
    }//GEN-LAST:tour_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:tour_updateButtonActionPerformed
   
         //tourController inittour = new tourController();
        //inittour.insert("" + nameText.getText(), "" + descText.getText(), "" + dateText.getDateFormatString() , beginText.getSelectedIndex() ,endText.getSelectedIndex() , "" + priceText.getText()  );
        String title =  evT.getText();
        String description = descT.getText();
        String date = dTe.getText();
        String Shours = BeginT.getText();
        String Ehours = EndT.getText();
        String fee = costT.getText();
        
        String sql = "INSERT INTO tour(title,description,date,timeBegin,timeEnd, fee) VALUES(?,?,?,?,?,?)";        
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, description);
            pstmt.setString(3, date);
            pstmt.setString(4, Shours);
            pstmt.setString(5, Ehours);
            pstmt.setString(6, fee);
            pstmt.executeUpdate();
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }    
        
        
        JOptionPane.showMessageDialog(null, " tour Updated");
        
        deleteRow();
        clearTable();
        fillTable();
        
        
      


// TODO add your handling code here:
    }//GEN-LAST:tour_updateButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:tour_jButton1ActionPerformed
        // TODO add your handling code here: get ID from selected element and put in x
        JOptionPane.showMessageDialog(null, "Feature coming soon!!!");
    }//GEN-LAST:tour_jButton1ActionPerformed

    private void addButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:tour_addButton1ActionPerformed
                
            clearTable();
            fillTable();
        // TODO add your handling code here:
    }//GEN-LAST:tour_addButton1ActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:tour_deleteButtonActionPerformed

        
      deleteRow();
        clearTable();
        fillTable();

        // TODO add your handling code here:
    }//GEN-LAST:tour_deleteButtonActionPerformed

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane BeginT;
    private javax.swing.JLabel Date;
    private javax.swing.JTextPane EndT;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Price;
    private javax.swing.JLabel TimeF;
    private javax.swing.JLabel TimeT;
    private javax.swing.JButton addButton;
    private javax.swing.JButton addButton1;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JTextPane costT;
    private javax.swing.JLabel d;
    private javax.swing.JTextPane dTe;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextPane descT;
    private javax.swing.JTextPane evT;
    private javax.swing.JTable tourTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
