package com.udj.logic;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class StudentManager {

    private static final String STUDENT_FILE = "src/main/resources/data/StudentsData.txt";
    private static final String DELIMITER = "\\|";
    private static final String SEPARATOR = "|";  

    public static String generateStudentID() {
        String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)).substring(2);
        int nextNumber = 1;

        try (BufferedReader br = new BufferedReader(new FileReader(STUDENT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(DELIMITER);
                if (parts.length > 0 && parts[0].startsWith("UDJ-" + year)) {
                    String[] idParts = parts[0].split("-");
                    int num = Integer.parseInt(idParts[2]);
                    if (num >= nextNumber) {
                        nextNumber = num + 1;
                    }
                }
            }
        } catch (Exception e) {}
        String numberFormatted = String.format("%04d", nextNumber);
        return "UDJ-" + year + "-" + numberFormatted;
    }

    public static boolean studentIDExists(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader(STUDENT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(id + SEPARATOR)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean saveStudent(String id, String name, String program,
                                      String department, String college, String yearLevel,
                                      String status, String email, String city, String block) {
        try {
            File file = new File(STUDENT_FILE);
            if (!file.getParentFile().exists()) file.getParentFile().mkdirs();

            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            
            bw.write(id + SEPARATOR + name + SEPARATOR + program + SEPARATOR + department + SEPARATOR +
                     college + SEPARATOR + yearLevel + SEPARATOR + status + SEPARATOR + email + SEPARATOR + 
                     city + SEPARATOR + block);
            
            bw.newLine();
            bw.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static List<String[]> getAllStudents() {
        List<String[]> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(STUDENT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                
                String[] data = line.split(DELIMITER);
                
                if (data.length >= 10) {
                    students.add(data);
                } 
                else if (data.length == 9) {
                    String[] fixedData = new String[10];
                    System.arraycopy(data, 0, fixedData, 0, 9);
                    fixedData[9] = "N/A"; 
                    students.add(fixedData);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
    
    public static String[] getStudent(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader(STUDENT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(DELIMITER);
                if (data.length > 0 && data[0].equals(id)) {
                    if (data.length == 9) {
                        String[] fixedData = new String[10];
                        System.arraycopy(data, 0, fixedData, 0, 9);
                        fixedData[9] = "N/A";
                        return fixedData;
                    }
                    return data;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static String getStudentBlock(String id) {
        String[] student = getStudent(id);
        if (student != null && student.length >= 10) {
            return student[9];
        }
        return null;
    }
    
     public static String getProgramCode(String fullName) {
        if (fullName == null) return "UNK";
        return switch (fullName.trim()) {
            case "Bachelor of Science in Information Technology" -> "BSIT";
            case "Bachelor of Science in Computer Science" -> "BSCS";
            case "Bachelor of Science in Information System" -> "BSIS";
            case "Bachelor of Science in Environmental Science" -> "BSES";
            case "Bachelor of Applied Science in Laboratory Technology" -> "BASLT";
            case "Bachelor of Science in Civil Engineering" -> "BSCE";
            case "Bachelor of Science in Electrical Engineering" -> "BSEE";
            case "Bachelor of Science in Electronics Engineering" -> "BSECE";
            case "Bachelor of Science in Mechanical Engineering" -> "BSME";
            case "Bachelor of Science in Entrepreneurship Management" -> "BSEntrep";
            case "Bachelor of Science in Hospitality Management" -> "BSHM";
            default -> "GEN";
        };
    }
    
    public static boolean updateStudent(String originalId, String newName, String program,
                                      String department, String college, String yearLevel,
                                      String status, String email, String city, String block) {
        List<String> lines = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(STUDENT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(DELIMITER);
                
                if (data.length > 0 && data[0].equals(originalId)) {
                    String newLine = originalId + SEPARATOR + newName + SEPARATOR + program + SEPARATOR + department + SEPARATOR +
                                     college + SEPARATOR + yearLevel + SEPARATOR + status + SEPARATOR + email + SEPARATOR + 
                                     city + SEPARATOR + block;
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

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(STUDENT_FILE))) {
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

    public static boolean deleteStudent(String id) {
        List<String> lines = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(STUDENT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(DELIMITER);
                
                if (data.length > 0 && data[0].trim().equals(id.trim())) {
                    found = true; 
                } else {
                    lines.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        if (found) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(STUDENT_FILE))) {
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
}