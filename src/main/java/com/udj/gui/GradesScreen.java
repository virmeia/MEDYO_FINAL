package com.udj.gui;

public class GradesScreen extends javax.swing.JPanel {
private StudentProfileMain parentFrame;
    public GradesScreen(StudentProfileMain parentFrame) {
        this.parentFrame = parentFrame;
        initComponents();
        
        LogoutC1.setVisible(false);
        
        SchedC.addActionListener(evt -> parentFrame.showPanel("SCHEDULE"));
        EvalC.addActionListener(evt -> parentFrame.showPanel("EVALUATION"));
        BackC.addActionListener(evt -> parentFrame.showMainProfile());
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SchedC = new javax.swing.JButton();
        EvalC = new javax.swing.JButton();
        LogoutC = new javax.swing.JButton();
        LogoutC1 = new javax.swing.JButton();
        BackC = new javax.swing.JButton();
        BGPanel = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SchedC.setBorderPainted(false);
        SchedC.setContentAreaFilled(false);
        SchedC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SchedC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SchedCMouseClicked(evt);
            }
        });
        add(SchedC, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 540, 150, 50));

        EvalC.setBorderPainted(false);
        EvalC.setContentAreaFilled(false);
        EvalC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EvalC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EvalCMouseClicked(evt);
            }
        });
        add(EvalC, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 540, 150, 50));

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

        BackC.setBorderPainted(false);
        BackC.setContentAreaFilled(false);
        BackC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(BackC, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 540, 150, 50));

        BGPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GradesMain.png"))); // NOI18N
        add(BGPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));
    }// </editor-fold>//GEN-END:initComponents

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

    private void EvalCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvalCMouseClicked
        parentFrame.showPanel("EVALUATION");
    }//GEN-LAST:event_EvalCMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGPanel;
    private javax.swing.JButton BackC;
    private javax.swing.JButton EvalC;
    private javax.swing.JButton LogoutC;
    private javax.swing.JButton LogoutC1;
    private javax.swing.JButton SchedC;
    // End of variables declaration//GEN-END:variables
}
