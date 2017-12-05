/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelGUI.receptionGUI;

import HSMcontrollers.roomController;
import dbConnexion.SQLiteJDBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Noria Soumbou
 */
public class WakePanel extends javax.swing.JPanel {
    final private SQLiteJDBConnection db = new SQLiteJDBConnection();
    /**
     * Creates new form WakePanel
     */
    public WakePanel() {
        initComponents();
        fillTable();
    }
    
    private void fillTable(){
        DefaultTableModel model = (DefaultTableModel) tableWakeupCallTime.getModel();
        roomController rc = new roomController();
        String sql = "SELECT * FROM wake";
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while(rs.next()) {
                  String roomdata = rc.GetRoom(rs.getInt("idRoom"));
                  model.addRow(new Object[]{ rs.getInt("idWake"), roomdata,rs.getString("client"),
                      rs.getDate("date").toString(),rs.getString("time"),rs.getString("more")});
                }
                rs.close();
            }catch(SQLException e){ System.out.println("all wake: "+e.getMessage()); }            
            pstmt.close();
            //conn.close();
        } catch (SQLException e) {
            System.out.println("all wake db"+e.getMessage());
        }
        tableWakeupCallTime.removeColumn(tableWakeupCallTime.getColumnModel().getColumn(0)); // hide id
        tableWakeupCallTime.setDefaultEditor(Object.class, null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel12 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Room");
        model.addColumn("Name");
        model.addColumn("Date");
        model.addColumn("Time");
        model.addColumn("More");
        //tableWakeupCallTime = new javax.swing.JTable();
        tableWakeupCallTime = new javax.swing.JTable();
        callButton = new javax.swing.JButton();
        textF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtSearch2 = new javax.swing.JLabel();

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        tableWakeupCallTime.setModel(model);
        tableWakeupCallTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableWakeupCallTimeMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableWakeupCallTime);

        callButton.setText("Called");
        callButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                callButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Room:");

        txtSearch2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        txtSearch2.setText("Wake up requests");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearch2)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(textF, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(callButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(callButton)
                    .addComponent(textF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void callButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_callButtonActionPerformed
        int row = tableWakeupCallTime.getSelectedRow();
        int id = (int)tableWakeupCallTime.getModel().getValueAt(row, 0);
        deleteWake(id);
    }//GEN-LAST:event_callButtonActionPerformed

    private void tableWakeupCallTimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableWakeupCallTimeMouseClicked
        int row = tableWakeupCallTime.getSelectedRow();
        if (row >= 0){
           textF.setText(tableWakeupCallTime.getModel().getValueAt(row, 1)+" "+tableWakeupCallTime.getModel().getValueAt(row, 2));       
        }
    }//GEN-LAST:event_tableWakeupCallTimeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton callButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tableWakeupCallTime;
    private javax.swing.JTextField textF;
    private javax.swing.JLabel txtSearch2;
    // End of variables declaration//GEN-END:variables

    private void deleteWake(int id) {       
         String sql = "DELETE FROM wake WHERE idWake = ?"; 
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
