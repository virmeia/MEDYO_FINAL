package com.udj.logic;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import javax.swing.JComboBox;

public class ScheduleUtils {
    
    private static final String STUDENT_FILE = "src/main/resources/data/StudentsData.txt";
    private static final String COURSE_FILE = "src/main/resources/data/Courses.txt";
    private static final String FACULTY_FILE = "src/main/resources/data/FacultysData.txt";

    public static final String[] DAYS = { "- Select Day -", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
    
    public static final String[] TIME_HOURS = { 
        "- Select Time -", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", 
        "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00" 
    };

    public static void loadInstructorsByDept(JComboBox<String> cbInstructor, String targetDept) {
        Vector<String> items = new Vector<>();
        items.add("- Select Instructor -");

        if (Files.exists(Paths.get(FACULTY_FILE))) {
            try (BufferedReader br = new BufferedReader(new FileReader(FACULTY_FILE))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split("\\|");

                    if (data.length > 2) {
                        String name = data[1].trim();
                        String dept = data[2].trim(); 

                        boolean isMatch = dept.toUpperCase().contains(targetDept.toUpperCase());

                        if (targetDept.equalsIgnoreCase("ALL")) {
                            isMatch = true; 
                        }

                        if (isMatch) {
                            if (name.endsWith(",")) name = name.substring(0, name.length() - 1);
                            items.add(name);
                        }
                    }
                }
            } catch (IOException e) {}
        }

        if (items.size() > 1) {
            Collections.sort(items.subList(1, items.size()));
        }
        cbInstructor.setModel(new javax.swing.DefaultComboBoxModel<>(items));
    }
    
    public static String getCourseDept(String courseCode) {
        List<String[]> courses = CourseManager.getAllCourses();
        for (String[] c : courses) {
            if (c[0].equalsIgnoreCase(courseCode)) {
                return c[3]; 
            }
        }
        return "";
    }

    public static void loadBlocksFromStudentData(JComboBox<String> cbBlock) {
        Set<String> uniqueBlocks = new HashSet<>();
        if (Files.exists(Paths.get(STUDENT_FILE))) {
            try (BufferedReader br = new BufferedReader(new FileReader(STUDENT_FILE))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split("\\|"); 
                    if (data.length > 0) uniqueBlocks.add(data[data.length - 1].trim());
                }
            } catch (IOException e) {}
        }
        Vector<String> items = new Vector<>();
        items.add("- Select Block -");
        items.addAll(uniqueBlocks.stream().sorted().toList());
        cbBlock.setModel(new javax.swing.DefaultComboBoxModel<>(items));
    }

    public static void loadCourseCodes(JComboBox<String> cbCourse) {
        Vector<String> items = new Vector<>();
        items.add("- Select Course -");
        if (Files.exists(Paths.get(COURSE_FILE))) {
            try (BufferedReader br = new BufferedReader(new FileReader(COURSE_FILE))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length > 0) items.add(data[0].trim());
                }
            } catch (IOException e) {}
        }
        cbCourse.setModel(new javax.swing.DefaultComboBoxModel<>(items));
    }

    public static String getCourseDescription(String courseCode) {
        List<String[]> courses = CourseManager.getAllCourses();
        for (String[] course : courses) {
            if (course.length > 1 && course[0].equalsIgnoreCase(courseCode)) {
                return course[1]; 
            }
        }
        return ""; 
    }

    private static String getDeptFromPrefix(String prefix) {
        return switch (prefix.toUpperCase()) {
            case "BSCS", "BSIT" -> "Computer Studies";
            case "BSCE", "BSEE", "BSME" -> "Engineering";
            case "BSCHEM" -> "Chemistry";
            case "BSHM", "BSBA" -> "Management";
            default -> "ALL";
        };
    }

    private static String getYearFromSuffix(String suffix) {
        return switch (suffix) {
            case "1" -> "First Year";
            case "2" -> "Second Year";
            case "3" -> "Third Year";
            case "4" -> "Fourth Year";
            default -> "All";
        };
    }
    
    public static void filterCoursesByBlock(JComboBox<String> cbCourse, String blockName) {
        cbCourse.removeAllItems();
        cbCourse.addItem("- Select Course -");

        if (blockName == null || blockName.startsWith("-")) return; 

        String targetDept = "ALL";
        String targetYear = "All";

        if (blockName.contains("-")) {
            String[] parts = blockName.split("-");
            if (parts.length >= 2) {
                targetDept = getDeptFromPrefix(parts[0]); 
                targetYear = getYearFromSuffix(parts[parts.length-1]); 
            }
        }

        List<String[]> courses = CourseManager.getAllCourses(); 
        
        for (String[] c : courses) {
            if (c.length < 5) continue; 

            String cDept = c[3];
            String cYear = c[4];

            boolean isDeptMatch = cDept.equalsIgnoreCase(targetDept) || cDept.equalsIgnoreCase("ALL");
            boolean isYearMatch = cYear.equalsIgnoreCase(targetYear) || cYear.equalsIgnoreCase("ALL");

            if (isDeptMatch && isYearMatch) {
                cbCourse.addItem(c[0]); 
            }
        }
    }    
}