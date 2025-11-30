package com.udj.gui.components;

public class DeleteAll extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DeleteAll.class.getName());
    private boolean confirmed = false;
    
    public DeleteAll(java.awt.Frame parent, boolean modal) {
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

        TypeHere = new javax.swing.JTextField();
        Cancel = new javax.swing.JLabel();
        Confirm = new javax.swing.JLabel();
        DABG = new com.udj.gui.components.ButtonLabelBG();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TypeHere.setFont(new java.awt.Font("Product Sans", 1, 12)); // NOI18N
        TypeHere.setAutoscrolls(false);
        TypeHere.setBorder(null);
        TypeHere.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TypeHere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TypeHereActionPerformed(evt);
            }
        });
        getContentPane().add(TypeHere, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 125, 60, -1));
        TypeHere.setOpaque(false);

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

        DABG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DeleteAll.png"))); // NOI18N
        getContentPane().add(DABG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TypeHereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TypeHereActionPerformed

    }//GEN-LAST:event_TypeHereActionPerformed

    private void CancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelMouseClicked
        confirmed = false;
        this.dispose();
    }//GEN-LAST:event_CancelMouseClicked

    private void ConfirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmMouseClicked
        String input = TypeHere.getText().trim();
        
        if (input.equals("DELETE")) {
            confirmed = true;
            this.dispose(); 
        } else {
            java.awt.Toolkit.getDefaultToolkit().beep();
            TypeHere.selectAll();
        }
    }//GEN-LAST:event_ConfirmMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cancel;
    private javax.swing.JLabel Confirm;
    private javax.swing.JLabel DABG;
    private javax.swing.JTextField TypeHere;
    // End of variables declaration//GEN-END:variables
}
