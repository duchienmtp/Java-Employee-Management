package FrontEnd.CriticismContentUI;
import BackEnd.CriticismManagement.Criticism;
import BackEnd.CriticismManagement.CriticismBUS;
import BackEnd.EmployeesRewardsCriticismManagement.EmployeesRewardsCriticism;
import BackEnd.EmployeesRewardsCriticismManagement.EmployeesRewardsCriticismBUS;
import FrontEnd.CriticismContentUI.CriticismEmployeePanel;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class CriticismEmployeeForm extends javax.swing.JFrame implements ActionListener, WindowListener {
    String type;
    EmployeesRewardsCriticismBUS employeeRCBUS = new EmployeesRewardsCriticismBUS();
    CriticismBUS criticismBUS = new CriticismBUS();

    EmployeesRewardsCriticism employeercUpdate;
    public CriticismEmployeeForm() {
        initComponents();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        DatePickerSettings pickerSettingsBegin = new DatePickerSettings();
        pickerSettingsBegin.setFormatForDatesCommonEra("dd/MM/yyyy");
        startDatePicker.setSettings(pickerSettingsBegin);
        startDatePicker.setDateToToday();

        // Get the default editor associated with the spinner
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) countSpinner.getEditor();

        // Access the text field component within the editor
        JTextField textField = editor.getTextField();

        // Set the foreground color (text color) of the text field
        textField.setForeground(Color.WHITE); // Set your desired color

        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        cancelButton.addActionListener(this);
        addWindowListener(this);
    }
    public CriticismEmployeeForm(String _type, String _criticismId) {
       JPanel plInput = new JPanel();
       plInput.add(criticsimIDComboBox);
       JPanel plButton = new JPanel();

         if (this.type.equals("Thêm")) {
            this.setTitle("Thêm mới kỷ luật nhân viên");
            criticsimIDComboBox.setSelectedItem("CR" + String.valueOf(criticismBUS.getlistcriticism().size() + 1));
            
            LocalDate createdAt = java.time.LocalDate.now();
            this.startDatePicker.setDate(createdAt);
            plButton.add(addButton);

        } else {
            this.setTitle("Sửa kỷ luật nhân viên");
              for ( EmployeesRewardsCriticism erc : employeeRCBUS.getlistEmployeeRC()) {
                if (erc.getCriticismId().equals(_criticismId)) {
                    this.employeercUpdate = erc;
                }
            }
            if (this.employeercUpdate == null) {
                JOptionPane.showMessageDialog(null, "Lỗi, không tìm thấy nhân viên");
                this.dispose();
            }

            employeeIDComboBox.setSelectedItem(this.employeercUpdate.getEmployeeId());
            criticsimIDComboBox.setSelectedItem(this.employeercUpdate.getCriticismId());
            countSpinner.setValue(this.employeercUpdate.getFaultCount());
            //moneyTextField.setText(String.valueOf(this.employeercUpdate.getTongTien()));
            //startDatePicker.setText((String)this.employeercUpdate.getCreatedAt() );
           plInput.add(moneyTextField);
           plButton.add(updateButton);
        }
         plButton.add(cancelButton);

        this.add(plInput, BorderLayout.CENTER);
        this.add(plButton, BorderLayout.SOUTH);
         // mouse listener

     }

//    public void showFormWithData(ArrayList<Object> data) {
//        if (data != null) {
//            employeeIDComboBox.setSelectedItem(data.get(1));
//            criticsimIDComboBox.setSelectedItem(data.get(3));
//            criticismNameTextField.setText((String) data.get(4));
//            countSpinner.setValue(data.get(5));
//            moneyTextField.setText(Integer.toString((int) data.get(6)));
//            startDatePicker.setText((String) data.get(7));
//        }
//    }
     public void showFormWithData(ArrayList<Object> data) {
        if (data != null && data.size() >= 8) { // Đảm bảo có đủ dữ liệu
            employeeIDComboBox.setSelectedItem(data.get(1));
            criticsimIDComboBox.setSelectedItem(data.get(3));
            criticismNameTextField.setText((String) data.get(4));
            countSpinner.setValue((Integer) data.get(5));
            moneyTextField.setText(String.valueOf(data.get(6)));
            startDatePicker.setDate((LocalDate)data.get(7)) ; // Giả sử định dạng ngày là "yyyy-MM-dd"
            
            
        }
    }
    

    public void clearFormData() {
        employeeIDComboBox.setSelectedItem("");
        criticsimIDComboBox.setSelectedItem("");
        criticismNameTextField.setText("");
        countSpinner.setValue(0);
        moneyTextField.setText("");
        startDatePicker.setText("");
    }

    public void handleSubmitForm() {
        String employeeID = (String) employeeIDComboBox.getSelectedItem();

        int confirmation = JOptionPane.showConfirmDialog(this,
                "Bạn có muốn thêm mới dữ liệu nhân viên với ID " + employeeID + " ?",
                "XÁC NHẬN ?",
                JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
//            // Create a new ArrayList
//            ArrayList<Object> dataList = new ArrayList<>(rowData.length);
//
//            // Add all elements from the array to the ArrayList
//            dataList.addAll(Arrays.asList(rowData));
        }
    }

    public boolean isFormFilled() {
        return !( criticismNameTextField.getText().equals("")
                || startDatePicker.getText().equals("")
                || ((int) countSpinner.getValue() == 0)
                || moneyTextField.getText().equals(""));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            if (isFormFilled()) {
                handleSubmitForm();
                clearFormData();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Hãy nhập thông tin trước!", "CẢNH BÁO", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == cancelButton) {
            if (isFormFilled()) {
                JOptionPane.showMessageDialog(this, "Bạn có muốn hủy!", "CẢNH BÁO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                clearFormData();
                dispose();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        startDatePicker = new com.github.lgooddatepicker.components.DatePicker();
        criticismIDLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        criticsimIDComboBox = new javax.swing.JComboBox<>();
        criticismNameLabel = new javax.swing.JLabel();
        employeeIDComboBox = new javax.swing.JComboBox<>();
        criticismNameTextField = new javax.swing.JTextField();
        startDatePickerLabel = new javax.swing.JLabel();
        countLabel = new javax.swing.JLabel();
        employeeIDLabel = new javax.swing.JLabel();
        countSpinner = new javax.swing.JSpinner();
        moneyLabel = new javax.swing.JLabel();
        moneyTextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        startDatePicker.setForeground(new java.awt.Color(0, 51, 51));
        startDatePicker.setName("startDatePicker"); // NOI18N

        criticismIDLabel.setLabelFor(criticsimIDComboBox);
        criticismIDLabel.setText("Mã Kỷ Luật :");
        criticismIDLabel.setBackground(new java.awt.Color(255, 255, 255));
        criticismIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        criticismIDLabel.setForeground(new java.awt.Color(0, 51, 51));
        criticismIDLabel.setName("criticismIDLabel"); // NOI18N
        criticismIDLabel.setOpaque(true);

        cancelButton.setText("Hủy Bỏ");
        cancelButton.setBackground(new java.awt.Color(108, 117, 125));
        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setOpaque(true);
        cancelButton.setToolTipText("cancelButton");

        criticsimIDComboBox.setEditable(true);
        criticsimIDComboBox.setBackground(new java.awt.Color(204, 204, 204));
        criticsimIDComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        criticsimIDComboBox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        criticsimIDComboBox.setForeground(new java.awt.Color(0, 51, 51));
        criticsimIDComboBox.setName("criticsimIDComboBox"); // NOI18N
        criticsimIDComboBox.setOpaque(true);

        criticismNameLabel.setLabelFor(criticismNameTextField);
        criticismNameLabel.setText("Tên Kỷ Luật :");
        criticismNameLabel.setBackground(new java.awt.Color(255, 255, 255));
        criticismNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        criticismNameLabel.setForeground(new java.awt.Color(0, 51, 51));
        criticismNameLabel.setName("criticismNameLabel"); // NOI18N
        criticismNameLabel.setOpaque(true);

        employeeIDComboBox.setEditable(true);
        employeeIDComboBox.setBackground(new java.awt.Color(204, 204, 204));
        employeeIDComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employeeIDComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        employeeIDComboBox.setForeground(new java.awt.Color(0, 51, 51));
        employeeIDComboBox.setName("employeeIDComboBox"); // NOI18N
        employeeIDComboBox.setOpaque(true);

        criticismNameTextField.setBackground(new java.awt.Color(204, 204, 204));
        criticismNameTextField.setEnabled(false);
        criticismNameTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        criticismNameTextField.setName("criticismNameTextField"); // NOI18N
        criticismNameTextField.setOpaque(true);

        startDatePickerLabel.setText("Ngày Tạo :");
        startDatePickerLabel.setBackground(new java.awt.Color(255, 255, 255));
        startDatePickerLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        startDatePickerLabel.setForeground(new java.awt.Color(0, 51, 51));
        startDatePickerLabel.setOpaque(true);
        startDatePickerLabel.setToolTipText("startDatePickerLabel");

        countLabel.setLabelFor(countSpinner);
        countLabel.setText("Số Lần :");
        countLabel.setBackground(new java.awt.Color(255, 255, 255));
        countLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        countLabel.setForeground(new java.awt.Color(0, 51, 51));
        countLabel.setName("countLabel"); // NOI18N
        countLabel.setOpaque(true);

        employeeIDLabel.setText("Mã Nhân Viên :");
        employeeIDLabel.setBackground(new java.awt.Color(255, 255, 255));
        employeeIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        employeeIDLabel.setForeground(new java.awt.Color(0, 51, 51));
        employeeIDLabel.setName("employeeIDLabel"); // NOI18N
        employeeIDLabel.setOpaque(true);

        countSpinner.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        countSpinner.setOpaque(true);

        moneyLabel.setText("Tiền Phạt :");
        moneyLabel.setBackground(new java.awt.Color(255, 255, 255));
        moneyLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        moneyLabel.setForeground(new java.awt.Color(0, 51, 51));
        moneyLabel.setName("moneyLabel"); // NOI18N
        moneyLabel.setOpaque(true);

        moneyTextField.setBackground(new java.awt.Color(204, 204, 204));
        moneyTextField.setEnabled(false);
        moneyTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        moneyTextField.setName("moneyTextField"); // NOI18N
        moneyTextField.setOpaque(true);

        addButton.setBackground(new java.awt.Color(25, 135, 84));
        addButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        addButton.setText("Thêm");
        addButton.setIconTextGap(10);
        addButton.setName("addButton"); // NOI18N

        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        updateButton.setText("Sửa");
        updateButton.setIconTextGap(10);
        updateButton.setName("updateButton"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(criticismIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(employeeIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(criticismNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(criticsimIDComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(employeeIDComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(criticismNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 3, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(startDatePickerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(countLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(moneyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(moneyTextField))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(countSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(employeeIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(criticismIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(criticsimIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(criticismNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(criticismNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDatePickerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(countLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(countSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(moneyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moneyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel countLabel;
    private javax.swing.JSpinner countSpinner;
    private javax.swing.JLabel criticismIDLabel;
    private javax.swing.JLabel criticismNameLabel;
    private javax.swing.JTextField criticismNameTextField;
    private javax.swing.JComboBox<String> criticsimIDComboBox;
    private javax.swing.JComboBox<String> employeeIDComboBox;
    private javax.swing.JLabel employeeIDLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel moneyLabel;
    private javax.swing.JTextField moneyTextField;
    private com.github.lgooddatepicker.components.DatePicker startDatePicker;
    private javax.swing.JLabel startDatePickerLabel;
    private javax.swing.JButton updateButton;
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
