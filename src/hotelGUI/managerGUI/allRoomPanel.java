/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelGUI.managerGUI;

import HSMcontrollers.roomController;
import dbConnexion.SQLiteJDBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Noria Soumbou
 */
public class allRoomPanel extends javax.swing.JPanel {

    final private SQLiteJDBConnection db = new SQLiteJDBConnection();

    /**
     * Creates new form allRoomPanel
     */
    public allRoomPanel() {
        initComponents();
        /*ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        ses.scheduleAtFixedRate(() -> {*/
            fillTable();
        //}, 0, 1, TimeUnit.MINUTES);
    }

    private void fillTable() {
        roomController rc = new roomController();
        DefaultTableModel model = (DefaultTableModel) roomTable.getModel();
        //model.setRowCount(0);
        String sql = "SELECT * FROM rooms ";
        try (Connection conn = db.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                        model.addRow(new Object[]{rs.getInt("idRoom"),rc.GetRoomName(rs.getInt("idRoomType")), 
                            rs.getString("location"), rs.getString("description"), rc.GetRoomPriceByType(rs.getInt("idRoomType")),
                            rc.roomReservationStatus(rs.getInt("idRoom")) });
                }
                rs.close();
            } catch (SQLException e) {
                System.out.println("Result: " + e.getMessage());
            }
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("select " + e.getMessage());
        }
        //hide id column - retrieve id table.getModel().getValueAt(table.getSelectedRow(),4);
        roomTable.removeColumn(roomTable.getColumnModel().getColumn(0));

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
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Type");
        model.addColumn("Location");
        model.addColumn("Description");
        model.addColumn("Price/night");
        model.addColumn("Status");
        roomTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        roomTable.setModel(model);
        /*
        roomTable.setAutoCreateRowSorter(true);
        roomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        */
        jScrollPane1.setViewportView(roomTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable roomTable;
    // End of variables declaration//GEN-END:variables

}
