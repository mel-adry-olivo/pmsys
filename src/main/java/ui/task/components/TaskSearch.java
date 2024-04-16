package ui.task.components;

import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import ui.custom.SimplePanel;

public class TaskSearch extends SimplePanel {

    public TaskSearch() {
        initComponents();
           
        searchBar.putClientProperty("JTextField.placeholderText", "Search tasks here");
        searchBar.putClientProperty("FlatLaf.style", "border: null;");       
        searchBar.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                searchbarFocus(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                searchbarFocus(false);
            }
                });
    }
    
    
    
    public String getText() {
        return searchBar.getText();
    }
    
    private void searchbarFocus(boolean focused) {
        String borderStyle = focused ? "#2F2B43,2,50;" : "#d3d3d3,1,50;";
        String style = "arc: 50; border: 1,1,1,1," + borderStyle;

        FlatAnimatedLafChange.showSnapshot();
        this.putClientProperty("FlatLaf.style", style);
        FlatAnimatedLafChange.hideSnapshotWithAnimation();     
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchBar = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setFlatClientProperty("arc: 50; border: 1,1,1,1, #d3d3d3,1,50;");
        setLayoutConstraints("insets 5 25 5 10");
        setMaximumSize(new java.awt.Dimension(990, 30));
        setMinimumSize(new java.awt.Dimension(990, 30));
        setName(""); // NOI18N
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(990, 30));

        searchBar.setBackground(new java.awt.Color(255, 255, 255));
        searchBar.setFont(new java.awt.Font("Inter", 0, 11)); // NOI18N
        searchBar.setForeground(new java.awt.Color(38, 38, 38));
        searchBar.setBorder(null);
        searchBar.setPreferredSize(new java.awt.Dimension(990, 30));
        add(searchBar);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField searchBar;
    // End of variables declaration//GEN-END:variables

}
