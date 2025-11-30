package com.udj.gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

public class StatusEvaluationPanel extends javax.swing.JPanel {

    private TeacherDB parentFrame;
    private String teacherID;
    private List<EvaluationData> allEvaluations;
    
    public StatusEvaluationPanel(TeacherDB parentFrame) {  
        this.parentFrame = parentFrame;
        initComponents();
        SchedC.addActionListener(evt -> parentFrame.showPanel("SCHEDULE"));
        ViewC.addActionListener(evt -> parentFrame.showPanel("VIEW"));
        GradeC.addActionListener(evt -> parentFrame.showPanel("GRADES"));
        SchedC1.setVisible(false);
        ViewC1.setVisible(false);
        GradeC1.setVisible(false);
        allEvaluations = new ArrayList<>();
    }
    
    public void setTeacherID(String teacherID) {
        System.out.println("DEBUG: setTeacherID called with: " + teacherID);
        this.teacherID = teacherID;
        loadAllEvaluations();
        System.out.println("DEBUG: Found " + allEvaluations.size() + " evaluations");
        populateSubjectComboBox();
        loadStudentData(); 
    }
    
    private void loadAllEvaluations() {
        String filePath = "src/main/resources/data/EvaluationsData.txt";
        allEvaluations.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");

                if (data.length >= 8 && data[0].equals(teacherID)) {
                    EvaluationData eval = new EvaluationData();
                    eval.courseCode = data[1];
                    eval.rate1 = data[2];
                    eval.rate2 = data[3];
                    eval.rate3 = data[4];
                    eval.rate4 = data[5];
                    eval.rate5 = data[6];
                    eval.overallAverage = data[7];

                    if (data.length > 8) {
                        StringBuilder commentBuilder = new StringBuilder();
                        for (int i = 8; i < data.length; i++) {
                            if (!data[i].trim().isEmpty()) {
                                if (commentBuilder.length() > 0) {
                                    commentBuilder.append("\n");
                                }
                                commentBuilder.append(data[i].trim());
                            }
                        }
                        eval.comments = commentBuilder.length() > 0 ? commentBuilder.toString() : "No comments";
                    } else {
                        eval.comments = "No comments";
                    }

                    allEvaluations.add(eval);
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading evaluation file: " + e.getMessage());
        }
    }
    
    private void populateSubjectComboBox() {
        SubjectDB.removeAllItems();
       
        if (allEvaluations.size() > 1) {
            SubjectDB.setVisible(true);
            
            for (EvaluationData eval : allEvaluations) {
                SubjectDB.addItem(eval.courseCode);
            }
        } else if (allEvaluations.size() == 1) {
            
            SubjectDB.setVisible(false);
            
            SubjectDB.addItem(allEvaluations.get(0).courseCode);
        } else {
            
            SubjectDB.setVisible(false);
        }
    }
    
    private void loadStudentData() {
        String selectedSubject = (String) SubjectDB.getSelectedItem();
        
        if (selectedSubject == null || allEvaluations.isEmpty()) {
            displayNoData();
            return;
        }
        
        displaySpecificCourse(selectedSubject);
    }
    
    private void displayAllCoursesAverage() {
        if (allEvaluations.isEmpty()) {
            displayNoData();
            return;
        }

        double totalRate1 = 0, totalRate2 = 0, totalRate3 = 0;
        double totalRate4 = 0, totalRate5 = 0, totalOverall = 0;

        for (EvaluationData eval : allEvaluations) {
            totalRate1 += Double.parseDouble(eval.rate1);
            totalRate2 += Double.parseDouble(eval.rate2);
            totalRate3 += Double.parseDouble(eval.rate3);
            totalRate4 += Double.parseDouble(eval.rate4);
            totalRate5 += Double.parseDouble(eval.rate5);
            totalOverall += Double.parseDouble(eval.overallAverage);
        }

        int count = allEvaluations.size();

        Rate1.setText(String.format("%.2f", totalRate1 / count));
        Rate2.setText(String.format("%.2f", totalRate2 / count));
        Rate3.setText(String.format("%.2f", totalRate3 / count));
        Rate4.setText(String.format("%.2f", totalRate4 / count));
        Rate5.setText(String.format("%.2f", totalRate5 / count));
        AveRate.setText(String.format("%.2f", totalOverall / count));

        StringBuilder allComments = new StringBuilder();

        for (EvaluationData eval : allEvaluations) {
            allComments.append(eval.courseCode).append(":\n");
            allComments.append(eval.comments).append("\n\n");
        }

        JTextArea commentsArea = new JTextArea();
        commentsArea.setText(allComments.toString().trim());
        commentsArea.setWrapStyleWord(true);
        commentsArea.setLineWrap(true);
        commentsArea.setEditable(false);
        commentsArea.setFont(new java.awt.Font("Arial", 0, 12));
        commentsArea.setBackground(new java.awt.Color(255, 255, 255));
        commentsArea.setCaretPosition(0);
        Comments.setViewportView(commentsArea);
    }
    
    private void displaySpecificCourse(String courseCode) {
        EvaluationData eval = null;
    
        for (EvaluationData e : allEvaluations) {
            if (e.courseCode.equals(courseCode)) {
                eval = e;
                break;
            }
        }

        if (eval == null) {
            displayNoData();
            return;
        }

        Rate1.setText(eval.rate1);
        Rate2.setText(eval.rate2);
        Rate3.setText(eval.rate3);
        Rate4.setText(eval.rate4);
        Rate5.setText(eval.rate5);
        AveRate.setText(eval.overallAverage);

        JTextArea commentsArea = new JTextArea();
        commentsArea.setText(eval.comments);
        commentsArea.setWrapStyleWord(true);
        commentsArea.setLineWrap(true);
        commentsArea.setEditable(false);
        commentsArea.setFont(new java.awt.Font("Arial", 0, 12));
        commentsArea.setBackground(new java.awt.Color(255, 255, 255));
        commentsArea.setCaretPosition(0);
        Comments.setViewportView(commentsArea);
    }
    
    private void displayNoData() {
        Rate1.setText("N/A");
        Rate2.setText("N/A");
        Rate3.setText("N/A");
        Rate4.setText("N/A");
        Rate5.setText("N/A");
        AveRate.setText("N/A");
        
        JTextArea commentsArea = new JTextArea();
        commentsArea.setText("No evaluation data available.");
        commentsArea.setWrapStyleWord(true);
        commentsArea.setLineWrap(true);
        commentsArea.setEditable(false);
        commentsArea.setFont(new java.awt.Font("Arial", 0, 14));
        commentsArea.setBackground(new java.awt.Color(255, 255, 255));
        Comments.setViewportView(commentsArea);
    }
    
    private class EvaluationData {
        String courseCode;
        String rate1, rate2, rate3, rate4, rate5;
        String overallAverage;
        String comments;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Comments = new javax.swing.JScrollPane();
        SubjectDB = new javax.swing.JComboBox<>();
        AveRate = new javax.swing.JLabel();
        Rate5 = new javax.swing.JLabel();
        Rate4 = new javax.swing.JLabel();
        Rate3 = new javax.swing.JLabel();
        Rate2 = new javax.swing.JLabel();
        Rate1 = new javax.swing.JLabel();
        ViewC = new javax.swing.JButton();
        SchedC = new javax.swing.JButton();
        GradeC = new javax.swing.JButton();
        ViewC1 = new javax.swing.JButton();
        GradeC1 = new javax.swing.JButton();
        SchedC1 = new javax.swing.JButton();
        BGPanel = new javax.swing.JLabel();

        setToolTipText("");
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(Comments, new org.netbeans.lib.awtextra.AbsoluteConstraints(658, 204, 270, 230));

        SubjectDB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SubjectDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubjectDBActionPerformed(evt);
            }
        });
        add(SubjectDB, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 92, 66, 20));

        AveRate.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        AveRate.setForeground(new java.awt.Color(46, 20, 72));
        AveRate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(AveRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 405, 90, 20));

        Rate5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Rate5.setForeground(new java.awt.Color(46, 20, 72));
        Rate5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(Rate5, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 356, 90, 20));

        Rate4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Rate4.setForeground(new java.awt.Color(46, 20, 72));
        Rate4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(Rate4, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 314, 90, 20));

        Rate3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Rate3.setForeground(new java.awt.Color(46, 20, 72));
        Rate3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(Rate3, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 280, 90, 20));

        Rate2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Rate2.setForeground(new java.awt.Color(46, 20, 72));
        Rate2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(Rate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 244, 90, 20));

        Rate1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Rate1.setForeground(new java.awt.Color(46, 20, 72));
        Rate1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(Rate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 210, 90, 20));

        ViewC.setBorderPainted(false);
        ViewC.setContentAreaFilled(false);
        ViewC.setRequestFocusEnabled(false);
        ViewC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ViewCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ViewCMouseExited(evt);
            }
        });
        ViewC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewCActionPerformed(evt);
            }
        });
        add(ViewC, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 450, 180, 90));

        SchedC.setBorderPainted(false);
        SchedC.setContentAreaFilled(false);
        SchedC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SchedC.setRequestFocusEnabled(false);
        SchedC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SchedCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SchedCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SchedCMouseExited(evt);
            }
        });
        SchedC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SchedCActionPerformed(evt);
            }
        });
        add(SchedC, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 180, 90));

        GradeC.setBorderPainted(false);
        GradeC.setContentAreaFilled(false);
        GradeC.setRequestFocusEnabled(false);
        GradeC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GradeCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GradeCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GradeCMouseExited(evt);
            }
        });
        GradeC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GradeCActionPerformed(evt);
            }
        });
        add(GradeC, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 450, 180, 90));

        ViewC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ViewButt.png"))); // NOI18N
        ViewC1.setBorderPainted(false);
        ViewC1.setContentAreaFilled(false);
        ViewC1.setRequestFocusEnabled(false);
        add(ViewC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 450, 180, 90));

        GradeC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/StudButt.png"))); // NOI18N
        GradeC1.setBorderPainted(false);
        GradeC1.setContentAreaFilled(false);
        GradeC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GradeC1ActionPerformed(evt);
            }
        });
        add(GradeC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 450, 180, 90));

        SchedC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SchedButt.png"))); // NOI18N
        SchedC1.setBorderPainted(false);
        SchedC1.setContentAreaFilled(false);
        add(SchedC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 180, 90));

        BGPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/StatBG.png"))); // NOI18N
        add(BGPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void GradeC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GradeC1ActionPerformed
       
    }//GEN-LAST:event_GradeC1ActionPerformed

    private void ViewCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewCMouseClicked
        parentFrame.showPanel("VIEW");    
        ViewC1.setVisible(true);
        BGPanel.repaint();
    }//GEN-LAST:event_ViewCMouseClicked

    private void ViewCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewCMouseEntered
        ViewC1.setVisible(true);
    }//GEN-LAST:event_ViewCMouseEntered

    private void ViewCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewCMouseExited
        ViewC1.setVisible(false);
    }//GEN-LAST:event_ViewCMouseExited

    private void ViewCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewCActionPerformed
        
    }//GEN-LAST:event_ViewCActionPerformed

    private void SchedCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SchedCMouseClicked
        parentFrame.showPanel("SCHEDULE");
        
        SchedC1.setVisible(true);
        BGPanel.repaint();
    }//GEN-LAST:event_SchedCMouseClicked

    private void SchedCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SchedCMouseEntered
        SchedC1.setVisible(true);
    }//GEN-LAST:event_SchedCMouseEntered

    private void SchedCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SchedCMouseExited
        SchedC1.setVisible(false);
    }//GEN-LAST:event_SchedCMouseExited

    private void SchedCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SchedCActionPerformed
        
    }//GEN-LAST:event_SchedCActionPerformed

    private void GradeCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GradeCMouseClicked
        parentFrame.showPanel("GRADES");
        GradeC1.setVisible(true);
        BGPanel.repaint();
    }//GEN-LAST:event_GradeCMouseClicked

    private void GradeCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GradeCMouseEntered
        GradeC1.setVisible(true);       
    }//GEN-LAST:event_GradeCMouseEntered

    private void GradeCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GradeCMouseExited
        GradeC1.setVisible(false);
    }//GEN-LAST:event_GradeCMouseExited

    private void GradeCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GradeCActionPerformed
       
    }//GEN-LAST:event_GradeCActionPerformed

    private void SubjectDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubjectDBActionPerformed
        loadStudentData();
    }//GEN-LAST:event_SubjectDBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AveRate;
    private javax.swing.JLabel BGPanel;
    private javax.swing.JScrollPane Comments;
    private javax.swing.JButton GradeC;
    private javax.swing.JButton GradeC1;
    private javax.swing.JLabel Rate1;
    private javax.swing.JLabel Rate2;
    private javax.swing.JLabel Rate3;
    private javax.swing.JLabel Rate4;
    private javax.swing.JLabel Rate5;
    private javax.swing.JButton SchedC;
    private javax.swing.JButton SchedC1;
    private javax.swing.JComboBox<String> SubjectDB;
    private javax.swing.JButton ViewC;
    private javax.swing.JButton ViewC1;
    // End of variables declaration//GEN-END:variables

}
