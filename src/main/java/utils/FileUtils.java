package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    private static FileUtils instance;

    private static final String DATA_FOLDER = "data";
    private static String PROJECT_FILE;
    private static String TASK_FILE;

    private FileUtils() {
        
        File dataDir = new File(FileUtils.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile();
        String absoluteDataPath = dataDir.getAbsolutePath() + File.separator + DATA_FOLDER;
        new File(absoluteDataPath).mkdirs();
        
        PROJECT_FILE = absoluteDataPath + File.separator + "projects.txt";
        TASK_FILE = absoluteDataPath + File.separator + "tasks.txt"; 

        initFiles();
    }

    public static FileUtils getInstance() {
        if (instance == null) {
            instance = new FileUtils();
        }
        return instance;
    }
    
    public void initFiles() {
        try {
            createFiles();
        } catch (IOException e) { }
    }

    //
    //  PROJECT RELATED
    //
    //////////////////////////////////////////////////////////////////////
    
    public void saveProjectData(String formattedProject) {
        saveData(formattedProject, PROJECT_FILE);
    }
    
    public List<String> readAllProjectData() {
        return readAllData(PROJECT_FILE);
    }
    
    public String getProjectByID(String id) {
        return getDataByID(PROJECT_FILE, id);
    }
    
    public void updateProjectData(String projectID, String formattedUpdatedProject) {
        updateData(PROJECT_FILE, projectID, formattedUpdatedProject);
    }
    
    public void deleteProjectData(String projectID) {
        deleteData(PROJECT_FILE, projectID);
    }

    
    //
    //  TASK RELATED
    //
    /////////////////////////////////////////////////////////////////
 
    public void saveTaskData(String formattedTask) {
        saveData(formattedTask, TASK_FILE);
    }
    
    public List<String> readAllTaskData() {
        return readAllData(TASK_FILE);
    }
    
    public String getTaskByID(String id) {
        return getDataByID(TASK_FILE, id);
    }
    
    public void updateTaskData(String taskId, String formattedUpdatedTask) {
        updateData(TASK_FILE, taskId, formattedUpdatedTask);
    }
    
    public void deleteTaskData(String taskId) {
        deleteData(TASK_FILE, taskId);
    }
    
    /////////////////////////////////////////////////////////////////
    
    
    private void saveData(String data, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            
            writer.write(data);
            writer.newLine();            
        } catch (IOException e) { e.printStackTrace(); }
        
    }
    
    private List<String> readAllData(String filePath) {
        
        List<String> lines = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            
            String line;
            
            while ((line = reader.readLine()) != null) {
                
                lines.add(line);
            }
            
        } catch (IOException e) { e.printStackTrace(); }
        
        return lines;
    }
        
    private String getDataByID(String filePath, String targetID) {
        List<String> data = readAllData(filePath); 
        
        for(String line : data) {
            
            String dataID; 
            String[] fields = line.split("\\|\\|\\|");
            
            if(filePath.equals(PROJECT_FILE)) {
                dataID = fields[0];
            } else {
                dataID = fields[1];
            }
            
            if(dataID.equals(targetID)) {
                return line;
            }
        }
        
        return null;
    }
    
    private void saveAllData(String filePath, List<String> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) { e.printStackTrace(); }
    }
    
    private void updateData(String filePath, String targetID, String updatedData) {
        
        List<String> data = readAllData(filePath);
        int i = 0;
        for (String line : data) {
            
            String dataID = "";           
            String[] fields = line.split("\\|\\|\\|");
            
            if(filePath.equals(PROJECT_FILE)) {
                dataID = fields[0];
            } else if (filePath.equals(TASK_FILE)){
                dataID = fields[1];
            }
            
            
            if(dataID.equals(targetID)) {
                
                data.set(i, updatedData);
                saveAllData(filePath, data);
                return;
            }
            
            i++;
        }
    }
    
    private void deleteData(String filePath, String targetID) {
        List<String> data = readAllData(filePath);
         
        int i = 0;
        for (String line : data) {
            
            String dataID = "";           
            String[] fields = line.split("\\|\\|\\|");
            
            if(filePath.equals(PROJECT_FILE)) {
                dataID = fields[0];
            } else if (filePath.equals(TASK_FILE)){
                dataID = fields[1];
            }
            
            if(dataID.equals(targetID)) {
                
                data.remove(i);
                saveAllData(filePath, data);
                return;
            }
            
            i++;
        }
    }
        
    
    public List<String> getTasksByProjectId(String projectId) {
        List<String> taskLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(TASK_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\\|\\|\\|");
                if (fields[0].equals(projectId)) {
                    taskLines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return taskLines;
    }
    
    /////////////////////////////////////////////////////////////////

    public void createFiles() throws IOException {

        File projectFile = new File(PROJECT_FILE);
        if (!projectFile.exists()) projectFile.createNewFile();

        File taskFile = new File(TASK_FILE);
        if (!taskFile.exists()) taskFile.createNewFile();
    }
}