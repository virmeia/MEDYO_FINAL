package com.udj.logic;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ScheduleManager {

    private static final String FILE_PATH = "src/main/resources/data/Schedules.txt"; 
    private static final String FACULTY_FILE = "src/main/resources/data/FacultysData.txt";
    private static final String COURSE_FILE = "src/main/resources/data/Courses.txt";
    
    // CHANGE: Use Pipe instead of Comma
    private static final String DELIMITER = "\\|";  // For splitting (Regex)
    private static final String WRITE_SEP = "|";    // For writing
    private static final int MAX_SUBJECTS_PER_BLOCK = 8; 

    public static List<String[]> getAllSchedules() {
        List<String[]> schedules = new ArrayList<>();
        Path path = Paths.get(FILE_PATH);

        if (!Files.exists(path)) {
            try { Files.createDirectories(path.getParent()); Files.createFile(path); } catch (IOException e) { return schedules; }
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] data = line.split(DELIMITER, -1);
                    if (data.length == 7) { 
                        schedules.add(data);
                    }
                }
            }
        } catch (IOException e) { e.printStackTrace(); }
        return schedules;
    }

    private static String getFacultyDepartment(String instructorName) {
        if (!Files.exists(Paths.get(FACULTY_FILE))) return "";
        try (BufferedReader br = new BufferedReader(new FileReader(FACULTY_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|"); 
                if (data.length > 2 && data[1].trim().equalsIgnoreCase(instructorName)) {
                    return data[2].trim(); 
                }
            }
        } catch (IOException e) {}
        return "";
    }

    private static String getCourseDepartment(String courseCode) {
        if (!Files.exists(Paths.get(COURSE_FILE))) return "";
        try (BufferedReader br = new BufferedReader(new FileReader(COURSE_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(","); 
                if (data.length > 3 && data[0].trim().equalsIgnoreCase(courseCode)) {
                    return data[3].trim(); 
                }
            }
        } catch (IOException e) {}
        return "";
    }

    public static String checkDepartmentMatch(String instructor, String courseCode) {
        String facultyDept = getFacultyDepartment(instructor);
        String courseDept = getCourseDepartment(courseCode);

        if (facultyDept.isEmpty() || courseDept.isEmpty() || instructor.equals("TBA")) {
            return null; 
        }

        boolean match = facultyDept.toUpperCase().contains(courseDept.toUpperCase());
        boolean isGenEd = courseDept.equalsIgnoreCase("ALL");

        if (!match && !isGenEd) {
            return "Restriction: " + instructor + " (" + facultyDept + ") cannot teach " + courseDept + " subjects.";
        }
        return null;
    }

    public static String checkConflicts(String block, String day, String start, String end, String instructor, String currentID) {
        List<String[]> schedules = getAllSchedules();
        
        long blockCount = schedules.stream()
                .filter(s -> s[1].equalsIgnoreCase(block) && !s[0].equals(currentID))
                .count();
        if (blockCount >= MAX_SUBJECTS_PER_BLOCK) return "Block Limit Reached (Max 8 Subjects).";

        for (String[] s : schedules) {
            if (s[0].equals(currentID)) continue; 

            if (s[3].equalsIgnoreCase(day)) {
                String existStart = s[4];
                String existEnd = s[5];

                boolean isOverlap = (start.compareTo(existEnd) < 0) && (end.compareTo(existStart) > 0);

                if (isOverlap) {
                    if (s[6].equalsIgnoreCase(instructor)) {
                        return "Conflict: Instructor " + instructor + " is already teaching at this time.";
                    }
                    if (s[1].equalsIgnoreCase(block)) {
                        return "Conflict: Block " + block + " already has a class at this time.";
                    }
                }
            }
        }
        return null;
    }

    public static boolean addSchedule(String block, String code, String day, String start, String end, String instructor) {
        String deptError = checkDepartmentMatch(instructor, code);
        if (deptError != null) {
            javax.swing.JOptionPane.showMessageDialog(null, deptError, "Department Restriction", javax.swing.JOptionPane.WARNING_MESSAGE);
            return false;
        }

        String error = checkConflicts(block, day, start, end, instructor, "NEW");
        if (error != null) {
            javax.swing.JOptionPane.showMessageDialog(null, error, "Schedule Conflict", javax.swing.JOptionPane.WARNING_MESSAGE);
            return false;
        }

        String id = generateSchedID();
        // CHANGED: Use WRITE_SEP (|) instead of DELIMITER
        String newRecord = String.join(WRITE_SEP, id, block, code, day, start, end, instructor);

        return writeLine(newRecord, true);
    }
    
    public static boolean updateSchedule(String id, String block, String code, String day, String start, String end, String instructor) {
        String deptError = checkDepartmentMatch(instructor, code);
        if (deptError != null) {
            javax.swing.JOptionPane.showMessageDialog(null, deptError, "Department Restriction", javax.swing.JOptionPane.WARNING_MESSAGE);
            return false;
        }

        String error = checkConflicts(block, day, start, end, instructor, id);
        if (error != null) {
            javax.swing.JOptionPane.showMessageDialog(null, error, "Schedule Conflict", javax.swing.JOptionPane.WARNING_MESSAGE);
            return false;
        }

        List<String[]> all = getAllSchedules();
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (String[] s : all) {
                if (s[0].equals(id)) {
                    // CHANGED: Use WRITE_SEP
                    pw.println(String.join(WRITE_SEP, id, block, code, day, start, end, instructor));
                } else {
                    // Re-join existing arrays using Pipe
                    pw.println(String.join(WRITE_SEP, s));
                }
            }
            return true;
        } catch (IOException e) { return false; }
    }

    public static boolean deleteSchedule(String id) {
        List<String[]> all = getAllSchedules();
        boolean found = false;
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (String[] s : all) {
                if (!s[0].equals(id)) {
                    pw.println(String.join(WRITE_SEP, s));
                } else {
                    found = true;
                }
            }
        } catch (IOException e) { return false; }
        return found;
    }

    public static String generateSchedID() {
        List<String[]> schedules = getAllSchedules();
        if (schedules.isEmpty()) return "SCD001";
        
        int maxId = 0;
        for (String[] s : schedules) {
            String id = s[0];
            if (id.startsWith("SCD")) {
                try {
                    int num = Integer.parseInt(id.substring(3)); 
                    if (num > maxId) maxId = num;
                } catch (NumberFormatException ignored) {}
            }
        }
        return String.format("SCD%03d", maxId + 1);
    }

    private static boolean writeLine(String record, boolean append) {
        try {
            File f = new File(FILE_PATH);
            if (!f.getParentFile().exists()) f.getParentFile().mkdirs();
            try (PrintWriter pw = new PrintWriter(new FileWriter(f, append))) {
                pw.println(record);
                return true;
            }
        } catch (IOException e) { return false; }
    }
}