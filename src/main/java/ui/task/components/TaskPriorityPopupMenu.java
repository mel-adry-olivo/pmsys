

package ui.task.components;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class TaskPriorityPopupMenu extends MouseAdapter{

    private final JTable table;
    private final JPopupMenu priorityPopupMenu;
    private final JMenuItem[] priorityItems;
    
    public TaskPriorityPopupMenu(JTable table) {
        
        this.table = table;
        
        priorityPopupMenu = new JPopupMenu();
  
        priorityItems = new JMenuItem[] {
            new JMenuItem("LOW"),
            new JMenuItem("MEDIUM"),
            new JMenuItem("HIGH"),
        };
        
        for(JMenuItem item : priorityItems) {
            priorityPopupMenu.add(item);
            item.addActionListener((e) -> {
                          
                int row = table.getSelectedRow();
                int column = table.getSelectedColumn();

                if (row >= 0 && row < table.getRowCount()) {
                    ((DefaultTableModel) table.getModel()).setValueAt(item.getText(), row, column);

                }  
            });
        }
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

        if (row >= 0 && column == 3) {
            table.setRowSelectionInterval(row, row);
            table.setColumnSelectionInterval(column, column);

            priorityPopupMenu.show(e.getComponent(), e.getX(), e.getY());
        }
    }
}
