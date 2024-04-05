/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FrontEnd.CriticismContentUI;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
public class CriticismEmployeePanel extends javax.swing.JPanel implements ActionListener, ListSelectionListener, MouseListener {

    int selectedRow = -1;
    boolean selectionConfirmed;
    public CriticismEmployeePanel() {
        initComponents();
      
        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
       CriticismEmployeeTable.getSelectionModel().addListSelectionListener(this);
        tableInit();
        jPanel1.addMouseListener(this);
    }

   public void tableInit() {
        Object[] newRowData = {1, "LKL001","Nguyễn Như Phương","100,000", "02/01/2024"};
        DefaultTableModel model = (DefaultTableModel) CriticismEmployeeTable.getModel();
        for (int i = 0; i < 10; i++) {
            model.addRow(newRowData);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        criticismEmployeeFormContainer = new javax.swing.JPanel();
        criticismEmployeeLabel = new javax.swing.JLabel();
        CriticismEmployeeForm = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        typeCriticismNameLabel1 = new javax.swing.JLabel();
        EmployeeComboBox = new javax.swing.JComboBox<>();
        criticismNameEmployeeLabel = new javax.swing.JLabel();
        typeCriticismComboBox = new javax.swing.JComboBox<>();
        moneyCriticismLabel = new javax.swing.JLabel();
        moneyTextField = new javax.swing.JTextField();
        criticismEmployeeTableContainer = new javax.swing.JPanel();
        CriticismEmployeeTableLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CriticismEmployeeTable = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1055, 640));

        criticismEmployeeFormContainer.setBackground(new java.awt.Color(255, 255, 255));
        criticismEmployeeFormContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        criticismEmployeeFormContainer.setName("criticismEmployeeFormContainer"); // NOI18N

        criticismEmployeeLabel.setBackground(new java.awt.Color(255, 255, 255));
        criticismEmployeeLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        criticismEmployeeLabel.setForeground(new java.awt.Color(51, 51, 0));
        criticismEmployeeLabel.setText("Tạo Kỷ Luật");
        criticismEmployeeLabel.setName("criticismEmployeeLabel"); // NOI18N
        criticismEmployeeLabel.setOpaque(true);

        CriticismEmployeeForm.setBackground(new java.awt.Color(255, 255, 255));
        CriticismEmployeeForm.setName("CriticismEmployeeForm"); // NOI18N

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
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        updateButton.setText("Sửa");
        updateButton.setIconTextGap(10);
        updateButton.setName("updateButton"); // NOI18N
        updateButton.setOpaque(true);

        cancelBtn.setBackground(new java.awt.Color(108, 117, 125));
        cancelBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("Hủy Bỏ");
        cancelBtn.setName("cancelBtn"); // NOI18N

        typeCriticismNameLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        typeCriticismNameLabel1.setForeground(new java.awt.Color(51, 51, 0));
        typeCriticismNameLabel1.setText("Chọn Loại Kỷ Luật:");
        typeCriticismNameLabel1.setName("typeRewardNameLabel"); // NOI18N

        EmployeeComboBox.setEditable(true);
        EmployeeComboBox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EmployeeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        criticismNameEmployeeLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        criticismNameEmployeeLabel.setForeground(new java.awt.Color(51, 51, 0));
        criticismNameEmployeeLabel.setText("Chọn Nhân Viên");
        criticismNameEmployeeLabel.setName("typeRewardNameLabel"); // NOI18N

        typeCriticismComboBox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        typeCriticismComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        typeCriticismComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeCriticismComboBoxActionPerformed(evt);
            }
        });

        moneyCriticismLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        moneyCriticismLabel.setForeground(new java.awt.Color(51, 51, 0));
        moneyCriticismLabel.setText("Số Tiền Phạt:");

        moneyTextField.setEditable(false);
        moneyTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        moneyTextField.setText("500,000");
        moneyTextField.setEnabled(false);

        javax.swing.GroupLayout CriticismEmployeeFormLayout = new javax.swing.GroupLayout(CriticismEmployeeForm);
        CriticismEmployeeForm.setLayout(CriticismEmployeeFormLayout);
        CriticismEmployeeFormLayout.setHorizontalGroup(
            CriticismEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CriticismEmployeeFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CriticismEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CriticismEmployeeFormLayout.createSequentialGroup()
                        .addGroup(CriticismEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(typeCriticismNameLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EmployeeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(typeCriticismComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(CriticismEmployeeFormLayout.createSequentialGroup()
                                .addComponent(addButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(CriticismEmployeeFormLayout.createSequentialGroup()
                        .addComponent(criticismNameEmployeeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addGroup(CriticismEmployeeFormLayout.createSequentialGroup()
                        .addComponent(moneyCriticismLabel)
                        .addGap(18, 18, 18)
                        .addComponent(moneyTextField)
                        .addContainerGap())))
        );
        CriticismEmployeeFormLayout.setVerticalGroup(
            CriticismEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CriticismEmployeeFormLayout.createSequentialGroup()
                .addComponent(criticismNameEmployeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmployeeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(typeCriticismNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeCriticismComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(CriticismEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moneyCriticismLabel)
                    .addComponent(moneyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(CriticismEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout criticismEmployeeFormContainerLayout = new javax.swing.GroupLayout(criticismEmployeeFormContainer);
        criticismEmployeeFormContainer.setLayout(criticismEmployeeFormContainerLayout);
        criticismEmployeeFormContainerLayout.setHorizontalGroup(
            criticismEmployeeFormContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(criticismEmployeeFormContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(criticismEmployeeFormContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(criticismEmployeeFormContainerLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(CriticismEmployeeForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(criticismEmployeeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
                .addContainerGap())
        );
        criticismEmployeeFormContainerLayout.setVerticalGroup(
            criticismEmployeeFormContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(criticismEmployeeFormContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(criticismEmployeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CriticismEmployeeForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        criticismEmployeeTableContainer.setBackground(new java.awt.Color(255, 255, 255));
        criticismEmployeeTableContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        criticismEmployeeTableContainer.setName("criticismEmployeeTableContainer"); // NOI18N

        CriticismEmployeeTableLabel.setBackground(new java.awt.Color(255, 255, 255));
        CriticismEmployeeTableLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CriticismEmployeeTableLabel.setForeground(new java.awt.Color(51, 51, 0));
        CriticismEmployeeTableLabel.setText("Kỷ Luật Nhân Viên");
        CriticismEmployeeTableLabel.setName("CriticismEmployeeTableLabel"); // NOI18N
        CriticismEmployeeTableLabel.setOpaque(true);

        CriticismEmployeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Loại Kỷ Luật", "Tên Nhân Viên", "Số Tiền Phạt", "Ngày Tạo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CriticismEmployeeTable.setName("degreeTable"); // NOI18N
        CriticismEmployeeTable.setRowHeight(40);
        jScrollPane1.setViewportView(CriticismEmployeeTable);
        if (CriticismEmployeeTable.getColumnModel().getColumnCount() > 0) {
            CriticismEmployeeTable.getColumnModel().getColumn(0).setPreferredWidth(1);
            CriticismEmployeeTable.getColumnModel().getColumn(3).setPreferredWidth(7);
            CriticismEmployeeTable.getColumnModel().getColumn(4).setPreferredWidth(4);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout criticismEmployeeTableContainerLayout = new javax.swing.GroupLayout(criticismEmployeeTableContainer);
        criticismEmployeeTableContainer.setLayout(criticismEmployeeTableContainerLayout);
        criticismEmployeeTableContainerLayout.setHorizontalGroup(
            criticismEmployeeTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(criticismEmployeeTableContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(criticismEmployeeTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CriticismEmployeeTableLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        criticismEmployeeTableContainerLayout.setVerticalGroup(
            criticismEmployeeTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(criticismEmployeeTableContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CriticismEmployeeTableLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(criticismEmployeeFormContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(criticismEmployeeTableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(criticismEmployeeTableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(criticismEmployeeFormContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 993, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void typeCriticismComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeCriticismComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeCriticismComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CriticismEmployeeForm;
    private javax.swing.JTable CriticismEmployeeTable;
    private javax.swing.JLabel CriticismEmployeeTableLabel;
    private javax.swing.JComboBox<String> EmployeeComboBox;
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPanel criticismEmployeeFormContainer;
    private javax.swing.JLabel criticismEmployeeLabel;
    private javax.swing.JPanel criticismEmployeeTableContainer;
    private javax.swing.JLabel criticismNameEmployeeLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel moneyCriticismLabel;
    private javax.swing.JTextField moneyTextField;
    private javax.swing.JComboBox<String> typeCriticismComboBox;
    private javax.swing.JLabel typeCriticismNameLabel1;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
         Component clickedComponent = jPanel1.getComponentAt(jPanel1.getMousePosition());
         if (clickedComponent !=CriticismEmployeeTable && selectionConfirmed) {
           CriticismEmployeeTable.getSelectionModel().clearSelection();
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
