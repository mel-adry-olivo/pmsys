package project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import task.Task;

public class Project {

    private String projectID;
    private String title;
    private String description;
    private String status;
    private LocalDate dueDate;
    private List<Task> tasks;

    public Project(String title, String description, String dueDate) {
        this.projectID = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.status = "ACTIVE";
        this.dueDate = LocalDate.parse(dueDate, DateTimeFormatter.ofPattern("d MMM yyyy"));
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
    
    public void removeTask(Task task) {
        tasks.remove(task);
    }
    
    @Override
    public String toString() {
        return projectID + "|||" 
                + title + "|||" 
                + description + "|||" 
                + status + "|||" 
                + dueDate.format(DateTimeFormatter.ofPattern("d MMM yyyy"));
    }
    
    public static class Create {
        private String projectID;
        private String title;
        private String description;
        private String status;
        private LocalDate dueDate;
        private List<Task> tasks;

        public Create() {
            this.tasks = new ArrayList<>();
        }

        public Create withProjectID(String projectID) {
            this.projectID = projectID;
            return this;
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

        public Create withDueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Create withDueDate(String dueDate) {
            this.dueDate = LocalDate.parse(dueDate, DateTimeFormatter.ofPattern("d MMM yyyy"));
            return this;
        }

        public Create withTasks(List<Task> tasks) {
            this.tasks = tasks;
            return this;
        }

        public Project build() {
            Project project = new Project(title, description, dueDate != null ? dueDate.format(DateTimeFormatter.ofPattern("d MMM yyyy")) : null);

            if (projectID != null) {
                project.setProjectID(projectID); 
            }
            if (status != null) {
                project.setStatus(status);
            }
            if (tasks != null) {
                project.setTasks(tasks);
            }

            return project;
        }
    }
    
    // Getters & Setters   
    public String getProjectID() {
        return projectID;
    }
    
    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    public LocalDate getDueDate() {
        return dueDate;
    }
    
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public List<Task> getTasks() {
        return tasks;
    }
    
    public int getDoneTasks() {
        int done = 0;
        for(Task task : tasks) {
            if(task.getStatus().equals("DONE")) {
                done++;
            }
        }
        return done;
    }
    
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    
 
}
