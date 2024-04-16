package ui.project;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import main.utils.StyleUtils;
import project.Project;
import project.ProjectController;
import utils.DateUtils;
import ui.custom.SimplePanel;
import ui.views.ProjectsPage;
import utils.PopupUtils;

public class ProjectEditForm extends SimplePanel{

    private Project project;
    private ProjectCard card;
    
    public ProjectEditForm(Project project, ProjectCard card) {
        this.project = project;
        this.card = card;
        
        initComponents();
        
        StyleUtils.applyDefaultStyles(btnEdit, StyleUtils.BUTTON_FILLED);
        StyleUtils.applyDefaultStyles(txtTitleField, StyleUtils.TEXTFIELD_FORM);
        StyleUtils.applyDefaultStyles(txtDescriptionField, StyleUtils.TEXTFIELD_FORM);
        StyleUtils.applyDefaultStyles(txtDueDateField, StyleUtils.TEXTFIELD_FORM);
        StyleUtils.applyDefaultStyles(txtStatusField, StyleUtils.TEXTFIELD_FORM);
        
        txtDueDateField.putClientProperty("JTextField.placeholderText", "dd MMM yyy (e.g., 20 Jan 2022)");
        txtStatusField.putClientProperty("JTextField.placeholderText", "ACTIVE, ON HOLD, DONE");
    }
 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        lblTitleField = new javax.swing.JLabel();
        txtTitleField = new javax.swing.JTextField();
        lblDescriptionField = new javax.swing.JLabel();
        lblOptional = new javax.swing.JLabel();
        txtDescriptionField = new javax.swing.JTextField();
        lblDueDateField = new javax.swing.JLabel();
        txtDueDateField = new javax.swing.JTextField();
        Status = new javax.swing.JLabel();
        txtStatusField = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setArc(40);
        setColumnConstraints("");
        setComponentConstraint(new String[] {"wrap", "wrap", "wrap, span 3 0", "split 2", "span 2, wrap", "wrap, span 3 0", "wrap", "wrap, span 3 0", "wrap", "wrap, span 3 0", "x 175", "align right"});
        setFlatClientProperty("");
        setFocusable(false);
        setLayoutConstraints("insets 20 30 20 30, fill");
        setMaximumSize(new java.awt.Dimension(370, 500));
        setMinimumSize(new java.awt.Dimension(370, 500));
        setName(""); // NOI18N
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(370, 500));
        setRowConstraints("[]5[]5[][]5[][]5[]5[]5[]15[]");

        lbTitle.setFont(new java.awt.Font("Inter", 1, 24)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(38, 38, 38));
        lbTitle.setText("Edit Project");
        lbTitle.setFocusable(false);
        lbTitle.setRequestFocusEnabled(false);
        lbTitle.setVerifyInputWhenFocusTarget(false);
        add(lbTitle);

        lblTitleField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTitleField.setForeground(new java.awt.Color(38, 38, 38));
        lblTitleField.setText("Title");
        lblTitleField.setFocusable(false);
        lblTitleField.setRequestFocusEnabled(false);
        lblTitleField.setVerifyInputWhenFocusTarget(false);
        add(lblTitleField);

        txtTitleField.setMargin(new java.awt.Insets(4, 10, 4, 6));
        txtTitleField.setMinimumSize(new java.awt.Dimension(310, 40));
        txtTitleField.setNextFocusableComponent(txtDescriptionField);
        txtTitleField.setPreferredSize(new java.awt.Dimension(280, 40));
        add(txtTitleField);

        lblDescriptionField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDescriptionField.setForeground(new java.awt.Color(38, 38, 38));
        lblDescriptionField.setText("Description");
        lblDescriptionField.setFocusable(false);
        lblDescriptionField.setRequestFocusEnabled(false);
        lblDescriptionField.setVerifyInputWhenFocusTarget(false);
        add(lblDescriptionField);

        lblOptional.setFont(new java.awt.Font("Inter Medium", 0, 10)); // NOI18N
        lblOptional.setForeground(new java.awt.Color(157, 157, 157));
        lblOptional.setText("(Optional)");
        lblOptional.setFocusable(false);
        lblOptional.setRequestFocusEnabled(false);
        lblOptional.setVerifyInputWhenFocusTarget(false);
        add(lblOptional);

        txtDescriptionField.setMargin(new java.awt.Insets(4, 10, 4, 6));
        txtDescriptionField.setMinimumSize(new java.awt.Dimension(310, 40));
        txtDescriptionField.setNextFocusableComponent(txtDueDateField);
        txtDescriptionField.setPreferredSize(new java.awt.Dimension(280, 40));
        add(txtDescriptionField);

        lblDueDateField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDueDateField.setForeground(new java.awt.Color(38, 38, 38));
        lblDueDateField.setText("Due Date");
        lblDueDateField.setFocusable(false);
        lblDueDateField.setRequestFocusEnabled(false);
        lblDueDateField.setVerifyInputWhenFocusTarget(false);
        add(lblDueDateField);

        txtDueDateField.setMargin(new java.awt.Insets(4, 10, 4, 6));
        txtDueDateField.setMinimumSize(new java.awt.Dimension(310, 40));
        txtDueDateField.setNextFocusableComponent(txtStatusField);
        txtDueDateField.setPreferredSize(new java.awt.Dimension(280, 40));
        add(txtDueDateField);

        Status.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Status.setForeground(new java.awt.Color(38, 38, 38));
        Status.setText("Status");
        Status.setFocusable(false);
        Status.setRequestFocusEnabled(false);
        Status.setVerifyInputWhenFocusTarget(false);
        add(Status);

        txtStatusField.setMargin(new java.awt.Insets(4, 10, 4, 6));
        txtStatusField.setMinimumSize(new java.awt.Dimension(310, 40));
        txtStatusField.setNextFocusableComponent(btnEdit);
        txtStatusField.setPreferredSize(new java.awt.Dimension(280, 40));
        add(txtStatusField);

        btnCancel.setBackground(new java.awt.Color(255, 255, 255));
        btnCancel.setFont(new java.awt.Font("Inter", 1, 11)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(38, 38, 38));
        btnCancel.setText("CANCEL");
        btnCancel.setBorderPainted(false);
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.setFocusPainted(false);
        btnCancel.setFocusable(false);
        btnCancel.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCancel.setMaximumSize(new java.awt.Dimension(75, 30));
        btnCancel.setMinimumSize(new java.awt.Dimension(75, 30));
        btnCancel.setPreferredSize(new java.awt.Dimension(75, 30));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        add(btnCancel);

        btnEdit.setBackground(new java.awt.Color(47, 43, 67));
        btnEdit.setFont(new java.awt.Font("Inter", 1, 11)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("EDIT");
        btnEdit.setBorderPainted(false);
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.setFocusPainted(false);
        btnEdit.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnEdit.setMaximumSize(new java.awt.Dimension(75, 30));
        btnEdit.setMinimumSize(new java.awt.Dimension(75, 30));
        btnEdit.setPreferredSize(new java.awt.Dimension(75, 30));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        add(btnEdit);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        SwingUtilities.invokeLater(() -> PopupUtils.getInstance().hidePopup(this));
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        
        String title = txtTitleField.getText();
        String description = txtDescriptionField.getText();
        String dueDate = txtDueDateField.getText();
        String status = txtStatusField.getText();
             
        if(!title.isEmpty()) {
            project.setTitle(title);
        }

        if(!description.isEmpty()) {
            project.setDescription(description);
        }

        if(!dueDate.isEmpty()) {
            if(!DateUtils.isValidDate(dueDate)) 
            JOptionPane.showMessageDialog(this, "Wrong date format", "", JOptionPane.WARNING_MESSAGE);
            else 
            project.setDueDate(DateUtils.stringToDate(dueDate));
        }

        if(!status.isEmpty()) {
            project.setStatus(status);
        }

        ProjectController.getInstance().addOrUpdateProject(project, "update");
        ProjectsPage.getInstance().removeCard(card);
        ProjectsPage.getInstance().revalidate();              
    }//GEN-LAST:event_btnEditActionPerformed


 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Status;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lblDescriptionField;
    private javax.swing.JLabel lblDueDateField;
    private javax.swing.JLabel lblOptional;
    private javax.swing.JLabel lblTitleField;
    private javax.swing.JTextField txtDescriptionField;
    private javax.swing.JTextField txtDueDateField;
    private javax.swing.JTextField txtStatusField;
    private javax.swing.JTextField txtTitleField;
    // End of variables declaration//GEN-END:variables

    
}
