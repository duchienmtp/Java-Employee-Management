package FrontEnd.AccountContentUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BackEnd.AccountManagement.Account;
import FrontEnd.Redux.Redux;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class AccountManagementContentPanel extends javax.swing.JPanel
        implements MouseListener, ActionListener, ListSelectionListener {

    AccountForm accountForm;
    int selectedRow = -1;
    Object[] selectedRowData;
    // ArrayList<Object> formData;
    boolean selectionConfirmed;

    public AccountManagementContentPanel() {
        initComponents();

        // formData = new ArrayList<>();
        // Đăng ký listener cho các nút
        addButton.addActionListener(this);
        editButton.addActionListener(this);
        deleteButton.addActionListener(this);

        // Đặt callback cho AccountForm
        // accountForm.setSubmitCallback(this::onFormSubmit);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1), // Line color and stroke size
                "Tìm kiếm",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("Segoe UI", Font.PLAIN, 12),
                Color.BLACK // Text color
        );
        jPanel1.setBorder(titledBorder);

        tableLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable1.setDefaultRenderer(String.class, centerRenderer);
        jTable1.setDefaultRenderer(Integer.class, centerRenderer);

        // tableInit(Redux.accountList);
        tableInit(Redux.accountBUS.getAccountList());
        jTable1.getSelectionModel().addListSelectionListener(this);
        jPanel1.addMouseListener(this);
        addMouseListener(this);

        setVisible(true);
    }

    // public static void tableInit(ArrayList<Account> accountList) {
    // DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    // model.setRowCount(0);
    //
    // for (int i = 0; i < accountList.size(); i++) {
    // Account account = accountList.get(i);
    // model.addRow(new Object[] {
    // i + 1,
    // account.getEmployee().getId(),
    // account.getUsername(),
    // account.getEmail(),
    // account.getAuthorization().equalsIgnoreCase("admin") ? "Quản Trị Viên" :
    // "Nhân Viên",
    // account.getAccountStatus() ? "Đang hoạt động" : "Ngừng hoạt động"
    // });
    // }
    // }
    public static void tableInit(ArrayList<Account> accountBUS) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        for (int i = 0; i < accountBUS.size(); i++) {
            model.addRow(new Object[] {
                    i + 1,
                    accountBUS.get(i).getEmployee().getId(),
                    accountBUS.get(i).getUsername(),
                    accountBUS.get(i).getEmail(),
                    accountBUS.get(i).getAuthorization().equalsIgnoreCase("admin") ? "Quản Trị Viên" : "Nhân Viên",
                    accountBUS.get(i).getAccountStatus() ? "Đang hoạt động" : "Ngừng hoạt động"
            });
        }
    }

    // private void onFormSubmit(ArrayList<Object> data) {
    // Account newAccount = new Account(
    // (String) data.get(0), // ID
    // (String) data.get(1), // Tên nhân viên
    // (String) data.get(2), // Mật khẩu
    // (String) data.get(3), // Email
    // (String) data.get(4), // Tệp avatar
    // (String) data.get(6) // Vai trò
    // );
    // // JOptionPane.showMessageDialog(this,newAccount.getUsername() , "CẢNH BÁO
    // 11",
    // // JOptionPane.INFORMATION_MESSAGE);
    // accountBUS.addAccount(newAccount); // Thêm vào dữ liệu\
    //
    // updateTable(); // Cập nhật bảng sau khi thêm dữ liệu
    // }
    public void insertTableRow() {
        accountForm = new AccountForm();
        accountForm.setTitle("THÊM MỚI THÔNG TIN CÁ NHÂN CỦA NHÂN VIÊN");
        accountForm.setVisible(true);
    }
    // Phương pháp cập nhật bảng
    // private void updateTable() {
    // DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    // model.setRowCount(0);
    // ArrayList<Account> accountList = accountBUS.getAccountList();
    // for (int i = 0; i < accountList.size(); i++) {
    // Account account = accountList.get(i);
    // model.addRow(new Object[] {
    // i + 1,
    // account.getEmployee().getId(),
    // account.getUsername(),
    // account.getEmail(),
    // account.getAuthorization()
    // });
    // }
    // }

    public void updateTableRow() {
        Account selectedAccount = Redux.accountBUS.getAccountById((String) selectedRowData[1]);
        List<Object> accountPropertiesValue = selectedAccount.toList();
        // Create a new ArrayList
        ArrayList<Object> dataList = new ArrayList<>();

        // Add all elements from the array to the ArrayList
        dataList.addAll(accountPropertiesValue);
        accountForm = new AccountForm();
        accountForm.setTitle("CẬP NHẬT THÔNG TIN TÀI KHOẢN CỦA NHÂN VIÊN");
        accountForm.setVisible(true);
        accountForm.showFormWithData(dataList);

    }

    // public void deleteTableRow(int selectedRow, String employeeID) {
    //
    // DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    // int confirmation = JOptionPane.showConfirmDialog(this,
    // "Bạn có muốn xóa bỏ nhân viên với ID " + employeeID + " ?",
    // "XÓA BỎ ?",
    // JOptionPane.YES_NO_OPTION);
    //
    // if (confirmation == JOptionPane.YES_OPTION) {
    // model.removeRow(selectedRow);
    // jTable1.revalidate();
    // }
    // }
    public void deleteTableRow() {
        int confirmation = JOptionPane.showConfirmDialog(this,
                "Bạn có muốn xóa bỏ nhân viên với ID " + selectedRowData[1] + " ?",
                "XÓA BỎ ?",
                JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            Redux.accountBUS.deleteAccount(Redux.accountBUS.getAccountById((String) selectedRowData[1]));
            jTable1.revalidate();
            tableInit(Redux.accountBUS.getAccountList());
        }
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
                addButton.setEnabled(false);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // String employeeID = "";
        // if (selectedRowData != null) {
        // employeeID = (String) selectedRowData[1];
        // }
        // if (e.getSource() == addButton) {
        // accountForm.clearFormData();
        // accountForm.setTitle("THÊM MỚI TÀI KHOẢN NHÂN VIÊN");
        // accountForm.setVisible(true);
        // } else if (e.getSource() == deleteButton) {
        // if (selectedRow >= 0) {
        // deleteTableRow(selectedRow, employeeID);
        // } else {
        // JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng trước!", "CẢNH BÁO",
        // JOptionPane.INFORMATION_MESSAGE);
        // }
        // } else if (e.getSource() == editButton) {
        // if (selectedRow >= 0) {
        // updateTableRow(selectedRowData, employeeID);
        // accountForm.setVisible(true);
        // } else {
        // JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng trước!", "CẢNH BÁO",
        // JOptionPane.INFORMATION_MESSAGE);
        // }
        // } else if (e.getSource() == importExcel) {
        //
        // } else if (e.getSource() == exportExcel) {
        //
        // }
        if (e.getSource() == addButton) {
            insertTableRow();
        } else if (e.getSource() == deleteButton) {
            if (selectedRow >= 0) {
                deleteTableRow();
            } else {
                JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng trước!", "CẢNH BÁO",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == editButton) {
            if (selectedRow >= 0) {
                updateTableRow();
            } else {
                JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng trước!", "CẢNH BÁO",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == importExcel) {

        } else if (e.getSource() == exportExcel) {

        }
        addButton.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableContainer = new javax.swing.JPanel();
        tableLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        importExcel = new javax.swing.JButton();
        exportExcel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        searchOptionComboBox = new javax.swing.JComboBox<>();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();

        setBackground(java.awt.Color.white);
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);

        tableContainer.setBackground(new java.awt.Color(255, 255, 255));
        tableContainer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tableContainer.setName("tableContainer"); // NOI18N
        tableContainer.setPreferredSize(new java.awt.Dimension(863, 364));

        tableLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tableLabel.setForeground(new java.awt.Color(0, 0, 0));
        tableLabel.setText("Danh sách tài khoản của nhân viên");
        tableLabel.setName("tableLabel"); // NOI18N

        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "STT", "Mã Nhân Viên", "Tên Nhân Viên", "Email", "Phân Quyền", "Trạng Thái"
                }) {
            Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class,
                    java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTable1.setRowHeight(40);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout tableContainerLayout = new javax.swing.GroupLayout(tableContainer);
        tableContainer.setLayout(tableContainerLayout);
        tableContainerLayout.setHorizontalGroup(
                tableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tableContainerLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(tableLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
                                .addGap(25, 25, 25))
                        .addGroup(tableContainerLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                                .addContainerGap()));
        tableContainerLayout.setVerticalGroup(
                tableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tableContainerLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tableLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(21, Short.MAX_VALUE)));

        addButton.setBackground(new java.awt.Color(25, 135, 84));
        addButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        addButton.setText("Thêm");
        addButton.setIconTextGap(10);
        addButton.setName("addButton"); // NOI18N

        deleteButton.setBackground(new java.awt.Color(220, 53, 69));
        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        deleteButton.setText("Xóa");
        deleteButton.setIconTextGap(10);
        deleteButton.setName("deleteButton"); // NOI18N

        editButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        editButton.setText("Sửa");
        editButton.setIconTextGap(10);
        editButton.setName("editButton"); // NOI18N

        importExcel.setBackground(new java.awt.Color(13, 110, 253));
        importExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        importExcel.setForeground(new java.awt.Color(255, 255, 255));
        importExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excel.png"))); // NOI18N
        importExcel.setText("Nhập ");
        importExcel.setIconTextGap(10);
        importExcel.setName("importExcel"); // NOI18N

        exportExcel.setBackground(new java.awt.Color(13, 202, 240));
        exportExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        exportExcel.setForeground(new java.awt.Color(255, 255, 255));
        exportExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excel.png"))); // NOI18N
        exportExcel.setText("Xuất");
        exportExcel.setIconTextGap(10);
        exportExcel.setName("exportExcel"); // NOI18N
        exportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportExcelActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        searchOptionComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        searchOptionComboBox.setForeground(new java.awt.Color(255, 255, 255));
        searchOptionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo Tên", "Theo Mã" }));
        searchOptionComboBox.setName("searchOptionComboBox"); // NOI18N
        searchOptionComboBox.setOpaque(true);

        searchTextField.setBackground(new java.awt.Color(204, 204, 204));
        searchTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        searchTextField.setForeground(new java.awt.Color(0, 0, 0));
        searchTextField.setName("searchTextField"); // NOI18N
        searchTextField.setOpaque(true);
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });

        searchButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        searchButton.setText("Tìm Kiếm");
        searchButton.setIconTextGap(10);
        searchButton.setName("searchButton"); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(searchOptionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 133,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 538,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(searchOptionComboBox)
                                        .addComponent(searchTextField)
                                        .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 49,
                                                Short.MAX_VALUE))
                                .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(63, 63, 63)
                                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(69, 69, 69)
                                                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(69, 69, 69)
                                                .addComponent(importExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(62, 62, 62)
                                                .addComponent(exportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tableContainer, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(96, 96, 96)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(importExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(exportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(tableContainer, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)));
    }// </editor-fold>//GEN-END:initComponents

    private void exportExcelActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exportExcelActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xlsx");
            fileChooser.setFileFilter(filter);
            fileChooser.setDialogTitle("Specify a file to save");

            int userSelection = fileChooser.showSaveDialog(this);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                String filePath = fileToSave.getAbsolutePath();
                if (!filePath.endsWith(".xlsx")) {
                    filePath += ".xlsx";
                }

                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("JTable Sheet");

                // Write column names to the first row of the sheet
                XSSFRow headerRow = sheet.createRow(0);
                for (int j = 0; j < jTable1.getColumnCount(); j++) {
                    XSSFCell cell = headerRow.createCell(j);
                    cell.setCellValue(jTable1.getColumnName(j));
                }
                for (int i = 0; i < jTable1.getRowCount(); i++) {
                    XSSFRow row = sheet.createRow(i + 1);
                    for (int j = 0; j < jTable1.getColumnCount(); j++) {
                        Object value = jTable1.getValueAt(i, j);
                        String cellValue = (value != null) ? value.toString() : "";
                        XSSFCell cell = row.createCell(j); // Tạo ô trong bảng tính
                        cell.setCellValue(cellValue); // Ghi giá trị vào ô
                    }
                }

                // Write the workbook to the file
                FileOutputStream out = new FileOutputStream(new File(filePath));
                workbook.write(out);
                out.close();
                workbook.close();

                JOptionPane.showMessageDialog(null, "Data Exported Successfully");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }// GEN-LAST:event_exportExcelActionPerformed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchTextFieldActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_searchTextFieldActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        String searchText = searchTextField.getText().trim();
        String searchOption = (String) searchOptionComboBox.getSelectedItem();

        if (searchText.isEmpty()) {
            tableInit(Redux.accountBUS.getAccountList());
        } else {
            ArrayList<Account> searchResults = new ArrayList<>();
            for (Account account : Redux.accountBUS.getAccountList()) {
                switch (searchOption) {
                    case "Theo Tên":
                        if (account.getUsername().toLowerCase().contains(searchText.toLowerCase())) {
                            searchResults.add(account);
                        }
                        break;
                    case "Theo Mã":
                        if (account.getEmployee().getId().toLowerCase().contains(searchText.toLowerCase())) {
                            searchResults.add(account);
                        }
                        break;
                    default:
                        break;
                }
            }
            tableInit(searchResults);
        }
    }// GEN-LAST:event_searchButtonActionPerformed

    public void tableInit(List<Account> accounts) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            model.addRow(new Object[] {
                    i + 1,
                    account.getEmployee().getId(),
                    account.getUsername(),
                    account.getEmail(),
                    account.getAuthorization()
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton exportExcel;
    private javax.swing.JButton importExcel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTable jTable1;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox<String> searchOptionComboBox;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JPanel tableContainer;
    private javax.swing.JLabel tableLabel;

    // End of variables declaration//GEN-END:variables
    @Override
    public void mouseClicked(MouseEvent e) {
        // if (e.getSource() == this) {
        // Component clickedComponent = this.getComponentAt(this.getMousePosition());
        // if (clickedComponent != jTable1 && selectionConfirmed) {
        // jTable1.getSelectionModel().clearSelection();
        // selectionConfirmed = false;
        // }
        // }

        Component clickedComponent = jPanel1.getComponentAt(jPanel1.getMousePosition());
        if (clickedComponent != jTable1 && selectionConfirmed) {
            jTable1.getSelectionModel().clearSelection();
            selectionConfirmed = false;
            addButton.setEnabled(true);
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
}
