package com.udj.logic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FacultyManager {

    private static final String FACULTY_FILE = "src/main/resources/data/FacultysData.txt";
    private static final String SEPARATOR = "|"; 
    
    public static String generateFacultyID() {
        int nextNumber = 1;

        try (BufferedReader br = new BufferedReader(new FileReader(FACULTY_FILE))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length > 0 && parts[0].startsWith("UDJ-T-")) {
                    String[] idParts = parts[0].split("-");
                    if (idParts.length >= 3) {
                        try {
                            int num = Integer.parseInt(idParts[2]);
                            if (num >= nextNumber) {
                                nextNumber = num + 1;
                            }
                        } catch (NumberFormatException e) {
                            // Ignore lines with malformed IDs
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String numberFormatted = String.format("%04d", nextNumber);
        return "UDJ-T-" + numberFormatted;
    }

    public static boolean facultyIDExists(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader(FACULTY_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Check with the new separator to ensure exact match
                if (line.startsWith(id + SEPARATOR)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean saveFaculty(String id, String name, String department,
                                      String employmentType, String college, String email, String city) {
        try {
            File file = new File(FACULTY_FILE);
            System.out.println("Trying to save to: " + file.getAbsolutePath());

            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            // Save using " | " separator
            bw.write(id + SEPARATOR + name + SEPARATOR + department + SEPARATOR + 
                     employmentType + SEPARATOR + college + SEPARATOR + email + SEPARATOR + city);
            bw.newLine();
            bw.close();

            System.out.println("Faculty save successful!");
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public static List<String[]> getAllFaculty() {
        List<String[]> faculty = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FACULTY_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length >= 5) {
                    faculty.add(data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return faculty;
    }
    
    public static String[] getFaculty(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader(FACULTY_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length > 0 && data[0].equals(id)) {
                    return data;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean updateFaculty(String originalId, String newName, String department,
                                      String employmentType, String college, String email, String city) {
        List<String> lines = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(FACULTY_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length > 0 && data[0].equals(originalId)) {
                    String newLine = originalId + SEPARATOR + newName + SEPARATOR + department + SEPARATOR +
                                     employmentType + SEPARATOR + college + SEPARATOR + email + SEPARATOR + city;
                    lines.add(newLine);
                    found = true;
                } else {
                    lines.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        if (!found) return false;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FACULTY_FILE))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // DELETE FACULTY
    public static boolean deleteFaculty(String id) {
        List<String> lines = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(FACULTY_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length > 0 && data[0].trim().equals(id.trim())) {
                    found = true; 
                    System.out.println("DEBUG: Deleting Faculty ID: " + id);
                } else {
                    lines.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        if (found) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FACULTY_FILE))) {
                for (String line : lines) {
                    bw.write(line);
                    bw.newLine();
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
    
    public static int getFacultyCountByCollege(String college) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(FACULTY_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length >= 5 && data[4].equals(college)) {
                    count++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public static List<String[]> searchFaculty(String searchTerm) {
        List<String[]> results = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FACULTY_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" \\| ");
                if (data.length >= 2) { 
                    String id = data[0].toLowerCase();
                    String name = data[1].toLowerCase();
                    String search = searchTerm.toLowerCase();
                    
                    if (id.contains(search) || name.contains(search)) {
                        results.add(data);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }
}