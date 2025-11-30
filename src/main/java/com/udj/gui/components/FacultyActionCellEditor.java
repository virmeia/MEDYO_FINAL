package com.udj.gui.components;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class FacultyActionCellEditor extends AbstractCellEditor implements TableCellEditor {
    private final FacultyActionPanel panel;
    private int currentRow;
    private final JTable table;
    private final com.udj.gui.FacultyManagement parentPanel;
    
    public FacultyActionCellEditor(JTable table, com.udj.gui.FacultyManagement parentPanel) {
        this.table = table;
        this.parentPanel = parentPanel; 
        panel = new FacultyActionPanel();
        
        panel.addViewListener(e -> {
            viewFaculty(currentRow);
            fireEditingStopped();
        });
        
        panel.addEditListener(e -> {
            editFaculty(currentRow);
            fireEditingStopped();
        });
        
        panel.addDeleteListener(e -> {
            deleteFaculty(currentRow);
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
    
    private void viewFaculty(int row) {
        String id = table.getValueAt(row, 0).toString();
        java.awt.Window parentWindow = javax.swing.SwingUtilities.getWindowAncestor(table);
        java.awt.Frame frame = null;
        if (parentWindow instanceof java.awt.Frame frame1) {
            frame = frame1;
        }
        
        com.udj.gui.ViewFaculty viewDialog = new com.udj.gui.ViewFaculty(frame, true);
        viewDialog.loadFacultyDetails(id); 
        viewDialog.setVisible(true);
    }
    
    private void editFaculty(int row) {
        String id = table.getValueAt(row, 0).toString();
        Frame parentFrame = (Frame) SwingUtilities.getWindowAncestor(table);
        
        com.udj.gui.EditFaculty editDialog = new com.udj.gui.EditFaculty(parentFrame, true, parentPanel);
        editDialog.loadFacultyDetails(id);
        editDialog.setVisible(true);
    }
    
    private void deleteFaculty(int row) {
        String id = table.getValueAt(row, 0).toString();
       
        Window parentWindow = SwingUtilities.getWindowAncestor(table);
        Frame frame = null;
        if (parentWindow instanceof Frame frame1) {
            frame = frame1;
        }
        
        com.udj.gui.DeleteFaculty dialog = new com.udj.gui.DeleteFaculty(frame, true);
        dialog.setTargetID(id); 
        dialog.setVisible(true); 
        
        if (dialog.isConfirmed()) {
            boolean success = com.udj.logic.FacultyManager.deleteFaculty(id);
           
            if (success) {
                JOptionPane.showMessageDialog(null, "Faculty deleted successfully!");
                parentPanel.refreshTable(); 
            } else {
                JOptionPane.showMessageDialog(null, "Error deleting faculty.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}