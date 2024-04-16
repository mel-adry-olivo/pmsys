package ui.task.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import utils.IconUtils;
import main.utils.StyleUtils;
import ui.custom.SimplePanel;


public class TaskStatus extends SimplePanel implements TableCellRenderer{

    public TaskStatus() {
        initComponents();
        
        StyleUtils.applyDefaultStyles(status, StyleUtils.BUTTON_OUTLINED);
        StyleUtils.appendStyle(status, "borderColor: null; background: #D3E5EF; foreground: #3b5466;");
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.decode("#d3d3d3")));
        String statusType = (String) table.getValueAt(row, 2);
       
        status.setIcon(IconUtils.getIcon(statusType.toLowerCase() + "_circle"));
        setText(statusType.toUpperCase());
        setStatusColor(statusType.toUpperCase());
        
        return this;
    }
    
    public void setStatusColor(String content) {
        switch(content.toUpperCase()) {
            case "TO DO" -> StyleUtils.appendStyle(status, "borderColor: null; background: #DBEDDB; foreground: #425C4D;");
            case "READY" -> StyleUtils.appendStyle(status, "borderColor: null; background: #D3E5EF; foreground: #3b5466;");
            case "IN PROGRESS" -> StyleUtils.appendStyle(status, "borderColor: null; background: #FDECC8; foreground: #574430;");
            case "TO REVIEW" -> StyleUtils.appendStyle(status, "borderColor: null; background: #E8DEEE; foreground: #553B67;");
            case "DONE" -> StyleUtils.appendStyle(status, "borderColor: null; background: #ffe2dd; foreground: #a36e6b;");
        }
    }
    
    public void setText(String text) {
        status.setText(text);
    }
    
    public String getText() {
        return status.getText();
    }

    public void setWidth(int w) {
        setMaximumSize(new Dimension(w, 25));
        setMinimumSize(new Dimension(w, 25));
        setPreferredSize(new Dimension(w, 25));
        status.setMaximumSize(new Dimension(w, 25));
        status.setMinimumSize(new Dimension(w, 25));
        status.setPreferredSize(new Dimension(w, 25));
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        status = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(31, 111, 235));
        setArc(0);
        setColumnConstraints("[center]");
        setComponentConstraint(new String[] {"center, grow"});
        setFlatClientProperty("");
        setLayoutConstraints("insets 0, fill, center, center");
        setMaximumSize(new java.awt.Dimension(115, 25));
        setMinimumSize(new java.awt.Dimension(115, 25));
        setOpacity(1.0F);
        setPreferredSize(new java.awt.Dimension(115, 25));
        setRowConstraints("[center]");

        status.setFont(new java.awt.Font("Inter", 1, 10)); // NOI18N
        status.setText("IN PROGRESS");
        status.setBorderPainted(false);
        status.setFocusPainted(false);
        status.setMargin(new java.awt.Insets(2, 10, 3, 10));
        status.setMaximumSize(new java.awt.Dimension(115, 25));
        status.setMinimumSize(new java.awt.Dimension(115, 25));
        status.setPreferredSize(new java.awt.Dimension(115, 25));
        add(status);
        status.getAccessibleContext().setAccessibleParent(status);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton status;
    // End of variables declaration//GEN-END:variables

   
}
