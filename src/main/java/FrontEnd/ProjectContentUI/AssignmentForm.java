package FrontEnd.ProjectContentUI;

import BackEnd.AssignmentManagement.Assignment;
import BackEnd.AssignmentManagement.AssignmentBUS;
import BackEnd.EmployeeManagement.Employee;
import BackEnd.EmployeeManagement.EmployeeBUS;
import BackEnd.ProjectsManagement.ProjectBUS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class AssignmentForm extends javax.swing.JFrame implements ActionListener, WindowListener {

    public boolean btnconfirmClicked = false;
    ArrayList<Object> formData;
    EmployeeBUS emB = new EmployeeBUS();
    AssignmentBUS asmB = new AssignmentBUS();
    ProjectBUS pjB = new ProjectBUS();

    public AssignmentForm() {
        initComponents();

        formData = new ArrayList<>();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        DatePickerSettings pickerSettingsBegin = new DatePickerSettings();
        pickerSettingsBegin.setFormatForDatesCommonEra("dd/MM/yyyy");
        startDatePicker.setSettings(pickerSettingsBegin);
        startDatePicker.setDateToToday();

        DatePickerSettings pickerSettingsComplete = new DatePickerSettings();
        pickerSettingsComplete.setFormatForDatesCommonEra("dd/MM/yyyy");
        endDatePicker.setSettings(pickerSettingsComplete);
        endDatePicker.setDateToToday();

        confirmButton.addActionListener(this);
        cancelButton.addActionListener(this);
        for (int i = 0; i < emB.getEmployeeList().size(); i++) {
            employeeIDComboBox.addItem(emB.getEmployeeList().get(i).getId());
        }
        for (int i = 0; i < pjB.getProjectList().size(); i++) {
            projectIDComboBox.addItem(pjB.getProjectList().get(i).getProjectId());
        }
        addWindowListener(this);
    }

    public ArrayList<Object> getDataFromForm() {
        String employeeID = (String) employeeIDComboBox.getSelectedItem(),
                employeeName = employeeNameTextField.getText(),
                projectID = (String) projectIDComboBox.getSelectedItem(),
                projectName = employeeNameTextField.getText(),
                startDate = Employee.formatBirthDateToDatabaseType(startDatePicker.getText()),
                endDate = Employee.formatBirthDateToDatabaseType(endDatePicker.getText()),
                projectPlace = (String) projectPlaceComboBox.getSelectedItem();

        return new ArrayList<>(Arrays.asList(employeeID, employeeName, projectID, projectName, startDate, endDate,
                projectPlace));
    }

    public void showFormWithData(ArrayList<Object> data) {
        if (data != null) {
            employeeIDComboBox.setSelectedItem(data.get(1));
            employeeNameTextField.setText((String) data.get(2));
            projectIDComboBox.setSelectedItem(data.get(3));
            projectNameTextField.setText((String) data.get(4));
            startDatePicker.setText((String) data.get(6));
            endDatePicker.setText((String) data.get(7));
            projectPlaceComboBox.setSelectedItem(data.get(5));
        }
    }

    public void clearFormData() {
        employeeIDComboBox.setSelectedItem("");
        employeeNameTextField.setText("");
        projectIDComboBox.setSelectedItem("");
        projectNameTextField.setText("");
        startDatePicker.setText("");
        endDatePicker.setText("");
        projectPlaceComboBox.setSelectedItem("");
    }

    public static String getEmployeeIdFromAssignmentForm() {
        return employeeIDComboBox.getSelectedItem().toString();
    }

    public static String getProjectIdFromAssignmentForm() {
        return projectIDComboBox.getSelectedItem().toString();
    }

    public static JButton getConfirmButton() {
        return confirmButton;
    }

    public void handleSubmitForm() {
        formData = getDataFromForm();

        int confirmation = JOptionPane.showConfirmDialog(this,
                "Xác nhận thao tác ?",
                "CẬP NHẬT ?",
                JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            if (asmB.checkInList(employeeIDComboBox.getSelectedItem().toString(),
                    projectIDComboBox.getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(null, "Nhân viên này đã được đăng kí công tác này.");
            }
            DefaultTableModel model = (DefaultTableModel) AssignmentManagementContentPanel
                    .getAssignmentManagementContentTable().getModel();
            Object tmp = new Object[]{
                AssignmentManagementContentPanel.getAssignmentManagementContentTable().getRowCount() + 1,
                employeeIDComboBox.getSelectedItem(), employeeNameTextField.getText(),
                projectIDComboBox.getSelectedItem(), projectNameTextField.getText(),
                projectPlaceComboBox.getSelectedItem(), startDatePicker.getDate(), endDatePicker.getDate()};
            model.addColumn(tmp);
            AssignmentManagementContentPanel.getAssignmentManagementContentTable().setModel(model);
            Assignment newasm = new Assignment(employeeIDComboBox.getSelectedItem().toString(),
                    projectIDComboBox.getSelectedItem().toString(), false);
            asmB.addNewAssignment(newasm);
            clearFormData();
            dispose();
        }
    }

    public void cancelSubmitForm() {
        formData = getDataFromForm();

        int confirmation = JOptionPane.showConfirmDialog(this,
                "Xác nhận thao tác ?",
                "HỦY BỎ ?",
                JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            clearFormData();
            dispose();
        }
    }

    public boolean isFormFilled() {
        return !(employeeNameTextField.getText().equals("")
                || projectNameTextField.getText().equals("")
                || startDatePicker.getText().equals("")
                || endDatePicker.getText().equals("")
                || ((String) projectPlaceComboBox.getSelectedItem()).equals(""));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            if (isFormFilled()) {
                handleSubmitForm();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Hãy nhập thông tin trước!", "CẢNH BÁO",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == cancelButton) {
            if (isFormFilled()) {
                cancelSubmitForm();
            } else {
                clearFormData();
                dispose();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        employeeIDLabel = new javax.swing.JLabel();
        employeeNameTextField = new javax.swing.JTextField();
        projectIDLabel = new javax.swing.JLabel();
        projectIDComboBox = new javax.swing.JComboBox<>();
        projectNameLabel = new javax.swing.JLabel();
        employeeIDComboBox = new javax.swing.JComboBox<>();
        employeeNameLabel = new javax.swing.JLabel();
        projectNameTextField = new javax.swing.JTextField();
        startDatePickerLabel = new javax.swing.JLabel();
        endDatePicker = new com.github.lgooddatepicker.components.DatePicker();
        endDatePickerLabel = new javax.swing.JLabel();
        startDatePicker = new com.github.lgooddatepicker.components.DatePicker();
        projectPlaceLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        confirmButton = new javax.swing.JButton();
        projectPlaceComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("THÊM MỚI THÔNG TIN CÔNG TÁC CỦA NHÂN VIÊN");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 600));

        employeeIDLabel.setLabelFor(projectIDComboBox);
        employeeIDLabel.setText("Mã Nhân Viên :");
        employeeIDLabel.setBackground(new java.awt.Color(255, 255, 255));
        employeeIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        employeeIDLabel.setForeground(new java.awt.Color(0, 0, 0));
        employeeIDLabel.setName("employeeIDLabel"); // NOI18N
        employeeIDLabel.setOpaque(true);

        employeeNameTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        employeeNameTextField.setBackground(new java.awt.Color(204, 204, 204));
        employeeNameTextField.setEnabled(false);
        employeeNameTextField.setForeground(new java.awt.Color(0, 0, 0));
        employeeNameTextField.setName("employeeNameTextField"); // NOI18N
        employeeNameTextField.setOpaque(true);

        projectIDLabel.setLabelFor(employeeNameTextField);
        projectIDLabel.setText("Mã Dự Án :");
        projectIDLabel.setBackground(new java.awt.Color(255, 255, 255));
        projectIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        projectIDLabel.setForeground(new java.awt.Color(0, 0, 0));
        projectIDLabel.setName("projectIDLabel"); // NOI18N
        projectIDLabel.setOpaque(true);

        projectIDComboBox.setBackground(new java.awt.Color(204, 204, 204));
        projectIDComboBox.setEditable(true);
        projectIDComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        projectIDComboBox.setForeground(new java.awt.Color(0, 0, 0));
        projectIDComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        projectIDComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        projectIDComboBox.setName("projectIDComboBox"); // NOI18N
        projectIDComboBox.setOpaque(true);
        projectIDComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                projectIDComboBoxItemStateChanged(evt);
            }
        });
        projectIDComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                projectIDComboBoxMouseClicked(evt);
            }
        });

        projectNameLabel.setLabelFor(employeeNameTextField);
        projectNameLabel.setText("Tên Dự Án :");
        projectNameLabel.setBackground(new java.awt.Color(255, 255, 255));
        projectNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        projectNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        projectNameLabel.setName("projectNameLabel"); // NOI18N
        projectNameLabel.setOpaque(true);

        employeeIDComboBox.setBackground(new java.awt.Color(204, 204, 204));
        employeeIDComboBox.setEditable(true);
        employeeIDComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        employeeIDComboBox.setForeground(new java.awt.Color(0, 0, 0));
        employeeIDComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employeeIDComboBox.setName("employeeIDComboBox"); // NOI18N
        employeeIDComboBox.setOpaque(true);
        employeeIDComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                employeeIDComboBoxItemStateChanged(evt);
            }
        });
        employeeIDComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeIDComboBoxMouseClicked(evt);
            }
        });

        employeeNameLabel.setLabelFor(employeeNameTextField);
        employeeNameLabel.setText("Tên Nhân Viên :");
        employeeNameLabel.setBackground(new java.awt.Color(255, 255, 255));
        employeeNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        employeeNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        employeeNameLabel.setName("employeeNameLabel"); // NOI18N
        employeeNameLabel.setOpaque(true);

        projectNameTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        projectNameTextField.setBackground(new java.awt.Color(204, 204, 204));
        projectNameTextField.setEnabled(false);
        projectNameTextField.setForeground(new java.awt.Color(0, 0, 0));
        projectNameTextField.setName("projectNameTextField"); // NOI18N
        projectNameTextField.setOpaque(true);

        startDatePickerLabel.setLabelFor(startDatePicker);
        startDatePickerLabel.setText("Ngày Bắt Đầu :");
        startDatePickerLabel.setBackground(new java.awt.Color(255, 255, 255));
        startDatePickerLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        startDatePickerLabel.setForeground(new java.awt.Color(0, 0, 0));
        startDatePickerLabel.setOpaque(true);
        startDatePickerLabel.setToolTipText("startDatePickerLabel");

        endDatePicker.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        endDatePicker.setName("endDatePicker"); // NOI18N

        endDatePickerLabel.setLabelFor(endDatePicker);
        endDatePickerLabel.setText("Ngày Kết Thúc :");
        endDatePickerLabel.setBackground(new java.awt.Color(255, 255, 255));
        endDatePickerLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        endDatePickerLabel.setForeground(new java.awt.Color(0, 0, 0));
        endDatePickerLabel.setName("endDatePickerLabel"); // NOI18N
        endDatePickerLabel.setOpaque(true);

        startDatePicker.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        startDatePicker.setName("startDatePicker"); // NOI18N

        projectPlaceLabel.setText("Dự Án Tại :");
        projectPlaceLabel.setBackground(new java.awt.Color(255, 255, 255));
        projectPlaceLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        projectPlaceLabel.setForeground(new java.awt.Color(0, 0, 0));
        projectPlaceLabel.setName("projectPlaceLabel"); // NOI18N
        projectPlaceLabel.setOpaque(true);

        cancelButton.setText("Hủy Bỏ");
        cancelButton.setBackground(new java.awt.Color(108, 117, 125));
        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setOpaque(true);
        cancelButton.setToolTipText("cancelButton");

        confirmButton.setText("Xác Nhận");
        confirmButton.setBackground(new java.awt.Color(13, 110, 253));
        confirmButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        confirmButton.setForeground(new java.awt.Color(255, 255, 255));
        confirmButton.setName("confirmButton"); // NOI18N
        confirmButton.setOpaque(true);

        projectPlaceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TP HCM", "Hải Phòng", "Hà Nội", "Đà Nẵng", " " }));
        projectPlaceComboBox.setBackground(new java.awt.Color(204, 204, 204));
        projectPlaceComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        projectPlaceComboBox.setForeground(new java.awt.Color(0, 0, 0));
        projectPlaceComboBox.setName("projectPlaceComboBox"); // NOI18N
        projectPlaceComboBox.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startDatePickerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(projectNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(projectNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(endDatePickerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(endDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(employeeIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(employeeNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                            .addComponent(projectIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(projectIDComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(employeeNameTextField)
                            .addComponent(employeeIDComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(projectPlaceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(projectPlaceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(employeeIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(projectIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(projectNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDatePickerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endDatePickerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectPlaceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(projectPlaceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void employeeIDComboBoxMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_employeeIDComboBoxMouseClicked

    }// GEN-LAST:event_employeeIDComboBoxMouseClicked

    private void projectIDComboBoxMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_projectIDComboBoxMouseClicked

    }// GEN-LAST:event_projectIDComboBoxMouseClicked

    private void employeeIDComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_employeeIDComboBoxItemStateChanged
        // TODO add your handling code here:
        String emId = employeeIDComboBox.getSelectedItem().toString();
        for (int i = 0; i < emB.getEmployeeList().size(); i++) {
            if (emId.equalsIgnoreCase(emB.getEmployeeList().get(i).getId())) {
                employeeNameTextField.setText(emB.getEmployeeList().get(i).getFullName());
            }
        }
    }// GEN-LAST:event_employeeIDComboBoxItemStateChanged

    private void projectIDComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_projectIDComboBoxItemStateChanged
        // TODO add your handling code here:
        String pjId = projectIDComboBox.getSelectedItem().toString();
        for (int i = 0; i < pjB.getProjectList().size(); i++) {
            if (pjId.equalsIgnoreCase(pjB.getProjectList().get(i).getProjectId())) {
                projectNameTextField.setText(pjB.getProjectList().get(i).getProjectName());
                startDatePicker.setText(pjB.getProjectList().get(i).getBeginAt());
                endDatePicker.setText(pjB.getProjectList().get(i).getCompleteAt());
                projectPlaceComboBox.setSelectedItem(pjB.getProjectList().get(i).getPlace());
            }
        }
    }// GEN-LAST:event_projectIDComboBoxItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    public static javax.swing.JButton confirmButton;
    public static javax.swing.JComboBox<String> employeeIDComboBox;
    private javax.swing.JLabel employeeIDLabel;
    private javax.swing.JLabel employeeNameLabel;
    private javax.swing.JTextField employeeNameTextField;
    private com.github.lgooddatepicker.components.DatePicker endDatePicker;
    private javax.swing.JLabel endDatePickerLabel;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JComboBox<String> projectIDComboBox;
    private javax.swing.JLabel projectIDLabel;
    private javax.swing.JLabel projectNameLabel;
    private javax.swing.JTextField projectNameTextField;
    private javax.swing.JComboBox<String> projectPlaceComboBox;
    private javax.swing.JLabel projectPlaceLabel;
    private com.github.lgooddatepicker.components.DatePicker startDatePicker;
    private javax.swing.JLabel startDatePickerLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
        clearFormData();
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
