package ui.task;

import javax.swing.table.DefaultTableModel;
import project.Project;

public class TaskTableModel extends DefaultTableModel {
    
    private static final int STATUS_COLUMN_INDEX = 2;  
    public boolean ignoreExternalChanges = false;
    private Project project;

    public TaskTableModel(Object[] columnNames, Project project) {
        super(columnNames, 0);
        this.project = project;
    }

    
    
    @Override
    public void addRow(Object[] rowData) {
        super.addRow(rowData);
    }

    @Override
    public void removeRow(int row) {
        super.removeRow(row); 
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        super.setValueAt(aValue, row, column); 

        if (column == STATUS_COLUMN_INDEX && !ignoreExternalChanges) { 
            fireTableCellUpdated(row, column);
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column != 2 && column != 3;
    }
        
    
}
