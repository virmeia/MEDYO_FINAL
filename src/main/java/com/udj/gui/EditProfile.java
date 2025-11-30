package com.udj.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import javax.swing.UIManager;

public class EditProfile extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(EditProfile.class.getName());
    
    private UpdateProfile parentFrame;
    private JLabel ProfilePicLabel;
    private String tempProfilePicturePath;
    private static final int IMAGE_SIZE = 150;

    public EditProfile(UpdateProfile parent, JLabel picLabel, String currentPicPath) {
        this.parentFrame = parent;
        this.ProfilePicLabel = picLabel;
        this.tempProfilePicturePath = currentPicPath;
        
        initComponents();
        
        if (parent instanceof JFrame) {
            setLocationRelativeTo((JFrame) parent);
        } else {
            setLocationRelativeTo(null);
        }
        
        setAlwaysOnTop(true);
        
        UploadC1.setVisible(false);
        SaveC1.setVisible(false);
        
        if (parent instanceof JFrame) {
            ((JFrame) parent).setEnabled(false);
        }
        
        UIManager.put("OptionPane.background", new java.awt.Color(242, 216, 255));
        UIManager.put("Panel.background", new java.awt.Color(242, 216, 255));
        UIManager.put("OptionPane.messageForeground", new java.awt.Color(61, 31, 92));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGPanel = new javax.swing.JPanel();
        SaveC = new javax.swing.JButton();
        UploadC = new javax.swing.JButton();
        SaveC1 = new javax.swing.JButton();
        UploadC1 = new javax.swing.JButton();
        BGLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BGPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SaveC.setBorderPainted(false);
        SaveC.setContentAreaFilled(false);
        SaveC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SaveC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SaveCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SaveCMouseExited(evt);
            }
        });
        BGPanel.add(SaveC, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 130, 70, 30));

        UploadC.setBorderPainted(false);
        UploadC.setContentAreaFilled(false);
        UploadC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UploadC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UploadCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UploadCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UploadCMouseExited(evt);
            }
        });
        BGPanel.add(UploadC, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, 30));

        SaveC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SaveC1.png"))); // NOI18N
        SaveC1.setBorderPainted(false);
        SaveC1.setContentAreaFilled(false);
        BGPanel.add(SaveC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 133, 80, 30));

        UploadC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/UploadC1.png"))); // NOI18N
        UploadC1.setBorderPainted(false);
        UploadC1.setContentAreaFilled(false);
        BGPanel.add(UploadC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 132, 80, 30));

        BGLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EditProfileMain.png"))); // NOI18N
        BGPanel.add(BGLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 200));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BGPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BGPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UploadCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadCMouseClicked
        UploadC1.setVisible(true);
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Profile Picture");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
            "Image Files", "jpg", "jpeg", "png", "gif"));

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            if (loadAndDisplayPicture(selectedFile)) {
                tempProfilePicturePath = selectedFile.getAbsolutePath();
                JOptionPane.showMessageDialog(this, "Picture selected! Click SAVE to confirm.", "Preview Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_UploadCMouseClicked

    private void UploadCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadCMouseEntered
        UploadC1.setVisible(true);
    }//GEN-LAST:event_UploadCMouseEntered

    private void UploadCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadCMouseExited
        UploadC1.setVisible(false);
    }//GEN-LAST:event_UploadCMouseExited

    private void SaveCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveCMouseClicked
        SaveC1.setVisible(true);
        
        if (tempProfilePicturePath == null || tempProfilePicturePath.isEmpty()) {
         JOptionPane.showMessageDialog(this, 
             "Please upload a picture first!", 
             "No Picture", 
             JOptionPane.WARNING_MESSAGE);
         return;
        }
        
        String permanentPath = savePicturePermanently(tempProfilePicturePath);

        if (permanentPath != null) {
            parentFrame.setProfilePicturePath(permanentPath); 

            JOptionPane.showMessageDialog(this, 
                "Profile picture saved successfully!", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, 
                "Failed to save profile picture!", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SaveCMouseClicked

    private void SaveCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveCMouseEntered
        SaveC1.setVisible(true);
    }//GEN-LAST:event_SaveCMouseEntered

    private void SaveCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveCMouseExited
        SaveC1.setVisible(false);
    }//GEN-LAST:event_SaveCMouseExited
    
    private boolean loadAndDisplayPicture(File file) {
        try {
            BufferedImage img = ImageIO.read(file);

            if (img == null) {
                JOptionPane.showMessageDialog(this, 
                    "Could not read the selected file as an image.", 
                    "Load Error", 
                    JOptionPane.ERROR_MESSAGE);
                return false;
            }

            Image scaledImg = img.getScaledInstance(140, 130, Image.SCALE_SMOOTH);

            ProfilePicLabel.setIcon(new ImageIcon(scaledImg));
            ProfilePicLabel.setText("");
            ProfilePicLabel.setOpaque(false); 
            ProfilePicLabel.setBorder(BorderFactory.createLineBorder(new Color(61, 31, 92), 3));

            return true;

        } catch (IOException e) {
            System.err.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                "Error loading image: " + e.getMessage(), 
                "IO Error", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
   private String savePicturePermanently(String sourcePath) {
        if (sourcePath == null || sourcePath.isEmpty()) {
            return null; 
        }

        try {
            // Create separate folders for student and teacher profiles
            String userType = parentFrame.getUserType();
            File destDir = new File("images" + File.separator + "profile" + File.separator + userType);
            if (!destDir.exists()) {
                destDir.mkdirs();
            }

            File sourceFile = new File(sourcePath);
            if (!sourceFile.exists()) {
                return null;
            }

            // Use the profile ID from the parent frame
            String profileIdCleaned = parentFrame.getProfileId().replaceAll("[^a-zA-Z0-9-]", "_");

            String extension = "png";
            int dotIndex = sourceFile.getName().lastIndexOf('.');
            if (dotIndex > 0) {
                extension = sourceFile.getName().substring(dotIndex + 1);
            }

            String fileName = "profile_" + profileIdCleaned + "." + extension; 
            File destFile = new File(destDir, fileName);

            java.nio.file.Files.copy(
                sourceFile.toPath(), 
                destFile.toPath(), 
                java.nio.file.StandardCopyOption.REPLACE_EXISTING
            );
            
            return destFile.getAbsolutePath(); 

        } catch (IOException e) {
            logger.log(java.util.logging.Level.SEVERE, "Failed to save image permanently", e);
            JOptionPane.showMessageDialog(this, 
                "Error saving image: " + e.getMessage(), 
                "Save Error", 
                JOptionPane.ERROR_MESSAGE);

            return sourcePath; 
        }
    }
    
   @Override
   public void dispose() {
        if (parentFrame instanceof JFrame) {
            JFrame frame = (JFrame) parentFrame;
            if (frame.isDisplayable()) {
                frame.setEnabled(true);
                frame.toFront();
            }
        }
        super.dispose();
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGLabel;
    private javax.swing.JPanel BGPanel;
    private javax.swing.JButton SaveC;
    private javax.swing.JButton SaveC1;
    private javax.swing.JButton UploadC;
    private javax.swing.JButton UploadC1;
    // End of variables declaration//GEN-END:variables
}
