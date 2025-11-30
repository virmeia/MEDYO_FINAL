package com.udj.gui;

import com.udj.gui.components.StudentActionCellEditor;
import com.udj.gui.components.ActionCellRenderer;
import com.udj.gui.components.CustomComboBox;
import com.udj.gui.components.CustomScrollBarUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;
import com.udj.logic.StudentManager;
import javax.swing.table.DefaultTableModel;

public class StudentManagement extends javax.swing.JPanel {
    
    private static final String PLACEHOLDER_TEXT = "Search Name or ID";
    private final AdminDB parentFrame;

    public StudentManagement(AdminDB parentFrame) {
        this.parentFrame = parentFrame;
        initComponents();
        
        styleTable();
        styleScrollBar();
        DashboardC1.setVisible(false);
        StudentC1.setVisible(true);
        FacultyC1.setVisible(false);
        CoursesnCurriC1.setVisible(false);
        SystemC1.setVisible(false);       
        StudentScrollPane.setBorder(null);
        StudentScrollPane.getViewport().setOpaque(true);
        StudentScrollPane.getViewport().setBackground(Color.decode("#F4E8FA")); 
        StudentScrollPane.setBorder(BorderFactory.createEmptyBorder());
        CustomComboBox.applyStyle(CollegeCB);
        CollegeCB.setBorder(new LineBorder(new Color(0x8750A6), 1, true)); 
        loadStudentData();
        setupActionColumn(); 
        Search.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) { loadStudentData(); }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) { loadStudentData(); }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) { loadStudentData(); }
        });
    }
    
    private void setupActionColumn() {
        StudentTable.getColumnModel().getColumn(6).setCellRenderer(new ActionCellRenderer());
        StudentTable.getColumnModel().getColumn(6).setCellEditor(new StudentActionCellEditor(StudentTable, this));
        StudentTable.setRowHeight(30);
    }
    
     private void loadStudentData() {
        DefaultTableModel model = (DefaultTableModel) StudentTable.getModel();
        model.setRowCount(0); 
        
        String selectedFilter = (String) CollegeCB.getSelectedItem();
        String targetCollegeName = "";
        if (selectedFilter != null) {
            targetCollegeName = switch (selectedFilter) {
                case "COS" -> "College of Science";
                case "COE" -> "College of Engineering";
                case "CLA" -> "College of Liberal Arts";
                default -> "ALL";
            };
        }
        
        String searchText = Search.getText().trim();
        if (searchText.equals("Search Name or ID")) {
            searchText = "";
        }
        searchText = searchText.toLowerCase();
        
        java.util.List<String[]> students = StudentManager.getAllStudents();
        
        for (String[] student : students) {
            String id = student[0];
            String name = student[1];
            String studentCollege = student[4];

            boolean matchesCollege = "ALL".equals(targetCollegeName) || studentCollege.equals(targetCollegeName);
            boolean matchesSearch = searchText.isEmpty() || 
                                    id.toLowerCase().contains(searchText) || 
                                    name.toLowerCase().contains(searchText);

            if (matchesCollege && matchesSearch) {
                Object[] row = {
                    student[0], 
                    student[1], 
                    student[2], 
                    student[5], 
                    student[3], 
                    student[6], 
                    "⋮"         
                };
                model.addRow(row);
            }
        }   
    }
    
    public void refreshTable() {
        loadStudentData();
        StudentTable.revalidate();
        StudentTable.repaint();
    }
    
    private void styleScrollBar() {
        JScrollBar verticalBar = StudentScrollPane.getVerticalScrollBar();
        verticalBar.setUI(new CustomScrollBarUI());
        verticalBar.setPreferredSize(new Dimension(5, Integer.MAX_VALUE));

        JScrollBar horizontalBar = StudentScrollPane.getHorizontalScrollBar();
        horizontalBar.setUI(new CustomScrollBarUI());
        horizontalBar.setPreferredSize(new Dimension(Integer.MAX_VALUE, 10));
    }
    
    private void styleTable() {
        StudentTable.getTableHeader().setOpaque(false);
        StudentTable.getTableHeader().setBackground(Color.decode("#8f6da0")); 
        StudentTable.getTableHeader().setForeground(Color.WHITE);
        StudentTable.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        StudentTable.setBackground(Color.decode("#F4E8FA"));
        StudentTable.setForeground(Color.decode("#2E1448"));
        StudentTable.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        StudentTable.setSelectionBackground(Color.decode("#C8A8D8"));
        StudentTable.setSelectionForeground(Color.decode("#2E1448"));
        StudentTable.setShowGrid(true);
        StudentTable.setGridColor(new Color(140, 104, 160, 25)); 
        StudentTable.setIntercellSpacing(new java.awt.Dimension(4, 1));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StudentScrollPane = new javax.swing.JScrollPane();
        StudentTable = new javax.swing.JTable();
        CollegeCB = new javax.swing.JComboBox<>();
        Search = new javax.swing.JTextField();
        AddStudentC = new javax.swing.JLabel();
        AutoPromoteC = new javax.swing.JLabel();
        CoursesnCurriC = new javax.swing.JButton();
        SystemC = new javax.swing.JButton();
        DashboardC = new javax.swing.JButton();
        FacultyC = new javax.swing.JButton();
        DashboardC1 = new com.udj.gui.components.ButtonBG();
        StudentC1 = new com.udj.gui.components.ButtonBG();
        FacultyC1 = new com.udj.gui.components.ButtonBG();
        CoursesnCurriC1 = new com.udj.gui.components.ButtonBG();
        SystemC1 = new com.udj.gui.components.ButtonBG();
        StudentMBG = new com.udj.gui.components.ButtonLabelBG();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        StudentScrollPane.setBackground(new java.awt.Color(238, 221, 242));
        StudentScrollPane.setBorder(null);
        StudentScrollPane.setColumnHeaderView(null);

        StudentTable.setAutoCreateRowSorter(true);
        StudentTable.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        StudentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Program", "Year", "Department", "Status", "Actions"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        StudentTable.setGridColor(new java.awt.Color(143, 109, 160));
        StudentTable.setOpaque(false);
        StudentTable.setShowGrid(false);
        StudentTable.getTableHeader().setResizingAllowed(false);
        StudentTable.getTableHeader().setReorderingAllowed(false);
        StudentScrollPane.setViewportView(StudentTable);
        if (StudentTable.getColumnModel().getColumnCount() > 0) {
            StudentTable.getColumnModel().getColumn(0).setResizable(false);
            StudentTable.getColumnModel().getColumn(0).setPreferredWidth(40);
            StudentTable.getColumnModel().getColumn(1).setResizable(false);
            StudentTable.getColumnModel().getColumn(1).setPreferredWidth(90);
            StudentTable.getColumnModel().getColumn(2).setResizable(false);
            StudentTable.getColumnModel().getColumn(3).setResizable(false);
            StudentTable.getColumnModel().getColumn(3).setPreferredWidth(25);
            StudentTable.getColumnModel().getColumn(4).setResizable(false);
            StudentTable.getColumnModel().getColumn(5).setResizable(false);
            StudentTable.getColumnModel().getColumn(5).setPreferredWidth(25);
            StudentTable.getColumnModel().getColumn(6).setResizable(false);
            StudentTable.getColumnModel().getColumn(6).setPreferredWidth(45);
        }

        add(StudentScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 216, 697, 344));

        CollegeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "COS", "COE", "CLA" }));
        CollegeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CollegeCBActionPerformed(evt);
            }
        });
        add(CollegeCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 66, 20));

        Search.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Search.setForeground(new java.awt.Color(102, 102, 102));
        Search.setText("Search Name or ID"); // NOI18N
        Search.setBorder(null);
        Search.setPreferredSize(new java.awt.Dimension(180, 25));
        Search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SearchFocusLost(evt);
            }
        });
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(793, 103, 130, 17));
        Search.setOpaque(false);

        AddStudentC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddStudentC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddStudentCMouseClicked(evt);
            }
        });
        add(AddStudentC, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 170, 70, 22));

        AutoPromoteC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AutoPromoteC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AutoPromoteCMouseClicked(evt);
            }
        });
        add(AutoPromoteC, new org.netbeans.lib.awtextra.AbsoluteConstraints(773, 170, 86, 22));

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
        add(CoursesnCurriC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 160, 35));

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
        add(SystemC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 160, 35));

        DashboardC.setBorderPainted(false);
        DashboardC.setContentAreaFilled(false);
        DashboardC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardC.setFocusPainted(false);
        DashboardC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardCMouseExited(evt);
            }
        });
        add(DashboardC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 160, 35));

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
        add(FacultyC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 160, 35));

        DashboardC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DashboardAdminC1.png"))); // NOI18N
        DashboardC1.setBorderPainted(false);
        DashboardC1.setContentAreaFilled(false);
        add(DashboardC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 229, 162, 37));

        StudentC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/StudentAdminC1.png"))); // NOI18N
        StudentC1.setBorderPainted(false);
        StudentC1.setContentAreaFilled(false);
        add(StudentC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 290, 162, 37));

        FacultyC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FacultyAdminC1.png"))); // NOI18N
        FacultyC1.setBorderPainted(false);
        FacultyC1.setContentAreaFilled(false);
        add(FacultyC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 351, 160, 40));

        CoursesnCurriC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CourseAdminC1.png"))); // NOI18N
        CoursesnCurriC1.setBorderPainted(false);
        CoursesnCurriC1.setContentAreaFilled(false);
        add(CoursesnCurriC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 409, 160, 40));

        SystemC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SystemAdminC1.png"))); // NOI18N
        SystemC1.setBorderPainted(false);
        SystemC1.setContentAreaFilled(false);
        add(SystemC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 472, 160, 38));

        StudentMBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SMBG.png"))); // NOI18N
        add(StudentMBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void SearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchFocusGained
        if (Search.getText().equals(PLACEHOLDER_TEXT)) {
            Search.setText("");
            Search.setForeground(java.awt.Color.BLACK);
        }
    }//GEN-LAST:event_SearchFocusGained

    private void SearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchFocusLost
        if (Search.getText().trim().isEmpty()) {
            Search.setText(PLACEHOLDER_TEXT);
            Search.setForeground(java.awt.Color.GRAY);
        }
    }//GEN-LAST:event_SearchFocusLost

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        loadStudentData();
    }//GEN-LAST:event_SearchActionPerformed

    private void CollegeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CollegeCBActionPerformed
        loadStudentData();
    }//GEN-LAST:event_CollegeCBActionPerformed

    private void AddStudentCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddStudentCMouseClicked
        java.awt.EventQueue.invokeLater(() -> {
            AddStudent dialog = new AddStudent(parentFrame, true, this);
            dialog.setLocationRelativeTo(parentFrame);
            dialog.setVisible(true);
        });
    }//GEN-LAST:event_AddStudentCMouseClicked

    private void AutoPromoteCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AutoPromoteCMouseClicked

    }//GEN-LAST:event_AutoPromoteCMouseClicked

    private void DashboardCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardCMouseClicked
        parentFrame.showDashboard();
    }//GEN-LAST:event_DashboardCMouseClicked

    private void DashboardCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardCMouseEntered
        DashboardC1.setVisible(true);
        DashboardC1.repaint();
    }//GEN-LAST:event_DashboardCMouseEntered

    private void DashboardCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardCMouseExited
        DashboardC1.setVisible(false);
    }//GEN-LAST:event_DashboardCMouseExited

    private void FacultyCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FacultyCMouseClicked
        parentFrame.showPanel("FACULTY_MANAGEMENT");
        refreshTable();
    }//GEN-LAST:event_FacultyCMouseClicked

    private void FacultyCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FacultyCMouseEntered
        FacultyC1.setVisible(true);
        FacultyC1.repaint();
    }//GEN-LAST:event_FacultyCMouseEntered

    private void FacultyCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FacultyCMouseExited
        FacultyC1.setVisible(false);
    }//GEN-LAST:event_FacultyCMouseExited

    private void CoursesnCurriCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CoursesnCurriCMouseClicked
        parentFrame.showPanel("COURSES_AND_CURRICULUM");
    }//GEN-LAST:event_CoursesnCurriCMouseClicked

    private void CoursesnCurriCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CoursesnCurriCMouseEntered
        CoursesnCurriC1.setVisible(true);
        CoursesnCurriC1.repaint();
    }//GEN-LAST:event_CoursesnCurriCMouseEntered

    private void CoursesnCurriCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CoursesnCurriCMouseExited
        CoursesnCurriC1.setVisible(false);
    }//GEN-LAST:event_CoursesnCurriCMouseExited

    private void SystemCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SystemCMouseClicked
        parentFrame.showPanel("SYSTEM_AND_ACCOUNT");
    }//GEN-LAST:event_SystemCMouseClicked

    private void SystemCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SystemCMouseEntered
        SystemC1.setVisible(true);
        SystemC1.repaint();
    }//GEN-LAST:event_SystemCMouseEntered

    private void SystemCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SystemCMouseExited
        SystemC1.setVisible(false);
    }//GEN-LAST:event_SystemCMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddStudentC;
    private javax.swing.JLabel AutoPromoteC;
    private javax.swing.JComboBox<String> CollegeCB;
    private javax.swing.JButton CoursesnCurriC;
    private javax.swing.JButton CoursesnCurriC1;
    private javax.swing.JButton DashboardC;
    private javax.swing.JButton DashboardC1;
    private javax.swing.JButton FacultyC;
    private javax.swing.JButton FacultyC1;
    private javax.swing.JTextField Search;
    private javax.swing.JButton StudentC1;
    private javax.swing.JLabel StudentMBG;
    private javax.swing.JScrollPane StudentScrollPane;
    private javax.swing.JTable StudentTable;
    private javax.swing.JButton SystemC;
    private javax.swing.JButton SystemC1;
    // End of variables declaration//GEN-END:variables
}
