package project;

import data.DataRepository;
import java.util.List;
import page.PageManager;
import task.TaskController;
import task.TaskUpdateObserver;
import ui.project.ProjectCard;
import ui.project.ProjectUI;
import ui.views.ProjectsPage;
import utils.PopupUtils;

public class ProjectController implements TaskUpdateObserver{
    
    private static final ProjectController instance = new ProjectController();
    public static ProjectController getInstance() {
        return instance;
    }
    
    private final ProjectUI projectUI = ProjectUI.getInstance();
    
    private ProjectController() { 
        TaskController.getInstance().addTaskUpdateObserver(ProjectController.this);
    }
    
    public void addOrUpdateProject(Project project, String saveOrUpdate) {   
              
        switch(saveOrUpdate) {
            case "save" -> {            
                DataRepository.getInstance().saveProject(project); 
                ProjectsPage.getInstance().updateProjectCount();
            }
            case "update" -> DataRepository.getInstance().updateProject(project);
        }

        ProjectCard projectCard = ProjectCard.createCard(project);
        
        ProjectsPage.getInstance().addCard(projectCard);
        
        PopupUtils.getInstance().hidePopup(); 
        
        PageManager.getInstance().showPage(ProjectsPage.getInstance());
                  
    }
    
    public void deleteProject(Project project, ProjectCard card) {
        
        String id = project.getProjectID();
        
        DataRepository.getInstance().deleteProject(id);

        ProjectsPage.getInstance().removeCard(card);
        ProjectsPage.getInstance().updateProjectCount();
    
        
    }
  
    public void showProjectUI(Project project) {
            projectUI.updateInformation(project); 
            PageManager.getInstance().showPage(projectUI);

    }
  
    public void loadProjects() {
     
        ProjectsPage.getInstance().removeAllCard();
        
        List<Project> projectData = DataRepository.getInstance().getAllData(); 
        
        for(Project project : projectData) { 
            
            ProjectCard projectCard = ProjectCard.createCard(project);

            ProjectsPage.getInstance().addCard(projectCard);
            ProjectsPage.getInstance().updateProjectCount();
    
        }   
    }
    
    public String getCurrentProjectID() {
        return projectUI.getProjectId();
    }   

    @Override
    public void onTaskUpdated() {
        loadProjects();
    }
}
