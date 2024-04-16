
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import ui.custom.SimplePanel;


public class Start extends SimplePanel implements MouseListener{

    public Start() {
        initComponents();  
        addMouseListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new JLabel();

        setBackground(new Color(249, 248, 251));

        jLabel1.setFont(new Font("Inter", 1, 36)); // NOI18N
        jLabel1.setForeground(new Color(38, 38, 38));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        ResourceBundle bundle = ResourceBundle.getBundle("Bundle"); // NOI18N
        jLabel1.setText(bundle.getString("Start.jLabel1.text")); // NOI18N
        jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 676, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(304, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(337, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        
        FlatAnimatedLafChange.showSnapshot();
        this.setVisible(false);
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
