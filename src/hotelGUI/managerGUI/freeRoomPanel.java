/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelGUI.managerGUI;
import dbConnexion.SQLiteJDBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Panel show all tables who has not be reserved
 * @author Noria Soumbou
 */
public class freeRoomPanel extends javax.swing.JPanel {
    final private SQLiteJDBConnection db = new SQLiteJDBConnection();
    /**
     * Creates new form freeRoomPanel
     */
    public freeRoomPanel() {
        initComponents();
        fillTable();
    }
    
    /**
     * Fill the table of free rooms
     */
    private void fillTable(){
        
        String sql = "SELECT * FROM room ";
        try (Connection conn = db.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    if(isFree(rs.getInt(1))){
                        //TODO put in table
                    }
                    // System.out.println("2:"+rs.getInt(1));
                }
                rs.close();
            }catch(SQLException e){ System.out.println("Result: "+e.getMessage()); }            
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("select "+e.getMessage());
        }      
    
    }
    
    /**
     * check if room is not reserved or occupied
     * @param rid room ID
     * @return true if free and false if not
     */
    private boolean isFree(int rid){   
        boolean free = true;
        String sql = "SELECT status FROM room_reserve where idRoom = ?";
        try (Connection conn = db.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
             pstmt.setInt(1, rid);
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    free = false;
                }
                rs.close();
            }catch(SQLException e){ System.out.println("Result: "+e.getMessage()); }            
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("select "+e.getMessage());
        }   
        return free;    
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
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
