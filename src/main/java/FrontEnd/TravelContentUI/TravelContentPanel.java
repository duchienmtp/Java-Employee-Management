package FrontEnd.TravelContentUI;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
public class TravelContentPanel extends javax.swing.JPanel implements ActionListener{

    public businessTravelForm btform;
    public businessTravelFrame btFrame;
    public UserInformationBusinessTravel uif;
    public Object[] obj;
    public TravelContentPanel() {
        initComponents();
        disableEditing();
        jLabel2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        btform = new businessTravelForm();
        btFrame = new businessTravelFrame();
        uif = new UserInformationBusinessTravel();
        setVisible(true);
        btnAdd.addActionListener(this);
        btnDelete.addActionListener(this);
        btnEdit.addActionListener(this);
        btnSearch.addActionListener(this);
        setVisible(true);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tbTravel.setDefaultRenderer(Object.class, centerRenderer);
        tableinit();
        tbTravel.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Xử lý sự kiện selection change ở đây
            }
        });
        tbTravel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                
                if(e.getClickCount() == 2){
                    DefaultTableModel model = (DefaultTableModel) tbTravel.getModel();
                    int i = tbTravel.getSelectedRow();
                    uif.gettxtBusinessTravelID().setText(model.getValueAt(i, 1).toString());
                    uif.gettxtID().setText(model.getValueAt(i, 2).toString());
                    uif.gettxtHoten().setText(model.getValueAt(i, 3).toString());
                    uif.gettxtBeginAt().setText(model.getValueAt(i, 4).toString());
                    uif.gettxtCompleteAt().setText(model.getValueAt(i, 5).toString());
                    uif.gettxtPlace().setText("Hà Nội");
                    uif.gettxtPurpose().setText("Kí hợp đồng.");
                    uif.setVisible(true);
                }
            }
        });
    }

    
    private void disableEditing() {
        // Lấy mô hình của bảng
        DefaultTableModel model = (DefaultTableModel) tbTravel.getModel();
        
        // Lặp qua từng cột và thiết lập một DefaultCellEditor với null để không thể chỉnh sửa trực tiếp
        for (int i = 0; i < model.getColumnCount(); i++) {
            TableColumn column = tbTravel.getColumnModel().getColumn(i);
            column.setCellEditor(new DefaultCellEditor(new JTextField()) {
                @Override
                public boolean isCellEditable(java.util.EventObject e) {
                    return false; // Không cho phép chỉnh sửa
                }
            });
        }
    }
    
    public static int getSizeTable(){
        DefaultTableModel model = (DefaultTableModel) tbTravel.getModel();
        return model.getRowCount();
    }
    public static boolean checkexist(String name, String id){
        DefaultTableModel model = (DefaultTableModel) tbTravel.getModel();
        boolean flag = false;
        for(int i = 0 ; i < model.getRowCount() ; i++){
            String name_tmp = model.getValueAt(i, 2).toString();
            System.out.println(name_tmp);
            String id_tmp = model.getValueAt(i, 1).toString();
            System.out.println(id_tmp);
            if(name.equalsIgnoreCase(name_tmp) && id.equalsIgnoreCase(id_tmp)){
                flag = true;
            }
        }
        return flag;
    }
    public static void addTableTravel(Object[] tmp ){
        DefaultTableModel model = (DefaultTableModel) tbTravel.getModel();
        model.addRow(tmp);
        tbTravel.setModel(model);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        cbSearch = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTravel = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setName("travelContentPanel"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1000, 740));

        btnAdd.setBackground(new java.awt.Color(25, 135, 84));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnAdd.setText("THÊM");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(220, 53, 69));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnDelete.setText("XÓA");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(45, 64, 80));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnEdit.setText("SỬA");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tìm kiếm : ");

        btnSearch.setBackground(new java.awt.Color(255, 0, 0));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.setMargin(new java.awt.Insets(2, 14, 10, 14));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        cbSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo mã công tác", "Theo tên", "Theo ID", " ", " " }));
        cbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSearchActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Danh sách nhân viên công tác");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbTravel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbTravel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbTravel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã công tác", "ID", "Họ và tên", "Ngày bắt đầu", "Ngày kết thúc"
            }
        ));
        jScrollPane1.setViewportView(tbTravel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSearch)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnAdd){
            if(btform != null){
                btform.setVisible(true);
                btform.setEnabled(true);
            }
            else {
                JOptionPane.showMessageDialog(this, "Can not found form!");
            }
        } else if(e.getSource() == btnDelete){
            int a = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn là muốn xóa thông tin công tác của nhân viên này? ","Thông báo",JOptionPane.YES_NO_OPTION);
            if(a == JOptionPane.YES_OPTION){
                int i = tbTravel.getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) tbTravel.getModel();
                if(i >= 0){
                    model.removeRow(i);
                    tbTravel.setModel(model);
                }
            }
        } else if(e.getSource() == btnEdit){
            int i = tbTravel.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) tbTravel.getModel();
            if(i >= 0){
                btFrame.gettxtBusinessTravelID().setText(model.getValueAt(i, 1).toString());
                btFrame.gettxtBusinessTravelID().setEnabled(true);
                btFrame.gettxtHoten().setText(model.getValueAt(i, 3).toString());
                btFrame.gettxtHoten().setEnabled(true);
                btFrame.gettxtID().setText(model.getValueAt(i, 2).toString());
                btFrame.gettxtID().setEnabled(true);
                btFrame.gettxtBeginAt().setText(model.getValueAt(i, 4).toString());
                btFrame.gettxtBeginAt().setEnabled(true);
                btFrame.gettxtCompleteAt().setText(model.getValueAt(i, 5).toString());
                btFrame.gettxtCompleteAt().setEnabled(true);
                btFrame.gettxtPlace().setText("Hà Nội");
                btFrame.gettxtPlace().setEnabled(true);
                btFrame.gettxtPurpose().setText("Kí hợp đồng");
                btFrame.gettxtPurpose().setEnabled(true);
                btFrame.getbtnCLose().setEnabled(true);
                btFrame.getbtnConfirm().setEnabled(true);
                btFrame.setVisible(true);
            }
        } else if(e.getSource() == btnSearch ){
            String tmp = txtSearch.getText().trim();
            if(!tmp.isEmpty()){
                search(tmp);
            } else {
                JOptionPane.showMessageDialog(this,"Vui lòng nhập họ tên hoặc id hoặc mã công tác của nhân viên cần tìm kiếm!");
            }
        }
    }

public void search(String searchText) {
    DefaultTableModel model = (DefaultTableModel) tbTravel.getModel();
    int check = 0;
    for (int i = 0; i < tbTravel.getRowCount(); i++) {
        String btid = model.getValueAt(i, 1).toString().trim().toLowerCase();
        String name = model.getValueAt(i, 3).toString().trim().toLowerCase(); // Lấy tên từ dòng hiện tại và chuyển thành chữ thường
        String id = model.getValueAt(i, 2).toString().trim().toLowerCase(); // Lấy ID từ dòng hiện tại và chuyển thành chữ thường
        if (name.contains(searchText.toLowerCase()) || id.contains(searchText.toLowerCase()) || btid.contains(searchText.toLowerCase())) { // So sánh tên hoặc ID với nội dung tìm kiếm
            tbTravel.getSelectionModel().setSelectionInterval(i, i); // Chọn dòng tìm thấy
            Rectangle rect = tbTravel.getCellRect(i, 0, true);
            tbTravel.scrollRectToVisible(rect); // Cuộn tới dòng tìm thấy
            check = 1;
            break; // Kết thúc vòng lặp khi tìm thấy dòng phù hợp
        }
    }
    if (check == 0) {
        JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu.");
    }
}

    public void tableinit(){
        DefaultTableModel model = (DefaultTableModel) tbTravel.getModel();
//        String businessTravelId, beginAt, completedAt, place, purpose;
        model.setRowCount(0);
        for(int i = 0 , j = 0; i < 10 ; i++){
            Object[] obj = {++j,"HN001","PO001","Lữ Thị Cẩm Tri","10/10/2023","10/02/2024"};
            model.addRow(obj);
        }
        
        tbTravel.setModel(model);
    }
    
    public static JTable gettbTravel(){
        return tbTravel;
    }
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void cbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSearchActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tbTravel;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
