package FrontEnd.RewardContentUI;


public class RewardContentPanel extends javax.swing.JPanel {

    
    public RewardContentPanel() {
        initComponents();
        setVisible(true);
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rewardContainer = new javax.swing.JPanel();
        appMenu = new javax.swing.JPanel();
        typeRewardBtn = new javax.swing.JButton();
        rewardEmployeeBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 255, 204));
        setName("rewardContentPanel"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1000, 740));
        setLayout(new java.awt.GridLayout(1, 0));

        jpanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(0, 255, 204));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        rewardContainer.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout rewardContainerLayout = new javax.swing.GroupLayout(rewardContainer);
        rewardContainer.setLayout(rewardContainerLayout);
        rewardContainerLayout.setHorizontalGroup(
            rewardContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1500, Short.MAX_VALUE)
        );
        rewardContainerLayout.setVerticalGroup(
            rewardContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
        );

        typeRewardBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        typeRewardBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\OneDrive\\Documents\\NetBeansProjects\\Employee-Management\\Java-Employee-Management\\src\\main\\resources\\images\\add.png")); // NOI18N
        typeRewardBtn.setText("Loại Khen Thưởng");
        typeRewardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeRewardBtnActionPerformed(evt);
            }
        });

        rewardEmployeeBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rewardEmployeeBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\OneDrive\\Documents\\NetBeansProjects\\Employee-Management\\Java-Employee-Management\\src\\main\\resources\\images\\star.png")); // NOI18N
        rewardEmployeeBtn.setText("Thêm Khen Thưởng");
        rewardEmployeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rewardEmployeeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout appMenuLayout = new javax.swing.GroupLayout(appMenu);
        appMenu.setLayout(appMenuLayout);
        appMenuLayout.setHorizontalGroup(
            appMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(typeRewardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127)
                .addComponent(rewardEmployeeBtn)
                .addContainerGap(963, Short.MAX_VALUE))
        );
        appMenuLayout.setVerticalGroup(
            appMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appMenuLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(appMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeRewardBtn)
                    .addComponent(rewardEmployeeBtn))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jpanel1Layout = new javax.swing.GroupLayout(jpanel1);
        jpanel1.setLayout(jpanel1Layout);
        jpanel1Layout.setHorizontalGroup(
            jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpanel1Layout.createSequentialGroup()
                .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(appMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rewardContainer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpanel1Layout.setVerticalGroup(
            jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel1Layout.createSequentialGroup()
                .addComponent(appMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rewardContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jpanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void typeRewardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeRewardBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeRewardBtnActionPerformed

    private void rewardEmployeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rewardEmployeeBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rewardEmployeeBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel appMenu;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpanel1;
    private javax.swing.JPanel rewardContainer;
    private javax.swing.JButton rewardEmployeeBtn;
    private javax.swing.JButton typeRewardBtn;
    // End of variables declaration//GEN-END:variables

}
