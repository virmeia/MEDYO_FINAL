package com.udj.logic;

public class Teacher extends User {
    public Teacher(String username, String password) {
        super(username, password);
    }

    @Override
    public String getRole() {
        return "TEACHER";
    }
}
