package FrontEnd.DepartmentContentUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepartmentContentPanel extends javax.swing.JPanel implements ActionListener {

    DepartmentManagementContentPanel departmentManagementContentPanel;
    AddEmployeeToDepartmentContentPanel employeeDepartmentContentPanel;

    public DepartmentContentPanel() {
        initComponents();

        departmentManagementContentPanel = new DepartmentManagementContentPanel();
        employeeDepartmentContentPanel = new AddEmployeeToDepartmentContentPanel();

        departmentContainer.setLayout(new GridLayout(1, 1));

        showDepartmentManagementContentPanel();

        departmentButton.addActionListener(this);
        employeeButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == departmentButton) {
            showDepartmentManagementContentPanel();
        } else if (e.getSource() == employeeButton) {
            showEmployeeDepartmentContentPanel();
        }
    }

    private void clearAppContentPanel() {
        departmentContainer.removeAll();
        validate();
        repaint();
    }

    private void showDepartmentManagementContentPanel() {
        clearAppContentPanel();
        departmentContainer.add(departmentManagementContentPanel);
        validate();
        repaint();
    }

    private void showEmployeeDepartmentContentPanel() {
        clearAppContentPanel();
        departmentContainer.add(employeeDepartmentContentPanel);
        validate();
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        departmentButton = new javax.swing.JButton();
        employeeButton = new javax.swing.JButton();
        departmentContainer = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        departmentButton.setBackground(new java.awt.Color(45, 64, 80));
        departmentButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        departmentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/assignment.png"))); // NOI18N
        departmentButton.setText("Quản Lý Phòng Ban");
        departmentButton.setIconTextGap(10);
        departmentButton.setName("departmentButton"); // NOI18N

        employeeButton.setBackground(new java.awt.Color(45, 64, 80));
        employeeButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        employeeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/project.png"))); // NOI18N
        employeeButton.setText("Quản Lý Nhân Viên");
        employeeButton.setIconTextGap(10);
        employeeButton.setName("employeeButton"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(departmentButton)
                                .addGap(77, 77, 77)
                                .addComponent(employeeButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(departmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(employeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(23, Short.MAX_VALUE)));

        departmentContainer.setBackground(new java.awt.Color(255, 255, 255));
        departmentContainer.setName("departmentContainer"); // NOI18N
        departmentContainer.setPreferredSize(new java.awt.Dimension(1055, 640));

        javax.swing.GroupLayout departmentContainerLayout = new javax.swing.GroupLayout(departmentContainer);
        departmentContainer.setLayout(departmentContainerLayout);
        departmentContainerLayout.setHorizontalGroup(
                departmentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1055, Short.MAX_VALUE));
        departmentContainerLayout.setVerticalGroup(
                departmentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 640, Short.MAX_VALUE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(departmentContainer, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(departmentContainer, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton departmentButton;
    private javax.swing.JPanel departmentContainer;
    private javax.swing.JButton employeeButton;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
