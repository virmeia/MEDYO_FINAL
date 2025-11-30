package com.udj.gui;

public class StatusEvaluationPanel extends javax.swing.JPanel {

private TeacherDB parentFrame;
    
    public StatusEvaluationPanel(TeacherDB parentFrame) {  
        this.parentFrame = parentFrame;
        initComponents();
        SchedC.addActionListener(evt -> parentFrame.showPanel("SCHEDULE"));
        ViewC.addActionListener(evt -> parentFrame.showPanel("VIEW"));
        GradeC.addActionListener(evt -> parentFrame.showPanel("GRADES"));
        SchedC1.setVisible(false);
        ViewC1.setVisible(false);
        GradeC1.setVisible(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ViewC = new javax.swing.JButton();
        SchedC = new javax.swing.JButton();
        GradeC = new javax.swing.JButton();
        ViewC1 = new javax.swing.JButton();
        GradeC1 = new javax.swing.JButton();
        SchedC1 = new javax.swing.JButton();
        BGPanel = new javax.swing.JLabel();

        setToolTipText("");
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        add(GradeC, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 450, 180, 90));

        ViewC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ViewButt.png"))); // NOI18N
        ViewC1.setBorderPainted(false);
        ViewC1.setContentAreaFilled(false);
        ViewC1.setRequestFocusEnabled(false);
        add(ViewC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 450, 180, 90));

        GradeC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/StudButt.png"))); // NOI18N
        GradeC1.setBorderPainted(false);
        GradeC1.setContentAreaFilled(false);
        GradeC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GradeC1ActionPerformed(evt);
            }
        });
        add(GradeC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 450, 180, 90));

        SchedC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SchedButt.png"))); // NOI18N
        SchedC1.setBorderPainted(false);
        SchedC1.setContentAreaFilled(false);
        add(SchedC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 180, 90));

        BGPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/StatBG.png"))); // NOI18N
        add(BGPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void GradeC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GradeC1ActionPerformed
       
    }//GEN-LAST:event_GradeC1ActionPerformed

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

    private void GradeCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GradeCActionPerformed
       
    }//GEN-LAST:event_GradeCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGPanel;
    private javax.swing.JButton GradeC;
    private javax.swing.JButton GradeC1;
    private javax.swing.JButton SchedC;
    private javax.swing.JButton SchedC1;
    private javax.swing.JButton ViewC;
    private javax.swing.JButton ViewC1;
    // End of variables declaration//GEN-END:variables

}
