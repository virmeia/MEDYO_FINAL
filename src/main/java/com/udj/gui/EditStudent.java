package com.udj.gui;

import com.udj.gui.components.CustomComboBox;
import com.udj.gui.components.EditSaveConfirm;
import com.udj.logic.StudentManager;

public class EditStudent extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(EditStudent.class.getName());
    private StudentManagement parentPanel;
    
   public EditStudent(java.awt.Frame parent, boolean modal, StudentManagement studentPanel) {
        super(parent, modal);
        this.parentPanel = studentPanel;
        initComponents();
        CustomComboBox.applyStyle(Program); CustomComboBox.applyStyle(Department); CustomComboBox.applyStyle(College); CustomComboBox.applyStyle(YearLevel); CustomComboBox.applyStyle(Status);
        CustomComboBox.applyScrollbar(Program);
        StudentID.setText(StudentManager.generateStudentID());
        StudentID.setEditable(false); 
    }
    
    public EditStudent(java.awt.Frame parent, boolean modal) {
        this(parent, modal, null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGPanel = new com.udj.gui.components.Background();
        BackButton = new javax.swing.JLabel();
        ClearC = new javax.swing.JLabel();
        SaveC = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        StudentID = new javax.swing.JTextField();
        Program = new javax.swing.JComboBox<>();
        Department = new javax.swing.JComboBox<>();
        College = new javax.swing.JComboBox<>();
        YearLevel = new javax.swing.JComboBox<>();
        Status = new javax.swing.JComboBox<>();
        Email = new javax.swing.JTextField();
        City = new javax.swing.JTextField();
        NewStudentLabel = new javax.swing.JLabel();
        AddStudent = new com.udj.gui.components.ButtonLabelBG();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        BGPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackButtonMouseClicked(evt);
            }
        });
        BGPanel.add(BackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 12, 20, 20));

        ClearC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClearC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearCMouseClicked(evt);
            }
        });
        BGPanel.add(ClearC, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 357, 85, 25));

        SaveC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SaveC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveCMouseClicked(evt);
            }
        });
        BGPanel.add(SaveC, new org.netbeans.lib.awtextra.AbsoluteConstraints(428, 357, 85, 25));

        Name.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Name.setAutoscrolls(false);
        Name.setBorder(null);
        Name.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });
        BGPanel.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 82, 300, 20));
        Name.setOpaque(false);

        StudentID.setEditable(false);
        StudentID.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        StudentID.setForeground(new java.awt.Color(102, 102, 102));
        StudentID.setAutoscrolls(false);
        StudentID.setBorder(null);
        StudentID.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        StudentID.setRequestFocusEnabled(false);
        StudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentIDActionPerformed(evt);
            }
        });
        BGPanel.add(StudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 300, 20));
        StudentID.setOpaque(false);

        Program.setBackground(new java.awt.Color(242, 216, 255));
        Program.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select Program -", "Bachelor of Science in Information Technology", "Bachelor of Science in Computer Science", "Bachelor of Science in Information System", "Bachelor of Science in Environmental Science", "Bachelor of Applied Science in Laboratory Technology", "Bachelor of Science in Civil Engineering", "Bachelor of Science in Electrical Engineering", "Bachelor of Science in Electronics Engineering", "Bachelor of Science in Mechanical Engineering", "Bachelor of Science in Entrepreneurship Management", "Bachelor of Science in Hospitality Management", "Bachelor of Arts in Management major in Industrial Management" }));
        BGPanel.add(Program, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 138, 313, 18));

        Department.setBackground(new java.awt.Color(242, 216, 255));
        Department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select Department -", "Computer Studies Department", "Chemistry Department", "Engineering Department", "Entrepreneurship and Management Department" }));
        BGPanel.add(Department, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 165, 313, 18));

        College.setBackground(new java.awt.Color(242, 216, 255));
        College.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select College -", "College of Science", "College of Engineering", "College of Liberal Arts" }));
        BGPanel.add(College, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 193, 313, 18));

        YearLevel.setBackground(new java.awt.Color(242, 216, 255));
        YearLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select Year Level -", "First Year", "Second Year", "Third Year", "Fourth Year" }));
        BGPanel.add(YearLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 220, 313, 18));

        Status.setBackground(new java.awt.Color(242, 216, 255));
        Status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select Status -", "Regular", "Irregular" }));
        BGPanel.add(Status, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 247, 313, 18));

        Email.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Email.setAutoscrolls(false);
        Email.setBorder(null);
        Email.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });
        BGPanel.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 274, 300, 20));
        Email.setOpaque(false);

        City.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        City.setAutoscrolls(false);
        City.setBorder(null);
        City.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        City.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CityActionPerformed(evt);
            }
        });
        BGPanel.add(City, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 301, 300, 20));
        City.setOpaque(false);

        NewStudentLabel.setFont(new java.awt.Font("Product Sans", 1, 18)); // NOI18N
        NewStudentLabel.setForeground(new java.awt.Color(255, 255, 255));
        NewStudentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NewStudentLabel.setText("EDIT STUDENT RECORD");
        BGPanel.add(NewStudentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 40));

        AddStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AddStudentBG.png"))); // NOI18N
        BGPanel.add(AddStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 400));

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        
    }//GEN-LAST:event_NameActionPerformed

    private void StudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentIDActionPerformed
        
    }//GEN-LAST:event_StudentIDActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        
    }//GEN-LAST:event_EmailActionPerformed

    private void BackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_BackButtonMouseClicked

    private void CityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CityActionPerformed
    
    }//GEN-LAST:event_CityActionPerformed
    
    private void SaveCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveCMouseClicked
        String id = StudentID.getText().trim();
        String name = Name.getText().trim();
        String email = Email.getText().trim();
        String city = City.getText().trim();
        String program = Program.getSelectedItem().toString();
        String department = Department.getSelectedItem().toString();
        String college = College.getSelectedItem().toString();
        String rawYear = YearLevel.getSelectedItem().toString();
        String status = Status.getSelectedItem().toString();

        String yearCode = "1";
        switch (rawYear) {
            case "First Year" -> yearCode = "1";
            case "Second Year" -> yearCode = "2";
            case "Third Year" -> yearCode = "3";
            case "Fourth Year" -> yearCode = "4";
            case "Fifth Year" -> yearCode = "5";
        }

        String programCode = com.udj.logic.StudentManager.getProgramCode(program);
        String block = programCode + "-" + yearCode;

        if (name.isEmpty() || email.isEmpty() || city.isEmpty() ||
            program.equals("- Select Program -") || department.equals("- Select Department -") ||
            college.equals("- Select College -") || rawYear.equals("- Select Year Level -") ||
            status.equals("- Select Status -"))
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please complete all fields.", "Incomplete", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        EditSaveConfirm dialog = new EditSaveConfirm((java.awt.Frame)null, true);
        dialog.setVisible(true);
        if (!dialog.isConfirmed()) return;

        boolean success = com.udj.logic.StudentManager.updateStudent(id, name, program, department,
                                      college, rawYear, status, email, city, block);

        if (success) {
            javax.swing.JOptionPane.showMessageDialog(this, "Student updated successfully!");
            if (parentPanel != null) {
                parentPanel.refreshTable();
            }
            this.dispose();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Failed to update record.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SaveCMouseClicked
   
    private void ClearCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearCMouseClicked
        Name.setText("");
        Email.setText("");
        City.setText("");
        Program.setSelectedIndex(0);
        Department.setSelectedIndex(0);
        College.setSelectedIndex(0);
        YearLevel.setSelectedIndex(0);
        Status.setSelectedIndex(0);
    }//GEN-LAST:event_ClearCMouseClicked

    public void loadStudentDetails(String id) {
        String[] data = StudentManager.getStudent(id);
        if (data != null) {
            StudentID.setText(data[0]);
            Name.setText(data[1]);
            Program.setSelectedItem(data[2]);
            Department.setSelectedItem(data[3]);
            College.setSelectedItem(data[4]);
            YearLevel.setSelectedItem(data[5]);
            Status.setSelectedItem(data[6]);
            Email.setText(data[7]);
            City.setText(data[8]);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: Student not found!");
            this.dispose();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddStudent;
    private javax.swing.JPanel BGPanel;
    private javax.swing.JLabel BackButton;
    private javax.swing.JTextField City;
    private javax.swing.JLabel ClearC;
    private javax.swing.JComboBox<String> College;
    private javax.swing.JComboBox<String> Department;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Name;
    private javax.swing.JLabel NewStudentLabel;
    private javax.swing.JComboBox<String> Program;
    private javax.swing.JLabel SaveC;
    private javax.swing.JComboBox<String> Status;
    private javax.swing.JTextField StudentID;
    private javax.swing.JComboBox<String> YearLevel;
    // End of variables declaration//GEN-END:variables
}
