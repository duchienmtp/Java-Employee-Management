/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FrontEnd.AccountContentUI;

/**
 *
 * @author PC
 */
public class Taotaikhoan extends javax.swing.JPanel {

    /**
     * Creates new form Taotaikhoan
     */
    public Taotaikhoan() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ChontepButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Hotxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Tentxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Emailtxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Sodienthoaitxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Matkhautxt = new javax.swing.JTextField();
        NhanvienComboBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Nhaplaimatkhautxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        QuanlyRadioButton = new javax.swing.JRadioButton();
        NhanvienRadioButton = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        DanghoatdongRadioButton = new javax.swing.JRadioButton();
        NgunghoatdongRadioButton = new javax.swing.JRadioButton();
        TaotaikhoanButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Tạo tài khoản");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Chọn ảnh");

        ChontepButton.setBackground(java.awt.Color.gray);
        ChontepButton.setForeground(java.awt.Color.white);
        ChontepButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/i2.png"))); // NOI18N
        ChontepButton.setText("Chọn tệp");
        ChontepButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChontepButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Vui lòng chọn đúng file định dạng: .jpg, .png");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Chọn nhân viên ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Họ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tên");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Email");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Số điện thoại");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Mật khẩu");

        NhanvienComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên 1", "Nhân viên 2", "Nhân viên 3", "Nhân viên 4", "Nhân viên 5", " " }));

        jLabel10.setText("Trên 6 ký tự, phải có 1 chữ thường , 1 chữ hoa và 1 ký tự đặc biệt");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Nhập lại mật khẩu");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Quyền hạn");

        QuanlyRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        QuanlyRadioButton.setText("Quản lý");

        NhanvienRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NhanvienRadioButton.setText("Nhân viên");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Trạng thái");

        DanghoatdongRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DanghoatdongRadioButton.setText("Đang hoạt động");

        NgunghoatdongRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NgunghoatdongRadioButton.setText("Ngưng hoạt động");

        TaotaikhoanButton.setBackground(java.awt.Color.green);
        TaotaikhoanButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TaotaikhoanButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        TaotaikhoanButton.setText("Tạo tài khoản");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(TaotaikhoanButton)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DanghoatdongRadioButton)
                            .addComponent(QuanlyRadioButton))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NhanvienRadioButton)
                            .addComponent(NgunghoatdongRadioButton)))
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(ChontepButton)))
                .addGap(0, 278, Short.MAX_VALUE))
            .addComponent(NhanvienComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Hotxt)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Nhaplaimatkhautxt, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Matkhautxt, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Sodienthoaitxt, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Emailtxt, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tentxt))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ChontepButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NhanvienComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Hotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Tentxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Emailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Sodienthoaitxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Matkhautxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Nhaplaimatkhautxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QuanlyRadioButton)
                    .addComponent(NhanvienRadioButton))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DanghoatdongRadioButton)
                    .addComponent(NgunghoatdongRadioButton))
                .addGap(18, 18, 18)
                .addComponent(TaotaikhoanButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ChontepButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChontepButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChontepButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ChontepButton;
    private javax.swing.JRadioButton DanghoatdongRadioButton;
    private javax.swing.JTextField Emailtxt;
    private javax.swing.JTextField Hotxt;
    private javax.swing.JTextField Matkhautxt;
    private javax.swing.JRadioButton NgunghoatdongRadioButton;
    private javax.swing.JComboBox<String> NhanvienComboBox;
    private javax.swing.JRadioButton NhanvienRadioButton;
    private javax.swing.JTextField Nhaplaimatkhautxt;
    private javax.swing.JRadioButton QuanlyRadioButton;
    private javax.swing.JTextField Sodienthoaitxt;
    private javax.swing.JButton TaotaikhoanButton;
    private javax.swing.JTextField Tentxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}