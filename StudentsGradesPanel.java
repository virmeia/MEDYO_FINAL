package com.udj.gui;

import com.udj.gui.components.CustomComboBox;
import com.udj.gui.components.CustomScrollBarUI;
import com.udj.logic.StudentGrade;
import com.udj.logic.StudentManager;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class StudentsGradesPanel extends javax.swing.JPanel{ 

private final TeacherDB parentFrame;

    public StudentsGradesPanel(TeacherDB parentFrame) {
        this.parentFrame = parentFrame;
        initComponents();
        
        loadTableData();
        loadStudentData();
        styleTable();
        styleScrollBar();
        StudGradesScrollPane.setBorder(null);
        StudGradesScrollPane.getViewport().setOpaque(true);
        StudGradesScrollPane.getViewport().setBackground(Color.decode("#F4E8FA")); 
        StudGradesScrollPane.setBorder(BorderFactory.createEmptyBorder());
        CustomComboBox.applyStyle(CB);
        CB.setBorder(new LineBorder(new Color(0x8750A6), 1, true));
        SchedC.addActionListener(evt -> parentFrame.showPanel("SCHEDULE"));
        EvalC.addActionListener(evt -> parentFrame.showPanel("STATUS"));
        ViewC.addActionListener(evt -> parentFrame.showPanel("VIEW"));
        SchedC1.setVisible(false);
        EvalC1.setVisible(false);
        ViewC1.setVisible(false);        
    }
    
      private void styleScrollBar() {
        JScrollBar verticalBar = StudGradesScrollPane.getVerticalScrollBar();
        verticalBar.setUI(new CustomScrollBarUI());
        verticalBar.setPreferredSize(new Dimension(5, Integer.MAX_VALUE));

        JScrollBar horizontalBar = StudGradesScrollPane.getHorizontalScrollBar();
        horizontalBar.setUI(new CustomScrollBarUI());
        horizontalBar.setPreferredSize(new Dimension(Integer.MAX_VALUE, 10));
    }
      
    private void styleTable() {
        StudGradesTable.getTableHeader().setOpaque(false);
        StudGradesTable.getTableHeader().setBackground(Color.decode("#8f6da0")); 
        StudGradesTable.getTableHeader().setForeground(Color.WHITE);
        StudGradesTable.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 13));
        StudGradesTable.setBackground(Color.decode("#F4E8FA"));
        StudGradesTable.setForeground(Color.decode("#2E1448"));
        StudGradesTable.setFont(new java.awt.Font("Arial", Font.PLAIN, 13));
        StudGradesTable.setSelectionBackground(Color.decode("#C8A8D8"));
        StudGradesTable.setSelectionForeground(Color.decode("#2E1448"));
        StudGradesTable.setShowGrid(true);
        StudGradesTable.setGridColor(new Color(140, 104, 160, 25)); 
        StudGradesTable.setIntercellSpacing(new java.awt.Dimension(4, 1));
    }
    
     private void loadStudentData() {
        DefaultTableModel model = (DefaultTableModel) StudGradesTable.getModel();
        model.setRowCount(0); 
        
        java.util.List<String[]> students = StudentManager.getAllStudents();
        
        for (String[] student : students) {
            String id = student[0];
            String name = student[1];
            String studentCollege = student[4];
            
                Object[] row = {
                    student[0], 
                    student[1], 
                    student[2], 
                    student[5], 
                    student[3], 
                    student[6], 
                    "⋮"         
                };
                model.addRow(row);
            
        }   
    }
    
    private void loadTableData() {

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StudGradesScrollPane = new javax.swing.JScrollPane();
        StudGradesTable = new javax.swing.JTable();
        SubmitC = new javax.swing.JButton();
        SaveButtonC = new javax.swing.JButton();
        CB = new javax.swing.JComboBox<>();
        SchedC = new javax.swing.JButton();
        EvalC = new javax.swing.JButton();
        ViewC = new javax.swing.JButton();
        EvalC1 = new javax.swing.JButton();
        ViewC1 = new javax.swing.JButton();
        SchedC1 = new javax.swing.JButton();
        BGPanel = new javax.swing.JLabel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        StudGradesScrollPane.setBorder(null);
        StudGradesScrollPane.setOpaque(false);

        StudGradesTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        StudGradesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Prelims Grade", "Midterms Grade", "Finals Grade", "Final Grade", "Status", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        StudGradesTable.setPreferredSize(new java.awt.Dimension(70, 110));
        StudGradesScrollPane.setViewportView(StudGradesTable);
        if (StudGradesTable.getColumnModel().getColumnCount() > 0) {
            StudGradesTable.getColumnModel().getColumn(0).setResizable(false);
            StudGradesTable.getColumnModel().getColumn(1).setResizable(false);
            StudGradesTable.getColumnModel().getColumn(2).setResizable(false);
            StudGradesTable.getColumnModel().getColumn(3).setResizable(false);
            StudGradesTable.getColumnModel().getColumn(4).setResizable(false);
            StudGradesTable.getColumnModel().getColumn(5).setResizable(false);
            StudGradesTable.getColumnModel().getColumn(6).setResizable(false);
            StudGradesTable.getColumnModel().getColumn(7).setResizable(false);
        }

        add(StudGradesScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 861, 328));

        SubmitC.setBorderPainted(false);
        SubmitC.setContentAreaFilled(false);
        SubmitC.setFocusPainted(false);
        SubmitC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SubmitCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SubmitCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SubmitCMouseExited(evt);
            }
        });
        SubmitC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitCActionPerformed(evt);
            }
        });
        add(SubmitC, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 80, 80, 20));

        SaveButtonC.setBorderPainted(false);
        SaveButtonC.setContentAreaFilled(false);
        SaveButtonC.setFocusPainted(false);
        SaveButtonC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveButtonCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SaveButtonCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SaveButtonCMouseExited(evt);
            }
        });
        SaveButtonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonCActionPerformed(evt);
            }
        });
        add(SaveButtonC, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, 70, 20));

        CB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Subject", "subj1", "subj2", "subj3", "subj4", "subj5" }));
        CB.setToolTipText("");
        add(CB, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 120, -1));

        SchedC.setBorderPainted(false);
        SchedC.setContentAreaFilled(false);
        SchedC.setRequestFocusEnabled(false);
        SchedC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SchedCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SchedCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SchedCMouseExited(evt);
            }
        });
        SchedC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SchedCActionPerformed(evt);
            }
        });
        add(SchedC, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 180, 90));

        EvalC.setBorderPainted(false);
        EvalC.setContentAreaFilled(false);
        EvalC.setRequestFocusEnabled(false);
        EvalC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EvalCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EvalCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EvalCMouseExited(evt);
            }
        });
        EvalC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EvalCActionPerformed(evt);
            }
        });
        add(EvalC, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 180, 90));

        ViewC.setBorderPainted(false);
        ViewC.setContentAreaFilled(false);
        ViewC.setRequestFocusEnabled(false);
        ViewC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ViewCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ViewCMouseExited(evt);
            }
        });
        ViewC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewCActionPerformed(evt);
            }
        });
        add(ViewC, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 450, 180, 90));

        EvalC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/StatButt.png"))); // NOI18N
        EvalC1.setBorderPainted(false);
        EvalC1.setContentAreaFilled(false);
        EvalC1.setRequestFocusEnabled(false);
        add(EvalC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 450, 180, 90));

        ViewC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ViewButt.png"))); // NOI18N
        ViewC1.setBorderPainted(false);
        ViewC1.setContentAreaFilled(false);
        add(ViewC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 450, 180, 90));

        SchedC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SchedButt.png"))); // NOI18N
        SchedC1.setBorderPainted(false);
        SchedC1.setContentAreaFilled(false);
        add(SchedC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 180, 90));

        BGPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SGBG.png"))); // NOI18N
        add(BGPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void ViewCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewCActionPerformed
       
    }//GEN-LAST:event_ViewCActionPerformed

    private void ViewCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewCMouseClicked
        parentFrame.showPanel("VIEW");
        
        ViewC1.setVisible(true);
        BGPanel.repaint();
    }//GEN-LAST:event_ViewCMouseClicked

    private void ViewCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewCMouseEntered
        ViewC1.setVisible(true);
        ViewC1.repaint();
        BGPanel.repaint();
    }//GEN-LAST:event_ViewCMouseEntered

    private void ViewCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewCMouseExited
        
        ViewC1.setVisible(false);
    }//GEN-LAST:event_ViewCMouseExited

    private void EvalCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvalCMouseClicked
        parentFrame.showPanel("STATUS");

        EvalC1.setVisible(true);
        BGPanel.repaint();
    }//GEN-LAST:event_EvalCMouseClicked

    private void EvalCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvalCMouseEntered
        EvalC1.setVisible(true);
        EvalC1.repaint();
        BGPanel.repaint();
    }//GEN-LAST:event_EvalCMouseEntered

    private void EvalCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvalCMouseExited
        EvalC1.setVisible(false);
    }//GEN-LAST:event_EvalCMouseExited

    private void EvalCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EvalCActionPerformed
      
    }//GEN-LAST:event_EvalCActionPerformed

    private void SchedCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SchedCMouseClicked
        parentFrame.showPanel("SCHEDULE");      
        SchedC1.setVisible(true);
        BGPanel.repaint();
    }//GEN-LAST:event_SchedCMouseClicked

    private void SchedCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SchedCMouseEntered
        SchedC1.setVisible(true);
        SchedC1.repaint();
        BGPanel.repaint();
    }//GEN-LAST:event_SchedCMouseEntered

    private void SchedCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SchedCMouseExited
        
        SchedC1.setVisible(false);
    }//GEN-LAST:event_SchedCMouseExited

    private void SchedCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SchedCActionPerformed
     
    }//GEN-LAST:event_SchedCActionPerformed

    private void SaveButtonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonCActionPerformed

    }//GEN-LAST:event_SaveButtonCActionPerformed

    private void SaveButtonCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveButtonCMouseExited
       
    }//GEN-LAST:event_SaveButtonCMouseExited

    private void SaveButtonCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveButtonCMouseEntered
       
    }//GEN-LAST:event_SaveButtonCMouseEntered

    private void SaveButtonCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveButtonCMouseClicked

    }//GEN-LAST:event_SaveButtonCMouseClicked

    private void SubmitCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmitCMouseClicked
       
    }//GEN-LAST:event_SubmitCMouseClicked

    private void SubmitCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmitCMouseEntered
   
    }//GEN-LAST:event_SubmitCMouseEntered

    private void SubmitCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmitCMouseExited

    }//GEN-LAST:event_SubmitCMouseExited

    private void SubmitCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitCActionPerformed
    
    }//GEN-LAST:event_SubmitCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGPanel;
    private javax.swing.JComboBox<String> CB;
    private javax.swing.JButton EvalC;
    private javax.swing.JButton EvalC1;
    private javax.swing.JButton SaveButtonC;
    private javax.swing.JButton SchedC;
    private javax.swing.JButton SchedC1;
    private javax.swing.JScrollPane StudGradesScrollPane;
    private javax.swing.JTable StudGradesTable;
    private javax.swing.JButton SubmitC;
    private javax.swing.JButton ViewC;
    private javax.swing.JButton ViewC1;
    // End of variables declaration//GEN-END:variables
}

    
