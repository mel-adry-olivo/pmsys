package ui.task;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import ui.custom.SimplePanel;
import main.utils.StyleUtils;
import project.ProjectController;
import task.Task;
import task.TaskController;
import task.TaskUpdate;
import task.TaskUpdateObserver;
import ui.task.components.TaskDeletePopupMenu;
import ui.task.components.TaskPriorityPopupMenu;
import ui.task.components.TaskStatusPopupMenu;

public class TaskSection extends SimplePanel{

    
    
    public TaskSection() {
        initComponents();
        customizeTable();
        setupListeners();
        setupKeyBindings();
        dispatchScrollEvent(scrollPane);

        inputbox.setVisible(false);
        StyleUtils.applyDefaultStyles(inputbox, StyleUtils.TEXTFIELD_FORM);
        inputbox.putClientProperty("JTextField.placeholderText", "Enter task name here");
    }

    private void customizeTable() {

        int[] columnWidths = { 250, 600, 140, 110 };
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < columnWidths.length; i++) {
            columnModel.getColumn(i).setPreferredWidth(columnWidths[i]);
        }

        table.getTableHeader().setFont(new Font("Inter", Font.BOLD, 11));
        TableCellRenderer headerRenderer = table.getTableHeader().getDefaultRenderer();
        ((DefaultTableCellRenderer) headerRenderer).setHorizontalAlignment(SwingConstants.LEFT);
        table.getTableHeader().setDefaultRenderer(headerRenderer);

        StyleUtils.applyDefaultStyles(btnAddTask, StyleUtils.BUTTON_TASK_ADD).include("hoverBackground: #f2f2f2;");
    }

    private void setupListeners() {
        
        btnAddTask.addActionListener(new TaskSection.AddTaskEvent());
        
        table.addMouseListener(new TaskDeletePopupMenu(this));
        table.addMouseListener(new TaskStatusPopupMenu(table));
        table.addMouseListener(new TaskPriorityPopupMenu(table));
        

    }

    private void dispatchScrollEvent(JScrollPane scrollPane) {
        scrollPane.addMouseWheelListener((MouseWheelEvent e) -> {
            ((JScrollPane) scrollPane.getParent()
                    .getParent() // task section
                    .getParent() // viewport
                    .getParent()) // parent scroll panel
                    .dispatchEvent(e);
        });
    }


    private void setupKeyBindings() {
        
        // TABLE ENTER TO GO TO NEXT
        table.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "editNextCell");

        table.getActionMap().put("editNextCell", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getEditingRow();
                int column = (table.getEditingColumn() + 1 >= table.getColumnCount()) ? 0
                        : table.getEditingColumn() + 1;
                table.editCellAt(row, column);
            }
        });

        // ENTER KEYBIND
        inputbox.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "editNextCell");

        inputbox.getActionMap().put("editNextCell", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddTask(inputbox);
                hideInputBox();
            }
        });

        
        // ESCAPE KEYBIND
        inputbox.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "escapeKey");

        inputbox.getActionMap().put("escapeKey", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideInputBox();
            }
        });
    }
    
    private void handleAddTask(JTextField field) {

        String input = field.getText();
    
        if (input.isEmpty()) {
            
            JOptionPane.showMessageDialog(table, "Task name should not be empty", "ERROR", JOptionPane.ERROR_MESSAGE);
            
        } else {
            Task newTask = new Task.Create()
                                .withProjectId(ProjectController.getInstance().getCurrentProjectID())
                                .withName(input)
                                .withDescription("")
                                .withStatus(getSectionName())
                                .withPriority("LOW")
                                .build();
          
        
            TaskController.getInstance().addTask(newTask);
        
            DefaultTableModel defaultModel = ((DefaultTableModel)table.getModel());
            
            SwingUtilities.invokeLater(() -> {
                defaultModel.addRow(Task.toTable(newTask, this));
                updateTableSize(table,scrollPane);
            });
         }
        
    }

    public void updateTableSize(JTable table, JScrollPane scrollPane) {
        
        int totalHeight = table.getRowHeight() * table.getRowCount() + table.getTableHeader().getHeight();
        
        scrollPane.setPreferredSize(new Dimension(scrollPane.getWidth(), totalHeight));
        revalidate();
        repaint();

    }
    

    // called in keybind setup
    private void hideInputBox() {       
        inputbox.setText("");
        remove(inputbox);
        
        add(btnAddTask, "gaptop 10");
        btnAddTask.setVisible(true);
        
        revalidate();
        repaint();    
    }

   
    
    // add task listener
    private class AddTaskEvent extends FocusAdapter implements ActionListener{
        
        // show input box if clicked
        @Override
        public void actionPerformed(ActionEvent e) {   
            TaskCellEditorListener listener = new TaskCellEditorListener(getSection());
            table.getCellEditor(table.getRowCount() - 1,
            0).addCellEditorListener(listener);

            remove(btnAddTask);
            add(inputbox, "gaptop 10");
            
            inputbox.setVisible(true);
            inputbox.requestFocusInWindow();
            
            getSection().revalidate();
            getSection().repaint();
        }
        
        // hide if lost focus
        @Override
        public void focusLost(FocusEvent e) {
            hideInputBox();
        }
    }
    
    public void showButton(boolean b) {
        btnAddTask.setVisible(b);
    }

    public void showInput(boolean b) {
        inputbox.setVisible(b);
    }

    public JButton getAddButton() {
        return btnAddTask;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JTable getTable() {
        return table;
    }
    
    public int getDoneCount() {
        return table.getRowCount();
    }

    public String[] getColumnNames(JTable table) {

        String[] columnNames = new String[table.getColumnCount()];
        for (int i = 0; i < table.getColumnCount(); i++) {
            columnNames[i] = table.getColumnName(i);
        }
        return columnNames;
    }

    public String getSectionName() {
        return statusTitle.getText();
    }

    public void setText(String text) {
        statusTitle.setText(text);
    }

    public TableModel getModel() {
        return table.getModel();
    }

    public void setStatusColor(String text) {
        statusTitle.setStatusColor(text);
    }

    public TaskSection getSection() {
        return this;
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputbox = new javax.swing.JTextField();
        header = new ui.custom.SimplePanel();
        statusTitle = new ui.task.components.TaskStatus();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnAddTask = new javax.swing.JButton();

        inputbox.setMargin(new java.awt.Insets(2, 20, 2, 6));
        inputbox.setMinimumSize(new java.awt.Dimension(1140, 35));
        inputbox.setPreferredSize(new java.awt.Dimension(1140, 35));

        setBackground(new java.awt.Color(255, 255, 255));
        setArc(20);
        setColumnConstraints("[center]");
        setComponentConstraint(new String[] {"wrap", "growx", "gapbottom 10"});
        setFlatClientProperty("arc: 20;");
        setLayoutConstraints("insets 0, wrap, fillx");
        setMinimumSize(new java.awt.Dimension(1150, 160));
        setName(""); // NOI18N
        setOpacity(1.0F);
        setOpaque(false);
        setRowConstraints("[]0[]10[]");

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(211, 211, 211)));
        header.setArc(0);
        header.setComponentConstraint(new String[] {"gapbottom 10"});
        header.setEnabled(false);
        header.setFlatClientProperty("");
        header.setLayoutConstraints("insets 5 0 ");
        header.setMinimumSize(new java.awt.Dimension(1150, 35));
        header.setOpaque(false);
        header.setPreferredSize(new java.awt.Dimension(1150, 35));

        statusTitle.setArc(0);
        statusTitle.setFlatClientProperty("arc: 0");
        statusTitle.setWidth(1150);
        header.add(statusTitle);

        add(header);

        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setEnabled(false);
        scrollPane.setHorizontalScrollBar(null);
        scrollPane.setPreferredSize(new java.awt.Dimension(452, 35));
        scrollPane.setRequestFocusEnabled(false);
        scrollPane.setViewportView(null);
        scrollPane.setWheelScrollingEnabled(false);

        table.setBackground(new java.awt.Color(255, 255, 255));
        table.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        table.setForeground(new java.awt.Color(38, 38, 38));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TASK TITLE", "SUMMARY", "STATUS", "PRIORITY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setColumnSelectionAllowed(true);
        table.setFillsViewportHeight(true);
        table.setRowSelectionAllowed(false);
        table.setSelectionBackground(new java.awt.Color(255, 255, 255));
        table.setSelectionForeground(new java.awt.Color(38, 38, 38));
        table.setShowGrid(true);
        table.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
        }

        add(scrollPane);

        btnAddTask.setFont(new java.awt.Font("Inter Medium", 0, 11)); // NOI18N
        btnAddTask.setText("     + New");
        btnAddTask.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(211, 211, 211)));
        btnAddTask.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAddTask.setMargin(new java.awt.Insets(2, 25, 3, 14));
        btnAddTask.setMinimumSize(new java.awt.Dimension(1140, 35));
        btnAddTask.setPreferredSize(new java.awt.Dimension(1140, 35));
        add(btnAddTask);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTask;
    private ui.custom.SimplePanel header;
    private javax.swing.JTextField inputbox;
    private javax.swing.JScrollPane scrollPane;
    private ui.task.components.TaskStatus statusTitle;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables


}
