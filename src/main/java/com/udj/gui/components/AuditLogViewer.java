package com.udj.gui.components;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class AuditLogViewer extends JDialog {

    private JTable logTable;
    private DefaultTableModel tableModel;
    private JLabel summaryLabel;
    private static final String LOG_FILE = "src/main/resources/data/AccountActivityLogs.txt";

    public AuditLogViewer(java.awt.Frame parent) {
        super(parent, "System Audit Logs", true); // true = Modal (blocks other windows)
        setSize(600, 500);
        setLocationRelativeTo(parent);
        setLayout(new java.awt.BorderLayout());

        // 1. HEADER (Summary)
        summaryLabel = new JLabel("Loading logs...");
        summaryLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        summaryLabel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        summaryLabel.setOpaque(true);
        summaryLabel.setBackground(Color.decode("#f4e8fa"));
        summaryLabel.setForeground(Color.decode("#2e1448"));
        add(summaryLabel, java.awt.BorderLayout.NORTH);

        // 2. TABLE SETUP
        String[] columns = {"User ID", "Action", "Timestamp"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Disable editing
            }
        };

        logTable = new JTable(tableModel);
        styleTable(); // Apply your purple styling
        
        JScrollPane scrollPane = new JScrollPane(logTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(Color.WHITE);
        add(scrollPane, java.awt.BorderLayout.CENTER);

        // 3. LOAD DATA
        loadLogs();
    }

    private void loadLogs() {
        File file = new File(LOG_FILE);
        int totalActions = 0;
        int creations = 0;
        int deletions = 0;
        int resets = 0;

        if (!file.exists()) {
            summaryLabel.setText("No audit logs found.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            // Read lines and add to table
            // Storing in a list first to reverse order (Newest First) if desired, 
            // but for simple logs, standard order is fine.
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] data = line.split(",");
                if (data.length >= 3) {
                    tableModel.addRow(new Object[]{data[0], data[1], data[2]});
                    
                    // Simple Stats Counting
                    totalActions++;
                    String action = data[1].toLowerCase();
                    if (action.contains("created")) creations++;
                    if (action.contains("deleted")) deletions++;
                    if (action.contains("reset")) resets++;
                }
            }
            
            // Update Summary Label
            summaryLabel.setText(String.format(
                "<html>Total Actions: %d &nbsp;|&nbsp; <font color='green'>Created: %d</font> &nbsp;|&nbsp; <font color='red'>Deleted: %d</font> &nbsp;|&nbsp; <font color='blue'>Resets: %d</font></html>", 
                totalActions, creations, deletions, resets
            ));

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading log file.");
        }
    }

    private void styleTable() {
        logTable.setRowHeight(30);
        logTable.getTableHeader().setBackground(Color.decode("#8f6da0"));
        logTable.getTableHeader().setForeground(Color.WHITE);
        logTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        logTable.setSelectionBackground(Color.decode("#C8A8D8"));
        logTable.setShowGrid(true);
        logTable.setGridColor(new Color(140, 104, 160, 25));
        
        // Center text in cells
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < logTable.getColumnCount(); i++) {
            logTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
}