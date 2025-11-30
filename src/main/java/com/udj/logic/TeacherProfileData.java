package com.udj.logic;

public class TeacherProfileData {
    private String teacherID;
    private String teacherName;
    private String teacherDepartment;
    private String teacherCollege;
    private String teacherStatus;
    private String teacherEmail;
    private String teacherCity;
    
    // Constructor
    public TeacherProfileData(String teacherID, String teacherName, String teacherDepartment, String teacherCollege
                              , String teacherStatus, String teacherEmail, String teacherCity) {
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.teacherDepartment = teacherDepartment;
        this.teacherCollege = teacherCollege;
        this.teacherStatus = teacherStatus;
        this.teacherEmail = teacherEmail;
        this.teacherCity = teacherCity;
    }
    
    public static TeacherProfileData fromArray(String[] data) {
        if (data == null || data.length < 7) {
            throw new IllegalArgumentException("Invalid student data array");
        }
        
        return new TeacherProfileData(
            data[0], // id
            data[1], // name
            data[2], // department
            data[4], // status
            data[3], // college
            data[5], // email
            data[6]  // city
        );
    }
    
    // Getters
    public String getTeacherID() {
        return teacherID;
    }
    
    public String getTeacherName() {
        return teacherName;
    }
    
    public String getTeacherDepartment() {
        return teacherDepartment;
    }
    
    public String getTeacherCollege() {
        return teacherCollege;
    }
 
    public String getTeacherStatus() {
        return teacherStatus;
    }
    
    public String getTeacherEmail() {
        return teacherEmail;
    }
    
    public String getTeacherCity() {
        return teacherCity;
    }
}