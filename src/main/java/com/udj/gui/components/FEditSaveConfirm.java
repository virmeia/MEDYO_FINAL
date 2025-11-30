package com.udj.gui.components;

public class FEditSaveConfirm extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FEditSaveConfirm.class.getName());
private boolean confirmed = false;
    
    public FEditSaveConfirm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Yes = new javax.swing.JButton();
        No = new javax.swing.JButton();
        ESBG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(255, 150));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Yes.setBorderPainted(false);
        Yes.setContentAreaFilled(false);
        Yes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YesMouseClicked(evt);
            }
        });
        getContentPane().add(Yes, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 110, 42, 15));

        No.setBorderPainted(false);
        No.setContentAreaFilled(false);
        No.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NoMouseClicked(evt);
            }
        });
        getContentPane().add(No, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 110, 42, 15));

        ESBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FEditandSave.png"))); // NOI18N
        ESBG.setPreferredSize(new java.awt.Dimension(255, 150));
        getContentPane().add(ESBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 255, 150));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void YesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YesMouseClicked
        // TODO add your handling code here:
        confirmed = true;  // user confirmed
        setVisible(false);
    }//GEN-LAST:event_YesMouseClicked

    private void NoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoMouseClicked
        // TODO add your handling code here:
        confirmed = false;  // user confirmed
        setVisible(false);
    }//GEN-LAST:event_NoMouseClicked

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ESBG;
    private javax.swing.JButton No;
    private javax.swing.JButton Yes;
    // End of variables declaration//GEN-END:variables
}
