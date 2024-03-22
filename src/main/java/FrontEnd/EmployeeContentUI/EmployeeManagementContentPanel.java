package FrontEnd.EmployeeContentUI;

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
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class EmployeeManagementContentPanel extends javax.swing.JPanel implements MouseListener, ActionListener, ListSelectionListener {

    UserInformationForm userInfoForm;
    UserInformationFrame userInfoFrame;
    int selectedRow = -1;
    Object[] selectedRowData;
    boolean selectionConfirmed;

    public EmployeeManagementContentPanel() {
        initComponents();
        userInfoForm = new UserInformationForm();
        userInfoFrame = new UserInformationFrame();

        addButton.addActionListener(this);
        editButton.addActionListener(this);
        deleteButton.addActionListener(this);

//        LineBorder lineBorder = (LineBorder) BorderFactory.createLineBorder(Color.black, 1, true);
//        searchTextField.setBorder(lineBorder);
//        searchTextField.setCaretPosition();
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

        tableInit();
        jTable1.getSelectionModel().addListSelectionListener(this);
        jTable1.addMouseListener(this);
        addMouseListener(this);
        setVisible(true);
    }

    public void tableInit() {
        Object[] newRowData = {1, "NV001", "Trần Đức Hiển", "Nam", "23/09/2004", "Trưởng phòng", "Đang làm việc"};
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < 10; i++) {
            model.addRow(newRowData);
        }
    }

    public void updateTableRow(Object[] rowData, String employeeID) {
        // Create a new ArrayList
        ArrayList<Object> dataList = new ArrayList<>(rowData.length);

        // Add all elements from the array to the ArrayList
        dataList.addAll(Arrays.asList(rowData));
        userInfoForm.showFormWithData(dataList);
    }

    public void deleteTableRow(int selectedRow, String employeeID) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int confirmation = JOptionPane.showConfirmDialog(this,
                "Bạn có muốn xóa bỏ nhân viên với ID " + employeeID + " ?",
                "XÓA BỎ ?",
                JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            model.removeRow(selectedRow);
            jTable1.revalidate();
        }
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
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String employeeID = "";
        if (selectedRowData != null) {
            employeeID = (String) selectedRowData[1];
        }
        if (e.getSource() == addButton) {
            userInfoForm.setVisible(true);
        } else if (e.getSource() == deleteButton) {
            if (selectedRow >= 0) {
                deleteTableRow(selectedRow, employeeID);
            } else {
                JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng trước!", "CẢNH BÁO", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == editButton) {
            if (selectedRow >= 0) {
                updateTableRow(selectedRowData, employeeID);
                userInfoForm.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng trước!", "CẢNH BÁO", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == importExcel) {

        } else if (e.getSource() == exportExcel) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        importExcel = new javax.swing.JButton();
        exportExcel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        searchOptionComboBox = new javax.swing.JComboBox<>();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        tableContainer = new javax.swing.JPanel();
        tableLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(0, 0, 0));
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setPreferredSize(new java.awt.Dimension(1055, 640));

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        searchOptionComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        searchOptionComboBox.setForeground(new java.awt.Color(255, 255, 255));
        searchOptionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo Tên", "Theo Mã" }));
        searchOptionComboBox.setName("searchOptionComboBox"); // NOI18N
        searchOptionComboBox.setOpaque(true);

        searchTextField.setBackground(new java.awt.Color(255, 255, 255));
        searchTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        searchTextField.setForeground(new java.awt.Color(0, 0, 0));
        searchTextField.setCaretColor(new java.awt.Color(0, 0, 0));
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
                .addComponent(searchOptionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchOptionComboBox)
                    .addComponent(searchTextField)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addContainerGap())
        );

        tableContainer.setBackground(new java.awt.Color(255, 255, 255));
        tableContainer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tableContainer.setForeground(new java.awt.Color(0, 0, 0));
        tableContainer.setName("tableContainer"); // NOI18N

        tableLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tableLabel.setForeground(new java.awt.Color(0, 0, 0));
        tableLabel.setText("Danh sách nhân viên");
        tableLabel.setName("tableLabel"); // NOI18N

        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID", "Họ và Tên", "Giới Tính", "Ngày Sinh", "Chức Vụ", "Trạng Thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(40);
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(3);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout tableContainerLayout = new javax.swing.GroupLayout(tableContainer);
        tableContainer.setLayout(tableContainerLayout);
        tableContainerLayout.setHorizontalGroup(
            tableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tableContainerLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(tableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(tableContainerLayout.createSequentialGroup()
                        .addComponent(tableLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
        );
        tableContainerLayout.setVerticalGroup(
            tableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tableContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tableContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(importExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(exportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(importExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(tableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton exportExcel;
    private javax.swing.JButton importExcel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox<String> searchOptionComboBox;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JPanel tableContainer;
    private javax.swing.JLabel tableLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == jTable1) {
            if (e.getClickCount() == 2) {
                // Get the selected row index
                selectedRow = jTable1.getSelectedRow();
                if (selectedRow != -1) {
                    // Open a new frame with information from the selected row
                    userInfoFrame.setVisible(true);
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
