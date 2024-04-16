package ui.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumnModel;
import main.utils.StyleUtils;
import page.PageManager;
import project.Project;
import task.Task;
import ui.custom.SimplePanel;
import ui.task.TaskSection;
import ui.task.TaskSectionCellEditor;
import ui.task.TaskTableModel;
import ui.task.TaskTableModelListener;
import ui.task.components.TaskPriority;
import ui.task.components.TaskStatus;
import ui.views.ProjectsPage;
import utils.IconUtils;
import utils.TableUtils;

public final class ProjectUI extends SimplePanel{

    private static final ProjectUI instance = new ProjectUI();
    public static ProjectUI getInstance() {
        return instance;
    }
    
    private Project project;
    private JButton[] filterButtons;
    private TaskSection[] sections;

    private ProjectUI() {
        initComponents();
        initFilterEvents();
        
        setupTables();
    
        scrollPane.putClientProperty("FlatLaf.style", "border: null;");
        scrollPane.getVerticalScrollBar().setUnitIncrement(12);

        IconUtils.setButtonIcon(btnClose, "close_icon");
        
        btnClose.addActionListener((e) -> {
            
            PageManager.getInstance().showPage(ProjectsPage.getInstance());
        });
        StyleUtils.applyDefaultStyles(btnClose, StyleUtils.BUTTON_LOGO);
    }



    public void updateInformation(Project project) {
        SwingUtilities.invokeLater(() -> {
            setProject(project);
            setTitle(project.getTitle());
            setDescription(project.getDescription());
            setStatus(project.getStatus());
            setDueDate(project.getDueDate().toString());
            setTask(project.getTasks());
        });
    }
  
     public void setupTables() {
    
        sections = new TaskSection[] {
            todoSection,
            readySection,
            inProgressSection,
            toReviewSection,
            doneSection
        };


        for(TaskSection section : sections) {
            JTable table = section.getTable();
            String[] columnNames = section.getColumnNames(table);
            table.setModel(new TaskTableModel(columnNames,project));
        }


        TaskTableModelListener listener = new TaskTableModelListener(sections);
        
        for(TaskSection section : sections) {
            
            JTable table = section.getTable();
            
            table.getModel().addTableModelListener(listener);

            table.getColumnModel().getColumn(0).setCellEditor(new TaskSectionCellEditor());
            table.getColumnModel().getColumn(1).setCellEditor(new TaskSectionCellEditor());
            table.getColumnModel().getColumn(2).setCellRenderer(new TaskStatus());
            table.getColumnModel().getColumn(3).setCellRenderer(new TaskPriority());

            int[] columnWidths = {300, 550, 140, 110};
            TableColumnModel columnModel = table.getColumnModel();
            for (int i = 0; i < columnWidths.length; i++) {
                columnModel.getColumn(i).setPreferredWidth(columnWidths[i]);
            }
        }

     }

  
    
    
    
    public final void initFilterEvents() {
        
        filterButtons = new JButton[] { filterToDo, filterReady, filterInProgress, filterToReview, filterDone };
        
        ProjectUI.FilterEvents filterEvents = new ProjectUI.FilterEvents();
        
        for (JButton button : filterButtons) {
            
            StyleUtils.applyDefaultStyles(button, StyleUtils.BUTTON_OUTLINED);           
            button.addActionListener(filterEvents);            
            button.setSelected(true);
        }
    }
    
    public String getProjectId() {
        return project.getProjectID();
    }
    
    public void setProject(Project project) {
        this.project = project;
    }
    
    public void setTitle(String title) {
        lblTitle.setText(title);
    }
    
    public void setDescription(String text) {
        txtDescription.setText(text);
    }

    public void setStatus(String text) {
        status.setText(text);
    }

    public void setDueDate(String text) {
        dueDate.setText(text);
    }
    
    public void setTask(List<Task> tasks) {
        SwingUtilities.invokeLater(() -> TableUtils.addTaskToSections(tasks, sections));
    }
    
    public int getDoneCount() {
        return doneSection.getDoneCount();
    }    
    
    private class FilterEvents implements ActionListener{
             
        @Override
        public void actionPerformed(ActionEvent e) {            
           JButton button = (JButton) e.getSource();
            switch (button.getName()) {
                case "filterToDo" -> closeOrOpen(button, todoSection);
                case "filterReady" -> closeOrOpen(button, readySection);
                case "filterInProgress" -> closeOrOpen(button, inProgressSection);
                case "filterToReview" -> closeOrOpen(button, toReviewSection);
                case "filterDone" -> closeOrOpen(button, doneSection);
            }
        }
  
        public void closeOrOpen(JButton button, TaskSection section) {
            if (button.isSelected()) {
                StyleUtils.appendStyle(button, "borderColor: #d3d3d3;");
                section.setVisible(false);
                sectionContainer.remove(section);
            } else {
                StyleUtils.appendStyle(button, "borderColor: #2F2B43;");
                section.setVisible(true);
                sectionContainer.add(section);
            }

            button.setSelected(section.isVisible());
            sectionContainer.repaint();
            sectionContainer.revalidate();
         }    
    }
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //
    //
    //  NETBEANS AUTO-GENERATED CODE
    //        
    ///////////////////////////////////////////////////////////
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new ui.custom.SimplePanel();
        lblTitle = new javax.swing.JLabel();
        status = new ui.project.ProjectStatus();
        dueDate = new ui.project.ProjectDueDate();
        headerR = new ui.custom.SimplePanel();
        txtDescription = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        content = new ui.custom.SimplePanel();
        taskHeader = new ui.custom.SimplePanel();
        filterToDo = new javax.swing.JButton();
        filterReady = new javax.swing.JButton();
        filterInProgress = new javax.swing.JButton();
        filterToReview = new javax.swing.JButton();
        filterDone = new javax.swing.JButton();
        searchbar = new ui.task.components.TaskSearch();
        scrollPane = new javax.swing.JScrollPane();
        sectionContainer = new ui.custom.SimplePanel();
        todoSection = new ui.task.TaskSection();
        readySection = new ui.task.TaskSection();
        inProgressSection = new ui.task.TaskSection();
        toReviewSection = new ui.task.TaskSection();
        doneSection = new ui.task.TaskSection();

        setBackground(new java.awt.Color(255, 255, 255));
        setColumnConstraints("[]0[]");
        setComponentConstraint(new String[] {"split 2", "gapx 0, wrap"});
        setLayoutConstraints("insets 0");
        setMaximumSize(new java.awt.Dimension(1230, 650));
        setMinimumSize(new java.awt.Dimension(1230, 650));
        setOpacity(1.0F);
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1230, 650));
        setRowConstraints("[]0[]");

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(211, 211, 211)));
        header.setColumnConstraints("");
        header.setComponentConstraint(new String[] {"pushx, wrap", "split 2"});
        header.setLayoutConstraints("fill, insets 15 30, wrap 2");
        header.setMaximumSize(new java.awt.Dimension(310, 90));
        header.setMinimumSize(new java.awt.Dimension(310, 90));
        header.setOpacity(1.0F);
        header.setOpaque(false);
        header.setPreferredSize(new java.awt.Dimension(310, 90));
        header.setRowConstraints("[]10[]");

        lblTitle.setFont(new java.awt.Font("Inter", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(38, 38, 38));
        lblTitle.setText("<project title>");
        header.add(lblTitle);

        status.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        status.setOpaque(false);
        header.add(status);

        dueDate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dueDate.setOpaque(false);
        header.add(dueDate);

        add(header);

        headerR.setBackground(new java.awt.Color(255, 255, 255));
        headerR.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(211, 211, 211)));
        headerR.setComponentConstraint(new String[] {"grow, pushx"});
        headerR.setLayoutConstraints("insets 15 20 15 30");
        headerR.setMaximumSize(new java.awt.Dimension(920, 90));
        headerR.setMinimumSize(new java.awt.Dimension(920, 90));
        headerR.setPreferredSize(new java.awt.Dimension(920, 90));

        txtDescription.setFont(new java.awt.Font("Inter Medium", 0, 10)); // NOI18N
        txtDescription.setForeground(new java.awt.Color(157, 157, 157));
        txtDescription.setText("<description>");
        txtDescription.setMaximumSize(new java.awt.Dimension(200, 30));
        txtDescription.setMinimumSize(new java.awt.Dimension(200, 30));
        txtDescription.setPreferredSize(new java.awt.Dimension(200, 30));
        headerR.add(txtDescription);

        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.setFocusPainted(false);
        btnClose.setFocusable(false);
        btnClose.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnClose.setMaximumSize(new java.awt.Dimension(18, 18));
        btnClose.setMinimumSize(new java.awt.Dimension(18, 18));
        btnClose.setPreferredSize(new java.awt.Dimension(18, 18));
        btnClose.setRequestFocusEnabled(false);
        headerR.add(btnClose);

        add(headerR);

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setColumnConstraints("");
        content.setComponentConstraint(new String[] {"wrap", "split 2"});
        content.setLayoutConstraints("insets 0, center, fillx");
        content.setOpacity(1.0F);
        content.setOpaque(false);
        content.setRowConstraints("[]0[]");

        taskHeader.setBackground(new java.awt.Color(255, 255, 255));
        taskHeader.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(211, 211, 211)));
        taskHeader.setColumnConstraints("[]10[]");
        taskHeader.setLayoutConstraints("insets 10 36 10 30");
        taskHeader.setMaximumSize(new java.awt.Dimension(1230, 50));
        taskHeader.setMinimumSize(new java.awt.Dimension(1230, 50));
        taskHeader.setPreferredSize(new java.awt.Dimension(1230, 50));

        filterToDo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        filterToDo.setFocusPainted(false);
        filterToDo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        filterToDo.setMaximumSize(new java.awt.Dimension(25, 25));
        filterToDo.setMinimumSize(new java.awt.Dimension(25, 25));
        filterToDo.setName("filterToDo"); // NOI18N
        taskHeader.add(filterToDo);

        filterReady.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        filterReady.setFocusPainted(false);
        filterReady.setMargin(new java.awt.Insets(0, 0, 0, 0));
        filterReady.setMaximumSize(new java.awt.Dimension(25, 25));
        filterReady.setMinimumSize(new java.awt.Dimension(25, 25));
        filterReady.setName("filterReady"); // NOI18N
        taskHeader.add(filterReady);

        filterInProgress.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        filterInProgress.setFocusPainted(false);
        filterInProgress.setMargin(new java.awt.Insets(0, 0, 0, 0));
        filterInProgress.setMaximumSize(new java.awt.Dimension(25, 25));
        filterInProgress.setMinimumSize(new java.awt.Dimension(25, 25));
        filterInProgress.setName("filterInProgress"); // NOI18N
        taskHeader.add(filterInProgress);

        filterToReview.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        filterToReview.setFocusPainted(false);
        filterToReview.setInheritsPopupMenu(true);
        filterToReview.setMargin(new java.awt.Insets(0, 0, 0, 0));
        filterToReview.setMaximumSize(new java.awt.Dimension(25, 25));
        filterToReview.setMinimumSize(new java.awt.Dimension(25, 25));
        filterToReview.setName("filterToReview"); // NOI18N
        taskHeader.add(filterToReview);

        filterDone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        filterDone.setFocusPainted(false);
        filterDone.setMargin(new java.awt.Insets(0, 0, 0, 0));
        filterDone.setMaximumSize(new java.awt.Dimension(25, 25));
        filterDone.setMinimumSize(new java.awt.Dimension(25, 25));
        filterDone.setName("filterDone"); // NOI18N
        taskHeader.add(filterDone);
        taskHeader.add(searchbar);

        content.add(taskHeader);

        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setMinimumSize(null);
        scrollPane.setPreferredSize(new java.awt.Dimension(1230, 510));
        scrollPane.setVerifyInputWhenFocusTarget(false);
        scrollPane.setViewportView(sectionContainer);

        sectionContainer.setBackground(new java.awt.Color(255, 255, 255));
        sectionContainer.setColumnConstraints("[center]");
        sectionContainer.setComponentConstraint(new String[] {});
        sectionContainer.setLayoutConstraints("insets 0 15, fillx, wrap");
        sectionContainer.setOpacity(1.0F);
        sectionContainer.setRowConstraints("[]35[]35[]35[]35[]");

        todoSection.setRequestFocusEnabled(false);
        todoSection.setStatusColor("To Do");
        todoSection.setText("TO DO");
        sectionContainer.add(todoSection);
        todoSection.getAccessibleContext().setAccessibleParent(scrollPane);

        readySection.setRequestFocusEnabled(false);
        readySection.setStatusColor("Ready");
        readySection.setText("READY");
        sectionContainer.add(readySection);

        inProgressSection.setRequestFocusEnabled(false);
        inProgressSection.setStatusColor("In Progress");
        sectionContainer.add(inProgressSection);

        toReviewSection.setRequestFocusEnabled(false);
        toReviewSection.setStatusColor("To Review");
        toReviewSection.setText("TO REVIEW");
        sectionContainer.add(toReviewSection);

        doneSection.setRequestFocusEnabled(false);
        doneSection.setStatusColor("Done");
        doneSection.setText("DONE");
        sectionContainer.add(doneSection);

        scrollPane.setViewportView(sectionContainer);

        content.add(scrollPane);

        add(content);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private ui.custom.SimplePanel content;
    private ui.task.TaskSection doneSection;
    private ui.project.ProjectDueDate dueDate;
    private javax.swing.JButton filterDone;
    private javax.swing.JButton filterInProgress;
    private javax.swing.JButton filterReady;
    private javax.swing.JButton filterToDo;
    private javax.swing.JButton filterToReview;
    private ui.custom.SimplePanel header;
    private ui.custom.SimplePanel headerR;
    private ui.task.TaskSection inProgressSection;
    private javax.swing.JLabel lblTitle;
    private ui.task.TaskSection readySection;
    private javax.swing.JScrollPane scrollPane;
    private ui.task.components.TaskSearch searchbar;
    private ui.custom.SimplePanel sectionContainer;
    private ui.project.ProjectStatus status;
    private ui.custom.SimplePanel taskHeader;
    private ui.task.TaskSection toReviewSection;
    private ui.task.TaskSection todoSection;
    private javax.swing.JLabel txtDescription;
    // End of variables declaration//GEN-END:variables

}
