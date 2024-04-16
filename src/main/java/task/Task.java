package task;

import java.util.UUID;
import ui.task.TaskSection;

public class Task {
    private String projectId;
    private String id;
    private String name;
    private String description;
    private String status;
    private String priority;

    // for creation
    public Task(String projectId, String name, String description, String status, String priority) {
        this.projectId = projectId;
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return projectId + "|||" 
                + id + "|||" 
                + name + "|||"
                + description + "|||" 
                + status + "|||" 
                + priority;
    }
    
    public static Object[] toTable(Task task, TaskSection section) {
        return new Object[]{ task.getName(), task.getDescription(), section.getSectionName(), task.getPriority() };
    }
    
    public static class Create {
        
        private String projectId;
        private String id;
        private String name;
        private String description = ""; 
        private String status = "TO DO";  
        private String priority = "LOW";  

        public Create withProjectId(String projectId) {
            this.projectId = projectId;
            return this;
        }
        
        public Create withId(String id) {
            this.id = id;
            return this;
        }

        public Create withName(String name) {
            this.name = name;
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

        public Create withPriority(String priority) {
            this.priority = priority;
            return this;
        }

        public Task build() {
            Task task = new Task(projectId, name, description, status, priority);
            
            if (id != null) {
                task.setId(id);
            }
            
            return task;
        }
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
    
    
}
