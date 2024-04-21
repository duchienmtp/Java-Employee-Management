package BackEnd.EmployeeManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import BackEnd.EmployeeManagement.Employee;
public class EmployeeBUS {
    private EmployeeDAO emD = new EmployeeDAO();
    private ArrayList<Employee> list = new ArrayList<>();
    public EmployeeBUS() {
        list = emD.getAllEmployees();
    }
    public ArrayList<Employee> getEmployeeList(){
        return list;
    }
    public String getfullNameByEmployeeId(String employeeId){
        String tmp = null;
        if(emD.getNameOfEmployeeByEmployeeId(employeeId)!=null){
            tmp = emD.getNameOfEmployeeByEmployeeId(employeeId);
        }
        return tmp;
    }
    public ArrayList<Employee> getEmployeeInDepartment(String departmentId){
        ResultSet rs = emD.getEmployeeInDepartment(departmentId);
        ArrayList<Employee> arr = new ArrayList<>();
        try {
            if(rs != null){
                while(rs.next()){
                    arr.add(new Employee(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(10),rs.getString(11),rs.getString(12),rs.getBoolean(13),rs.getBoolean(14)));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "--ERROR! Lỗi đọc dữ liệu bảng nhân viên");
        } 
        return arr;
    }
    public void removeEmployee(String employeeId){
        if(emD.deleteEmployee(employeeId)){
            for(int i = 0 ; i < list.size() ; i++){
                if(list.get(i).getId().equals(employeeId)){
                    list.remove(i);
                    break;
                }
            }
        }
    }
    public String getFullnameByEmployeeId(String id){
        if(emD.getFullnameByEmployeeId(id)!=null){
            return emD.getFullnameByEmployeeId(id);
        }
        return null;
    }
}
