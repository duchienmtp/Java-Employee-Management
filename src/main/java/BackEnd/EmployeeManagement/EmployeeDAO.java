package BackEnd.EmployeeManagement;
import BackEnd.ConnectDB.ConnectDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmployeeDAO {
    private ConnectDB con;
    public EmployeeDAO() {
    }
    public ArrayList<Employee> getAllEmployees(){
        con = new ConnectDB();
        ArrayList<Employee> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Employees WHERE deleteStatus  = 0";
            ResultSet rs = con.sqlQuery(sql);
            if(rs != null){
                while(rs.next()){
                    list.add(new Employee(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getBoolean(14),rs.getBoolean(15)));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "--ERROR! Lỗi đọc dữ liệu bảng nhân viên");
        } finally {
            con.closeConnect();
        }
        return list;
    }
    public String getNameOfEmployeeByEmployeeId(String employeeId){
        con = new ConnectDB();
        String fullName = null;
        try {
            String sql = "SELECT fullName FROM Employees WHERE id = '" + employeeId + "'";
            ResultSet rs = con.sqlQuery(sql);
            if (rs.next()) {
                fullName = rs.getNString("fullName");
            }
        } catch (SQLException ex) {
            // Xử lý các exception nếu có
            ex.printStackTrace();
        } finally {
            con.closeConnect();
        }
        return fullName;
    }
    public ResultSet getEmployeeInDepartment(String departmentId){
        con = new ConnectDB();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Employees WHERE departmentId = '" + departmentId + "'";
            rs = con.sqlQuery(sql);
        } finally {
            con.closeConnect();
        }
        return rs;
    }
    public boolean deleteEmployee(String employeeId){
        con = new ConnectDB();
        boolean flag = false;
        try {
            String sql = "UPDATE Employees SET deleteStatus = 1 where Id = '" + employeeId + "'";
            flag = con.sqlUpdate(sql);
        } finally {
            con.closeConnect();
        }
        return flag;
    }
    public String getFullnameByEmployeeId(String id){
        con = new ConnectDB();
        String fn = null;
        try {
            String sql = "SELECT fullName FROM Employees WHERE id = '" + id + "'";
            ResultSet rs = con.sqlQuery(sql);
            if(rs.next()){
                fn = rs.getString(1);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        finally {
        }
        return fn;
    }
    

}
