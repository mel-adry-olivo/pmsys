package ui.project;

import java.awt.Cursor;
import ui.custom.SimplePanel;


public class ProjectDueDate extends SimplePanel {

    public ProjectDueDate() {
        initComponents();
    }
    
    public void setText(String text) {
        dueDateLabel.setText("DUE DATE: " + text);
        repaint();
    }
    
    public void setCursor(Cursor cursor) {
        dueDateLabel.setCursor(cursor);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dueDateLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setArc(50);
        setColumnConstraints("[center]");
        setComponentConstraint(new String[] {});
        setFlatClientProperty("arc: 50; border: 1,0,1,1, #B75AFF, 2,50;");
        setLayoutConstraints("insets 0, fill, center, center");
        setMaximumSize(new java.awt.Dimension(140, 20));
        setMinimumSize(new java.awt.Dimension(140, 20));
        setOpacity(1.0F);
        setPreferredSize(new java.awt.Dimension(140, 20));

        dueDateLabel.setBackground(new java.awt.Color(255, 255, 255));
        dueDateLabel.setFont(new java.awt.Font("Inter", 1, 9)); // NOI18N
        dueDateLabel.setForeground(new java.awt.Color(183, 90, 255));
        dueDateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dueDateLabel.setText("DUE DATE: 00 JAN 0000");
        dueDateLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dueDateLabel.setFocusable(false);
        dueDateLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        dueDateLabel.setMaximumSize(new java.awt.Dimension(140, 20));
        dueDateLabel.setMinimumSize(new java.awt.Dimension(140, 20));
        dueDateLabel.setPreferredSize(new java.awt.Dimension(140, 20));
        add(dueDateLabel);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dueDateLabel;
    // End of variables declaration//GEN-END:variables

}
