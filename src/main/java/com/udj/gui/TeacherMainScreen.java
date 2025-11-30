package com.udj.gui;

public class TeacherMainScreen extends javax.swing.JFrame {

    public TeacherMainScreen() {
        initComponents();
        
        MenuC1.setVisible(false);  
        MenuC.setFocusPainted(false);
        MenuC.setBorderPainted(false);
        EditC1.setVisible(false);
        EditC.setFocusPainted(false);
        EditC.setBorderPainted(false);
        LogoutC1.setVisible(false); 
        LogoutC.setFocusPainted(false);
        LogoutC.setBorderPainted(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGPanel = new javax.swing.JPanel();
        EditC = new javax.swing.JButton();
        MenuC = new javax.swing.JButton();
        LogoutC = new javax.swing.JButton();
        EditC1 = new javax.swing.JButton();
        MenuC1 = new javax.swing.JButton();
        LogoutC1 = new javax.swing.JButton();
        TPBLabel = new com.udj.gui.components.ButtonLabelBG();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BGPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EditC.setBorderPainted(false);
        EditC.setContentAreaFilled(false);
        EditC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EditC.setFocusPainted(false);
        EditC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EditCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EditCMouseExited(evt);
            }
        });
        BGPanel.add(EditC, new org.netbeans.lib.awtextra.AbsoluteConstraints(764, 330, 103, 30));

        MenuC.setBorderPainted(false);
        MenuC.setContentAreaFilled(false);
        MenuC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuC.setFocusPainted(false);
        MenuC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuCMouseExited(evt);
            }
        });
        BGPanel.add(MenuC, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 450, 180, 90));

        LogoutC.setBorderPainted(false);
        LogoutC.setContentAreaFilled(false);
        LogoutC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogoutC.setFocusPainted(false);
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
        BGPanel.add(LogoutC, new org.netbeans.lib.awtextra.AbsoluteConstraints(855, 13, 105, 30));

        EditC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EditProfileButton.png"))); // NOI18N
        EditC1.setBorderPainted(false);
        EditC1.setContentAreaFilled(false);
        BGPanel.add(EditC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, 110, 70));

        MenuC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BttnMenu.png"))); // NOI18N
        MenuC1.setBorderPainted(false);
        MenuC1.setContentAreaFilled(false);
        BGPanel.add(MenuC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 430, 180, 130));

        LogoutC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LogOutButton.png"))); // NOI18N
        LogoutC1.setBorderPainted(false);
        LogoutC1.setContentAreaFilled(false);
        BGPanel.add(LogoutC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(812, 10, 190, 40));

        TPBLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TeacherProfile.png"))); // NOI18N
        BGPanel.add(TPBLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        getContentPane().add(BGPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenuCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuCMouseClicked
        TeacherDB teacherMenu = new TeacherDB();
        teacherMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MenuCMouseClicked

    private void MenuCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuCMouseEntered
        MenuC1.setVisible(true);
        MenuC1.repaint();
        BGPanel.repaint(); 
    }//GEN-LAST:event_MenuCMouseEntered

    private void MenuCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuCMouseExited
        MenuC1.setVisible(false);
        BGPanel.repaint();
    }//GEN-LAST:event_MenuCMouseExited

    private void EditCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditCMouseClicked
        
    }//GEN-LAST:event_EditCMouseClicked

    private void EditCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditCMouseEntered
        EditC1.setVisible(true);
        EditC1.repaint();
        BGPanel.repaint(); 
    }//GEN-LAST:event_EditCMouseEntered

    private void EditCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditCMouseExited
        EditC1.setVisible(false);
        BGPanel.repaint();
    }//GEN-LAST:event_EditCMouseExited

    private void LogoutCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutCMouseExited
        LogoutC1.setVisible(false);
        BGPanel.repaint();
    }//GEN-LAST:event_LogoutCMouseExited

    private void LogoutCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutCMouseEntered
        LogoutC1.setVisible(true);
        LogoutC1.repaint();
        BGPanel.repaint();
    }//GEN-LAST:event_LogoutCMouseEntered

    private void LogoutCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutCMouseClicked

    }//GEN-LAST:event_LogoutCMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BGPanel;
    private javax.swing.JButton EditC;
    private javax.swing.JButton EditC1;
    private javax.swing.JButton LogoutC;
    private javax.swing.JButton LogoutC1;
    private javax.swing.JButton MenuC;
    private javax.swing.JButton MenuC1;
    private javax.swing.JLabel TPBLabel;
    // End of variables declaration//GEN-END:variables

}