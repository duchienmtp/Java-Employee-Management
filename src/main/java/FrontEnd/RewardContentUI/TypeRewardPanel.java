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
public class TypeRewardPanel extends javax.swing.JPanel implements ActionListener, ListSelectionListener, MouseListener {

    int selectedRow = -1;
    boolean selectionConfirmed;
    public TypeRewardPanel() {
        initComponents();
   addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        typeRewardTable.getSelectionModel().addListSelectionListener(this);
        tableInit();
        jPanel1.addMouseListener(this);
    }

     public void tableInit() {
        Object[] newRowData = {1, "LKT001", "Nhân viên của năm","1,000,000", "02/01/2024"};
        DefaultTableModel model = (DefaultTableModel) typeRewardTable.getModel();
        for (int i = 0; i < 10; i++) {
            model.addRow(newRowData);
        }
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
        cancelBtn = new javax.swing.JButton();
        moneyRewardLabel1 = new javax.swing.JLabel();
        moneyRewardNameTextField1 = new javax.swing.JTextField();
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

        TypeRewardLabel.setBackground(new java.awt.Color(255, 255, 255));
        TypeRewardLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TypeRewardLabel.setForeground(new java.awt.Color(0, 102, 51));
        TypeRewardLabel.setText("Tạo Loại Khen Thưởng");
        TypeRewardLabel.setName("TypeRewardLabel"); // NOI18N
        TypeRewardLabel.setOpaque(true);

        typeRewardForm.setBackground(new java.awt.Color(255, 255, 255));
        typeRewardForm.setName("typeRewardForm"); // NOI18N

        typeRewardIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        typeRewardIDLabel.setForeground(new java.awt.Color(0, 102, 51));
        typeRewardIDLabel.setText("Mã Loại Khen Thưởng:");
        typeRewardIDLabel.setName("typeRewardIDLabel"); // NOI18N

        typeRewardIDTextField.setBackground(new java.awt.Color(204, 204, 204));
        typeRewardIDTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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
        typeRewardNameLabel.setForeground(new java.awt.Color(0, 102, 0));
        typeRewardNameLabel.setText("Tên Loại Khen Thưởng :");
        typeRewardNameLabel.setName("typeRewardNameLabel"); // NOI18N

        typeRewardNameTextField.setBackground(new java.awt.Color(204, 204, 204));
        typeRewardNameTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        typeRewardNameTextField.setName("typeRewardNameTextField"); // NOI18N

        cancelBtn.setBackground(new java.awt.Color(108, 117, 125));
        cancelBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("Hủy Bỏ");
        cancelBtn.setName("cancelBtn"); // NOI18N

        moneyRewardLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        moneyRewardLabel1.setForeground(new java.awt.Color(0, 102, 0));
        moneyRewardLabel1.setText("Số Tiền Thưởng :");
        moneyRewardLabel1.setName("typeRewardNameLabel"); // NOI18N

        moneyRewardNameTextField1.setBackground(new java.awt.Color(204, 204, 204));
        moneyRewardNameTextField1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        moneyRewardNameTextField1.setName("typeRewardNameTextField"); // NOI18N

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
                .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
            .addComponent(cancelBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(moneyRewardLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(typeRewardFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(moneyRewardNameTextField1)
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moneyRewardLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(moneyRewardNameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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

        typeRewardTableLabel.setBackground(new java.awt.Color(255, 255, 255));
        typeRewardTableLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        typeRewardTableLabel.setForeground(new java.awt.Color(0, 102, 0));
        typeRewardTableLabel.setText("Loại Khen Thưởng");
        typeRewardTableLabel.setName("typeRewardTableLabel"); // NOI18N
        typeRewardTableLabel.setOpaque(true);

        typeRewardTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Loại Khen Thưởng", "Tên Khen Thưởng", "Số Tiền Thưởng", "Ngày Tạo"
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
        typeRewardTable.setName("degreeTable"); // NOI18N
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
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addGap(0, 0, 0))
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
                .addComponent(typeRewardTableLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(typeRewardTableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(typeRewardFormContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(typeRewardTableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TypeRewardLabel;
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel moneyRewardLabel1;
    private javax.swing.JTextField moneyRewardNameTextField1;
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
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Component clickedComponent = jPanel1.getComponentAt(jPanel1.getMousePosition());
        if (clickedComponent !=typeRewardTable && selectionConfirmed) {
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