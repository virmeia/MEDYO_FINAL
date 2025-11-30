package com.udj.gui;

import com.udj.gui.components.FAddSaveConfirm;
import com.udj.gui.components.CustomComboBox;
import com.udj.logic.FacultyManager;

public class AddFaculty extends javax.swing.JDialog {   
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AddFaculty.class.getName());
    private FacultyManagement parentPanel;
    
   public AddFaculty(java.awt.Frame parent, boolean modal, FacultyManagement facultyPanel) {
        super(parent, modal);
        this.parentPanel = facultyPanel;
        
        initComponents();
        CustomComboBox.applyStyle(Department);  CustomComboBox.applyStyle(EmploymentType); CustomComboBox.applyStyle(College);
        FacultyID.setText(FacultyManager.generateFacultyID());
        FacultyID.setEditable(false); 
        BackB.setVisible(false);
    }
    
    public AddFaculty(java.awt.Frame parent, boolean modal) {
        this(parent, modal, null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGPanel = new javax.swing.JPanel();
        NewFacultyLabel = new javax.swing.JLabel();
        NameFormat = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        FacultyID = new javax.swing.JTextField();
        Department = new javax.swing.JComboBox<>();
        EmploymentType = new javax.swing.JComboBox<>();
        College = new javax.swing.JComboBox<>();
        Email = new javax.swing.JTextField();
        City = new javax.swing.JTextField();
        Clear = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        Back = new javax.swing.JLabel();
        BackB = new com.udj.gui.components.ButtonLabelBG();
        AddBG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BGPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NewFacultyLabel.setFont(new java.awt.Font("Product Sans", 1, 18)); // NOI18N
        NewFacultyLabel.setForeground(new java.awt.Color(255, 255, 255));
        NewFacultyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NewFacultyLabel.setText("NEW FACULTY");
        BGPanel.add(NewFacultyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 40));

        NameFormat.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        NameFormat.setText("Format: SURNAME, Given Name Middle Name");
        BGPanel.add(NameFormat, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 85, 250, -1));

        Name.setBorder(null);
        BGPanel.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 101, 290, 18));

        FacultyID.setBackground(new java.awt.Color(242, 242, 242));
        FacultyID.setForeground(new java.awt.Color(102, 102, 102));
        FacultyID.setBorder(null);
        BGPanel.add(FacultyID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 129, 290, 18));

        Department.setBackground(new java.awt.Color(242, 216, 255));
        Department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select Department -", "Computer Studies Department", "Chemistry Department", "Engineering Department", "Entrepreneurship and Management Department" }));
        Department.setFocusable(false);
        BGPanel.add(Department, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 156, 315, 18));

        EmploymentType.setBackground(new java.awt.Color(242, 216, 255));
        EmploymentType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select Employment Type -", "Part-Time", "Full Time", " " }));
        BGPanel.add(EmploymentType, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 183, 315, 18));

        College.setBackground(new java.awt.Color(242, 216, 255));
        College.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select College -", "College of Science", "College of Engineering", "College of Liberal Arts", " " }));
        BGPanel.add(College, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 315, 18));

        Email.setBorder(null);
        BGPanel.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 259, 290, 18));

        City.setBorder(null);
        BGPanel.add(City, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 286, 290, 18));

        Clear.setBorderPainted(false);
        Clear.setContentAreaFilled(false);
        Clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearMouseClicked(evt);
            }
        });
        BGPanel.add(Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 353, 80, 30));

        Save.setBorderPainted(false);
        Save.setContentAreaFilled(false);
        Save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveMouseClicked(evt);
            }
        });
        BGPanel.add(Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, 80, 20));

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

        AddBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Faculty.png"))); // NOI18N
        BGPanel.add(AddBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 400));

        getContentPane().add(BGPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveMouseClicked
        String id = FacultyID.getText().trim();
        if (id.isEmpty()) {
            id = FacultyManager.generateFacultyID();
            FacultyID.setText(id);
        }
        String name = Name.getText().trim();
        String email = Email.getText().trim();
        String city = City.getText().trim();
        String department = Department.getSelectedItem().toString();
        String employment = EmploymentType.getSelectedItem().toString();
        String college = College.getSelectedItem().toString();

        if (name.isEmpty() || email.isEmpty() || city.isEmpty() ||
            department.equals("- Select Department -") ||
            college.equals("- Select College -") || employment.equals("- Select Employment Type -"))
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Please complete all fields before saving.","Incomplete Information", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (name.contains("|") || email.contains("|") || city.contains("|")) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Fields cannot contain the pipe character '|' as it is used for data formatting.", 
                "Invalid Character", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (id.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,"Error generating faculty ID.","ID Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (FacultyManager.facultyIDExists(id)) {
            javax.swing.JOptionPane.showMessageDialog(this,"Error: Generated ID already exists. Try again.","Duplicate Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        FAddSaveConfirm dialog = new FAddSaveConfirm((java.awt.Frame)null, true);
        dialog.setVisible(true);
        if (!dialog.isConfirmed()) return;

        boolean success = FacultyManager.saveFaculty(id, name, department, employment,
                              college, email, city);
        if (success) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Faculty saved successfully!\nID: " + id,
                "Success", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            if (parentPanel != null) {
                parentPanel.refreshTable();
            }            
            FacultyID.setText(FacultyManager.generateFacultyID());
            Name.setText("");
            Email.setText("");
            City.setText("");
            Department.setSelectedIndex(0);
            EmploymentType.setSelectedIndex(0);    
            College.setSelectedIndex(0);          
            this.dispose();
        }
        else {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Failed to save faculty information.",
                "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SaveMouseClicked

    private void ClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearMouseClicked
        Name.setText("");
        Email.setText("");
        City.setText("");
        Department.setSelectedIndex(0);
        EmploymentType.setSelectedIndex(0);
        College.setSelectedIndex(0);
    }//GEN-LAST:event_ClearMouseClicked

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        BackB.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackMouseClicked

    private void BackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseEntered
        BackB.setVisible(true);
    }//GEN-LAST:event_BackMouseEntered

    private void BackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseExited
        BackB.setVisible(false);
    }//GEN-LAST:event_BackMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddBG;
    private javax.swing.JPanel BGPanel;
    private javax.swing.JLabel Back;
    private javax.swing.JLabel BackB;
    private javax.swing.JTextField City;
    private javax.swing.JButton Clear;
    private javax.swing.JComboBox<String> College;
    private javax.swing.JComboBox<String> Department;
    private javax.swing.JTextField Email;
    private javax.swing.JComboBox<String> EmploymentType;
    private javax.swing.JTextField FacultyID;
    private javax.swing.JTextField Name;
    private javax.swing.JLabel NameFormat;
    private javax.swing.JLabel NewFacultyLabel;
    private javax.swing.JButton Save;
    // End of variables declaration//GEN-END:variables
}
