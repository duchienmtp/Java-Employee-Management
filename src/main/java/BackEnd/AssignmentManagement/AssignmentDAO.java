package BackEnd.AssignmentManagement;
import BackEnd.ConnectDB.ConnectDB;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class AssignmentDAO {
    private ConnectDB con;
    public AssignmentDAO() {
    }

    public ArrayList<Assignment> getAllAssignments(){
        con = new ConnectDB();
        ArrayList<Assignment> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Assignments WHERE deleteStatus = 0";
            ResultSet rs = con.sqlQuery(sql);
            if(rs!=null){
                while (rs.next()) {                    
                    list.add(new Assignment(rs.getString(1),rs.getString(2),rs.getBoolean(3)));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng phân công");
        } finally {
            con.closeConnect();
        }
        return list;
    }
    public boolean addNewAssignment(Assignment asm){
        con = new ConnectDB();
        boolean flag = false;
        try {
            String sql = "insert into Assignments values ('" + asm.getEmployeeId() + "','" + asm.getProjectId() + "','" + asm.isDeleteStatus() + "')";
            flag = con.sqlUpdate(sql);
        } finally {
            con.closeConnect();
        }
        return flag;
    }
    public boolean updateAssignmentWithEmployeeId(Assignment asm){
        con = new ConnectDB();
        boolean flag = false;
        try {
            String sql = "update set projectId = '" + asm.getProjectId() + "' where employeeId = '" + asm.getEmployeeId() + "'";
            flag = con.sqlUpdate(sql);
        } finally {
            con.closeConnect();
        }
        return flag;
    }
    public boolean updateAssignmentWithProjectId(Assignment asm){
        con = new ConnectDB();
        boolean flag = false;
        try {
            String sql = "update set employeeId = '" + asm.getEmployeeId() + "' where projectId = '" + asm.getProjectId() + "'";
            flag = con.sqlUpdate(sql);
        } finally {
            con.closeConnect();
        }
        return flag;
    }
    public boolean deleteAssignment(Assignment asm){
        con = new ConnectDB();
        boolean flag = false;
        try {
            String sql = "update Assignments set deleteStatus = 1 where employeeId = '" + asm.getEmployeeId() + "' and projectId = '" + asm.getProjectId() + "'";
            flag = con.sqlUpdate(sql);
        } finally {
            con.closeConnect();
        }
        return flag;
    }
    
    
}
