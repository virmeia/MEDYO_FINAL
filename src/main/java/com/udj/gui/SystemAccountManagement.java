package com.udj.gui;

import com.udj.gui.components.CustomScrollBarUI;
import com.udj.gui.components.PendingActionCellEditor;
import com.udj.gui.components.PendingActionPanel;
import com.udj.gui.components.SystemActionCellEditor;
import com.udj.gui.components.SystemActionPanel;
import com.udj.logic.AccountManager;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class SystemAccountManagement extends javax.swing.JPanel {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SystemAccountManagement.class.getName());
    private static final String PLACEHOLDER_TEXT = "Search User ID";
    private String currentSortFilter = "ALL";
    private final AdminDB parentFrame;

    public SystemAccountManagement(AdminDB parentFrame) {
        this.parentFrame = parentFrame;
        initComponents();
        
        styleTable();
        styleScrollBar();
        DashboardC1.setVisible(false);
        StudentC1.setVisible(false);
        FacultyC1.setVisible(false);
        CoursesnCurriC1.setVisible(false);
        SystemC1.setVisible(true);  
        PendingScrollPane.setBorder(null);
        PendingScrollPane.getViewport().setOpaque(true);
        PendingScrollPane.getViewport().setBackground(Color.decode("#F4E8FA")); 
        PendingScrollPane.setBorder(BorderFactory.createEmptyBorder());
        ActiveScrollPane.setBorder(null);
        ActiveScrollPane.getViewport().setOpaque(true);
        ActiveScrollPane.getViewport().setBackground(Color.decode("#F4E8FA")); 
        ActiveScrollPane.setBorder(BorderFactory.createEmptyBorder());
        loadPendingData();
        loadActiveData("");
        setupActionColumns();
        Search.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                performSearch();
            }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                performSearch();
            }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                performSearch();
            }
            private void performSearch() {
                String text = Search.getText();
                if (text.equals(PLACEHOLDER_TEXT)) {
                    return; 
                }
                loadActiveData(text);
            }
        });
    }
    
   private void loadPendingData() {
        DefaultTableModel model = (DefaultTableModel) PendingAccountTable.getModel();
        model.setRowCount(0);
        
        List<String[]> pendingList = AccountManager.getPendingUsers();
        int count = 0;
        
        for (String[] user : pendingList) {
            String role = user[2].toUpperCase(); 
            boolean showRow = currentSortFilter.equals("ALL") || role.equals(currentSortFilter);
            
            if (showRow) {
                count++;
                model.addRow(new Object[]{ count, user[0], "Create" });
            }
        }
        TotalPending.setText("(" + count + ")");
    }
    
    private void loadActiveData(String searchQuery) {
        DefaultTableModel model = (DefaultTableModel) ActiveAccountTable.getModel();
        model.setRowCount(0);
        
        List<String[]> activeList = AccountManager.getAllAccounts();
        int count = 0;
        String query = searchQuery.toLowerCase().trim();
        
        for (String[] account : activeList) {
            String id = account[0];
            String role = account[3].toUpperCase();

            boolean match = query.isEmpty() || id.toLowerCase().contains(query);

            if (match) {
                count++;
                model.addRow(new Object[]{
                    count, 
                    id,          
                    role,        
                    "Manage"     
                });
            }
        }
        TotalActive.setText("(" + count + ")");
    }
    
    public void refreshActiveTable() {
        loadActiveData(Search.getText().equals(PLACEHOLDER_TEXT) ? "" : Search.getText());
        loadPendingData();
    }
    
    private void setupActionColumns() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        PendingAccountTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        
        ActiveAccountTable.getColumnModel().getColumn(3).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                SystemActionPanel p = new SystemActionPanel();
                if (isSelected) p.setBackground(table.getSelectionBackground());
                else p.setBackground(table.getBackground());
                return p;
            }
        });
        ActiveAccountTable.getColumnModel().getColumn(3).setCellEditor(new SystemActionCellEditor(ActiveAccountTable, this));
        
        PendingAccountTable.getColumnModel().getColumn(2).setCellRenderer((table, value, isSelected, hasFocus, row, column) -> {
            PendingActionPanel p = new PendingActionPanel();
            p.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
            return p;
        });
        PendingAccountTable.getColumnModel().getColumn(2).setCellEditor(new PendingActionCellEditor(PendingAccountTable, this));
        PendingAccountTable.setRowHeight(30); 
        ActiveAccountTable.setRowHeight(30);
        PendingScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        ActiveScrollPane.getVerticalScrollBar().setUnitIncrement(16);
    }
    
    private void styleScrollBar() {
        JScrollBar verticalBar = PendingScrollPane.getVerticalScrollBar();
        verticalBar.setUI(new CustomScrollBarUI());
        verticalBar.setPreferredSize(new Dimension(5, Integer.MAX_VALUE));
        JScrollBar horizontalBar = PendingScrollPane.getHorizontalScrollBar();
        horizontalBar.setUI(new CustomScrollBarUI());
        horizontalBar.setPreferredSize(new Dimension(Integer.MAX_VALUE, 10));
        JScrollBar verticalBar1 = ActiveScrollPane.getVerticalScrollBar();
        verticalBar1.setUI(new CustomScrollBarUI());
        verticalBar1.setPreferredSize(new Dimension(5, Integer.MAX_VALUE));
        JScrollBar horizontalBar1 = ActiveScrollPane.getHorizontalScrollBar();
        horizontalBar1.setUI(new CustomScrollBarUI());
        horizontalBar1.setPreferredSize(new Dimension(Integer.MAX_VALUE, 10));
    }
    
    private void styleTable() {
        PendingAccountTable.getTableHeader().setOpaque(false);
        PendingAccountTable.getTableHeader().setBackground(Color.decode("#8f6da0")); 
        PendingAccountTable.getTableHeader().setForeground(Color.WHITE);
        PendingAccountTable.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        PendingAccountTable.setBackground(Color.decode("#F4E8FA"));
        PendingAccountTable.setForeground(Color.decode("#2E1448"));
        PendingAccountTable.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        PendingAccountTable.setSelectionBackground(Color.decode("#C8A8D8"));
        PendingAccountTable.setSelectionForeground(Color.decode("#2E1448"));
        PendingAccountTable.setShowGrid(true);
        PendingAccountTable.setGridColor(new Color(140, 104, 160, 25)); 
        PendingAccountTable.setIntercellSpacing(new java.awt.Dimension(4, 1));
        ActiveAccountTable.getTableHeader().setOpaque(false);
        ActiveAccountTable.getTableHeader().setBackground(Color.decode("#8f6da0")); 
        ActiveAccountTable.getTableHeader().setForeground(Color.WHITE);
        ActiveAccountTable.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        ActiveAccountTable.setBackground(Color.decode("#F4E8FA"));
        ActiveAccountTable.setForeground(Color.decode("#2E1448"));
        ActiveAccountTable.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        ActiveAccountTable.setSelectionBackground(Color.decode("#C8A8D8"));
        ActiveAccountTable.setSelectionForeground(Color.decode("#2E1448"));
        ActiveAccountTable.setShowGrid(true);
        ActiveAccountTable.setGridColor(new Color(140, 104, 160, 25)); 
        ActiveAccountTable.setIntercellSpacing(new java.awt.Dimension(4, 1));
        javax.swing.table.DefaultTableCellRenderer center = new javax.swing.table.DefaultTableCellRenderer();
        center.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        PendingAccountTable.setDefaultRenderer(Object.class, center);
        ActiveAccountTable.setDefaultRenderer(Object.class, center);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ActiveScrollPane = new javax.swing.JScrollPane();
        ActiveAccountTable = new javax.swing.JTable();
        PendingScrollPane = new javax.swing.JScrollPane();
        PendingAccountTable = new javax.swing.JTable();
        Search = new javax.swing.JTextField();
        AdminName = new javax.swing.JTextField();
        TotalActive = new javax.swing.JTextField();
        TotalPending = new javax.swing.JTextField();
        CreateAll = new javax.swing.JLabel();
        SortStudents = new javax.swing.JLabel();
        SortTeachers = new javax.swing.JLabel();
        ViewAdmins = new javax.swing.JLabel();
        DeleteAll = new javax.swing.JLabel();
        AdminProfile = new javax.swing.JLabel();
        AddAdminC = new javax.swing.JLabel();
        AuditLogs = new javax.swing.JLabel();
        PALabel = new javax.swing.JLabel();
        AALabel = new javax.swing.JLabel();
        DashboardC = new javax.swing.JButton();
        CoursesnCurriC = new javax.swing.JButton();
        FacultyC = new javax.swing.JButton();
        StudentC = new javax.swing.JButton();
        StudentC1 = new com.udj.gui.components.ButtonBG();
        FacultyC1 = new com.udj.gui.components.ButtonBG();
        DashboardC1 = new com.udj.gui.components.ButtonBG();
        SystemC1 = new com.udj.gui.components.ButtonBG();
        CoursesnCurriC1 = new com.udj.gui.components.ButtonBG();
        SystemAccountBG = new com.udj.gui.components.ButtonLabelBG();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ActiveScrollPane.setBackground(new java.awt.Color(238, 221, 242));
        ActiveScrollPane.setBorder(null);
        ActiveScrollPane.setColumnHeaderView(null);

        ActiveAccountTable.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        ActiveAccountTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "ID", "Role", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ActiveAccountTable.setGridColor(new java.awt.Color(143, 109, 160));
        ActiveAccountTable.setOpaque(false);
        ActiveAccountTable.setShowGrid(false);
        ActiveAccountTable.getTableHeader().setResizingAllowed(false);
        ActiveAccountTable.getTableHeader().setReorderingAllowed(false);
        ActiveScrollPane.setViewportView(ActiveAccountTable);
        if (ActiveAccountTable.getColumnModel().getColumnCount() > 0) {
            ActiveAccountTable.getColumnModel().getColumn(0).setMinWidth(25);
            ActiveAccountTable.getColumnModel().getColumn(0).setPreferredWidth(25);
            ActiveAccountTable.getColumnModel().getColumn(0).setMaxWidth(25);
            ActiveAccountTable.getColumnModel().getColumn(1).setResizable(false);
            ActiveAccountTable.getColumnModel().getColumn(1).setPreferredWidth(90);
            ActiveAccountTable.getColumnModel().getColumn(2).setResizable(false);
            ActiveAccountTable.getColumnModel().getColumn(2).setPreferredWidth(80);
            ActiveAccountTable.getColumnModel().getColumn(3).setMinWidth(80);
            ActiveAccountTable.getColumnModel().getColumn(3).setPreferredWidth(80);
            ActiveAccountTable.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        add(ActiveScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 261, 414, 259));

        PendingScrollPane.setBackground(new java.awt.Color(238, 221, 242));
        PendingScrollPane.setBorder(null);
        PendingScrollPane.setColumnHeaderView(null);

        PendingAccountTable.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        PendingAccountTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "ID", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PendingAccountTable.setGridColor(new java.awt.Color(143, 109, 160));
        PendingAccountTable.setOpaque(false);
        PendingAccountTable.setShowGrid(false);
        PendingAccountTable.getTableHeader().setResizingAllowed(false);
        PendingAccountTable.getTableHeader().setReorderingAllowed(false);
        PendingScrollPane.setViewportView(PendingAccountTable);
        if (PendingAccountTable.getColumnModel().getColumnCount() > 0) {
            PendingAccountTable.getColumnModel().getColumn(0).setMinWidth(25);
            PendingAccountTable.getColumnModel().getColumn(0).setPreferredWidth(25);
            PendingAccountTable.getColumnModel().getColumn(0).setMaxWidth(25);
            PendingAccountTable.getColumnModel().getColumn(1).setResizable(false);
            PendingAccountTable.getColumnModel().getColumn(1).setPreferredWidth(90);
            PendingAccountTable.getColumnModel().getColumn(2).setMinWidth(80);
            PendingAccountTable.getColumnModel().getColumn(2).setPreferredWidth(80);
            PendingAccountTable.getColumnModel().getColumn(2).setMaxWidth(80);
        }

        add(PendingScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 261, 242, 259));

        Search.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Search.setForeground(new java.awt.Color(102, 102, 102));
        Search.setText("Search User ID"); // NOI18N
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
        add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(808, 225, 130, 16));
        Search.setOpaque(false);

        AdminName.setFont(new java.awt.Font("Product Sans", 1, 12)); // NOI18N
        AdminName.setForeground(new java.awt.Color(46, 20, 72));
        AdminName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        AdminName.setAutoscrolls(false);
        AdminName.setBorder(null);
        AdminName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AdminName.setFocusable(false);
        AdminName.setOpaque(true);
        AdminName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminNameActionPerformed(evt);
            }
        });
        add(AdminName, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 21, 210, 20));
        AdminName.setOpaque(false);

        TotalActive.setFont(new java.awt.Font("Product Sans", 1, 12)); // NOI18N
        TotalActive.setForeground(new java.awt.Color(46, 20, 72));
        TotalActive.setAutoscrolls(false);
        TotalActive.setBorder(null);
        TotalActive.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TotalActive.setFocusable(false);
        add(TotalActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 221, 40, 20));
        TotalActive.setOpaque(false);

        TotalPending.setFont(new java.awt.Font("Product Sans", 1, 12)); // NOI18N
        TotalPending.setForeground(new java.awt.Color(255, 255, 255));
        TotalPending.setAutoscrolls(false);
        TotalPending.setBorder(null);
        TotalPending.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TotalPending.setFocusable(false);
        add(TotalPending, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 221, 40, 20));
        TotalPending.setOpaque(false);

        CreateAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CreateAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreateAllMouseClicked(evt);
            }
        });
        add(CreateAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 530, 62, 22));

        SortStudents.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SortStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SortStudentsMouseClicked(evt);
            }
        });
        add(SortStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 530, 62, 22));

        SortTeachers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SortTeachers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SortTeachersMouseClicked(evt);
            }
        });
        add(SortTeachers, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 530, 62, 22));

        ViewAdmins.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ViewAdmins.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewAdminsMouseClicked(evt);
            }
        });
        add(ViewAdmins, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 530, 80, 22));

        DeleteAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DeleteAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteAllMouseClicked(evt);
            }
        });
        add(DeleteAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 530, 126, 22));

        AdminProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AdminProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdminProfileMouseClicked(evt);
            }
        });
        add(AdminProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 100, 120, 27));

        AddAdminC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddAdminC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddAdminCMouseClicked(evt);
            }
        });
        add(AddAdminC, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 170, 70, 22));

        AuditLogs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AuditLogs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AuditLogsMouseClicked(evt);
            }
        });
        add(AuditLogs, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, 80, 22));

        PALabel.setFont(new java.awt.Font("Product Sans", 1, 12)); // NOI18N
        PALabel.setForeground(new java.awt.Color(255, 255, 255));
        PALabel.setText("   PENDING ACCOUNTS");
        add(PALabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 180, 20));

        AALabel.setFont(new java.awt.Font("Product Sans", 1, 12)); // NOI18N
        AALabel.setForeground(new java.awt.Color(46, 20, 72));
        AALabel.setText("   ACTIVE ACCOUNTS");
        add(AALabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 180, 20));

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

        StudentC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/StudentAdminC1.png"))); // NOI18N
        StudentC1.setBorderPainted(false);
        StudentC1.setContentAreaFilled(false);
        add(StudentC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 290, 162, 37));

        FacultyC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FacultyAdminC1.png"))); // NOI18N
        FacultyC1.setBorderPainted(false);
        FacultyC1.setContentAreaFilled(false);
        add(FacultyC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 351, 160, 40));

        DashboardC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DashboardAdminC1.png"))); // NOI18N
        DashboardC1.setBorderPainted(false);
        DashboardC1.setContentAreaFilled(false);
        add(DashboardC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 229, 162, 37));

        SystemC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SystemAdminC1.png"))); // NOI18N
        SystemC1.setBorderPainted(false);
        SystemC1.setContentAreaFilled(false);
        add(SystemC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 472, 160, 38));

        CoursesnCurriC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CourseAdminC1.png"))); // NOI18N
        CoursesnCurriC1.setBorderPainted(false);
        CoursesnCurriC1.setContentAreaFilled(false);
        add(CoursesnCurriC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 409, 160, 40));

        SystemAccountBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SAMBG.png"))); // NOI18N
        add(SystemAccountBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));
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

    private void AddAdminCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddAdminCMouseClicked
        javax.swing.JFrame parentFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        java.awt.EventQueue.invokeLater(() -> {
            AddAdmin dialog = new AddAdmin(parentFrame, true, this);
            dialog.setLocationRelativeTo(parentFrame);
            dialog.setVisible(true);
        });
    }//GEN-LAST:event_AddAdminCMouseClicked

    private void AuditLogsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AuditLogsMouseClicked
                com.udj.gui.components.AuditLogViewer logDialog = new com.udj.gui.components.AuditLogViewer(parentFrame);
        logDialog.setVisible(true);
    }//GEN-LAST:event_AuditLogsMouseClicked

    private void DeleteAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteAllMouseClicked
        List<String[]> activeList = AccountManager.getAllAccounts();
        
        if (activeList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No active accounts to delete.");
            return;
        }

        com.udj.gui.components.DeleteAll dialog = new com.udj.gui.components.DeleteAll(parentFrame, true);
        dialog.setVisible(true);

        if (dialog.isConfirmed()) {
            DeleteAll.setEnabled(false);
            
            new Thread(() -> {
                int deletedCount = 0;
                
                for (String[] account : activeList) {
                    String id = account[0];
                    String role = account[3].toUpperCase(); 

                    if (role.equals("ADMIN")) {
                        continue; 
                    }
 
                    boolean success = AccountManager.deleteAccount(id);
                    if (success) deletedCount++;
                }

                final int finalCount = deletedCount;
                javax.swing.SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(this, 
                        finalCount + " accounts deleted successfully.\n(Admins were not removed)");
                    refreshActiveTable();
                    DeleteAll.setEnabled(true);
                });
                
            }).start();
        }
    }//GEN-LAST:event_DeleteAllMouseClicked

    private void ViewAdminsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewAdminsMouseClicked
            java.awt.EventQueue.invokeLater(() -> {
            ViewAdmins dialog = new ViewAdmins(parentFrame, true);
            dialog.setLocationRelativeTo(parentFrame);
            dialog.setVisible(true);
        });
    }//GEN-LAST:event_ViewAdminsMouseClicked

    private void SortTeachersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SortTeachersMouseClicked
        if (currentSortFilter.equals("TEACHER")) {
            currentSortFilter = "ALL";
        } else {
            currentSortFilter = "TEACHER";
        }
        loadPendingData();
    }//GEN-LAST:event_SortTeachersMouseClicked

    private void SortStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SortStudentsMouseClicked
        if (currentSortFilter.equals("STUDENT")) {
            currentSortFilter = "ALL";
        } else {
            currentSortFilter = "STUDENT";
        }
        loadPendingData();
    }//GEN-LAST:event_SortStudentsMouseClicked

    private void CreateAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateAllMouseClicked
        List<String[]> pendingList = AccountManager.getPendingUsers();
   
        if (pendingList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No pending users to create.");
            return;
        }

        com.udj.gui.components.CreateAll dialog = new com.udj.gui.components.CreateAll(parentFrame, true);
        dialog.setVisible(true); 

        if (dialog.isConfirmed()) {
            CreateAll.setEnabled(false); 
            new Thread(() -> {
                int successCount = 0;
                
                for (String[] user : pendingList) {
                    String id = user[0];
                    String role = user[2]; 
                    String defaultPass = user[3];
                    
                    boolean created = AccountManager.createAccount(id, id, defaultPass, role);
                    if (created) successCount++;
                }
        
                final int finalCount = successCount;
                javax.swing.SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(this, finalCount + " accounts created!");
                    refreshActiveTable();
                    CreateAll.setEnabled(true);
                });
                
            }).start();
        }
    }//GEN-LAST:event_CreateAllMouseClicked

    private void AdminNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminNameActionPerformed
      
    }//GEN-LAST:event_AdminNameActionPerformed

    private void AdminProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminProfileMouseClicked
       
    }//GEN-LAST:event_AdminProfileMouseClicked

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AALabel;
    private javax.swing.JTable ActiveAccountTable;
    private javax.swing.JScrollPane ActiveScrollPane;
    private javax.swing.JLabel AddAdminC;
    private javax.swing.JTextField AdminName;
    private javax.swing.JLabel AdminProfile;
    private javax.swing.JLabel AuditLogs;
    private javax.swing.JButton CoursesnCurriC;
    private javax.swing.JButton CoursesnCurriC1;
    private javax.swing.JLabel CreateAll;
    private javax.swing.JButton DashboardC;
    private javax.swing.JButton DashboardC1;
    private javax.swing.JLabel DeleteAll;
    private javax.swing.JButton FacultyC;
    private javax.swing.JButton FacultyC1;
    private javax.swing.JLabel PALabel;
    private javax.swing.JTable PendingAccountTable;
    private javax.swing.JScrollPane PendingScrollPane;
    private javax.swing.JTextField Search;
    private javax.swing.JLabel SortStudents;
    private javax.swing.JLabel SortTeachers;
    private javax.swing.JButton StudentC;
    private javax.swing.JButton StudentC1;
    private javax.swing.JLabel SystemAccountBG;
    private javax.swing.JButton SystemC1;
    private javax.swing.JTextField TotalActive;
    private javax.swing.JTextField TotalPending;
    private javax.swing.JLabel ViewAdmins;
    // End of variables declaration//GEN-END:variables
}
