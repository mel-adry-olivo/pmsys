

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatInspector;
import com.formdev.flatlaf.fonts.inter.FlatInterFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.UIManager;
import page.PageManager;
import project.ProjectController;
import utils.PopupUtils;

public class Application extends JFrame {

        public Application() {
                initComponents();
                initApplication();
                setVisible(true);
          
        }

        private void initApplication() {
            
            PageManager.getInstance().install(content);
            PopupUtils.getInstance().install(this);
            
            ProjectController.getInstance().loadProjects();
            
            

            addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                            requestFocusInWindow(true);
                    }
            });

        }
        
        public Component getContentPanel() {
            return contentLayer;
        }

        public static void main(String args[]){

                FlatInspector.install("ctrl shift alt X");
                FlatInterFont.install();
                
                FlatLaf.registerCustomDefaultsSource("themes");
                FlatMacLightLaf.setup();
                
                UIManager.put("defaultFont", new Font(FlatInterFont.FAMILY, Font.PLAIN, 12));

                EventQueue.invokeLater(() -> new Application());

        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layeredPane = new javax.swing.JLayeredPane();
        sidebar = new ui.sidebar.Sidebar();
        topbar = new ui.topbar.Topbar();
        contentLayer = new javax.swing.JLayeredPane();
        content = new ui.custom.SimplePanel();
        start1 = new Start();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setName("frame"); // NOI18N
        setResizable(false);

        contentLayer.setBackground(new java.awt.Color(204, 204, 204));
        contentLayer.setMinimumSize(new java.awt.Dimension(1230, 650));

        content.setBackground(new java.awt.Color(249, 248, 251));
        content.setLayoutConstraints("insets 0");

        contentLayer.setLayer(content, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout contentLayerLayout = new javax.swing.GroupLayout(contentLayer);
        contentLayer.setLayout(contentLayerLayout);
        contentLayerLayout.setHorizontalGroup(
            contentLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, 1230, Short.MAX_VALUE)
        );
        contentLayerLayout.setVerticalGroup(
            contentLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );

        layeredPane.setLayer(sidebar, javax.swing.JLayeredPane.MODAL_LAYER);
        layeredPane.setLayer(topbar, javax.swing.JLayeredPane.MODAL_LAYER);
        layeredPane.setLayer(contentLayer, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPane.setLayer(start1, javax.swing.JLayeredPane.DRAG_LAYER);

        javax.swing.GroupLayout layeredPaneLayout = new javax.swing.GroupLayout(layeredPane);
        layeredPane.setLayout(layeredPaneLayout);
        layeredPaneLayout.setHorizontalGroup(
            layeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layeredPaneLayout.createSequentialGroup()
                .addComponent(sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(topbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contentLayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(start1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE))
        );
        layeredPaneLayout.setVerticalGroup(
            layeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layeredPaneLayout.createSequentialGroup()
                .addComponent(topbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(contentLayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(start1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(layeredPane)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ui.custom.SimplePanel content;
    private javax.swing.JLayeredPane contentLayer;
    private javax.swing.JLayeredPane layeredPane;
    private ui.sidebar.Sidebar sidebar;
    private Start start1;
    private ui.topbar.Topbar topbar;
    // End of variables declaration//GEN-END:variables

}
