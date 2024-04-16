package ui.task.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import main.utils.StyleUtils;
import ui.custom.SimplePanel;


public class TaskPriority extends SimplePanel implements TableCellRenderer{

    public TaskPriority() {
        initComponents();
        
        StyleUtils.applyDefaultStyles(priority, StyleUtils.BUTTON_OUTLINED);

    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.decode("#d3d3d3")));
        String priorityType = (String) table.getValueAt(row, 3);
       
        setText(priorityType.toUpperCase());
        setStatusColor(priorityType.toUpperCase());
        
        return this;
    }

    private void setStatusColor(String content) {     
        switch(content.toUpperCase()) {
            case "LOW" -> StyleUtils.appendStyle(priority, "borderColor: null; background: #DBEDDB; foreground: #3F5A49;");
            case "MEDIUM" -> StyleUtils.appendStyle(priority, "borderColor: null; background: #FDECC8; foreground: #574430;");
            case "HIGH" -> StyleUtils.appendStyle(priority, "borderColor: null; background: #FFE2DD; foreground: #7B3D3A;");
        }
    }
    
    public void setText(String text) {
        priority.setText(text);
    }
  
    
    @Override
    public Insets getInsets() {
        return new Insets(5, 5, 5, 5); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        priority = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(31, 111, 235));
        setArc(0);
        setColumnConstraints("[center]");
        setComponentConstraint(new String[] {"center"});
        setFlatClientProperty("");
        setLayoutConstraints("insets 5, fill, center, center");
        setMaximumSize(new java.awt.Dimension(100, 25));
        setMinimumSize(new java.awt.Dimension(100, 25));
        setOpacity(1.0F);
        setPreferredSize(new java.awt.Dimension(100, 25));
        setRowConstraints("[center]");

        priority.setBackground(new java.awt.Color(204, 255, 204));
        priority.setFont(new java.awt.Font("Inter", 1, 10)); // NOI18N
        priority.setForeground(new java.awt.Color(182, 205, 182));
        priority.setText("LOW");
        priority.setMaximumSize(new java.awt.Dimension(100, 25));
        priority.setMinimumSize(new java.awt.Dimension(100, 25));
        priority.setPreferredSize(new java.awt.Dimension(100, 25));
        add(priority);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton priority;
    // End of variables declaration//GEN-END:variables

   
}
