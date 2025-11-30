package com.udj.gui;

public class DeleteStudent extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DeleteStudent.class.getName());
    private boolean confirmed = false;
    public DeleteStudent(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }
    public void setTargetID(String id) {
        StudentID.setText(id);
        StudentID.setEditable(false);
    }
    
    public boolean isConfirmed() {
        return confirmed;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGPanel = new com.udj.gui.components.Background();
        Yes = new javax.swing.JLabel();
        No = new javax.swing.JLabel();
        StudentID = new javax.swing.JTextField();
        DeleteStudent = new com.udj.gui.components.ButtonLabelBG();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BGPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Yes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Yes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YesMouseClicked(evt);
            }
        });
        BGPanel.add(Yes, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 150, 60, 19));

        No.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        No.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NoMouseClicked(evt);
            }
        });
        BGPanel.add(No, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 150, 60, 19));

        StudentID.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        StudentID.setForeground(new java.awt.Color(255, 102, 102));
        StudentID.setAutoscrolls(false);
        StudentID.setBorder(null);
        StudentID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        StudentID.setFocusable(false);
        BGPanel.add(StudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 125, 80, -1));
        StudentID.setOpaque(false);

        DeleteStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DeleteSR.png"))); // NOI18N
        BGPanel.add(DeleteStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 200));

        getContentPane().add(BGPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 200));

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
    private javax.swing.JPanel BGPanel;
    private javax.swing.JLabel DeleteStudent;
    private javax.swing.JLabel No;
    private javax.swing.JTextField StudentID;
    private javax.swing.JLabel Yes;
    // End of variables declaration//GEN-END:variables
}
