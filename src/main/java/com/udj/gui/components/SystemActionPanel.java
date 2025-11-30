package com.udj.gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SystemActionPanel extends JPanel {
    private final JButton resetBtn;
    private final JButton deleteBtn;
    
    public SystemActionPanel() {
        setLayout(new GridBagLayout()); 
        setOpaque(true);
        setBackground(new Color(244, 232, 250));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 4, 0, 4);
        
        // 1. Reset Button (Key)
        resetBtn = createButton("🔑", new Color(0x2e1448));
        resetBtn.setToolTipText("Reset Password");
        add(resetBtn, gbc);    
        
        // 2. Delete Button (Trash)
        deleteBtn = createButton("🗑", new Color(0xA65087));
        deleteBtn.setToolTipText("Delete Account");
        add(deleteBtn, gbc);
    }
    
    private JButton createButton(String text, Color color) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
        btn.setForeground(color);
        btn.setBackground(new Color(244, 232, 250)); 
        btn.setBorder(null); 
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setPreferredSize(new Dimension(25, 25));
        return btn;
    }
    
    public void addResetListener(ActionListener listener) {
        resetBtn.addActionListener(listener);
    }
    
    public void addDeleteListener(ActionListener listener) {
        deleteBtn.addActionListener(listener);
    }
}