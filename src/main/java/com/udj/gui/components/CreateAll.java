package com.udj.gui.components;

import javax.swing.JOptionPane;

public class CreateAll extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CreateAll.class.getName());
    private boolean confirmed = false;
    
    public CreateAll(java.awt.Frame parent, boolean modal) {
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

        Cancel = new javax.swing.JLabel();
        Confirm = new javax.swing.JLabel();
        TypeHere = new javax.swing.JTextField();
        GABG = new com.udj.gui.components.ButtonLabelBG();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelMouseClicked(evt);
            }
        });
        getContentPane().add(Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 153, 80, 17));

        Confirm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Confirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConfirmMouseClicked(evt);
            }
        });
        getContentPane().add(Confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 153, 80, 17));

        TypeHere.setFont(new java.awt.Font("Product Sans", 1, 12)); // NOI18N
        TypeHere.setAutoscrolls(false);
        TypeHere.setBorder(null);
        TypeHere.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TypeHere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TypeHereActionPerformed(evt);
            }
        });
        getContentPane().add(TypeHere, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 126, 70, -1));
        TypeHere.setOpaque(false);

        GABG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CreateAll.png"))); // NOI18N
        getContentPane().add(GABG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TypeHereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TypeHereActionPerformed

    }//GEN-LAST:event_TypeHereActionPerformed

    private void ConfirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmMouseClicked
        String input = TypeHere.getText().trim();
        
        if (input.equals("CREATE")) {
            confirmed = true;
            this.dispose(); 
        } else {
            java.awt.Toolkit.getDefaultToolkit().beep();
            TypeHere.selectAll(); 
            JOptionPane.showMessageDialog(this, "Please type 'CREATE' to confirm.");
        }
    }//GEN-LAST:event_ConfirmMouseClicked

    private void CancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelMouseClicked
        confirmed = false;
        this.dispose();
    }//GEN-LAST:event_CancelMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cancel;
    private javax.swing.JLabel Confirm;
    private javax.swing.JLabel GABG;
    private javax.swing.JTextField TypeHere;
    // End of variables declaration//GEN-END:variables
}
