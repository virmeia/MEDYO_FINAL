package com.udj.gui;

public class AboutUDJ extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AboutUDJ.class.getName());

    public AboutUDJ() {
        initComponents();
        BackB.setVisible(false); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AboutC = new javax.swing.JLabel();
        AdmissionC = new javax.swing.JLabel();
        AcademicsC = new javax.swing.JLabel();
        UniversityLC = new javax.swing.JLabel();
        Back = new javax.swing.JLabel();
        BackB = new com.udj.gui.components.ButtonLabelBG();
        About = new com.udj.gui.components.Background();
        AboutBG = new com.udj.gui.components.ButtonLabelBG();
        Admission = new com.udj.gui.components.Background();
        AdmissionBG = new com.udj.gui.components.ButtonLabelBG();
        Academics = new com.udj.gui.components.Background();
        AcademicsBG = new com.udj.gui.components.ButtonLabelBG();
        UniversityLife = new com.udj.gui.components.Background();
        UniversityLifeBG = new com.udj.gui.components.ButtonLabelBG();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AboutC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AboutC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AboutCMouseClicked(evt);
            }
        });
        getContentPane().add(AboutC, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 120, 30));

        AdmissionC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AdmissionC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdmissionCMouseClicked(evt);
            }
        });
        getContentPane().add(AdmissionC, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 20, 120, 30));

        AcademicsC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AcademicsC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AcademicsCMouseClicked(evt);
            }
        });
        getContentPane().add(AcademicsC, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 120, 30));

        UniversityLC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UniversityLC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UniversityLCMouseClicked(evt);
            }
        });
        getContentPane().add(UniversityLC, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 160, 30));

        Back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(954, 18, 26, 26));

        BackB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackIcon.png"))); // NOI18N
        getContentPane().add(BackB, new org.netbeans.lib.awtextra.AbsoluteConstraints(952, 10, 30, 40));

        About.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AboutBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AboutPanel.png"))); // NOI18N
        About.add(AboutBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        getContentPane().add(About, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        Admission.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AdmissionBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AdmissionPanel.png"))); // NOI18N
        Admission.add(AdmissionBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        getContentPane().add(Admission, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        Academics.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AcademicsBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AcademicsPanel.png"))); // NOI18N
        Academics.add(AcademicsBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        getContentPane().add(Academics, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        UniversityLife.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UniversityLifeBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/UniversityLifePanel.png"))); // NOI18N
        UniversityLife.add(UniversityLifeBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        getContentPane().add(UniversityLife, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AboutCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AboutCMouseClicked
        About.setOpaque(true);
        About.repaint();
    }//GEN-LAST:event_AboutCMouseClicked

    private void AdmissionCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdmissionCMouseClicked
        Admission.setOpaque(true);
        Admission.repaint();
    }//GEN-LAST:event_AdmissionCMouseClicked

    private void UniversityLCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UniversityLCMouseClicked
        UniversityLife.setOpaque(true);
        UniversityLife.repaint();
    }//GEN-LAST:event_UniversityLCMouseClicked

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        BackB.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackMouseClicked

    private void AcademicsCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AcademicsCMouseClicked
        Academics.setOpaque(true);
        Academics.repaint();
    }//GEN-LAST:event_AcademicsCMouseClicked

    private void BackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseEntered
        BackB.setVisible(true);
    }//GEN-LAST:event_BackMouseEntered

    private void BackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseExited
        BackB.setVisible(false);
    }//GEN-LAST:event_BackMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel About;
    private javax.swing.JLabel AboutBG;
    private javax.swing.JLabel AboutC;
    private javax.swing.JPanel Academics;
    private javax.swing.JLabel AcademicsBG;
    private javax.swing.JLabel AcademicsC;
    private javax.swing.JPanel Admission;
    private javax.swing.JLabel AdmissionBG;
    private javax.swing.JLabel AdmissionC;
    private javax.swing.JLabel Back;
    private javax.swing.JLabel BackB;
    private javax.swing.JLabel UniversityLC;
    private javax.swing.JPanel UniversityLife;
    private javax.swing.JLabel UniversityLifeBG;
    // End of variables declaration//GEN-END:variables
}
