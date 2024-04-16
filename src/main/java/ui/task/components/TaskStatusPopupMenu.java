package ui.task.components;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import ui.task.TaskTableModel;

public class TaskStatusPopupMenu extends MouseAdapter{

    private final JTable table;
    private final JPopupMenu statusPopupMenu;
    private final JMenuItem[] statusItems;
    
    public TaskStatusPopupMenu(JTable table) {
        
        this.table = table;
        
        statusPopupMenu = new JPopupMenu();
  
        statusItems = new JMenuItem[] {
            new JMenuItem("TO DO"),
            new JMenuItem("READY"),
            new JMenuItem("IN PROGRESS"),
            new JMenuItem("TO REVIEW"),
            new JMenuItem("DONE")
        };
        
        for(JMenuItem item : statusItems) {
            statusPopupMenu.add(item);
            item.addActionListener((e) -> {     

                int row = table.getSelectedRow();
                int column = table.getSelectedColumn();      
                if (row >= 0 && row < table.getRowCount()) {
                    updateTableCell(table, row, column, item.getText());
                }
        
            });
        } 
    }
    
    private void updateTableCell(JTable table, int row, int column, String newStatus) {
        
        TaskTableModel model = (TaskTableModel) table.getModel();  
        
        model.ignoreExternalChanges = true;  
        
        model.setValueAt(newStatus, row, column);
        
        model.ignoreExternalChanges = false;   
    }
    

    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            showPopupMenu(e);
        }
    }



    private void showPopupMenu(MouseEvent e) {
        int row = table.rowAtPoint(e.getPoint());
        int column = table.columnAtPoint(e.getPoint());

        if (row >= 0 && column == 2) {
            table.setRowSelectionInterval(row, row);
            table.setColumnSelectionInterval(column, column);

            statusPopupMenu.show(e.getComponent(), e.getX(), e.getY());
        }
    }
}
