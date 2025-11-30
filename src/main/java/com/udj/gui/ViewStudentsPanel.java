package com.udj.gui;

import com.udj.gui.components.CustomScrollBarUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JScrollBar;

public class ViewStudentsPanel extends javax.swing.JPanel {

private TeacherDB parentFrame;

    public ViewStudentsPanel(TeacherDB parentFrame) {
        
        this.parentFrame = parentFrame;
        initComponents();
        styleTable();
        styleScrollBar();
        ClassListScrollPane.setBorder(null);
        ClassListScrollPane.getViewport().setOpaque(true);
        ClassListScrollPane.getViewport().setBackground(Color.decode("#F4E8FA")); 
        ClassListScrollPane.setBorder(BorderFactory.createEmptyBorder());
        SchedC.addActionListener(evt -> parentFrame.showPanel("SCHEDULE"));
        EvalC.addActionListener(evt -> parentFrame.showPanel("STATUS"));
        GradeC.addActionListener(evt -> parentFrame.showPanel("GRADES"));
        
        SchedC1.setVisible(false);
        EvalC1.setVisible(false);
        GradeC1.setVisible(false);
    }

     private void styleScrollBar() {
        JScrollBar verticalBar = ClassListScrollPane.getVerticalScrollBar();
        verticalBar.setUI(new CustomScrollBarUI());
        verticalBar.setPreferredSize(new Dimension(5, Integer.MAX_VALUE));

        JScrollBar horizontalBar = ClassListScrollPane.getHorizontalScrollBar();
        horizontalBar.setUI(new CustomScrollBarUI());
        horizontalBar.setPreferredSize(new Dimension(Integer.MAX_VALUE, 10));
    }
    
    private void styleTable() {
        ClassList.getTableHeader().setOpaque(false);
        ClassList.getTableHeader().setBackground(Color.decode("#8f6da0")); 
        ClassList.getTableHeader().setForeground(Color.WHITE);
        ClassList.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        ClassList.setBackground(Color.decode("#F4E8FA"));
        ClassList.setForeground(Color.decode("#2E1448"));
        ClassList.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        ClassList.setSelectionBackground(Color.decode("#C8A8D8"));
        ClassList.setSelectionForeground(Color.decode("#2E1448"));
        ClassList.setShowGrid(true);
        ClassList.setGridColor(new Color(140, 104, 160, 25)); 
        ClassList.setIntercellSpacing(new java.awt.Dimension(4, 1));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ClassListScrollPane = new javax.swing.JScrollPane();
        ClassList = new javax.swing.JTable();
        EvalC = new javax.swing.JButton();
        GradeC = new javax.swing.JButton();
        SchedC = new javax.swing.JButton();
        EvalC1 = new javax.swing.JButton();
        SchedC1 = new javax.swing.JButton();
        GradeC1 = new javax.swing.JButton();
        BGPanel = new com.udj.gui.components.ButtonLabelBG();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ClassList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Student Name", "Program", "Year Level", "Department", "Status"
            }
        ));
        ClassListScrollPane.setViewportView(ClassList);
        if (ClassList.getColumnModel().getColumnCount() > 0) {
            ClassList.getColumnModel().getColumn(0).setResizable(false);
            ClassList.getColumnModel().getColumn(1).setResizable(false);
            ClassList.getColumnModel().getColumn(2).setResizable(false);
            ClassList.getColumnModel().getColumn(3).setResizable(false);
            ClassList.getColumnModel().getColumn(4).setResizable(false);
            ClassList.getColumnModel().getColumn(5).setResizable(false);
        }

        add(ClassListScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 102, 860, 335));

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

        GradeC.setBorderPainted(false);
        GradeC.setContentAreaFilled(false);
        GradeC.setRequestFocusEnabled(false);
        GradeC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GradeCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GradeCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GradeCMouseExited(evt);
            }
        });
        GradeC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GradeCActionPerformed(evt);
            }
        });
        add(GradeC, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 453, 180, 90));

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

        EvalC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/StatButt.png"))); // NOI18N
        EvalC1.setBorderPainted(false);
        EvalC1.setContentAreaFilled(false);
        EvalC1.setRequestFocusEnabled(false);
        add(EvalC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 180, 90));

        SchedC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SchedButt.png"))); // NOI18N
        SchedC1.setBorderPainted(false);
        SchedC1.setContentAreaFilled(false);
        SchedC1.setRequestFocusEnabled(false);
        add(SchedC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 180, 90));

        GradeC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/StudButt.png"))); // NOI18N
        GradeC1.setBorderPainted(false);
        GradeC1.setContentAreaFilled(false);
        GradeC1.setRequestFocusEnabled(false);
        add(GradeC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 453, 180, 90));

        BGPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ViewBG.png"))); // NOI18N
        add(BGPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void GradeCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GradeCActionPerformed
       
    }//GEN-LAST:event_GradeCActionPerformed

    private void GradeCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GradeCMouseClicked
        parentFrame.showPanel("GRADES");
        
        GradeC1.setVisible(true);
        BGPanel.repaint();
    }//GEN-LAST:event_GradeCMouseClicked

    private void GradeCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GradeCMouseEntered
        GradeC1.setVisible(true);
        
    }//GEN-LAST:event_GradeCMouseEntered

    private void GradeCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GradeCMouseExited
        GradeC1.setVisible(false);
    }//GEN-LAST:event_GradeCMouseExited

    private void SchedCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SchedCMouseClicked
        parentFrame.showPanel("SCHEDULE");
        
        SchedC1.setVisible(true);
        BGPanel.repaint();
    }//GEN-LAST:event_SchedCMouseClicked

    private void SchedCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SchedCMouseEntered
        SchedC1.setVisible(true);
    }//GEN-LAST:event_SchedCMouseEntered

    private void SchedCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SchedCMouseExited
        SchedC1.setVisible(false);
    }//GEN-LAST:event_SchedCMouseExited

    private void SchedCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SchedCActionPerformed
        
    }//GEN-LAST:event_SchedCActionPerformed

    private void EvalCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvalCMouseClicked
        parentFrame.showPanel("STATUS");
        
        EvalC1.setVisible(true);
        BGPanel.repaint();
    }//GEN-LAST:event_EvalCMouseClicked

    private void EvalCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvalCMouseEntered
        EvalC1.setVisible(true);
    }//GEN-LAST:event_EvalCMouseEntered

    private void EvalCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvalCMouseExited
        EvalC1.setVisible(false);
    }//GEN-LAST:event_EvalCMouseExited

    private void EvalCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EvalCActionPerformed
        
    }//GEN-LAST:event_EvalCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGPanel;
    private javax.swing.JTable ClassList;
    private javax.swing.JScrollPane ClassListScrollPane;
    private javax.swing.JButton EvalC;
    private javax.swing.JButton EvalC1;
    private javax.swing.JButton GradeC;
    private javax.swing.JButton GradeC1;
    private javax.swing.JButton SchedC;
    private javax.swing.JButton SchedC1;
    // End of variables declaration//GEN-END:variables
}
