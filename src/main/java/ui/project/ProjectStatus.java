package ui.project;

import java.awt.Color;
import java.awt.Cursor;
import ui.custom.SimplePanel;


public class ProjectStatus extends SimplePanel {

    public ProjectStatus() {
        initComponents();
    }

    public void setText(String text) {
        statusLabel.setText(text);
        switch(text) {
            case "ACTIVE" -> setBackground(Color.decode("#4E6AFF"));
            case "ON HOLD" -> setBackground(Color.decode("#FFA34E"));
            case "DONE" -> setBackground(Color.decode("#57CA70"));
        }
        repaint();
    }
    
    public void setCursor(Cursor cursor) {
        statusLabel.setCursor(cursor);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statusLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 163, 78));
        setForeground(new java.awt.Color(255, 255, 255));
        setArc(50);
        setColumnConstraints("[center]");
        setComponentConstraint(new String[] {"center"});
        setFlatClientProperty("arc: 50");
        setLayoutConstraints("insets 0, fill, center, center");
        setMaximumSize(new java.awt.Dimension(75, 20));
        setMinimumSize(new java.awt.Dimension(75, 20));
        setOpacity(1.0F);
        setPreferredSize(new java.awt.Dimension(75, 20));
        setRowConstraints("[center]");

        statusLabel.setFont(new java.awt.Font("Inter", 1, 9)); // NOI18N
        statusLabel.setForeground(new java.awt.Color(255, 255, 255));
        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusLabel.setText("STATUS");
        statusLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        statusLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        statusLabel.setMaximumSize(new java.awt.Dimension(75, 20));
        statusLabel.setMinimumSize(new java.awt.Dimension(75, 20));
        statusLabel.setPreferredSize(new java.awt.Dimension(75, 20));
        add(statusLabel);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables

}
