package com.udj.gui;

import com.udj.logic.EvaluationManager;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.UIManager;

public class EvaluationTab extends javax.swing.JDialog {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(EvaluationTab.class.getName());
    private String courseCode;
    private String courseName;
    private String instructor;
    private String studentID;
    
    public EvaluationTab(java.awt.Frame parent, boolean modal, 
                           String courseCode, String courseName, 
                           String instructor, String studentID) {
        super(parent, modal);
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instructor;
        this.studentID = studentID;
        
        initComponents();
        setupButtonGroups();
        setLocationRelativeTo(parent);
        
        CourseLabel.setText(courseName);
        InstructorLabel.setText(instructor);
        
        Submit.addActionListener(this::SubmitButtonActionPerformed); 
        Rating1.setOpaque(false);
        Rating2.setOpaque(false);
        Rating3.setOpaque(false);
        Rating4.setOpaque(false);
        Rating5.setOpaque(false);
        
        Rating1_1.setOpaque(false);
        Rating1_2.setOpaque(false);
        Rating1_3.setOpaque(false);
        Rating1_4.setOpaque(false);
        Rating1_5.setOpaque(false);

        Rating2_1.setOpaque(false);
        Rating2_2.setOpaque(false);
        Rating2_3.setOpaque(false);
        Rating2_4.setOpaque(false);
        Rating2_5.setOpaque(false);

        Rating3_1.setOpaque(false);
        Rating3_2.setOpaque(false);
        Rating3_3.setOpaque(false);
        Rating3_4.setOpaque(false);
        Rating3_5.setOpaque(false);

        Rating4_1.setOpaque(false);
        Rating4_2.setOpaque(false);
        Rating4_3.setOpaque(false);
        Rating4_4.setOpaque(false);
        Rating4_5.setOpaque(false);
        
        UIManager.put("OptionPane.background", new java.awt.Color(242, 216, 255));
        UIManager.put("Panel.background", new java.awt.Color(242, 216, 255));
        UIManager.put("OptionPane.messageForeground", new java.awt.Color(61, 31, 92));
    }
    
    
    private void setupButtonGroups() {
        ButtonGroup group1 = new ButtonGroup();
        group1.add(Rating1);
        group1.add(Rating2);
        group1.add(Rating3);
        group1.add(Rating4);
        group1.add(Rating5);
        
        ButtonGroup group2 = new ButtonGroup();
        group2.add(Rating1_1);
        group2.add(Rating1_2);
        group2.add(Rating1_3);
        group2.add(Rating1_4);
        group2.add(Rating1_5);
        
        ButtonGroup group3 = new ButtonGroup();
        group3.add(Rating2_1);
        group3.add(Rating2_2);
        group3.add(Rating2_3);
        group3.add(Rating2_4);
        group3.add(Rating2_5);
        
        ButtonGroup group4 = new ButtonGroup();
        group4.add(Rating3_1);
        group4.add(Rating3_2);
        group4.add(Rating3_3);
        group4.add(Rating3_4);
        group4.add(Rating3_5);
        
        ButtonGroup group5 = new ButtonGroup();
        group5.add(Rating4_1);
        group5.add(Rating4_2);
        group5.add(Rating4_3);
        group5.add(Rating4_4);
        group5.add(Rating4_5);
    }
    
    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Collect ratings from all 5 groups
        int[] ratings = new int[5];
        boolean allSelected = true;
        
        if (Rating1.isSelected()) ratings[0] = 1;
        else if (Rating2.isSelected()) ratings[0] = 2;
        else if (Rating3.isSelected()) ratings[0] = 3;
        else if (Rating4.isSelected()) ratings[0] = 4;
        else if (Rating5.isSelected()) ratings[0] = 5;
        else allSelected = false;

        if (Rating1_1.isSelected()) ratings[1] = 1;
        else if (Rating1_2.isSelected()) ratings[1] = 2;
        else if (Rating1_3.isSelected()) ratings[1] = 3;
        else if (Rating1_4.isSelected()) ratings[1] = 4;
        else if (Rating1_5.isSelected()) ratings[1] = 5;
        else allSelected = false;

        if (Rating2_1.isSelected()) ratings[2] = 1;
        else if (Rating2_2.isSelected()) ratings[2] = 2;
        else if (Rating2_3.isSelected()) ratings[2] = 3;
        else if (Rating2_4.isSelected()) ratings[2] = 4;
        else if (Rating2_5.isSelected()) ratings[2] = 5;
        else allSelected = false;

        if (Rating3_1.isSelected()) ratings[3] = 1;
        else if (Rating3_2.isSelected()) ratings[3] = 2;
        else if (Rating3_3.isSelected()) ratings[3] = 3;
        else if (Rating3_4.isSelected()) ratings[3] = 4;
        else if (Rating3_5.isSelected()) ratings[3] = 5;
        else allSelected = false;

        if (Rating4_1.isSelected()) ratings[4] = 1;
        else if (Rating4_2.isSelected()) ratings[4] = 2;
        else if (Rating4_3.isSelected()) ratings[4] = 3;
        else if (Rating4_4.isSelected()) ratings[4] = 4;
        else if (Rating4_5.isSelected()) ratings[4] = 5;
        else allSelected = false;

        if (!allSelected) {
            JOptionPane.showMessageDialog(this,
                "Please rate all 5 statements before submitting.",
                "Incomplete Evaluation",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        String comments = CommentText.getText().trim();
        if (comments.isEmpty()) {
            comments = null; 
        }

        boolean success = EvaluationManager.saveEvaluation(
            courseCode, courseName, instructor, ratings, studentID, comments
        );

        if (success) {
            double avg = 0;
            for (int r : ratings) avg += r;
            avg = avg / 5;

            JOptionPane.showMessageDialog(this,
                String.format("Thank you for your feedback.", avg),
                "Success",
                JOptionPane.INFORMATION_MESSAGE);

            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this,
                "Failed to save evaluation. Please try again.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGPanel = new javax.swing.JPanel();
        Comment = new javax.swing.JScrollPane();
        CommentText = new javax.swing.JTextArea();
        InstructorLabel = new javax.swing.JLabel();
        CourseLabel = new javax.swing.JLabel();
        Submit = new javax.swing.JButton();
        Rating4_1 = new javax.swing.JRadioButton();
        Rating4_2 = new javax.swing.JRadioButton();
        Rating4_3 = new javax.swing.JRadioButton();
        Rating4_4 = new javax.swing.JRadioButton();
        Rating4_5 = new javax.swing.JRadioButton();
        Rating3_1 = new javax.swing.JRadioButton();
        Rating3_2 = new javax.swing.JRadioButton();
        Rating3_3 = new javax.swing.JRadioButton();
        Rating3_4 = new javax.swing.JRadioButton();
        Rating3_5 = new javax.swing.JRadioButton();
        Rating2_1 = new javax.swing.JRadioButton();
        Rating2_2 = new javax.swing.JRadioButton();
        Rating2_3 = new javax.swing.JRadioButton();
        Rating2_4 = new javax.swing.JRadioButton();
        Rating2_5 = new javax.swing.JRadioButton();
        Rating1_1 = new javax.swing.JRadioButton();
        Rating1_2 = new javax.swing.JRadioButton();
        Rating1_3 = new javax.swing.JRadioButton();
        Rating1_4 = new javax.swing.JRadioButton();
        Rating1_5 = new javax.swing.JRadioButton();
        Rating1 = new javax.swing.JRadioButton();
        Rating2 = new javax.swing.JRadioButton();
        Rating3 = new javax.swing.JRadioButton();
        Rating4 = new javax.swing.JRadioButton();
        Rating5 = new javax.swing.JRadioButton();
        BGLabel = new javax.swing.JLabel();

        BGPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CommentText.setColumns(20);
        CommentText.setRows(5);
        Comment.setViewportView(CommentText);

        BGPanel.add(Comment, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 470, 30));

        InstructorLabel.setBackground(new java.awt.Color(61, 31, 92));
        InstructorLabel.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        InstructorLabel.setForeground(new java.awt.Color(61, 31, 92));
        BGPanel.add(InstructorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 44, 370, 20));

        CourseLabel.setBackground(new java.awt.Color(61, 31, 92));
        CourseLabel.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        CourseLabel.setForeground(new java.awt.Color(61, 31, 92));
        BGPanel.add(CourseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 20, 390, 20));

        Submit.setBorderPainted(false);
        Submit.setContentAreaFilled(false);
        Submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BGPanel.add(Submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 100, 30));

        Rating4_1.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Rating4_1.addActionListener(this::Rating4_1ActionPerformed);
        BGPanel.add(Rating4_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 216, -1, -1));

        Rating4_2.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Rating4_2.addActionListener(this::Rating4_2ActionPerformed);
        BGPanel.add(Rating4_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 216, -1, -1));

        Rating4_3.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Rating4_3.addActionListener(this::Rating4_3ActionPerformed);
        BGPanel.add(Rating4_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 216, -1, -1));

        Rating4_4.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Rating4_4.addActionListener(this::Rating4_4ActionPerformed);
        BGPanel.add(Rating4_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 216, -1, -1));

        Rating4_5.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Rating4_5.addActionListener(this::Rating4_5ActionPerformed);
        BGPanel.add(Rating4_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 216, -1, -1));

        Rating3_1.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Rating3_1.addActionListener(this::Rating3_1ActionPerformed);
        BGPanel.add(Rating3_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 188, -1, -1));

        Rating3_2.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Rating3_2.addActionListener(this::Rating3_2ActionPerformed);
        BGPanel.add(Rating3_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 188, -1, -1));

        Rating3_3.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Rating3_3.addActionListener(this::Rating3_3ActionPerformed);
        BGPanel.add(Rating3_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 188, -1, -1));

        Rating3_4.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Rating3_4.addActionListener(this::Rating3_4ActionPerformed);
        BGPanel.add(Rating3_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 188, -1, -1));

        Rating3_5.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Rating3_5.addActionListener(this::Rating3_5ActionPerformed);
        BGPanel.add(Rating3_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 188, -1, -1));

        Rating2_1.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Rating2_1.addActionListener(this::Rating2_1ActionPerformed);
        BGPanel.add(Rating2_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 162, -1, -1));

        Rating2_2.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Rating2_2.addActionListener(this::Rating2_2ActionPerformed);
        BGPanel.add(Rating2_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 162, -1, -1));

        Rating2_3.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Rating2_3.addActionListener(this::Rating2_3ActionPerformed);
        BGPanel.add(Rating2_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 162, -1, -1));

        Rating2_4.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Rating2_4.addActionListener(this::Rating2_4ActionPerformed);
        BGPanel.add(Rating2_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 162, -1, -1));

        Rating2_5.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Rating2_5.addActionListener(this::Rating2_5ActionPerformed);
        BGPanel.add(Rating2_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 162, -1, -1));

        Rating1_1.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Rating1_1.addActionListener(this::Rating1_1ActionPerformed);
        BGPanel.add(Rating1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 138, -1, -1));

        Rating1_2.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Rating1_2.addActionListener(this::Rating1_2ActionPerformed);
        BGPanel.add(Rating1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 138, -1, -1));

        Rating1_3.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Rating1_3.addActionListener(this::Rating1_3ActionPerformed);
        BGPanel.add(Rating1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 138, -1, -1));

        Rating1_4.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Rating1_4.addActionListener(this::Rating1_4ActionPerformed);
        BGPanel.add(Rating1_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 138, -1, -1));

        Rating1_5.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Rating1_5.addActionListener(this::Rating1_5ActionPerformed);
        BGPanel.add(Rating1_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 138, -1, -1));

        Rating1.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Rating1.addActionListener(this::Rating1ActionPerformed);
        BGPanel.add(Rating1, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 112, -1, -1));

        Rating2.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Rating2.addActionListener(this::Rating2ActionPerformed);
        BGPanel.add(Rating2, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 112, -1, -1));

        Rating3.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Rating3.addActionListener(this::Rating3ActionPerformed);
        BGPanel.add(Rating3, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 112, -1, -1));

        Rating4.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Rating4.addActionListener(this::Rating4ActionPerformed);
        BGPanel.add(Rating4, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 112, -1, -1));

        Rating5.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Rating5.addActionListener(this::Rating5ActionPerformed);
        BGPanel.add(Rating5, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 112, -1, -1));

        BGLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Evaluation.png"))); // NOI18N
        BGPanel.add(BGLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 400));

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

    private void Rating1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating1ActionPerformed

    private void Rating2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating2ActionPerformed

    private void Rating3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating3ActionPerformed

    private void Rating4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating4ActionPerformed

    private void Rating5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating5ActionPerformed

    private void Rating1_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating1_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating1_1ActionPerformed

    private void Rating1_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating1_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating1_2ActionPerformed

    private void Rating1_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating1_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating1_3ActionPerformed

    private void Rating1_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating1_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating1_4ActionPerformed

    private void Rating1_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating1_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating1_5ActionPerformed

    private void Rating2_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating2_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating2_1ActionPerformed

    private void Rating2_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating2_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating2_2ActionPerformed

    private void Rating2_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating2_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating2_3ActionPerformed

    private void Rating2_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating2_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating2_4ActionPerformed

    private void Rating2_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating2_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating2_5ActionPerformed

    private void Rating3_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating3_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating3_1ActionPerformed

    private void Rating3_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating3_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating3_2ActionPerformed

    private void Rating3_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating3_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating3_3ActionPerformed

    private void Rating3_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating3_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating3_4ActionPerformed

    private void Rating3_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating3_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating3_5ActionPerformed

    private void Rating4_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating4_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating4_1ActionPerformed

    private void Rating4_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating4_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating4_2ActionPerformed

    private void Rating4_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating4_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating4_3ActionPerformed

    private void Rating4_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating4_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating4_4ActionPerformed

    private void Rating4_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating4_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating4_5ActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGLabel;
    private javax.swing.JPanel BGPanel;
    private javax.swing.JScrollPane Comment;
    private javax.swing.JTextArea CommentText;
    private javax.swing.JLabel CourseLabel;
    private javax.swing.JLabel InstructorLabel;
    private javax.swing.JRadioButton Rating1;
    private javax.swing.JRadioButton Rating1_1;
    private javax.swing.JRadioButton Rating1_2;
    private javax.swing.JRadioButton Rating1_3;
    private javax.swing.JRadioButton Rating1_4;
    private javax.swing.JRadioButton Rating1_5;
    private javax.swing.JRadioButton Rating2;
    private javax.swing.JRadioButton Rating2_1;
    private javax.swing.JRadioButton Rating2_2;
    private javax.swing.JRadioButton Rating2_3;
    private javax.swing.JRadioButton Rating2_4;
    private javax.swing.JRadioButton Rating2_5;
    private javax.swing.JRadioButton Rating3;
    private javax.swing.JRadioButton Rating3_1;
    private javax.swing.JRadioButton Rating3_2;
    private javax.swing.JRadioButton Rating3_3;
    private javax.swing.JRadioButton Rating3_4;
    private javax.swing.JRadioButton Rating3_5;
    private javax.swing.JRadioButton Rating4;
    private javax.swing.JRadioButton Rating4_1;
    private javax.swing.JRadioButton Rating4_2;
    private javax.swing.JRadioButton Rating4_3;
    private javax.swing.JRadioButton Rating4_4;
    private javax.swing.JRadioButton Rating4_5;
    private javax.swing.JRadioButton Rating5;
    private javax.swing.JButton Submit;
    // End of variables declaration//GEN-END:variables
}
