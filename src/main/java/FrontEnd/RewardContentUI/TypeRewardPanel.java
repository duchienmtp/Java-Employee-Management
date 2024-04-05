package FrontEnd.RewardContentUI;

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

public class TypeRewardPanel extends javax.swing.JPanel implements ActionListener, ListSelectionListener, MouseListener {

    int selectedRow = -1;
    boolean selectionConfirmed;
    Object[] selectedRowData;

    public TypeRewardPanel() {
        initComponents();

        TypeRewardLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        typeRewardTableLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        cancelButton.addActionListener(this);

        typeRewardTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        typeRewardTable.setDefaultRenderer(String.class, centerRenderer);
        typeRewardTable.setDefaultRenderer(Object.class, centerRenderer);
        typeRewardTable.setDefaultRenderer(Integer.class, centerRenderer);
        typeRewardTable.setDefaultRenderer(Double.class, centerRenderer);

        typeRewardTable.getSelectionModel().addListSelectionListener(this);
        tableInit();
        jPanel1.addMouseListener(this);
    }

    public void tableInit() {
        Object[] newRowData = {1, "RE001", "Nhân viên của năm", 1000000, "02/01/2024"};
        DefaultTableModel model = (DefaultTableModel) typeRewardTable.getModel();
        for (int i = 0; i < 10; i++) {
            model.addRow(newRowData);
        }
    }

    public void insertTableRow() {
        String typeRewardID = (String) typeRewardIDTextField.getText();
        String typeRewardName = typeRewardNameTextField.getText();
        int money = Integer.parseInt((String) moneyTextField.getText());

        int confirmation = JOptionPane.showConfirmDialog(this,
                "Bạn có muốn thêm mới dữ liệu loại khen thưởng với ID " + typeRewardID + " ?",
                "CẬP NHẬT ?",
                JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
//            // Create a new ArrayList
//            ArrayList<Object> dataList = new ArrayList<>(rowData.length);
//
//            // Add all elements from the array to the ArrayList
//            dataList.addAll(Arrays.asList(rowData));
            typeRewardTable.revalidate();

        }
    }

    public void updateTableRow(Object[] rowData, String typeRewardID) {
        int confirmation = JOptionPane.showConfirmDialog(this,
                "Bạn có muốn cập nhật dữ liệu loại khen thưởng với ID " + typeRewardID + " ?",
                "CẬP NHẬT ?",
                JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            // Create a new ArrayList
            ArrayList<Object> dataList = new ArrayList<>(rowData.length);

            // Add all elements from the array to the ArrayList
            dataList.addAll(Arrays.asList(rowData));
            typeRewardTable.revalidate();
        }
    }

    public void deleteTableRow(int selectedRow, String typeRewardID) {
        DefaultTableModel model = (DefaultTableModel) typeRewardTable.getModel();
        int confirmation = JOptionPane.showConfirmDialog(this,
                "Bạn có muốn xóa bỏ loại khen thưởng với ID " + typeRewardID + " ?",
                "XÓA BỎ ?",
                JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            model.removeRow(selectedRow);
            typeRewardTable.revalidate();
        }
    }

    public void fillDataTypeRewardForm(Object[] selectedRowData) {
        typeRewardIDTextField.setText((String) selectedRowData[1]);
        typeRewardNameTextField.setText((String) selectedRowData[2]);
        moneyTextField.setText(Integer.toString((int) selectedRowData[3]));
    }

    public void clearFormContent() {
        typeRewardIDTextField.setText("");
        typeRewardNameTextField.setText("");
        moneyTextField.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        typeRewardFormContainer = new javax.swing.JPanel();
        TypeRewardLabel = new javax.swing.JLabel();
        typeRewardForm = new javax.swing.JPanel();
        typeRewardIDLabel = new javax.swing.JLabel();
        typeRewardIDTextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        typeRewardNameLabel = new javax.swing.JLabel();
        typeRewardNameTextField = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        moneyLabel = new javax.swing.JLabel();
        moneyTextField = new javax.swing.JTextField();
        typeRewardTableContainer = new javax.swing.JPanel();
        typeRewardTableLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        typeRewardTable = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1055, 640));

        typeRewardFormContainer.setBackground(new java.awt.Color(255, 255, 255));
        typeRewardFormContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        typeRewardFormContainer.setName("typeRewardFormContainer"); // NOI18N
        typeRewardFormContainer.setPreferredSize(new java.awt.Dimension(386, 540));

        TypeRewardLabel.setBackground(new java.awt.Color(255, 255, 255));
        TypeRewardLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TypeRewardLabel.setForeground(new java.awt.Color(0, 0, 0));
        TypeRewardLabel.setText("Tạo Loại Khen Thưởng");
        TypeRewardLabel.setName("TypeRewardLabel"); // NOI18N
        TypeRewardLabel.setOpaque(true);

        typeRewardForm.setBackground(new java.awt.Color(255, 255, 255));
        typeRewardForm.setName("typeRewardForm"); // NOI18N

        typeRewardIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        typeRewardIDLabel.setForeground(new java.awt.Color(0, 0, 0));
        typeRewardIDLabel.setText("Mã Loại Khen Thưởng:");
        typeRewardIDLabel.setName("typeRewardIDLabel"); // NOI18N

        typeRewardIDTextField.setBackground(new java.awt.Color(204, 204, 204));
        typeRewardIDTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        typeRewardIDTextField.setForeground(new java.awt.Color(0, 0, 0));
        typeRewardIDTextField.setName("typeRewardIDTextField"); // NOI18N

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

        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        updateButton.setText("Sửa");
        updateButton.setIconTextGap(10);
        updateButton.setName("updateButton"); // NOI18N
        updateButton.setOpaque(true);

        typeRewardNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        typeRewardNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        typeRewardNameLabel.setText("Tên Loại Khen Thưởng :");
        typeRewardNameLabel.setName("typeRewardNameLabel"); // NOI18N

        typeRewardNameTextField.setBackground(new java.awt.Color(204, 204, 204));
        typeRewardNameTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        typeRewardNameTextField.setForeground(new java.awt.Color(0, 0, 0));
        typeRewardNameTextField.setName("typeRewardNameTextField"); // NOI18N

        cancelButton.setBackground(new java.awt.Color(108, 117, 125));
        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Hủy Bỏ");
        cancelButton.setName("cancelButton"); // NOI18N

        moneyLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        moneyLabel.setForeground(new java.awt.Color(0, 0, 0));
        moneyLabel.setLabelFor(moneyTextField);
        moneyLabel.setText("Số Tiền Thưởng :");
        moneyLabel.setName("moneyLabel"); // NOI18N
        moneyLabel.setPreferredSize(new java.awt.Dimension(118, 40));

        moneyTextField.setBackground(new java.awt.Color(204, 204, 204));
        moneyTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        moneyTextField.setForeground(new java.awt.Color(0, 0, 0));
        moneyTextField.setName("moneyTextField"); // NOI18N

        javax.swing.GroupLayout typeRewardFormLayout = new javax.swing.GroupLayout(typeRewardForm);
        typeRewardForm.setLayout(typeRewardFormLayout);
        typeRewardFormLayout.setHorizontalGroup(
            typeRewardFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(typeRewardNameTextField)
            .addComponent(typeRewardNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(typeRewardIDTextField, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(typeRewardIDLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(typeRewardFormLayout.createSequentialGroup()
                .addComponent(addButton)
                .addGap(18, 18, 18)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(cancelButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(typeRewardFormLayout.createSequentialGroup()
                .addComponent(moneyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moneyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        typeRewardFormLayout.setVerticalGroup(
            typeRewardFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typeRewardFormLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(typeRewardIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(typeRewardIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(typeRewardNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(typeRewardNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(typeRewardFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(moneyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moneyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(typeRewardFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(typeRewardFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout typeRewardFormContainerLayout = new javax.swing.GroupLayout(typeRewardFormContainer);
        typeRewardFormContainer.setLayout(typeRewardFormContainerLayout);
        typeRewardFormContainerLayout.setHorizontalGroup(
            typeRewardFormContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typeRewardFormContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(typeRewardFormContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typeRewardForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TypeRewardLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        typeRewardFormContainerLayout.setVerticalGroup(
            typeRewardFormContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typeRewardFormContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TypeRewardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(typeRewardForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        typeRewardTableContainer.setBackground(new java.awt.Color(255, 255, 255));
        typeRewardTableContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        typeRewardTableContainer.setName("typeRewardTableContainer"); // NOI18N
        typeRewardTableContainer.setPreferredSize(new java.awt.Dimension(537, 540));

        typeRewardTableLabel.setBackground(new java.awt.Color(255, 255, 255));
        typeRewardTableLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        typeRewardTableLabel.setForeground(new java.awt.Color(0, 0, 0));
        typeRewardTableLabel.setText("Loại Khen Thưởng");
        typeRewardTableLabel.setName("typeRewardTableLabel"); // NOI18N
        typeRewardTableLabel.setOpaque(true);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        typeRewardTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Loại Khen Thưởng", "Tên Khen Thưởng", "Số Tiền Thưởng", "Ngày Tạo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        typeRewardTable.setName("typeRewardTable"); // NOI18N
        typeRewardTable.setRowHeight(40);
        jScrollPane1.setViewportView(typeRewardTable);
        if (typeRewardTable.getColumnModel().getColumnCount() > 0) {
            typeRewardTable.getColumnModel().getColumn(0).setPreferredWidth(1);
            typeRewardTable.getColumnModel().getColumn(4).setPreferredWidth(3);
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout typeRewardTableContainerLayout = new javax.swing.GroupLayout(typeRewardTableContainer);
        typeRewardTableContainer.setLayout(typeRewardTableContainerLayout);
        typeRewardTableContainerLayout.setHorizontalGroup(
            typeRewardTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, typeRewardTableContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(typeRewardTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(typeRewardTableLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        typeRewardTableContainerLayout.setVerticalGroup(
            typeRewardTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typeRewardTableContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(typeRewardTableLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(typeRewardFormContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(typeRewardTableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(typeRewardTableContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(typeRewardFormContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
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
    private javax.swing.JLabel TypeRewardLabel;
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel moneyLabel;
    private javax.swing.JTextField moneyTextField;
    private javax.swing.JPanel typeRewardForm;
    private javax.swing.JPanel typeRewardFormContainer;
    private javax.swing.JLabel typeRewardIDLabel;
    private javax.swing.JTextField typeRewardIDTextField;
    private javax.swing.JLabel typeRewardNameLabel;
    private javax.swing.JTextField typeRewardNameTextField;
    private javax.swing.JTable typeRewardTable;
    private javax.swing.JPanel typeRewardTableContainer;
    private javax.swing.JLabel typeRewardTableLabel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        String typeRewardID = "";
        if (selectedRowData != null) {
            typeRewardID = (String) selectedRowData[1];
        }

        if (e.getSource() == addButton) {

        } else if (e.getSource() == deleteButton) {
            if (selectedRow >= 0) {
                deleteTableRow(selectedRow, typeRewardID);
            } else {
                JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng trước!", "CẢNH BÁO", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == updateButton) {
            if (selectedRow >= 0) {
                updateTableRow(selectedRowData, typeRewardID);
            } else {
                JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng trước!", "CẢNH BÁO", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == cancelButton) {
            clearFormContent();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (!event.getValueIsAdjusting()) {  // Ensure selection is stable
            selectionConfirmed = true;
            selectedRow = typeRewardTable.getSelectedRow();
            if (selectedRow >= 0) {  // Check if a row is selected
                selectedRowData = new Object[typeRewardTable.getColumnCount()];
                for (int i = 0; i < typeRewardTable.getColumnCount(); i++) {
                    selectedRowData[i] = typeRewardTable.getValueAt(selectedRow, i);
                }
                fillDataTypeRewardForm(selectedRowData);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Component clickedComponent = jPanel1.getComponentAt(jPanel1.getMousePosition());
        if (clickedComponent != typeRewardTable && selectionConfirmed) {
            typeRewardTable.getSelectionModel().clearSelection();
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
