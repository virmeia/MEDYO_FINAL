package com.udj.logic;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AccountManager {

    private static final String CREDENTIALS_FILE = "src/main/resources/data/LoginCredentials.txt";
    private static final String HISTORY_FILE = "src/main/resources/data/AccountActivityLogs.txt";
    private static final String STUDENT_FILE = "src/main/resources/data/StudentsData.txt"; 
    private static final String ADMIN_FILE = "src/main/resources/data/AdminsData.txt";

    public static boolean createAccount(String id, String username, String password, String role) {
        if (id.contains(",") || password.contains(",") || role.contains(",")) {
            return false;
        }

        if (idExists(id)) return false;

        try {
            File file = new File(CREDENTIALS_FILE);
            if (!file.getParentFile().exists()) file.getParentFile().mkdirs();

            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(id + "," + password + "," + role);
            bw.newLine();
            bw.close();
            
            logHistory(id, "Account Created");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteAccount(String id) {
        List<String> lines = new ArrayList<>();
        boolean found = false;
        
        try (BufferedReader br = new BufferedReader(new FileReader(CREDENTIALS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue; 

                String[] data = line.split(",");
                if (data.length > 0 && data[0].equals(id)) {
                    found = true;
                } else {
                    lines.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            return false; 
        } catch (Exception e) { 
            e.printStackTrace(); 
            return false; 
        }

        if (found) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(CREDENTIALS_FILE))) {
                for (String l : lines) { 
                    bw.write(l); 
                    bw.newLine(); 
                }
                logHistory(id, "Account Deleted");
                return true;
            } catch (Exception e) { return false; }
        }
        return false;
    }

    public static boolean resetPassword(String id, String newPassword) {
        if (newPassword.contains(",")) return false;

        List<String> lines = new ArrayList<>();
        boolean found = false;
        
        try (BufferedReader br = new BufferedReader(new FileReader(CREDENTIALS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] data = line.split(",");
                if (data.length >= 3 && data[0].equals(id)) {
                    lines.add(data[0] + "," + newPassword + "," + data[2]);
                    found = true;
                } else {
                    lines.add(line);
                }
            }
        } catch (Exception e) { return false; }

        if (found) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(CREDENTIALS_FILE))) {
                for (String l : lines) { 
                    bw.write(l); 
                    bw.newLine(); 
                }
                logHistory(id, "Password Reset");
                return true;
            } catch (Exception e) { return false; }
        }
        return false;
    }

    public static List<String[]> getAllAccounts() {
        List<String[]> accounts = new ArrayList<>();
        File file = new File(CREDENTIALS_FILE);
        
        if (!file.exists()) return accounts;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] data = line.split(",");
                if (data.length >= 3) {
                    accounts.add(new String[]{data[0], data[0], data[1], data[2]});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public static List<String[]> getPendingUsers() {
        List<String[]> pendingList = new ArrayList<>();
        Set<String> registeredIDs = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CREDENTIALS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] data = line.split(",");
                if (data.length > 0) registeredIDs.add(data[0]);
            }
        } catch (Exception e) {}

        List<String[]> students = StudentManager.getAllStudents();
        for (String[] s : students) {
            String id = s[0];
            String fullName = s[1]; 
            
            if (!registeredIDs.contains(id)) {
                String defaultPass = id; 
                if (fullName.contains(",")) {
                    defaultPass = fullName.split(",")[0].trim().replace(" ", "");
                }

                pendingList.add(new String[]{id, fullName, "STUDENT", defaultPass});
            }
        }
        
        return pendingList;
    }

    private static boolean idExists(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader(CREDENTIALS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] data = line.split(",");
                if (data.length > 0 && data[0].equals(id)) return true;
            }
        } catch (Exception e) {}
        return false;
    }

    public static void logHistory(String id, String action) {
        try {
            File file = new File(HISTORY_FILE);
            if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            bw.write(id + "," + action + "," + time);
            bw.newLine();
            bw.close();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static String getSurname(String targetID) {
        String[] filesToCheck = { STUDENT_FILE, ADMIN_FILE };
        
        for (String filePath : filesToCheck) {
            File file = new File(filePath);
            if (!file.exists()) continue;

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.trim().isEmpty()) continue;

                    String[] data = line.split("\\|"); 
                    
                    if (data.length > 1) {
                        String id = data[0].trim();
                        
                        if (id.equalsIgnoreCase(targetID)) {
                            String fullName = data[1].trim();
                            if (fullName.contains(",")) {
                                return fullName.split(",")[0].trim().replace(" ", "");
                            } else {
                                return fullName.trim().replace(" ", "");
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null; 
    }
}