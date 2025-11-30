package com.udj.logic;

import java.text.DecimalFormat;

public class StudentGrade { 
    
    private static final String GRADES_FILE = "src/main/resources/data/GradesData.txt";

    private String studentId;
    private String name;
    private String program;
    private Double prelimGrade;
    private Double midtermGrade;
    private Double finalsGrade;
    
    private Double finalGrade;
    private String status;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public StudentGrade(String studentId, String name, String program, String yearAndSection) {
        this.studentId = studentId;
        this.name = name;
        this.program = program;
        this.status = "N/A"; 
    }
    
    public StudentGrade(String studentId, String name, String program, String yearAndSection, 
                        Double prelimGrade, Double midtermGrade, Double finalsGrade) {
        this.studentId = studentId;
        this.name = name;
        this.program = program;
       
        this.prelimGrade = prelimGrade;
        this.midtermGrade = midtermGrade;
        this.finalsGrade = finalsGrade;
        calculateFinalGradeAndStatus();
    }

    public void calculateFinalGradeAndStatus() {
        if (prelimGrade == null || midtermGrade == null || finalsGrade == null) {
            this.finalGrade = null;
            this.status = "INC";
            return;
        }

        double sum = prelimGrade + midtermGrade + finalsGrade;
        double calculatedGrade = sum / 3.0;

        try {
            this.finalGrade = Double.parseDouble(df.format(calculatedGrade));
        } catch (NumberFormatException e) {
            this.finalGrade = calculatedGrade;
        }

        if (this.finalGrade <= 3.0) {
            this.status = "Passed";
        } else {
            this.status = "Failed";
        }
    }

    
    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getProgram() { return program; }

    public void setPrelimGrade(Double prelimGrade) { 
        this.prelimGrade = prelimGrade; 
        calculateFinalGradeAndStatus(); 
    }
    public void setMidtermGrade(Double midtermGrade) { 
        this.midtermGrade = midtermGrade; 
        calculateFinalGradeAndStatus();
    }
    public void setFinalsGrade(Double finalsGrade) { 
        this.finalsGrade = finalsGrade; 
        calculateFinalGradeAndStatus();
    }

    public Double getPrelimGrade() { return prelimGrade; }
    public Double getMidtermGrade() { return midtermGrade; }
    public Double getFinalsGrade() { return finalsGrade; }

    public Double getFinalGrade() { return finalGrade; }
    public String getStatus() { return status; }
}