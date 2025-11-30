package com.udj.logic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AdminManager {

    private static final String ADMIN_FILE = "src/main/resources/data/AdminsData.txt";
    
    private static final String DELIMITER = "\\|"; 
    private static final String SEPARATOR = "|"; 
    
    public static boolean saveAdmin(String id, String name, String email, String contact) {
        try {
            File file = new File(ADMIN_FILE);
            file.getParentFile().mkdirs();

            if (adminIDExists(id)) {
                return false; 
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            
            bw.write(id + SEPARATOR + name + SEPARATOR + email + SEPARATOR + contact);
            
            bw.newLine();
            bw.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean adminIDExists(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader(ADMIN_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(id + SEPARATOR)) {
                    return true;
                }
            }
        } catch (Exception e) {}
        return false;
    }
 
    public static String[] getAdmin(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader(ADMIN_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(DELIMITER);
                if (data.length > 0 && data[0].equals(id)) {
                    return data;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<String[]> getAllAdmins() {
        List<String[]> admins = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ADMIN_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(DELIMITER);
                if (data.length >= 4) {
                    admins.add(data);
                }
            }
        } catch (Exception e) {}
        return admins;
    }
    
}