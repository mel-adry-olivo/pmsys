package ui.task.components;

import java.awt.Insets;
import javax.swing.DefaultCellEditor;
import javax.swing.JTextField;
import main.utils.StyleUtils;

public class TaskSectionCellEditor extends DefaultCellEditor {
    
    public TaskSectionCellEditor() {
        super(new JTextField());
        JTextField textField = (JTextField) getComponent();
        textField.setMargin(new Insets(5, 10, 5, 10)); 
        textField.putClientProperty("JTextField.placeholderText", "Enter text here");
        StyleUtils.applyDefaultStyles(textField, StyleUtils.TEXTFIELD_FORM)
                .include("borderWidth: 2; borderColor: #2F2B43;");
        
    }
}