package FrontEnd.UserInfoContentUI;

public class UserInfoContentPanel extends javax.swing.JPanel {

    public UserInfoContentPanel() {
        initComponents();

        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Thongtintaikhoan = new javax.swing.JLabel();
        emloyeeAvatar = new javax.swing.JPanel();
        Tennhanvien = new javax.swing.JLabel();
        Manhanvien = new javax.swing.JLabel();
        Ho = new javax.swing.JLabel();
        Ten = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        Sodienthoai = new javax.swing.JLabel();
        Matkhau = new javax.swing.JLabel();
        Quyenhan = new javax.swing.JLabel();
        Trangthai = new javax.swing.JLabel();
        Manhanvientxt = new javax.swing.JTextField();
        Hotxt = new javax.swing.JTextField();
        Tentxt = new javax.swing.JTextField();
        Emailtxt = new javax.swing.JTextField();
        Sodienthoaitxt = new javax.swing.JTextField();
        Matkhautxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ChinhsuaButton = new javax.swing.JButton();

        setBackground(java.awt.Color.white);
        setName("userInfoContentPanel"); // NOI18N

        Thongtintaikhoan.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Thongtintaikhoan.setText("Thông tin tài khoản");

        emloyeeAvatar.setBackground(new java.awt.Color(255, 255, 255));
        emloyeeAvatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        emloyeeAvatar.setToolTipText("");
        emloyeeAvatar.setMinimumSize(new java.awt.Dimension(300, 300));
        emloyeeAvatar.setName("emloyeeAvatar"); // NOI18N
        emloyeeAvatar.setPreferredSize(new java.awt.Dimension(150, 150));

        javax.swing.GroupLayout emloyeeAvatarLayout = new javax.swing.GroupLayout(emloyeeAvatar);
        emloyeeAvatar.setLayout(emloyeeAvatarLayout);
        emloyeeAvatarLayout.setHorizontalGroup(
            emloyeeAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        emloyeeAvatarLayout.setVerticalGroup(
            emloyeeAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Tennhanvien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Tennhanvien.setText("Nhân viên 1");

        Manhanvien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Manhanvien.setText("Mã nhân viên:");

        Ho.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Ho.setText("Họ:");

        Ten.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Ten.setText("Tên:");

        Email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Email.setText("Email:");

        Sodienthoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Sodienthoai.setText("Số điện thoại:");

        Matkhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Matkhau.setText("Mật khẩu:");

        Quyenhan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Quyenhan.setText("Quyền hạn:");

        Trangthai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Trangthai.setText("Trạng thái:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Nhân viên");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Đang hoạt động");

        ChinhsuaButton.setBackground(java.awt.Color.cyan);
        ChinhsuaButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ChinhsuaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        ChinhsuaButton.setText("Chỉnh sửa");
        ChinhsuaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChinhsuaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Thongtintaikhoan)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(emloyeeAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(Tennhanvien)))
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ChinhsuaButton)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Sodienthoai)
                        .addGap(18, 18, 18)
                        .addComponent(Sodienthoaitxt, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Email)
                        .addGap(18, 18, 18)
                        .addComponent(Emailtxt))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Manhanvien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Manhanvientxt))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Ho)
                        .addGap(26, 26, 26)
                        .addComponent(Hotxt))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Ten)
                        .addGap(18, 18, 18)
                        .addComponent(Tentxt))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Matkhau)
                            .addComponent(Quyenhan)
                            .addComponent(Trangthai))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(Matkhautxt))))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Thongtintaikhoan)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emloyeeAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Manhanvien)
                            .addComponent(Manhanvientxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Ho)
                            .addComponent(Hotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Ten)
                            .addComponent(Tentxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tennhanvien)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Email)
                        .addComponent(Emailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sodienthoai)
                    .addComponent(Sodienthoaitxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Matkhau)
                    .addComponent(Matkhautxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Quyenhan)
                    .addComponent(jLabel11))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Trangthai)
                    .addComponent(jLabel12))
                .addGap(43, 43, 43)
                .addComponent(ChinhsuaButton)
                .addGap(0, 15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ChinhsuaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChinhsuaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChinhsuaButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ChinhsuaButton;
    private javax.swing.JLabel Email;
    private javax.swing.JTextField Emailtxt;
    private javax.swing.JLabel Ho;
    private javax.swing.JTextField Hotxt;
    private javax.swing.JLabel Manhanvien;
    private javax.swing.JTextField Manhanvientxt;
    private javax.swing.JLabel Matkhau;
    private javax.swing.JTextField Matkhautxt;
    private javax.swing.JLabel Quyenhan;
    private javax.swing.JLabel Sodienthoai;
    private javax.swing.JTextField Sodienthoaitxt;
    private javax.swing.JLabel Ten;
    private javax.swing.JLabel Tennhanvien;
    private javax.swing.JTextField Tentxt;
    private javax.swing.JLabel Thongtintaikhoan;
    private javax.swing.JLabel Trangthai;
    private javax.swing.JPanel emloyeeAvatar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    // End of variables declaration//GEN-END:variables
}
