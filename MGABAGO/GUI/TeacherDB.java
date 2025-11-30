package com.udj.gui;

import javax.swing.JPanel;
import java.awt.CardLayout;

public class TeacherDB extends javax.swing.JFrame {
       
    private final JPanel contentPanel;
    private final CardLayout cardLayout;
    private String currentMenu = "";
    private String teacherID;

    public TeacherDB(String teacherID) {
       this.teacherID = teacherID;
       initComponents();

       cardLayout = new CardLayout();
       contentPanel = new JPanel(cardLayout);
       
       contentPanel.add(new StudentsGradesPanel(this), "GRADES");
       contentPanel.add(new ViewStudentsPanel(this), "VIEW");
       contentPanel.add(new StatusEvaluationPanel(this), "STATUS");
       contentPanel.add(new SchedulePanel(this), "SCHEDULE");

       BGPanel.add(contentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));
       contentPanel.setVisible(false);
       
       SchedC1.setVisible(false);
       GradeC1.setVisible(false);
       EvalC1.setVisible(false);
       ViewC1.setVisible(false);
       BackC1.setVisible(false);
    }
    
    public void showPanel(String name) {
        cardLayout.show(contentPanel, name);
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGPanel = new javax.swing.JPanel();
        BackC = new javax.swing.JButton();
        EvalC = new javax.swing.JButton();
        GradeC = new javax.swing.JButton();
        SchedC = new javax.swing.JButton();
        ViewC = new javax.swing.JButton();
        EvalC1 = new javax.swing.JButton();
        BackC1 = new javax.swing.JButton();
        GradeC1 = new javax.swing.JButton();
        SchedC1 = new javax.swing.JButton();
        ViewC1 = new javax.swing.JButton();
        TMSlabel = new com.udj.gui.components.ButtonLabelBG();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BGPanel.setOpaque(false);
        BGPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BackC.setBorder(null);
        BackC.setBorderPainted(false);
        BackC.setContentAreaFilled(false);
        BackC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BackC.setFocusPainted(false);
        BackC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackCMouseExited(evt);
            }
        });
        BackC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackCActionPerformed(evt);
            }
        });
        BGPanel.add(BackC, new org.netbeans.lib.awtextra.AbsoluteConstraints(938, 11, 37, 37));

        EvalC.setBorder(null);
        EvalC.setBorderPainted(false);
        EvalC.setContentAreaFilled(false);
        EvalC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EvalC.setFocusPainted(false);
        EvalC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EvalCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EvalCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EvalCMouseExited(evt);
            }
        });
        EvalC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EvalCActionPerformed(evt);
            }
        });
        BGPanel.add(EvalC, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 180, 90));

        GradeC.setBorderPainted(false);
        GradeC.setContentAreaFilled(false);
        GradeC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GradeC.setFocusPainted(false);
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
        BGPanel.add(GradeC, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, 170, 80));

        SchedC.setBorderPainted(false);
        SchedC.setContentAreaFilled(false);
        SchedC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SchedC.setFocusPainted(false);
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
        BGPanel.add(SchedC, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 180, 90));

        ViewC.setBorderPainted(false);
        ViewC.setContentAreaFilled(false);
        ViewC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ViewC.setFocusPainted(false);
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
        BGPanel.add(ViewC, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 450, 180, 90));

        EvalC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/StatButt.png"))); // NOI18N
        EvalC1.setBorderPainted(false);
        EvalC1.setContentAreaFilled(false);
        BGPanel.add(EvalC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 240, 130));

        BackC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackButton.png"))); // NOI18N
        BackC1.setBorderPainted(false);
        BackC1.setContentAreaFilled(false);
        BackC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackC1ActionPerformed(evt);
            }
        });
        BGPanel.add(BackC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(926, 11, 60, 40));

        GradeC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/StudButt.png"))); // NOI18N
        GradeC1.setBorderPainted(false);
        GradeC1.setContentAreaFilled(false);
        BGPanel.add(GradeC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 450, 230, -1));

        SchedC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SchedButt.png"))); // NOI18N
        SchedC1.setBorderPainted(false);
        SchedC1.setContentAreaFilled(false);
        BGPanel.add(SchedC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 447, 220, 100));

        ViewC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ViewButt.png"))); // NOI18N
        ViewC1.setBorderPainted(false);
        ViewC1.setContentAreaFilled(false);
        BGPanel.add(ViewC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 440, 240, 110));

        TMSlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TeacherDB.png"))); // NOI18N
        BGPanel.add(TMSlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        getContentPane().add(BGPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
  
    private void GradeCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GradeCActionPerformed

    }//GEN-LAST:event_GradeCActionPerformed

    private void GradeCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GradeCMouseExited
        if (!currentMenu.equals("GRADES")) {
            GradeC1.setVisible(false);
        }
    }//GEN-LAST:event_GradeCMouseExited

    private void GradeCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GradeCMouseEntered
        GradeC1.setVisible(true);
        GradeC1.repaint();
        BGPanel.repaint();
    }//GEN-LAST:event_GradeCMouseEntered

    private void GradeCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GradeCMouseClicked
        currentMenu = "GRADES"; 
        contentPanel.setVisible(true);
        cardLayout.show(contentPanel, "GRADES");
        GradeC1.setVisible(true);
        EvalC1.setVisible(false);
        SchedC1.setVisible(false);
        ViewC1.setVisible(false);
        TMSlabel.setVisible(false);
        BGPanel.repaint();
    }//GEN-LAST:event_GradeCMouseClicked

    private void SchedCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SchedCActionPerformed

    }//GEN-LAST:event_SchedCActionPerformed

    private void SchedCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SchedCMouseExited
        if (!currentMenu.equals("SCHEDULE")) {
            SchedC1.setVisible(false);
        }
    }//GEN-LAST:event_SchedCMouseExited

    private void SchedCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SchedCMouseEntered
        SchedC1.setVisible(true);
        SchedC1.repaint();
        BGPanel.repaint();
    }//GEN-LAST:event_SchedCMouseEntered

    private void SchedCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SchedCMouseClicked
        currentMenu = "SCHEDULE"; 
        contentPanel.setVisible(true);
        cardLayout.show(contentPanel, "SCHEDULE");
        SchedC1.setVisible(true);
        EvalC1.setVisible(false);
        GradeC1.setVisible(false);
        ViewC1.setVisible(false);
        TMSlabel.setVisible(false);
        BGPanel.repaint();
    }//GEN-LAST:event_SchedCMouseClicked

    private void EvalCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EvalCActionPerformed

    }//GEN-LAST:event_EvalCActionPerformed

    private void EvalCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvalCMouseExited
        if (!currentMenu.equals("STATUS")) {
            EvalC1.setVisible(false);
        }
    }//GEN-LAST:event_EvalCMouseExited

    private void EvalCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvalCMouseEntered
        EvalC1.setVisible(true);
        EvalC1.repaint();
        BGPanel.repaint();
    }//GEN-LAST:event_EvalCMouseEntered

    private void EvalCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvalCMouseClicked
        currentMenu = "STATUS"; 
        contentPanel.setVisible(true);
        
        // ADDED: Load teacher evaluation data when showing STATUS panel
        StatusEvaluationPanel statusPanel = (StatusEvaluationPanel) contentPanel.getComponent(2);
        statusPanel.setTeacherID(this.teacherID);
        
        cardLayout.show(contentPanel, "STATUS");
        EvalC1.setVisible(true);
        SchedC1.setVisible(false);
        GradeC1.setVisible(false);
        ViewC1.setVisible(false);
        TMSlabel.setVisible(false);
        BGPanel.repaint();
    }//GEN-LAST:event_EvalCMouseClicked

    private void ViewCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewCMouseClicked
        currentMenu = "VIEW"; 
        contentPanel.setVisible(true);
        cardLayout.show(contentPanel, "VIEW");
        ViewC1.setVisible(true);
        EvalC1.setVisible(false);
        SchedC1.setVisible(false);
        GradeC1.setVisible(false);
        TMSlabel.setVisible(false);
        BGPanel.repaint();  
    }//GEN-LAST:event_ViewCMouseClicked

    private void ViewCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewCMouseEntered
        ViewC1.setVisible(true);
        ViewC1.repaint();
        BGPanel.repaint();
    }//GEN-LAST:event_ViewCMouseEntered

    private void ViewCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewCMouseExited
        if (!currentMenu.equals("VIEW")) {
            ViewC1.setVisible(false);
        }
    }//GEN-LAST:event_ViewCMouseExited

    private void ViewCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewCActionPerformed
        
    }//GEN-LAST:event_ViewCActionPerformed

    private void BackCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackCMouseClicked
        TeacherMainScreen teacherProfile = new TeacherMainScreen();
        teacherProfile.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackCMouseClicked

    private void BackCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackCMouseEntered
        BackC1.setVisible(true);
        BackC1.repaint();
        BGPanel.repaint();
    }//GEN-LAST:event_BackCMouseEntered

    private void BackCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackCMouseExited
        BackC1.setVisible(false);
        BGPanel.repaint();
    }//GEN-LAST:event_BackCMouseExited

    private void BackCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackCActionPerformed
        
    }//GEN-LAST:event_BackCActionPerformed

    private void BackC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackC1ActionPerformed
     
    }//GEN-LAST:event_BackC1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BGPanel;
    private javax.swing.JButton BackC;
    private javax.swing.JButton BackC1;
    private javax.swing.JButton EvalC;
    private javax.swing.JButton EvalC1;
    private javax.swing.JButton GradeC;
    private javax.swing.JButton GradeC1;
    private javax.swing.JButton SchedC;
    private javax.swing.JButton SchedC1;
    private javax.swing.JLabel TMSlabel;
    private javax.swing.JButton ViewC;
    private javax.swing.JButton ViewC1;
    // End of variables declaration//GEN-END:variables
}

