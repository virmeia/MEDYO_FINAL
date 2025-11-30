package com.udj.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginCheck {

    // MUST match the path used in AccountManager
    private static final String CREDENTIALS_FILE_PATH = "src/main/resources/data/LoginCredentials.txt";

    public static User validateLogin(String inputId, String inputPassword) {
        // Use FileReader to read the LIVE file, not the cached build file
        try (BufferedReader br = new BufferedReader(new FileReader(CREDENTIALS_FILE_PATH))) {
            
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                
                // We expect 3 columns: ID, Password, Role
                if (parts.length >= 3) {
                    String fileId = parts[0].trim();       // ID acts as Username
                    String filePassword = parts[1].trim(); 
                    String role = parts[2].trim();         

                    if (fileId.equals(inputId) && filePassword.equals(inputPassword)) {
                        switch (role.toUpperCase()) {
                            case "STUDENT" -> { return new Student(inputId, inputPassword); }
                            case "TEACHER" -> { return new Teacher(inputId, inputPassword); }
                            case "ADMIN"   -> { return new Admin(inputId, inputPassword); }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; 
    }
}