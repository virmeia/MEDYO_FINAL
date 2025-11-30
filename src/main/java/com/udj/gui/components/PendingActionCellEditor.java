package com.udj.gui.components;

import com.udj.logic.AccountManager;
import com.udj.gui.SystemAccountManagement;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class PendingActionCellEditor extends AbstractCellEditor implements TableCellEditor {
    private final PendingActionPanel panel;
    private final JTable table;
    private final SystemAccountManagement parentPanel;
    private int currentRow;
    
    public PendingActionCellEditor(JTable table, SystemAccountManagement parentPanel) {
        this.table = table;
        this.parentPanel = parentPanel;
        panel = new PendingActionPanel();
        
        // --- VIEW ACTION ---
        panel.addViewListener(e -> {
            fireEditingStopped();
            viewStudent(currentRow);
        });
        
        // --- CREATE ACTION ---
        panel.addCreateListener(e -> {
            fireEditingStopped();
            createAccount(currentRow);
        });
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        currentRow = row;
        panel.setBackground(table.getSelectionBackground());
        return panel;
    }
    
    @Override
    public Object getCellEditorValue() { return ""; }
    
    private void viewStudent(int row) {
        String id = table.getValueAt(row, 1).toString(); // Col 1 is ID
        
        Window parentWindow = SwingUtilities.getWindowAncestor(table);
        Frame frame = (parentWindow instanceof Frame) ? (Frame) parentWindow : null;
        
        com.udj.gui.ViewStudent viewDialog = new com.udj.gui.ViewStudent(frame, true);
        viewDialog.loadStudentDetails(id);
        viewDialog.setVisible(true);
    }
    
    private void createAccount(int row) {
        String id = table.getValueAt(row, 1).toString();
        
        String[] studentData = com.udj.logic.StudentManager.getStudent(id);
        String defaultPass = id; 
        
        if (studentData != null) {
            String fullName = studentData[1];
            if (fullName.contains(",")) {
                defaultPass = fullName.split(",")[0].trim().replace(" ", "");
            }
        }

        int confirm = JOptionPane.showConfirmDialog(null, 
            "Create account for ID: " + id + "?\nDefault Password: " + defaultPass, 
            "Confirm Create", 
            JOptionPane.YES_NO_OPTION);
            
        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = AccountManager.createAccount(id, id, defaultPass, "STUDENT");
            
            if (success) {
                JOptionPane.showMessageDialog(null, "Account Created!");
                parentPanel.refreshActiveTable();
            } else {
                JOptionPane.showMessageDialog(null, "Error creating account.");
            }
        }
    }
}