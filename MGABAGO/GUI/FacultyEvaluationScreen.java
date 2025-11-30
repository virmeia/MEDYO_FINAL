package com.udj.gui;

import com.udj.logic.EvaluationManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.UIManager;

public class FacultyEvaluationScreen extends javax.swing.JPanel {
    private StudentProfileMain parentFrame;
    private String currentStudentID;
    private List<String[]> teacherData;
    public FacultyEvaluationScreen(StudentProfileMain parentFrame, String studentID) {
        this.parentFrame = parentFrame;
        this.currentStudentID = studentID;
        
        initComponents();
        
        UIManager.put("OptionPane.background", new java.awt.Color(242, 216, 255));
        UIManager.put("Panel.background", new java.awt.Color(242, 216, 255));
        UIManager.put("OptionPane.messageForeground", new java.awt.Color(61, 31, 92));
    
        setupTable();
        loadTeachersForEvaluation();
        
        LogoutC1.setVisible(false);
        SchedC.addActionListener(evt -> parentFrame.showPanel("SCHEDULE"));
        GradesC.addActionListener(evt -> parentFrame.showPanel("GRADES"));
        BackC.addActionListener(evt -> parentFrame.showMainProfile());
    }
    
    public FacultyEvaluationScreen(String studentID) {
        this.currentStudentID = studentID;
        initComponents();
        setupTable();
        loadTeachersForEvaluation();
    }
    
    private void setupTable() {
        javax.swing.table.JTableHeader header = TeacherTable.getTableHeader();
        header.setBackground(new java.awt.Color(242, 216, 255));
        header.setForeground(new java.awt.Color(61, 31, 92)); 
        header.setFont(new java.awt.Font("Product Sans", java.awt.Font.BOLD, 12));
        TeacherTable.setOpaque(false);
        TeacherTable.setBackground(new java.awt.Color(0, 0, 0, 0));
        Table.setOpaque(false);
        Table.getViewport().setOpaque(false);
        
        TeacherTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 1) { 
                    evaluateSelectedTeacher();
                }
            }
        });
    }
    
    private void loadTeachersForEvaluation() {
        DefaultTableModel model = (DefaultTableModel) TeacherTable.getModel();
        model.setRowCount(0);

        teacherData = EvaluationManager.getAllTeachersForEvaluation(currentStudentID); 
        teacherData.sort((a, b) -> a[3].compareToIgnoreCase(b[3]));

        for (String[] teacher : teacherData) {
            String status = "Pending";
            if (currentStudentID != null) {
                boolean hasEvaluated = EvaluationManager.hasStudentEvaluated(
                    currentStudentID, teacher[2]
                );
                status = hasEvaluated ? "Complete" : "Pending";
            }

            model.addRow(new Object[]{
                teacher[2],  
                teacher[3],  
                teacher[1], 
                status       
            });
        }
    }
    
    private void evaluateSelectedTeacher() {
        int selectedRow = TeacherTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, 
                "Please select a teacher to evaluate.",
                "No Selection", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        String[] selectedTeacher = teacherData.get(selectedRow);
        String teacherID = selectedTeacher[0]; 
        String teacherName = selectedTeacher[1]; 
        String courseCode = selectedTeacher[2];  
        String courseName = selectedTeacher[3];  

        String status = TeacherTable.getValueAt(selectedRow, 3).toString();

        if (status.equals("Complete")) {
            JOptionPane.showMessageDialog(this,
                "You have already evaluated this teacher.",
                "Already Completed",
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (currentStudentID == null) {
            JOptionPane.showMessageDialog(this,
                "Please log in to submit evaluations.",
                "Login Required",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        EvaluationTab dialog = new EvaluationTab(
            (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this),
            true,
            courseCode,
            courseName,
            teacherName, 
            currentStudentID
        );
        dialog.setVisible(true);

        loadTeachersForEvaluation();
    }
    
    public void refreshTable() {
        loadTeachersForEvaluation();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackC = new javax.swing.JButton();
        LogoutC = new javax.swing.JButton();
        LogoutC1 = new javax.swing.JButton();
        SchedC = new javax.swing.JButton();
        GradesC = new javax.swing.JButton();
        Table = new javax.swing.JScrollPane();
        TeacherTable = new javax.swing.JTable();
        BGPanel = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BackC.setBorderPainted(false);
        BackC.setContentAreaFilled(false);
        BackC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(BackC, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 540, 150, 50));

        LogoutC.setBorderPainted(false);
        LogoutC.setContentAreaFilled(false);
        LogoutC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogoutC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LogoutCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LogoutCMouseExited(evt);
            }
        });
        add(LogoutC, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, 110, 30));

        LogoutC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LogoutC1.png"))); // NOI18N
        LogoutC1.setBorderPainted(false);
        LogoutC1.setContentAreaFilled(false);
        LogoutC1.setMaximumSize(new java.awt.Dimension(438, 202));
        LogoutC1.setMinimumSize(new java.awt.Dimension(438, 202));
        add(LogoutC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 120, 40));

        SchedC.setBorderPainted(false);
        SchedC.setContentAreaFilled(false);
        SchedC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SchedC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SchedCMouseClicked(evt);
            }
        });
        add(SchedC, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 540, 150, 50));

        GradesC.setBorderPainted(false);
        GradesC.setContentAreaFilled(false);
        GradesC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GradesC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GradesCMouseClicked(evt);
            }
        });
        add(GradesC, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 537, 150, 50));

        Table.setBackground(new java.awt.Color(61, 31, 92));
        Table.setBorder(null);
        Table.setForeground(new java.awt.Color(249, 236, 255));

        TeacherTable.setBackground(new java.awt.Color(249, 236, 255));
        TeacherTable.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        TeacherTable.setForeground(new java.awt.Color(61, 31, 92));
        TeacherTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Course Code", "Course Name", "Instructor", "Status"
            }
        ));
        TeacherTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TeacherTable.setGridColor(new java.awt.Color(61, 31, 92));
        TeacherTable.setOpaque(false);
        TeacherTable.setShowGrid(true);
        Table.setViewportView(TeacherTable);
        if (TeacherTable.getColumnModel().getColumnCount() > 0) {
            TeacherTable.getColumnModel().getColumn(0).setMinWidth(100);
            TeacherTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            TeacherTable.getColumnModel().getColumn(0).setMaxWidth(100);
            TeacherTable.getColumnModel().getColumn(3).setMinWidth(100);
            TeacherTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            TeacherTable.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        add(Table, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 190, 900, 333));

        BGPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FacultyEvaluationMain.png"))); // NOI18N
        add(BGPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void GradesCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GradesCMouseClicked
        parentFrame.showPanel("GRADES");
    }//GEN-LAST:event_GradesCMouseClicked

    private void LogoutCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutCMouseClicked
        java.awt.Frame parentFrame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this);
        new Logout((javax.swing.JFrame) parentFrame).setVisible(true);
    }//GEN-LAST:event_LogoutCMouseClicked

    private void LogoutCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutCMouseEntered
        LogoutC1.setVisible(true);
    }//GEN-LAST:event_LogoutCMouseEntered

    private void LogoutCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutCMouseExited
        LogoutC1.setVisible(false);
    }//GEN-LAST:event_LogoutCMouseExited

    private void SchedCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SchedCMouseClicked
        parentFrame.showPanel("SCHEDULE");
    }//GEN-LAST:event_SchedCMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGPanel;
    private javax.swing.JButton BackC;
    private javax.swing.JButton GradesC;
    private javax.swing.JButton LogoutC;
    private javax.swing.JButton LogoutC1;
    private javax.swing.JButton SchedC;
    private javax.swing.JScrollPane Table;
    private javax.swing.JTable TeacherTable;
    // End of variables declaration//GEN-END:variables
}
