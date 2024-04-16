package ui.topbar;

import main.utils.StyleUtils;
import utils.IconUtils;
import ui.custom.SimplePanel;


public final class Topbar extends SimplePanel {

    TopbarStyleHandler styleEvents;

    public Topbar() {
        initComponents();
        initComponentStyles();
        initComponentStyleEvents();

    }

    public void initComponentStyles() {
        StyleUtils.applyDefaultStyles(searchButton, StyleUtils.BUTTON_LOGO)
                .include("hoverBackground: #2F2B43; pressedBackground: #2F2B43;");

        searchBar.putClientProperty("JTextField.placeholderText", "Search not implemented yet :>");
        searchBar.putClientProperty("FlatLaf.style", "border: null;");

        searchButton.setIcon(IconUtils.getIcon("search_default"));
    }

    private void initComponentStyleEvents() {
        styleEvents = new TopbarStyleHandler(searchPanel, searchButton);
        searchBar.addFocusListener(styleEvents);
        searchButton.addMouseListener(styleEvents);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchPanel = new ui.custom.SimplePanel();
        searchBar = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(233, 233, 233)));
        setColumnConstraints("[]push[]10[]");
        setLayoutConstraints("insets 10 30 10 50, fill");
        setMaximumSize(new java.awt.Dimension(1230, 70));
        setMinimumSize(new java.awt.Dimension(1230, 70));
        setPreferredSize(new java.awt.Dimension(1230, 70));

        searchPanel.setFlatClientProperty("arc: 50; border: 1,1,1,1, #d3d3d3,1,50;");
        searchPanel.setLayoutConstraints("insets 5 25 5 10");
        searchPanel.setOpacity(0.0F);
        searchPanel.setOpaque(false);
        searchPanel.setPreferredSize(new java.awt.Dimension(720, 40));

        searchBar.setBackground(new java.awt.Color(255, 255, 255));
        searchBar.setForeground(new java.awt.Color(38, 38, 38));
        searchBar.setBorder(null);
        searchBar.setPreferredSize(new java.awt.Dimension(650, 40));
        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });
        searchPanel.add(searchBar);
        searchBar.getAccessibleContext().setAccessibleName("");
        searchBar.getAccessibleContext().setAccessibleDescription("");

        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchButton.setMaximumSize(new java.awt.Dimension(30, 30));
        searchButton.setMinimumSize(new java.awt.Dimension(30, 30));
        searchButton.setName("search"); // NOI18N
        searchButton.setPreferredSize(new java.awt.Dimension(30, 30));
        searchPanel.add(searchButton);

        add(searchPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField searchBar;
    private javax.swing.JButton searchButton;
    private ui.custom.SimplePanel searchPanel;
    // End of variables declaration//GEN-END:variables
}
