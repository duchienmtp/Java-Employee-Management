package FrontEnd.RewardContentUI;

import com.github.lgooddatepicker.components.DatePickerSettings;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class RewardEmployeeForm extends javax.swing.JFrame implements ActionListener, WindowListener {

    public RewardEmployeeForm() {
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

        confirmButton.addActionListener(this);
        cancelButton.addActionListener(this);

        addWindowListener(this);
    }

    public void showFormWithData(ArrayList<Object> data) {
        if (data != null) {
            employeeIDComboBox.setSelectedItem(data.get(1));
            employeeNameTextField.setText((String) data.get(2));
            rewardIDComboBox.setSelectedItem(data.get(3));
            rewardNameTextField.setText((String) data.get(4));
            countSpinner.setValue(data.get(5));
            moneyTextField.setText(Integer.toString((int) data.get(6)));
            startDatePicker.setText((String) data.get(7));
        }
    }

    public void clearFormData() {
        employeeIDComboBox.setSelectedItem("");
        employeeNameTextField.setText("");
        rewardIDComboBox.setSelectedItem("");
        rewardNameTextField.setText("");
        countSpinner.setValue("");
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
        return !(employeeNameTextField.getText().equals("")
                || rewardNameTextField.getText().equals("")
                || startDatePicker.getText().equals("")
                || ((int) countSpinner.getValue() == 0)
                || moneyTextField.getText().equals(""));
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
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
        employeeNameTextField = new javax.swing.JTextField();
        rewardIDLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        rewardIDComboBox = new javax.swing.JComboBox<>();
        confirmButton = new javax.swing.JButton();
        rewardNameLabel = new javax.swing.JLabel();
        employeeIDComboBox = new javax.swing.JComboBox<>();
        employeeNameLabel = new javax.swing.JLabel();
        rewardNameTextField = new javax.swing.JTextField();
        startDatePickerLabel = new javax.swing.JLabel();
        countLabel = new javax.swing.JLabel();
        employeeIDLabel = new javax.swing.JLabel();
        countSpinner = new javax.swing.JSpinner();
        moneyLabel = new javax.swing.JLabel();
        moneyTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        startDatePicker.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        startDatePicker.setForeground(new java.awt.Color(0, 0, 0));
        startDatePicker.setName("startDatePicker"); // NOI18N

        employeeNameTextField.setBackground(new java.awt.Color(204, 204, 204));
        employeeNameTextField.setEnabled(false);
        employeeNameTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        employeeNameTextField.setForeground(new java.awt.Color(0, 0, 0));
        employeeNameTextField.setName("employeeNameTextField"); // NOI18N
        employeeNameTextField.setOpaque(true);

        rewardIDLabel.setLabelFor(rewardIDComboBox);
        rewardIDLabel.setText("Mã Khen Thưởng :");
        rewardIDLabel.setBackground(new java.awt.Color(255, 255, 255));
        rewardIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rewardIDLabel.setForeground(new java.awt.Color(0, 0, 0));
        rewardIDLabel.setName("rewardIDLabel"); // NOI18N
        rewardIDLabel.setOpaque(true);

        cancelButton.setText("Hủy Bỏ");
        cancelButton.setBackground(new java.awt.Color(108, 117, 125));
        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setOpaque(true);
        cancelButton.setToolTipText("cancelButton");

        rewardIDComboBox.setEditable(true);
        rewardIDComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        rewardIDComboBox.setBackground(new java.awt.Color(204, 204, 204));
        rewardIDComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rewardIDComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rewardIDComboBox.setForeground(new java.awt.Color(0, 0, 0));
        rewardIDComboBox.setName("rewardIDComboBox"); // NOI18N
        rewardIDComboBox.setOpaque(true);

        confirmButton.setText("Xác Nhận");
        confirmButton.setBackground(new java.awt.Color(13, 110, 253));
        confirmButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        confirmButton.setForeground(new java.awt.Color(255, 255, 255));
        confirmButton.setName("confirmButton"); // NOI18N
        confirmButton.setOpaque(true);

        rewardNameLabel.setLabelFor(rewardNameTextField);
        rewardNameLabel.setText("Tên Khen Thưởng :");
        rewardNameLabel.setBackground(new java.awt.Color(255, 255, 255));
        rewardNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rewardNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        rewardNameLabel.setName("rewardNameLabel"); // NOI18N
        rewardNameLabel.setOpaque(true);

        employeeIDComboBox.setEditable(true);
        employeeIDComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C++", "Database", "Java", "Python", "TypeScripts" }));
        employeeIDComboBox.setBackground(new java.awt.Color(204, 204, 204));
        employeeIDComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employeeIDComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        employeeIDComboBox.setForeground(new java.awt.Color(0, 0, 0));
        employeeIDComboBox.setName("employeeIDComboBox"); // NOI18N
        employeeIDComboBox.setOpaque(true);

        employeeNameLabel.setText("Tên Nhân Viên :");
        employeeNameLabel.setBackground(new java.awt.Color(255, 255, 255));
        employeeNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        employeeNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        employeeNameLabel.setName("employeeNameLabel"); // NOI18N
        employeeNameLabel.setOpaque(true);

        rewardNameTextField.setBackground(new java.awt.Color(204, 204, 204));
        rewardNameTextField.setEnabled(false);
        rewardNameTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rewardNameTextField.setForeground(new java.awt.Color(0, 0, 0));
        rewardNameTextField.setName("rewardNameTextField"); // NOI18N
        rewardNameTextField.setOpaque(true);

        startDatePickerLabel.setText("Ngày Tạo :");
        startDatePickerLabel.setBackground(new java.awt.Color(255, 255, 255));
        startDatePickerLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        startDatePickerLabel.setForeground(new java.awt.Color(0, 0, 0));
        startDatePickerLabel.setOpaque(true);
        startDatePickerLabel.setToolTipText("startDatePickerLabel");

        countLabel.setLabelFor(countSpinner);
        countLabel.setText("Số Lần :");
        countLabel.setBackground(new java.awt.Color(255, 255, 255));
        countLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        countLabel.setForeground(new java.awt.Color(0, 0, 0));
        countLabel.setName("countLabel"); // NOI18N
        countLabel.setOpaque(true);

        employeeIDLabel.setText("Mã Nhân Viên :");
        employeeIDLabel.setBackground(new java.awt.Color(255, 255, 255));
        employeeIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        employeeIDLabel.setForeground(new java.awt.Color(0, 0, 0));
        employeeIDLabel.setName("employeeIDLabel"); // NOI18N
        employeeIDLabel.setOpaque(true);

        countSpinner.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        countSpinner.setOpaque(true);

        moneyLabel.setText("Tiền Thưởng :");
        moneyLabel.setBackground(new java.awt.Color(255, 255, 255));
        moneyLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        moneyLabel.setForeground(new java.awt.Color(0, 0, 0));
        moneyLabel.setName("moneyLabel"); // NOI18N
        moneyLabel.setOpaque(true);

        moneyTextField.setBackground(new java.awt.Color(204, 204, 204));
        moneyTextField.setEnabled(false);
        moneyTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        moneyTextField.setForeground(new java.awt.Color(0, 0, 0));
        moneyTextField.setName("moneyTextField"); // NOI18N
        moneyTextField.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rewardNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(rewardNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rewardIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(employeeIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(employeeNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(employeeNameTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rewardIDComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(employeeIDComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(startDatePickerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(countLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(countSpinner)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(moneyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(moneyTextField)))))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(employeeIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rewardIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rewardIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rewardNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rewardNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDatePickerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(countLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(countSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(moneyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moneyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel countLabel;
    private javax.swing.JSpinner countSpinner;
    private javax.swing.JComboBox<String> employeeIDComboBox;
    private javax.swing.JLabel employeeIDLabel;
    private javax.swing.JLabel employeeNameLabel;
    private javax.swing.JTextField employeeNameTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel moneyLabel;
    private javax.swing.JTextField moneyTextField;
    private javax.swing.JComboBox<String> rewardIDComboBox;
    private javax.swing.JLabel rewardIDLabel;
    private javax.swing.JLabel rewardNameLabel;
    private javax.swing.JTextField rewardNameTextField;
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
