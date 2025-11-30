package com.udj.gui.components;

public class EnterSecurityKey extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(EnterSecurityKey.class.getName());
    private boolean confirmed = false;
    
    public EnterSecurityKey(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }
    
    public EnterSecurityKey(java.awt.Dialog parent, boolean modal) {
        super(parent, true); 
        initComponents();
        setLocationRelativeTo(parent);
    }

    public boolean isConfirmed() {
        return confirmed;
    }
    
    public String getSecurityKey() {
        return new String(SecurityKey.getPassword());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cancel = new javax.swing.JLabel();
        Confirm = new javax.swing.JLabel();
        SecurityKey = new javax.swing.JPasswordField();
        ESKBG = new com.udj.gui.components.ButtonLabelBG();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelMouseClicked(evt);
            }
        });
        getContentPane().add(Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 150, 80, 17));

        Confirm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Confirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConfirmMouseClicked(evt);
            }
        });
        getContentPane().add(Confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 150, 80, 17));

        SecurityKey.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        SecurityKey.setBorder(null);
        SecurityKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SecurityKeyActionPerformed(evt);
            }
        });
        getContentPane().add(SecurityKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 112, 130, 17));

        ESKBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SecurityKey.png"))); // NOI18N
        getContentPane().add(ESKBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 200));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelMouseClicked
        confirmed = false; 
        setVisible(false);
    }//GEN-LAST:event_CancelMouseClicked

    private void ConfirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmMouseClicked
        confirmed = true;  
        setVisible(false);
    }//GEN-LAST:event_ConfirmMouseClicked

    private void SecurityKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SecurityKeyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SecurityKeyActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cancel;
    private javax.swing.JLabel Confirm;
    private javax.swing.JLabel ESKBG;
    private javax.swing.JPasswordField SecurityKey;
    // End of variables declaration//GEN-END:variables
}
