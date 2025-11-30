package com.udj.gui;

import com.udj.gui.components.CustomComboBox;
import com.udj.logic.ScheduleManager;
import com.udj.logic.ScheduleUtils;
import javax.swing.JOptionPane;

public class AddEditSchedule extends javax.swing.JDialog {

   private CoursesCurriculumManagement parentPanel;
    private boolean isEditMode = false;
    private String currentID = "";

    public AddEditSchedule(java.awt.Frame parent, boolean modal, CoursesCurriculumManagement panel) {
        super(parent, modal);
        this.parentPanel = panel;
        initComponents();
        setupDropdowns();
       
        SchedID.setText(com.udj.logic.ScheduleManager.generateSchedID());
        SchedID.setEditable(false); 
        SchedID.setFocusable(false);
        SchedID.setRequestFocusEnabled(false);
        BackB.setVisible(false);
    }
    
    public AddEditSchedule(java.awt.Frame parent, boolean modal, CoursesCurriculumManagement panel, 
                           String id, String block, String code, String day, String start, String end, String prof) {
        this(parent, modal, panel);
        this.isEditMode = true;
        this.currentID = id;
        
        SchedID.setText(id);
        SchedID.setEditable(false);
        SchedID.setFocusable(false);
        SchedID.setRequestFocusEnabled(false);
        Block.setSelectedItem(block);
        CourseCode.setSelectedItem(code);
        Day.setSelectedItem(day);
        TimeStart.setSelectedItem(start); 
        TimeEnd.setSelectedItem(end);    
        Instructor.setSelectedItem(prof);
        CourseLabel.setText("EDIT SCHEDULE");
    }

    public AddEditSchedule(java.awt.Frame parent, boolean modal) {
        this(parent, modal, null);
    }
    
    private void setupDropdowns() {
        CustomComboBox.applyStyle(Block); CustomComboBox.applyStyle(CourseCode);
        CustomComboBox.applyStyle(Day); CustomComboBox.applyStyle(TimeStart);
        CustomComboBox.applyStyle(TimeEnd); CustomComboBox.applyStyle(Instructor);
        CustomComboBox.applyScrollbar(TimeStart); CustomComboBox.applyScrollbar(TimeEnd); 
        
        ScheduleUtils.loadBlocksFromStudentData(Block);
        
        Block.addActionListener((java.awt.event.ActionEvent evt) -> {
            String selectedBlock = (String) Block.getSelectedItem();
            ScheduleUtils.filterCoursesByBlock(CourseCode, selectedBlock);
        });
     
        Day.setModel(new javax.swing.DefaultComboBoxModel<>(ScheduleUtils.DAYS));
        TimeStart.setModel(new javax.swing.DefaultComboBoxModel<>(ScheduleUtils.TIME_HOURS));
        TimeEnd.setModel(new javax.swing.DefaultComboBoxModel<>(ScheduleUtils.TIME_HOURS));
        
        CourseCode.addActionListener((java.awt.event.ActionEvent evt) -> {
            String selectedCode = (String) CourseCode.getSelectedItem();
            
            if (selectedCode != null && !selectedCode.startsWith("-")) {
                String desc = ScheduleUtils.getCourseDescription(selectedCode); 
                String dept = ScheduleUtils.getCourseDept(selectedCode);
                ScheduleUtils.loadInstructorsByDept(Instructor, dept);
                lblCourseDesc.setText(desc);
            } else {
                lblCourseDesc.setText("");
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGPanel = new com.udj.gui.components.Background();
        Back = new javax.swing.JLabel();
        BackB = new com.udj.gui.components.ButtonLabelBG();
        ClearC = new javax.swing.JLabel();
        SaveC = new javax.swing.JLabel();
        SchedID = new javax.swing.JTextField();
        Block = new javax.swing.JComboBox<>();
        lblCourseDesc = new javax.swing.JLabel();
        CourseCode = new javax.swing.JComboBox<>();
        Day = new javax.swing.JComboBox<>();
        TimeStart = new javax.swing.JComboBox<>();
        TimeEnd = new javax.swing.JComboBox<>();
        Instructor = new javax.swing.JComboBox<>();
        CourseLabel = new javax.swing.JLabel();
        AddSched = new com.udj.gui.components.ButtonLabelBG();

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
        BGPanel.add(ClearC, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 303, 85, 25));

        SaveC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SaveC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveCMouseClicked(evt);
            }
        });
        BGPanel.add(SaveC, new org.netbeans.lib.awtextra.AbsoluteConstraints(428, 303, 85, 25));

        SchedID.setEditable(false);
        SchedID.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        SchedID.setForeground(new java.awt.Color(102, 102, 102));
        SchedID.setAutoscrolls(false);
        SchedID.setBorder(null);
        SchedID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        SchedID.setOpaque(true);
        SchedID.setRequestFocusEnabled(false);
        BGPanel.add(SchedID, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 84, 280, 20));

        Block.setBackground(new java.awt.Color(242, 216, 255));
        BGPanel.add(Block, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 112, 296, 18));

        lblCourseDesc.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        lblCourseDesc.setForeground(new java.awt.Color(102, 102, 102));
        BGPanel.add(lblCourseDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 140, 240, 20));

        CourseCode.setBackground(new java.awt.Color(242, 216, 255));
        BGPanel.add(CourseCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 140, 296, 18));

        Day.setBackground(new java.awt.Color(242, 216, 255));
        BGPanel.add(Day, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 167, 296, 18));

        TimeStart.setBackground(new java.awt.Color(242, 216, 255));
        BGPanel.add(TimeStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 194, 296, 18));

        TimeEnd.setBackground(new java.awt.Color(242, 216, 255));
        BGPanel.add(TimeEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 222, 296, 18));

        Instructor.setBackground(new java.awt.Color(242, 216, 255));
        BGPanel.add(Instructor, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 249, 296, 18));

        CourseLabel.setFont(new java.awt.Font("Product Sans", 1, 18)); // NOI18N
        CourseLabel.setForeground(new java.awt.Color(255, 255, 255));
        CourseLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CourseLabel.setText("SCHEDULE");
        BGPanel.add(CourseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 40));

        AddSched.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AddSchedule.png"))); // NOI18N
        BGPanel.add(AddSched, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 350));

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
        String block = Block.getSelectedItem().toString();
        String code = CourseCode.getSelectedItem().toString();
        String day = Day.getSelectedItem().toString();
        String start = TimeStart.getSelectedItem().toString();
        String end = TimeEnd.getSelectedItem().toString();
        String prof = Instructor.getSelectedItem().toString();

        if (block.startsWith("-") || code.startsWith("-") || day.startsWith("-") || start.startsWith("-") || end.startsWith("-") || prof.startsWith("-")) {
            JOptionPane.showMessageDialog(this, "Please select all fields.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (start.compareTo(end) >= 0) {
            JOptionPane.showMessageDialog(this, "Start time must be before End time.", "Time Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean success;
        if (isEditMode) {
            success = ScheduleManager.updateSchedule(currentID, block, code, day, start, end, prof);
        } else {
            success = ScheduleManager.addSchedule(block, code, day, start, end, prof);
        }

        if (success) {
            JOptionPane.showMessageDialog(this, isEditMode ? "Schedule Updated!" : "Schedule Added!");
            if (parentPanel != null) parentPanel.loadScheduleData();
            this.dispose();
        }
    }//GEN-LAST:event_SaveCMouseClicked
   
    private void ClearCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearCMouseClicked
        if (!isEditMode) {
            SchedID.setText("");
            Block.setSelectedIndex(0);
            CourseCode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"- Select Block First -"}));
        }
        Day.setSelectedIndex(0);
        TimeStart.setSelectedIndex(0);
        Instructor.setSelectedIndex(0);
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
    private javax.swing.JLabel AddSched;
    private javax.swing.JPanel BGPanel;
    private javax.swing.JLabel Back;
    private javax.swing.JLabel BackB;
    private javax.swing.JComboBox<String> Block;
    private javax.swing.JLabel ClearC;
    private javax.swing.JComboBox<String> CourseCode;
    private javax.swing.JLabel CourseLabel;
    private javax.swing.JComboBox<String> Day;
    private javax.swing.JComboBox<String> Instructor;
    private javax.swing.JLabel SaveC;
    private javax.swing.JTextField SchedID;
    private javax.swing.JComboBox<String> TimeEnd;
    private javax.swing.JComboBox<String> TimeStart;
    private javax.swing.JLabel lblCourseDesc;
    // End of variables declaration//GEN-END:variables
}
