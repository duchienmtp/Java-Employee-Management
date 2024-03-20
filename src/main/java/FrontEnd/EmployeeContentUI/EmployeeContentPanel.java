package FrontEnd.EmployeeContentUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableCellRenderer;

public class EmployeeContentPanel extends javax.swing.JPanel implements ActionListener {

    DegreeContentPanel degreeContentPanel;
    PositionContentPanel positionContentPanel;
    SpecialtyContentPanel specialtyContentPanel;
    EmployeeManagementContentPanel employeeManagementContentPanel;

    public EmployeeContentPanel() {
        initComponents();
//        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//        centerRenderer.setHorizontalAlignment(JLabel.LEFT);
//        employeeTable.setDefaultRenderer(String.class, centerRenderer);
//
//        DefaultTableCellRenderer integerRenderer = new DefaultTableCellRenderer();
//        integerRenderer.setHorizontalAlignment(JLabel.LEFT);
//        employeeTable.setDefaultRenderer(Integer.class, integerRenderer);
        degreeContentPanel = new DegreeContentPanel();
        positionContentPanel = new PositionContentPanel();
        specialtyContentPanel = new SpecialtyContentPanel();
        employeeManagementContentPanel = new EmployeeManagementContentPanel();

        employeeContainer.setLayout(new GridLayout(1, 1));

        showEmployeeManagementContentPanel();

        degreeButton.addActionListener(this);
        positionButton.addActionListener(this);
        specialtyButton.addActionListener(this);
        employeeTypeButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == degreeButton) {
            showDegreeContentPanel();
        } else if (e.getSource() == positionButton) {
            showPositionContentPanel();
        } else if (e.getSource() == specialtyButton) {
            showSpecialtyContentPanel();
        } else {
            showEmployeeManagementContentPanel();
        }
    }

    private void clearAppContentPanel() {
        employeeContainer.removeAll();
        validate();
        repaint();
    }

    private void showDegreeContentPanel() {
        clearAppContentPanel();
        employeeContainer.add(degreeContentPanel);
        validate();
        repaint();
    }

    private void showPositionContentPanel() {
        clearAppContentPanel();
        employeeContainer.add(positionContentPanel);
        validate();
        repaint();
    }

    private void showSpecialtyContentPanel() {
        clearAppContentPanel();
        employeeContainer.add(specialtyContentPanel);
        validate();
        repaint();
    }

    private void showEmployeeManagementContentPanel() {
        clearAppContentPanel();
        employeeContainer.add(employeeManagementContentPanel);
        validate();
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        appSubMenu = new javax.swing.JPanel();
        specialtyButton = new javax.swing.JButton();
        degreeButton = new javax.swing.JButton();
        employeeTypeButton = new javax.swing.JButton();
        positionButton = new javax.swing.JButton();
        employeeContainer = new javax.swing.JPanel();

        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setName("employeeContentPanel"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1000, 740));

        appSubMenu.setBackground(new java.awt.Color(204, 204, 204));
        appSubMenu.setAlignmentX(0.0F);
        appSubMenu.setAlignmentY(0.0F);
        appSubMenu.setName("appSubMenu"); // NOI18N

        specialtyButton.setBackground(new java.awt.Color(45, 64, 80));
        specialtyButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        specialtyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/specialty.png"))); // NOI18N
        specialtyButton.setText("Chuyên Môn");
        specialtyButton.setIconTextGap(10);
        specialtyButton.setName("specialtyButton"); // NOI18N

        degreeButton.setBackground(new java.awt.Color(45, 64, 80));
        degreeButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        degreeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/degree.png"))); // NOI18N
        degreeButton.setText("Bằng Cấp");
        degreeButton.setIconTextGap(10);
        degreeButton.setName("degreeButton"); // NOI18N

        employeeTypeButton.setBackground(new java.awt.Color(45, 64, 80));
        employeeTypeButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        employeeTypeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/employee.png"))); // NOI18N
        employeeTypeButton.setText("Loại NViên");
        employeeTypeButton.setIconTextGap(10);
        employeeTypeButton.setName("employeeTypeButton"); // NOI18N

        positionButton.setBackground(new java.awt.Color(45, 64, 80));
        positionButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        positionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/position.png"))); // NOI18N
        positionButton.setText("Chức Vụ");
        positionButton.setIconTextGap(10);
        positionButton.setName("positionButton"); // NOI18N

        javax.swing.GroupLayout appSubMenuLayout = new javax.swing.GroupLayout(appSubMenu);
        appSubMenu.setLayout(appSubMenuLayout);
        appSubMenuLayout.setHorizontalGroup(
            appSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appSubMenuLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(employeeTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(positionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(specialtyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(degreeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        appSubMenuLayout.setVerticalGroup(
            appSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appSubMenuLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(appSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(specialtyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(degreeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(positionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        employeeContainer.setBackground(new java.awt.Color(255, 0, 255));
        employeeContainer.setAlignmentX(0.0F);
        employeeContainer.setAlignmentY(0.0F);
        employeeContainer.setName("employeeContainer"); // NOI18N
        employeeContainer.setPreferredSize(new java.awt.Dimension(1000, 640));

        javax.swing.GroupLayout employeeContainerLayout = new javax.swing.GroupLayout(employeeContainer);
        employeeContainer.setLayout(employeeContainerLayout);
        employeeContainerLayout.setHorizontalGroup(
            employeeContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        employeeContainerLayout.setVerticalGroup(
            employeeContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(appSubMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(employeeContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(appSubMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(employeeContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel appSubMenu;
    private javax.swing.JButton degreeButton;
    private javax.swing.JPanel employeeContainer;
    private javax.swing.JButton employeeTypeButton;
    private javax.swing.JButton positionButton;
    private javax.swing.JButton specialtyButton;
    // End of variables declaration//GEN-END:variables

}
