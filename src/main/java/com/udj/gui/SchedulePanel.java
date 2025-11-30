
package com.udj.gui;


public class SchedulePanel extends javax.swing.JPanel {

private TeacherDB parentFrame;
   
    public SchedulePanel(TeacherDB parentFrame) {
       
        this.parentFrame = parentFrame;
        initComponents();

        ViewC.addActionListener(evt -> parentFrame.showPanel("SCHEDULE"));
        EvalC.addActionListener(evt -> parentFrame.showPanel("STATUS"));
        GradeC.addActionListener(evt -> parentFrame.showPanel("GRADES"));
        
        ViewC1.setVisible(false);
        EvalC1.setVisible(false);
        GradeC1.setVisible(false);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ViewC = new javax.swing.JButton();
        EvalC = new javax.swing.JButton();
        GradeC = new javax.swing.JButton();
        GradeC1 = new javax.swing.JButton();
        EvalC1 = new javax.swing.JButton();
        ViewC1 = new javax.swing.JButton();
        BGPanel = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 640, 330));

        ViewC.setBorderPainted(false);
        ViewC.setContentAreaFilled(false);
        ViewC.setFocusPainted(false);
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

        EvalC.setBorderPainted(false);
        EvalC.setContentAreaFilled(false);
        EvalC.setFocusPainted(false);
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
        GradeC.setFocusPainted(false);
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

        GradeC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/StudButt.png"))); // NOI18N
        GradeC1.setBorderPainted(false);
        GradeC1.setContentAreaFilled(false);
        GradeC1.setFocusPainted(false);
        add(GradeC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 453, 180, 90));

        EvalC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/StatButt.png"))); // NOI18N
        EvalC1.setBorderPainted(false);
        EvalC1.setContentAreaFilled(false);
        EvalC1.setFocusPainted(false);
        add(EvalC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 180, 90));

        ViewC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ViewButt.png"))); // NOI18N
        ViewC1.setBorderPainted(false);
        ViewC1.setContentAreaFilled(false);
        ViewC1.setFocusPainted(false);
        add(ViewC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 450, 180, 90));

        BGPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SchedBG.png"))); // NOI18N
        add(BGPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));
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

    private void ViewCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewCMouseClicked
        parentFrame.showPanel("VIEW");
        
        ViewC1.setVisible(true);
        BGPanel.repaint();
    }//GEN-LAST:event_ViewCMouseClicked

    private void ViewCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewCMouseEntered
        ViewC1.setVisible(true);
    }//GEN-LAST:event_ViewCMouseEntered

    private void ViewCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewCMouseExited
        ViewC1.setVisible(false);
    }//GEN-LAST:event_ViewCMouseExited

    private void ViewCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewCActionPerformed
        
    }//GEN-LAST:event_ViewCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGPanel;
    private javax.swing.JButton EvalC;
    private javax.swing.JButton EvalC1;
    private javax.swing.JButton GradeC;
    private javax.swing.JButton GradeC1;
    private javax.swing.JButton ViewC;
    private javax.swing.JButton ViewC1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
