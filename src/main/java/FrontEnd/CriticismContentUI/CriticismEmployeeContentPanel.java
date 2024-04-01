/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FrontEnd.CriticismContentUI;

/**
 *
 * @author admin
 */
public class CriticismEmployeeContentPanel extends javax.swing.JFrame {

    /**
     * Creates new form CriticismEmployeeContentPanel
     */
    public CriticismEmployeeContentPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        criticismEmployeeFormContainer = new javax.swing.JPanel();
        criticismEmployeeLabel = new javax.swing.JLabel();
        CriticismEmployeeForm = new javax.swing.JPanel();
        criticismIDLabel = new javax.swing.JLabel();
        CriticismIDTextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        criticismNameLabel = new javax.swing.JLabel();
        criticismNameTextField = new javax.swing.JTextField();
        cancelBtn = new javax.swing.JButton();
        criticismNumLabel = new javax.swing.JLabel();
        criticismNumTextField = new javax.swing.JTextField();
        typeCriticismNameLabel1 = new javax.swing.JLabel();
        EmployeeComboBox = new javax.swing.JComboBox<>();
        criticismNameEmployeeLabel = new javax.swing.JLabel();
        typeCriticismComboBox = new javax.swing.JComboBox<>();
        moneyCriticismLabel = new javax.swing.JLabel();
        moneyCriticismSpinner = new javax.swing.JSpinner();
        criticismEmployeeTableContainer = new javax.swing.JPanel();
        CriticismEmployeeTableLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CriticismEmployeeTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1055, 640));

        criticismEmployeeFormContainer.setBackground(new java.awt.Color(255, 255, 255));
        criticismEmployeeFormContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        criticismEmployeeFormContainer.setName("criticismEmployeeFormContainer"); // NOI18N

        criticismEmployeeLabel.setBackground(new java.awt.Color(255, 255, 255));
        criticismEmployeeLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        criticismEmployeeLabel.setText("Tạo Kỷ Luật");
        criticismEmployeeLabel.setName("criticismEmployeeLabel"); // NOI18N
        criticismEmployeeLabel.setOpaque(true);

        CriticismEmployeeForm.setBackground(new java.awt.Color(255, 255, 255));
        CriticismEmployeeForm.setName("CriticismEmployeeForm"); // NOI18N

        criticismIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        criticismIDLabel.setText("Mã Kỷ Luật:");
        criticismIDLabel.setName("criticismIDLabel"); // NOI18N

        CriticismIDTextField.setBackground(new java.awt.Color(204, 204, 204));
        CriticismIDTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CriticismIDTextField.setEnabled(false);
        CriticismIDTextField.setName("CriticismIDTextField"); // NOI18N
        CriticismIDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CriticismIDTextFieldActionPerformed(evt);
            }
        });

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

        criticismNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        criticismNameLabel.setText("Tên Kỷ Luật :");
        criticismNameLabel.setName("criticismNameLabel"); // NOI18N

        criticismNameTextField.setBackground(new java.awt.Color(204, 204, 204));
        criticismNameTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        criticismNameTextField.setName("criticismNameTextField"); // NOI18N

        cancelBtn.setBackground(new java.awt.Color(108, 117, 125));
        cancelBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("Hủy Bỏ");
        cancelBtn.setName("cancelBtn"); // NOI18N

        criticismNumLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        criticismNumLabel.setText("Số Quyết Định :");
        criticismNumLabel.setName("typeRewardNameLabel"); // NOI18N

        criticismNumTextField.setBackground(new java.awt.Color(204, 204, 204));
        criticismNumTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        criticismNumTextField.setName("typeRewardNameTextField"); // NOI18N

        typeCriticismNameLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        typeCriticismNameLabel1.setText("Chọn Loại Kỷ Luật:");
        typeCriticismNameLabel1.setName("typeRewardNameLabel"); // NOI18N

        EmployeeComboBox.setEditable(true);
        EmployeeComboBox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EmployeeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        criticismNameEmployeeLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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
        moneyCriticismLabel.setText("Số Tiền Phạt:");

        javax.swing.GroupLayout CriticismEmployeeFormLayout = new javax.swing.GroupLayout(CriticismEmployeeForm);
        CriticismEmployeeForm.setLayout(CriticismEmployeeFormLayout);
        CriticismEmployeeFormLayout.setHorizontalGroup(
            CriticismEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CriticismEmployeeFormLayout.createSequentialGroup()
                .addGroup(CriticismEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CriticismEmployeeFormLayout.createSequentialGroup()
                        .addComponent(criticismNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(criticismNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CriticismEmployeeFormLayout.createSequentialGroup()
                        .addComponent(criticismIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(CriticismIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52))
            .addGroup(CriticismEmployeeFormLayout.createSequentialGroup()
                .addComponent(criticismNumLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(CriticismEmployeeFormLayout.createSequentialGroup()
                .addComponent(criticismNumTextField)
                .addContainerGap())
            .addGroup(CriticismEmployeeFormLayout.createSequentialGroup()
                .addComponent(criticismNameEmployeeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(CriticismEmployeeFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CriticismEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typeCriticismNameLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EmployeeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(typeCriticismComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(CriticismEmployeeFormLayout.createSequentialGroup()
                        .addComponent(moneyCriticismLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(moneyCriticismSpinner))
                    .addGroup(CriticismEmployeeFormLayout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        CriticismEmployeeFormLayout.setVerticalGroup(
            CriticismEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CriticismEmployeeFormLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(CriticismEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(criticismIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CriticismIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CriticismEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(criticismNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(criticismNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(criticismNumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(criticismNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(criticismNameEmployeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmployeeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeCriticismNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeCriticismComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CriticismEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moneyCriticismSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moneyCriticismLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
                        .addComponent(CriticismEmployeeForm, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
        CriticismEmployeeTableLabel.setText("Kỷ Luật Nhân Viên");
        CriticismEmployeeTableLabel.setName("CriticismEmployeeTableLabel"); // NOI18N
        CriticismEmployeeTableLabel.setOpaque(true);

        CriticismEmployeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Kỷ Luật", "Tên Kỷ Luật", "Tên Nhân Viên", "Mã Loại Kỷ Luật", "Số Quyết Định", "Số Tiền Phạt", "Ngày Tạo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true
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
                .addContainerGap(95, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 993, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CriticismIDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CriticismIDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CriticismIDTextFieldActionPerformed

    private void typeCriticismComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeCriticismComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeCriticismComboBoxActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CriticismEmployeeContentPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CriticismEmployeeContentPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CriticismEmployeeContentPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CriticismEmployeeContentPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CriticismEmployeeContentPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CriticismEmployeeForm;
    private javax.swing.JTable CriticismEmployeeTable;
    private javax.swing.JLabel CriticismEmployeeTableLabel;
    private javax.swing.JTextField CriticismIDTextField;
    private javax.swing.JComboBox<String> EmployeeComboBox;
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPanel criticismEmployeeFormContainer;
    private javax.swing.JLabel criticismEmployeeLabel;
    private javax.swing.JPanel criticismEmployeeTableContainer;
    private javax.swing.JLabel criticismIDLabel;
    private javax.swing.JLabel criticismNameEmployeeLabel;
    private javax.swing.JLabel criticismNameLabel;
    private javax.swing.JTextField criticismNameTextField;
    private javax.swing.JLabel criticismNumLabel;
    private javax.swing.JTextField criticismNumTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel moneyCriticismLabel;
    private javax.swing.JSpinner moneyCriticismSpinner;
    private javax.swing.JComboBox<String> typeCriticismComboBox;
    private javax.swing.JLabel typeCriticismNameLabel1;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
