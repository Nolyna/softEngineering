/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelGUI.employeeGUI;
import HSMcontrollers.employeeController;
import dbConnexion.SQLiteJDBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Noria Soumbou
 */
public class ClockPanel extends javax.swing.JPanel {
    
    final private employeeController clocktime = new employeeController();
    private int cid;
    private final DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
    private final DateFormat tf = new SimpleDateFormat("HH:mm:ss");
    private Date date = new Date();
    final private SQLiteJDBConnection db = new SQLiteJDBConnection();
    /**
     * Creates new form clock
     * @param EID employee ID
     */
    public ClockPanel( int EID) {
        initComponents();
        cid = EID;
        fieldTime.setText(df.format(date));
        buttonEBreak.setEnabled(false);
        buttonSBreak.setEnabled(false);
        buttonClockOut.setEnabled(false);
    }
        
    /**
     * get today day timeStamp
     * @return timestamp
     */
    public Long todayDate(){
        Date dtes = new Date();
        Long today = dtes.getTime();
        return today; 
    }
    
    private void getData(){        
        java.sql.Date sqlDate = new java.sql.Date(todayDate());
        String sql = "SELECT * FROM in_out where idEmployee = ? AND dates <= ?";
        try (Connection conn = db.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cid);
            pstmt.setDate(2, sqlDate);
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("in-out search: ");
                if(rs.next()) {
                    System.out.println("in-out found: ");
                    if(rs.getTime("checkin") != null ){ fieldClockIn.setText(rs.getTime("checkin").toString());}
                    if(rs.getTime("checkout")!= null ){ fieldClockOut.setText(rs.getTime("checkout").toString());}
                    if(rs.getTime("breakin") != null ){ fieldBreakStart.setText(rs.getTime("breakin").toString());}
                    if(rs.getTime("breakout")!= null ){ fieldBreakEnd.setText(rs.getTime("breakout").toString());}
                }
            }catch(SQLException e){ System.out.println("in-out: "+e.getMessage()); }  
        } catch (SQLException e) {  System.out.println("in-out db"+e.getMessage());}      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fieldClockIn = new javax.swing.JTextField();
        txtClockIn = new javax.swing.JLabel();
        buttonClockIn = new javax.swing.JButton();
        txtBreakS = new javax.swing.JLabel();
        fieldBreakStart = new javax.swing.JTextField();
        buttonSBreak = new javax.swing.JButton();
        txtBreakE = new javax.swing.JLabel();
        fieldTime = new javax.swing.JTextField();
        buttonEBreak = new javax.swing.JButton();
        txtClockOut = new javax.swing.JLabel();
        fieldClockOut = new javax.swing.JTextField();
        buttonClockOut = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        fieldBreakEnd = new javax.swing.JTextField();
        txtSearch2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        fieldClockIn.setEditable(false);
        fieldClockIn.setFocusable(false);

        txtClockIn.setText("Clock-In Time");

        buttonClockIn.setText("Clock-In");
        buttonClockIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClockInActionPerformed(evt);
            }
        });

        txtBreakS.setText("Break Started ");

        fieldBreakStart.setEditable(false);
        fieldBreakStart.setFocusable(false);

        buttonSBreak.setText("Start Break");
        buttonSBreak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSBreakActionPerformed(evt);
            }
        });

        txtBreakE.setText("Break Ended");

        fieldTime.setEditable(false);
        fieldTime.setFocusable(false);

        buttonEBreak.setText("End Break");
        buttonEBreak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEBreakActionPerformed(evt);
            }
        });

        txtClockOut.setText("Clock-Out Time");

        fieldClockOut.setEditable(false);
        fieldClockOut.setFocusable(false);

        buttonClockOut.setText("Clock-Out");
        buttonClockOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonClockOutMouseClicked(evt);
            }
        });

        jLabel1.setText("Date:");

        fieldBreakEnd.setEditable(false);
        fieldBreakEnd.setFocusable(false);

        txtSearch2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        txtSearch2.setText("Clock ...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtClockIn)
                                        .addGap(23, 23, 23))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(txtClockOut)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fieldClockIn, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                    .addComponent(fieldClockOut)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonClockIn)
                                .addGap(6, 6, 6)
                                .addComponent(buttonClockOut)))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBreakS)
                                    .addComponent(txtBreakE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fieldBreakStart, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                    .addComponent(fieldBreakEnd)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonSBreak)
                                .addGap(24, 24, 24)
                                .addComponent(buttonEBreak))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldTime, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSearch2))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(fieldTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonClockIn)
                    .addComponent(buttonSBreak)
                    .addComponent(buttonEBreak)
                    .addComponent(buttonClockOut))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClockIn)
                    .addComponent(fieldClockIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBreakS)
                    .addComponent(fieldBreakStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBreakE)
                    .addComponent(fieldClockOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClockOut)
                    .addComponent(fieldBreakEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonClockOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonClockOutMouseClicked
        //fieldClockOut.setText(clocktime.currentTime());
        buttonClockOut.setEnabled(false);
        clocktime.clockout(cid);
        getData();
    }//GEN-LAST:event_buttonClockOutMouseClicked

    private void buttonEBreakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEBreakActionPerformed
        //fieldBreakEnd.setText(clocktime.currentTime());
        clocktime.breakkout(cid);
        buttonEBreak.setEnabled(false);
        buttonClockOut.setEnabled(true);
        getData();
    }//GEN-LAST:event_buttonEBreakActionPerformed

    private void buttonSBreakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSBreakActionPerformed
        // TODO add your handling code here:
         //fieldBreakStart.setText(clocktime.currentTime());
         clocktime.breakin(cid);
        buttonSBreak.setEnabled(false);
        buttonEBreak.setEnabled(true);
        getData();
    }//GEN-LAST:event_buttonSBreakActionPerformed

    private void buttonClockInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClockInActionPerformed
        // TODO add your handling code here:
        //fieldClockIn.setText(clocktime.currentTime());
        clocktime.clockin(cid);
        buttonClockIn.setEnabled(false);
        buttonSBreak.setEnabled(true);
        getData();
    }//GEN-LAST:event_buttonClockInActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClockIn;
    private javax.swing.JButton buttonClockOut;
    private javax.swing.JButton buttonEBreak;
    private javax.swing.JButton buttonSBreak;
    private javax.swing.JTextField fieldBreakEnd;
    private javax.swing.JTextField fieldBreakStart;
    private javax.swing.JTextField fieldClockIn;
    private javax.swing.JTextField fieldClockOut;
    private javax.swing.JTextField fieldTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel txtBreakE;
    private javax.swing.JLabel txtBreakS;
    private javax.swing.JLabel txtClockIn;
    private javax.swing.JLabel txtClockOut;
    private javax.swing.JLabel txtSearch2;
    // End of variables declaration//GEN-END:variables
}
