/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FrontEnd.TravelContentUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;


/**
 *
 * @author CAM TRI
 */
public class businessTravelForm extends javax.swing.JFrame implements ActionListener{

    public boolean btnconfirmClicked = false;
    /**
     * Creates new form NewJFrame
     */
    public businessTravelForm() {
        initComponents();
        setTitle("NHẬP THÔNG TIN CÔNG TÁC CỦA NHÂN VIÊN");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        DatePickerSettings pickerSettingsBegin = new DatePickerSettings();
        pickerSettingsBegin.setFormatForDatesCommonEra("dd/MM/yyyy");
        dateBeginAt.setSettings(pickerSettingsBegin);
        dateBeginAt.setDateToToday();
        
        DatePickerSettings pickerSettingsComplete = new DatePickerSettings();
        pickerSettingsComplete.setFormatForDatesCommonEra("dd/MM/yyyy");
        dateCompleteAt.setSettings(pickerSettingsComplete);
        dateCompleteAt.setDateToToday();
        btnClose.addActionListener(this);
        btnConfirm.addActionListener(this);
        btnSearch.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnClose){
            if(!btnconfirmClicked){
                int a = JOptionPane.showConfirmDialog(this, "Bạn có chắc sẽ không lưu thông tin công tác của nhân viên này?","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                if(a == JOptionPane.YES_OPTION){
                dispose();
                }
            } else {
                dispose();
            }
        }else if(e.getSource() == btnSearch){
            String hoten = txtHoten.getText().toString();
            String id = txtID.getText().toString();
            if(hoten != "" && id!=""){
                if(TravelContentPanel.checkexist(hoten, id)){
                    JOptionPane.showMessageDialog(this, "Tồn tại thông tin nhân viên.");
                } else {
                    JOptionPane.showMessageDialog(this, "Không tồn tại thông tin nhân viên.");
                }
            }else {
                JOptionPane.showMessageDialog(this, "Vui lòng điền thông tin người cần nhập thông tin công tác!");
            }
        }else if(e.getSource() == btnConfirm){
            if(btnSearchClicked(e)){
                if(txtID.getText() == "" || txtHoten.getText() == ""){
                    JOptionPane.showMessageDialog(this, "Vui lòng điền họ tên và id của nhân viên!");
                } else {
                    Object[] tmp = {TravelContentPanel.gettbTravel().getRowCount() + 1,txtIDTravel.getText().toString(),txtID.getText().toString(),txtHoten.getText().toString(),txtPlace.getText().toString()};
                    TravelContentPanel.addTableTravel(tmp);
                    btnconfirmClicked = true;
                    txtID.setText("");
                    txtHoten.setText("");
                    dateBeginAt.setText("");
                    dateCompleteAt.setText("");
                    txtPlace.setText("");
                    txtPurpose.setText("");
                    dispose();
                }
            }
        }
    }
    public boolean btnSearchClicked(ActionEvent e){
        btnConfirm.setEnabled(true);
        return true;
    }
   
    public static JButton getbtnConfirm(){
        return btnConfirm;
    }
    public static JButton getbtnCLose(){
        return btnClose;
    }
    public static JTextField gettxtHoten(){
        return txtHoten;
    }
    public static JTextField gettxtID(){
        return txtID;
    }
    public static String gettxtBeginAt(){
        return dateBeginAt.getDateStringOrEmptyString();
    }
    public static String gettxtCompleteAt(){
        return dateCompleteAt.getDateStringOrEmptyString();
    }
    public static JTextField gettxtPurpose(){
        return txtPurpose;
    }
    public static JTextField gettxtPlace(){
        return txtPlace;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtHoten = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPlace = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPurpose = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtIDTravel = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dateBeginAt = new com.github.lgooddatepicker.components.DatePicker();
        dateCompleteAt = new com.github.lgooddatepicker.components.DatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("ID : ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Họ tên : ");

        btnSearch.setBackground(new java.awt.Color(25, 135, 84));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.setMargin(new java.awt.Insets(10, 14, 10, 14));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Bắt đầu công tác :  ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Kết thúc công tác : ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Địa điểm công tác : ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Mục đích công tác : ");

        btnConfirm.setBackground(new java.awt.Color(45, 64, 80));
        btnConfirm.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnConfirm.setText("Xác nhận");

        btnClose.setBackground(new java.awt.Color(45, 64, 80));
        btnClose.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClose.setText("Hủy bỏ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Mã công tác : ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("NHẬP THÔNG TIN CÔNG TÁC CỦA NHÂN VIÊN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIDTravel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearch))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(91, 91, 91))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dateBeginAt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateCompleteAt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8)
                    .addComponent(txtPurpose, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDTravel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlace, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateCompleteAt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateBeginAt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPurpose, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnClose;
    public static javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnSearch;
    public static com.github.lgooddatepicker.components.DatePicker dateBeginAt;
    public static com.github.lgooddatepicker.components.DatePicker dateCompleteAt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JTextField txtHoten;
    public static javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDTravel;
    public static javax.swing.JTextField txtPlace;
    public static javax.swing.JTextField txtPurpose;
    // End of variables declaration//GEN-END:variables
}
