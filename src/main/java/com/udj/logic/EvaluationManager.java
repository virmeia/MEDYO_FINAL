package com.udj.logic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EvaluationManager {

    private static final String TEACHER_FILE = "src/main/resources/data/TeachersData.txt";
    private static final String EVALUATION_FILE = "src/main/resources/data/EvaluationsData.txt";
    private static final String STUDENT_EVAL_TRACKING_FILE = "src/main/resources/data/EvaluationTracker.txt";
   
    public static List<String[]> getAllTeachersForEvaluation() {
        List<String[]> teachers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(TEACHER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 4) {
                    for (int i = 0; i < data.length; i++) {
                        data[i] = data[i].trim();
                    }
                    teachers.add(data);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Teacher file not found, returning empty list");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teachers;
    }
   
    public static boolean saveEvaluation(String courseCode, String courseName, 
                                        String instructor, int[] ratings, 
                                        String evaluatorID, String comments) {
        try {
        File file = new File(EVALUATION_FILE);
        file.getParentFile().mkdirs();

        String teacherID = null;
            try (BufferedReader tbr = new BufferedReader(new FileReader(TEACHER_FILE))) {
                String tline;
                while ((tline = tbr.readLine()) != null) {
                    String[] tdata = tline.split(",");
                    if (tdata.length >= 3 && tdata[2].trim().equalsIgnoreCase(courseCode)) {
                        teacherID = tdata[0].trim(); 
                        break;
                    }
                }
            }

            if (teacherID == null) {
                System.out.println("ERROR: Could not find teacher ID for course " + courseCode);
                return false;
            }

            List<String> allLines = new ArrayList<>();
            boolean courseExists = false;
            int courseLineIndex = -1;

            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                int lineIndex = 0;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",", 9);
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
                String existingLine = allLines.get(courseLineIndex);
                String[] existingData = existingLine.split(",", 9);

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
                    // (oldAvg * (count-1) + newRating) / count
                    newAvgs[i] = (existingAvgs[i] * (count - 1) + ratings[i]) / count;
                    totalAvg += newAvgs[i];
                }
                totalAvg = totalAvg / 5;

                String updatedComments = existingComments.isEmpty()
                ? (comments != null ? comments : "")
                : existingComments + (comments != null && !comments.isEmpty() ? "|" + comments : "");
                
                StringBuilder updatedLine = new StringBuilder();
                updatedLine.append(teacherID).append(",").append(courseCode).append(",");
                for (int i = 0; i < 5; i++) {
                    updatedLine.append(String.format("%.2f", newAvgs[i])).append(",");
                }
                updatedLine.append(String.format("%.2f", totalAvg)).append(",");
                updatedLine.append(updatedComments);

                allLines.set(courseLineIndex, updatedLine.toString());

            } else {
                StringBuilder newLine = new StringBuilder();
                newLine.append(teacherID).append(",").append(courseCode).append(",");

                double totalAvg = 0;
                for (int i = 0; i < 5; i++) {
                    double avg = (double) ratings[i];
                    newLine.append(String.format("%.2f", avg)).append(",");
                    totalAvg += avg;
                }
                totalAvg = totalAvg / 5;
                newLine.append(String.format("%.2f", totalAvg)).append(",");
                newLine.append(comments != null ? comments : "");

                allLines.add(newLine.toString());
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (String line : allLines) {
                bw.write(line);
                bw.newLine();
            }
            bw.close();

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
            bw.write(studentID + "," + courseCode);
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
                String[] data = line.split(",");
                if (data.length >= 2 && 
                    data[0].equals(studentID) && 
                    data[1].equalsIgnoreCase(courseCode)) {
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

        try (BufferedReader br = new BufferedReader(new FileReader(TEACHER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 4 && data[3].equalsIgnoreCase(instructor)) {
                    matchingTeacherIDs.add(data[0].trim()); // teacherID
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(EVALUATION_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 9 && matchingTeacherIDs.contains(data[0].trim())) {
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
                sum += Double.parseDouble(eval[8]); 
                count++;
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                continue;
            }
        }
        return count > 0 ? sum / count : 0.0;
    }
    
    public static String[] getTeacherByCourseCode(String courseCode) {
        try (BufferedReader br = new BufferedReader(new FileReader(TEACHER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length > 0 && data[0].equalsIgnoreCase(courseCode)) {
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
                    averages[i] += Double.parseDouble(eval[3 + i]); 
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