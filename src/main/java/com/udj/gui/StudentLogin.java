package com.udj.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane; 

public class StudentLogin extends javax.swing.JFrame {
    
    private final JFrame mainAppFrame;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(StudentLogin.class.getName());

    public StudentLogin(javax.swing.JFrame mainFrame) {
        initComponents();
       this.mainAppFrame = mainFrame;
        this.setAlwaysOnTop(true);
        if (this.mainAppFrame != null) {
            this.mainAppFrame.setEnabled(false);
        }
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                restoreParent();
            }
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                if (mainAppFrame != null && mainAppFrame.isDisplayable()) {
                    restoreParent();
                }
            }
        });
    }
    
    private void restoreParent() {
        if (mainAppFrame != null) {
            mainAppFrame.setEnabled(true);
            mainAppFrame.toFront(); 
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new com.udj.gui.components.Background();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        UsernameF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        PWLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        LoginButton = new javax.swing.JLabel();
        LoginBGLabel = new javax.swing.JLabel();
        LoginBHover = new com.udj.gui.components.ButtonLabelBG();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(310, 170));
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Product Sans", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("please Contact the Admin for assistance.");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 380, 30));

        jLabel2.setFont(new java.awt.Font("Product Sans", 0, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("If you have problem with your account,");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 380, 30));

        jPasswordField1.setBackground(new java.awt.Color(248, 240, 252));
        jPasswordField1.setBorder(null);
        jPasswordField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 194, 190, 20));

        UsernameF.setBackground(new java.awt.Color(249, 243, 253));
        UsernameF.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        UsernameF.setBorder(null);
        UsernameF.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(UsernameF, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 190, 20));

        jLabel5.setForeground(new java.awt.Color(46, 20, 72));
        jLabel5.setText("________________________________________");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 194, 200, 30));

        jLabel7.setForeground(new java.awt.Color(46, 20, 72));
        jLabel7.setText("________________________________________");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 150, 200, 30));

        PWLabel.setFont(new java.awt.Font("Product Sans", 0, 13)); // NOI18N
        PWLabel.setForeground(new java.awt.Color(102, 102, 102));
        PWLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PWLabel.setText("Password");
        jPanel1.add(PWLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 190, 70));

        jLabel3.setFont(new java.awt.Font("Product Sans", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Student Login");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 380, 60));

        jLabel6.setFont(new java.awt.Font("Product Sans", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Username");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 190, 60));

        LoginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LoginButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LoginButtonMouseExited(evt);
            }
        });
        jPanel1.add(LoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 287, 180, 43));

        LoginBGLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LoginTemp.png"))); // NOI18N
        jPanel1.add(LoginBGLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        LoginBHover.setBackground(new java.awt.Color(248, 241, 253));
        LoginBHover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LoginBHover.png"))); // NOI18N
        jPanel1.add(LoginBHover, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 285, -1, 45));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LoginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtonMouseClicked
        String username = UsernameF.getText().trim();
        String password = new String(jPasswordField1.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter username and password.", "Missing Fields", JOptionPane.WARNING_MESSAGE);
            return;
        }

        com.udj.logic.User user = com.udj.logic.LoginCheck.validateLogin(username, password);

        if (user != null) {
            String role = user.getRole();

            switch (role) {
                case "STUDENT" -> {
                    JOptionPane.showMessageDialog(this, "Login successful!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                    if (mainAppFrame != null) { 
                        mainAppFrame.dispose(); 
                    }
                   // StudentDashboard studentScreen = new StudentDashboard(); // Replace with your actual class
                   // studentScreen.setVisible(true);
                    this.dispose(); 
                }
                case "TEACHER", "ADMIN" -> {
                    JOptionPane.showMessageDialog(this, "This account is not for student login. Please use the appropriate login screen.", "Wrong Login", JOptionPane.WARNING_MESSAGE);
                }
                default -> {
                    JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_LoginButtonMouseClicked

    private void LoginButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtonMouseEntered
        LoginBHover.setOpaque(true);
        LoginBHover.repaint();
    }//GEN-LAST:event_LoginButtonMouseEntered

    private void LoginButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtonMouseExited
        LoginBHover.setOpaque(false);
        LoginBHover.getParent().repaint();
    }//GEN-LAST:event_LoginButtonMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LoginBGLabel;
    private javax.swing.JLabel LoginBHover;
    private javax.swing.JLabel LoginButton;
    private javax.swing.JLabel PWLabel;
    private javax.swing.JTextField UsernameF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    // End of variables declaration//GEN-END:variables
}
