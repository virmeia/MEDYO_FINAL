package com.udj.logic;

import java.io.*;
import java.util.*;
import com.udj.gui.StudentProfileMain;

public class EvaluationManager {

    private static final String COURSES_FILE = "src/main/resources/data/Courses.txt";
    private static final String FACULTY_FILE = "src/main/resources/data/FacultysData.txt";
    private static final String SCHEDULE_FILE = "src/main/resources/data/Schedules.txt";
    private static final String STUDENT_FILE = "src/main/resources/data/StudentsData.txt";
    private static final String EVALUATION_FILE = "src/main/resources/data/EvaluationsData.txt";
    private static final String STUDENT_EVAL_TRACKING_FILE = "src/main/resources/data/EvaluationTracker.txt";
   
    public static List<String[]> getAllTeachersForEvaluation(String studentID) {
        List<String[]> evaluationData = new ArrayList<>();
    
        // Get the logged-in student's block
        String studentBlock = getStudentBlock(studentID);

        if (studentBlock == null) {
            System.err.println("Could not find student block");
            return evaluationData;
        }

        System.out.println("DEBUG - Student block: " + studentBlock);

        // Read all schedules for this student's block
        // Schedule format: ScheduleID|Block|CourseCode|Day|StartTime|EndTime|TeacherName
        Map<String, String> courseTeacherMap = new HashMap<>(); // CourseCode -> TeacherName

        try (BufferedReader br = new BufferedReader(new FileReader(SCHEDULE_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 7) {
                    String scheduleBlock = parts[1].trim();
                    String courseCode = parts[2].trim();
                    String teacherName = parts[6].trim();

                    // If this schedule is for the student's block
                    if (scheduleBlock.equalsIgnoreCase(studentBlock)) {
                        courseTeacherMap.put(courseCode, teacherName);
                        System.out.println("DEBUG - Found schedule: " + courseCode + " -> " + teacherName);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading schedule: " + e.getMessage());
            e.printStackTrace();
        }

        // Read course details
        Map<String, String> courseNameMap = new HashMap<>(); // CourseCode -> CourseName
        try (BufferedReader br = new BufferedReader(new FileReader(COURSES_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 2) {
                    String courseCode = parts[0].trim();
                    String courseName = parts[1].trim();
                    courseNameMap.put(courseCode, courseName);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading courses: " + e.getMessage());
            e.printStackTrace();
        }

        // Combine all data
        for (Map.Entry<String, String> entry : courseTeacherMap.entrySet()) {
            String courseCode = entry.getKey();
            String teacherName = entry.getValue();
            String courseName = courseNameMap.getOrDefault(courseCode, "Unknown Course");

            // Return format: [TeacherID(empty), TeacherName, CourseCode, CourseName]
            evaluationData.add(new String[]{
                "",              // Empty teacher ID - not needed
                teacherName,     // BAYANI, Elaiza Mae P.
                courseCode,      // ID4
                courseName       // PANG ENGINEERING NA
            });

            System.out.println("DEBUG - Added: " + courseCode + " | " + courseName + " | " + teacherName);
        }

        System.out.println("DEBUG - Total courses found: " + evaluationData.size());
        return evaluationData;
    }
    
    private static String getStudentBlock(String studentID) {
        System.out.println("DEBUG - Looking for student ID: [" + studentID + "]");
        System.out.println("DEBUG - File path: " + STUDENT_FILE);

        File file = new File(STUDENT_FILE);
        System.out.println("DEBUG - File exists: " + file.exists());
        System.out.println("DEBUG - File absolute path: " + file.getAbsolutePath());

        try (BufferedReader br = new BufferedReader(new FileReader(STUDENT_FILE))) {
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                System.out.println("DEBUG - Line " + lineNumber + ": " + line); // Print entire line

                String[] parts = line.split("\\|");

                if (parts.length >= 10) {
                    String fileStudentID = parts[0].trim();
                    String block = parts[9].trim();
                    System.out.println("DEBUG - ID: [" + fileStudentID + "] Block: [" + block + "] Match: " + fileStudentID.equals(studentID));

                    if (fileStudentID.equals(studentID)) {
                        System.out.println("DEBUG - FOUND! Returning block: " + block);
                        return block;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading student data: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("DEBUG - Block not found for student ID: [" + studentID + "]");
        return null;
    }
   
    public static boolean saveEvaluation(String courseCode, String courseName, 
                                        String instructor, int[] ratings, 
                                        String evaluatorID, String comments) {
        try {
            File file = new File(EVALUATION_FILE);
            file.getParentFile().mkdirs();

            // Find teacher ID by instructor name
            String teacherID = null;
            try (BufferedReader tbr = new BufferedReader(new FileReader(FACULTY_FILE))) {
                String tline;
                while ((tline = tbr.readLine()) != null) {
                    String[] tdata = tline.split("\\|");
                    if (tdata.length >= 2 && tdata[1].trim().equalsIgnoreCase(instructor)) {
                        teacherID = tdata[0].trim(); 
                        break;
                    }
                }
            }

            if (teacherID == null) {
                System.out.println("ERROR: Could not find teacher ID for instructor " + instructor);
                return false;
            }

            List<String> allLines = new ArrayList<>();
            boolean courseExists = false;
            int courseLineIndex = -1;

            // Read existing evaluations
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                int lineIndex = 0;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split("\\|", 9);
                    if (data.length >= 2 && data[0].equals(teacherID) && data[1].equals(courseCode)) {
                        courseExists = true;
                        courseLineIndex = lineIndex;
                    }
                    allLines.add(line);
                    lineIndex++;
                }
                br.close();
            }

            if (courseExists) {
                // Update existing evaluation
                String existingLine = allLines.get(courseLineIndex);
                String[] existingData = existingLine.split("\\|", 9);

                double[] existingAvgs = new double[5];
                String existingComments = "";
                int count = 1;

                for (int i = 0; i < 5; i++) {
                    existingAvgs[i] = Double.parseDouble(existingData[2 + i]);
                }

                if (existingData.length >= 9 && !existingData[8].isEmpty()) {
                    existingComments = existingData[8];
                    count = existingComments.split("\\|").length + 1;
                }

                double[] newAvgs = new double[5];
                double totalAvg = 0;

                for (int i = 0; i < 5; i++) {
                    newAvgs[i] = (existingAvgs[i] * (count - 1) + ratings[i]) / count;
                    totalAvg += newAvgs[i];
                }
                totalAvg = totalAvg / 5;

                String updatedComments = existingComments.isEmpty()
                    ? (comments != null ? comments : "")
                    : existingComments + (comments != null && !comments.isEmpty() ? "|" + comments : "");
                
                StringBuilder updatedLine = new StringBuilder();
                updatedLine.append(teacherID).append("|").append(courseCode).append("|");
                for (int i = 0; i < 5; i++) {
                    updatedLine.append(String.format("%.2f", newAvgs[i])).append("|");
                }
                updatedLine.append(String.format("%.2f", totalAvg)).append("|");
                updatedLine.append(updatedComments);

                allLines.set(courseLineIndex, updatedLine.toString());

            } else {
                // Create new evaluation
                StringBuilder newLine = new StringBuilder();
                newLine.append(teacherID).append("|").append(courseCode).append("|");

                double totalAvg = 0;
                for (int i = 0; i < 5; i++) {
                    double avg = (double) ratings[i];
                    newLine.append(String.format("%.2f", avg)).append("|");
                    totalAvg += avg;
                }
                totalAvg = totalAvg / 5;
                newLine.append(String.format("%.2f", totalAvg)).append("|");
                newLine.append(comments != null ? comments : "");

                allLines.add(newLine.toString());
            }

            // Write back to file
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (String line : allLines) {
                bw.write(line);
                bw.newLine();
            }
            bw.close();

            // Track that this student evaluated this course
            trackStudentEvaluation(evaluatorID, courseCode);

            System.out.println("Evaluation saved successfully!");
            return true;

        } catch (Exception e) {
            System.out.println("ERROR saving evaluation: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    private static void trackStudentEvaluation(String studentID, String courseCode) {
        try {
            File file = new File(STUDENT_EVAL_TRACKING_FILE);
            file.getParentFile().mkdirs();
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(studentID + "|" + courseCode);
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static boolean hasStudentEvaluated(String studentID, String courseCode) {
            try (BufferedReader br = new BufferedReader(new FileReader(STUDENT_EVAL_TRACKING_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length >= 2 && 
                    data[0].trim().equals(studentID) && 
                    data[1].trim().equalsIgnoreCase(courseCode)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static List<String[]> getEvaluationsByInstructor(String instructor) {
         List<String[]> evaluations = new ArrayList<>();
        List<String> matchingTeacherIDs = new ArrayList<>();

        // Find all teacher IDs matching the instructor name
        try (BufferedReader br = new BufferedReader(new FileReader(FACULTY_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length >= 2 && data[1].equalsIgnoreCase(instructor)) {
                    matchingTeacherIDs.add(data[0].trim());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Get all evaluations for those teacher IDs
        try (BufferedReader br = new BufferedReader(new FileReader(EVALUATION_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length >= 8 && matchingTeacherIDs.contains(data[0].trim())) {
                    evaluations.add(data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return evaluations;
    }
    
    public static double getAverageRating(String instructor) {
        List<String[]> evaluations = getEvaluationsByInstructor(instructor);
        if (evaluations.isEmpty()) return 0.0;
        
        double sum = 0;
        int count = 0;
        for (String[] eval : evaluations) {
            try {
                sum += Double.parseDouble(eval[7]); 
                count++;
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                continue;
            }
        }
        return count > 0 ? sum / count : 0.0;
    }
    
    public static String[] getTeacherByCourseCode(String courseCode) {
        try (BufferedReader br = new BufferedReader(new FileReader(COURSES_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length > 0 && data[0].trim().equalsIgnoreCase(courseCode)) {
                    return data;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static double[] getAverageRatingsByStatement(String instructor) {
        List<String[]> evaluations = getEvaluationsByInstructor(instructor);
        double[] averages = new double[5];
        
        if (evaluations.isEmpty()) return averages;
        
        for (String[] eval : evaluations) {
            try {
                for (int i = 0; i < 5; i++) {
                    averages[i] += Double.parseDouble(eval[2 + i]); 
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                continue;
            }
        }
        
        for (int i = 0; i < 5; i++) {
            averages[i] = averages[i] / evaluations.size();
        }
        
        return averages;
    }
}