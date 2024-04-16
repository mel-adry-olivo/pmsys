package page;

import com.formdev.flatlaf.FlatLaf;
import javax.swing.SwingUtilities;
import ui.custom.SimplePanel;
import ui.views.dashboard.DashboardPage;

public class PageManager {
    
    private static PageManager instance = new PageManager(); 
    public static PageManager getInstance() {
        return instance;
    }

    public void updateUI() {
        container.repaint();
        container.revalidate();
        FlatLaf.updateUI();
    }
    
    private SimplePanel container;
 
    public void install(SimplePanel container) {      
        this.container = container;
        showPage(new DashboardPage());       
    }

    public void showPage(SimplePanel panel) {
        
        SwingUtilities.invokeLater(() -> {
            container.removeAll();
            container.add(panel, "grow");
            container.repaint();
            container.revalidate();
        });
    }
 
}
