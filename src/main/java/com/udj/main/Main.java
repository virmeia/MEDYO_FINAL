package com.udj.main;

public class Main { 

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new com.udj.gui.AdminDB().setVisible(true); 
        });
    }
}