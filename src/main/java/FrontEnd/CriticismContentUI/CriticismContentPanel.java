package FrontEnd.CriticismContentUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CriticismContentPanel extends javax.swing.JPanel implements ActionListener {

    TypeCriticismContentPanel typeCriticismContentPanel;
    CriticismEmployeeContentPanel criticismEmployeeContentPanel;
    public CriticismContentPanel() {
        initComponents();
//         typeCriticismContentPanel = new TypeCriticismContentPanel();
//       criticismContainer.setLayout(new GridLayout(1, 1));
//       showTypeCriticismContentPanel();
        typeCriticismBtn.addActionListener(this);
        criticismEmployeeBtn.addActionListener(this);
        
        
        setVisible(true);
    }
     @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == typeCriticismBtn) {
            showTypeCriticismContentPanel();
        } else if (e.getSource() == criticismEmployeeBtn) {
            showCriticismEmployeeContentPanel();
        }
    }

    private void clearPanel() {
        criticismContainer.removeAll();
        criticismContainer.revalidate();
        criticismContainer.repaint();
    }

    private void showTypeCriticismContentPanel() {
        clearPanel();
       typeCriticismContentPanel = new TypeCriticismContentPanel();
        criticismContainer.add(typeCriticismContentPanel);
        criticismContainer.revalidate();
        criticismContainer.repaint();
    }

    private void showCriticismEmployeeContentPanel() {
        clearPanel();
        criticismEmployeeContentPanel = new CriticismEmployeeContentPanel();
        criticismContainer.add(criticismEmployeeContentPanel);
        criticismContainer.revalidate();
        criticismContainer.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addCriticism = new javax.swing.JPanel();
        typeCriticismBtn = new javax.swing.JButton();
        criticismEmployeeBtn = new javax.swing.JButton();
        criticismContainer = new javax.swing.JPanel();

        setBackground(new java.awt.Color(153, 153, 255));
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);

        addCriticism.setBackground(new java.awt.Color(204, 204, 204));

        typeCriticismBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        typeCriticismBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\OneDrive\\Documents\\NetBeansProjects\\Employee-Management\\Java-Employee-Management\\src\\main\\resources\\images\\add.png")); // NOI18N
        typeCriticismBtn.setText("Thêm Loại Kỷ Luật");

        criticismEmployeeBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        criticismEmployeeBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\OneDrive\\Documents\\NetBeansProjects\\Employee-Management\\Java-Employee-Management\\src\\main\\resources\\images\\hammer.png")); // NOI18N
        criticismEmployeeBtn.setText("Tạo Kỷ Luật");

        javax.swing.GroupLayout addCriticismLayout = new javax.swing.GroupLayout(addCriticism);
        addCriticism.setLayout(addCriticismLayout);
        addCriticismLayout.setHorizontalGroup(
            addCriticismLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCriticismLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(typeCriticismBtn)
                .addGap(70, 70, 70)
                .addComponent(criticismEmployeeBtn)
                .addContainerGap(548, Short.MAX_VALUE))
        );
        addCriticismLayout.setVerticalGroup(
            addCriticismLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addCriticismLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(addCriticismLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeCriticismBtn)
                    .addComponent(criticismEmployeeBtn))
                .addGap(24, 24, 24))
        );

        criticismContainer.setBackground(new java.awt.Color(255, 204, 204));
        criticismContainer.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout criticismContainerLayout = new javax.swing.GroupLayout(criticismContainer);
        criticismContainer.setLayout(criticismContainerLayout);
        criticismContainerLayout.setHorizontalGroup(
            criticismContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        criticismContainerLayout.setVerticalGroup(
            criticismContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addCriticism, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(criticismContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(addCriticism, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(criticismContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addCriticism;
    private javax.swing.JPanel criticismContainer;
    private javax.swing.JButton criticismEmployeeBtn;
    private javax.swing.JButton typeCriticismBtn;
    // End of variables declaration//GEN-END:variables
   
}




