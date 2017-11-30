package hotelGUI;

import HSMmodel.employee;
import hotelGUI.employeeGUI.ClockPanel;
import hotelGUI.employeeGUI.HoursPanel;
import hotelGUI.managerGUI.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

/**
 *PURPOSE:
 * page manager
 * @author Noria Soumbou
 */
class ManagerPage extends javax.swing.JFrame {
    public static employee emp = new employee();
    GridBagLayout layout = new GridBagLayout();
    final ClockPanel clockView; 
    final RoomPanel  roomView;
    final HoursPanel  hoursView;
    final EventPanel eventView;
    final AmenityPanel amenityView;
    final AddEmployeePanel addEmployeeView;
   // final employeePanel employeeView;
    /**
     * Creates new form ManagerPage2
     */
    public ManagerPage( String email) {
        emp.setemail(email);
        emp.getEmployeeByEmail();
        initComponents();
        
        clockView =  new ClockPanel(emp.getid());
        roomView = new RoomPanel();
        hoursView = new HoursPanel();
        eventView = new EventPanel();
        amenityView = new AmenityPanel();
        addEmployeeView = new AddEmployeePanel();
        //employeeView = new employeePanel();
        dynamicPanel.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridx = 0; c.gridy = 0;        
        dynamicPanel.add(roomView,c);
        roomView.setVisible(false);
        
        c.gridx = 0; c.gridy = 0;        
        dynamicPanel.add(addEmployeeView,c);
        addEmployeeView.setVisible(false);
        
       /* c.gridx = 0; c.gridy = 0;        
        dynamicPanel.add(employeeView,c);
        employeeView.setVisible(false);*/
        
        c.gridx = 0; c.gridy = 0;        
        dynamicPanel.add(amenityView,c);
        amenityView.setVisible(false);
        
        c.gridx = 0; c.gridy = 0;        
        dynamicPanel.add(clockView,c);
        clockView.setVisible(false);
        
        c.gridx = 0; c.gridy = 0;        
        dynamicPanel.add(hoursView,c);
        hoursView.setVisible(false);
        
        c.gridx = 0; c.gridy = 0;        
        dynamicPanel.add(eventView,c);
        eventView.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        dynamicPanel = new javax.swing.JPanel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        amenityMenu = new javax.swing.JMenuItem();
        activityMenu = new javax.swing.JMenu();
        eventMenu = new javax.swing.JMenuItem();
        tourMenu = new javax.swing.JMenuItem();
        roomMenu = new javax.swing.JMenuItem();
        settingMenu = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        addEmployeeMenu = new javax.swing.JMenuItem();
        viewEmployeeMenu = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        clockMenu = new javax.swing.JMenuItem();
        hoursMenu = new javax.swing.JMenuItem();
        quitMenu = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout dynamicPanelLayout = new javax.swing.GroupLayout(dynamicPanel);
        dynamicPanel.setLayout(dynamicPanelLayout);
        dynamicPanelLayout.setHorizontalGroup(
            dynamicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        dynamicPanelLayout.setVerticalGroup(
            dynamicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        jMenu3.setText("Hotel ");

        amenityMenu.setText("Amenities");
        amenityMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amenityMenuActionPerformed(evt);
            }
        });
        jMenu3.add(amenityMenu);

        activityMenu.setText("Activities");

        eventMenu.setText("Events");
        eventMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventMenuActionPerformed(evt);
            }
        });
        activityMenu.add(eventMenu);

        tourMenu.setText("Tours");
        activityMenu.add(tourMenu);

        jMenu3.add(activityMenu);

        roomMenu.setText("Rooms");
        roomMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomMenuActionPerformed(evt);
            }
        });
        jMenu3.add(roomMenu);

        settingMenu.setText("Settings");
        jMenu3.add(settingMenu);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Employees");

        addEmployeeMenu.setText("new employee");
        addEmployeeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeMenuActionPerformed(evt);
            }
        });
        jMenu4.add(addEmployeeMenu);

        viewEmployeeMenu.setText("view employees");
        viewEmployeeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewEmployeeMenuActionPerformed(evt);
            }
        });
        jMenu4.add(viewEmployeeMenu);

        jMenuBar2.add(jMenu4);

        jMenu5.setText("User");
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });

        clockMenu.setText("clock-in / clock-out");
        clockMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clockMenuMouseClicked(evt);
            }
        });
        clockMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clockMenuActionPerformed(evt);
            }
        });
        jMenu5.add(clockMenu);

        hoursMenu.setText("Hours summary");
        hoursMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hoursMenuActionPerformed(evt);
            }
        });
        jMenu5.add(hoursMenu);

        quitMenu.setText("Quit");
        quitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitMenuActionPerformed(evt);
            }
        });
        jMenu5.add(quitMenu);

        jMenuBar2.add(jMenu5);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dynamicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dynamicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void amenityMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amenityMenuActionPerformed
        // TODO add your handling code here:
        amenityView.setVisible(true);
        eventView.setVisible(false);
        hoursView.setVisible(false);
        clockView.setVisible(false);
        roomView.setVisible(false);
        clockView.setVisible(false);
        //employeeView.setVisible(false);
        addEmployeeView.setVisible(false);
    }//GEN-LAST:event_amenityMenuActionPerformed

    private void clockMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clockMenuMouseClicked
        // TODO add your handling code here:       
    }//GEN-LAST:event_clockMenuMouseClicked

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu5ActionPerformed

    private void clockMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clockMenuActionPerformed
        // TODO add your handling code here:
        clockView.setVisible(true);
        roomView.setVisible(false);
        hoursView.setVisible(false);
        eventView.setVisible(false);
        amenityView.setVisible(false);
        //employeeView.setVisible(false);
        addEmployeeView.setVisible(false);
        clockView.revalidate();
    }//GEN-LAST:event_clockMenuActionPerformed

    private void roomMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomMenuActionPerformed
        // TODO add your handling code here:
        dynamicPanel.setPreferredSize(roomView.getSize());
        roomView.setVisible(true);
        clockView.setVisible(false);
        hoursView.setVisible(false);
        eventView.setVisible(false);
        amenityView.setVisible(false);
        //employeeView.setVisible(false);
        addEmployeeView.setVisible(false);
        this.validate();
    }//GEN-LAST:event_roomMenuActionPerformed

    private void hoursMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hoursMenuActionPerformed
        // TODO add your handling code here:
        hoursView.setVisible(true);
        clockView.setVisible(false);
        roomView.setVisible(false);
        clockView.setVisible(false);
        eventView.setVisible(false);
        amenityView.setVisible(false);
        //employeeView.setVisible(false);
        addEmployeeView.setVisible(false);
    }//GEN-LAST:event_hoursMenuActionPerformed

    private void quitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitMenuActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new welcomePage().setVisible(true);  
    }//GEN-LAST:event_quitMenuActionPerformed

    private void eventMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventMenuActionPerformed
        // TODO add your handling code here:
        eventView.setVisible(true);
        hoursView.setVisible(false);
        clockView.setVisible(false);
        roomView.setVisible(false);
        clockView.setVisible(false);
        amenityView.setVisible(false);
        //employeeView.setVisible(false);
        addEmployeeView.setVisible(false);
    }//GEN-LAST:event_eventMenuActionPerformed

    private void addEmployeeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeMenuActionPerformed
        addEmployeeView.setVisible(true);
        amenityView.setVisible(false);
        eventView.setVisible(false);
        hoursView.setVisible(false);
        clockView.setVisible(false);
        roomView.setVisible(false);
        clockView.setVisible(false);
        //employeeView.setVisible(false);
    }//GEN-LAST:event_addEmployeeMenuActionPerformed

    private void viewEmployeeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewEmployeeMenuActionPerformed
        //employeeView.setVisible(true);
        amenityView.setVisible(false);
        eventView.setVisible(false);
        hoursView.setVisible(false);
        clockView.setVisible(false);
        roomView.setVisible(false);
        clockView.setVisible(false);
        addEmployeeView.setVisible(false);
    }//GEN-LAST:event_viewEmployeeMenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ManagerPage("test@gmail.com").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu activityMenu;
    private javax.swing.JMenuItem addEmployeeMenu;
    private javax.swing.JMenuItem amenityMenu;
    private javax.swing.JMenuItem clockMenu;
    private javax.swing.JPanel dynamicPanel;
    private javax.swing.JMenuItem eventMenu;
    private javax.swing.JMenuItem hoursMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem quitMenu;
    private javax.swing.JMenuItem roomMenu;
    private javax.swing.JMenuItem settingMenu;
    private javax.swing.JMenuItem tourMenu;
    private javax.swing.JMenuItem viewEmployeeMenu;
    // End of variables declaration//GEN-END:variables
}
