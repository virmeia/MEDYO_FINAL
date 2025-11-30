package com.udj.gui;

import com.udj.gui.components.CustomScrollBarUI;
import com.udj.logic.StudentManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

public class ViewStudent extends javax.swing.JDialog {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ViewStudent.class.getName());

    public ViewStudent(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        styleTable();
        styleScrollBar();
        disableEditing();
        GradesScrollPane.setBorder(null);
        GradesScrollPane.getViewport().setOpaque(true);
        GradesScrollPane.getViewport().setBackground(Color.decode("#F4E8FA")); 
        GradesScrollPane.setBorder(BorderFactory.createEmptyBorder());
        BackB.setVisible(false);
    }
    
    private void disableEditing() {
     JTextField[] fields = {
            Name, StudentID, Program, Department, College, 
            YearLevel, Status, Email, City
        };
        for (JTextField field : fields) {
            field.setEditable(false);                  
            field.setOpaque(false);                    
            field.setBorder(null);                     
            field.setFont(new Font("Arial", Font.BOLD, 12)); 
            field.setForeground(new Color(0x2E1448));    // UNIFORM COLOR (Dark Purple)
            field.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Standard pointer
        }
    }
    
    public void loadStudentDetails(String id) {
        String[] data = StudentManager.getStudent(id);
        
        if (data != null) {
            // 0:ID, 1:Name, 2:Prog, 3:Dept, 4:Col, 5:Year, 6:Stat, 7:Email, 8:City            
            StudentID.setText(data[0]);
            Name.setText(data[1]);
            Program.setText(data[2]);
            Department.setText(data[3]);
            College.setText(data[4]);
            YearLevel.setText(data[5]);
            Status.setText(data[6]);
            Email.setText(data[7]);
            City.setText(data[8]);
            
        } else {
            JOptionPane.showMessageDialog(this, "Student not found.");
            this.dispose();
        }
    }
    
    private void styleScrollBar() {
        JScrollBar verticalBar = GradesScrollPane.getVerticalScrollBar();
        verticalBar.setUI(new CustomScrollBarUI());
        verticalBar.setPreferredSize(new Dimension(5, Integer.MAX_VALUE));

        JScrollBar horizontalBar = GradesScrollPane.getHorizontalScrollBar();
        horizontalBar.setUI(new CustomScrollBarUI());
        horizontalBar.setPreferredSize(new Dimension(Integer.MAX_VALUE, 10));
    }
    
    private void styleTable() {
        GradesTable.getTableHeader().setOpaque(false);
        GradesTable.getTableHeader().setBackground(Color.decode("#8f6da0")); 
        GradesTable.getTableHeader().setForeground(Color.WHITE);
        GradesTable.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        GradesTable.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
        GradesTable.setBackground(Color.decode("#F4E8FA"));
        GradesTable.setForeground(Color.decode("#2E1448"));
        GradesTable.setFont(new java.awt.Font("Arial", Font.BOLD, 13));
        GradesTable.setSelectionBackground(Color.decode("#C8A8D8"));
        GradesTable.setSelectionForeground(Color.decode("#2E1448"));
        GradesTable.setShowGrid(true);
        GradesTable.setGridColor(new Color(140, 104, 160, 25)); 
        GradesTable.setIntercellSpacing(new java.awt.Dimension(5, 1));
        javax.swing.table.DefaultTableCellRenderer center = new javax.swing.table.DefaultTableCellRenderer();
        center.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        GradesTable.setDefaultRenderer(Object.class, center);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GradesScrollPane = new javax.swing.JScrollPane();
        GradesTable = new javax.swing.JTable();
        BGPanel = new javax.swing.JPanel();
        Name = new javax.swing.JTextField();
        StudentID = new javax.swing.JTextField();
        Program = new javax.swing.JTextField();
        Department = new javax.swing.JTextField();
        College = new javax.swing.JTextField();
        YearLevel = new javax.swing.JTextField();
        Status = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        City = new javax.swing.JTextField();
        Back = new javax.swing.JLabel();
        BackB = new com.udj.gui.components.ButtonLabelBG();
        StudentInfoL1 = new javax.swing.JLabel();
        StudentInfoL = new javax.swing.JLabel();
        ViewStudentL = new javax.swing.JLabel();
        ViewStudent = new com.udj.gui.components.ButtonLabelBG();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GradesScrollPane.setBackground(new java.awt.Color(238, 221, 242));
        GradesScrollPane.setBorder(null);
        GradesScrollPane.setColumnHeaderView(null);

        GradesTable.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        GradesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Course Code", "Course Name", "Instructor", "Grades"
            }
        ));
        GradesTable.setGridColor(new java.awt.Color(143, 109, 160));
        GradesTable.setOpaque(false);
        GradesTable.setRowHeight(30);
        GradesTable.setShowGrid(false);
        GradesTable.getTableHeader().setReorderingAllowed(false);
        GradesScrollPane.setViewportView(GradesTable);
        if (GradesTable.getColumnModel().getColumnCount() > 0) {
            GradesTable.getColumnModel().getColumn(0).setMinWidth(150);
            GradesTable.getColumnModel().getColumn(0).setPreferredWidth(150);
            GradesTable.getColumnModel().getColumn(0).setMaxWidth(150);
            GradesTable.getColumnModel().getColumn(3).setMinWidth(150);
            GradesTable.getColumnModel().getColumn(3).setPreferredWidth(150);
            GradesTable.getColumnModel().getColumn(3).setMaxWidth(150);
        }

        getContentPane().add(GradesScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 338, 903, 224));

        BGPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Name.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Name.setAutoscrolls(false);
        Name.setBorder(null);
        Name.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Name.setFocusable(false);
        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });
        BGPanel.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 137, 280, 18));
        Name.setOpaque(false);

        StudentID.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        StudentID.setAutoscrolls(false);
        StudentID.setBorder(null);
        StudentID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        StudentID.setFocusable(false);
        StudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentIDActionPerformed(evt);
            }
        });
        BGPanel.add(StudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 163, 280, 18));
        Name.setOpaque(false);

        Program.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Program.setAutoscrolls(false);
        Program.setBorder(null);
        Program.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Program.setFocusable(false);
        Program.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProgramActionPerformed(evt);
            }
        });
        BGPanel.add(Program, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 189, 280, 18));
        Name.setOpaque(false);

        Department.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Department.setAutoscrolls(false);
        Department.setBorder(null);
        Department.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Department.setFocusable(false);
        Department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepartmentActionPerformed(evt);
            }
        });
        BGPanel.add(Department, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 215, 280, 18));
        Name.setOpaque(false);

        College.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        College.setAutoscrolls(false);
        College.setBorder(null);
        College.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        College.setFocusable(false);
        College.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CollegeActionPerformed(evt);
            }
        });
        BGPanel.add(College, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 241, 280, 18));
        Name.setOpaque(false);

        YearLevel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        YearLevel.setAutoscrolls(false);
        YearLevel.setBorder(null);
        YearLevel.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        YearLevel.setFocusable(false);
        YearLevel.setVerifyInputWhenFocusTarget(false);
        YearLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearLevelActionPerformed(evt);
            }
        });
        BGPanel.add(YearLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(639, 137, 280, 18));
        Name.setOpaque(false);

        Status.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Status.setAutoscrolls(false);
        Status.setBorder(null);
        Status.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Status.setFocusable(false);
        Status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusActionPerformed(evt);
            }
        });
        BGPanel.add(Status, new org.netbeans.lib.awtextra.AbsoluteConstraints(639, 163, 280, 18));
        Name.setOpaque(false);

        Email.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Email.setAutoscrolls(false);
        Email.setBorder(null);
        Email.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Email.setFocusable(false);
        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });
        BGPanel.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(639, 189, 280, 18));
        Name.setOpaque(false);

        City.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        City.setAutoscrolls(false);
        City.setBorder(null);
        City.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        City.setFocusable(false);
        City.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CityActionPerformed(evt);
            }
        });
        BGPanel.add(City, new org.netbeans.lib.awtextra.AbsoluteConstraints(639, 215, 280, 18));
        Name.setOpaque(false);

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
        BGPanel.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(957, 16, 28, 28));

        BackB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackIcon.png"))); // NOI18N
        BGPanel.add(BackB, new org.netbeans.lib.awtextra.AbsoluteConstraints(956, 10, 30, 40));

        StudentInfoL1.setFont(new java.awt.Font("Product Sans", 1, 18)); // NOI18N
        StudentInfoL1.setForeground(new java.awt.Color(61, 31, 92));
        StudentInfoL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StudentInfoL1.setText("Student Grades                                ");
        BGPanel.add(StudentInfoL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 360, 90));

        StudentInfoL.setFont(new java.awt.Font("Product Sans", 1, 18)); // NOI18N
        StudentInfoL.setForeground(new java.awt.Color(61, 31, 92));
        StudentInfoL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StudentInfoL.setText("Student Information                       ");
        BGPanel.add(StudentInfoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 360, 100));

        ViewStudentL.setFont(new java.awt.Font("Product Sans", 1, 20)); // NOI18N
        ViewStudentL.setForeground(new java.awt.Color(255, 255, 255));
        ViewStudentL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ViewStudentL.setText("VIEWING STUDENT RECORD");
        BGPanel.add(ViewStudentL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 60));

        ViewStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ViewStudent.png"))); // NOI18N
        BGPanel.add(ViewStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        getContentPane().add(BGPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed

    }//GEN-LAST:event_NameActionPerformed

    private void StudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentIDActionPerformed
      
    }//GEN-LAST:event_StudentIDActionPerformed

    private void ProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProgramActionPerformed
        
    }//GEN-LAST:event_ProgramActionPerformed

    private void DepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepartmentActionPerformed
      
    }//GEN-LAST:event_DepartmentActionPerformed

    private void CollegeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CollegeActionPerformed
       
    }//GEN-LAST:event_CollegeActionPerformed

    private void YearLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearLevelActionPerformed
      
    }//GEN-LAST:event_YearLevelActionPerformed

    private void CityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CityActionPerformed
     
    }//GEN-LAST:event_CityActionPerformed

    private void StatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatusActionPerformed
       
    }//GEN-LAST:event_StatusActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
      
    }//GEN-LAST:event_EmailActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BGPanel;
    private javax.swing.JLabel Back;
    private javax.swing.JLabel BackB;
    private javax.swing.JTextField City;
    private javax.swing.JTextField College;
    private javax.swing.JTextField Department;
    private javax.swing.JTextField Email;
    private javax.swing.JScrollPane GradesScrollPane;
    private javax.swing.JTable GradesTable;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField Program;
    private javax.swing.JTextField Status;
    private javax.swing.JTextField StudentID;
    private javax.swing.JLabel StudentInfoL;
    private javax.swing.JLabel StudentInfoL1;
    private javax.swing.JLabel ViewStudent;
    private javax.swing.JLabel ViewStudentL;
    private javax.swing.JTextField YearLevel;
    // End of variables declaration//GEN-END:variables
}
