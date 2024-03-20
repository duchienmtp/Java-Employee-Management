package FrontEnd.EmployeeContentUI;

import java.awt.Color;
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
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class EmployeeManagementContentPanel extends javax.swing.JPanel implements MouseListener, ActionListener, ListSelectionListener {

    UserInformationForm userInfoForm;
    int selectedRow = -1;
    Object[] selectedRowData;

    public EmployeeManagementContentPanel() {
        initComponents();
        userInfoForm = new UserInformationForm();

        addButton.addActionListener(this);
        editButton.addActionListener(this);
        deleteButton.addActionListener(this);

        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2), // Line color and stroke size
                "Tìm kiếm",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("Segoe UI", Font.PLAIN, 12),
                Color.BLACK // Text color
        );
        jPanel1.setBorder(titledBorder);

        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable1.setDefaultRenderer(String.class, centerRenderer);
        jTable1.setDefaultRenderer(Integer.class, centerRenderer);
        tableInit();
        jTable1.getSelectionModel().addListSelectionListener(this);

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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(0, 0, 0));
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

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
                false, false, false, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(49, 49, 49)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(importExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(exportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(226, Short.MAX_VALUE))
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
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
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
