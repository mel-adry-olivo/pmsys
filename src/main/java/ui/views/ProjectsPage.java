package ui.views;

import javax.swing.SwingUtilities;
import ui.custom.SimplePanel;
import ui.project.ProjectCard;

public class ProjectsPage extends SimplePanel{

    public static ProjectsPage instance = new ProjectsPage();  
    public static ProjectsPage getInstance() {
        return instance;
    }
     
    private static int count = 0;
    
    public ProjectsPage() {
        initComponents();
        customizeScrollPane();
        
    }

    public void addCard(ProjectCard card) {
        SwingUtilities.invokeLater(() -> {
            content.add(card, "grow, gaptop 15");    
            content.repaint();
            content.revalidate();   
        });   
    }
    
    public void removeCard(ProjectCard card) {
        SwingUtilities.invokeLater(() -> {
            content.remove(card);
            content.repaint();
            content.revalidate(); 
        });
    }
    
    public void removeAllCard() {
        SwingUtilities.invokeLater(() -> {
            content.removeAll();
        });
    }
    
    public void updateProjectCount() {
        SwingUtilities.invokeLater(() -> {
            projectCount.setText(content.getComponentCount() + " Projects");
        });
    }
    
    private void customizeScrollPane() {
        SwingUtilities.invokeLater(() -> {
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.putClientProperty("FlatLaf.style", ""
                + "border: null;"
                + "background: null;");
        });
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        main = new ui.custom.SimplePanel();
        top = new ui.custom.SimplePanel();
        txtPageTitle = new javax.swing.JLabel();
        projectCount = new javax.swing.JLabel();
        content = new ui.custom.SimplePanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayoutConstraints("insets 0, fill");
        setMinimumSize(new java.awt.Dimension(1230, 650));
        setPreferredSize(new java.awt.Dimension(1230, 650));
        setRowConstraints("");

        scrollPane.setBackground(new java.awt.Color(102, 153, 255));
        scrollPane.setForeground(new java.awt.Color(255, 255, 255));
        scrollPane.setAutoscrolls(true);
        scrollPane.setHorizontalScrollBar(null);
        scrollPane.setOpaque(false);
        scrollPane.setPreferredSize(new java.awt.Dimension(1230, 650));

        main.setBackground(new java.awt.Color(255, 255, 255));
        main.setColumnConstraints("");
        main.setComponentConstraint(new String[] {",", ",", "grow"});
        main.setLayoutConstraints("wrap, insets 20 58 0 58, fillx");
        main.setMaximumSize(new java.awt.Dimension(1230, 650));
        main.setMinimumSize(new java.awt.Dimension(1230, 650));
        main.setName(""); // NOI18N
        main.setPreferredSize(new java.awt.Dimension(1230, 650));
        main.setRowConstraints("[]4[]0[]");

        top.setBackground(new java.awt.Color(255, 204, 204));
        top.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(211, 211, 211)));
        top.setColumnConstraints("[]push[]");
        top.setComponentConstraint(new String[] {"wrap", ",", "span 2 2"});
        top.setLayoutConstraints("insets 10 4 5 4,");
        top.setMaximumSize(new java.awt.Dimension(1115, 65));
        top.setMinimumSize(new java.awt.Dimension(1115, 65));
        top.setOpacity(0.0F);
        top.setOpaque(false);
        top.setPreferredSize(new java.awt.Dimension(1115, 65));
        top.setRowConstraints("[]3[]");

        txtPageTitle.setFont(new java.awt.Font("Inter", 1, 24)); // NOI18N
        txtPageTitle.setForeground(new java.awt.Color(38, 38, 38));
        txtPageTitle.setText("Project List");
        top.add(txtPageTitle);

        projectCount.setFont(new java.awt.Font("Inter Medium", 0, 11)); // NOI18N
        projectCount.setForeground(new java.awt.Color(157, 157, 157));
        projectCount.setText("0 Projects");
        top.add(projectCount);

        main.add(top);

        content.setBackground(new java.awt.Color(204, 255, 204));
        content.setColumnConstraints("[]25[]25[]25[]");
        content.setComponentConstraint(new String[] {});
        content.setLayoutConstraints("wrap 4,  insets 0 0 0 0");
        content.setMaximumSize(new java.awt.Dimension(1115, 545));
        content.setMinimumSize(new java.awt.Dimension(1115, 545));
        content.setOpacity(0.0F);
        content.setOpaque(false);
        content.setPreferredSize(new java.awt.Dimension(1115, 545));
        content.setRowConstraints("");
        main.add(content);

        scrollPane.setViewportView(main);

        add(scrollPane);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ui.custom.SimplePanel content;
    private ui.custom.SimplePanel main;
    private javax.swing.JLabel projectCount;
    private javax.swing.JScrollPane scrollPane;
    private ui.custom.SimplePanel top;
    private javax.swing.JLabel txtPageTitle;
    // End of variables declaration//GEN-END:variables

}
