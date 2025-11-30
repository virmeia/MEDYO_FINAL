package com.udj.logic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Properties;
import java.util.logging.Logger;

public class ProfilePictureManager {
    private static final Logger logger = Logger.getLogger(ProfilePictureManager.class.getName());
    private static final String PROFILE_PATHS_FILE = "src/main/resources/data/ProfilePicturePaths.properties";
    private static final String DEFAULT_PROFILE_IMAGE = "images/default_image.png";
    
    public static boolean saveProfilePath(String studentId, String imagePath) {
        Properties props = loadAllProfilePaths();
        props.setProperty(studentId, imagePath);
        
        try (OutputStream output = new FileOutputStream(PROFILE_PATHS_FILE)) {
            props.store(output, "Student Profile Picture Paths");
            logger.info("Successfully saved path for student ID: " + studentId);
            return true;
        } catch (IOException ex) {
            logger.severe("Failed to save profile path for " + studentId + ": " + ex.getMessage());
            return false;
        }
    }
    
    public static String loadProfilePath(String studentId) {
        Properties props = loadAllProfilePaths();
        String path = props.getProperty(studentId);
        
        if (path != null) {
            return path;
        } else {
            return DEFAULT_PROFILE_IMAGE;
        }
    }
    
    private static Properties loadAllProfilePaths() {
        Properties props = new Properties();
        File file = new File(PROFILE_PATHS_FILE);
        
        if (file.exists()) {
            try (InputStream input = new FileInputStream(file)) {
                props.load(input);
            } catch (IOException ex) {
                logger.severe("Error loading profile paths file: " + ex.getMessage());
            }
        } else {
            logger.info("Profile paths file does not exist, starting fresh.");
        }
        
        return props;
    }
    
    public static ImageIcon loadAndScaleImage(String imagePath, int width, int height) {
        if (imagePath == null || imagePath.isEmpty()) {
            imagePath = DEFAULT_PROFILE_IMAGE;
            logger.info("No image path provided, using default profile image");
        }
        
        try {
            File file = new File(imagePath);

            if (!file.exists() || file.length() == 0) {
                logger.warning("Profile picture file does not exist or is empty: " + imagePath);
                
                if (!imagePath.equals(DEFAULT_PROFILE_IMAGE)) {
                    logger.info("Attempting to load default profile image");
                    file = new File(DEFAULT_PROFILE_IMAGE);
                    
                    if (!file.exists()) {
                        logger.severe("Default profile image not found at: " + DEFAULT_PROFILE_IMAGE);
                        return null;
                    }
                } else {
                    return null;
                }
            }
            
            BufferedImage img = ImageIO.read(file);
            if (img == null) {
                logger.warning("Failed to read image from: " + imagePath);
                return null;
            }
            
            Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImg);
            
        } catch (IOException e) {
            logger.severe("Failed to load profile picture: " + e.getMessage());
            
            try {
                File defaultFile = new File(DEFAULT_PROFILE_IMAGE);
                if (defaultFile.exists()) {
                    BufferedImage defaultImg = ImageIO.read(defaultFile);
                    if (defaultImg != null) {
                        Image scaledImg = defaultImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                        return new ImageIcon(scaledImg);
                    }
                }
            } catch (IOException ex) {
                logger.severe("Failed to load default profile picture: " + ex.getMessage());
            }
            
            return null;
        }
    }
}
