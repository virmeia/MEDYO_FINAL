package com.udj.gui;

import com.udj.gui.components.CustomScrollBarUI;
import com.udj.logic.FacultyManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

public class ViewFaculty extends javax.swing.JDialog {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ViewFaculty.class.getName());

    public ViewFaculty(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        styleTable();
        styleScrollBar();
        disableEditing();
        ViewFacultyScrollPane.setBorder(null);
        ViewFacultyScrollPane.getViewport().setOpaque(true);
        ViewFacultyScrollPane.getViewport().setBackground(Color.decode("#F4E8FA")); 
        ViewFacultyScrollPane.setBorder(BorderFactory.createEmptyBorder());
        Back1.setVisible(false);
    }
    
    private void disableEditing() {
     JTextField[] fields = {
            Name, FacultyID, Department, EmploymentType, College, Email, City
        };
        for (JTextField field : fields) {
            field.setEditable(false);                  
            field.setOpaque(false);                    
            field.setBorder(null);                     
            field.setFont(new Font("Arial", Font.BOLD, 12)); 
            field.setForeground(new Color(0x2E1448));    // UNIFORM COLOR (Dark Purple)
            field.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Standard pointer
        }
    }
    
    public void loadFacultyDetails(String id) {
        String[] data = FacultyManager.getFaculty(id);
        
        if (data != null) {
            // 0:ID, 1:Name, 2:Prog, 3:Dept, 4:Col, 5:Year, 6:Stat, 7:Email, 8:City
            
            FacultyID.setText(data[0]);
            Name.setText(data[1]);
            Department.setText(data[2]);
            EmploymentType.setText(data[3]);
            College.setText(data[4]);
            Email.setText(data[5]);
            City.setText(data[6]);
           
               
        } else {
            JOptionPane.showMessageDialog(this, "Faculty not found.");
            this.dispose();
        }
    }
    
    
    private void styleScrollBar() {
        JScrollBar verticalBar = ViewFacultyScrollPane.getVerticalScrollBar();
        verticalBar.setUI(new CustomScrollBarUI());
        verticalBar.setPreferredSize(new Dimension(5, Integer.MAX_VALUE));

        JScrollBar horizontalBar = ViewFacultyScrollPane.getHorizontalScrollBar();
        horizontalBar.setUI(new CustomScrollBarUI());
        horizontalBar.setPreferredSize(new Dimension(Integer.MAX_VALUE, 10));
    }
    
    private void styleTable() {
        ViewFacultyTable.getTableHeader().setOpaque(false);
        ViewFacultyTable.getTableHeader().setBackground(Color.decode("#8f6da0")); 
        ViewFacultyTable.getTableHeader().setForeground(Color.WHITE);
        ViewFacultyTable.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        ViewFacultyTable.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
        ViewFacultyTable.setBackground(Color.decode("#F4E8FA"));
        ViewFacultyTable.setForeground(Color.decode("#2E1448"));
        ViewFacultyTable.setFont(new java.awt.Font("Arial", Font.BOLD, 13));
        ViewFacultyTable.setSelectionBackground(Color.decode("#C8A8D8"));
        ViewFacultyTable.setSelectionForeground(Color.decode("#2E1448"));
        ViewFacultyTable.setShowGrid(true);
        ViewFacultyTable.setGridColor(new Color(140, 104, 160, 25)); 
        ViewFacultyTable.setIntercellSpacing(new java.awt.Dimension(5, 1));
        javax.swing.table.DefaultTableCellRenderer center = new javax.swing.table.DefaultTableCellRenderer();
        center.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        ViewFacultyTable.setDefaultRenderer(Object.class, center);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ViewFacultyScrollPane = new javax.swing.JScrollPane();
        ViewFacultyTable = new javax.swing.JTable();
        BGPanel = new javax.swing.JPanel();
        Name = new javax.swing.JTextField();
        FacultyID = new javax.swing.JTextField();
        Department = new javax.swing.JTextField();
        EmploymentType = new javax.swing.JTextField();
        College = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        City = new javax.swing.JTextField();
        Back = new javax.swing.JButton();
        Back1 = new javax.swing.JButton();
        ViewFacultyBG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ViewFacultyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Course Code", "Course Name", "Program", "Units", "Schedule"
            }
        ));
        ViewFacultyScrollPane.setViewportView(ViewFacultyTable);

        getContentPane().add(ViewFacultyScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 340, 900, 222));

        BGPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Name.setBorder(null);
        Name.addActionListener(this::NameActionPerformed);
        BGPanel.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 138, 284, 17));

        FacultyID.setBorder(null);
        FacultyID.addActionListener(this::FacultyIDActionPerformed);
        BGPanel.add(FacultyID, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 163, 284, 17));

        Department.setBorder(null);
        BGPanel.add(Department, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 189, 284, 17));

        EmploymentType.setBorder(null);
        BGPanel.add(EmploymentType, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 215, 284, 17));

        College.setBorder(null);
        BGPanel.add(College, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, 137, 284, 17));

        Email.setBorder(null);
        Email.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        Email.addActionListener(this::EmailActionPerformed);
        BGPanel.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, 162, 284, 18));

        City.setBorder(null);
        BGPanel.add(City, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, 189, 284, 17));

        Back.setBorderPainted(false);
        Back.setContentAreaFilled(false);
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackMouseExited(evt);
            }
        });
        BGPanel.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 11, 40, 40));

        Back1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackIcon.png"))); // NOI18N
        Back1.setBorderPainted(false);
        Back1.setContentAreaFilled(false);
        Back1.addActionListener(this::Back1ActionPerformed);
        BGPanel.add(Back1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 11, 40, 40));

        ViewFacultyBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ViewFaculty.png"))); // NOI18N
        BGPanel.add(ViewFacultyBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(BGPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FacultyIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacultyIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FacultyIDActionPerformed

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void Back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Back1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Back1ActionPerformed

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        Back.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackMouseClicked

    private void BackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseEntered
        Back.setVisible(true);
    }//GEN-LAST:event_BackMouseEntered

    private void BackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseExited
        Back.setVisible(false);
    }//GEN-LAST:event_BackMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BGPanel;
    private javax.swing.JButton Back;
    private javax.swing.JButton Back1;
    private javax.swing.JTextField City;
    private javax.swing.JTextField College;
    private javax.swing.JTextField Department;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField EmploymentType;
    private javax.swing.JTextField FacultyID;
    private javax.swing.JTextField Name;
    private javax.swing.JLabel ViewFacultyBG;
    private javax.swing.JScrollPane ViewFacultyScrollPane;
    private javax.swing.JTable ViewFacultyTable;
    // End of variables declaration//GEN-END:variables
}
