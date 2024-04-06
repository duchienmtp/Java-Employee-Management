package FrontEnd.SalaryContentUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class SalaryContentPanel extends javax.swing.JPanel implements ActionListener, ListSelectionListener, MouseListener {

    int selectedRow = -1;
    boolean selectionConfirmed;
    Object[] selectedRowData;
    ArrayList<Object> formData;

    DetailSalaryInfo detailSalaryInfo;

    public SalaryContentPanel() {
        initComponents();

        formData = new ArrayList<>();

        detailSalaryInfo = new DetailSalaryInfo();

        salaryLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        salaryTableLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        detailButton.addActionListener(this);
        cancelButton.addActionListener(this);

        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable1.setDefaultRenderer(String.class, centerRenderer);
        jTable1.setDefaultRenderer(Object.class, centerRenderer);
        jTable1.setDefaultRenderer(Integer.class, centerRenderer);
        jTable1.setDefaultRenderer(Double.class, centerRenderer);

        tableInit();
        jTable1.getSelectionModel().addListSelectionListener(this);
//        jTable1.addMouseListener(this);
        jPanel1.addMouseListener(this);

        setVisible(true);
    }

    public void tableInit() {
        Object[] newRowData = {1, "EM001", "Trần Đức Hiển", "4/2024", 30000000, "01/04/2024"};
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < 10; i++) {
            model.addRow(newRowData);
        }
    }

    public ArrayList<Object> getDataFromForm() {
        String employeeID = (String) employeeIDComboBox.getSelectedItem(),
                employeeName = employeeNameTextField.getText();
        int monthOfSalary = Integer.parseInt((String) monthPickerComboBox.getSelectedItem());
        double salary = Double.parseDouble((String) salarySumTextField.getText());

        return new ArrayList<>(Arrays.asList(employeeID, employeeName, monthOfSalary, salary));
    }

    public void insertTableRow() {
        formData = getDataFromForm();

        int confirmation = JOptionPane.showConfirmDialog(this,
                "Bạn có muốn thêm mới dữ liệu lương của nhân viên với ID " + formData.get(0) + " ?",
                "THÊM MỚI ?",
                JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            clearFormContent();
            jTable1.revalidate();
        }
    }

    public void updateTableRow() {
        formData = getDataFromForm();

        int confirmation = JOptionPane.showConfirmDialog(this,
                "Bạn có muốn cập nhật dữ liệu lương của nhân viên với ID " + formData.get(0) + " ?",
                "CẬP NHẬT ?",
                JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            clearFormContent();
            jTable1.revalidate();
        }
    }

    public void deleteTableRow() {
        formData = getDataFromForm();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int confirmation = JOptionPane.showConfirmDialog(this,
                "Bạn có muốn xóa bỏ dữ liệu lương của nhân viên với ID " + formData.get(0) + " ?",
                "XÓA BỎ ?",
                JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            model.removeRow(selectedRow);
            clearFormContent();
            jTable1.revalidate();
        }
    }

    public void fillDataSalaryForm(Object[] selectedRowData) {
        employeeIDComboBox.setSelectedItem((String) selectedRowData[1]);
        employeeNameTextField.setText((String) selectedRowData[2]);
        monthPickerComboBox.setSelectedItem(Integer.toString((int) selectedRowData[3]));
        salarySumTextField.setText(Integer.toString((int) selectedRowData[4]));
    }

    public void clearFormContent() {
        employeeIDComboBox.setSelectedItem("");
        employeeNameTextField.setText("");
        monthPickerComboBox.setSelectedItem("1");
        salarySumTextField.setText("");
    }

    public boolean isFormFilled() {
        return !(employeeNameTextField.getText().equals("") || ((String) monthPickerComboBox.getSelectedItem()).equals(""));
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (!event.getValueIsAdjusting()) {  // Ensure selection is stable
            selectionConfirmed = true;
            selectedRow = jTable1.getSelectedRow();
            if (selectedRow >= 0) {  // Check if a row is selected
                selectedRowData = new Object[jTable1.getColumnCount()];
                for (int i = 0; i < jTable1.getColumnCount(); i++) {
                    selectedRowData[i] = jTable1.getValueAt(selectedRow, i);
                }
                fillDataSalaryForm(selectedRowData);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            if (isFormFilled()) {
                insertTableRow();
            } else {
                JOptionPane.showMessageDialog(this, "Hãy nhập thông tin trước!", "CẢNH BÁO", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == deleteButton) {
            if (selectedRow >= 0) {
                deleteTableRow();
            } else {
                JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng trước!", "CẢNH BÁO", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == updateButton) {
            if (selectedRow >= 0) {
                if (isFormFilled()) {
                    updateTableRow();
                } else {
                    JOptionPane.showMessageDialog(this, "Hãy nhập thông tin trước!", "CẢNH BÁO", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng trước!", "CẢNH BÁO", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == cancelButton) {
            clearFormContent();
        } else if (e.getSource() == detailButton) {
            if (selectedRow >= 0) {
                detailSalaryInfo.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng trước!", "CẢNH BÁO", JOptionPane.INFORMATION_MESSAGE);
            }
        }
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        salaryFormContainer = new javax.swing.JPanel();
        salaryLabel = new javax.swing.JLabel();
        salaryForm = new javax.swing.JPanel();
        employeeNameLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        employeeNameTextField = new javax.swing.JTextField();
        detailButton = new javax.swing.JButton();
        employeeIDComboBox = new javax.swing.JComboBox<>();
        monthPickerLabel = new javax.swing.JLabel();
        monthPickerComboBox = new javax.swing.JComboBox<>();
        salarySumLabel = new javax.swing.JLabel();
        employeeIDLabel = new javax.swing.JLabel();
        salarySumTextField = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        salaryTableContainer = new javax.swing.JPanel();
        salaryTableLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(102, 255, 102));
        setName("salaryContentPanel"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        salaryFormContainer.setBackground(new java.awt.Color(255, 255, 255));
        salaryFormContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        salaryFormContainer.setName("salaryFormContainer"); // NOI18N
        salaryFormContainer.setPreferredSize(new java.awt.Dimension(386, 540));

        salaryLabel.setBackground(new java.awt.Color(255, 255, 255));
        salaryLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        salaryLabel.setForeground(new java.awt.Color(0, 0, 0));
        salaryLabel.setText("Bảng Tính Lương");
        salaryLabel.setName("salaryLabel"); // NOI18N
        salaryLabel.setOpaque(true);
        salaryLabel.setPreferredSize(new java.awt.Dimension(369, 25));

        salaryForm.setBackground(new java.awt.Color(255, 255, 255));
        salaryForm.setName("salaryForm"); // NOI18N

        employeeNameLabel.setBackground(new java.awt.Color(255, 255, 255));
        employeeNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        employeeNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        employeeNameLabel.setLabelFor(employeeNameTextField);
        employeeNameLabel.setText("Tên Nhân Viên :");
        employeeNameLabel.setName("employeeNameLabel"); // NOI18N
        employeeNameLabel.setOpaque(true);

        cancelButton.setBackground(new java.awt.Color(108, 117, 125));
        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Hủy Bỏ");
        cancelButton.setName("cancelButton"); // NOI18N
        cancelButton.setOpaque(true);

        employeeNameTextField.setBackground(new java.awt.Color(204, 204, 204));
        employeeNameTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        employeeNameTextField.setForeground(new java.awt.Color(0, 0, 0));
        employeeNameTextField.setCaretColor(new java.awt.Color(0, 0, 0));
        employeeNameTextField.setEnabled(false);
        employeeNameTextField.setName("employeeNameTextField"); // NOI18N

        detailButton.setBackground(new java.awt.Color(13, 110, 253));
        detailButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        detailButton.setForeground(new java.awt.Color(255, 255, 255));
        detailButton.setText("Xem Chi Tiết");
        detailButton.setName("detailButton"); // NOI18N
        detailButton.setOpaque(true);

        employeeIDComboBox.setBackground(new java.awt.Color(204, 204, 204));
        employeeIDComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        employeeIDComboBox.setForeground(new java.awt.Color(0, 0, 0));
        employeeIDComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EM001", "EM002", "EM003", " " }));
        employeeIDComboBox.setName("employeeIDComboBox"); // NOI18N
        employeeIDComboBox.setOpaque(true);

        monthPickerLabel.setBackground(new java.awt.Color(255, 255, 255));
        monthPickerLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        monthPickerLabel.setForeground(new java.awt.Color(0, 0, 0));
        monthPickerLabel.setLabelFor(monthPickerComboBox);
        monthPickerLabel.setText("Lương Tháng :");
        monthPickerLabel.setName("monthPickerLabel"); // NOI18N
        monthPickerLabel.setOpaque(true);

        monthPickerComboBox.setBackground(new java.awt.Color(204, 204, 204));
        monthPickerComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        monthPickerComboBox.setForeground(new java.awt.Color(0, 0, 0));
        monthPickerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));
        monthPickerComboBox.setName("monthPickerComboBox"); // NOI18N
        monthPickerComboBox.setOpaque(true);

        salarySumLabel.setBackground(new java.awt.Color(255, 255, 255));
        salarySumLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        salarySumLabel.setForeground(new java.awt.Color(0, 0, 0));
        salarySumLabel.setLabelFor(salarySumTextField);
        salarySumLabel.setText("Tổng Lương :");
        salarySumLabel.setName("salarySumLabel"); // NOI18N
        salarySumLabel.setOpaque(true);
        salarySumLabel.setPreferredSize(new java.awt.Dimension(95, 20));

        employeeIDLabel.setBackground(new java.awt.Color(255, 255, 255));
        employeeIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        employeeIDLabel.setForeground(new java.awt.Color(0, 0, 0));
        employeeIDLabel.setLabelFor(employeeIDComboBox);
        employeeIDLabel.setText("Mã Nhân Viên :");
        employeeIDLabel.setName("employeeIDLabel"); // NOI18N
        employeeIDLabel.setOpaque(true);
        employeeIDLabel.setPreferredSize(new java.awt.Dimension(101, 40));

        salarySumTextField.setBackground(new java.awt.Color(204, 204, 204));
        salarySumTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        salarySumTextField.setForeground(new java.awt.Color(0, 0, 0));
        salarySumTextField.setCaretColor(new java.awt.Color(0, 0, 0));
        salarySumTextField.setEnabled(false);
        salarySumTextField.setName("salarySumTextField"); // NOI18N
        salarySumTextField.setOpaque(true);

        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        updateButton.setText("Sửa");
        updateButton.setIconTextGap(10);
        updateButton.setName("updateButton"); // NOI18N
        updateButton.setOpaque(true);

        addButton.setBackground(new java.awt.Color(25, 135, 84));
        addButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        addButton.setText("Thêm");
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.setIconTextGap(10);
        addButton.setName("addButton"); // NOI18N
        addButton.setPreferredSize(new java.awt.Dimension(112, 40));

        deleteButton.setBackground(new java.awt.Color(220, 53, 69));
        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        deleteButton.setText("Xóa");
        deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteButton.setIconTextGap(10);
        deleteButton.setName("deleteButton"); // NOI18N
        deleteButton.setOpaque(true);

        javax.swing.GroupLayout salaryFormLayout = new javax.swing.GroupLayout(salaryForm);
        salaryForm.setLayout(salaryFormLayout);
        salaryFormLayout.setHorizontalGroup(
            salaryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salaryFormLayout.createSequentialGroup()
                .addGroup(salaryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(monthPickerLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employeeNameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salarySumLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(salaryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employeeNameTextField)
                    .addComponent(monthPickerComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salarySumTextField)))
            .addGroup(salaryFormLayout.createSequentialGroup()
                .addComponent(employeeIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(employeeIDComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, salaryFormLayout.createSequentialGroup()
                .addComponent(detailButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(salaryFormLayout.createSequentialGroup()
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
        );
        salaryFormLayout.setVerticalGroup(
            salaryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, salaryFormLayout.createSequentialGroup()
                .addGroup(salaryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(employeeIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employeeIDComboBox))
                .addGap(18, 18, 18)
                .addGroup(salaryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(employeeNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employeeNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(salaryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(monthPickerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(monthPickerComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(salaryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(salarySumTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(salarySumLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(salaryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(detailButton, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addGroup(salaryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout salaryFormContainerLayout = new javax.swing.GroupLayout(salaryFormContainer);
        salaryFormContainer.setLayout(salaryFormContainerLayout);
        salaryFormContainerLayout.setHorizontalGroup(
            salaryFormContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salaryFormContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(salaryFormContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salaryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salaryForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        salaryFormContainerLayout.setVerticalGroup(
            salaryFormContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salaryFormContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(salaryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(salaryForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        salaryTableContainer.setBackground(new java.awt.Color(255, 255, 255));
        salaryTableContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        salaryTableContainer.setName("salaryTableContainer"); // NOI18N
        salaryTableContainer.setPreferredSize(new java.awt.Dimension(537, 540));

        salaryTableLabel.setBackground(new java.awt.Color(255, 255, 255));
        salaryTableLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        salaryTableLabel.setForeground(new java.awt.Color(0, 0, 0));
        salaryTableLabel.setText("Bảng Lương");
        salaryTableLabel.setName("salaryTableLabel"); // NOI18N
        salaryTableLabel.setOpaque(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID", "Tên Nhân Viên", "Lương Tháng", "Thực Lãnh", "Ngày Tạo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setName("degreeTable"); // NOI18N
        jTable1.setRowHeight(40);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout salaryTableContainerLayout = new javax.swing.GroupLayout(salaryTableContainer);
        salaryTableContainer.setLayout(salaryTableContainerLayout);
        salaryTableContainerLayout.setHorizontalGroup(
            salaryTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salaryTableContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(salaryTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salaryTableLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE))
                .addContainerGap())
        );
        salaryTableContainerLayout.setVerticalGroup(
            salaryTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salaryTableContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(salaryTableLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(salaryFormContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(salaryTableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(salaryTableContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salaryFormContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton detailButton;
    private javax.swing.JComboBox<String> employeeIDComboBox;
    private javax.swing.JLabel employeeIDLabel;
    private javax.swing.JLabel employeeNameLabel;
    private javax.swing.JTextField employeeNameTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> monthPickerComboBox;
    private javax.swing.JLabel monthPickerLabel;
    private javax.swing.JPanel salaryForm;
    private javax.swing.JPanel salaryFormContainer;
    private javax.swing.JLabel salaryLabel;
    private javax.swing.JLabel salarySumLabel;
    private javax.swing.JTextField salarySumTextField;
    private javax.swing.JPanel salaryTableContainer;
    private javax.swing.JLabel salaryTableLabel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
