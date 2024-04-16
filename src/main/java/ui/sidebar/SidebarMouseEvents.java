package ui.sidebar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import page.PageManager;
import ui.custom.SimplePanel;
import ui.views.ProjectsPage;
import ui.views.dashboard.DashboardPage;
import utils.IconUtils;

public class SidebarMouseEvents extends MouseAdapter{

    private final Map<SimplePanel, JButton> pageButtonMap;
    private JButton selectedButton;

    public SidebarMouseEvents(JButton[] buttons) {
        pageButtonMap = new HashMap<>();
        setupMappings(buttons);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        SwingUtilities.invokeLater(() -> selectButton(button));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        SwingUtilities.invokeLater(() -> handleHoverEvent(e.getSource(), true));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        SwingUtilities.invokeLater(() -> handleHoverEvent(e.getSource(), false));
    }

    
   
    
    private void handleHoverEvent(Object source, boolean mouseEntered) {
        JButton button = (JButton) source;
        button.setIcon(IconUtils.getMenuIcon(mouseEntered || button.isSelected(), button.getName()));
    }

    private void setupMappings(JButton[] buttons) {
        for (JButton button : buttons) {
            switch (button.getName()) {
                case "dashboard" -> pageButtonMap.put(new DashboardPage(), button);
                case "projects" -> pageButtonMap.put(ProjectsPage.getInstance(), button);
            }
        }
        selectedButton = buttons[0];
        selectedButton.setSelected(true);
    }

    private void selectButton(JButton button) {
        
        if (selectedButton == button) { 
            return;  
        }

        selectedButton.setSelected(false);
        selectedButton.setIcon(IconUtils.getMenuIcon(false, selectedButton.getName()));

        selectedButton = button; // make the clicked button the selected button
        
        selectedButton.setSelected(true);
        selectedButton.setIcon(IconUtils.getMenuIcon(true, selectedButton.getName()));

        PageManager.getInstance().showPage(getPageTypeForButton(button));
        
    }

    private SimplePanel getPageTypeForButton(JButton button) {
        for (Map.Entry<SimplePanel, JButton> entry : pageButtonMap.entrySet()) {
            if (entry.getValue() == button) {
                return entry.getKey();
            }
        }
        return null;
    }
}
