package FrontEnd.RewardContentUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class RewardContentPanel extends javax.swing.JPanel implements ActionListener {
     TypeRewardPanel typeRewardContentPanel1;
     RewardEmployeePanel rewardEmployeeContentPanel;
    
    public RewardContentPanel() {
        initComponents();
        //setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        rewardContainer.setLayout(new GridLayout(1, 1));
        showTypeRewardContentPanel();

       typeRewardBtn.addActionListener(this);
       rewardEmployeeBtn.addActionListener(this);
       
        setVisible(true);
    }
     @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == typeRewardBtn) {
            showTypeRewardContentPanel();
        } else if (e.getSource() == rewardEmployeeBtn) {
            showRewardEmployeeContentPanel();
        }
    }
    private void clearPanel() {
        rewardContainer.removeAll();
        rewardContainer.revalidate();
        rewardContainer.repaint();
    }
    private void showTypeRewardContentPanel() {
         clearPanel();
        typeRewardContentPanel1 = new TypeRewardPanel();
        rewardContainer.add(typeRewardContentPanel1);
        rewardContainer.revalidate();
        rewardContainer.repaint();
    }

    private void showRewardEmployeeContentPanel() {
        clearPanel();
        rewardEmployeeContentPanel = new RewardEmployeePanel();
        rewardContainer.add(rewardEmployeeContentPanel);
        rewardContainer.revalidate();
        rewardContainer.repaint();
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rewardContainer = new javax.swing.JPanel();
        addMenu = new javax.swing.JPanel();
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
            .addGap(0, 1485, Short.MAX_VALUE)
        );
        rewardContainerLayout.setVerticalGroup(
            rewardContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
        );

        addMenu.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout addMenuLayout = new javax.swing.GroupLayout(addMenu);
        addMenu.setLayout(addMenuLayout);
        addMenuLayout.setHorizontalGroup(
            addMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addMenuLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(typeRewardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(rewardEmployeeBtn)
                .addContainerGap(957, Short.MAX_VALUE))
        );
        addMenuLayout.setVerticalGroup(
            addMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addMenuLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(addMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeRewardBtn)
                    .addComponent(rewardEmployeeBtn))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jpanel1Layout = new javax.swing.GroupLayout(jpanel1);
        jpanel1.setLayout(jpanel1Layout);
        jpanel1Layout.setHorizontalGroup(
            jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1506, Short.MAX_VALUE)
            .addGroup(jpanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel1Layout.createSequentialGroup()
                        .addComponent(rewardContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15))
                    .addGroup(jpanel1Layout.createSequentialGroup()
                        .addComponent(addMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jpanel1Layout.setVerticalGroup(
            jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rewardContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jpanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void rewardEmployeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rewardEmployeeBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rewardEmployeeBtnActionPerformed

    private void typeRewardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeRewardBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeRewardBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addMenu;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpanel1;
    private javax.swing.JPanel rewardContainer;
    private javax.swing.JButton rewardEmployeeBtn;
    private javax.swing.JButton typeRewardBtn;
    // End of variables declaration//GEN-END:variables


}
