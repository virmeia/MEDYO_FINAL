package com.udj.gui.components;

public class AddSaveConfirm extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AddSaveConfirm.class.getName());
    private boolean confirmed = false;
    
    public AddSaveConfirm(java.awt.Frame parent, boolean modal) {
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

        Yes = new javax.swing.JLabel();
        No = new javax.swing.JLabel();
        ASBG = new com.udj.gui.components.ButtonLabelBG();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Yes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Yes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YesMouseClicked(evt);
            }
        });
        getContentPane().add(Yes, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 112, 44, 12));

        No.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        No.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NoMouseClicked(evt);
            }
        });
        getContentPane().add(No, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 112, 44, 12));

        ASBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AddandSave.png"))); // NOI18N
        getContentPane().add(ASBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void YesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YesMouseClicked
        confirmed = true;  // user confirmed
        setVisible(false);
    }//GEN-LAST:event_YesMouseClicked

    private void NoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoMouseClicked
        confirmed = false; // user cancelled
        setVisible(false);
    }//GEN-LAST:event_NoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ASBG;
    private javax.swing.JLabel No;
    private javax.swing.JLabel Yes;
    // End of variables declaration//GEN-END:variables
}
