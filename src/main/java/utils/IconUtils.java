package utils;

import java.net.URL;
import javax.swing.ImageIcon;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;

public class IconUtils {
       
    private static Map<String, ImageIcon> iconStorage = new HashMap<>();

    private static ImageIcon retrieveIcon(String name) {     
        ImageIcon icon = iconStorage.get(name);
        if (icon == null) {
            URL iconURL = IconUtils.class.getResource("/images/" + name + ".png");
            if (iconURL != null) {
                icon = new ImageIcon(iconURL);
                iconStorage.put(name, icon);
            } else {    
                System.err.println("Resource not found: " + name); 
            }
        }
        
        return icon;
    }
       
    public static ImageIcon getIcon(String name) {
        return retrieveIcon(name);
    }
    
    public static URL getIconURL(String name) {
        return IconUtils.class.getResource("/images/" + name + ".png");
    }
    
    public static ImageIcon getMenuIcon(boolean selected, String name) {
        return selected ? IconUtils.retrieveIcon(name + "_selected") : IconUtils.retrieveIcon(name + "_default");
    }
    
    public static void setButtonIcon(JButton component, String file) {
        component.setIcon(getIcon(file));
    }
}