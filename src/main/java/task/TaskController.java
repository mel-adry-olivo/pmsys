package task;

import data.DataRepository;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableModel;

public class TaskController implements TaskUpdate {
    
    private final List<TaskUpdateObserver> observers = new ArrayList<>(); 

    private static final TaskController instance = new TaskController();
    public static TaskController getInstance() {
        return instance;
    }
    
    private TaskController() { }
    
    public void addTask(Task task) {
        
        DataRepository.getInstance().addTask(task);
        
        notifyTaskUpdated();
    }
    
    public void updateTask(TableModelEvent e, int row) {

        if (row != TableModelEvent.HEADER_ROW) {
  
            TableModel model = (TableModel) e.getSource();
            
            String name = (String) model.getValueAt(row, 0);
            Task task = DataRepository.getInstance().getTaskByName(name);

            if(task != null) {

                task.setName((String) model.getValueAt(row, 0));
                task.setDescription((String) model.getValueAt(row, 1));
                task.setStatus((String) model.getValueAt(row, 2));
                task.setPriority((String) model.getValueAt(row, 3));

                DataRepository.getInstance().updateTask(task);
            }
        }
        
        notifyTaskUpdated();
    }
    
    public void deleteTaskByName(String name) {
        DataRepository.getInstance().deleteTask(name);
        notifyTaskUpdated();
    }
    
     @Override
    public void addTaskUpdateObserver(TaskUpdateObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeTaskUpdateObserver(TaskUpdateObserver observer) {
        observers.remove(observer);
    }
    
    private void notifyTaskUpdated() {
        for (TaskUpdateObserver observer : observers) {
            observer.onTaskUpdated();
        }
    }
}
