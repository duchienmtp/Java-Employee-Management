package FrontEnd.TravelContentUI;
import java.awt.Rectangle;
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
public class TravelContentPanel extends javax.swing.JPanel implements ActionListener{

    public businessTravelForm btform;
    public businessTravelFrame btFrame;
    public Object[] obj;
    public TravelContentPanel() {
        initComponents();
        disableEditing();
        btform = new businessTravelForm();
        btFrame = new businessTravelFrame();
        setVisible(true);
        btnAdd.addActionListener(this);
        btnDelete.addActionListener(this);
        btnEdit.addActionListener(this);
        btnSearch.addActionListener(this);
        tableinit();
        setVisible(true);
        tbTravel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                
                if(e.getClickCount() == 2){
                    
                    DefaultTableModel model = (DefaultTableModel) tbTravel.getModel();
                    int i = tbTravel.getSelectedRow();
                    btFrame.gettxtHoten().setText(model.getValueAt(i, 2).toString());
                    btFrame.gettxtHoten().setEnabled(false);
                    btFrame.gettxtID().setText(model.getValueAt(i, 1).toString());
                    btFrame.gettxtID().setEnabled(false);
                    btFrame.gettxtBeginAt().setText("10/10/2023");
                    btFrame.gettxtBeginAt().setEnabled(false);
                    btFrame.gettxtCompleteAt().setText("10/2/2024");
                    btFrame.gettxtCompleteAt().setEnabled(false);
                    btFrame.gettxtPlace().setText("Hà Nội");
                    btFrame.gettxtPlace().setEnabled(false);
                    btFrame.gettxtPurpose().setText("Kí hợp đồng");
                    btFrame.gettxtPurpose().setEnabled(false);
                    btFrame.setVisible(true);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTravel = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHoten = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setName("travelContentPanel"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1000, 740));

        btnAdd.setBackground(new java.awt.Color(0, 51, 102));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnAdd.setText("THÊM");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(0, 51, 102));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnDelete.setText("XÓA");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(0, 51, 102));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnEdit.setText("SỬA");

        tbTravel.setBackground(new java.awt.Color(51, 51, 51));
        tbTravel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbTravel.setForeground(new java.awt.Color(204, 204, 204));
        tbTravel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "ID", "Họ tên ", "Trạng thái"
            }
        ));
        tbTravel.setSelectionForeground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(tbTravel);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID : ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Họ và tên : ");

        btnSearch.setBackground(new java.awt.Color(255, 0, 0));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSearch.setText("Tìm kiếm");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Danh sách nhân viên đang công tác : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(108, 108, 108)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(txtID)
                    .addComponent(txtHoten))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
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
                btFrame.gettxtHoten().setText(model.getValueAt(i, 2).toString());
                btFrame.gettxtHoten().setEnabled(true);
                btFrame.gettxtID().setText(model.getValueAt(i, 1).toString());
                btFrame.gettxtID().setEnabled(true);
                btFrame.gettxtBeginAt().setText("10/10/2023");
                btFrame.gettxtBeginAt().setEnabled(true);
                btFrame.gettxtCompleteAt().setText("10/02/2024");
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
            if(txtHoten.getText().toString() != "" && txtID.getText().toString() != ""){
                search();
            } else {
                JOptionPane.showMessageDialog(this,"Vui lòng nhập họ tên hoặc id của nhân viên cần tìm kiếm!");
            }
        }
    }
//    public void search(){
//        int check = 0;
//        String txtsearchhoten = txtHoten.getText().trim().toLowerCase();
//        String txtsearchid = txtID.getText().trim().toLowerCase();
//        DefaultTableModel model = (DefaultTableModel) tbTravel.getModel();
//        for(int i = 0 ; i < tbTravel.getRowCount() ; i++){
//            if(model.getValueAt(i, 2).toString().trim().toLowerCase().equalsIgnoreCase(txtsearchhoten) || model.getValueAt(i, 2).toString().trim().toLowerCase().equalsIgnoreCase(txtsearchid)){
//                tbTravel.setRowSelectionInterval(i, i);
//                Rectangle rect = tbTravel.getCellRect(i, 0, true);
//                tbTravel.scrollRectToVisible(rect);
//                check = 1;
//            }
//        }
//        if(check == 0){
//            JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu.");
//        }
//    }
    public void search() {
        int check = 0;
        String txtsearchhoten = txtHoten.getText().trim().toLowerCase();
        String txtsearchid = txtID.getText().trim().toLowerCase();
        DefaultTableModel model = (DefaultTableModel) tbTravel.getModel();
        for (int i = 0; i < tbTravel.getRowCount(); i++) {
            String name = model.getValueAt(i, 2).toString().trim().toLowerCase();
            String id = model.getValueAt(i, 1).toString().trim().toLowerCase();
            if (name.equals(txtsearchhoten) || id.equals(txtsearchid)) {
                tbTravel.getSelectionModel().addSelectionInterval(i, i); // Hiển thị dòng
                tbTravel.getColumnModel().getSelectionModel().addSelectionInterval(0, tbTravel.getColumnCount() - 1); // Hiển thị toàn bộ hàng
                Rectangle rect = tbTravel.getCellRect(i, 0, true);
                tbTravel.scrollRectToVisible(rect);
                check = 1;
                break; // Khi tìm thấy thông tin, thoát khỏi vòng lặp
            }
        }
        if (check == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu.");
        } else {
            // Ẩn các dòng không khớp với thông tin tìm kiếm
            for (int i = 0; i < tbTravel.getRowCount(); i++) {
                if (i != tbTravel.getSelectedRow()) {
                    tbTravel.getSelectionModel().removeSelectionInterval(i, i); // Ẩn dòng
                    tbTravel.getColumnModel().getSelectionModel().removeSelectionInterval(0, tbTravel.getColumnCount() - 1); // Ẩn toàn bộ hàng
                }
            }
        }
    }

    public void tableinit(){
        DefaultTableModel model = (DefaultTableModel) tbTravel.getModel();
//        String businessTravelId, beginAt, completedAt, place, purpose;
        model.setRowCount(0);
        for(int i = 0 , j = 0; i < 10 ; i++){
            Object[] obj = {++j,"PO001","Lữ Thị Cẩm Tri","Đang làm việc"};
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tbTravel;
    private javax.swing.JTextField txtHoten;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
