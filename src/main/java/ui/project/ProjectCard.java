package ui.project;

import java.awt.Cursor;
import javax.swing.SwingUtilities;
import main.utils.StyleUtils;
import project.Project;
import ui.custom.SimplePanel;
import utils.IconUtils;

public class ProjectCard extends SimplePanel{
    
    private Project project;
    
    public ProjectCard() {
        initComponents();
        initListeners();
        customizeComponents();
        
        
    }
    
    public final void initListeners() {
        SwingUtilities.invokeLater(() -> {
            
            addMouseListener(new ProjectCardMouseEvents(this));

            btnOptions.addActionListener((e) -> {           
                ProjectCardPopupMenu.create(project, this).show(btnOptions, btnOptions.getWidth(), btnOptions.getHeight());    
            });
        }); 
    }
    public final void customizeComponents(){
            
        SwingUtilities.invokeLater(() -> {
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            IconUtils.setButtonIcon(btnOptions, "projects_menu");
            StyleUtils.applyDefaultStyles(btnOptions, StyleUtils.BUTTON_LOGO);
        });  
    }
    

    public static ProjectCard createCard(Project project) {

        ProjectCard projectCard = new ProjectCard.Create(project)
                                        .withTitle(project.getTitle())
                                        .withDescription(project.getDescription())
                                        .withStatus(project.getStatus())
                                        .withDoneTasks(project.getDoneTasks())
                                        .withTaskCount(project.getTasks().size())                        
                                        .withDueDate(project.getDueDate().toString())
                                        .build();
        return projectCard;
    }


  
    public static class Create {
        
        private Project project;
        private String title;
        private String description;
        private String status;
        private int taskCount;
        private int doneTasks; 
        private String dueDate;
        
        public Create(Project project) {
            this.project = project;
        }

        public Create withTitle(String title) {
            this.title = title;
            return this;
        }
        
        public Create withDescription(String description) {
            this.description = description;
            return this;
        }

        public Create withStatus(String status) {
            this.status = status;
            return this;
        }

        public Create withDoneTasks(int doneTasks) {
            this.doneTasks = doneTasks;
            return this;
        }
        
        public Create withTaskCount(int taskCount) {
            this.taskCount = taskCount;
            return this;
        }
        
        public Create withDueDate(String dueDate) {
            this.dueDate = dueDate;
            return this;
        }
        
        public ProjectCard build() {
            
            ProjectCard card = new ProjectCard(); 

            SwingUtilities.invokeLater(() -> {
                card.setProject(project);
                card.setTitle(title);
                card.setDescription(description);
                card.setStatus(status);
                card.setTasksDone(doneTasks);
                card.setTaskCount(taskCount, doneTasks);    
                card.setDueDate(dueDate);
            });
            
            return card;
        }
    }
    
    // Getters & Setters

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }  
    public void setTitle(String title) {
        txtProjectTitle.setText(title);
    }  
    public void setDescription(String description) {
        txtDescription.setText(description);
    }   
    public void setStatus(String status) {
        this.status.setText(status);
    }   
    public void setTaskCount(int count, int doneTasks) {
        txtTasksDone.setText("Task Done: "+doneTasks+ " / " + project.getTasks().size());
        progressBar.setMaximum(count);
    }  
    
    public void setTasksDone(int tasksDone) {
        progressBar.setValue(tasksDone);
    }
    
    public void setDueDate(String dueDate) {
        this.dueDate.setText(dueDate);
    }


 
       
    //////////////////////////////////
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtProjectTitle = new javax.swing.JLabel();
        btnOptions = new javax.swing.JButton();
        status = new ui.project.ProjectStatus();
        txtDescription = new javax.swing.JLabel();
        txtTasksDone = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        dueDate = new ui.project.ProjectDueDate();

        setBackground(new java.awt.Color(255, 255, 255));
        setArc(0);
        setColumnConstraints("");
        setComponentConstraint(new String[] {"pushx, width 100%", "wrap", "wrap", "wrap", "wrap", "wrap, span 2"});
        setFlatClientProperty("arc: 30; border: 1,0,1,1, #d3d3d3,1,30;");
        setLayoutConstraints("insets 20 20 18 20");
        setMinimumSize(new java.awt.Dimension(270, 240));
        setName("card"); // NOI18N
        setOpacity(1.0F);
        setPreferredSize(new java.awt.Dimension(270, 240));
        setRequestFocusEnabled(false);
        setRowConstraints("[]15[]15[]15[]15[]20[]");

        txtProjectTitle.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        txtProjectTitle.setForeground(new java.awt.Color(38, 38, 38));
        txtProjectTitle.setText("Project Name");
        txtProjectTitle.setMaximumSize(new java.awt.Dimension(200, 20));
        txtProjectTitle.setMinimumSize(new java.awt.Dimension(200, 20));
        txtProjectTitle.setPreferredSize(new java.awt.Dimension(200, 20));
        add(txtProjectTitle);

        btnOptions.setBackground(new java.awt.Color(255, 255, 255));
        btnOptions.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOptions.setFocusPainted(false);
        btnOptions.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnOptions.setMaximumSize(new java.awt.Dimension(20, 20));
        btnOptions.setMinimumSize(new java.awt.Dimension(20, 20));
        btnOptions.setPreferredSize(new java.awt.Dimension(20, 20));
        add(btnOptions);

        status.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        status.setEnabled(false);
        status.setText("ACTIVE");
        add(status);

        txtDescription.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        txtDescription.setForeground(new java.awt.Color(157, 157, 157));
        txtDescription.setText("<html>Track progress and manage tasks efficiently</html>");
        txtDescription.setMaximumSize(new java.awt.Dimension(200, 30));
        txtDescription.setMinimumSize(new java.awt.Dimension(200, 30));
        txtDescription.setPreferredSize(new java.awt.Dimension(200, 30));
        add(txtDescription);

        txtTasksDone.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        txtTasksDone.setForeground(new java.awt.Color(38, 38, 38));
        txtTasksDone.setText("Tasks: 0");
        add(txtTasksDone);

        progressBar.setForeground(new java.awt.Color(47, 43, 67));
        progressBar.setPreferredSize(new java.awt.Dimension(250, 4));
        add(progressBar);

        dueDate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dueDate.setEnabled(false);
        add(dueDate);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOptions;
    private ui.project.ProjectDueDate dueDate;
    private javax.swing.JProgressBar progressBar;
    private ui.project.ProjectStatus status;
    private javax.swing.JLabel txtDescription;
    private javax.swing.JLabel txtProjectTitle;
    private javax.swing.JLabel txtTasksDone;
    // End of variables declaration//GEN-END:variables

}
