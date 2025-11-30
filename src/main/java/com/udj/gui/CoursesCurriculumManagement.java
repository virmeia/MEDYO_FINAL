package com.udj.gui;

import com.udj.gui.components.CustomComboBox;
import com.udj.gui.components.CustomScrollBarUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class CoursesCurriculumManagement extends javax.swing.JPanel {
    
    private final DefaultTableModel courseModel;
    private final DefaultTableModel scheduleModel;
    private static final String PLACEHOLDER_TEXT = "Search Here";
    private final AdminDB parentFrame;

    public CoursesCurriculumManagement(AdminDB parentFrame) {
        this.parentFrame = parentFrame;
        initComponents();
        
        courseModel = (DefaultTableModel) CourseTable.getModel();
        scheduleModel = (DefaultTableModel) ScheduleTable.getModel(); 
        loadCourseData();
        loadScheduleData();  
        styleTable();
        styleScrollBar();
        styleTabbedPane();
        filterAndReloadCourseData();
        DashboardC1.setVisible(false);
        StudentC1.setVisible(false);
        FacultyC1.setVisible(false);
        CoursesnCurriC1.setVisible(true);
        SystemC1.setVisible(false);  
        CustomComboBox.applyStyle(DepartmentCB); CustomComboBox.applyStyle(YearLevelCB); CustomComboBox.applyStyle(SemesterCB);
        DepartmentCB.setBorder(new LineBorder(new Color(0x8750A6), 1, true)); YearLevelCB.setBorder(new LineBorder(new Color(0x8750A6), 1, true)); SemesterCB.setBorder(new LineBorder(new Color(0x8750A6), 1, true));
    }
    
    public void loadCourseData() {
        courseModel.setRowCount(0);

        String selectedDept = DepartmentCB.getSelectedItem().toString();
        String selectedYear = YearLevelCB.getSelectedItem().toString();
        String selectedSemester = SemesterCB.getSelectedItem().toString();

        String deptFilter = selectedDept.equals("Departments") ? "ALL_FILTER" : selectedDept;
        String yearFilter = selectedYear.equals("Year Levels") ? "ALL_FILTER" : selectedYear;
        String semFilter = selectedSemester.equals("Semesters") ? "ALL_FILTER" : selectedSemester;

        List<String[]> courses = com.udj.logic.CourseManager.getAllCourses(); 

        for (String[] row : courses) {
            String rowDept = row[3];      
            String rowYear = row[4];      
            String rowSemester = row[5];  

            boolean deptMatch = deptFilter.equals("ALL_FILTER") || rowDept.equalsIgnoreCase(deptFilter);
            boolean yearMatch = yearFilter.equals("ALL_FILTER") || rowYear.equalsIgnoreCase(yearFilter);
            boolean semMatch = semFilter.equals("ALL_FILTER") || rowSemester.equalsIgnoreCase(semFilter);

            if (deptMatch && yearMatch && semMatch) {
                courseModel.addRow(row);
            }
        }
    }
    
    public void loadScheduleData() {
        scheduleModel.setRowCount(0);
        List<String[]> schedules = com.udj.logic.ScheduleManager.getAllSchedules();
        for (String[] row : schedules) {
            scheduleModel.addRow(row);
        }
    }
    
    private void filterAndReloadCourseData() {
        if (MainTabbedPane.getSelectedIndex() == 0) {
            loadCourseData();
        }
        if (MainTabbedPane.getSelectedIndex() == 1) {
            loadScheduleData();
        }
    }
    
    private void styleScrollBar() {
        JScrollBar verticalBar = CourseScrollPane.getVerticalScrollBar();
        verticalBar.setUI(new CustomScrollBarUI());
        verticalBar.setPreferredSize(new Dimension(5, Integer.MAX_VALUE));
        JScrollBar horizontalBar = CourseScrollPane.getHorizontalScrollBar();
        horizontalBar.setUI(new CustomScrollBarUI());
        horizontalBar.setPreferredSize(new Dimension(Integer.MAX_VALUE, 10));
        
        JScrollBar verticalBar1 = ScheduleScrollPane.getVerticalScrollBar();
        verticalBar1.setUI(new CustomScrollBarUI());
        verticalBar1.setPreferredSize(new Dimension(5, Integer.MAX_VALUE));
        JScrollBar horizontalBar1 = ScheduleScrollPane.getHorizontalScrollBar();
        horizontalBar1.setUI(new CustomScrollBarUI());
        horizontalBar1.setPreferredSize(new Dimension(Integer.MAX_VALUE, 10));
    }
    
    private void styleTabbedPane() {
        MainTabbedPane.setUI(new CustomTabUI());
        MainTabbedPane.setForeground(Color.decode("#2E1448")); 
        MainTabbedPane.setFont(new Font("Arial", Font.BOLD, 13));
        CourseScrollPane.setBorder(null);
        CourseScrollPane.getViewport().setOpaque(true);
        CourseScrollPane.getViewport().setBackground(Color.decode("#F4E8FA")); 
        CourseScrollPane.setBorder(BorderFactory.createEmptyBorder());
        ScheduleScrollPane.setBorder(null);
        ScheduleScrollPane.getViewport().setOpaque(true);
        ScheduleScrollPane.getViewport().setBackground(Color.decode("#F4E8FA")); 
        ScheduleScrollPane.setBorder(BorderFactory.createEmptyBorder());
    }
    
    private void styleTable() {
        CourseTable.getTableHeader().setOpaque(false);
        CourseTable.getTableHeader().setBackground(Color.decode("#8f6da0")); 
        CourseTable.getTableHeader().setForeground(Color.WHITE);
        CourseTable.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        CourseTable.setBackground(Color.decode("#F4E8FA"));
        CourseTable.setForeground(Color.decode("#2E1448"));
        CourseTable.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        CourseTable.setSelectionBackground(Color.decode("#C8A8D8"));
        CourseTable.setSelectionForeground(Color.decode("#2E1448"));
        CourseTable.setShowGrid(true);
        CourseTable.setGridColor(new Color(140, 104, 160, 25)); 
        CourseTable.setIntercellSpacing(new java.awt.Dimension(4, 1));
        ScheduleTable.getTableHeader().setOpaque(false);
        ScheduleTable.getTableHeader().setBackground(Color.decode("#8f6da0")); 
        ScheduleTable.getTableHeader().setForeground(Color.WHITE);
        ScheduleTable.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        ScheduleTable.setBackground(Color.decode("#F4E8FA"));
        ScheduleTable.setForeground(Color.decode("#2E1448"));
        ScheduleTable.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        ScheduleTable.setSelectionBackground(Color.decode("#C8A8D8"));
        ScheduleTable.setSelectionForeground(Color.decode("#2E1448"));
        ScheduleTable.setShowGrid(true);
        ScheduleTable.setGridColor(new Color(140, 104, 160, 25)); 
        ScheduleTable.setIntercellSpacing(new java.awt.Dimension(4, 1));
        javax.swing.table.DefaultTableCellRenderer center = new javax.swing.table.DefaultTableCellRenderer();
        center.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        CourseTable.setDefaultRenderer(Object.class, center);
        ScheduleTable.setDefaultRenderer(Object.class, center);
    }
    
    class CustomTabUI extends javax.swing.plaf.basic.BasicTabbedPaneUI {
        private final Color selectedColor = Color.decode("#c8a8d8"); 
        private final Color unselectedColor = Color.decode("#F4E8FA"); 
        private final Color selectedTextColor = Color.decode("#2E1448");
        private final Color unselectedTextColor = Color.decode("#8f6da0");

        @Override
        protected void installDefaults() {
            super.installDefaults();
            contentBorderInsets = new java.awt.Insets(0, 0, 0, 0);
            tabAreaInsets = new java.awt.Insets(0, 0, 0, 0);
        }
        @Override
        protected void paintTabBackground(java.awt.Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
            java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
            
            if (isSelected) {
                g2.setColor(selectedColor);
                tabPane.setForegroundAt(tabIndex, selectedTextColor);
            } else {
                g2.setColor(unselectedColor);
                tabPane.setForegroundAt(tabIndex, unselectedTextColor);
            }
            g2.fillRect(x, y, w, h);
        }
        @Override
        protected void paintContentBorder(java.awt.Graphics g, int tabPlacement, int selectedIndex) {
        }
        @Override
        protected void paintFocusIndicator(java.awt.Graphics g, int tabPlacement, java.awt.Rectangle[] rects, int tabIndex, java.awt.Rectangle iconRect, java.awt.Rectangle textRect, boolean isSelected) {
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainTabbedPane = new javax.swing.JTabbedPane();
        CourseScrollPane = new javax.swing.JScrollPane();
        CourseTable = new javax.swing.JTable();
        ScheduleScrollPane = new javax.swing.JScrollPane();
        ScheduleTable = new javax.swing.JTable();
        DepartmentCB = new javax.swing.JComboBox<>();
        YearLevelCB = new javax.swing.JComboBox<>();
        SemesterCB = new javax.swing.JComboBox<>();
        Search = new javax.swing.JTextField();
        Add = new javax.swing.JLabel();
        Edit = new javax.swing.JLabel();
        Delete = new javax.swing.JLabel();
        SystemC = new javax.swing.JButton();
        DashboardC = new javax.swing.JButton();
        StudentC = new javax.swing.JButton();
        FacultyC = new javax.swing.JButton();
        DashboardC1 = new com.udj.gui.components.ButtonBG();
        StudentC1 = new com.udj.gui.components.ButtonBG();
        FacultyC1 = new com.udj.gui.components.ButtonBG();
        CoursesnCurriC1 = new com.udj.gui.components.ButtonBG();
        SystemC1 = new com.udj.gui.components.ButtonBG();
        CCMBG = new com.udj.gui.components.ButtonLabelBG();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MainTabbedPane.setBackground(new java.awt.Color(244, 232, 250));
        MainTabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        MainTabbedPane.setFont(new java.awt.Font("Product Sans", 1, 12)); // NOI18N
        MainTabbedPane.setOpaque(true);

        CourseScrollPane.setBackground(new java.awt.Color(238, 221, 242));
        CourseScrollPane.setBorder(null);
        CourseScrollPane.setColumnHeaderView(null);

        CourseTable.setAutoCreateRowSorter(true);
        CourseTable.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        CourseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course Code", "Description", "Units", "Department", "Year Level", "Semester"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CourseTable.setGridColor(new java.awt.Color(143, 109, 160));
        CourseTable.setOpaque(false);
        CourseTable.setShowGrid(false);
        CourseTable.getTableHeader().setResizingAllowed(false);
        CourseTable.getTableHeader().setReorderingAllowed(false);
        CourseScrollPane.setViewportView(CourseTable);
        if (CourseTable.getColumnModel().getColumnCount() > 0) {
            CourseTable.getColumnModel().getColumn(0).setResizable(false);
            CourseTable.getColumnModel().getColumn(0).setPreferredWidth(40);
            CourseTable.getColumnModel().getColumn(1).setResizable(false);
            CourseTable.getColumnModel().getColumn(1).setPreferredWidth(90);
            CourseTable.getColumnModel().getColumn(2).setResizable(false);
            CourseTable.getColumnModel().getColumn(2).setPreferredWidth(25);
            CourseTable.getColumnModel().getColumn(3).setResizable(false);
            CourseTable.getColumnModel().getColumn(4).setResizable(false);
            CourseTable.getColumnModel().getColumn(5).setResizable(false);
        }

        MainTabbedPane.addTab("  Course Management  ", CourseScrollPane);

        ScheduleScrollPane.setBackground(new java.awt.Color(238, 221, 242));
        ScheduleScrollPane.setBorder(null);
        ScheduleScrollPane.setColumnHeaderView(null);

        ScheduleTable.setAutoCreateRowSorter(true);
        ScheduleTable.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        ScheduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Schedule ID", "Block", "Course Code", "Day", "Time Start", "Time End", "Instructor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ScheduleTable.setGridColor(new java.awt.Color(143, 109, 160));
        ScheduleTable.setOpaque(false);
        ScheduleTable.setShowGrid(false);
        ScheduleTable.getTableHeader().setResizingAllowed(false);
        ScheduleTable.getTableHeader().setReorderingAllowed(false);
        ScheduleScrollPane.setViewportView(ScheduleTable);
        if (ScheduleTable.getColumnModel().getColumnCount() > 0) {
            ScheduleTable.getColumnModel().getColumn(0).setResizable(false);
            ScheduleTable.getColumnModel().getColumn(1).setResizable(false);
            ScheduleTable.getColumnModel().getColumn(1).setPreferredWidth(40);
            ScheduleTable.getColumnModel().getColumn(2).setResizable(false);
            ScheduleTable.getColumnModel().getColumn(2).setPreferredWidth(90);
            ScheduleTable.getColumnModel().getColumn(3).setResizable(false);
            ScheduleTable.getColumnModel().getColumn(3).setPreferredWidth(25);
            ScheduleTable.getColumnModel().getColumn(4).setResizable(false);
            ScheduleTable.getColumnModel().getColumn(5).setResizable(false);
            ScheduleTable.getColumnModel().getColumn(6).setResizable(false);
            ScheduleTable.getColumnModel().getColumn(6).setPreferredWidth(25);
        }

        MainTabbedPane.addTab("  Class Scheduling  ", ScheduleScrollPane);

        add(MainTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 216, 697, 344));
        MainTabbedPane.getAccessibleContext().setAccessibleName("MainTab");

        DepartmentCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Departments", "Computer Studies", "Chemistry", "Engineering", "Management" }));
        DepartmentCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepartmentCBActionPerformed(evt);
            }
        });
        add(DepartmentCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 175, 145, 20));

        YearLevelCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year Levels", "First Year", "Second Year", "Third Year", "Fourth Year" }));
        YearLevelCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearLevelCBActionPerformed(evt);
            }
        });
        add(YearLevelCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 175, 120, 20));

        SemesterCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semesters", "1st Semester", "2nd Semester", "Any Semester" }));
        SemesterCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SemesterCBActionPerformed(evt);
            }
        });
        add(SemesterCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 175, 110, 20));

        Search.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Search.setForeground(new java.awt.Color(102, 102, 102));
        Search.setText("Search Here"); // NOI18N
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

        Add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddMouseClicked(evt);
            }
        });
        add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(893, 168, 60, 30));

        Edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditMouseClicked(evt);
            }
        });
        add(Edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(819, 168, 60, 30));

        Delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteMouseClicked(evt);
            }
        });
        add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(742, 168, 60, 30));

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

        StudentC.setBorderPainted(false);
        StudentC.setContentAreaFilled(false);
        StudentC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        StudentC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudentCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                StudentCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                StudentCMouseExited(evt);
            }
        });
        add(StudentC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 160, 35));

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
        add(CoursesnCurriC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 403, 170, 50));

        SystemC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SystemAdminC1.png"))); // NOI18N
        SystemC1.setBorderPainted(false);
        SystemC1.setContentAreaFilled(false);
        add(SystemC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 472, 160, 38));

        CCMBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CCM.png"))); // NOI18N
        add(CCMBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));
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
 
    }//GEN-LAST:event_SearchActionPerformed

    private void DepartmentCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepartmentCBActionPerformed
        loadCourseData();
    }//GEN-LAST:event_DepartmentCBActionPerformed

    private void AddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseClicked
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (MainTabbedPane.getSelectedIndex() == 0) {
            AddEditCourse dialog = new AddEditCourse(parentFrame, true, this);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        } else if (MainTabbedPane.getSelectedIndex() == 1) { 
            AddEditSchedule dialog = new AddEditSchedule(parentFrame, true, this);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_AddMouseClicked

    private void EditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditMouseClicked
        int selectedTab = MainTabbedPane.getSelectedIndex();
        int selectedRow = -1;

        if (selectedTab == 0) {
            selectedRow = CourseTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(this, "Please select a course to edit.", 
                    "No Selection", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String id = CourseTable.getValueAt(selectedRow, 0). toString();
            String desc = CourseTable.getValueAt(selectedRow, 1).toString();
            String units = CourseTable. getValueAt(selectedRow, 2).toString();
            String dept = CourseTable.getValueAt(selectedRow, 3).toString();
            String yearLevel = CourseTable.getValueAt(selectedRow, 4).toString();
            String semester = CourseTable. getValueAt(selectedRow, 5).toString();

            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            AddEditCourse dialog = new AddEditCourse(parentFrame, true, this, id, desc, 
                units, dept, yearLevel, semester);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        } else if (selectedTab == 1) { // Schedule Tab
            int row = ScheduleTable.getSelectedRow();
            if (row < 0) { JOptionPane.showMessageDialog(this, "Select a schedule."); return; }
            
            // Get values from table (7 columns)
            String id = ScheduleTable.getValueAt(row, 0).toString();
            String block = ScheduleTable.getValueAt(row, 1).toString();
            String code = ScheduleTable.getValueAt(row, 2).toString();
            String day = ScheduleTable.getValueAt(row, 3).toString();
            String start = ScheduleTable.getValueAt(row, 4).toString();
            String end = ScheduleTable.getValueAt(row, 5).toString();
            String prof = ScheduleTable.getValueAt(row, 6).toString();

            JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
            AddEditSchedule dialog = new AddEditSchedule(parent, true, this, id, block, code, day, start, end, prof);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_EditMouseClicked

    private void DeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteMouseClicked
        int selectedTab = MainTabbedPane.getSelectedIndex();
        int selectedRow = -1;

        if (selectedTab == 0) {
            selectedRow = CourseTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(this, "Please select a course to delete.", "No Selection", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String courseID = CourseTable.getValueAt(selectedRow, 0).toString();
            int confirm = JOptionPane.showConfirmDialog(this, "Delete this course?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                if (com.udj.logic. CourseManager.deleteCourse(courseID)) {
                    JOptionPane.showMessageDialog(this, "Course deleted successfully!", "Success", JOptionPane. INFORMATION_MESSAGE);
                    loadCourseData();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete course.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
       } else if (selectedTab == 1) { // Schedule Tab
            int row = ScheduleTable.getSelectedRow();
            if (row < 0) { JOptionPane.showMessageDialog(this, "Select a schedule."); return; }
            
            String id = ScheduleTable.getValueAt(row, 0).toString(); // ID is Col 0
            int confirm = JOptionPane.showConfirmDialog(this, "Delete Schedule " + id + "?", "Confirm", JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                if (com.udj.logic.ScheduleManager.deleteSchedule(id)) {
                    loadScheduleData();
                    JOptionPane.showMessageDialog(this, "Deleted.");
                }
            }
        }
    }//GEN-LAST:event_DeleteMouseClicked

    private void YearLevelCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearLevelCBActionPerformed
        loadCourseData();
    }//GEN-LAST:event_YearLevelCBActionPerformed

    private void SemesterCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SemesterCBActionPerformed
        loadCourseData();
    }//GEN-LAST:event_SemesterCBActionPerformed

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
    }//GEN-LAST:event_FacultyCMouseClicked

    private void FacultyCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FacultyCMouseEntered
        FacultyC1.setVisible(true);
        FacultyC1.repaint();
    }//GEN-LAST:event_FacultyCMouseEntered

    private void FacultyCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FacultyCMouseExited
        FacultyC1.setVisible(false);
    }//GEN-LAST:event_FacultyCMouseExited

    private void StudentCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentCMouseClicked
        parentFrame.showPanel("STUDENT_MANAGEMENT");
    }//GEN-LAST:event_StudentCMouseClicked

    private void StudentCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentCMouseEntered
        StudentC1.setVisible(true);
        StudentC1.repaint();
    }//GEN-LAST:event_StudentCMouseEntered

    private void StudentCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentCMouseExited
        StudentC1.setVisible(false);
    }//GEN-LAST:event_StudentCMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Add;
    private javax.swing.JLabel CCMBG;
    private javax.swing.JScrollPane CourseScrollPane;
    private javax.swing.JTable CourseTable;
    private javax.swing.JButton CoursesnCurriC1;
    private javax.swing.JButton DashboardC;
    private javax.swing.JButton DashboardC1;
    private javax.swing.JLabel Delete;
    private javax.swing.JComboBox<String> DepartmentCB;
    private javax.swing.JLabel Edit;
    private javax.swing.JButton FacultyC;
    private javax.swing.JButton FacultyC1;
    private javax.swing.JTabbedPane MainTabbedPane;
    private javax.swing.JScrollPane ScheduleScrollPane;
    private javax.swing.JTable ScheduleTable;
    private javax.swing.JTextField Search;
    private javax.swing.JComboBox<String> SemesterCB;
    private javax.swing.JButton StudentC;
    private javax.swing.JButton StudentC1;
    private javax.swing.JButton SystemC;
    private javax.swing.JButton SystemC1;
    private javax.swing.JComboBox<String> YearLevelCB;
    // End of variables declaration//GEN-END:variables
}
