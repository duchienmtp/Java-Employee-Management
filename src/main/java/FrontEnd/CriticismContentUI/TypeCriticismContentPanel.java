
package FrontEnd.CriticismContentUI;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class TypeCriticismContentPanel extends javax.swing.JFrame implements ActionListener, ListSelectionListener, MouseListener {

    int selectedRow = -1;
    boolean selectionConfirmed;
    public TypeCriticismContentPanel() {
        initComponents();
        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
       typeCriticismTable.getSelectionModel().addListSelectionListener(this);
        tableInit();
        jPanel1.addMouseListener(this);
    }

   public void tableInit() {
        Object[] newRowData = {1, "LKL001", "Đi Trễ","100,000", "02/01/2024"};
        DefaultTableModel model = (DefaultTableModel) typeCriticismTable.getModel();
        for (int i = 0; i < 10; i++) {
            model.addRow(newRowData);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        typeCriticismFormContainer = new javax.swing.JPanel();
        TypeCriticismLabel = new javax.swing.JLabel();
        typeCriticismForm = new javax.swing.JPanel();
        typeCriticismIDLabel = new javax.swing.JLabel();
        typeCriticismIDTextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        typeCriticismNameLabel = new javax.swing.JLabel();
        typeCriticismNameTextField = new javax.swing.JTextField();
        cancelBtn = new javax.swing.JButton();
        moneyCriticismTextField1 = new javax.swing.JTextField();
        moneyCriticismLabel1 = new javax.swing.JLabel();
        typeCriticismTableContainer = new javax.swing.JPanel();
        typeCriticismTableLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        typeCriticismTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1055, 640));

        typeCriticismFormContainer.setBackground(new java.awt.Color(255, 255, 255));
        typeCriticismFormContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        typeCriticismFormContainer.setName("typeCriticismFormContainer"); // NOI18N

        TypeCriticismLabel.setBackground(new java.awt.Color(255, 255, 255));
        TypeCriticismLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TypeCriticismLabel.setText("Tạo Loại Kỷ Luật");
        TypeCriticismLabel.setName("TypeCriticismLabel"); // NOI18N
        TypeCriticismLabel.setOpaque(true);

        typeCriticismForm.setBackground(new java.awt.Color(255, 255, 255));
        typeCriticismForm.setName("typeCriticismForm"); // NOI18N

        typeCriticismIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        typeCriticismIDLabel.setText("Mã Loại Kỷ Luật:");
        typeCriticismIDLabel.setName("typeCriticismIDLabel"); // NOI18N

        typeCriticismIDTextField.setBackground(new java.awt.Color(204, 204, 204));
        typeCriticismIDTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        typeCriticismIDTextField.setEnabled(false);
        typeCriticismIDTextField.setName("typeCriticismIDTextField"); // NOI18N

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

        typeCriticismNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        typeCriticismNameLabel.setText("Tên Loại Kỷ Luật:");
        typeCriticismNameLabel.setName("typeCriticismNameLabel"); // NOI18N

        typeCriticismNameTextField.setBackground(new java.awt.Color(204, 204, 204));
        typeCriticismNameTextField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        typeCriticismNameTextField.setName("typeCriticismNameTextField"); // NOI18N

        cancelBtn.setBackground(new java.awt.Color(108, 117, 125));
        cancelBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("Hủy Bỏ");
        cancelBtn.setName("cancelBtn"); // NOI18N

        moneyCriticismTextField1.setBackground(new java.awt.Color(204, 204, 204));
        moneyCriticismTextField1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        moneyCriticismTextField1.setName("typeCriticismNameTextField"); // NOI18N

        moneyCriticismLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        moneyCriticismLabel1.setText("Số Tiền Phạt:");
        moneyCriticismLabel1.setName("typeCriticismNameLabel"); // NOI18N

        javax.swing.GroupLayout typeCriticismFormLayout = new javax.swing.GroupLayout(typeCriticismForm);
        typeCriticismForm.setLayout(typeCriticismFormLayout);
        typeCriticismFormLayout.setHorizontalGroup(
            typeCriticismFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(typeCriticismNameTextField)
            .addComponent(typeCriticismNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(typeCriticismIDTextField, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(typeCriticismIDLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(typeCriticismFormLayout.createSequentialGroup()
                .addComponent(addButton)
                .addGap(18, 18, 18)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
            .addComponent(cancelBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(moneyCriticismTextField1)
            .addComponent(moneyCriticismLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        typeCriticismFormLayout.setVerticalGroup(
            typeCriticismFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typeCriticismFormLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(typeCriticismIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(typeCriticismIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(typeCriticismNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(typeCriticismNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(moneyCriticismLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moneyCriticismTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(typeCriticismFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(typeCriticismFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout typeCriticismFormContainerLayout = new javax.swing.GroupLayout(typeCriticismFormContainer);
        typeCriticismFormContainer.setLayout(typeCriticismFormContainerLayout);
        typeCriticismFormContainerLayout.setHorizontalGroup(
            typeCriticismFormContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typeCriticismFormContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(typeCriticismFormContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typeCriticismForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TypeCriticismLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        typeCriticismFormContainerLayout.setVerticalGroup(
            typeCriticismFormContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typeCriticismFormContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TypeCriticismLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(typeCriticismForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        typeCriticismTableContainer.setBackground(new java.awt.Color(255, 255, 255));
        typeCriticismTableContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        typeCriticismTableContainer.setName("typeCriticismTableContainer"); // NOI18N

        typeCriticismTableLabel.setBackground(new java.awt.Color(255, 255, 255));
        typeCriticismTableLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        typeCriticismTableLabel.setText("Loại Kỷ Luật");
        typeCriticismTableLabel.setName("typeCriticismTableLabel"); // NOI18N
        typeCriticismTableLabel.setOpaque(true);

        typeCriticismTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Loại Kỷ Luật", "Tên Khen Thưởng", "Số Tiền Phạt", "Ngày Tạo"
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
        typeCriticismTable.setName("degreeTable"); // NOI18N
        typeCriticismTable.setRowHeight(40);
        jScrollPane1.setViewportView(typeCriticismTable);
        if (typeCriticismTable.getColumnModel().getColumnCount() > 0) {
            typeCriticismTable.getColumnModel().getColumn(0).setPreferredWidth(1);
            typeCriticismTable.getColumnModel().getColumn(4).setPreferredWidth(3);
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

        javax.swing.GroupLayout typeCriticismTableContainerLayout = new javax.swing.GroupLayout(typeCriticismTableContainer);
        typeCriticismTableContainer.setLayout(typeCriticismTableContainerLayout);
        typeCriticismTableContainerLayout.setHorizontalGroup(
            typeCriticismTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, typeCriticismTableContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(typeCriticismTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(typeCriticismTableLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        typeCriticismTableContainerLayout.setVerticalGroup(
            typeCriticismTableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typeCriticismTableContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(typeCriticismTableLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(typeCriticismFormContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(typeCriticismTableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(typeCriticismFormContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(typeCriticismTableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TypeCriticismContentPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TypeCriticismContentPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TypeCriticismContentPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TypeCriticismContentPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TypeCriticismContentPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TypeCriticismLabel;
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel moneyCriticismLabel1;
    private javax.swing.JTextField moneyCriticismTextField1;
    private javax.swing.JPanel typeCriticismForm;
    private javax.swing.JPanel typeCriticismFormContainer;
    private javax.swing.JLabel typeCriticismIDLabel;
    private javax.swing.JTextField typeCriticismIDTextField;
    private javax.swing.JLabel typeCriticismNameLabel;
    private javax.swing.JTextField typeCriticismNameTextField;
    private javax.swing.JTable typeCriticismTable;
    private javax.swing.JPanel typeCriticismTableContainer;
    private javax.swing.JLabel typeCriticismTableLabel;
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
         if (clickedComponent !=typeCriticismTable && selectionConfirmed) {
           typeCriticismTable.getSelectionModel().clearSelection();
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
