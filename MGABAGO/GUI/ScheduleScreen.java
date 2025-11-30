package com.udj.gui;

public class ScheduleScreen extends javax.swing.JPanel {

private StudentProfileMain parentFrame;
    public ScheduleScreen(StudentProfileMain parentFrame) {
        this.parentFrame = parentFrame;
        initComponents();
        
        LogoutC1.setVisible(false);
        
        GradesC.addActionListener(evt -> parentFrame.showPanel("GRADES"));
        EvalC.addActionListener(evt -> parentFrame.showPanel("EVALUATION"));
        BackC.addActionListener(evt -> parentFrame.showMainProfile());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LogoutC = new javax.swing.JButton();
        BackC = new javax.swing.JButton();
        EvalC = new javax.swing.JButton();
        GradesC = new javax.swing.JButton();
        LogoutC1 = new javax.swing.JButton();
        BGPanel = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        BackC.setBorderPainted(false);
        BackC.setContentAreaFilled(false);
        BackC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(BackC, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 540, 150, 50));

        EvalC.setBorderPainted(false);
        EvalC.setContentAreaFilled(false);
        EvalC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(EvalC, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 540, 150, 50));

        GradesC.setBorderPainted(false);
        GradesC.setContentAreaFilled(false);
        GradesC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GradesC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GradesCMouseClicked(evt);
            }
        });
        add(GradesC, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 537, 150, 50));

        LogoutC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LogoutC1.png"))); // NOI18N
        LogoutC1.setBorderPainted(false);
        LogoutC1.setContentAreaFilled(false);
        LogoutC1.setMaximumSize(new java.awt.Dimension(438, 202));
        LogoutC1.setMinimumSize(new java.awt.Dimension(438, 202));
        add(LogoutC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 120, 40));

        BGPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ScheduleMain.png"))); // NOI18N
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

    private void GradesCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GradesCMouseClicked
        parentFrame.showPanel("GRADES");
    }//GEN-LAST:event_GradesCMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGPanel;
    private javax.swing.JButton BackC;
    private javax.swing.JButton EvalC;
    private javax.swing.JButton GradesC;
    private javax.swing.JButton LogoutC;
    private javax.swing.JButton LogoutC1;
    // End of variables declaration//GEN-END:variables
}
