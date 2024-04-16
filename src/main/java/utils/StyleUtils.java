package main.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class StyleUtils{

    public static final int BUTTON_LOGO = 0;
    public static final int BUTTON_OUTLINED = 1;
    public static final int BUTTON_FILLED = 2;
    public static final int BUTTON_ON_HOLD = 3;
    public static final int BUTTON_ACTIVE = 4;
    public static final int BUTTON_DONE = 5;
    public static final int BUTTON_DUE_DATE = 6;
    public static final int BUTTON_TASK_ADD = 7;
    
    public static final int TEXTFIELD_FORM = 0;
    
    
    private static final Map<Class<?>, List<String>> defaultStyles = new HashMap<>();
   
    private JComponent component;

    private StyleUtils(JComponent component) {
        this.component = component;
    }
           
    public static StyleUtils applyDefaultStyles(JComponent component, int typeIndex) {
     
        List<String> styles = defaultStyles.get(component.getClass());
        
        if (styles != null && typeIndex >= 0 && typeIndex < styles.size()) {
            apply(component, styles.get(typeIndex));
        }
        
        return new StyleUtils(component);
    }
    public StyleUtils include(String styleSnippet) {
        apply(component, styleSnippet);
        return this;
    } 
    public static void appendStyle(JComponent component, String property) {
        apply(component, property);
    }   
    public static void apply(JComponent component, String styleSnippet) {        
        String existingStyle = (String) component.getClientProperty("FlatLaf.style");
        component.putClientProperty("FlatLaf.style", existingStyle == null ? styleSnippet : existingStyle + styleSnippet);
    } 
    
    // add styles here
    static {
        
        List<String> buttonStyles = Arrays.asList(
                // LOGO BUTTON
                "borderWidth:0;"
                        + "focusWidth:0;"
                        + "innerFocusWidth:0;"
                        + "background:null;"
                        + "foreground:null;"
                        + "hoverBackground:null;"
                        + "selectedBackground:null;"
                        + "pressedBackground:null;"
                        + "arc:999;", 
                
                // OUTLINED BUTTON
                "borderWidth:2;"
                        + "borderColor:#2F2B43;"
                        + "hoverBorderColor:#2F2B43;"
                        + "hoverBackground:null;"
                        + "hoverForeground:#2F2B43;"
                        + "pressedBackground: null;"
                        + "pressedForeground:#2F2B43;"
                        + "selectedBackground: null;"
                        + "background:null;"
                        + "foreground: null;"
                        + "arc:30;", 
                
                // FILLED BUTTON
                "borderWidth:0;"
                        + "focusWidth:0;"
                        + "innerFocusWidth:0;"
                        + "background:#2F2B43;"
                        + "pressedBackground:null;"
                        + "hoverBackground: #444156;"
                        + "arc:30;",
                
                // ON HOLD BUTTON
                "borderWidth: 0;"
                        + "borderColor: null;"
                        + "hoverBorderColor: null;"
                        + "hoverBackground: null;"
                        + "pressedBackground: null;"
                        + "pressedForeground: null;"
                        + "background: #FFA34E;"
                        + "foreground: #FFFFFF;"
                        + "arc: 30;",
                
                // ACTIVE BUTTON
                "borderWidth: 0;"
                        + "borderColor: null;"
                        + "hoverBorderColor: null;"
                        + "hoverBackground: null;"
                        + "pressedBackground: null;"
                        + "pressedForeground: null;"
                        + "background: #4E6AFF;"
                        + "foreground: #FFFFFF;"
                        + "arc: 20;",
                
                // DONE BUTTON
                "borderWidth: 0;"
                        + "borderColor: null;"
                        + "hoverBorderColor: null;"
                        + "hoverBackground: null;"
                        + "pressedBackground: null;"
                        + "pressedForeground: null;"
                        + "background: #57CA70;"
                        + "foreground: #FFFFFF;"
                        + "arc: 20;",
                
                // DUE DATE BUTTON
                "borderWidth: 2;"
                        + "borderColor: #B75AFF;"
                        + "hoverBorderColor: null;"
                        + "hoverBackground: null;"
                        + "pressedBackground: null;"
                        + "pressedForeground: null;"
                        + "background: null;"
                        + "foreground: #B75AFF;"
                        + "arc: 20;",
                
                // TASK ADD BUTTON
                "hoverBackground: #d3d3d3;"
                        + "pressedBackground: null;"
                        + "pressedForeground: null;"
                        + "background: null;"
                        + "foreground: #262626;"

                );

        List<String> textFieldStyles = Arrays.asList(
                // FORM FIELD
                "focusWidth:1;"
                        + "background:null;"
                        + "focusedBorderColor:#2F2B43;"
                        + "focusColor: #2F2B43;"
                        + "focusedBackground:#2F2B43;"
                        + "arc:30;"
                );



        defaultStyles.put(JButton.class, buttonStyles);
        defaultStyles.put(JTextField.class, textFieldStyles);        
    }
}
