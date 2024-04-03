package FrontEnd.ProjectContentUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssignmentContentPanel extends javax.swing.JPanel implements ActionListener {

    AssignmentManagementContentPanel bussinessTravelContentPanel;
    ProjectManagementContentPanel projectContentPanel;

    public AssignmentContentPanel() {
        initComponents();

        bussinessTravelContentPanel = new AssignmentManagementContentPanel();
        projectContentPanel = new ProjectManagementContentPanel();

        bussinessTravelContainer.setLayout(new GridLayout(1, 1));

        showAssignmentContentPanel();

        assignmentButton.addActionListener(this);
        projectButton.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == assignmentButton) {
            showAssignmentContentPanel();
        } else if (e.getSource() == projectButton) {
            showProjectContentPanel();
        }
    }

    private void clearAppContentPanel() {
        bussinessTravelContainer.removeAll();
        validate();
        repaint();
    }

    private void showAssignmentContentPanel() {
        clearAppContentPanel();
        bussinessTravelContainer.add(bussinessTravelContentPanel);
        validate();
        repaint();
    }

    private void showProjectContentPanel() {
        clearAppContentPanel();
        bussinessTravelContainer.add(projectContentPanel);
        validate();
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        assignmentButton = new javax.swing.JButton();
        projectButton = new javax.swing.JButton();
        bussinessTravelContainer = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setName("travelContentPanel"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1000, 740));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        assignmentButton.setBackground(new java.awt.Color(45, 64, 80));
        assignmentButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        assignmentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/assignment.png"))); // NOI18N
        assignmentButton.setText("Thêm Công Tác");
        assignmentButton.setIconTextGap(10);
        assignmentButton.setName("assignmentButton"); // NOI18N

        projectButton.setBackground(new java.awt.Color(45, 64, 80));
        projectButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        projectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/project.png"))); // NOI18N
        projectButton.setText("Thêm Dự Án");
        projectButton.setIconTextGap(10);
        projectButton.setName("projectButton"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(assignmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(projectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(412, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(projectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        bussinessTravelContainer.setName("bussinessTravelContainer"); // NOI18N
        bussinessTravelContainer.setPreferredSize(new java.awt.Dimension(1055, 640));

        javax.swing.GroupLayout bussinessTravelContainerLayout = new javax.swing.GroupLayout(bussinessTravelContainer);
        bussinessTravelContainer.setLayout(bussinessTravelContainerLayout);
        bussinessTravelContainerLayout.setHorizontalGroup(
            bussinessTravelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        bussinessTravelContainerLayout.setVerticalGroup(
            bussinessTravelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bussinessTravelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bussinessTravelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignmentButton;
    private javax.swing.JPanel bussinessTravelContainer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton projectButton;
    // End of variables declaration//GEN-END:variables

}
