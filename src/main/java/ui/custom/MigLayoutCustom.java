package ui.custom;

import java.awt.Component;
import net.miginfocom.swing.MigLayout;

public class MigLayoutCustom extends MigLayout{

    private String[] componentConstraints;
    
    public void setComponentConstraints(String[] constraints){
        componentConstraints = constraints;
    }

    @Override
    public void addLayoutComponent(Component comp, Object constraints) {
        
        int index = comp.getParent().getComponentZOrder(comp);
        Object constraint = constraints;
        
        if (componentConstraints != null && index < componentConstraints.length) {
            
            constraint = componentConstraints[index];
        }
        try {
            
            super.addLayoutComponent(comp, constraint);
        } catch (Exception e) {
            System.out.println("error hahaha");
        }
    }
}
