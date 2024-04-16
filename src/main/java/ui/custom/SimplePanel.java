package ui.custom;

import com.formdev.flatlaf.ui.FlatUIUtils;
import com.formdev.flatlaf.util.UIScale;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class SimplePanel extends JPanel{

    private float opacity;
    private int arc;
    private String layoutConstraints;
    private String columnConstraints;
    private String rowConstraints;
    private String[] componentConstraint;
    private MigLayoutCustom layout;
    
    public SimplePanel() {
        layout = new MigLayoutCustom();
        setLayout(layout);
        opacity = 1.0f;
        arc = 0;
    }

    public void setLayoutConstraints(String layoutConstraints) {
        this.layoutConstraints = layoutConstraints;
        layout.setLayoutConstraints(this.layoutConstraints);
        revalidate();
    }

    public void setColumnConstraints(String columnConstraints) {
        this.columnConstraints = columnConstraints;
        layout.setColumnConstraints(this.columnConstraints);
        revalidate();
    }

    public void setRowConstraints(String rowConstraints) {
        this.rowConstraints = rowConstraints;
        layout.setRowConstraints(this.rowConstraints);
        revalidate();
    }

    public void setComponentConstraint(String[] componentConstraint) {
        this.componentConstraint = componentConstraint;
        layout.setComponentConstraints(this.componentConstraint);
        revalidate();
    }
    
    public void setFlatClientProperty(String flatLafStyle) {
        putClientProperty("FlatLaf.style", flatLafStyle);
        revalidate();
    }

    public void setOpacity(float opacity) {
        this.opacity = opacity;
        repaint();
    }

    public void setArc(int arc) {
        this.arc = arc;
        repaint();
    }

   
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        Graphics2D g2 = (Graphics2D) g.create();
        FlatUIUtils.setRenderingHints(g2);
        
        try {
            g2.setComposite(AlphaComposite.SrcOver.derive(opacity));
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, width, height, UIScale.scale(arc), UIScale.scale(arc));
            g2.setComposite(AlphaComposite.SrcOver.derive(opacity));
        } finally {
            g2.dispose();
        }
    }    
    
}
