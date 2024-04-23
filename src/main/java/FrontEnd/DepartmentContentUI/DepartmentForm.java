package FrontEnd.DepartmentContentUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JRadioButton;
import BackEnd.DepartmentManagement.Department;
import BackEnd.DepartmentManagement.DepartmentBUS;
import javax.swing.DefaultComboBoxModel;
public class DepartmentForm extends javax.swing.JFrame implements ActionListener, WindowListener {
DepartmentBUS departmentBUS = new DepartmentBUS();
    public boolean btnconfirmClicked = false;
    ArrayList<Object> formData;

    public DepartmentForm() {
        initComponents();
        managerIDComboBox.addActionListener(this);
        formData = new ArrayList<>();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        confirmButton.addActionListener(this);
        cancelButton.addActionListener(this);
        formInit();
        initializeManagerComboBox();




        addWindowListener(this);
    }
 public void formInit() {
        departmentIDTextField.setText(departmentBUS.getNextID());
    }    
// Trong phương thức IntcomBobox()
  public void initializeManagerComboBox() {
        ArrayList<String> employeeIDsAndNames = departmentBUS.getAllEmployeeIDs();
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        for (String employeeIDAndName : employeeIDsAndNames) {
            comboBoxModel.addElement(employeeIDAndName);
        }
        managerIDComboBox.setModel(comboBoxModel);
        managerIDComboBox.addActionListener(this);
    }




    public void showFormWithData(ArrayList<Object> data) {
    if (data != null) {
        departmentIDTextField.setText((String) data.get(1));
        departmentNameTextField.setText((String) data.get(2));
        String managerID = (String) data.get(3);
        managerIDComboBox.setSelectedItem(managerID);

        // Lấy danh sách ID và tên của người quản lý
        ArrayList<String> employeeIDsAndNames = departmentBUS.getAllEmployeeIDs();
        // Tìm tên của người quản lý dựa trên ID
        String employeeName = null;
        for (String employeeIDAndName : employeeIDsAndNames) {
            String[] parts = employeeIDAndName.split(" - ");
            String employeeID = parts[0];
            if (employeeID.equals(managerID)) {
                employeeName = parts[1];
                break;
            }
        }
        // Hiển thị tên của người quản lý trong managerNameTextField
        if (employeeName != null) {
            managerNameTextField.setText(employeeName);
        } else {
            managerNameTextField.setText("");
        }
    }
}

    public void clearFormData() {
        departmentIDTextField.setText("");
        departmentNameTextField.setText("");
        managerIDComboBox.setSelectedItem("");
        managerNameTextField.setText("");
    }

  public boolean isFormFilled() {
        return !(departmentNameTextField.getText().isEmpty()
                || managerIDComboBox.getSelectedItem().toString().isEmpty()
                || managerNameTextField.getText().isEmpty());
    }

    public ArrayList<Object> getDataFromForm() {
        String departmentID = departmentIDTextField.getText();
        String departmentName = departmentNameTextField.getText();
        String managerID = managerIDComboBox.getSelectedItem().toString();
        String managerName = managerNameTextField.getText();
        return new ArrayList<>(Arrays.asList(departmentID, departmentName, managerID, managerName));
    }


    public void handleSubmitForm() {
        formData = getDataFromForm();

        int confirmation = JOptionPane.showConfirmDialog(this,
                "Xác nhận thao tác ?",
                "XÁC NHẬN ?",
                JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
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
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            if (isFormFilled()) {
                handleSubmitForm();
            } else {
                JOptionPane.showMessageDialog(this, "Hãy nhập thông tin trước!", "CẢNH BÁO", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == cancelButton) {
            if (isFormFilled()) {
                cancelSubmitForm();
            } else {
                clearFormData();
                dispose();
            }
        } else if (e.getSource() == managerIDComboBox) {
            String selectedEmployeeIDAndName = managerIDComboBox.getSelectedItem().toString();
            String[] parts = selectedEmployeeIDAndName.split(" - ");
            if (parts.length == 2) {
                managerNameTextField.setText(parts[1]);
            } else {
                managerNameTextField.setText("");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        departmentIDLabel = new javax.swing.JLabel();
        departmentNameTextField = new javax.swing.JTextField();
        managerIDLabel = new javax.swing.JLabel();
        departmentNameLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        confirmButton = new javax.swing.JButton();
        departmentIDTextField = new javax.swing.JTextField();
        managerNameLabel = new javax.swing.JLabel();
        managerNameTextField = new javax.swing.JTextField();
        managerIDComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("THÊM MỚI THÔNG TIN CÔNG TÁC CỦA NHÂN VIÊN");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 600));

        departmentIDLabel.setBackground(new java.awt.Color(255, 255, 255));
        departmentIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        departmentIDLabel.setLabelFor(departmentIDTextField);
        departmentIDLabel.setText("Mã Phòng Ban :");
        departmentIDLabel.setName("departmentIDLabel"); // NOI18N
        departmentIDLabel.setOpaque(true);

        departmentNameTextField.setBackground(new java.awt.Color(204, 204, 204));
        departmentNameTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        departmentNameTextField.setName("departmentNameTextField"); // NOI18N
        departmentNameTextField.setOpaque(true);

        managerIDLabel.setBackground(new java.awt.Color(255, 255, 255));
        managerIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        managerIDLabel.setLabelFor(managerIDComboBox);
        managerIDLabel.setText("Mã Người Quản Lý :");
        managerIDLabel.setName("managerIDLabel"); // NOI18N
        managerIDLabel.setOpaque(true);

        departmentNameLabel.setBackground(new java.awt.Color(255, 255, 255));
        departmentNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        departmentNameLabel.setLabelFor(departmentNameTextField);
        departmentNameLabel.setText("Tên Phòng Ban :");
        departmentNameLabel.setName("departmentNameLabel"); // NOI18N
        departmentNameLabel.setOpaque(true);

        cancelButton.setBackground(new java.awt.Color(108, 117, 125));
        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Hủy Bỏ");
        cancelButton.setToolTipText("cancelButton");
        cancelButton.setOpaque(true);

        confirmButton.setBackground(new java.awt.Color(13, 110, 253));
        confirmButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        confirmButton.setForeground(new java.awt.Color(255, 255, 255));
        confirmButton.setText("Xác Nhận");
        confirmButton.setName("confirmButton"); // NOI18N
        confirmButton.setOpaque(true);

        departmentIDTextField.setBackground(new java.awt.Color(204, 204, 204));
        departmentIDTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        departmentIDTextField.setOpaque(true);

        managerNameLabel.setBackground(new java.awt.Color(255, 255, 255));
        managerNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        managerNameLabel.setLabelFor(managerNameTextField);
        managerNameLabel.setText("Tên Người Quản Lý :");
        managerNameLabel.setName("managerIDLabel"); // NOI18N
        managerNameLabel.setOpaque(true);

        managerNameTextField.setBackground(new java.awt.Color(204, 204, 204));
        managerNameTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        managerNameTextField.setEnabled(false);
        managerNameTextField.setName("managerIDTextField"); // NOI18N
        managerNameTextField.setOpaque(true);

        managerIDComboBox.setBackground(new java.awt.Color(204, 204, 204));
        managerIDComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        managerIDComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managerIDComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(managerNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(managerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(managerIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(managerIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(departmentIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(departmentNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(departmentNameTextField)
                            .addComponent(departmentIDTextField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(departmentIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departmentIDTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departmentNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departmentNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(managerIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(managerIDComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(managerNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(managerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void managerIDComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managerIDComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_managerIDComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel departmentIDLabel;
    private javax.swing.JTextField departmentIDTextField;
    private javax.swing.JLabel departmentNameLabel;
    private javax.swing.JTextField departmentNameTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> managerIDComboBox;
    private javax.swing.JLabel managerIDLabel;
    private javax.swing.JLabel managerNameLabel;
    private javax.swing.JTextField managerNameTextField;
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
