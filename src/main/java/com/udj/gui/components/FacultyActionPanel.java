package com.udj.gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FacultyActionPanel extends JPanel {
    private final JButton viewBtn;
    private final JButton editBtn;
    private final JButton deleteBtn;
    
    public FacultyActionPanel() {
        setLayout(new GridBagLayout()); 
        setOpaque(true);
        setBackground(new Color(244, 232, 250));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(4, 0, 0, 5);
        viewBtn = createButton("👁", new Color(0x2e1448));
        editBtn = createButton("✎", new Color(0x2e1448));
        deleteBtn = createButton("🗑", new Color(0xA65087));    
        add(viewBtn, gbc);    
        gbc.gridx = 1;
        add(editBtn, gbc);    
        gbc.gridx = 2;
        add(deleteBtn, gbc);
    }
    
    private JButton createButton(String text, Color color) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
        btn.setForeground(color);
        btn.setBackground(new Color(244, 232, 250)); 
        btn.setBorder(null); 
        btn.setBorderPainted(false); 
        btn.setContentAreaFilled(false); 
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setPreferredSize(new Dimension(20, 20));
        btn.setHorizontalAlignment(SwingConstants.CENTER);
        btn.setVerticalAlignment(SwingConstants.CENTER);
        return btn;
    }
    
    public void addViewListener(ActionListener listener) {
        viewBtn.addActionListener(listener);
    }
    
    public void addEditListener(ActionListener listener) {
        editBtn.addActionListener(listener);
    }
    
    public void addDeleteListener(ActionListener listener) {
        deleteBtn.addActionListener(listener);
    }
}