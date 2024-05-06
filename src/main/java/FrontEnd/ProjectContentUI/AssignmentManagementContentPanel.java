package FrontEnd.ProjectContentUI;

import BackEnd.AssignmentManagement.Assignment;
import BackEnd.ProjectsManagement.*;
import BackEnd.DegreeManagement.Degree;
import BackEnd.DepartmentManagement.Department;
import BackEnd.EmployeeManagement.Employee;
import BackEnd.PositionManagement.Position;
import BackEnd.SpecialtyManagement.Specialty;
import static FrontEnd.EmployeeContentUI.EmployeeManagementContentPanel.tableInit;
import static FrontEnd.ProjectContentUI.AssignmentForm.employeeIDComboBox;
import static FrontEnd.ProjectContentUI.AssignmentForm.projectIDComboBox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import FrontEnd.Redux.Redux;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.TableUI;
import org.apache.poi.ss.usermodel.Cell;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AssignmentManagementContentPanel extends javax.swing.JPanel
        implements ActionListener, ListSelectionListener, MouseListener {

    AssignmentForm assignmentForm;
    int selectedRow = -1;
    boolean selectionConfirmed;
    Object[] selectedRowData;
    int clickCount = 0;
    UserAssignmentInformation userAssignmentInformation;
    public AssignmentManagementContentPanel() {
        initComponents();

        if (!Redux.isAdmin) {
            Redux.assignmentBUS.getEmployeeAssignmentsByEmployeeId(Redux.userId);
            addButton.setVisible(false);
            deleteButton.setVisible(false);
            editButton.setVisible(false);
            importExcel.setVisible(false);
            exportExcel.setVisible(false);
        }

        tableLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1), // Line color and stroke size
                "Tìm kiếm",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("Segoe UI", Font.PLAIN, 12),
                Color.BLACK // Text color
        );
        jPanel1.setBorder(titledBorder);

        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        editButton.addActionListener(this);
        searchButton.addActionListener(this);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable1.setDefaultRenderer(Object.class, centerRenderer);
        jTable1.setDefaultRenderer(String.class, centerRenderer);
        jTable1.setDefaultRenderer(Integer.class, centerRenderer);

        if (!Redux.isAdmin) {
            tableInit(Redux.assignmentBUS.getEmployeeAssignmentList());
        } else {
            tableInit(Redux.assignmentBUS.getAssignmentsList());
        }

        jTable1.getSelectionModel().addListSelectionListener(this);
        jTable1.addMouseListener(this);
        addMouseListener(this);
        jTable1.addMouseListener(this);

        importExcel.setEnabled(true);
        exportExcel.setEnabled(true);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            insertTableRow();
        } else if (e.getSource() == deleteButton) {
            System.out.println("deleteTableRow");
            if (selectedRow >= 0) {
                deleteTableRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng trước!", "CẢNH BÁO",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == editButton) {
            System.out.println("updateTableRow");
            if (selectedRow >= 0) {
                updateTableRow(selectedRowData);
                assignmentForm.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng trước!", "CẢNH BÁO",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == importExcel) {
            System.out.println("handleImportExcel");
            handleImportExcel();
        } else if (e.getSource() == exportExcel) {
            System.out.println("handleExportExcel");
            handleExportExcel();
        } else if (e.getSource() == searchButton) {
            System.out.println("handleSearch");
            handleSearch();
        }
    }

    public void handleImportExcel() {
        try {
            FileInputStream file = new FileInputStream(new File("src/main/resources/files/ImportFile.xlsx"));

            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheet("Assignment Sheet");

            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                ArrayList<Object> dataList = new ArrayList<>();
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            dataList.add(cell.getNumericCellValue());
                            break;
                        case STRING:
                            dataList.add(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                }
                Project project = Redux.projectBUS.getProjectById(dataList.get(1).toString());
                Employee employee = Redux.employeeBUS.getEmployeeById(dataList.get(0).toString());

                if (project != null || employee != null) {
                    Assignment assignment = new Assignment(
                            Redux.employeeBUS.getEmployeeById(dataList.get(0).toString()),
                            Redux.projectBUS.getProjectById(dataList.get(1).toString()), false);
                    Redux.assignmentBUS.addAssignmentExcel(assignment);
                }
            }
            file.close();
            tableInit(Redux.assignmentBUS.getAssignmentsList());
            JOptionPane.showMessageDialog(null, "Data Imported Successfully");

        } catch (Exception e) {
            System.out.println("Can not imported data");
            e.printStackTrace();
        }
    }

    public void handleExportExcel() {
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
                XSSFSheet sheet = workbook.createSheet("Assignment Sheet");

                // Write column names to the first row of the sheet
                XSSFRow headerRow = sheet.createRow(0);
                for (int j = 0; j < Assignment.getHeader().size(); j++) {
                    XSSFCell cell = headerRow.createCell(j);
                    cell.setCellValue(Assignment.getHeader().get(j));
                }

                for (int i = 0; i < Redux.assignmentBUS.getAssignmentsList().size() - 1; i++) {
                    XSSFRow row = sheet.createRow(i + 1);
                    Assignment assisgnment = Redux.assignmentBUS.getAssignmentsList().get(i);
                    for (int j = 0; j < Assignment.getHeader().size(); j++) {
                        Object value = assisgnment.getPropertyByIndex(j);
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
            JOptionPane.showMessageDialog(null, "Không export excel được");
            ex.printStackTrace();
        }
    }

    public void handleSearch() {
        String searchOption = searchOptionComboBox.getSelectedItem().toString();
        String searchValue = searchTextField.getText().trim();
        if (searchValue.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy nhập từ khóa tìm kiếm!", "CẢNH BÁO",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        ArrayList<Assignment> list = new ArrayList<>();
        switch (searchOption) {
            case "Theo Tên":
                Redux.assignmentBUS.searchAssignmentByName(searchValue);
                list = Redux.assignmentBUS.getAssignmentResultSearch();
                break;
            case "Theo Mã Công Tác":
                Redux.assignmentBUS.searchAssignmentByProjectId(searchValue);
                list = Redux.assignmentBUS.getAssignmentResultSearch();
                break;
            default:
                break;
        }

        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả phù hợp!", "CẢNH BÁO",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            tableInit(list);
        }
    }

    public static void tableInit(ArrayList<Assignment> list) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[] { i + 1,
                    list.get(i).getEmployee().getId(),
                    list.get(i).getEmployee().getFullName(),
                    list.get(i).getProject().getProjectId(),
                    list.get(i).getProject().getProjectName(),
                    list.get(i).getProject().getPlace()
            });
        }
    }

    public static JTable getAssignmentManagementContentTable() {
        return jTable1;
    }

    public void insertTableRow() {
        assignmentForm = new AssignmentForm();
        assignmentForm.setTitle("THÊM MỚI CÔNG TÁC CỦA NHÂN VIÊN");
        assignmentForm.setVisible(true);
    }

    public void updateTableRow(Object[] rowData) {
        // Create a new ArrayList
        ArrayList<Object> dataList = new ArrayList<>(rowData.length);

        // Add all elements from the array to the ArrayList
        dataList.addAll(Arrays.asList(rowData));
        assignmentForm = new AssignmentForm();
        assignmentForm.setTitle("CẬP NHẬT THÔNG TIN CÔNG TÁC CỦA NHÂN VIÊN");
        assignmentForm.showFormWithData(dataList);
    }

    public void deleteTableRow(int selectedRow) {
        int confirmation = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc chắn là muốn xóa thông tin công tác của nhân viên này? ", "Thông báo",
                JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            Redux.assignmentBUS.deleteAssignment(Redux.assignmentBUS.findAssignmentByEmployeeIdAndProjectId(
                    (String) selectedRowData[1],
                    (String) selectedRowData[3]));
            jTable1.revalidate();
            tableInit(Redux.assignmentBUS.getAssignmentsList());
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
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        exportExcel = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        searchOptionComboBox = new javax.swing.JComboBox<>();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        importExcel = new javax.swing.JButton();
        tableContainer = new javax.swing.JPanel();
        tableLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

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

        editButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        editButton.setText("Sửa");
        editButton.setIconTextGap(10);
        editButton.setName("editButton"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        searchOptionComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        searchOptionComboBox.setForeground(new java.awt.Color(255, 255, 255));
        searchOptionComboBox
                .setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo Tên", "Theo Mã Công Tác" }));
        searchOptionComboBox.setName("searchOptionComboBox"); // NOI18N
        searchOptionComboBox.setOpaque(true);

        searchTextField.setBackground(new java.awt.Color(204, 204, 204));
        searchTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        searchTextField.setForeground(new java.awt.Color(0, 0, 0));
        searchTextField.setName("searchTextField"); // NOI18N
        searchTextField.setOpaque(true);

        searchButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        searchButton.setText("Tìm Kiếm");
        searchButton.setIconTextGap(10);
        searchButton.setName("searchButton"); // NOI18N

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

        importExcel.setBackground(new java.awt.Color(13, 110, 253));
        importExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        importExcel.setForeground(new java.awt.Color(255, 255, 255));
        importExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excel.png"))); // NOI18N
        importExcel.setText("Nhập ");
        importExcel.setIconTextGap(10);
        importExcel.setName("importExcel"); // NOI18N
        importExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importExcelActionPerformed(evt);
            }
        });

        tableContainer.setBackground(new java.awt.Color(255, 255, 255));
        tableContainer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tableContainer.setName("tableContainer"); // NOI18N

        tableLabel.setBackground(new java.awt.Color(255, 255, 255));
        tableLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tableLabel.setText("Danh sách công tác của nhân viên");
        tableLabel.setName("tableLabel"); // NOI18N
        tableLabel.setOpaque(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "STT", "ID", "Họ và Tên", "Mã Công Tác", "Tên Công Tác", "Nơi Công Tác"
                }) {
            Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
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
        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable1.setRowHeight(40);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout tableContainerLayout = new javax.swing.GroupLayout(tableContainer);
        tableContainer.setLayout(tableContainerLayout);
        tableContainerLayout.setHorizontalGroup(
                tableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tableContainerLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(tableContainerLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2)
                                        .addComponent(tableLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(25, 25, 25)));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tableContainer, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(96, 96, 96)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
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

    private void importExcelActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_importExcelActionPerformed
        System.out.println("handleImportExcel");
        handleImportExcel();
    }// GEN-LAST:event_importExcelActionPerformed

    private void exportExcelActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exportExcelActionPerformed
        System.out.println("handleExportExcel");
        handleExportExcel();
    }// GEN-LAST:event_exportExcelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton exportExcel;
    private javax.swing.JButton importExcel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable1;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox<String> searchOptionComboBox;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JPanel tableContainer;
    private javax.swing.JLabel tableLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == jTable1) {
            if(Redux.isAdmin){
                if(e.getClickCount() == 2){
                    clickCount++;
                    if(clickCount % 2 == 0){
                        selectedRow = jTable1.getSelectedRow();
                        for(Object it : selectedRowData){
                                    System.out.println(it + " ");
                                }
                        if(selectedRow!=-1){
                            Assignment assignment = Redux.assignmentBUS.findAssignmentByEmployeeIdAndProjectId(selectedRowData[1].toString(),selectedRowData[3].toString());
                            if(assignment!=null){
                                userAssignmentInformation = new UserAssignmentInformation();
                                userAssignmentInformation.setVisible(true);
                                userAssignmentInformation.showFormWithData(assignment);
                            }
                        }
                    }
                }
            }
        } else {
            Component clickedComponent = this.getComponentAt(this.getMousePosition());
            if (clickedComponent != jTable1 && selectionConfirmed) {
                jTable1.getSelectionModel().clearSelection();
                selectionConfirmed = false;
            }
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
