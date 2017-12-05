
package hotelGUI.managerGUI;


import dbConnexion.SQLiteJDBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Noria Soumbou
 */
public class EventPanel extends javax.swing.JPanel {
    
  
    final private SQLiteJDBConnection db = new SQLiteJDBConnection();
    private int row, row2;
    
    /**
     * Creates new form EventPanel
     * @param CID
     */
    public EventPanel() {
        initComponents();
        fillTable();
        idT.setVisible(false);
    }
    private void clearTable(){
    
        DefaultTableModel model = (DefaultTableModel) eventTable.getModel();
        model.setRowCount(0);
    
    }
    
    private void deleteRow( int id){            
        
           String sql = "DELETE FROM event WHERE idEvent =?" ; 
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    
    
    }
    private void fillTable(){
        DefaultTableModel model = (DefaultTableModel) eventTable.getModel();
        
        String sql = "SELECT * FROM event";
        
        
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while(rs.next()) {
                    //TODO change to date
                  model.addRow(new Object[]{ rs.getInt("idEvent"), rs.getString("title"), rs.getString("description"), 
                      rs.getString("date"),rs.getString("timeBegin"),rs.getString("timeEnd"),rs.getInt("fee")});
                  System.out.println("event: "+ rs.getString("title"));
                }
                rs.close();
            }catch(SQLException e){ System.out.println("all event: "+e.getMessage()); }            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("all event db"+e.getMessage());
        }
        eventTable.removeColumn(eventTable.getColumnModel().getColumn(0)); // hide id
        eventTable.setDefaultEditor(Object.class, null);
        
    }
        
    
    private void empty(){
        evT.setText("Event:");
        descT.setText("Description:");
        dTe.setText("Date:");
        BeginT.setText("Begin:");
        EndT.setText("End:");
        costT.setText("Cost:");
        idT.setText("");
    }
    
    private void eventTableMouseClicked(java.awt.event.MouseEvent evt) {                                        
         row = eventTable.getSelectedRow();         
        if (row >= 0){
           row2 = (int) eventTable.getModel().getValueAt(row,0);
           BeginT.setText((String) eventTable.getModel().getValueAt(row, 4));
           EndT.setText((String) eventTable.getModel().getValueAt(row, 5));
           costT.setText((String) eventTable.getModel().getValueAt(row, 6));
           dTe.setText((String) eventTable.getModel().getValueAt(row, 3));
           descT.setText((String) eventTable.getModel().getValueAt(row, 2));
           evT.setText((String) eventTable.getModel().getValueAt(row, 1));
           idT.setText((String) eventTable.getModel().getValueAt(row,0));
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
        eventTable = new javax.swing.JTable();
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
        idT = new javax.swing.JTextField();

        eventTable.setModel(new javax.swing.table.DefaultTableModel(
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
        eventTable.setColumnSelectionAllowed(true);
        eventTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eventTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(eventTable);
        eventTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        addButton.setText("Add event");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update event");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Remove Event");
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

        idT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTActionPerformed(evt);
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
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(idT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addComponent(idT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
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

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        new AddEventForm().setVisible(true); 
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        //eventController initEvent = new eventController();
        //initEvent.insert("" + nameText.getText(), "" + descText.getText(), "" + dateText.getDateFormatString() , beginText.getSelectedIndex() ,endText.getSelectedIndex() , "" + priceText.getText()  );
        String title = evT.getText();
        String description = descT.getText();
        String date =  dTe.getText();
        String Shours = BeginT.getText();
        String Ehours = EndT.getText();
        String fee = costT.getText();
        
        if( "".equals(idT.getText())){
            JOptionPane.showMessageDialog(null, " Select event");    
        }else{
        
            String sql = "UPDATE event SET title = ?,description =?,date=?,"
                    + "timeBegin = ?,timeEnd = ?, fee = ? WHERE idEvent = ?";        
            try (Connection conn = db.connect();
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, title);
                pstmt.setString(2, description);
                pstmt.setString(3, date);
                pstmt.setString(4, Shours);
                pstmt.setString(5, Ehours);
                pstmt.setString(6, fee);
                pstmt.setInt(7, Integer.valueOf(idT.getText()));
                pstmt.executeUpdate();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }            

            JOptionPane.showMessageDialog(null, " Event Updated"); 
            clearTable();
            fillTable();
        }

    }//GEN-LAST:event_updateButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here: get ID from selected element and put in x
        JOptionPane.showMessageDialog(null, "Feature coming soon!!!");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton1ActionPerformed
            clearTable();
            fillTable();
    }//GEN-LAST:event_addButton1ActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
      if( "".equals(idT.getText())){
            JOptionPane.showMessageDialog(null, " Select event");    
        }else{
            deleteRow(Integer.valueOf(idT.getText()));
            JOptionPane.showMessageDialog(null, " Event deleted"); 
            clearTable();
            fillTable();
      }
      
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void idTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTActionPerformed

    


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
    private javax.swing.JTable eventTable;
    private javax.swing.JTextField idT;
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
