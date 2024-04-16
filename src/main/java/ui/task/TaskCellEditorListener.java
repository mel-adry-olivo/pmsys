package ui.task;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

public class TaskCellEditorListener implements CellEditorListener{

    private TaskSection section;
    private boolean editingNewRow;    

    public TaskCellEditorListener(TaskSection section) {
        this.section = section;
        editingNewRow = true;
    }
    
    @Override
    public void editingStopped(ChangeEvent e) {
        
        JTable table = section.getTable();
        
        if (editingNewRow && table.getValueAt(table.getRowCount() - 1, 0).equals("")) {
           
            JOptionPane.showMessageDialog(table, "Task name should not be empty", "ERROR", JOptionPane.ERROR_MESSAGE);
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.removeRow(table.getRowCount() - 1);
            section.updateTableSize(table, section.getScrollPane());
           
        }
        editingNewRow = false; 
    }

    @Override
    public void editingCanceled(ChangeEvent e) {

    }
}