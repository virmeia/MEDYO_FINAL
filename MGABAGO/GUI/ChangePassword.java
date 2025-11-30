package com.udj.gui;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.UIManager;

public class ChangePassword extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ChangePassword.class.getName());
    private static final String DATA_FILE = "src/main/resources/data/LoginCredentials.txt";
    
    private static final Map<String, String> userPasswords = new HashMap<>();
    private static final Map<String, String[]> completeUserData = new HashMap<>();

    
    private String loggedInUserId;
    
    static {
        loadUserDataFromFile();
    }
    
    private static void loadUserDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("#")) continue; 
                
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String userId = parts[0].trim();
                    String password = parts[1].trim();
                    String role = parts.length >= 3 ? parts[2].trim() : "";
                    
                    userPasswords.put(userId, password);
                    completeUserData.put(userId, new String[]{password, role});
                }
            }
        } catch (IOException e) {
            logger.severe("FATAL: Could not read user data file: " + DATA_FILE + "\nError: " + e.getMessage());
        }
    }
    
    private static void saveUserDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE))) {
            for (Map.Entry<String, String[]> entry : completeUserData.entrySet()) {
                String userId = entry.getKey();
                String password = entry.getValue()[0];
                String role = entry.getValue()[1];
                
                if (!role.isEmpty()) {
                    writer.write(userId + "," + password + "," + role);
                } else {
                    writer.write(userId + "," + password);
                }
                writer.newLine();
            }
        } catch (IOException e) {
            logger.severe("FATAL: Could not write to user data file: " + DATA_FILE + "\nError: " + e.getMessage());
        }
    }
    
    public ChangePassword(String userId) {
        this.loggedInUserId = userId;
        initComponents();
        
        UIManager.put("OptionPane.background", new java.awt.Color(242, 216, 255));
        UIManager.put("Panel.background", new java.awt.Color(242, 216, 255));
        UIManager.put("OptionPane.messageForeground", new java.awt.Color(61, 31, 92));

        ChangeC1.setVisible(false);
        CancelC1.setVisible(false);
    }
    
    public ChangePassword() {
        initComponents();
        ChangeC1.setVisible(false);
        CancelC1.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new com.udj.gui.components.Background();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CurrentPass = new javax.swing.JPasswordField();
        NewPass = new javax.swing.JPasswordField();
        PWLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ChangeC = new javax.swing.JLabel();
        CancelC = new javax.swing.JLabel();
        CancelC1 = new com.udj.gui.components.ButtonLabelBG();
        ChangeC1 = new javax.swing.JLabel();
        BGLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(310, 170));
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Product Sans", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("not one you have used recently.");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 380, 30));

        jLabel2.setFont(new java.awt.Font("Product Sans", 0, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Please ensure your new password is");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 380, 30));

        CurrentPass.setBackground(new java.awt.Color(248, 240, 252));
        CurrentPass.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        CurrentPass.setBorder(null);
        jPanel1.add(CurrentPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 190, 20));

        NewPass.setBackground(new java.awt.Color(248, 240, 252));
        NewPass.setBorder(null);
        NewPass.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        NewPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewPassActionPerformed(evt);
            }
        });
        jPanel1.add(NewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 193, 190, 20));

        PWLabel.setFont(new java.awt.Font("Product Sans", 0, 13)); // NOI18N
        PWLabel.setForeground(new java.awt.Color(102, 102, 102));
        PWLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PWLabel.setText("New Password");
        jPanel1.add(PWLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 150, 190, 70));

        jLabel3.setFont(new java.awt.Font("Product Sans", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Change Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 380, 60));

        jLabel6.setFont(new java.awt.Font("Product Sans", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Current Password");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 110, 190, 60));

        ChangeC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ChangeC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChangeCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ChangeCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ChangeCMouseExited(evt);
            }
        });
        jPanel1.add(ChangeC, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 258, 180, 43));

        CancelC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CancelC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CancelCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CancelCMouseExited(evt);
            }
        });
        jPanel1.add(CancelC, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 314, 180, 43));

        CancelC1.setBackground(new java.awt.Color(248, 241, 253));
        CancelC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CancelC1.png"))); // NOI18N
        jPanel1.add(CancelC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 313, 220, 50));

        ChangeC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ChangeC1.png"))); // NOI18N
        ChangeC1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(ChangeC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 248, 230, 60));

        BGLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ChangePass.png"))); // NOI18N
        jPanel1.add(BGLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
        
    private void NewPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewPassActionPerformed
    
    private void changePassword(java.awt.event.MouseEvent evt) {                                          
        String currentPass = new String(CurrentPass.getPassword());
        String newPass = new String(NewPass.getPassword());

        if (currentPass.isEmpty() || newPass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both the current and new passwords.", "Missing Fields", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String storedPassword = userPasswords.get(loggedInUserId);
        
        if (storedPassword == null) {
            JOptionPane.showMessageDialog(this, "Error: User ID not found in database. Check the LoginCredentials.txt file.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!currentPass.equals(storedPassword)) {
            JOptionPane.showMessageDialog(this, "Incorrect current password. Please try again.", "Update Failed", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (newPass.equals(currentPass)) {
            JOptionPane.showMessageDialog(this, "New password cannot be the same as the current password.", "Update Failed", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        userPasswords.put(loggedInUserId, newPass); 
        
        String[] userData = completeUserData.get(loggedInUserId);
        if (userData != null) {
            userData[0] = newPass; 
        }
        saveUserDataToFile();
        JOptionPane.showMessageDialog(this, "Password changed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        this.dispose(); 
    }                                    

    private void CancelCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelCMouseEntered
        CancelC1.setVisible(true);
    }//GEN-LAST:event_CancelCMouseEntered

    private void CancelCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelCMouseExited
        CancelC1.setVisible(false);
    }//GEN-LAST:event_CancelCMouseExited

    private void ChangeCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChangeCMouseClicked
        ChangeC1.setVisible(true);
        changePassword(evt);
    }//GEN-LAST:event_ChangeCMouseClicked

    private void ChangeCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChangeCMouseEntered
        ChangeC1.setVisible(true);
    }//GEN-LAST:event_ChangeCMouseEntered

    private void ChangeCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChangeCMouseExited
        ChangeC1.setVisible(false);
    }//GEN-LAST:event_ChangeCMouseExited

    private void CancelCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelCMouseClicked
        CancelC1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CancelCMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGLabel;
    private javax.swing.JLabel CancelC;
    private javax.swing.JLabel CancelC1;
    private javax.swing.JLabel ChangeC;
    private javax.swing.JLabel ChangeC1;
    private javax.swing.JPasswordField CurrentPass;
    private javax.swing.JPasswordField NewPass;
    private javax.swing.JLabel PWLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
