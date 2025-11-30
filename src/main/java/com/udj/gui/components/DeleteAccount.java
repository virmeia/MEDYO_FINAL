package com.udj.gui.components;

public class DeleteAccount extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DeleteAccount.class.getName());
    private boolean confirmed = false;
    
    public DeleteAccount(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }

    public boolean isConfirmed() {
        return confirmed;
    }
    
    public void setTargetID(String id) {
        UserID.setText(id);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Yes = new javax.swing.JLabel();
        No = new javax.swing.JLabel();
        UserID = new javax.swing.JTextField();
        DABG = new com.udj.gui.components.ButtonLabelBG();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Yes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Yes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YesMouseClicked(evt);
            }
        });
        getContentPane().add(Yes, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 150, 60, 19));

        No.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NoMouseClicked(evt);
            }
        });
        getContentPane().add(No, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 150, 60, 19));

        UserID.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        UserID.setForeground(new java.awt.Color(255, 102, 102));
        UserID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        UserID.setAutoscrolls(false);
        UserID.setBorder(null);
        UserID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        UserID.setFocusable(false);
        UserID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserIDActionPerformed(evt);
            }
        });
        getContentPane().add(UserID, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 91, 110, 30));
        UserID.setOpaque(false);

        DABG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DeleteAcc.png"))); // NOI18N
        getContentPane().add(DABG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserIDActionPerformed

    }//GEN-LAST:event_UserIDActionPerformed

    private void YesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YesMouseClicked
        confirmed = true;  
        setVisible(false);
    }//GEN-LAST:event_YesMouseClicked

    private void NoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoMouseClicked
        confirmed = false; 
        setVisible(false);
    }//GEN-LAST:event_NoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DABG;
    private javax.swing.JLabel No;
    private javax.swing.JTextField UserID;
    private javax.swing.JLabel Yes;
    // End of variables declaration//GEN-END:variables
}
