/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FrontEnd.RewardContentUI;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
public class RewardEmployeePanel extends javax.swing.JPanel implements ActionListener, ListSelectionListener, MouseListener {

    int selectedRow = -1;
    boolean selectionConfirmed;
    public RewardEmployeePanel() {
        initComponents();
   addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        RewardEmployeeTable.getSelectionModel().addListSelectionListener(this);
        tableInit();
        jPanel1.addMouseListener(this);
    }

   public void tableInit() {
        Object[] newRowData = {1,"Nguyễn Văn Thành", "LKT001","1,000,000", "02/01/2024"};
        DefaultTableModel model = (DefaultTableModel) RewardEmployeeTable.getModel();
        for (int i = 0; i < 10; i++) {
            model.addRow(newRowData);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rewardEmployeeFormContainer = new javax.swing.JPanel();
        RewardEmployeeLabel = new javax.swing.JLabel();
        RewardEmployeeForm = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        typeRewardNameLabel1 = new javax.swing.JLabel();
        EmployeeComboBox = new javax.swing.JComboBox<>();
        typeRewardComboBox = new javax.swing.JComboBox<>();
        moneyLabel = new javax.swing.JLabel();
        moneyTextField = new javax.swing.JTextField();
        RewardNameEmployeeLabel = new javax.swing.JLabel();
        rewardEmployeeTableContainer = new javax.swing.JPanel();
        RewardEmployeeTableLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RewardEmployeeTable = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1055, 640));

        rewardEmployeeFormContainer.setBackground(new java.awt.Color(255, 255, 255));
        rewardEmployeeFormContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        rewardEmployeeFormContainer.setName("rewardEmployeeFormContainer"); // NOI18N

        RewardEmployeeLabel.setBackground(new java.awt.Color(255, 255, 255));
        RewardEmployeeLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        RewardEmployeeLabel.setForeground(new java.awt.Color(0, 102, 0));
        RewardEmployeeLabel.setText("Tạo Khen Thưởng");
        RewardEmployeeLabel.setName("RewardEmployeeLabel"); // NOI18N
        RewardEmployeeLabel.setOpaque(true);

        RewardEmployeeForm.setBackground(new java.awt.Color(255, 255, 255));
        RewardEmployeeForm.setName("RewardEmployeeForm"); // NOI18N

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

        cancelBtn.setBackground(new java.awt.Color(108, 117, 125));
        cancelBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("Hủy Bỏ");
        cancelBtn.setName("cancelBtn"); // NOI18N

        typeRewardNameLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        typeRewardNameLabel1.setForeground(new java.awt.Color(0, 102, 0));
        typeRewardNameLabel1.setText("Chọn Loại Khen Thưởng:");
        typeRewardNameLabel1.setName("typeRewardNameLabel"); // NOI18N

        EmployeeComboBox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EmployeeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        typeRewardComboBox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        typeRewardComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        typeRewardComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeRewardComboBoxActionPerformed(evt);
            }
        });

        moneyLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        moneyLabel.setForeground(new java.awt.Color(0, 102, 0));
        moneyLabel.setText("Số Tiền Thưởng:");

        moneyTextField.setEditable(false);
        moneyTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        moneyTextField.setText("500,000");
        moneyTextField.setEnabled(false);
        moneyTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moneyTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RewardEmployeeFormLayout = new javax.swing.GroupLayout(RewardEmployeeForm);
        RewardEmployeeForm.setLayout(RewardEmployeeFormLayout);
        RewardEmployeeFormLayout.setHorizontalGroup(
            RewardEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RewardEmployeeFormLayout.createSequentialGroup()
                .addGroup(RewardEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RewardEmployeeFormLayout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                    .addGroup(RewardEmployeeFormLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(RewardEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(typeRewardNameLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EmployeeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(typeRewardComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(RewardEmployeeFormLayout.createSequentialGroup()
                                .addComponent(moneyLabel)
                                .addGap(18, 18, 18)
                                .addComponent(moneyTextField))
                            .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        RewardEmployeeFormLayout.setVerticalGroup(
            RewardEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RewardEmployeeFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EmployeeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeRewardNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeRewardComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(RewardEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moneyLabel)
                    .addComponent(moneyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(RewardEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        RewardNameEmployeeLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RewardNameEmployeeLabel.setForeground(new java.awt.Color(0, 102, 0));
        RewardNameEmployeeLabel.setText("Chọn Nhân Viên");
        RewardNameEmployeeLabel.setName("typeRewardNameLabel"); // NOI18N

        javax.swing.GroupLayout rewardEmployeeFormContainerLayout = new javax.swing.GroupLayout(rewardEmployeeFormContainer);
        rewardEmployeeFormContainer.setLayout(rewardEmployeeFormContainerLayout);
        rewardEmployeeFormContainerLayout.setHorizontalGroup(
            rewardEmployeeFormContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rewardEmployeeFormContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rewardEmployeeFormContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RewardEmployeeForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RewardEmployeeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(rewardEmployeeFormContainerLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(RewardNameEmployeeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        rewardEmployeeFormContainerLayout.setVerticalGroup(
            rewardEmployeeFormContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rewardEmployeeFormContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RewardEmployeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RewardNameEmployeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RewardEmployeeForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rewardEmployeeTableContainer.setBackground(new java.awt.Color(255, 255, 255));
        rewardEmployeeTableContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        rewardEmployeeTableContainer.setName("rewardEmployeeTableContainer"); // NOI18N

        RewardEmployeeTableLabel.setBackground(new java.awt.Color(255, 255, 255));
        RewardEmployeeTableLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        RewardEmployeeTableLabel.setForeground(new java.awt.Color(0, 102, 0));
        RewardEmployeeTableLabel.setText("Khen Thưởng Nhân Viên");
        RewardEmployeeTableLabel.setName("RewardEmployeeTableLabel"); // NOI18N
        RewardEmployeeTableLabel.setOpaque(true);

        RewardEmployeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên Nhân Viên", "Mã Loại Khen Thưởng", "Số Tiền", "Ngày Tạo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        RewardEmployeeTable.setName("degreeTable"); // NOI18N
        RewardEmployeeTable.setRowHeight(40);
        jScrollPane1.setViewportView(RewardEmployeeTable);
        if (RewardEmployeeTable.getColumnModel().getColumnCount() > 0) {
            RewardEmployeeTable.getColumnModel().getColumn(0).setPreferredWidth(1);
            RewardEmployeeTable.getColumnModel().getColumn(3).setPreferredWidth(4);
            RewardEmployeeTable.getColumnModel().getColumn(4).setPreferredWidth(3);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout rewardEmployeeTableContainerLayout = new javax.swing.GroupLayout(rewardEmployeeTableContainer);
        rewardEmployeeTableContainer.setLayout(rewardEmployeeTableContainerLayout);
        rewardEmployeeTableContainerLayout.setHorizontalGroup(
            rewardEmployeeTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rewardEmployeeTableContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rewardEmployeeTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RewardEmployeeTableLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        rewardEmployeeTableContainerLayout.setVerticalGroup(
            rewardEmployeeTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rewardEmployeeTableContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RewardEmployeeTableLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(rewardEmployeeFormContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rewardEmployeeTableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rewardEmployeeFormContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rewardEmployeeTableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void typeRewardComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeRewardComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeRewardComboBoxActionPerformed

    private void moneyTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moneyTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moneyTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> EmployeeComboBox;
    private javax.swing.JPanel RewardEmployeeForm;
    private javax.swing.JLabel RewardEmployeeLabel;
    private javax.swing.JTable RewardEmployeeTable;
    private javax.swing.JLabel RewardEmployeeTableLabel;
    private javax.swing.JLabel RewardNameEmployeeLabel;
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel moneyLabel;
    private javax.swing.JTextField moneyTextField;
    private javax.swing.JPanel rewardEmployeeFormContainer;
    private javax.swing.JPanel rewardEmployeeTableContainer;
    private javax.swing.JComboBox<String> typeRewardComboBox;
    private javax.swing.JLabel typeRewardNameLabel1;
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
        if (clickedComponent !=RewardEmployeeTable && selectionConfirmed) {
            RewardEmployeeTable.getSelectionModel().clearSelection();
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
