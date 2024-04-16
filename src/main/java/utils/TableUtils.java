package utils;

import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import task.Task;
import ui.task.TaskSection;

public class TableUtils {

    public static void addTaskToSections(List<Task> tasks, TaskSection[] sections) {
        
        clearSections(sections);
            
            for(Task task : tasks) {   
                
                switch(task.getStatus()) {
                    case "TO DO" -> addTableRow(sections[0].getTable(), task);
                    case "READY" -> addTableRow(sections[1].getTable(), task);
                    case "IN PROGRESS" -> addTableRow(sections[2].getTable(), task);
                    case "TO REVIEW" -> addTableRow(sections[3].getTable(), task);
                    case "DONE" -> addTableRow(sections[4].getTable(), task);
                }
            }
            
        updateTableUI(sections);    
     
    }
    
    private static void addTableRow(JTable table, Task task) {
        SwingUtilities.invokeLater(() -> {
            ((DefaultTableModel) table.getModel()).addRow(new Object[] {
            task.getName().trim(),
            task.getDescription().trim(),
            task.getStatus(),
            task.getPriority()});
         });
        
        
    }
    
    public static void updateTableUI(TaskSection[] sections) {
        for(TaskSection section : sections) {
            SwingUtilities.invokeLater(() -> {
                section.updateTableSize(section.getTable(), section.getScrollPane());
                section.repaint();
                section.revalidate();
            });
        }
    }
    
     private static void clearSections(TaskSection[] sections) {
        for(TaskSection section : sections) {
            SwingUtilities.invokeLater(() -> {
                ((DefaultTableModel) section.getTable().getModel()).setRowCount(0);
                section.updateTableSize(section.getTable(), section.getScrollPane());
            }); 
        }
    }
     
}
