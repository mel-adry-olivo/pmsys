package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import project.Project;
import task.Task;
import utils.FileUtils;


public class DataRepository {
    
    private static DataRepository instance;
    public static DataRepository getInstance() {
        if(instance == null) {
            instance = new DataRepository();
        }
        return instance;
    }

    private List<Project> projectList;
    private List<Task> taskList;
    private Map<String, Task> taskByName;
    
    private DataRepository() {
        
        projectList = new ArrayList<>();
        taskList = new ArrayList<>();
        taskByName = new HashMap<>();
    }
    
    public void saveProject(Project project) {
       
        projectList.add(project);
        
        String formattedProject = project.toString();
        FileUtils.getInstance().saveProjectData(formattedProject);   
    }
    
    public void updateProject(Project project) {
        
        String formattedProject = project.toString();
        FileUtils.getInstance().updateProjectData(project.getProjectID(), formattedProject);
    }
            
    public void deleteProject(String projectID) {
        FileUtils.getInstance().deleteProjectData(projectID);
    }
    
    /////////////
    
    public void addTask(Task task) {
          
        taskList.add(task);
        taskByName.put(task.getName(), task);
        
        String formattedTask = task.toString();
        FileUtils.getInstance().saveTaskData(formattedTask);
    }
    
    public void updateTask(Task task) {
        
        String formattedTask = task.toString();
        FileUtils.getInstance().updateTaskData(task.getId(), formattedTask);
    }
    
    public void deleteTask(String name) {
        
        Task task = taskByName.get(name);
        
        
        if (task != null) {
               
            taskList.remove(task);
            taskByName.remove(name);
            
            Project project = getProjectById(task.getProjectId());
            project.removeTask(task);
            
            FileUtils.getInstance().deleteTaskData(task.getId());
        }
    }
    
    public Task getTaskByName(String name) {
        return taskByName.get(name);
    }
    
    public Project getProjectById(String id) {
        for(Project project : projectList) {
            if(project.getProjectID().equals(id)) {
                return project;
            }
        }
        return null;
    }
    
    // basically combines project data & task data
    public List<Project> getAllData() {

        List<Project> projectData = getAllProjectData();
        List<Task> taskData = getAllTaskData();

        for(Project project : projectData) {   

          for(Task task : taskData) {     

            if(project.getProjectID().equals(task.getProjectId())) {       
              project.addTask(task);         
              taskList.add(task);
              taskByName.put(task.getName(), task);
            }  
          }
          
          projectList.add(project);
        }
       
        return projectData;
      }
    
    // helper methods of getAllData()
    private List<Project> getAllProjectData() {

        List<Project> projectData = new ArrayList<>();
        List<String> projectFormattedData = FileUtils.getInstance().readAllProjectData();

        for(String line : projectFormattedData) {

          String[] fields = line.split("\\|\\|\\|");

          Project project = new Project.Create()
                      .withProjectID(fields[0])
                      .withTitle(fields[1])
                      .withDescription(fields[2])
                      .withStatus(fields[3])
                      .withDueDate(fields[4])
                      .build();

          projectData.add(project);
        }

        return projectData;
    }
    private List<Task> getAllTaskData() {

        List<Task> taskData = new ArrayList<>();
        List<String> taskFormattedData = FileUtils.getInstance().readAllTaskData();


        for(String line : taskFormattedData) {

          String[] fields = line.split("\\|\\|\\|");
          Task task = new Task.Create()
                    .withProjectId(fields[0])
                    .withId(fields[1])
                    .withName(fields[2])
                    .withDescription(fields[3])
                    .withStatus(fields[4])
                    .withPriority(fields[5])
                    .build();

          taskData.add(task);
        }

        return taskData;
    }
}
