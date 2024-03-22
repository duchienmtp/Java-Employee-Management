package FrontEnd.EmployeeContentUI;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UserInformationForm extends javax.swing.JFrame implements ActionListener {

    JFileChooser fileChooser;

    public UserInformationForm() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        DatePickerSettings pickerSettings = new DatePickerSettings();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        pickerSettings.setFormatForDatesCommonEra(dtf);
        birthdateDatePicker.setSettings(pickerSettings);
        birthdateDatePicker.setDateToToday();

        fileChooser = new JFileChooser();

        // Optional: Set a filter for specific file types
        // Replace IMAGE_EXTENSIONS with a list of supported image formats (adjust as needed)
        String[] IMAGE_EXTENSIONS = new String[]{"jpg", "jpeg", "png", "gif", "bmp"};

        // Filter for image files
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image Files", IMAGE_EXTENSIONS);

        fileChooser.setFileFilter(imageFilter);

        fileChooserButton.addActionListener(this);
//        birthdateDatePicker.addDateChangeListener(this);
        confirmButton.addActionListener(this);
        declineButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fileChooserButton) {
            // Show the file chooser dialog
            int returnVal = fileChooser.showOpenDialog(null);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                // Get the selected file
                java.io.File selectedFile = fileChooser.getSelectedFile();

                // Get the file name with extension
                String fileName = selectedFile.getName();

                // Display the file name in a message box
                JOptionPane.showMessageDialog(this, "Selected file: " + fileName,
                        "File Selected", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == confirmButton) {
            dispose();
        } else if (e.getSource() == declineButton) {
            dispose();
        }
    }

    public void showFormWithData(ArrayList<Object> data) {
        if (data != null) {
            employeeNameTextField.setText((String) data.get(2));
            if (data.get(2) != null) {
//                avatarLabel.setIcon(icon);
            } else {
                avatarLabel.setText("Không có ảnh");
            }
            genderComboBox.setSelectedItem(data.get(3));
            birthdateDatePicker.setText((String) data.get(4));
            phoneNumberTextField.setText("");
            ethicGroupComboBox.setSelectedItem("");
            religionComboBox.setSelectedItem("");
            nationComboBox.setSelectedItem("");
            specialtyComboBox.setSelectedItem("");
            degreeComboBox.setSelectedItem("");
            positionComboBox.setSelectedItem(data.get(5));
            employeeTypeComboBox.setSelectedItem(data.get(6));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        employeeNameLabel = new javax.swing.JLabel();
        employeeNameTextField = new javax.swing.JTextField();
        avatarLabel = new javax.swing.JLabel();
        fileChooserPanel = new javax.swing.JPanel();
        fileChooserButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        genderComboBox = new javax.swing.JComboBox<>();
        birthdateLabel = new javax.swing.JLabel();
        phoneNumberLabel = new javax.swing.JLabel();
        phoneNumberTextField = new javax.swing.JTextField();
        ethicGroupLabel = new javax.swing.JLabel();
        ethicGroupComboBox = new javax.swing.JComboBox<>();
        religionLabel = new javax.swing.JLabel();
        religionComboBox = new javax.swing.JComboBox<>();
        nationLabel = new javax.swing.JLabel();
        nationComboBox = new javax.swing.JComboBox<>();
        degreeLabel = new javax.swing.JLabel();
        degreeComboBox = new javax.swing.JComboBox<>();
        positionLabel = new javax.swing.JLabel();
        specialtyLabel = new javax.swing.JLabel();
        specialtyComboBox = new javax.swing.JComboBox<>();
        positionComboBox = new javax.swing.JComboBox<>();
        employeeTypeLabel = new javax.swing.JLabel();
        employeeTypeComboBox = new javax.swing.JComboBox<>();
        confirmButton = new javax.swing.JButton();
        declineButton = new javax.swing.JButton();
        birthdateDatePicker = new com.github.lgooddatepicker.components.DatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("THÊM MỚI");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        employeeNameLabel.setLabelFor(employeeNameTextField);
        employeeNameLabel.setText("Họ và Tên :");
        employeeNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        employeeNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        employeeNameLabel.setName("employeeNameLabel"); // NOI18N

        employeeNameTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        employeeNameTextField.setBackground(new java.awt.Color(204, 204, 204));
        employeeNameTextField.setCaretColor(new java.awt.Color(0, 0, 0));
        employeeNameTextField.setForeground(new java.awt.Color(0, 0, 0));
        employeeNameTextField.setHighlighter(null);
        employeeNameTextField.setName("employeeNameTextField"); // NOI18N

        avatarLabel.setLabelFor(fileChooserPanel);
        avatarLabel.setText("Ảnh đại diện (Nếu có) :");
        avatarLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        avatarLabel.setForeground(new java.awt.Color(0, 0, 0));
        avatarLabel.setName("avatarLabel"); // NOI18N

        fileChooserPanel.setBackground(new java.awt.Color(255, 255, 255));
        fileChooserPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        fileChooserPanel.setName("fileChooserPanel"); // NOI18N

        fileChooserButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        fileChooserButton.setForeground(new java.awt.Color(255, 255, 255));
        fileChooserButton.setText("Chọn tệp");
        fileChooserButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fileChooserButton.setName("fileChooserButton"); // NOI18N

        jLabel1.setText("Không có tệp nào được chọn");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout fileChooserPanelLayout = new javax.swing.GroupLayout(fileChooserPanel);
        fileChooserPanel.setLayout(fileChooserPanelLayout);
        fileChooserPanelLayout.setHorizontalGroup(
            fileChooserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fileChooserPanelLayout.createSequentialGroup()
                .addComponent(fileChooserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
        );
        fileChooserPanelLayout.setVerticalGroup(
            fileChooserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(fileChooserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        genderLabel.setLabelFor(genderComboBox);
        genderLabel.setText("Giới Tính :");
        genderLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        genderLabel.setForeground(new java.awt.Color(0, 0, 0));
        genderLabel.setName("genderLabel"); // NOI18N

        genderComboBox.setBackground(new java.awt.Color(204, 204, 204));
        genderComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        genderComboBox.setForeground(new java.awt.Color(0, 0, 0));
        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam ", "Nữ", " " }));
        genderComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        genderComboBox.setName("genderComboBox"); // NOI18N

        birthdateLabel.setLabelFor(birthdateDatePicker);
        birthdateLabel.setText("Ngày Sinh :");
        birthdateLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        birthdateLabel.setForeground(new java.awt.Color(0, 0, 0));
        birthdateLabel.setName("birthdateLabel"); // NOI18N

        phoneNumberLabel.setLabelFor(phoneNumberTextField);
        phoneNumberLabel.setText("Số Điện Thoại :");
        phoneNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        phoneNumberLabel.setForeground(new java.awt.Color(0, 0, 0));
        phoneNumberLabel.setName("phoneNumberLabel"); // NOI18N

        phoneNumberTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        phoneNumberTextField.setBackground(new java.awt.Color(204, 204, 204));
        phoneNumberTextField.setCaretColor(new java.awt.Color(0, 0, 0));
        phoneNumberTextField.setForeground(new java.awt.Color(0, 0, 0));
        phoneNumberTextField.setName("phoneNumberTextField"); // NOI18N
        phoneNumberTextField.setPreferredSize(new java.awt.Dimension(230, 26));

        ethicGroupLabel.setLabelFor(ethicGroupComboBox);
        ethicGroupLabel.setText("Dân Tộc :");
        ethicGroupLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ethicGroupLabel.setForeground(new java.awt.Color(0, 0, 0));
        ethicGroupLabel.setName("ethicGroupLabel"); // NOI18N

        ethicGroupComboBox.setBackground(new java.awt.Color(204, 204, 204));
        ethicGroupComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ethicGroupComboBox.setForeground(new java.awt.Color(0, 0, 0));
        ethicGroupComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kinh", "Tày", "Mường" }));
        ethicGroupComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ethicGroupComboBox.setName("ethicGroupComboBox"); // NOI18N
        ethicGroupComboBox.setPreferredSize(new java.awt.Dimension(200, 40));

        religionLabel.setLabelFor(religionComboBox);
        religionLabel.setText("Tôn giáo :");
        religionLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        religionLabel.setForeground(new java.awt.Color(0, 0, 0));
        religionLabel.setName("religionLabel"); // NOI18N

        religionComboBox.setBackground(new java.awt.Color(204, 204, 204));
        religionComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        religionComboBox.setForeground(new java.awt.Color(0, 0, 0));
        religionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phật Giáo", "Thiên Chúa Giáo", "Công Giáo" }));
        religionComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        religionComboBox.setName("religionComboBox"); // NOI18N

        nationLabel.setLabelFor(nationComboBox);
        nationLabel.setText("Quốc Tịch :");
        nationLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nationLabel.setForeground(new java.awt.Color(0, 0, 0));
        nationLabel.setName("nationLabel"); // NOI18N

        nationComboBox.setBackground(new java.awt.Color(204, 204, 204));
        nationComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nationComboBox.setForeground(new java.awt.Color(0, 0, 0));
        nationComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Việt Nam", "Hoa Kỳ", "Canada", "Nhật Bản", "Hàn Quốc", " " }));
        nationComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nationComboBox.setName("nationComboBox"); // NOI18N

        degreeLabel.setLabelFor(degreeComboBox);
        degreeLabel.setText("Bằng Cấp :");
        degreeLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        degreeLabel.setForeground(new java.awt.Color(0, 0, 0));
        degreeLabel.setName("degreeLabel"); // NOI18N

        degreeComboBox.setBackground(new java.awt.Color(204, 204, 204));
        degreeComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        degreeComboBox.setForeground(new java.awt.Color(0, 0, 0));
        degreeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bằng Cử Nhân", "Bằng Kỹ Sư", "Bằng Thạc Sĩ", "Bằng Tiến Sĩ", " " }));
        degreeComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        degreeComboBox.setName("degreeComboBox"); // NOI18N

        positionLabel.setLabelFor(positionComboBox);
        positionLabel.setText("Chức vụ :");
        positionLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        positionLabel.setForeground(new java.awt.Color(0, 0, 0));
        positionLabel.setName("positionLabel"); // NOI18N

        specialtyLabel.setLabelFor(specialtyComboBox);
        specialtyLabel.setText("Chuyên Môn :");
        specialtyLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        specialtyLabel.setForeground(new java.awt.Color(0, 0, 0));
        specialtyLabel.setName("specialtyLabel"); // NOI18N

        specialtyComboBox.setBackground(new java.awt.Color(204, 204, 204));
        specialtyComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        specialtyComboBox.setForeground(new java.awt.Color(0, 0, 0));
        specialtyComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kế Toán", "Lập Trình Viên", "Quản Lý Dự Án", "Quản Lý Nhân Sự", "Phân Tích Dữ Liệu Doanh Nghiệp", "Designer" }));
        specialtyComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        specialtyComboBox.setName("specialtyComboBox"); // NOI18N

        positionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân Viên", "Phó Phòng", "Trưởng Phòng", "Thư Ký", "Phó Giám Đốc", "Tổng Giám Đốc" }));
        positionComboBox.setBackground(new java.awt.Color(204, 204, 204));
        positionComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        positionComboBox.setForeground(new java.awt.Color(0, 0, 0));
        positionComboBox.setName("positionComboBox"); // NOI18N

        employeeTypeLabel.setLabelFor(employeeTypeComboBox);
        employeeTypeLabel.setText("Loại Nhân Viên :");
        employeeTypeLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        employeeTypeLabel.setForeground(new java.awt.Color(0, 0, 0));
        employeeTypeLabel.setName("employeeTypeLabel"); // NOI18N

        employeeTypeComboBox.setBackground(new java.awt.Color(204, 204, 204));
        employeeTypeComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        employeeTypeComboBox.setForeground(new java.awt.Color(0, 0, 0));
        employeeTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân Viên Chính Thức", "Nhân Viên Bán Thời Gian", "Thực Tập Sinh", " " }));
        employeeTypeComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employeeTypeComboBox.setName("employeeTypeComboBox"); // NOI18N

        confirmButton.setText("Xác Nhận");
        confirmButton.setBackground(new java.awt.Color(13, 110, 253));
        confirmButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        confirmButton.setForeground(new java.awt.Color(255, 255, 255));
        confirmButton.setName("confirmButton"); // NOI18N

        declineButton.setText("Hủy Bỏ");
        declineButton.setBackground(new java.awt.Color(108, 117, 125));
        declineButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        declineButton.setForeground(new java.awt.Color(255, 255, 255));
        declineButton.setName("declineButton"); // NOI18N

        birthdateDatePicker.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        birthdateDatePicker.setForeground(new java.awt.Color(0, 0, 0));
        birthdateDatePicker.setName("birthdateDatePicker"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(religionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(religionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(degreeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(birthdateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(degreeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(positionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(nationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(nationComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(positionComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(birthdateDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(phoneNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(phoneNumberTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(specialtyComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ethicGroupComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(employeeTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addComponent(declineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(specialtyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ethicGroupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(employeeTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(avatarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(employeeNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(employeeNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(283, 283, 283)
                                .addComponent(fileChooserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeNameLabel)
                    .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(avatarLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(employeeNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fileChooserPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthdateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phoneNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ethicGroupLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(birthdateDatePicker, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(phoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ethicGroupComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(religionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(specialtyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(religionComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(nationComboBox)
                    .addComponent(specialtyComboBox))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(positionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(degreeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employeeTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(degreeComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(positionComboBox)
                    .addComponent(employeeTypeComboBox))
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(declineButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatarLabel;
    private com.github.lgooddatepicker.components.DatePicker birthdateDatePicker;
    private javax.swing.JLabel birthdateLabel;
    private javax.swing.JButton confirmButton;
    private javax.swing.JButton declineButton;
    private javax.swing.JComboBox<String> degreeComboBox;
    private javax.swing.JLabel degreeLabel;
    private javax.swing.JLabel employeeNameLabel;
    private javax.swing.JTextField employeeNameTextField;
    private javax.swing.JComboBox<String> employeeTypeComboBox;
    private javax.swing.JLabel employeeTypeLabel;
    private javax.swing.JComboBox<String> ethicGroupComboBox;
    private javax.swing.JLabel ethicGroupLabel;
    private javax.swing.JButton fileChooserButton;
    private javax.swing.JPanel fileChooserPanel;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> nationComboBox;
    private javax.swing.JLabel nationLabel;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JTextField phoneNumberTextField;
    private javax.swing.JComboBox<String> positionComboBox;
    private javax.swing.JLabel positionLabel;
    private javax.swing.JComboBox<String> religionComboBox;
    private javax.swing.JLabel religionLabel;
    private javax.swing.JComboBox<String> specialtyComboBox;
    private javax.swing.JLabel specialtyLabel;
    // End of variables declaration//GEN-END:variables

//    @Override
//    public void dateChanged(DateChangeEvent dce) {
//        LocalDate localDate = birthdateDatePicker.getDate();
//        if (localDate != null) {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//            String formattedDate = localDate.format(formatter); // Use format() on the date
//            birthdateDatePicker.setText(formattedDate); // Set the displayed text
//        }
//    }
}
