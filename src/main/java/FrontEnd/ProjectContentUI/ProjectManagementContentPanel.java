package FrontEnd.ProjectContentUI;

import com.github.lgooddatepicker.components.DatePickerSettings;

import BackEnd.EmployeeManagement.Employee;
import BackEnd.ProjectsManagement.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ProjectManagementContentPanel extends javax.swing.JPanel
        implements ActionListener, ListSelectionListener, MouseListener {

    ProjectBUS pjB = new ProjectBUS();
    ArrayList<Project> projectList;
    int selectedRow = -1;
    boolean selectionConfirmed;
    Object[] selectedRowData;
    ArrayList<Object> formData;

    public ProjectManagementContentPanel() {
        initComponents();

        projectList = pjB.getProjectList();

        formData = new ArrayList<>();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        DatePickerSettings startDatePickerSettings = new DatePickerSettings();
        startDatePickerSettings.setFormatForDatesCommonEra(dtf);
        startDatePicker.setSettings(startDatePickerSettings);
        LocalDate today = LocalDate.now();
        startDatePickerSettings.setDateRangeLimits(today.minusDays(0), null);

        DatePickerSettings endDatePickerSettings = new DatePickerSettings();
        endDatePickerSettings.setFormatForDatesCommonEra(dtf);
        endDatePicker.setSettings(endDatePickerSettings);

        projectLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        projectTableLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        cancelButton.addActionListener(this);

        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable1.setDefaultRenderer(String.class, centerRenderer);
        jTable1.setDefaultRenderer(Object.class, centerRenderer);
        jTable1.setDefaultRenderer(Integer.class, centerRenderer);
        jTable1.setDefaultRenderer(Double.class, centerRenderer);

        formInit();
        tableInit(projectList);

        jTable1.getSelectionModel().addListSelectionListener(this);
        // jTable1.addMouseListener(this);
        jPanel1.addMouseListener(this);

        setVisible(true);
    }

    public void formInit() {
        projectIDTextField.setText(pjB.getNextID());
    }

    public void tableInit(ArrayList<Project> list) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).isDeleteStatus()) {
                model.addRow(new Object[] { i + 1, list.get(i).getProjectId(),
                        list.get(i).getProjectName(), list.get(i).getPlace(),
                        Employee.formatBirthDateToStandardTypeToStandardType(
                                list.get(i).getBeginAt()),
                        Employee.formatBirthDateToStandardTypeToStandardType(
                                list.get(i).getCompleteAt()),
                        list.get(i).getDepartmentId()
                });
            }
        }
    }

    public ArrayList<Object> getDataFromForm() {
        String projectID = projectIDTextField.getText(),
                projectName = projectNameTextField.getText(),
                departmentId = (String) DepartmentIdCombo.getSelectedItem(),
                startDate = Employee.formatBirthDateToDatabaseType(startDatePicker.getText()),
                endDate = Employee.formatBirthDateToDatabaseType(endDatePicker.getText()),
                projectPlace = projectPlaceTextField.getText();

        return new ArrayList<>(
                Arrays.asList(projectID, projectName, departmentId, startDate, endDate, projectPlace));
    }

    public void insertTableRow() {
        formData = getDataFromForm();

        int confirmation = JOptionPane.showConfirmDialog(this,
                "Bạn có muốn thêm mới dữ liệu dự án với ID " + formData.get(0) + " ?",
                "THÊM MỚI ?",
                JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            Project tmp = new Project((String) formData.get(0),
                    (String) formData.get(1), (String) formData.get(2),
                    (String) formData.get(3), (String) formData.get(4),
                    (String) formData.get(5), false);
            pjB.addProject(tmp);
            clearFormContent();
            jTable1.revalidate();
            tableInit(pjB.getProjectList());
        }
    }

    public void updateTableRow() {
        formData = getDataFromForm();

        int confirmation = JOptionPane.showConfirmDialog(this,
                "Bạn có muốn cập nhật dữ liệu dữ liệu dự án với ID " + formData.get(0) + " ?",
                "CẬP NHẬT ?",
                JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            Project tmp = new Project((String) formData.get(0),
                    (String) formData.get(1), (String) formData.get(2),
                    (String) formData.get(3), (String) formData.get(4),
                    (String) formData.get(5), false);
            pjB.updateProject(tmp);
            clearFormContent();
            jTable1.revalidate();
            tableInit(pjB.getProjectList());
        }
    }

    public void deleteTableRow() {
        formData = getDataFromForm();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int confirmation = JOptionPane.showConfirmDialog(this,
                "Bạn có muốn xóa bỏ dữ liệu dự án với ID " + formData.get(0) + " ?",
                "XÓA BỎ ?",
                JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            String pjId = model.getValueAt(selectedRow, 1).toString();
            pjB.deleteProject(pjId);
            clearFormContent();
            jTable1.revalidate();
            tableInit(pjB.getProjectList());
        }
    }

    public void fillDataProjectForm(Object[] selectedRowData) {
        projectIDTextField.setText((String) selectedRowData[1]);
        projectNameTextField.setText((String) selectedRowData[2]);
        startDatePicker.setText((String) selectedRowData[4]);
        endDatePicker.setText((String) selectedRowData[5]);
        projectPlaceTextField.setText((String) selectedRowData[3]);
    }

    public void clearFormContent() {
        formInit();
        projectNameTextField.setText("");
        startDatePicker.setText("");
        endDatePicker.setText("");
        projectPlaceTextField.setText("");
        addButton.setEnabled(true);
    }

    public boolean isFormFilled() {
        return !(projectNameTextField.getText().equals("")
                || startDatePicker.getText().equals("")
                || endDatePicker.getText().equals("")
                || projectPlaceTextField.getText().equals(""));
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (!event.getValueIsAdjusting()) { // Ensure selection is stable
            selectionConfirmed = true;
            selectedRow = jTable1.getSelectedRow();
            if (selectedRow >= 0) { // Check if a row is selected
                selectedRowData = new Object[jTable1.getColumnCount()];
                for (int i = 0; i < jTable1.getColumnCount(); i++) {
                    selectedRowData[i] = jTable1.getValueAt(selectedRow, i);
                }
                fillDataProjectForm(selectedRowData);
                addButton.setEnabled(false);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            if (isFormFilled()) {
                insertTableRow();
            } else {
                JOptionPane.showMessageDialog(this, "Hãy nhập thông tin trước!", "CẢNH BÁO",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == deleteButton) {
            if (selectedRow >= 0) {
                deleteTableRow();
            } else {
                JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng trước!", "CẢNH BÁO",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == updateButton) {
            if (selectedRow >= 0) {
                if (isFormFilled()) {
                    updateTableRow();
                } else {
                    JOptionPane.showMessageDialog(this, "Hãy nhập thông tin trước!", "CẢNH BÁO",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng trước!", "CẢNH BÁO",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == cancelButton) {
            clearFormContent();
        }
        addButton.setEnabled(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Component clickedComponent = jPanel1.getComponentAt(jPanel1.getMousePosition());
        if (clickedComponent != jTable1 && selectionConfirmed) {
            jTable1.getSelectionModel().clearSelection();
            selectionConfirmed = false;
        }
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        projectFormContainer = new javax.swing.JPanel();
        projectLabel = new javax.swing.JLabel();
        projectIDLabel = new javax.swing.JLabel();
        employeeNameLabel = new javax.swing.JLabel();
        projectNameTextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        monthPickerLabel = new javax.swing.JLabel();
        salarySumLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        projectIDTextField = new javax.swing.JTextField();
        startDatePicker = new com.github.lgooddatepicker.components.DatePicker();
        endDatePicker = new com.github.lgooddatepicker.components.DatePicker();
        projectPlaceTextField = new javax.swing.JTextField();
        projectPlaceLabel = new javax.swing.JLabel();
        DepartmentIdCombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        projectTableContainer = new javax.swing.JPanel();
        projectTableLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(102, 255, 102));
        setName("salaryContentPanel"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        projectFormContainer.setBackground(new java.awt.Color(255, 255, 255));
        projectFormContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        projectFormContainer.setName("projectFormContainer"); // NOI18N
        projectFormContainer.setPreferredSize(new java.awt.Dimension(396, 545));

        projectLabel.setText("Dự Án");
        projectLabel.setBackground(new java.awt.Color(255, 255, 255));
        projectLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        projectLabel.setForeground(new java.awt.Color(0, 0, 0));
        projectLabel.setName("projectLabel"); // NOI18N
        projectLabel.setOpaque(true);

        projectIDLabel.setLabelFor(projectIDTextField);
        projectIDLabel.setText("Mã Dự Án :");
        projectIDLabel.setBackground(new java.awt.Color(255, 255, 255));
        projectIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        projectIDLabel.setForeground(new java.awt.Color(0, 0, 0));
        projectIDLabel.setName("projectIDLabel"); // NOI18N
        projectIDLabel.setOpaque(true);

        employeeNameLabel.setLabelFor(projectNameTextField);
        employeeNameLabel.setText("Tên Dự Án :");
        employeeNameLabel.setBackground(new java.awt.Color(255, 255, 255));
        employeeNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        employeeNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        employeeNameLabel.setName("employeeNameLabel"); // NOI18N
        employeeNameLabel.setOpaque(true);

        projectNameTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        projectNameTextField.setBackground(new java.awt.Color(204, 204, 204));
        projectNameTextField.setCaretColor(new java.awt.Color(0, 0, 0));
        projectNameTextField.setForeground(new java.awt.Color(0, 0, 0));
        projectNameTextField.setName("projectNameTextField"); // NOI18N
        projectNameTextField.setOpaque(true);

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        addButton.setText("Thêm");
        addButton.setBackground(new java.awt.Color(25, 135, 84));
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setIconTextGap(10);
        addButton.setName("addButton"); // NOI18N

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        deleteButton.setText("Xóa");
        deleteButton.setBackground(new java.awt.Color(220, 53, 69));
        deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setIconTextGap(10);
        deleteButton.setName("deleteButton"); // NOI18N
        deleteButton.setOpaque(true);

        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        updateButton.setText("Sửa");
        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setIconTextGap(10);
        updateButton.setName("updateButton"); // NOI18N
        updateButton.setOpaque(true);

        monthPickerLabel.setText("Bắt Đầu Từ :");
        monthPickerLabel.setBackground(new java.awt.Color(255, 255, 255));
        monthPickerLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        monthPickerLabel.setForeground(new java.awt.Color(0, 0, 0));
        monthPickerLabel.setName("monthPickerLabel"); // NOI18N
        monthPickerLabel.setOpaque(true);

        salarySumLabel.setText("Kết Thúc :");
        salarySumLabel.setBackground(new java.awt.Color(255, 255, 255));
        salarySumLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        salarySumLabel.setForeground(new java.awt.Color(0, 0, 0));
        salarySumLabel.setName("salarySumLabel"); // NOI18N
        salarySumLabel.setOpaque(true);

        cancelButton.setText("Hủy Bỏ");
        cancelButton.setBackground(new java.awt.Color(108, 117, 125));
        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setName("cancelButton"); // NOI18N
        cancelButton.setOpaque(true);

        projectIDTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        projectIDTextField.setBackground(new java.awt.Color(204, 204, 204));
        projectIDTextField.setEnabled(false);
        projectIDTextField.setForeground(new java.awt.Color(0, 0, 0));
        projectIDTextField.setName("projectIDTextField"); // NOI18N
        projectIDTextField.setOpaque(true);

        startDatePicker.setForeground(new java.awt.Color(0, 0, 0));
        startDatePicker.setName("startDatePicker"); // NOI18N
        startDatePicker.setToolTipText("");

        endDatePicker.setForeground(new java.awt.Color(0, 0, 0));
        endDatePicker.setName("endDatePicker"); // NOI18N

        projectPlaceTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        projectPlaceTextField.setBackground(new java.awt.Color(204, 204, 204));
        projectPlaceTextField.setCaretColor(new java.awt.Color(0, 0, 0));
        projectPlaceTextField.setForeground(new java.awt.Color(0, 0, 0));
        projectPlaceTextField.setName("projectPlaceTextField"); // NOI18N
        projectPlaceTextField.setOpaque(true);

        projectPlaceLabel.setLabelFor(projectPlaceTextField);
        projectPlaceLabel.setText("Dự Án Tại :");
        projectPlaceLabel.setBackground(new java.awt.Color(255, 255, 255));
        projectPlaceLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        projectPlaceLabel.setForeground(new java.awt.Color(0, 0, 0));
        projectPlaceLabel.setName("projectPlaceLabel"); // NOI18N
        projectPlaceLabel.setOpaque(true);

        DepartmentIdCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DP001" }));
        DepartmentIdCombo.setBackground(new java.awt.Color(204, 204, 204));
        DepartmentIdCombo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DepartmentIdCombo.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setText("Phòng Quản Lý :");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout projectFormContainerLayout = new javax.swing.GroupLayout(projectFormContainer);
        projectFormContainer.setLayout(projectFormContainerLayout);
        projectFormContainerLayout.setHorizontalGroup(
                projectFormContainerLayout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(projectFormContainerLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(projectFormContainerLayout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(projectLabel,
                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addGroup(projectFormContainerLayout
                                                .createSequentialGroup()
                                                .addComponent(addButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(deleteButton,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        105,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(updateButton,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        129,
                                                        Short.MAX_VALUE))
                                        .addGroup(projectFormContainerLayout
                                                .createSequentialGroup()
                                                .addComponent(employeeNameLabel)
                                                .addGap(2, 2, 2)
                                                .addComponent(projectNameTextField))
                                        .addGroup(projectFormContainerLayout
                                                .createSequentialGroup()
                                                .addComponent(projectIDLabel)
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(projectIDTextField))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                projectFormContainerLayout
                                                        .createSequentialGroup()
                                                        .addGroup(projectFormContainerLayout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                .addComponent(startDatePicker,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        171,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(monthPickerLabel,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE))
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                        .addGroup(projectFormContainerLayout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                .addComponent(endDatePicker,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        171,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(salarySumLabel,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)))
                                        .addGroup(projectFormContainerLayout
                                                .createSequentialGroup()
                                                .addComponent(projectPlaceLabel)
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(projectPlaceTextField))
                                        .addComponent(cancelButton,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addGroup(projectFormContainerLayout
                                                .createSequentialGroup()
                                                .addComponent(jLabel1,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        155,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DepartmentIdCombo,
                                                        0,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)))
                                .addContainerGap()));
        projectFormContainerLayout.setVerticalGroup(
                projectFormContainerLayout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(projectFormContainerLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(projectLabel,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        50,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(projectFormContainerLayout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                false)
                                        .addComponent(projectIDLabel,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                40,
                                                Short.MAX_VALUE)
                                        .addComponent(projectIDTextField))
                                .addGap(18, 18, 18)
                                .addGroup(projectFormContainerLayout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                false)
                                        .addComponent(employeeNameLabel,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(projectNameTextField,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                40,
                                                Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(projectFormContainerLayout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(monthPickerLabel,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(salarySumLabel,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(projectFormContainerLayout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                false)
                                        .addComponent(startDatePicker,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                34,
                                                Short.MAX_VALUE)
                                        .addComponent(endDatePicker,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(projectFormContainerLayout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                false)
                                        .addComponent(projectPlaceLabel,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                40,
                                                Short.MAX_VALUE)
                                        .addComponent(projectPlaceTextField))
                                .addGap(18, 18, 18)
                                .addGroup(projectFormContainerLayout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                false)
                                        .addComponent(DepartmentIdCombo,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                36,
                                                Short.MAX_VALUE)
                                        .addComponent(jLabel1,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                .addGap(22, 22, 22)
                                .addComponent(cancelButton,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        50,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        60,
                                        Short.MAX_VALUE)
                                .addGroup(projectFormContainerLayout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(updateButton,
                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                projectFormContainerLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(deleteButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(addButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap()));

        projectTableContainer.setBackground(new java.awt.Color(255, 255, 255));
        projectTableContainer
                .setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        projectTableContainer.setName("projectTableContainer"); // NOI18N

        projectTableLabel.setText("Bảng Dự Án");
        projectTableLabel.setBackground(new java.awt.Color(255, 255, 255));
        projectTableLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        projectTableLabel.setForeground(new java.awt.Color(0, 0, 0));
        projectTableLabel.setName("projectTableLabel"); // NOI18N
        projectTableLabel.setOpaque(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "STT", "ID", "Tên Dự Án", "Nơi Làm Việc", "Ngày Bắt Đầu",
                        "Ngày Kết Thúc", "Phòng Quản Lý"
                }) {
            Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class,
                    java.lang.String.class,
                    java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable1.setName("degreeTable"); // NOI18N
        jTable1.setRowHeight(40);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout projectTableContainerLayout = new javax.swing.GroupLayout(
                projectTableContainer);
        projectTableContainer.setLayout(projectTableContainerLayout);
        projectTableContainerLayout.setHorizontalGroup(
                projectTableContainerLayout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(projectTableContainerLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(projectTableContainerLayout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(projectTableLabel,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(jScrollPane1,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                513,
                                                Short.MAX_VALUE))
                                .addContainerGap()));
        projectTableContainerLayout.setVerticalGroup(
                projectTableContainerLayout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(projectTableContainerLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(projectTableLabel,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        54,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        465,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(projectFormContainer,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        32,
                                        Short.MAX_VALUE)
                                .addComponent(projectTableContainer,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                false)
                                        .addComponent(projectFormContainer,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                560,
                                                Short.MAX_VALUE)
                                        .addComponent(projectTableContainer,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                .addContainerGap(40, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> DepartmentIdCombo;
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel employeeNameLabel;
    private com.github.lgooddatepicker.components.DatePicker endDatePicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel monthPickerLabel;
    private javax.swing.JPanel projectFormContainer;
    private javax.swing.JLabel projectIDLabel;
    private javax.swing.JTextField projectIDTextField;
    private javax.swing.JLabel projectLabel;
    private javax.swing.JTextField projectNameTextField;
    private javax.swing.JLabel projectPlaceLabel;
    private javax.swing.JTextField projectPlaceTextField;
    private javax.swing.JPanel projectTableContainer;
    private javax.swing.JLabel projectTableLabel;
    private javax.swing.JLabel salarySumLabel;
    private com.github.lgooddatepicker.components.DatePicker startDatePicker;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
