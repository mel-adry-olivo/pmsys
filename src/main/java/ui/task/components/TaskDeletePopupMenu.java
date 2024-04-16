package ui.task.components;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import task.TaskController;
import ui.task.TaskSection;


public class TaskDeletePopupMenu extends MouseAdapter{

    private final TaskSection section;
    private final JPopupMenu deletePopupMenu;
    private final JMenuItem deleteItem;
    
    public TaskDeletePopupMenu(TaskSection section) {
        
        this.section = section;
        
        deletePopupMenu = new JPopupMenu();
        deletePopupMenu.setPreferredSize(new Dimension(100,40));
        
        deleteItem = new JMenuItem("Delete");
        
        deletePopupMenu.add(deleteItem);

        deleteItem.addActionListener((e) -> {
            int selectedRow = section.getTable().getSelectedRow();
            if(selectedRow != -1) {
                
                String name = (String)((DefaultTableModel)section.getTable().getModel()).getValueAt(selectedRow, 0);

                ((DefaultTableModel)section.getTable().getModel()).removeRow(selectedRow);

                section.updateTableSize(section.getTable(), section.getScrollPane());

                TaskController.getInstance().deleteTaskByName(name);
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e) || SwingUtilities.isLeftMouseButton(e)) {

            if (section.getTable().getCellEditor() != null 
                    && section.getTable().isEditing()) {
                section.getTable().getCellEditor().cancelCellEditing();
            }          
        }
  
    }

    
    
    @Override
    public void mousePressed(MouseEvent e) {

        if (SwingUtilities.isRightMouseButton(e)) {
            
            
            showPopupMenu(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {

            showPopupMenu(e);
        }
    }

    private void showPopupMenu(MouseEvent e) {
        int row = section.getTable().rowAtPoint(e.getPoint());
        int column = section.getTable().columnAtPoint(e.getPoint());

        if (row < section.getTable().getRowCount() && column < section.getTable().getColumnCount()) { 

            section.getTable().setRowSelectionInterval(row, row); 
           
            deletePopupMenu.show(e.getComponent(), e.getX(), e.getY());
        }
    }
}