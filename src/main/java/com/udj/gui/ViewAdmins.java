package com.udj.gui;

import com.udj.gui.components.CustomScrollBarUI;
import com.udj.logic.AdminManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;

public class ViewAdmins extends javax.swing.JDialog {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ViewAdmins.class.getName());

    public ViewAdmins(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        styleTable();
        styleScrollBar();
        loadAdmins();
        AdminsScrollPane.setBorder(null);
        AdminsScrollPane.getViewport().setOpaque(true);
        AdminsScrollPane.getViewport().setBackground(Color.decode("#F4E8FA")); 
        AdminsScrollPane.setBorder(BorderFactory.createEmptyBorder());
    }
    
    private void loadAdmins() {
        DefaultTableModel model = (DefaultTableModel) AdminsTable.getModel();
        model.setRowCount(0); // Clear existing rows
        
        List<String[]> admins = AdminManager.getAllAdmins();
        
        for (String[] admin : admins) {
            model.addRow(new Object[]{
                admin[0], 
                admin[1], 
                admin[2], 
                admin[3]
            });
        }
    }
    
    private void styleScrollBar() {
        JScrollBar verticalBar = AdminsScrollPane.getVerticalScrollBar();
        verticalBar.setUI(new CustomScrollBarUI());
        verticalBar.setPreferredSize(new Dimension(5, Integer.MAX_VALUE));

        JScrollBar horizontalBar = AdminsScrollPane.getHorizontalScrollBar();
        horizontalBar.setUI(new CustomScrollBarUI());
        horizontalBar.setPreferredSize(new Dimension(Integer.MAX_VALUE, 10));
    }
    
    private void styleTable() {
        AdminsTable.getTableHeader().setOpaque(false);
        AdminsTable.getTableHeader().setBackground(Color.decode("#8f6da0")); 
        AdminsTable.getTableHeader().setForeground(Color.WHITE);
        AdminsTable.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 13));
        AdminsTable.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 25));
        AdminsTable.setBackground(Color.decode("#F4E8FA"));
        AdminsTable.setForeground(Color.decode("#2E1448"));
        AdminsTable.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        AdminsTable.setSelectionBackground(Color.decode("#C8A8D8"));
        AdminsTable.setSelectionForeground(Color.decode("#2E1448"));
        AdminsTable.setShowGrid(true);
        AdminsTable.setGridColor(new Color(140, 104, 160, 25)); 
        AdminsTable.setIntercellSpacing(new java.awt.Dimension(5, 1));
        javax.swing.table.DefaultTableCellRenderer center = new javax.swing.table.DefaultTableCellRenderer();
        center.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        AdminsTable.setDefaultRenderer(Object.class, center);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGPanel = new javax.swing.JPanel();
        Back = new javax.swing.JLabel();
        AdminsScrollPane = new javax.swing.JScrollPane();
        AdminsTable = new javax.swing.JTable();
        ViewAdmins = new com.udj.gui.components.ButtonLabelBG();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BGPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });
        BGPanel.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 8, 20, 20));

        AdminsScrollPane.setBackground(new java.awt.Color(238, 221, 242));
        AdminsScrollPane.setBorder(null);
        AdminsScrollPane.setColumnHeaderView(null);

        AdminsTable.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        AdminsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Admin ID", "Name", "Email", "Contact No."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        AdminsTable.setGridColor(new java.awt.Color(143, 109, 160));
        AdminsTable.setOpaque(false);
        AdminsTable.setRowHeight(30);
        AdminsTable.setShowGrid(false);
        AdminsTable.getTableHeader().setReorderingAllowed(false);
        AdminsScrollPane.setViewportView(AdminsTable);
        if (AdminsTable.getColumnModel().getColumnCount() > 0) {
            AdminsTable.getColumnModel().getColumn(0).setMinWidth(95);
            AdminsTable.getColumnModel().getColumn(0).setPreferredWidth(95);
            AdminsTable.getColumnModel().getColumn(0).setMaxWidth(95);
            AdminsTable.getColumnModel().getColumn(2).setMinWidth(150);
            AdminsTable.getColumnModel().getColumn(2).setPreferredWidth(150);
            AdminsTable.getColumnModel().getColumn(2).setMaxWidth(150);
            AdminsTable.getColumnModel().getColumn(3).setMinWidth(115);
            AdminsTable.getColumnModel().getColumn(3).setPreferredWidth(115);
            AdminsTable.getColumnModel().getColumn(3).setMaxWidth(115);
        }

        BGPanel.add(AdminsScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 63, 540, 270));

        ViewAdmins.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ViewAdmins.png"))); // NOI18N
        BGPanel.add(ViewAdmins, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 360));

        getContentPane().add(BGPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        this.dispose();
    }//GEN-LAST:event_BackMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane AdminsScrollPane;
    private javax.swing.JTable AdminsTable;
    private javax.swing.JPanel BGPanel;
    private javax.swing.JLabel Back;
    private javax.swing.JLabel ViewAdmins;
    // End of variables declaration//GEN-END:variables
}
