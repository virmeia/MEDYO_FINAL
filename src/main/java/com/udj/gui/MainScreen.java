package com.udj.gui;

public class MainScreen extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainScreen.class.getName());

    public MainScreen() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGPanel = new com.udj.gui.components.Background();
        StudentC = new javax.swing.JLabel();
        TeacherC = new javax.swing.JLabel();
        AdminC = new javax.swing.JLabel();
        AboutUDJC = new javax.swing.JLabel();
        BGLabel = new javax.swing.JLabel();
        AdminC1 = new com.udj.gui.components.ButtonLabelBG();
        StudentC1 = new com.udj.gui.components.ButtonLabelBG();
        TeacherC1 = new com.udj.gui.components.ButtonLabelBG();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BGPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        StudentC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        StudentC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudentCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                StudentCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                StudentCMouseExited(evt);
            }
        });
        BGPanel.add(StudentC, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 205, 230, 60));

        TeacherC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TeacherC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TeacherCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TeacherCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TeacherCMouseExited(evt);
            }
        });
        BGPanel.add(TeacherC, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 230, 60));

        AdminC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AdminC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdminCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AdminCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AdminCMouseExited(evt);
            }
        });
        BGPanel.add(AdminC, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 355, 230, 60));

        AboutUDJC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AboutUDJC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AboutUDJCMouseClicked(evt);
            }
        });
        BGPanel.add(AboutUDJC, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 140, 30));

        BGLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MainScreen.png"))); // NOI18N
        BGLabel.setMaximumSize(new java.awt.Dimension(2000, 1200));
        BGPanel.add(BGLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        AdminC1.setBackground(new java.awt.Color(255, 255, 255));
        AdminC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AdminC1.png"))); // NOI18N
        AdminC1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BGPanel.add(AdminC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 353, -1, 68));

        StudentC1.setBackground(new java.awt.Color(255, 255, 255));
        StudentC1.setForeground(new java.awt.Color(255, 255, 255));
        StudentC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/StudentC1.png"))); // NOI18N
        StudentC1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BGPanel.add(StudentC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 197, 320, 80));

        TeacherC1.setBackground(new java.awt.Color(255, 255, 255));
        TeacherC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TeacherC1.png"))); // NOI18N
        TeacherC1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BGPanel.add(TeacherC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 273, 330, 80));

        getContentPane().add(BGPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void StudentCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentCMouseClicked
        StudentC1.setOpaque(true);
        java.awt.EventQueue.invokeLater(() -> new StudentLogin(this).setVisible(true));
    }//GEN-LAST:event_StudentCMouseClicked

    private void StudentCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentCMouseEntered
        StudentC1.setOpaque(true);
        StudentC1.repaint();
    }//GEN-LAST:event_StudentCMouseEntered

    private void StudentCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentCMouseExited
        StudentC1.setOpaque(false);
        StudentC1.getParent().repaint();
    }//GEN-LAST:event_StudentCMouseExited

    private void TeacherCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TeacherCMouseClicked
        TeacherC1.setOpaque(true);
        java.awt.EventQueue.invokeLater(() -> new TeacherLogin(this).setVisible(true));
    }//GEN-LAST:event_TeacherCMouseClicked

    private void TeacherCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TeacherCMouseEntered
        TeacherC1.setOpaque(true);
        TeacherC1.repaint();
    }//GEN-LAST:event_TeacherCMouseEntered

    private void TeacherCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TeacherCMouseExited
        TeacherC1.setOpaque(false);
        TeacherC1.getParent().repaint();
    }//GEN-LAST:event_TeacherCMouseExited

    private void AdminCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminCMouseClicked
        AdminC1.setOpaque(true);
        java.awt.EventQueue.invokeLater(() -> new AdminLogin(this).setVisible(true));
    }//GEN-LAST:event_AdminCMouseClicked

    private void AdminCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminCMouseEntered
        AdminC1.setOpaque(true);
        AdminC1.repaint();
    }//GEN-LAST:event_AdminCMouseEntered

    private void AdminCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminCMouseExited
        AdminC1.setOpaque(false);
        AdminC1.getParent().repaint();
    }//GEN-LAST:event_AdminCMouseExited

    private void AboutUDJCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AboutUDJCMouseClicked
        java.awt.EventQueue.invokeLater(() -> new AboutUDJ().setVisible(true));
    }//GEN-LAST:event_AboutUDJCMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AboutUDJC;
    private javax.swing.JLabel AdminC;
    private javax.swing.JLabel AdminC1;
    private javax.swing.JLabel BGLabel;
    private javax.swing.JPanel BGPanel;
    private javax.swing.JLabel StudentC;
    private javax.swing.JLabel StudentC1;
    private javax.swing.JLabel TeacherC;
    private javax.swing.JLabel TeacherC1;
    // End of variables declaration//GEN-END:variables
}
