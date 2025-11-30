package com.udj.logic;

public class StudentProfileData {
    private String studentId;
    private String studentName;
    private String studentCourse;
    private String studentDepartment;
    private String studentCollege;
    private String studentYear;
    private String studentStatus;
    private String studentEmail;
    private String studentCity;
    
    // Constructor
    public StudentProfileData(String studentId, String studentName, String studentCourse, 
                             String studentDepartment, String studentCollege, String studentYear, 
                             String studentStatus, String studentEmail, String studentCity) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentCourse = studentCourse;
        this.studentDepartment = studentDepartment;
        this.studentCollege = studentCollege;
        this.studentYear = studentYear;
        this.studentStatus = studentStatus;
        this.studentEmail = studentEmail;
        this.studentCity = studentCity;
    }
    
    public static StudentProfileData fromArray(String[] data) {
        if (data == null || data.length < 9) {
            throw new IllegalArgumentException("Invalid student data array");
        }
        
        return new StudentProfileData(
            data[0], // id
            data[1], // name
            data[2], // course/program
            data[3], // department
            data[4], // college
            data[5], // year
            data[6], // status
            data[7], // email
            data[8]  // city
        );
    }
    
    // Getters
    public String getStudentId() {
        return studentId;
    }
    
    public String getStudentName() {
        return studentName;
    }
    
    public String getStudentCourse() {
        return studentCourse;
    }
    
    public String getStudentDepartment() {
        return studentDepartment;
    }
    
    public String getStudentCollege() {
        return studentCollege;
    }
    
    public String getStudentYear() {
        return studentYear;
    }
    
    public String getStudentStatus() {
        return studentStatus;
    }
    
    public String getStudentEmail() {
        return studentEmail;
    }
    
    public String getStudentCity() {
        return studentCity;
    }
}