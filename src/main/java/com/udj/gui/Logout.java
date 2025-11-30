package com.udj.gui;

public class Logout extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Logout.class.getName());
    
    private javax.swing.JFrame parentFrame; 
    private boolean confirmedYes = false;
    
    public Logout(javax.swing.JFrame parent) { 
        this.parentFrame = parent;
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);
        setAlwaysOnTop(true); 
        YesC1.setVisible(false);
        NoC1.setVisible(false);
        
        if (parentFrame != null) {
            parentFrame.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGPanel = new javax.swing.JPanel();
        YesC = new javax.swing.JButton();
        NoC = new javax.swing.JButton();
        NoC1 = new javax.swing.JButton();
        YesC1 = new javax.swing.JButton();
        BGLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BGPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        BGPanel.add(YesC, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 70, 30));

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
        BGPanel.add(NoC, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 70, 30));

        NoC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/NoC1.png"))); // NOI18N
        NoC1.setBorderPainted(false);
        NoC1.setContentAreaFilled(false);
        BGPanel.add(NoC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 124, 80, 40));

        YesC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/YesC1.png"))); // NOI18N
        YesC1.setBorderPainted(false);
        YesC1.setContentAreaFilled(false);
        BGPanel.add(YesC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 124, 70, 40));

        BGLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LogoutMain.png"))); // NOI18N
        BGPanel.add(BGLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BGPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BGPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NoCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoCMouseClicked
        confirmedYes = false;
        this.dispose();
    }//GEN-LAST:event_NoCMouseClicked

    private void NoCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoCMouseEntered
        NoC1.setVisible(true);
    }//GEN-LAST:event_NoCMouseEntered

    private void NoCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoCMouseExited
        NoC1.setVisible(false);
    }//GEN-LAST:event_NoCMouseExited

    private void YesCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YesCMouseClicked
        confirmedYes = true; // User clicked YES
        this.dispose();
        new com.udj.gui.MainScreen().setVisible(true); 
    }//GEN-LAST:event_YesCMouseClicked

    @Override
    public void dispose() {
        if (parentFrame != null && parentFrame.isDisplayable()) {
            if (confirmedYes) {
                parentFrame.dispose();
            } else {
                parentFrame.setEnabled(true);
                parentFrame.toFront();
            }
        }
        super.dispose();
    }
    
    private void YesCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YesCMouseEntered
        YesC1.setVisible(true);
    }//GEN-LAST:event_YesCMouseEntered

    private void YesCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YesCMouseExited
        YesC1.setVisible(false);
    }//GEN-LAST:event_YesCMouseExited

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGLabel;
    private javax.swing.JPanel BGPanel;
    private javax.swing.JButton NoC;
    private javax.swing.JButton NoC1;
    private javax.swing.JButton YesC;
    private javax.swing.JButton YesC1;
    // End of variables declaration//GEN-END:variables
}
