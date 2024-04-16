package utils;

import java.awt.Component;
import java.awt.Point;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public final class PopupUtils {
    
    private JFrame parentFrame;
    private JDialog dialog;
    
    public static PopupUtils instance = new PopupUtils();
    public static PopupUtils getInstance() {
        return instance;
    }
    
    private PopupUtils() { }
    
    public void install(JFrame parentFrame) {
        this.parentFrame = parentFrame;    
             
    }
    
    public void showPopup(Component component) {
        SwingUtilities.invokeLater(() -> {
            dialog = new JDialog(parentFrame, "", true); 

            dialog.getContentPane().add(component);     

            dialog.pack();
            dialog.setLocation(getCenter(parentFrame, dialog));

            dialog.setVisible(true);
        });  
    }
    
    public void hidePopup(Component component) {
        SwingUtilities.invokeLater(() -> {
            dialog.remove(component);
            dialog.setVisible(false);
        });       
    }
    
    public void hidePopup() {
        SwingUtilities.invokeLater(() -> {
            dialog.removeAll();
            dialog.setVisible(false);
        });       
    }
  
    public Point getCenter(JFrame frame, JDialog dialog) {
        int dialogX = parentFrame.getX() + (parentFrame.getWidth() - dialog.getWidth()) / 2;
        int dialogY = parentFrame.getY() + (parentFrame.getHeight() - dialog.getHeight()) / 2;
        return new Point(dialogX, dialogY);
    }
}
