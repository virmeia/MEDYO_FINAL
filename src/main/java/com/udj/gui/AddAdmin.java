package com.udj.gui;

public class AddAdmin extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AddAdmin.class.getName());
    private SystemAccountManagement parentPanel;
    private static final String SECURITY_KEY = "JEMA1234";
    
   public AddAdmin(java.awt.Frame parent, boolean modal, SystemAccountManagement systemPanel) {
        super(parent, modal);
        this.parentPanel = systemPanel;
        initComponents();
        BackB.setVisible(false);
    }
    
    public AddAdmin(java.awt.Frame parent, boolean modal) {
        this(parent, modal, null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGPanel = new com.udj.gui.components.Background();
        Name = new javax.swing.JTextField();
        AdminID = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        Contact = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        ConfirmPassword = new javax.swing.JPasswordField();
        NameFormat = new javax.swing.JLabel();
        Back = new javax.swing.JLabel();
        BackB = new com.udj.gui.components.ButtonLabelBG();
        ClearC = new javax.swing.JLabel();
        SaveC = new javax.swing.JLabel();
        NewStudentLabel = new javax.swing.JLabel();
        AddStudent = new com.udj.gui.components.ButtonLabelBG();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        BGPanel.setPreferredSize(new java.awt.Dimension(540, 360));
        BGPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Name.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Name.setAutoscrolls(false);
        Name.setBorder(null);
        Name.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });
        BGPanel.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 83, 280, 20));
        Name.setOpaque(false);

        AdminID.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        AdminID.setAutoscrolls(false);
        AdminID.setBorder(null);
        AdminID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        AdminID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminIDActionPerformed(evt);
            }
        });
        BGPanel.add(AdminID, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 110, 280, 20));
        AdminID.setOpaque(false);

        Email.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Email.setAutoscrolls(false);
        Email.setBorder(null);
        Email.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });
        BGPanel.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 137, 280, 20));
        Email.setOpaque(false);

        Contact.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Contact.setAutoscrolls(false);
        Contact.setBorder(null);
        Contact.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactActionPerformed(evt);
            }
        });
        BGPanel.add(Contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 164, 280, 20));
        Contact.setOpaque(false);

        Password.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Password.setBorder(null);
        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });
        BGPanel.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 192, 280, 20));

        ConfirmPassword.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        ConfirmPassword.setBorder(null);
        BGPanel.add(ConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 220, 280, 20));

        NameFormat.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        NameFormat.setText("Format: SURNAME, Given Name MI");
        BGPanel.add(NameFormat, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 250, -1));

        Back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackMouseExited(evt);
            }
        });
        BGPanel.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 20, 20));

        BackB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackIconSmall.png"))); // NOI18N
        BGPanel.add(BackB, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 12, -1, -1));

        ClearC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClearC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearCMouseClicked(evt);
            }
        });
        BGPanel.add(ClearC, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 320, 85, 25));

        SaveC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SaveC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveCMouseClicked(evt);
            }
        });
        BGPanel.add(SaveC, new org.netbeans.lib.awtextra.AbsoluteConstraints(428, 320, 85, 25));

        NewStudentLabel.setFont(new java.awt.Font("Product Sans", 1, 18)); // NOI18N
        NewStudentLabel.setForeground(new java.awt.Color(255, 255, 255));
        NewStudentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NewStudentLabel.setText("NEW ADMIN ACCOUNT");
        BGPanel.add(NewStudentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 40));

        AddStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AddAdminBG.png"))); // NOI18N
        BGPanel.add(AddStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BGPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BGPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        
    }//GEN-LAST:event_NameActionPerformed

    private void SaveCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveCMouseClicked
        String name = Name.getText().trim();
        String id = AdminID.getText().trim();
        String email = Email.getText().trim();
        String contact = Contact.getText().trim();
        String pass = new String(Password.getPassword()).trim();
        String confirmPass = new String(ConfirmPassword.getPassword()).trim();

        if (name.isEmpty() || id.isEmpty() || email.isEmpty() || contact.isEmpty() || pass.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!pass.equals(confirmPass)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        com.udj.gui.components.CreateAdminConfirm confirmDialog = new com.udj.gui.components.CreateAdminConfirm((java.awt.Frame)null, true);
        confirmDialog.setVisible(true);
        if (!confirmDialog.isConfirmed()) return;
        
        com.udj.gui.components.EnterSecurityKey keyDialog = new com.udj.gui.components.EnterSecurityKey(this, true);
        keyDialog.setVisible(true); 
        if (!keyDialog.isConfirmed()) return;

        String inputKey = keyDialog.getSecurityKey(); 
        
        if (inputKey == null || inputKey.trim().isEmpty()) {
             javax.swing.JOptionPane.showMessageDialog(this, "Security key is empty.", "Error", javax.swing.JOptionPane.WARNING_MESSAGE);
             return;
        }

        if (inputKey.equals(SECURITY_KEY)) {
            boolean profileSaved = com.udj.logic.AdminManager.saveAdmin(id, name, email, contact);
            if (!profileSaved) {
                 javax.swing.JOptionPane.showMessageDialog(this, "Error: Admin ID already exists.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                 return;
            }
            boolean accountCreated = com.udj.logic.AccountManager.createAccount(id, id, pass, "ADMIN");
            
            if (accountCreated) {
                javax.swing.JOptionPane.showMessageDialog(this, "Admin Account Created Successfully!");
                if (parentPanel != null) {
                    parentPanel.refreshActiveTable(); 
                }
                this.dispose();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Error: Login username taken.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
            
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Invalid Security Key!", "Access Denied", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SaveCMouseClicked
   
    private void ClearCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearCMouseClicked
        Name.setText("");
        AdminID.setText("");
        Email.setText("");
        Contact.setText("");
        Password.setText("");
        ConfirmPassword.setText("");
    }//GEN-LAST:event_ClearCMouseClicked

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        BackB.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackMouseClicked

    private void BackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseEntered
        BackB.setVisible(true);
    }//GEN-LAST:event_BackMouseEntered

    private void BackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseExited
        BackB.setVisible(false);
    }//GEN-LAST:event_BackMouseExited

    private void AdminIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminIDActionPerformed
      
    }//GEN-LAST:event_AdminIDActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
       
    }//GEN-LAST:event_EmailActionPerformed

    private void ContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactActionPerformed
     
    }//GEN-LAST:event_ContactActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddStudent;
    private javax.swing.JTextField AdminID;
    private javax.swing.JPanel BGPanel;
    private javax.swing.JLabel Back;
    private javax.swing.JLabel BackB;
    private javax.swing.JLabel ClearC;
    private javax.swing.JPasswordField ConfirmPassword;
    private javax.swing.JTextField Contact;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Name;
    private javax.swing.JLabel NameFormat;
    private javax.swing.JLabel NewStudentLabel;
    private javax.swing.JPasswordField Password;
    private javax.swing.JLabel SaveC;
    // End of variables declaration//GEN-END:variables
}
