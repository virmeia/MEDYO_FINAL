package com.udj.gui;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdminDB extends javax.swing.JFrame {
    private static final String STUDENTS_FILE = "/data/StudentsData.txt";
    private static final String FACULTY_FILE = "/data/FacultysData.txt";
    private static final String COURSES_FILE = "/data/Courses.txt";
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminDB.class.getName());
    private final JPanel contentPanel;
    private final CardLayout cardLayout;

    public AdminDB() {
       initComponents();

       updateDashboardData();

       cardLayout = new CardLayout();
       contentPanel = new JPanel(cardLayout);
       contentPanel.setOpaque(false);
       contentPanel.setBackground(new Color(244, 232, 250));
       contentPanel.setBounds(0, 0, 1000, 600);

       contentPanel.add(new StudentManagement(this), "STUDENT_MANAGEMENT");
       contentPanel.add(new FacultyManagement(this), "FACULTY_MANAGEMENT");
       contentPanel.add(new CoursesCurriculumManagement(this), "COURSES_AND_CURRICULUM");
       contentPanel.add(new SystemAccountManagement(this), "SYSTEM_AND_ACCOUNT");


       BGPanel.add(contentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));
       contentPanel.setVisible(false);
       JLayeredPane layeredPane = getLayeredPane();
       layeredPane.add(contentPanel, JLayeredPane.PALETTE_LAYER);
       
       contentPanel.setVisible(false);
       hideAllHighlights();       
    }
    
    private int countLinesInFile(String resourcePath) {
        int lineCount = 0;
     
        try (java.io.InputStream is = AdminDB.class.getResourceAsStream(resourcePath)) {
            
            if (is == null) {
                logger.severe(() -> "Resource not found in classpath: " + resourcePath);
                return 0;
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                while (reader.readLine() != null) {
                    lineCount++;
                }
            }
        } catch (IOException e) {
            logger.severe(() -> "Error reading resource " + resourcePath + ": " + e.getMessage());
            return 0;
        }
        return lineCount;
    }

    private void updateDashboardData() {
        int studentCount = countLinesInFile(STUDENTS_FILE);
        int facultyCount = countLinesInFile(FACULTY_FILE); 
        int courseCount = countLinesInFile(COURSES_FILE);   
        TotalStudents.setText(String.valueOf(studentCount));
        TotalFaculty.setText(String.valueOf(facultyCount));
        TotalCourses.setText(String.valueOf(courseCount));
    } 
    
     public void showPanel(String name) {
        setMainNavigationVisible(false);
        contentPanel.setVisible(true);
        
        TotalStudents.setVisible(false); 
        TotalFaculty.setVisible(false);
        TotalCourses.setVisible(false);
        
        cardLayout.show(contentPanel, name);
        contentPanel.revalidate();
        contentPanel.repaint();
    }
    
    public void showDashboard() {
        contentPanel.setVisible(false);
        setMainNavigationVisible(true);
        hideAllHighlights();
        
        TotalStudents.setVisible(true);
        TotalFaculty.setVisible(true);
        TotalCourses.setVisible(true);
        
        updateDashboardData();
    }
    
    private void setMainNavigationVisible(boolean visible) {
        StudentC.setVisible(visible);
        FacultyC.setVisible(visible);
        CoursesnCurriC.setVisible(visible);
        SystemC.setVisible(visible);
        if (!visible) {
            hideAllHighlights();
        }
    }
    
    private void hideAllHighlights() {
        StudentC1.setVisible(false);
        FacultyC1.setVisible(false);
        CoursesnCurriC1.setVisible(false);
        SystemC1.setVisible(false);
    }
    
    private boolean isCurrentPanel(String panelName) {
        Component[] components = contentPanel.getComponents();
        for (Component comp : components) {
            if (comp.isVisible()) {
                if (panelName.equals("STUDENT_MANAGEMENT") && comp instanceof StudentManagement) {
                    return true;
                }
                if (panelName.equals("FACULTY_MANAGEMENT") && comp instanceof FacultyManagement) {
                    return true;
                }
                if (panelName.equals("COURSES_AND_CURRICULUM") && comp instanceof CoursesCurriculumManagement) {
                    return true;
                }
                if (panelName.equals("SYSTEM_AND_ACCOUNT") && comp instanceof SystemAccountManagement) {
                    return true;
                }
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGPanel = new com.udj.gui.components.Background();
        CoursesnCurriC = new javax.swing.JButton();
        SystemC = new javax.swing.JButton();
        StudentC = new javax.swing.JButton();
        FacultyC = new javax.swing.JButton();
        DashboardC1 = new com.udj.gui.components.ButtonBG();
        StudentC1 = new com.udj.gui.components.ButtonBG();
        FacultyC1 = new com.udj.gui.components.ButtonBG();
        CoursesnCurriC1 = new com.udj.gui.components.ButtonBG();
        SystemC1 = new com.udj.gui.components.ButtonBG();
        TotalStudents = new javax.swing.JTextField();
        TotalFaculty = new javax.swing.JTextField();
        TotalCourses = new javax.swing.JTextField();
        AdminBG = new com.udj.gui.components.ButtonLabelBG();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BGPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CoursesnCurriC.setBorderPainted(false);
        CoursesnCurriC.setContentAreaFilled(false);
        CoursesnCurriC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CoursesnCurriC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CoursesnCurriCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CoursesnCurriCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CoursesnCurriCMouseExited(evt);
            }
        });
        BGPanel.add(CoursesnCurriC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 160, 35));

        SystemC.setBorderPainted(false);
        SystemC.setContentAreaFilled(false);
        SystemC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SystemC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SystemCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SystemCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SystemCMouseExited(evt);
            }
        });
        BGPanel.add(SystemC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 160, 35));

        StudentC.setBorderPainted(false);
        StudentC.setContentAreaFilled(false);
        StudentC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        StudentC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudentCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                StudentCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                StudentCMouseExited(evt);
            }
        });
        BGPanel.add(StudentC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 160, 35));

        FacultyC.setBorderPainted(false);
        FacultyC.setContentAreaFilled(false);
        FacultyC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FacultyC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FacultyCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FacultyCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FacultyCMouseExited(evt);
            }
        });
        BGPanel.add(FacultyC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 160, 35));

        DashboardC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DashboardAdminC1.png"))); // NOI18N
        DashboardC1.setBorderPainted(false);
        DashboardC1.setContentAreaFilled(false);
        BGPanel.add(DashboardC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 229, 162, 37));

        StudentC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/StudentAdminC1.png"))); // NOI18N
        StudentC1.setBorderPainted(false);
        StudentC1.setContentAreaFilled(false);
        BGPanel.add(StudentC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 290, 162, 37));

        FacultyC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FacultyAdminC1.png"))); // NOI18N
        FacultyC1.setBorderPainted(false);
        FacultyC1.setContentAreaFilled(false);
        BGPanel.add(FacultyC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 351, 165, 40));

        CoursesnCurriC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CourseAdminC1.png"))); // NOI18N
        CoursesnCurriC1.setBorderPainted(false);
        CoursesnCurriC1.setContentAreaFilled(false);
        BGPanel.add(CoursesnCurriC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 405, 165, 45));

        SystemC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SystemAdminC1.png"))); // NOI18N
        SystemC1.setBorderPainted(false);
        SystemC1.setContentAreaFilled(false);
        BGPanel.add(SystemC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 472, 160, 38));

        TotalStudents.setEditable(false);
        TotalStudents.setBackground(new java.awt.Color(185, 154, 202));
        TotalStudents.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TotalStudents.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TotalStudents.setBorder(null);
        TotalStudents.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TotalStudents.setFocusable(false);
        TotalStudents.setHighlighter(null);
        TotalStudents.setOpaque(true);
        TotalStudents.setRequestFocusEnabled(false);
        BGPanel.add(TotalStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 414, 53, 18));

        TotalFaculty.setBackground(new java.awt.Color(185, 154, 202));
        TotalFaculty.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TotalFaculty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TotalFaculty.setBorder(null);
        TotalFaculty.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TotalFaculty.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TotalFaculty.setEnabled(false);
        TotalFaculty.setOpaque(true);
        TotalFaculty.setSelectionColor(new java.awt.Color(51, 0, 51));
        TotalFaculty.addActionListener(this::TotalFacultyActionPerformed);
        BGPanel.add(TotalFaculty, new org.netbeans.lib.awtextra.AbsoluteConstraints(805, 414, 53, 18));

        TotalCourses.setEditable(false);
        TotalCourses.setBackground(new java.awt.Color(185, 154, 202));
        TotalCourses.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TotalCourses.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TotalCourses.setToolTipText("");
        TotalCourses.setBorder(null);
        TotalCourses.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TotalCourses.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TotalCourses.setEnabled(false);
        TotalCourses.setFocusable(false);
        TotalCourses.setOpaque(true);
        TotalCourses.setRequestFocusEnabled(false);
        BGPanel.add(TotalCourses, new org.netbeans.lib.awtextra.AbsoluteConstraints(593, 414, 53, 18));

        AdminBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ADBBG.png"))); // NOI18N
        BGPanel.add(AdminBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        getContentPane().add(BGPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CoursesnCurriCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CoursesnCurriCMouseClicked
        showPanel("COURSES_AND_CURRICULUM");
    }//GEN-LAST:event_CoursesnCurriCMouseClicked

    private void CoursesnCurriCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CoursesnCurriCMouseEntered
        CoursesnCurriC1.setVisible(true);
        CoursesnCurriC1.repaint();
    }//GEN-LAST:event_CoursesnCurriCMouseEntered

    private void CoursesnCurriCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CoursesnCurriCMouseExited
        CoursesnCurriC1.setVisible(false);
    }//GEN-LAST:event_CoursesnCurriCMouseExited

    private void SystemCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SystemCMouseClicked
        showPanel("SYSTEM_AND_ACCOUNT");
    }//GEN-LAST:event_SystemCMouseClicked

    private void SystemCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SystemCMouseEntered
        SystemC1.setVisible(true);
        SystemC1.repaint();
    }//GEN-LAST:event_SystemCMouseEntered

    private void SystemCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SystemCMouseExited
        SystemC1.setVisible(false);
    }//GEN-LAST:event_SystemCMouseExited

    private void StudentCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentCMouseClicked
        showPanel("STUDENT_MANAGEMENT");
    }//GEN-LAST:event_StudentCMouseClicked

    private void StudentCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentCMouseEntered
        StudentC1.setVisible(true);
        StudentC1.repaint();
    }//GEN-LAST:event_StudentCMouseEntered

    private void StudentCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentCMouseExited
        StudentC1.setVisible(false);
    }//GEN-LAST:event_StudentCMouseExited

    private void FacultyCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FacultyCMouseClicked
        showPanel("FACULTY_MANAGEMENT");
    }//GEN-LAST:event_FacultyCMouseClicked

    private void FacultyCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FacultyCMouseEntered
        FacultyC1.setVisible(true);
        FacultyC1.repaint();
    }//GEN-LAST:event_FacultyCMouseEntered

    private void FacultyCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FacultyCMouseExited
        FacultyC1.setVisible(false);
    }//GEN-LAST:event_FacultyCMouseExited

    private void TotalFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalFacultyActionPerformed

    }//GEN-LAST:event_TotalFacultyActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdminBG;
    private javax.swing.JPanel BGPanel;
    private javax.swing.JButton CoursesnCurriC;
    private javax.swing.JButton CoursesnCurriC1;
    private javax.swing.JButton DashboardC1;
    private javax.swing.JButton FacultyC;
    private javax.swing.JButton FacultyC1;
    private javax.swing.JButton StudentC;
    private javax.swing.JButton StudentC1;
    private javax.swing.JButton SystemC;
    private javax.swing.JButton SystemC1;
    private javax.swing.JTextField TotalCourses;
    private javax.swing.JTextField TotalFaculty;
    private javax.swing.JTextField TotalStudents;
    // End of variables declaration//GEN-END:variables
}
