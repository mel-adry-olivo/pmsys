package ui.task;

import java.awt.EventQueue;
import java.util.HashMap;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import page.PageManager;
import task.TaskController;
import ui.project.ProjectUI;

public class TaskTableModelListener implements TableModelListener{
    
    
    private final HashMap<String, TableModel> statusToTable = new HashMap<>();
    private TaskSection[] sections;

   
    public TaskTableModelListener(TaskSection[] sections) {
        this.sections = sections;
        
        for(TaskSection section : sections) {
            statusToTable.put(section.getSectionName().toUpperCase(), section.getTable().getModel());
        }
    }

    

    @Override
    public void tableChanged(TableModelEvent e) {
        
        int row = e.getFirstRow();
               
            // updated the other columns
        if (e.getType() == TableModelEvent.UPDATE) {
            TaskController.getInstance().updateTask(e, row);
           
        }  
        
            // updated the status (will change section)
        if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 2) {
            EventQueue.invokeLater(() -> handleStatusChange(e, row));
            
        }
        
        
            // the done section 
        if ((TableModel) e.getSource() == sections[4].getTable().getModel()) {
            int rowCount = sections[4].getTable().getModel().getRowCount();
        }
           
    }
    
    
    private void handleStatusChange(TableModelEvent e, int row) {
        
        TableModel model = (TableModel) e.getSource();
        String newStatus = (String) model.getValueAt(row, 2);

        TableModel destinationModel = statusToTable.get(newStatus.toUpperCase());  

        if (destinationModel != null) { 
            
            
            moveRow(model, destinationModel, row);    
             
            for (TaskSection section : sections) {

                section.updateTableSize(section.getTable(), section.getScrollPane());

            }

        }
    }
    
    
    private void moveRow(TableModel sourceTable, TableModel targetTable, int row) {
        
        Object[] rowData = new Object[sourceTable.getColumnCount()];

     
        for (int col = 0; col < rowData.length; col++) {
            rowData[col] = sourceTable.getValueAt(row, col);
        }
        
        if (targetTable instanceof DefaultTableModel dtm) {
            dtm.addRow(rowData);
        }

        if (sourceTable instanceof DefaultTableModel dtm) {
            dtm.removeRow(row);
        }
        
    }
    
   
}
