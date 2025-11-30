package com.udj.gui;

public class DeleteFaculty extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DeleteFaculty.class.getName());
    private boolean confirmed = false;
    public DeleteFaculty(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }
    public void setTargetID(String id) {
        FacultyID.setText(id);
        FacultyID.setEditable(false);
    }
    
    public boolean isConfirmed() {
        return confirmed;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FacultyID = new javax.swing.JTextField();
        Yes = new javax.swing.JButton();
        No = new javax.swing.JButton();
        DeleteBG = new com.udj.gui.components.ButtonLabelBG();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FacultyID.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        FacultyID.setForeground(new java.awt.Color(255, 102, 102));
        FacultyID.setAutoscrolls(false);
        FacultyID.setBorder(null);
        FacultyID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        FacultyID.setFocusable(false);
        getContentPane().add(FacultyID, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 125, 80, -1));
        FacultyID.setOpaque(false);

        Yes.setBorderPainted(false);
        Yes.setContentAreaFilled(false);
        Yes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YesMouseClicked(evt);
            }
        });
        getContentPane().add(Yes, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 150, 60, 20));

        No.setBorderPainted(false);
        No.setContentAreaFilled(false);
        No.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NoMouseClicked(evt);
            }
        });
        getContentPane().add(No, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 150, 60, 20));

        DeleteBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DeleteFR.png"))); // NOI18N
        getContentPane().add(DeleteBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 200));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void YesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YesMouseClicked
        confirmed = true;  
        setVisible(false);
    }//GEN-LAST:event_YesMouseClicked

    private void NoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoMouseClicked
        confirmed = false; 
        setVisible(false);
    }//GEN-LAST:event_NoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DeleteBG;
    private javax.swing.JTextField FacultyID;
    private javax.swing.JButton No;
    private javax.swing.JButton Yes;
    // End of variables declaration//GEN-END:variables
}
