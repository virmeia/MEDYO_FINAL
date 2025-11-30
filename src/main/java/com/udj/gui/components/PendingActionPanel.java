package com.udj.gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PendingActionPanel extends JPanel {
    private final JButton viewBtn;
    private final JButton createBtn;
    
    public PendingActionPanel() {
        setLayout(new GridBagLayout()); 
        setOpaque(true);
        setBackground(new Color(244, 232, 250)); 
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 4, 0, 4); 
        
        viewBtn = createButton("👁", new Color(0x2e1448)); 
        viewBtn.setToolTipText("View Details");
        add(viewBtn, gbc);    
        
        createBtn = createButton("➕", new Color(0x27ae60));
        createBtn.setToolTipText("Create Account");
        add(createBtn, gbc);
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
    
    public void addViewListener(ActionListener listener) {
        viewBtn.addActionListener(listener);
    }
    
    public void addCreateListener(ActionListener listener) {
        createBtn.addActionListener(listener);
    }
}