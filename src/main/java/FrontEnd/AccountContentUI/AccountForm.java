package FrontEnd.AccountContentUI;


import BackEnd.AccountManagement.Account;
import BackEnd.AccountManagement.AccountBUS;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.function.Consumer;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AccountForm extends javax.swing.JFrame implements ActionListener, WindowListener {
    AccountBUS accountBUS = new AccountBUS();
    JFileChooser fileChooser;
    ArrayList<Object> formData;
    File selectedFile = null;
    String fileName = "";
    ImageIcon imageIcon = null;
    private Consumer<ArrayList<Object>> submitCallback;

    public void setSubmitCallback(Consumer<ArrayList<Object>>  callback) {
        this.submitCallback = callback;
    }

    public AccountForm() {
        initComponents();
        
        formData = new ArrayList<>();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        fileChooser = new JFileChooser();

        // Optional: Set a filter for specific file types
        // Replace IMAGE_EXTENSIONS with a list of supported image formats (adjust as
        // needed)
        String[] IMAGE_EXTENSIONS = new String[]{"jpg", "jpeg", "png", "gif", "bmp"};

        // Filter for image files
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image Files", IMAGE_EXTENSIONS);

        fileChooser.setFileFilter(imageFilter);

        deleteFileButton.setVisible(false);
        
        formInit();
        
        fileChooserButton.addActionListener(this);
        confirmButton.addActionListener(this);
        declineButton.addActionListener(this);
        addWindowListener(this);
    }
    public void formInit() {
        employeeIDTextField.setText(accountBUS.getNextID());
    }
    

    public ArrayList<Object> getDataFromForm() {
        String employeeID = employeeIDTextField.getText(),
                employeeName = employeeNameTextField.getText(),
                password = String.valueOf(passwordField.getPassword()),
                email = emailTextField.getText(),
                
                confirmPassword = String.valueOf(confirmPasswordField.getPassword()),
                selectedValue = "";
        
        Enumeration<AbstractButton> allRadioButton = buttonGroup1.getElements();
        while (allRadioButton.hasMoreElements()) {
            JRadioButton temp = (JRadioButton) allRadioButton.nextElement();
            if (temp.isSelected()) {
                selectedValue = temp.getName();
            }
        }
//        String qlnv =   employeeID + ' ' + employeeName +' '+ password+' ' + email +' '+confirmPassword+' '+selectedValue;
//        JOptionPane.showMessageDialog(this,qlnv , "CẢNH BÁO", JOptionPane.INFORMATION_MESSAGE);
        return new ArrayList<>(Arrays.asList( employeeID, employeeName, password, email,fileName,confirmPassword,
                selectedValue));
    }
    public void insertTableRow() {
        formData = getDataFromForm();

        int confirmation = JOptionPane.showConfirmDialog(this,
                "Bạn có muốn thêm mới dữ liệu với ID " + formData.get(1) + " ?",
                "THÊM MỚI ?",
                JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            accountBUS.addAccount(new Account((String) formData.get(0), (String) formData.get(1),(String) formData.get(2),(String) formData.get(3),(String) formData.get(4),(String) formData.get(6)));
            clearFormData();
            //jTable1.revalidate();
            //tableInit(accountBUS.getAccountList());
        }
    }
    
    public void handleSubmitForm() {
        formData = getDataFromForm();

        int confirmation = JOptionPane.showConfirmDialog(this,
                "Xác nhận thao tác ?",
                "XÁC NHẬN ?",
                JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            // Lấy dữ liệu từ form
            if (selectedFile != null) {
                // Save the selected file to the avatars folder
                File destinationFile = new File("src/main/resources/avatars/" + fileName);

                try {

                    System.out.println("Check destination file: " + destinationFile.getAbsolutePath());

                    Files.copy(selectedFile.toPath(), destinationFile.toPath(),
                            StandardCopyOption.REPLACE_EXISTING);

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
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

    public void showFormWithData(ArrayList<Object> data) {
        if (data != null) {
            //formSetEnable(false);
            // if (data.get(2) != null) {
            //// avatarLabel.setIcon(icon);
            // } else {
            // avatarLabel.setText("Không có ảnh");
            // }
            employeeIDTextField.setText((String) data.get(1));
            employeeNameTextField.setText((String) data.get(2));
            emailTextField.setText((String) data.get(3));
            if (data.get(4).equals("Admin")) {
                ButtonModel adminRadioButtonModel = adminRadioButton.getModel();
                buttonGroup1.setSelected(adminRadioButtonModel, true);
            } else {
                ButtonModel employeeRadioButtonModel = employeeRadioButton.getModel();
                buttonGroup1.setSelected(employeeRadioButtonModel, true);
            }
            
            
        }
    }

    public void clearFormData() {
        formInit();
        //formSetEnable(true);
        avatarLabel.setText("Không có tệp nào được chọn");
        avatarContainer.setIcon(null);
        emailTextField.setText("");
        employeeIDTextField.setEnabled(false);
        employeeNameTextField.setText("");
        ButtonModel adminRadioButtonModel = adminRadioButton.getModel();
        buttonGroup1.setSelected(adminRadioButtonModel, false);
        ButtonModel employeeRadioButtonModel = employeeRadioButton.getModel();
        buttonGroup1.setSelected(employeeRadioButtonModel, false);
    }

//    public void formSetEnable(boolean isEnable) {
//        //fileChooserButton.setEnabled(isEnable);
//        employeeIDComboBox.setEnabled(isEnable);
//        //employeeNameTextField.setEnabled(isEnable);
//        //emailTextField.setEnabled(isEnable);
//        //passwordField.setEnabled(isEnable);
//        //confirmPasswordField.setEnabled(isEnable);
//    }

    public boolean isFormFilled() {
        return !(employeeNameTextField.getText().equals("")
                || emailTextField.getText().equals("")
                || passwordField.getPassword().equals("")
                || confirmPasswordField.getPassword().equals("")
                || (!adminRadioButton.isSelected()
                && !employeeRadioButton.isSelected()));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fileChooserButton) {
            // Show the file chooser dialog
            int returnVal = fileChooser.showOpenDialog(null);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                // Get the selected file
                selectedFile = fileChooser.getSelectedFile();

                // Get the file name with extension
                fileName = selectedFile.getName();

                // Display the file name in a message box
                avatarLabel.setText(fileName);

                // Read the image file
                String imagePath = selectedFile.getAbsolutePath(); // Use absolute path instead of relative path
                imageIcon = new ImageIcon(imagePath);

                deleteFileButton.setVisible(true);

                // Set the image as the icon of avatarContainer
                avatarContainer.setIcon(imageIcon);
            }
        } else if (e.getSource() == confirmButton) {
             if (isFormFilled()) {
                if (submitCallback != null) {
                    ArrayList<Object> data = getDataFromForm();
                    JOptionPane.showMessageDialog(this, data, "CẢNH BÁO", JOptionPane.INFORMATION_MESSAGE);
                    submitCallback.accept(data);
                    dispose();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Hãy nhập đủ thông tin!", "CẢNH BÁO", JOptionPane.INFORMATION_MESSAGE);
            }
            }
         else if (e.getSource() == declineButton) {
            if (isFormFilled()) {
                cancelSubmitForm();
            } else {
                clearFormData();
                dispose();
            }
        } else if (e.getSource() == deleteFileButton) {
            selectedFile = null;
            fileName = "Không có tệp nào được chọn";
            imageIcon = null;
            avatarContainer.setIcon(null);
            deleteFileButton.setVisible(false);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        fileChooserPanel = new javax.swing.JPanel();
        fileChooserButton = new javax.swing.JButton();
        avatarLabel = new javax.swing.JLabel();
        employeeIDLabel = new javax.swing.JLabel();
        employeeNameLabel = new javax.swing.JLabel();
        employeeNameTextField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        confirmPasswordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        confirmPasswordField = new javax.swing.JPasswordField();
        authenticateLabel = new javax.swing.JLabel();
        adminRadioButton = new javax.swing.JRadioButton();
        employeeRadioButton = new javax.swing.JRadioButton();
        confirmButton = new javax.swing.JButton();
        declineButton = new javax.swing.JButton();
        avatarPanel = new javax.swing.JPanel();
        avatarContainer = new javax.swing.JLabel();
        deleteFileButton = new javax.swing.JButton();
        employeeIDTextField = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setLabelFor(fileChooserPanel);
        jLabel6.setText("Chọn Hình Ảnh :");

        fileChooserPanel.setBackground(new java.awt.Color(255, 255, 255));
        fileChooserPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        fileChooserPanel.setName("fileChooserPanel"); // NOI18N

        fileChooserButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        fileChooserButton.setForeground(new java.awt.Color(255, 255, 255));
        fileChooserButton.setText("Chọn tệp");
        fileChooserButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fileChooserButton.setName("fileChooserButton"); // NOI18N
        fileChooserButton.setPreferredSize(new java.awt.Dimension(91, 36));

        avatarLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        avatarLabel.setText("Không có tệp nào được chọn");
        avatarLabel.setName("avatarLabel"); // NOI18N

        javax.swing.GroupLayout fileChooserPanelLayout = new javax.swing.GroupLayout(fileChooserPanel);
        fileChooserPanel.setLayout(fileChooserPanelLayout);
        fileChooserPanelLayout.setHorizontalGroup(
            fileChooserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fileChooserPanelLayout.createSequentialGroup()
                .addComponent(fileChooserButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(avatarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
        );
        fileChooserPanelLayout.setVerticalGroup(
            fileChooserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(avatarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(fileChooserButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        employeeIDLabel.setBackground(new java.awt.Color(255, 255, 255));
        employeeIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        employeeIDLabel.setText("Mã Nhân Viên :");
        employeeIDLabel.setName("employeeIDLabel"); // NOI18N
        employeeIDLabel.setOpaque(true);

        employeeNameLabel.setBackground(new java.awt.Color(255, 255, 255));
        employeeNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        employeeNameLabel.setLabelFor(employeeNameTextField);
        employeeNameLabel.setText("Tên Nhân Viên :");
        employeeNameLabel.setName("employeeNameLabel"); // NOI18N
        employeeNameLabel.setOpaque(true);

        employeeNameTextField.setBackground(new java.awt.Color(204, 204, 204));
        employeeNameTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        employeeNameTextField.setName("employeeNameTextField"); // NOI18N
        employeeNameTextField.setOpaque(true);

        emailLabel.setBackground(new java.awt.Color(255, 255, 255));
        emailLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        emailLabel.setLabelFor(emailTextField);
        emailLabel.setText("Email :");
        emailLabel.setName("emailLabel"); // NOI18N
        emailLabel.setOpaque(true);

        emailTextField.setBackground(new java.awt.Color(204, 204, 204));
        emailTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emailTextField.setName("emailTextField"); // NOI18N
        emailTextField.setOpaque(true);

        passwordLabel.setBackground(new java.awt.Color(255, 255, 255));
        passwordLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        passwordLabel.setLabelFor(passwordField);
        passwordLabel.setText("Mật Khẩu :");
        passwordLabel.setName("passwordLabel"); // NOI18N
        passwordLabel.setOpaque(true);

        confirmPasswordLabel.setBackground(new java.awt.Color(255, 255, 255));
        confirmPasswordLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        confirmPasswordLabel.setLabelFor(confirmPasswordField);
        confirmPasswordLabel.setText("Xác Nhận Mật Khẩu :");
        confirmPasswordLabel.setName("confirmPasswordLabel"); // NOI18N
        confirmPasswordLabel.setOpaque(true);

        passwordField.setBackground(new java.awt.Color(204, 204, 204));
        passwordField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        passwordField.setName("passwordField"); // NOI18N
        passwordField.setOpaque(true);

        confirmPasswordField.setBackground(new java.awt.Color(204, 204, 204));
        confirmPasswordField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        confirmPasswordField.setName("confirmPasswordField"); // NOI18N
        confirmPasswordField.setOpaque(true);

        authenticateLabel.setBackground(new java.awt.Color(255, 255, 255));
        authenticateLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        authenticateLabel.setText("Phân Quyền :");
        authenticateLabel.setName("authenticateLabel"); // NOI18N
        authenticateLabel.setOpaque(true);

        adminRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(adminRadioButton);
        adminRadioButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        adminRadioButton.setText("Quản Trị");
        adminRadioButton.setIconTextGap(10);
        adminRadioButton.setName("admin"); // NOI18N
        adminRadioButton.setOpaque(true);

        employeeRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(employeeRadioButton);
        employeeRadioButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        employeeRadioButton.setText("Nhân Viên :");
        employeeRadioButton.setIconTextGap(10);
        employeeRadioButton.setName("employee"); // NOI18N
        employeeRadioButton.setOpaque(true);

        confirmButton.setBackground(new java.awt.Color(13, 110, 253));
        confirmButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        confirmButton.setForeground(new java.awt.Color(255, 255, 255));
        confirmButton.setText("Xác Nhận");
        confirmButton.setName("confirmButton"); // NOI18N
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        declineButton.setBackground(new java.awt.Color(108, 117, 125));
        declineButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        declineButton.setForeground(new java.awt.Color(255, 255, 255));
        declineButton.setText("Hủy Bỏ");
        declineButton.setName("declineButton"); // NOI18N

        avatarPanel.setBackground(new java.awt.Color(255, 255, 255));
        avatarPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        avatarPanel.setPreferredSize(new java.awt.Dimension(150, 150));

        avatarContainer.setBackground(new java.awt.Color(255, 255, 255));
        avatarContainer.setOpaque(true);
        avatarContainer.setPreferredSize(new java.awt.Dimension(136, 136));

        javax.swing.GroupLayout avatarPanelLayout = new javax.swing.GroupLayout(avatarPanel);
        avatarPanel.setLayout(avatarPanelLayout);
        avatarPanelLayout.setHorizontalGroup(
            avatarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(avatarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(avatarContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        avatarPanelLayout.setVerticalGroup(
            avatarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(avatarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(avatarContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        deleteFileButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteFileButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteFileButton.setText("Xóa Ảnh");
        deleteFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteFileButtonActionPerformed(evt);
            }
        });

        employeeIDTextField.setBackground(new java.awt.Color(204, 204, 204));
        employeeIDTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        employeeIDTextField.setName("employeeNameTextField"); // NOI18N
        employeeIDTextField.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(declineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(employeeIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(deleteFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(employeeIDTextField, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(fileChooserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(employeeNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(avatarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(employeeNameTextField)))
                            .addComponent(passwordField)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(confirmPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(authenticateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(adminRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(employeeRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(confirmPasswordField, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(avatarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(deleteFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileChooserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(employeeIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employeeNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(confirmPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(employeeRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adminRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(authenticateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(declineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(614, 781));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
       
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void deleteFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteFileButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteFileButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton adminRadioButton;
    private javax.swing.JLabel authenticateLabel;
    private javax.swing.JLabel avatarContainer;
    private javax.swing.JLabel avatarLabel;
    private javax.swing.JPanel avatarPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton confirmButton;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JLabel confirmPasswordLabel;
    private javax.swing.JButton declineButton;
    private javax.swing.JButton deleteFileButton;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel employeeIDLabel;
    private javax.swing.JTextField employeeIDTextField;
    private javax.swing.JLabel employeeNameLabel;
    private javax.swing.JTextField employeeNameTextField;
    private javax.swing.JRadioButton employeeRadioButton;
    private javax.swing.JButton fileChooserButton;
    private javax.swing.JPanel fileChooserPanel;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
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
