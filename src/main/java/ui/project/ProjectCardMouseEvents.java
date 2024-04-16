package ui.project;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import project.ProjectController;

public class ProjectCardMouseEvents extends MouseAdapter{

    private ProjectCard cardPanel;

    public ProjectCardMouseEvents(ProjectCard cardPanel) {
        this.cardPanel = cardPanel;      
    }
 
    @Override
    public void mouseClicked(MouseEvent e) {
       
        ProjectController.getInstance().showProjectUI(cardPanel.getProject());
        
        cardFocus(false);
    }  
    
    // hover styles     
    
    @Override
    public void mouseEntered(MouseEvent e) { cardFocus(true); }
    @Override
    public void mouseExited(MouseEvent e) { cardFocus(false); } 
    private void cardFocus(boolean focused) {
        SwingUtilities.invokeLater(() -> {
            String borderStyle = focused ? "#2F2B43,2,30;" : "#d3d3d3,1,30;";
            String style = "arc: 30; border: 1,0,1,1," + borderStyle;
            cardPanel.putClientProperty("FlatLaf.style", style);
        }); 
    }
}
