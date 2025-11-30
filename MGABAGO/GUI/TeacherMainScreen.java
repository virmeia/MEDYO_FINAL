package com.udj.gui;

import com.udj.gui.components.UpdateProfile;
import javax.swing.*;
import java.awt.*;
import com.udj.logic.ProfilePictureManager;
import com.udj.logic.FacultyManager;
import com.udj.logic.TeacherProfileData;

public class TeacherMainScreen extends javax.swing.JFrame implements UpdateProfile {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TeacherMainScreen.class.getName());
    
    private static String loggedInTeacherId = null;
    private TeacherProfileData profileData; 
    private String profilePicturePath = null;
    
    public static void setLoggedInTeacherId(String id) {
        loggedInTeacherId = id;
    }
    
    public static String getLoggedInTeacherId() {
        return loggedInTeacherId;
    }
    
    public TeacherMainScreen() {
        loadTeacherData();
        initComponents();
        setLocationRelativeTo(null);
        
        EditC1.setVisible(false);
        
        updateProfile();
        
        loadAndDisplayPicture();
    }
    
    private void loadTeacherData() {
        if (loggedInTeacherId == null) {
            logger.severe("No teacher logged in!");
            JOptionPane.showMessageDialog(this, 
                "Please login first.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
       
        String[] teacherData = FacultyManager.getFaculty(loggedInTeacherId);
        
        if (teacherData != null && teacherData.length >= 7) {
            profileData = TeacherProfileData.fromArray(teacherData);  
        } else {
            logger.warning("Teacher data not found.");
            profileData = new TeacherProfileData(
                loggedInTeacherId, 
                "Unknown Teacher", 
                "N/A", "N/A", "N/A", "N/A", "N/A"  
            );
        }
        
        logger.info("Teacher logged in with ID: " + loggedInTeacherId);
    }
    
    public void refreshTeacherData() {
        loadTeacherData();
        updateProfile();
    }
    
    private void updateProfile() {
        TeacherID.setText(profileData.getTeacherID());       
        TeacherName.setText(profileData.getTeacherName());    
        TeacherDepartment.setText(profileData.getTeacherDepartment());
        TeacherCollege.setText(profileData.getTeacherCollege());
        TeacherStatus.setText(profileData.getTeacherStatus());
        TeacherEmail.setText(profileData.getTeacherEmail());
        TeacherCity.setText(profileData.getTeacherCity());
    }
    
    private void loadAndDisplayPicture() {
        if (loggedInTeacherId != null) {
            profilePicturePath = ProfilePictureManager.loadProfilePath(loggedInTeacherId);

            if (profilePicturePath != null && !profilePicturePath.isEmpty()) {
                ImageIcon icon = ProfilePictureManager.loadAndScaleImage(profilePicturePath, 140, 130);
                if (icon != null) {
                    ProfilePicLabel.setIcon(icon);
                    ProfilePicLabel.setBorder(BorderFactory.createLineBorder(new Color(61, 31, 92), 3));
                    ProfilePicLabel.setVisible(true);
                    EmptyProfile.setVisible(false);
                    return;
                }
            }
        }
        
        showDefaultImage();
    }
    
    private void showDefaultImage() {
       try {
        ImageIcon defaultIcon = new ImageIcon(getClass().getResource("/images/default_image.png"));
            if (defaultIcon.getImageLoadStatus() == MediaTracker.COMPLETE) {
                Image scaledImg = defaultIcon.getImage().getScaledInstance(140, 130, Image.SCALE_SMOOTH);
                ProfilePicLabel.setIcon(new ImageIcon(scaledImg));
                ProfilePicLabel.setBorder(BorderFactory.createLineBorder(new Color(61, 31, 92), 3));
                ProfilePicLabel.setVisible(true);
                EmptyProfile.setVisible(false);
            } else {
                ProfilePicLabel.setIcon(null);
                ProfilePicLabel.setVisible(false);
                EmptyProfile.setVisible(true);
            }
        } catch (Exception e) {
            ProfilePicLabel.setIcon(null);
            ProfilePicLabel.setVisible(false);
            EmptyProfile.setVisible(true);
        }
    }
    
    @Override
    public void setProfilePicturePath(String path) {
        this.profilePicturePath = path;
        if (loggedInTeacherId != null) {
            ProfilePictureManager.saveProfilePath(loggedInTeacherId, path);
        }

        ImageIcon icon = ProfilePictureManager.loadAndScaleImage(path, 140, 130);
        if (icon != null) {
            ProfilePicLabel.setIcon(icon);
            ProfilePicLabel.setBorder(BorderFactory.createLineBorder(new Color(61, 31, 92), 3));
            ProfilePicLabel.setVisible(true);
            EmptyProfile.setVisible(false);
        }
    }
    
    public String getTeacherId() {
        return loggedInTeacherId;
    }
    
    @Override
    public String getProfileId() {
        return loggedInTeacherId;
    }

    @Override
    public String getUserType() {
        return "teacher";
    }
    
    public String getTeacherName() {
        return profileData.getTeacherName();    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Name = new javax.swing.JLabel();
        BGPanel = new javax.swing.JPanel();
        LogoutC = new javax.swing.JButton();
        MenuC = new javax.swing.JButton();
        TeacherID = new javax.swing.JLabel();
        TeacherCity = new javax.swing.JLabel();
        TeacherEmail = new javax.swing.JLabel();
        TeacherStatus = new javax.swing.JLabel();
        TeacherCollege = new javax.swing.JLabel();
        TeacherDepartment = new javax.swing.JLabel();
        TeacherName = new javax.swing.JLabel();
        EmptyProfile = new javax.swing.JLabel();
        ProfilePicLabel = new javax.swing.JLabel();
        EditC = new javax.swing.JButton();
        EditC1 = new javax.swing.JButton();
        BGLabel = new javax.swing.JLabel();

        Name.setFont(new java.awt.Font("Product Sans", 1, 13)); // NOI18N
        Name.setForeground(new java.awt.Color(46, 20, 72));
        Name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BGPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LogoutC.setBorderPainted(false);
        LogoutC.setContentAreaFilled(false);
        LogoutC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogoutC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutCMouseClicked(evt);
            }
        });
        BGPanel.add(LogoutC, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 110, 40));

        MenuC.setBorderPainted(false);
        MenuC.setContentAreaFilled(false);
        MenuC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuCMouseExited(evt);
            }
        });
        BGPanel.add(MenuC, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 450, 180, 90));

        TeacherID.setFont(new java.awt.Font("Product Sans", 1, 13)); // NOI18N
        TeacherID.setForeground(new java.awt.Color(46, 20, 72));
        TeacherID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BGPanel.add(TeacherID, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 172, 440, 20));

        TeacherCity.setFont(new java.awt.Font("Product Sans", 1, 13)); // NOI18N
        TeacherCity.setForeground(new java.awt.Color(46, 20, 72));
        TeacherCity.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BGPanel.add(TeacherCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 440, 20));

        TeacherEmail.setFont(new java.awt.Font("Product Sans", 1, 13)); // NOI18N
        TeacherEmail.setForeground(new java.awt.Color(46, 20, 72));
        TeacherEmail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BGPanel.add(TeacherEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 304, 440, 20));

        TeacherStatus.setFont(new java.awt.Font("Product Sans", 1, 13)); // NOI18N
        TeacherStatus.setForeground(new java.awt.Color(46, 20, 72));
        TeacherStatus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BGPanel.add(TeacherStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 348, 440, 20));

        TeacherCollege.setFont(new java.awt.Font("Product Sans", 1, 13)); // NOI18N
        TeacherCollege.setForeground(new java.awt.Color(46, 20, 72));
        TeacherCollege.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BGPanel.add(TeacherCollege, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 440, 20));

        TeacherDepartment.setFont(new java.awt.Font("Product Sans", 1, 13)); // NOI18N
        TeacherDepartment.setForeground(new java.awt.Color(46, 20, 72));
        TeacherDepartment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BGPanel.add(TeacherDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 216, 440, 20));

        TeacherName.setFont(new java.awt.Font("Product Sans", 1, 13)); // NOI18N
        TeacherName.setForeground(new java.awt.Color(46, 20, 72));
        TeacherName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BGPanel.add(TeacherName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 440, 20));

        EmptyProfile.setBackground(new java.awt.Color(46, 20, 72));
        EmptyProfile.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        EmptyProfile.setForeground(new java.awt.Color(242, 216, 255));
        EmptyProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EmptyProfile.setOpaque(true);
        BGPanel.add(EmptyProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, 140, 130));
        BGPanel.add(ProfilePicLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, 140, 130));

        EditC.setBorderPainted(false);
        EditC.setContentAreaFilled(false);
        EditC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EditC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EditCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EditCMouseExited(evt);
            }
        });
        BGPanel.add(EditC, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 320, 110, 30));

        EditC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EditC1.png"))); // NOI18N
        EditC1.setBorderPainted(false);
        EditC1.setContentAreaFilled(false);
        BGPanel.add(EditC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(762, 316, 110, 30));

        BGLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TeacherMain.png"))); // NOI18N
        BGPanel.add(BGLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(BGPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EditCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditCMouseClicked
        EditProfile editFrame = new EditProfile(this, ProfilePicLabel, profilePicturePath);
        editFrame.setVisible(true);
    }//GEN-LAST:event_EditCMouseClicked

    private void EditCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditCMouseEntered
        EditC1.setVisible(true);
    }//GEN-LAST:event_EditCMouseEntered

    private void EditCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditCMouseExited
        EditC1.setVisible(false);
    }//GEN-LAST:event_EditCMouseExited

    private void MenuCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuCMouseClicked
        TeacherDB teacherDB = new TeacherDB(loggedInTeacherId);
        teacherDB.setVisible(true);  
        this.dispose();
    }//GEN-LAST:event_MenuCMouseClicked

    private void MenuCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuCMouseEntered
        
    }//GEN-LAST:event_MenuCMouseEntered

    private void MenuCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuCMouseExited
       
    }//GEN-LAST:event_MenuCMouseExited

    private void LogoutCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutCMouseClicked
        new Logout(this).setVisible(true);
    }//GEN-LAST:event_LogoutCMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGLabel;
    private javax.swing.JPanel BGPanel;
    private javax.swing.JButton EditC;
    private javax.swing.JButton EditC1;
    private javax.swing.JLabel EmptyProfile;
    private javax.swing.JButton LogoutC;
    private javax.swing.JButton MenuC;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel ProfilePicLabel;
    private javax.swing.JLabel TeacherCity;
    private javax.swing.JLabel TeacherCollege;
    private javax.swing.JLabel TeacherDepartment;
    private javax.swing.JLabel TeacherEmail;
    private javax.swing.JLabel TeacherID;
    private javax.swing.JLabel TeacherName;
    private javax.swing.JLabel TeacherStatus;
    // End of variables declaration//GEN-END:variables
}
