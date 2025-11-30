package com.udj.gui;

import com.udj.gui.components.CustomComboBox;
import javax.swing.JOptionPane;

public class AddEditCourse extends javax.swing.JDialog {
    
    private CoursesCurriculumManagement parentPanel; 
    private boolean isEditMode = false;
    private String originalCourseID = "";

    public AddEditCourse(java.awt.Frame parent, boolean modal, CoursesCurriculumManagement panel) {
        super(parent, modal);
        this.parentPanel = panel;
        this.isEditMode = false;
        
        initComponents();
        CustomComboBox.applyStyle(Department);
        CustomComboBox.applyStyle(YearLevel);
        CustomComboBox.applyStyle(Semester);
        BackB.setVisible(false);
    }
    
    public AddEditCourse(java.awt.Frame parent, boolean modal, CoursesCurriculumManagement panel, 
                   String id, String desc, String units, String dept, String yearLevel, String semester) {     
        this(parent, modal, panel);
        this.isEditMode = true;
        this.originalCourseID = id;
        CourseID.setText(id);
        CourseName.setText(desc);
        Units.setText(units);
        Department.setSelectedItem(dept); 
        YearLevel.setSelectedItem(yearLevel);
        Semester.setSelectedItem(semester);
        CourseID.setEditable(false);
        CourseID.setFocusable(false);
        CourseID.setRequestFocusEnabled(false);
        CourseID.setForeground(java.awt.Color. GRAY);
        CourseLabel.setText("EDIT COURSE");
    }
    
    public AddEditCourse(java.awt.Frame parent, boolean modal) {
        this(parent, modal, null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGPanel = new com.udj.gui.components.Background();
        Back = new javax.swing.JLabel();
        BackB = new com.udj.gui.components.ButtonLabelBG();
        ClearC = new javax.swing.JLabel();
        SaveC = new javax.swing.JLabel();
        CourseID = new javax.swing.JTextField();
        CourseName = new javax.swing.JTextField();
        Units = new javax.swing.JTextField();
        Department = new javax.swing.JComboBox<>();
        YearLevel = new javax.swing.JComboBox<>();
        Semester = new javax.swing.JComboBox<>();
        CourseLabel = new javax.swing.JLabel();
        AddCourse = new com.udj.gui.components.ButtonLabelBG();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        BGPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackMouseExited(evt);
            }
        });
        BGPanel.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 20, 20));

        BackB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackIconSmall.png"))); // NOI18N
        BGPanel.add(BackB, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 12, -1, -1));

        ClearC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClearC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearCMouseClicked(evt);
            }
        });
        BGPanel.add(ClearC, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 278, 85, 25));

        SaveC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SaveC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveCMouseClicked(evt);
            }
        });
        BGPanel.add(SaveC, new org.netbeans.lib.awtextra.AbsoluteConstraints(428, 278, 85, 25));

        CourseID.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        CourseID.setAutoscrolls(false);
        CourseID.setBorder(null);
        CourseID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        BGPanel.add(CourseID, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 84, 280, 20));
        CourseID.setOpaque(false);

        CourseName.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        CourseName.setAutoscrolls(false);
        CourseName.setBorder(null);
        CourseName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        BGPanel.add(CourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 111, 280, 20));
        CourseName.setOpaque(false);

        Units.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Units.setAutoscrolls(false);
        Units.setBorder(null);
        Units.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        BGPanel.add(Units, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 139, 280, 20));
        Units.setOpaque(false);

        Department.setBackground(new java.awt.Color(242, 216, 255));
        Department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select Department -", "All", "Computer Studies", "Chemistry", "Engineering", "Management" }));
        BGPanel.add(Department, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 167, 296, 18));

        YearLevel.setBackground(new java.awt.Color(242, 216, 255));
        YearLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select Year Level -", "All", "First Year", "Second Year", "Third Year", "Fourth Year" }));
        BGPanel.add(YearLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 194, 296, 18));

        Semester.setBackground(new java.awt.Color(242, 216, 255));
        Semester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select Semester -", "Any Semester", "1st Semester", "2nd Semester" }));
        BGPanel.add(Semester, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 222, 296, 18));

        CourseLabel.setFont(new java.awt.Font("Product Sans", 1, 18)); // NOI18N
        CourseLabel.setForeground(new java.awt.Color(255, 255, 255));
        CourseLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CourseLabel.setText("COURSE");
        BGPanel.add(CourseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 40));

        AddCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AddCourse.png"))); // NOI18N
        BGPanel.add(AddCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 325));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BGPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BGPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveCMouseClicked
        String code = CourseID.getText(). trim();
        String desc = CourseName.getText().trim();
        String unitStr = Units.getText().trim();
        String dept = Department.getSelectedItem().toString();
        String yearLevel = YearLevel.getSelectedItem().toString();
        String semester = Semester.getSelectedItem(). toString();

        if (code.isEmpty() || desc.isEmpty() || unitStr.isEmpty() || 
            dept. equals("- Select Department -") ||
            yearLevel.equals("- Select Year Level -") ||
            semester.equals("- Select Semester -")) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", 
                "Incomplete Information", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Integer. valueOf(unitStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Units must be a number.", 
                "Invalid Input", JOptionPane. WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to save this course?", 
            "Confirm Save", JOptionPane. YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        boolean success = false;
        String successMsg = "";

        if (isEditMode) {
            success = com.udj.logic.CourseManager.updateCourse(originalCourseID, desc, unitStr, 
                dept, yearLevel, semester);
            successMsg = "Course Updated Successfully!";
        } else {
            success = com.udj.logic.CourseManager.addCourse(code, desc, unitStr, 
                dept, yearLevel, semester);
            successMsg = "Course Added Successfully!";
        }

        if (success) {
            JOptionPane.showMessageDialog(this, successMsg, "Success", 
                JOptionPane. INFORMATION_MESSAGE);
            if (parentPanel != null) {
                parentPanel.loadCourseData();
            }
            ClearCMouseClicked(null);
            this.dispose();
        } else {
            String errorMsg = isEditMode ? "Failed to update course." : 
                "Failed to add course.  Possible Reason: Course ID already exists.";
            JOptionPane.showMessageDialog(this, errorMsg, "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SaveCMouseClicked
   
    private void ClearCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearCMouseClicked
        CourseID.setText(isEditMode ? originalCourseID : ""); 
        if (!isEditMode) CourseID.setEditable(true); 
        CourseName.setText("");
        Units.setText("");
        Department.setSelectedIndex(0);
    }//GEN-LAST:event_ClearCMouseClicked

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        this.dispose();
    }//GEN-LAST:event_BackMouseClicked

    private void BackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseEntered
        BackB.setVisible(true);
    }//GEN-LAST:event_BackMouseEntered

    private void BackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseExited
        BackB.setVisible(false);
    }//GEN-LAST:event_BackMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddCourse;
    private javax.swing.JPanel BGPanel;
    private javax.swing.JLabel Back;
    private javax.swing.JLabel BackB;
    private javax.swing.JLabel ClearC;
    private javax.swing.JTextField CourseID;
    private javax.swing.JLabel CourseLabel;
    private javax.swing.JTextField CourseName;
    private javax.swing.JComboBox<String> Department;
    private javax.swing.JLabel SaveC;
    private javax.swing.JComboBox<String> Semester;
    private javax.swing.JTextField Units;
    private javax.swing.JComboBox<String> YearLevel;
    // End of variables declaration//GEN-END:variables
}
