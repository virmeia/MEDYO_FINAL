package com.udj.gui;

public class SubmitGrades extends javax.swing.JPanel {

   
    public SubmitGrades() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        YesC = new javax.swing.JButton();
        NoC = new javax.swing.JButton();
        NoC1 = new javax.swing.JButton();
        YesC1 = new javax.swing.JButton();
        BGPanel = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        YesC.setBorderPainted(false);
        YesC.setContentAreaFilled(false);
        YesC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YesCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                YesCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                YesCMouseExited(evt);
            }
        });
        add(YesC, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 70, 20));

        NoC.setBorderPainted(false);
        NoC.setContentAreaFilled(false);
        NoC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NoCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NoCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NoCMouseExited(evt);
            }
        });
        add(NoC, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 70, 20));

        NoC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/No.png"))); // NOI18N
        NoC1.setBorderPainted(false);
        NoC1.setContentAreaFilled(false);
        add(NoC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 142, 70, 30));

        YesC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Yes.png"))); // NOI18N
        YesC1.setBorderPainted(false);
        YesC1.setContentAreaFilled(false);
        add(YesC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 138, 70, 40));

        BGPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SaveAndSubmit.png"))); // NOI18N
        add(BGPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 200));
    }// </editor-fold>//GEN-END:initComponents

    private void NoCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoCMouseClicked
       // confirmedYes = false;
        //this.dispose();
        new com.udj.gui.TeacherDB().setVisible(true);
    }//GEN-LAST:event_NoCMouseClicked

    private void NoCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoCMouseEntered
        NoC1.setVisible(true);
    }//GEN-LAST:event_NoCMouseEntered

    private void NoCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoCMouseExited
        NoC1.setVisible(false);
    }//GEN-LAST:event_NoCMouseExited

    private void YesCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YesCMouseClicked
       // confirmedYes = true; // User clicked YES
        //this.dispose();
        new com.udj.gui.TeacherDB().setVisible(true);
    }//GEN-LAST:event_YesCMouseClicked

    private void YesCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YesCMouseEntered
        YesC1.setVisible(true);
    }//GEN-LAST:event_YesCMouseEntered

    private void YesCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YesCMouseExited
        YesC1.setVisible(false);
    }//GEN-LAST:event_YesCMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGPanel;
    private javax.swing.JButton NoC;
    private javax.swing.JButton NoC1;
    private javax.swing.JButton YesC;
    private javax.swing.JButton YesC1;
    // End of variables declaration//GEN-END:variables
}
