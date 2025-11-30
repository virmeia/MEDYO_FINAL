package com.udj.gui.components;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

@SuppressWarnings("unchecked")
public class CustomComboBox {

    public static void applyStyle(JComboBox combo) {
        combo.setFocusable(false);
        combo.setOpaque(true);
        combo.setBackground(Color.WHITE); 
        combo.setForeground(new Color(0x3D1F5C)); 
        combo.setBorder(null);
        combo.putClientProperty("JComponent.roundRect", true);
        combo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setBorder(new EmptyBorder(6, 10, 6, 10));
                if (isSelected) {
                    setBackground(new Color(0x8750a6));
                    setForeground(Color.WHITE);
                } else {
                    setBackground(new Color(0xf8e9ff));
                    setForeground(new Color(0x3D1F5C));
                }

                return c;
            }
        });

        combo.setUI(new javax.swing.plaf.basic.BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton arrow = new JButton("▼");
                arrow.setBorder(null);
                arrow.setFocusable(false);
                arrow.setOpaque(true);
                arrow.setBackground(new Color(0x8750A6));
                arrow.setForeground(Color.WHITE);
                return arrow;
            }
        });
    }
    
    public static void applyScrollbar(JComboBox<?> combo) {
        Object comp = combo.getUI().getAccessibleChild(combo, 0);
        if (comp instanceof JPopupMenu popup) {
            JScrollPane scrollPane = (JScrollPane) popup.getComponent(0);
            JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
            verticalBar.setUI(new CustomScrollBarUI());
            verticalBar.setPreferredSize(new Dimension(8, 0)); // width of scrollbar  
            verticalBar.setOpaque(false);
            scrollPane.setBorder(null);
        }
    }
}
