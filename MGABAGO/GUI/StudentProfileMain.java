package com.udj.gui;

import com.udj.gui.components.UpdateProfile;
import javax.swing.*;
import java.awt.*;
import com.udj.logic.StudentManager;
import com.udj.logic.ProfilePictureManager;
import com.udj.logic.StudentProfileData;

public class StudentProfileMain extends javax.swing.JFrame implements UpdateProfile {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(StudentProfileMain.class.getName());
     private static String loggedInStudentId = null;
    private StudentProfileData profileData;
    private String profilePicturePath = null;
    
    private JPanel contentPanel;
    private CardLayout cardLayout;
    
    public static void setLoggedInStudentId(String id) {
        loggedInStudentId = id;
    }
    
    public static String getLoggedInStudentId() {
        return loggedInStudentId;
    }
    
    public StudentProfileMain() {
        loadStudentData();
        initComponents();
        setLocationRelativeTo(null);
        initializeCardLayout();
        loadAndDisplayPicture();
        updateProfile();
        ScheduleC1.setVisible(false); 
        EvaluationC1.setVisible(false);
        GradesC1.setVisible(false);
        PasswordC1.setVisible(false);
        LogoutC1.setVisible(false);
        EditProfileC1.setVisible(false);
    }
    
    private void initializeCardLayout() {
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        
        contentPanel.add(BGPanel, "MAIN_PROFILE");
        contentPanel.add(new ScheduleScreen(this), "SCHEDULE");
        contentPanel.add(new FacultyEvaluationScreen(this, profileData.getStudentId()), "EVALUATION");
        contentPanel.add(new GradesScreen(this), "GRADES");
        
        getContentPane().add(contentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));
        cardLayout.show(contentPanel, "MAIN_PROFILE");
    }
    
    public void showPanel(String panelName) {
        cardLayout.show(contentPanel, panelName);
    }
    
    public void showMainProfile() {
        cardLayout.show(contentPanel, "MAIN_PROFILE");
        updateProfile();
    }

    private void loadStudentData() {
        if (loggedInStudentId == null) {
        logger.severe("No student logged in!");
        JOptionPane.showMessageDialog(this, 
            "Please login first.", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
        return;
        }

        String[] studentData = StudentManager.getStudent(loggedInStudentId);  // ✅ Changed here

        if (studentData != null && studentData.length >= 9) {
            profileData = StudentProfileData.fromArray(studentData); 
        } else {
            logger.warning("Student data not found.");
            profileData = new StudentProfileData(
                loggedInStudentId, 
                "Unknown Student", 
                "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A"
            );
        }
    }
    
    public void refreshStudentData() {
        loadStudentData();
        updateProfile();
    }
    
    private void updateProfile() {
        Name.setText(profileData.getStudentName());
        ID.setText(profileData.getStudentId());
        Course.setText(profileData.getStudentCourse());
        Year.setText(profileData.getStudentYear());
        College.setText(profileData.getStudentCollege());
        Department.setText(profileData.getStudentDepartment());
        Email.setText(profileData.getStudentEmail());
        City.setText(profileData.getStudentCity());
        Status.setText(profileData.getStudentStatus()); 
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
    
    private void loadAndDisplayPicture() {
        String studentId = profileData.getStudentId();
        profilePicturePath = ProfilePictureManager.loadProfilePath(studentId);

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

        showDefaultImage();
    }
    
    public void setProfilePicturePath(String path) {
        this.profilePicturePath = path;
        ProfilePictureManager.saveProfilePath(profileData.getStudentId(), path);

        ImageIcon icon = ProfilePictureManager.loadAndScaleImage(path, 140, 130);
        if (icon != null) {
            ProfilePicLabel.setIcon(icon);
            ProfilePicLabel.setBorder(BorderFactory.createLineBorder(new Color(61, 31, 92), 3));
            ProfilePicLabel.setVisible(true);
            EmptyProfile.setVisible(false);
        }
    }
    
    public String getStudentId() {
        return profileData.getStudentId();
    }
    
    @Override
    public String getProfileId() {
        return profileData.getStudentId();
    }

    @Override
    public String getUserType() {
        return "student";
    }
    
    public String getStudentName() {
        return profileData.getStudentName();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGPanel = new javax.swing.JPanel();
        Status = new javax.swing.JLabel();
        ProfilePicLabel = new javax.swing.JLabel();
        EmptyProfile = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        Course = new javax.swing.JLabel();
        Year = new javax.swing.JLabel();
        College = new javax.swing.JLabel();
        Department = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        City = new javax.swing.JLabel();
        EditProfileC = new javax.swing.JButton();
        LogoutC = new javax.swing.JButton();
        PasswordC = new javax.swing.JButton();
        GradesC = new javax.swing.JButton();
        EvaluationC = new javax.swing.JButton();
        ScheduleC = new javax.swing.JButton();
        PasswordC1 = new javax.swing.JButton();
        EvaluationC1 = new javax.swing.JButton();
        ScheduleC1 = new javax.swing.JButton();
        GradesC1 = new javax.swing.JButton();
        EditProfileC1 = new javax.swing.JButton();
        LogoutC1 = new javax.swing.JButton();
        BGLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BGPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Status.setFont(new java.awt.Font("Product Sans", 1, 15)); // NOI18N
        Status.setForeground(new java.awt.Color(222, 191, 238));
        Status.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        BGPanel.add(Status, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 92, 340, 20));
        BGPanel.add(ProfilePicLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 140, 130));

        EmptyProfile.setBackground(new java.awt.Color(46, 20, 72));
        EmptyProfile.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        EmptyProfile.setForeground(new java.awt.Color(242, 216, 255));
        EmptyProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EmptyProfile.setOpaque(true);
        BGPanel.add(EmptyProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 140, 130));

        Name.setFont(new java.awt.Font("Product Sans", 1, 13)); // NOI18N
        Name.setForeground(new java.awt.Color(46, 20, 72));
        Name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BGPanel.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 118, 340, 20));

        ID.setFont(new java.awt.Font("Product Sans", 1, 13)); // NOI18N
        ID.setForeground(new java.awt.Color(46, 20, 72));
        ID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BGPanel.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 135, 340, 20));

        Course.setFont(new java.awt.Font("Product Sans", 1, 13)); // NOI18N
        Course.setForeground(new java.awt.Color(46, 20, 72));
        Course.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BGPanel.add(Course, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 152, 340, 20));

        Year.setFont(new java.awt.Font("Product Sans", 1, 13)); // NOI18N
        Year.setForeground(new java.awt.Color(46, 20, 72));
        Year.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BGPanel.add(Year, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 169, 340, 20));

        College.setFont(new java.awt.Font("Product Sans", 1, 13)); // NOI18N
        College.setForeground(new java.awt.Color(46, 20, 72));
        College.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BGPanel.add(College, new org.netbeans.lib.awtextra.AbsoluteConstraints(614, 118, 340, 20));

        Department.setFont(new java.awt.Font("Product Sans", 1, 13)); // NOI18N
        Department.setForeground(new java.awt.Color(46, 20, 72));
        Department.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BGPanel.add(Department, new org.netbeans.lib.awtextra.AbsoluteConstraints(614, 135, 340, 20));

        Email.setFont(new java.awt.Font("Product Sans", 1, 13)); // NOI18N
        Email.setForeground(new java.awt.Color(46, 20, 72));
        Email.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BGPanel.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(614, 152, 340, 20));

        City.setFont(new java.awt.Font("Product Sans", 1, 13)); // NOI18N
        City.setForeground(new java.awt.Color(46, 20, 72));
        City.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BGPanel.add(City, new org.netbeans.lib.awtextra.AbsoluteConstraints(614, 169, 340, 20));

        EditProfileC.setBorderPainted(false);
        EditProfileC.setContentAreaFilled(false);
        EditProfileC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EditProfileC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditProfileCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EditProfileCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EditProfileCMouseExited(evt);
            }
        });
        BGPanel.add(EditProfileC, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 560, 100, 30));

        LogoutC.setBorderPainted(false);
        LogoutC.setContentAreaFilled(false);
        LogoutC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogoutC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LogoutCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LogoutCMouseExited(evt);
            }
        });
        BGPanel.add(LogoutC, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, 110, 30));

        PasswordC.setBorderPainted(false);
        PasswordC.setContentAreaFilled(false);
        PasswordC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PasswordC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PasswordCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PasswordCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PasswordCMouseExited(evt);
            }
        });
        BGPanel.add(PasswordC, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, 390, 140));

        GradesC.setBorderPainted(false);
        GradesC.setContentAreaFilled(false);
        GradesC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GradesC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GradesCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GradesCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GradesCMouseExited(evt);
            }
        });
        BGPanel.add(GradesC, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 390, 140));

        EvaluationC.setBorderPainted(false);
        EvaluationC.setContentAreaFilled(false);
        EvaluationC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EvaluationC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EvaluationCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EvaluationCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EvaluationCMouseExited(evt);
            }
        });
        BGPanel.add(EvaluationC, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 390, 140));

        ScheduleC.setBorderPainted(false);
        ScheduleC.setContentAreaFilled(false);
        ScheduleC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ScheduleC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ScheduleCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ScheduleCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ScheduleCMouseExited(evt);
            }
        });
        BGPanel.add(ScheduleC, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 390, 140));

        PasswordC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PasswordC1.png"))); // NOI18N
        PasswordC1.setBorderPainted(false);
        PasswordC1.setContentAreaFilled(false);
        PasswordC1.setMaximumSize(new java.awt.Dimension(438, 202));
        PasswordC1.setMinimumSize(new java.awt.Dimension(438, 202));
        BGPanel.add(PasswordC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 397, 400, 150));

        EvaluationC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EvaluationC1.png"))); // NOI18N
        EvaluationC1.setBorderPainted(false);
        EvaluationC1.setContentAreaFilled(false);
        BGPanel.add(EvaluationC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, 410, 170));

        ScheduleC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ScheduleC1.png"))); // NOI18N
        ScheduleC1.setBorderPainted(false);
        ScheduleC1.setContentAreaFilled(false);
        ScheduleC1.setMaximumSize(new java.awt.Dimension(438, 202));
        ScheduleC1.setMinimumSize(new java.awt.Dimension(438, 202));
        BGPanel.add(ScheduleC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 400, 160));

        GradesC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GradesC1.png"))); // NOI18N
        GradesC1.setAlignmentY(0.0F);
        GradesC1.setBorderPainted(false);
        GradesC1.setContentAreaFilled(false);
        GradesC1.setMaximumSize(new java.awt.Dimension(438, 202));
        GradesC1.setMinimumSize(new java.awt.Dimension(438, 202));
        GradesC1.addActionListener(this::GradesC1ActionPerformed);
        BGPanel.add(GradesC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 397, 410, 150));

        EditProfileC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EditProfileC1.png"))); // NOI18N
        EditProfileC1.setBorderPainted(false);
        EditProfileC1.setContentAreaFilled(false);
        EditProfileC1.setMaximumSize(new java.awt.Dimension(438, 202));
        EditProfileC1.setMinimumSize(new java.awt.Dimension(438, 202));
        BGPanel.add(EditProfileC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 550, 120, 50));

        LogoutC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LogoutC1.png"))); // NOI18N
        LogoutC1.setBorderPainted(false);
        LogoutC1.setContentAreaFilled(false);
        LogoutC1.setMaximumSize(new java.awt.Dimension(438, 202));
        LogoutC1.setMinimumSize(new java.awt.Dimension(438, 202));
        BGPanel.add(LogoutC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 120, 40));

        BGLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/StudentProfileMain.png"))); // NOI18N
        BGPanel.add(BGLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(BGPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ScheduleCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScheduleCMouseEntered
        ScheduleC1.setVisible(true); ; 
    }//GEN-LAST:event_ScheduleCMouseEntered

    private void ScheduleCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScheduleCMouseExited
       ScheduleC1.setVisible(false);  
    }//GEN-LAST:event_ScheduleCMouseExited

    private void EvaluationCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvaluationCMouseClicked
        showPanel("EVALUATION");
    }//GEN-LAST:event_EvaluationCMouseClicked

    private void EvaluationCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvaluationCMouseEntered
        EvaluationC1.setVisible(true);
    }//GEN-LAST:event_EvaluationCMouseEntered

    private void EvaluationCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvaluationCMouseExited
        EvaluationC1.setVisible(false);
    }//GEN-LAST:event_EvaluationCMouseExited

    private void GradesCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GradesCMouseClicked
        showPanel("GRADES");
    }//GEN-LAST:event_GradesCMouseClicked

    private void GradesCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GradesCMouseEntered
       GradesC1.setVisible(true);
    }//GEN-LAST:event_GradesCMouseEntered

    private void GradesCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GradesCMouseExited
        GradesC1.setVisible(false);
    }//GEN-LAST:event_GradesCMouseExited

    private void PasswordCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PasswordCMouseClicked
        ChangePassword changePassWindow = new ChangePassword(profileData.getStudentId());
        changePassWindow.setVisible(true);
    }//GEN-LAST:event_PasswordCMouseClicked

    private void PasswordCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PasswordCMouseEntered
        PasswordC1.setVisible(true);    
    }//GEN-LAST:event_PasswordCMouseEntered

    private void PasswordCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PasswordCMouseExited
        PasswordC1.setVisible(false);
    }//GEN-LAST:event_PasswordCMouseExited

    private void LogoutCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutCMouseClicked
        new Logout(this).setVisible(true);
    }//GEN-LAST:event_LogoutCMouseClicked

    private void LogoutCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutCMouseEntered
       LogoutC1.setVisible(true);
    }//GEN-LAST:event_LogoutCMouseEntered

    private void LogoutCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutCMouseExited
        LogoutC1.setVisible(false);
    }//GEN-LAST:event_LogoutCMouseExited

    private void ScheduleCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScheduleCMouseClicked
        showPanel("SCHEDULE");
    }//GEN-LAST:event_ScheduleCMouseClicked

    private void EditProfileCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditProfileCMouseClicked
        EditProfile editFrame = new EditProfile(this, ProfilePicLabel, profilePicturePath);
        editFrame.setVisible(true);
    }//GEN-LAST:event_EditProfileCMouseClicked

    private void EditProfileCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditProfileCMouseEntered
        EditProfileC1.setVisible(true);
    }//GEN-LAST:event_EditProfileCMouseEntered

    private void EditProfileCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditProfileCMouseExited
        EditProfileC1.setVisible(false);
    }//GEN-LAST:event_EditProfileCMouseExited

    private void GradesC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GradesC1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GradesC1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGLabel;
    private javax.swing.JPanel BGPanel;
    private javax.swing.JLabel City;
    private javax.swing.JLabel College;
    private javax.swing.JLabel Course;
    private javax.swing.JLabel Department;
    private javax.swing.JButton EditProfileC;
    private javax.swing.JButton EditProfileC1;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel EmptyProfile;
    private javax.swing.JButton EvaluationC;
    private javax.swing.JButton EvaluationC1;
    private javax.swing.JButton GradesC;
    private javax.swing.JButton GradesC1;
    private javax.swing.JLabel ID;
    private javax.swing.JButton LogoutC;
    private javax.swing.JButton LogoutC1;
    private javax.swing.JLabel Name;
    private javax.swing.JButton PasswordC;
    private javax.swing.JButton PasswordC1;
    private javax.swing.JLabel ProfilePicLabel;
    private javax.swing.JButton ScheduleC;
    private javax.swing.JButton ScheduleC1;
    private javax.swing.JLabel Status;
    private javax.swing.JLabel Year;
    // End of variables declaration//GEN-END:variables
}
