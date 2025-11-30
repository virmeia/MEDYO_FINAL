package com.udj.gui.components;

import com.udj.logic.AccountManager;
import com.udj.gui.SystemAccountManagement;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class SystemActionCellEditor extends AbstractCellEditor implements TableCellEditor {
    private static final String SECURITY_KEY = "JEMA1234";
    private final SystemActionPanel panel;
    private final JTable table;
    private final SystemAccountManagement parentPanel;
    private int currentRow;
    
    public SystemActionCellEditor(JTable table, SystemAccountManagement parentPanel) {
        this.table = table;
        this.parentPanel = parentPanel;
        panel = new SystemActionPanel();
        
        panel.addResetListener(e -> {
            fireEditingStopped();
            resetPassword(currentRow);
        });
        
        panel.addDeleteListener(e -> {
            fireEditingStopped();
            deleteAccount(currentRow);
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
   
    private void resetPassword(int row) {
        String id = table.getValueAt(row, 1).toString();
        String surname = AccountManager.getSurname(id);
        String defaultPass;
        String message;

        if (surname != null) {
            defaultPass = surname;
            message = "Reset password for " + id + "?\n" +
                      "It will revert to the SURNAME: " + defaultPass;
        } else {
            defaultPass = id;
            message = "Surname not found in records.\n" +
                      "Password will revert to User ID: " + defaultPass;
        }
        
        int confirm = JOptionPane.showConfirmDialog(null, 
            message, 
            "Confirm Reset", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
            
        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = AccountManager.resetPassword(id, defaultPass);
            if (success) {
                JOptionPane.showMessageDialog(null, "Password reset to: " + defaultPass);
            } else {
                JOptionPane.showMessageDialog(null, "Error updating password file.");
            }
        }
    }
    
    private void deleteAccount(int row) {
        String id = table.getValueAt(row, 1).toString(); 
        String role = table.getValueAt(row, 2).toString().toUpperCase();

        if (role.equals("ADMIN")) {
            javax.swing.JFrame parentFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(table);
            com.udj.gui.components.EnterSecurityKey keyDialog = new com.udj.gui.components.EnterSecurityKey(parentFrame, true);
            keyDialog.setVisible(true); 
            
            if (!keyDialog.isConfirmed()) return;

            String inputKey = keyDialog.getSecurityKey(); 
            
            if (inputKey == null || inputKey.trim().isEmpty()) {
                 javax.swing.JOptionPane.showMessageDialog(null, "Security key is empty.", "Error", javax.swing.JOptionPane.WARNING_MESSAGE);
                 return;
            }

            if (inputKey.equals(SECURITY_KEY)) {
                performDelete(id);
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Invalid Security Key! Deletion Cancelled.", "Access Denied", javax.swing.JOptionPane.ERROR_MESSAGE);
            }

        } else {
            javax.swing.JFrame parentFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(table);
            com.udj.gui.components.DeleteAccount deleteDialog = new com.udj.gui.components.DeleteAccount(parentFrame, true);
            deleteDialog.setTargetID(id); 
            deleteDialog.setVisible(true);         
            if (deleteDialog.isConfirmed()) {
                performDelete(id);
            }
        }
    }

    private void performDelete(String id) {
        boolean success = AccountManager.deleteAccount(id);
        if (success) {
            JOptionPane.showMessageDialog(null, "Account removed.");
            parentPanel.refreshActiveTable();
        } else {
            JOptionPane.showMessageDialog(null, "Error deleting account.");
        }
    }
}