/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelGUI.clientGUI;

import dbConnexion.SQLiteJDBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Noria Soumbou
 */
public class WakePanel extends javax.swing.JPanel {
    
    private final int rid;
    private final String cid;
    final private SQLiteJDBConnection db = new SQLiteJDBConnection();
    
    /**
     * Creates new form wakePanel
     * @param CID Client name
     * @param RID Room Id
     */
    public WakePanel( String CID, int RID) {
        initComponents();
        cid = CID;
        rid = RID;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        moreText = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        timeBox = new javax.swing.JComboBox<>();

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel1.setText("What time would you like to be wake up?");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        moreText.setColumns(20);
        moreText.setRows(5);
        jScrollPane1.setViewportView(moreText);

        jLabel2.setText("Date");

        jLabel3.setText("Time");

        timeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12:00 AM (Midnight)","12:30 AM", "01:00 AM","01:30 AM", "02:00 AM","02:30 AM", "03:00 AM","03:30 AM", "04:00 AM","04:30 AM", "05:00 AM","05:30 AM", "06:00 AM","06:30 AM", "07:00 AM", "07:30 AM","08:00 AM","08:30 AM", "09:00 AM","09:30 AM", "10:00 AM","10:30 AM", "11:00 AM","11:30 AM", "12:00 PM (Noon)","12:30 PM", "01:00 PM","01:30 PM","02:00 PM", "02:30 PM", "03:00 PM","03:30 PM",  "04:00 PM","04:30 PM",  "05:00 PM","05:30 PM",  "06:00 PM", "06:30 PM", "07:00 PM","07:30 PM", "08:00 PM","08:30 PM", "09:00 PM","09:30 PM", "10:00 PM","10:30 PM", "11:00 PM","11:30 PM" }));
        timeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jButton1))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(timeBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(timeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String sql = "INSERT INTO wake (idRoom,date,time,client,more) VALUES(?,?,?,?,?)";
        java.util.Date utilWakeDate = dateChooser.getDate();
        java.sql.Date sqlWakeDate = new java.sql.Date(utilWakeDate.getTime());
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(2, sqlWakeDate);
            pstmt.setString(3, timeBox.getItemAt(timeBox.getSelectedIndex()));
            pstmt.setInt(1, rid);
            pstmt.setString(4, cid);
            pstmt.setString(5, moreText.getText());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       showMessageDialog(null, "Request Saved");
       moreText.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void timeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea moreText;
    private javax.swing.JComboBox<String> timeBox;
    // End of variables declaration//GEN-END:variables
}
