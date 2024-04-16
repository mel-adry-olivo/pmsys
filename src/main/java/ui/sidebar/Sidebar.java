package ui.sidebar;

import javax.swing.JButton;
import javax.swing.JFrame;
import utils.IconUtils;
import main.utils.StyleUtils;
import ui.custom.SimplePanel;

public final class Sidebar extends SimplePanel {
       
    private JButton[] buttons;
    private SidebarMouseEvents mouseEvents;
   
    public Sidebar() {  
        initComponents();
        initButtons();
    } 
    
    private void initButtons() {
        
        buttons = new JButton[]{btnDashboard, btnProjects};
        mouseEvents = new SidebarMouseEvents(buttons);
      
        for (JButton button : buttons) {
                button.addMouseListener(mouseEvents);
                StyleUtils.applyDefaultStyles(button, StyleUtils.BUTTON_LOGO);
                button.setIcon(IconUtils.getMenuIcon(button.isSelected(), button.getName()));
                button.revalidate();
            }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDashboard = new javax.swing.JButton();
        btnProjects = new javax.swing.JButton();

        setBackground(new java.awt.Color(47, 43, 67));
        setFocusCycleRoot(true);
        setLayoutConstraints("flowy, center, insets 100 0 0 0");
        setMaximumSize(new java.awt.Dimension(50, 720));
        setMinimumSize(new java.awt.Dimension(50, 720));
        setPreferredSize(new java.awt.Dimension(50, 720));
        setRowConstraints("[]40[]40[]40[]");

        btnDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDashboard.setFocusPainted(false);
        btnDashboard.setMaximumSize(new java.awt.Dimension(35, 35));
        btnDashboard.setMinimumSize(new java.awt.Dimension(35, 35));
        btnDashboard.setName("dashboard"); // NOI18N
        btnDashboard.setPreferredSize(new java.awt.Dimension(18, 18));
        add(btnDashboard);

        btnProjects.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProjects.setFocusPainted(false);
        btnProjects.setMaximumSize(new java.awt.Dimension(35, 35));
        btnProjects.setMinimumSize(new java.awt.Dimension(35, 35));
        btnProjects.setName("projects"); // NOI18N
        btnProjects.setPreferredSize(new java.awt.Dimension(18, 18));
        add(btnProjects);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnProjects;
    // End of variables declaration//GEN-END:variables
}
