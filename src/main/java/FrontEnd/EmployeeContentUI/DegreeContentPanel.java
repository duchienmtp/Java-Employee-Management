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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class DegreeContentPanel extends javax.swing.JPanel implements ActionListener, ListSelectionListener, MouseListener {

    int selectedRow = -1;
    boolean selectionConfirmed;
    Object[] selectedRowData;

    public DegreeContentPanel() {
        initComponents();
        degreeLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        degreeTableLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        cancelButton.addActionListener(this);

        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable1.setDefaultRenderer(String.class, centerRenderer);
        jTable1.setDefaultRenderer(Integer.class, centerRenderer);
        jTable1.setDefaultRenderer(Object.class, centerRenderer);

        tableInit();
        jTable1.getSelectionModel().addListSelectionListener(this);
//        jTable1.addMouseListener(this);
        jPanel1.addMouseListener(this);
        setVisible(true);
    }

    public void tableInit() {
        Object[] newRowData = {1, "DE001", "Cử Nhân", "23/09/2004"};
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < 10; i++) {
            model.addRow(newRowData);
        }
    }

    public void updateTableRow(Object[] rowData, String employeeID) {
        int confirmation = JOptionPane.showConfirmDialog(this,
                "Bạn có muốn cập nhật dữ liệu nhân viên với ID " + employeeID + " ?",
                "CẬP NHẬT ?",
                JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            // Create a new ArrayList
            ArrayList<Object> dataList = new ArrayList<>(rowData.length);

            // Add all elements from the array to the ArrayList
            dataList.addAll(Arrays.asList(rowData));
            jTable1.revalidate();
        }
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

    public void fillDataDegreeForm(Object[] selectedRowData) {
        degreeIDTextField.setText((String) selectedRowData[1]);
        degreeNameTextField.setText((String) selectedRowData[2]);
        degreeIDTextField.setEnabled(false);
    }

    public void clearFormContent() {
        degreeIDTextField.setText("");
        degreeNameTextField.setText("");
        degreeIDTextField.setEnabled(true);
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
                fillDataDegreeForm(selectedRowData);
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

        } else if (e.getSource() == deleteButton) {
            if (selectedRow >= 0) {
                deleteTableRow(selectedRow, employeeID);
            } else {
                JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng trước!", "CẢNH BÁO", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == updateButton) {
            if (selectedRow >= 0) {
                updateTableRow(selectedRowData, employeeID);
            } else {
                JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng trước!", "CẢNH BÁO", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == cancelButton) {
            clearFormContent();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        degreeFormContainer = new javax.swing.JPanel();
        degreeLabel = new javax.swing.JLabel();
        degreeForm = new javax.swing.JPanel();
        degreeIDLabel = new javax.swing.JLabel();
        degreeIDTextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        degreeNameLabel = new javax.swing.JLabel();
        degreeNameTextField = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        degreeTableContainer = new javax.swing.JPanel();
        degreeTableLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 204, 204));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1055, 640));

        degreeFormContainer.setBackground(new java.awt.Color(255, 255, 255));
        degreeFormContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        degreeFormContainer.setName("degreeFormContainer"); // NOI18N

        degreeLabel.setText("Bằng Cấp");
        degreeLabel.setBackground(new java.awt.Color(255, 255, 255));
        degreeLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        degreeLabel.setForeground(new java.awt.Color(0, 0, 0));
        degreeLabel.setName("degreeLabel"); // NOI18N
        degreeLabel.setOpaque(true);

        degreeForm.setBackground(new java.awt.Color(255, 255, 255));
        degreeForm.setName("degreeForm"); // NOI18N

        degreeIDLabel.setLabelFor(degreeIDTextField);
        degreeIDLabel.setText("Mã Bằng Cấp :");
        degreeIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        degreeIDLabel.setForeground(new java.awt.Color(0, 0, 0));
        degreeIDLabel.setName("degreeIDLabel"); // NOI18N

        degreeIDTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        degreeIDTextField.setBackground(new java.awt.Color(204, 204, 204));
        degreeIDTextField.setCaretColor(new java.awt.Color(0, 0, 0));
        degreeIDTextField.setEnabled(false);
        degreeIDTextField.setForeground(new java.awt.Color(0, 0, 0));
        degreeIDTextField.setName("degreeIDTextField"); // NOI18N

        addButton.setBackground(new java.awt.Color(25, 135, 84));
        addButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        addButton.setText("Thêm");
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.setIconTextGap(10);
        addButton.setName("addButton"); // NOI18N

        deleteButton.setBackground(new java.awt.Color(220, 53, 69));
        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        deleteButton.setText("Xóa");
        deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteButton.setIconTextGap(10);
        deleteButton.setName("deleteButton"); // NOI18N
        deleteButton.setOpaque(true);

        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        updateButton.setText("Sửa");
        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setIconTextGap(10);
        updateButton.setName("updateButton"); // NOI18N
        updateButton.setOpaque(true);

        degreeNameLabel.setLabelFor(degreeNameTextField);
        degreeNameLabel.setText("Tên Bằng Cấp :");
        degreeNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        degreeNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        degreeNameLabel.setName("degreeNameLabel"); // NOI18N

        degreeNameTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        degreeNameTextField.setBackground(new java.awt.Color(204, 204, 204));
        degreeNameTextField.setCaretColor(new java.awt.Color(0, 0, 0));
        degreeNameTextField.setForeground(new java.awt.Color(0, 0, 0));
        degreeNameTextField.setName("degreeNameTextField"); // NOI18N

        cancelButton.setText("Hủy Bỏ");
        cancelButton.setBackground(new java.awt.Color(108, 117, 125));
        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setName("cancelButton"); // NOI18N

        javax.swing.GroupLayout degreeFormLayout = new javax.swing.GroupLayout(degreeForm);
        degreeForm.setLayout(degreeFormLayout);
        degreeFormLayout.setHorizontalGroup(
            degreeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(degreeNameTextField)
            .addComponent(degreeNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(degreeIDTextField, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(degreeIDLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(degreeFormLayout.createSequentialGroup()
                .addComponent(addButton)
                .addGap(18, 18, 18)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
            .addComponent(cancelButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        degreeFormLayout.setVerticalGroup(
            degreeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(degreeFormLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(degreeIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(degreeIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(degreeNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(degreeNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(degreeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(degreeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout degreeFormContainerLayout = new javax.swing.GroupLayout(degreeFormContainer);
        degreeFormContainer.setLayout(degreeFormContainerLayout);
        degreeFormContainerLayout.setHorizontalGroup(
            degreeFormContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(degreeFormContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(degreeFormContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(degreeForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(degreeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        degreeFormContainerLayout.setVerticalGroup(
            degreeFormContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(degreeFormContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(degreeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(degreeForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        degreeTableContainer.setBackground(new java.awt.Color(255, 255, 255));
        degreeTableContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        degreeTableContainer.setName("degreeTableContainer"); // NOI18N

        degreeTableLabel.setText("Bằng Cấp");
        degreeTableLabel.setBackground(new java.awt.Color(255, 255, 255));
        degreeTableLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        degreeTableLabel.setForeground(new java.awt.Color(0, 0, 0));
        degreeTableLabel.setName("degreeTableLabel"); // NOI18N
        degreeTableLabel.setOpaque(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID", "Tên Bằng Cấp", "Ngày Tạo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout degreeTableContainerLayout = new javax.swing.GroupLayout(degreeTableContainer);
        degreeTableContainer.setLayout(degreeTableContainerLayout);
        degreeTableContainerLayout.setHorizontalGroup(
            degreeTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, degreeTableContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(degreeTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(degreeTableLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        degreeTableContainerLayout.setVerticalGroup(
            degreeTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(degreeTableContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(degreeTableLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(degreeFormContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(degreeTableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(degreeTableContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(degreeFormContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel degreeForm;
    private javax.swing.JPanel degreeFormContainer;
    private javax.swing.JLabel degreeIDLabel;
    private javax.swing.JTextField degreeIDTextField;
    private javax.swing.JLabel degreeLabel;
    private javax.swing.JLabel degreeNameLabel;
    private javax.swing.JTextField degreeNameTextField;
    private javax.swing.JPanel degreeTableContainer;
    private javax.swing.JLabel degreeTableLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

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

}
