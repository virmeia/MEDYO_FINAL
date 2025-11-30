package com.udj.gui.components;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class StudentActionCellEditor extends AbstractCellEditor implements TableCellEditor {
    private final StudentActionPanel panel;
    private int currentRow;
    private final JTable table;
    private final com.udj.gui.StudentManagement parentPanel;
    
    public StudentActionCellEditor(JTable table, com.udj.gui.StudentManagement parentPanel) {
        this.table = table;
        this.parentPanel = parentPanel; 
        panel = new StudentActionPanel();

        panel.addViewListener(e -> {
            viewStudent(currentRow);
            fireEditingStopped();
        });

        panel.addEditListener(e -> {
            editStudent(currentRow);
            fireEditingStopped();
        });

        panel.addDeleteListener(e -> {
            deleteStudent(currentRow);
            fireEditingStopped();
        });
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        currentRow = row;
        return panel;
    }
    
    @Override
    public Object getCellEditorValue() {
        return "";
    }
    
    private void viewStudent(int row) {
        String id = table.getValueAt(row, 0).toString();
        java.awt.Window parentWindow = javax.swing.SwingUtilities.getWindowAncestor(table);
        java.awt.Frame frame = null;
        if (parentWindow instanceof java.awt.Frame frame1) {
            frame = frame1;
        }
        com.udj.gui.ViewStudent viewDialog = new com.udj.gui.ViewStudent(frame, true);
        viewDialog.loadStudentDetails(id); 
        viewDialog.setVisible(true);
    }
    
    private void editStudent(int row) {
        String id = table.getValueAt(row, 0).toString();
        Frame parentFrame = (Frame) SwingUtilities.getWindowAncestor(table);
        com.udj.gui.EditStudent editDialog = new com.udj.gui.EditStudent(parentFrame, true, parentPanel);
        editDialog.loadStudentDetails(id);
        editDialog.setVisible(true);
    }
    
    private void deleteStudent(int row) {
        String id = table.getValueAt(row, 0).toString();
       
        Window parentWindow = SwingUtilities.getWindowAncestor(table);
        Frame frame = null;
        if (parentWindow instanceof Frame frame1) {
            frame = frame1;
        }

        com.udj.gui.DeleteStudent dialog = new com.udj.gui.DeleteStudent(frame, true);
        dialog.setTargetID(id); 
        dialog.setVisible(true); 

        if (dialog.isConfirmed()) {
            boolean success = com.udj.logic.StudentManager.deleteStudent(id);
           
            if (success) {
                JOptionPane.showMessageDialog(null, "Student deleted successfully!");
                parentPanel.refreshTable(); 
            } else {
                JOptionPane.showMessageDialog(null, "Error deleting student.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}