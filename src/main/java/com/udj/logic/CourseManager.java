package com.udj.logic;

import java.io.*;
import java.util. ArrayList;
import java.util. List;

public class CourseManager {
    private static final String COURSE_FILE = "src/main/resources/data/Courses.txt";

    public static List<String[]> getAllCourses() {
        List<String[]> list = new ArrayList<>();
        File file = new File(COURSE_FILE);
        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] data = line.split(",");
                if (data.length >= 4) {
                    String[] row = new String[6];
                    row[0] = data[0]. trim();  
                    row[1] = data[1].trim(); 
                    row[2] = data[2].trim();  
                    row[3] = data[3].trim();  
                    row[4] = data. length > 4 ? data[4].trim() : "All";  
                    row[5] = data.length > 5 ? data[5].trim() : "Any"; 
                    list.add(row);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean addCourse(String code, String desc, String units, String dept, 
                                   String yearLevel, String semester) {
        if (code. contains(",") || desc.contains(",") || units.contains(",")) return false;
        if (isCourseExists(code)) return false;

        try {
            File file = new File(COURSE_FILE);
            if (! file.getParentFile().exists()) file.getParentFile().mkdirs();

            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(code + "," + desc + "," + units + "," + dept + "," + yearLevel + "," + semester);
            bw.newLine();
            bw.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean updateCourse(String targetCode, String newDesc, String newUnits, 
                                       String newDept, String yearLevel, String semester) {
        List<String> lines = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(COURSE_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length > 0 && data[0]. equals(targetCode)) {
                    lines.add(targetCode + "," + newDesc + "," + newUnits + "," + newDept + "," + yearLevel + "," + semester);
                    found = true;
                } else {
                    lines.add(line);
                }
            }
        } catch (Exception e) { 
            return false; 
        }

        if (found) {
            return rewriteFile(lines);
        }
        return false;
    }

    public static boolean deleteCourse(String targetCode) {
        List<String> lines = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(COURSE_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length > 0 && data[0].equals(targetCode)) {
                    found = true;
                } else {
                    lines.add(line);
                }
            }
        } catch (Exception e) { 
            return false; 
        }

        return found && rewriteFile(lines);
    }

    private static boolean isCourseExists(String code) {
        for (String[] c : getAllCourses()) {
            if (c[0].equalsIgnoreCase(code)) return true;
        }
        return false;
    }

    private static boolean rewriteFile(List<String> lines) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(COURSE_FILE))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}