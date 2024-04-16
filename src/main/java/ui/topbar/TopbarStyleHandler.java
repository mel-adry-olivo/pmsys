package ui.topbar;

import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import ui.custom.SimplePanel;
import utils.IconUtils;


public class TopbarStyleHandler extends MouseAdapter implements FocusListener{

    private SimplePanel searchPanel;
    private JButton searchButton;

    public TopbarStyleHandler(SimplePanel searchPanel, JButton searchButton) {
        this.searchPanel = searchPanel;
        this.searchButton = searchButton;
    }

    
    
    @Override
    public void mouseEntered(MouseEvent e) {
        searchButton.setIcon(IconUtils.getMenuIcon(true, searchButton.getName()));
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        searchButton.setIcon(IconUtils.getMenuIcon(searchButton.isSelected(), searchButton.getName()));
    }

    @Override
    public void focusGained(FocusEvent e) {
        searchbarFocus(true);
    }

    @Override
    public void focusLost(FocusEvent e) {
        searchbarFocus(false);
    }
    
    private void searchbarFocus(boolean focused) {
        String borderStyle = focused ? "#2F2B43,2,50;" : "#d3d3d3,1,50;";
        String style = "arc: 50; border: 1,1,1,1," + borderStyle;

        FlatAnimatedLafChange.showSnapshot();
        searchPanel.putClientProperty("FlatLaf.style", style);
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
    }

}
