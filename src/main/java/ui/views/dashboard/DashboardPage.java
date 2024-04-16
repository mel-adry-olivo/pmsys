package ui.views.dashboard;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import ui.custom.SimplePanel;
import main.utils.StyleUtils;
import ui.project.ProjectAddForm;
import utils.PopupUtils;

public class DashboardPage extends SimplePanel{

    public DashboardPage() {
        initComponents();
        addProjectButtonEvent();
        

        StyleUtils.applyDefaultStyles(btnAddProject, StyleUtils.BUTTON_FILLED)
                .include("arc: 50;");
    }

    private void addProjectButtonEvent() {
        btnAddProject.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {                
                ProjectAddForm form = new ProjectAddForm();
                PopupUtils.getInstance().showPopup(form);
            }
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        content = new ui.custom.SimplePanel();
        greeting = new javax.swing.JLabel();
        subGreeting = new javax.swing.JLabel();
        btnAddProject = new javax.swing.JButton();
        myProjects = new javax.swing.JLabel();
        pnlProjects = new ui.custom.SimplePanel();
        undecided = new javax.swing.JLabel();
        undecidedPanel = new ui.custom.SimplePanel();
        side = new ui.custom.SimplePanel();
        currentDate = new ui.views.dashboard.DashboardDate();
        txtUpcoming = new javax.swing.JLabel();
        pnlDeadlines = new ui.custom.SimplePanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setFocusable(false);
        setMaximumSize(new java.awt.Dimension(1230, 650));
        setMinimumSize(new java.awt.Dimension(1230, 650));
        setPreferredSize(new java.awt.Dimension(1230, 650));

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setColumnConstraints("[grow]push[]");
        content.setComponentConstraint(new String[] {"cell 0 0", "cell 0 1", "cell 1 0, span 2 2, gapleft 50", "wrap, gaptop 35", "span 2", "wrap, gaptop 20", "span 2"});
        content.setLayoutConstraints("insets 25 40 25 40, wrap");
        content.setPreferredSize(new java.awt.Dimension(780, 650));
        content.setRowConstraints("[][]");

        greeting.setBackground(new java.awt.Color(38, 38, 38));
        greeting.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        greeting.setForeground(new java.awt.Color(38, 38, 38));
        greeting.setText("Good morning, Project Manager!");
        greeting.setFocusable(false);
        content.add(greeting);

        subGreeting.setFont(new java.awt.Font("Inter Medium", 0, 11)); // NOI18N
        subGreeting.setForeground(new java.awt.Color(157, 157, 157));
        subGreeting.setText("Track progress and manage tasks efficiently");
        subGreeting.setFocusable(false);
        content.add(subGreeting);

        btnAddProject.setBackground(new java.awt.Color(47, 43, 67));
        btnAddProject.setFont(new java.awt.Font("Inter", 1, 15)); // NOI18N
        btnAddProject.setForeground(new java.awt.Color(255, 255, 255));
        btnAddProject.setText("+ New Project");
        btnAddProject.setBorderPainted(false);
        btnAddProject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddProject.setFocusPainted(false);
        btnAddProject.setInheritsPopupMenu(true);
        btnAddProject.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnAddProject.setPreferredSize(new java.awt.Dimension(150, 40));
        content.add(btnAddProject);

        myProjects.setFont(new java.awt.Font("Inter", 1, 13)); // NOI18N
        myProjects.setForeground(new java.awt.Color(38, 38, 38));
        myProjects.setText("My projects");
        myProjects.setFocusable(false);
        content.add(myProjects);

        pnlProjects.setBackground(new java.awt.Color(255, 255, 255));
        pnlProjects.setFlatClientProperty("arc: 50; border: 1,1,1,1, #d3d3d3,1,50;");
        pnlProjects.setFocusable(false);
        pnlProjects.setInheritsPopupMenu(true);
        pnlProjects.setPreferredSize(new java.awt.Dimension(700, 250));
        content.add(pnlProjects);

        undecided.setFont(new java.awt.Font("Inter", 1, 13)); // NOI18N
        undecided.setForeground(new java.awt.Color(38, 38, 38));
        undecided.setText("Undecided");
        undecided.setFocusable(false);
        content.add(undecided);

        undecidedPanel.setBackground(new java.awt.Color(255, 255, 255));
        undecidedPanel.setFlatClientProperty("arc: 50; border: 1,1,1,1, #d3d3d3,1,50;");
        undecidedPanel.setFocusable(false);
        undecidedPanel.setInheritsPopupMenu(true);
        undecidedPanel.setPreferredSize(new java.awt.Dimension(700, 180));
        content.add(undecidedPanel);

        side.setBackground(new java.awt.Color(255, 255, 255));
        side.setLayoutConstraints("insets 25 40 25 40, wrap");
        side.setPreferredSize(new java.awt.Dimension(450, 650));
        side.setRowConstraints("[]25[][]10[]");

        currentDate.setFocusable(false);
        currentDate.setRowConstraints("");
        side.add(currentDate);

        txtUpcoming.setFont(new java.awt.Font("Inter", 1, 13)); // NOI18N
        txtUpcoming.setForeground(new java.awt.Color(38, 38, 38));
        txtUpcoming.setText("Upcoming project deadlines");
        txtUpcoming.setFocusable(false);
        side.add(txtUpcoming);

        pnlDeadlines.setFlatClientProperty("arc: 50; border: 1,1,1,1, #d3d3d3,1,50;");
        pnlDeadlines.setFocusable(false);
        pnlDeadlines.setOpacity(0.0F);
        pnlDeadlines.setOpaque(false);
        pnlDeadlines.setPreferredSize(new java.awt.Dimension(420, 510));
        side.add(pnlDeadlines);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(side, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(side, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProject;
    private ui.custom.SimplePanel content;
    private ui.views.dashboard.DashboardDate currentDate;
    private javax.swing.JLabel greeting;
    private javax.swing.JLabel myProjects;
    private ui.custom.SimplePanel pnlDeadlines;
    private ui.custom.SimplePanel pnlProjects;
    private ui.custom.SimplePanel side;
    private javax.swing.JLabel subGreeting;
    private javax.swing.JLabel txtUpcoming;
    private javax.swing.JLabel undecided;
    private ui.custom.SimplePanel undecidedPanel;
    // End of variables declaration//GEN-END:variables

}
