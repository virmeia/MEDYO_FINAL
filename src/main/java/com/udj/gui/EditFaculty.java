
package com.udj.gui;

import com.udj.gui.components.CustomComboBox;
import com.udj.gui.components.FEditSaveConfirm;
import com.udj.logic.FacultyManager;

public class EditFaculty extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(EditFaculty.class.getName());
    private FacultyManagement parentPanel;
    
   public EditFaculty(java.awt.Frame parent, boolean modal, FacultyManagement facultyPanel) {
        super(parent, modal);
        this.parentPanel = facultyPanel;
        initComponents();
        CustomComboBox.applyStyle(Department); CustomComboBox.applyStyle(EmploymentType); CustomComboBox.applyStyle(College);
        FacultyID.setText(FacultyManager.generateFacultyID());
        FacultyID.setEditable(false); 
    }
    
    public EditFaculty(java.awt.Frame parent, boolean modal) {
        this(parent, modal, null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGPanel = new javax.swing.JPanel();
        Name = new javax.swing.JTextField();
        FacultyID = new javax.swing.JTextField();
        Department = new javax.swing.JComboBox<>();
        EmploymentType = new javax.swing.JComboBox<>();
        College = new javax.swing.JComboBox<>();
        Email = new javax.swing.JTextField();
        City = new javax.swing.JTextField();
        Header = new javax.swing.JLabel();
        Save = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        EditBG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        BGPanel.setMinimumSize(new java.awt.Dimension(540, 400));
        BGPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Name.setBorder(null);
        BGPanel.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 101, 290, 19));

        FacultyID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        FacultyID.setForeground(new java.awt.Color(102, 102, 102));
        FacultyID.setBorder(null);
        FacultyID.setSelectionColor(new java.awt.Color(255, 255, 255));
        BGPanel.add(FacultyID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 128, 290, 19));

        Department.setBackground(new java.awt.Color(242, 216, 255));
        Department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select Department -", "Computer Studies Department", "Chemistry Department", "Engineering Department", "Entrepreneurship and Management Department" }));
        BGPanel.add(Department, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 155, 318, 21));

        EmploymentType.setBackground(new java.awt.Color(242, 216, 255));
        EmploymentType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select Employment Type - ", "Part-time", "Full Time" }));
        BGPanel.add(EmploymentType, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 182, 318, 21));

        College.setBackground(new java.awt.Color(242, 216, 255));
        College.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select College -", "College of Science", "College of Engineering", "College of Liberal Arts" }));
        BGPanel.add(College, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 228, 318, 21));

        Email.setBorder(null);
        Email.addActionListener(this::EmailActionPerformed);
        BGPanel.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 259, 290, 18));

        City.setBorder(null);
        City.addActionListener(this::CityActionPerformed);
        BGPanel.add(City, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 286, 290, 18));

        Header.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        Header.setForeground(new java.awt.Color(255, 255, 255));
        Header.setText("EDIT FACULTY RECORD");
        BGPanel.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 230, 40));

        Save.setBorderPainted(false);
        Save.setContentAreaFilled(false);
        Save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveMouseClicked(evt);
            }
        });
        BGPanel.add(Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 100, 40));

        Back.setBorderPainted(false);
        Back.setContentAreaFilled(false);
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });
        Back.addActionListener(this::BackActionPerformed);
        BGPanel.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 20, 20));

        Clear.setBorderPainted(false);
        Clear.setContentAreaFilled(false);
        Clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearMouseClicked(evt);
            }
        });
        Clear.addActionListener(this::ClearActionPerformed);
        BGPanel.add(Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 100, 40));

        EditBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Faculty.png"))); // NOI18N
        BGPanel.add(EditBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BGPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BGPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClearActionPerformed

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BackMouseClicked

    private void SaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveMouseClicked
        // TODO add your handling code here:
        String id = FacultyID.getText().trim();
        String name = Name.getText().trim();
        String email = Email.getText().trim();
        String city = City.getText().trim();
        String employment = EmploymentType.getSelectedItem().toString();
        String department = Department.getSelectedItem().toString();
        String college = College.getSelectedItem().toString();

        if (name.isEmpty() || email.isEmpty() || city.isEmpty() ||
            employment.equals("- Select Employment Type -") || department.equals("- Select Department -") ||
            college.equals("- Select College -"))
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Please complete all fields.", "Incomplete", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        FEditSaveConfirm dialog = new FEditSaveConfirm((java.awt.Frame)null, true);
        dialog.setVisible(true);
        if (!dialog.isConfirmed()) return;

        boolean success = FacultyManager.updateFaculty(id, name, department,employment,
                              college, email, city);

        if (success) {
            javax.swing.JOptionPane.showMessageDialog(this, "Student updated successfully!");
            if (parentPanel != null) {
                parentPanel.refreshTable(); 
            }
            this.dispose();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Failed to update record.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SaveMouseClicked

    private void CityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CityActionPerformed

    private void ClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearMouseClicked
        // TODO add your handling code here:
        Name.setText("");
        Email.setText("");
        City.setText("");
        Department.setSelectedIndex(0);
        EmploymentType.setSelectedIndex(0);
        College.setSelectedIndex(0);
    }//GEN-LAST:event_ClearMouseClicked

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    public void loadFacultyDetails(String id) {
        String[] data = FacultyManager.getFaculty(id);
        if (data != null) {
            FacultyID.setText(data[0]);
            Name.setText(data[1]);
            Department.setSelectedItem(data[2]);
            EmploymentType.setSelectedItem(data[3]);
            College.setSelectedItem(data[4]);
            Email.setText(data[5]);
            City.setText(data[6]);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: Faculty not found!");
            this.dispose();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BGPanel;
    private javax.swing.JButton Back;
    private javax.swing.JTextField City;
    private javax.swing.JButton Clear;
    private javax.swing.JComboBox<String> College;
    private javax.swing.JComboBox<String> Department;
    private javax.swing.JLabel EditBG;
    private javax.swing.JTextField Email;
    private javax.swing.JComboBox<String> EmploymentType;
    private javax.swing.JTextField FacultyID;
    private javax.swing.JLabel Header;
    private javax.swing.JTextField Name;
    private javax.swing.JButton Save;
    // End of variables declaration//GEN-END:variables
}
