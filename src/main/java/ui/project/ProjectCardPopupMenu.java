package ui.project;

import java.awt.Dimension;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import project.Project;
import project.ProjectController;
import utils.PopupUtils;

public class ProjectCardPopupMenu extends JPopupMenu{
    
    private JMenuItem editItem;
    private JMenuItem deleteItem;
    private final Project project;
    private final ProjectCard card;
    
    private ProjectCardPopupMenu(Project project, ProjectCard card)  {
        this.project = project;
        this.card = card;
        init();
    }   
    
    public static ProjectCardPopupMenu create(Project project, ProjectCard card) {
        return new ProjectCardPopupMenu(project, card);
    }
    
    private void init() {
        
        editItem = new JMenuItem("Edit");
        deleteItem = new JMenuItem("Delete");
        
        setPreferredSize(new Dimension(100,60));
             
        add(editItem);
        add(deleteItem);
        
        editItem.addActionListener((e) -> {
                ProjectEditForm form = new ProjectEditForm(project, card);
                PopupUtils.getInstance().showPopup(form);

        });
        
        deleteItem.addActionListener((e) -> {
            if(showConfirmDeleteDialog() == JOptionPane.YES_OPTION) {
                ProjectController.getInstance().deleteProject(project, card);
            }
        });
        
    }
    
    private int showConfirmDeleteDialog() {   
        int option = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this item?", "Confirm Deletion",
                JOptionPane.YES_NO_OPTION);
        return option;
    }
    
}
