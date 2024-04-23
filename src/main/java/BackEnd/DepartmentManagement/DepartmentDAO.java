package BackEnd.DepartmentManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import BackEnd.ConnectDB.ConnectDB;
import java.sql.PreparedStatement;

public class DepartmentDAO {
    
    ConnectDB dbConnection;
 
    public DepartmentDAO() {
    }

public ArrayList<String> getAllEmployeeIDsAndNames() {
    ArrayList<String> employeeIDsAndNames = new ArrayList<>();
    dbConnection = new ConnectDB();
    try {
        String query = "SELECT id, fullName FROM Employees";
        ResultSet rs = dbConnection.sqlQuery(query);

        if (rs != null) {
            while (rs.next()) {
                String employeeID = rs.getString("id");
                String employeeName = rs.getString("fullName");
                String employeeIDAndName = employeeID + " - " + employeeName;
                employeeIDsAndNames.add(employeeIDAndName);
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Lỗi khi đọc dữ liệu từ bảng Employees");
    } finally {
        dbConnection.closeConnect();
    }
    return employeeIDsAndNames;
}


    public ArrayList<Department> getAllDepartments() {
        ArrayList<Department> departmentList = new ArrayList<>();
        dbConnection = new ConnectDB();
        try {
            String query = "SELECT * FROM Departments";
            ResultSet rs = dbConnection.sqlQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    String departmentId = rs.getString("departmentId");
                    String departmentName = rs.getString("departmentName");
                    String departmentLeader = rs.getString("departmentLeader");
                    boolean deleteStatus = rs.getBoolean("deleteStatus");
                    departmentList.add(new Department(departmentId, departmentName, departmentLeader, deleteStatus));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng Departments");
        } finally {
            dbConnection.closeConnect();
        }
        return departmentList;
    }
    

    public boolean addNewDepartment(Department department) {
        dbConnection = new ConnectDB();
        boolean ok = false;
        try {
            String query = "INSERT INTO Departments VALUES ('" + department.getDepartmentId() + "', '"
                    + department.getDepartmentName() + "', '" + department.getDepartmentLeader() + "', '"
                    + department.getDeleteStatus()+ "')";
            ok = dbConnection.sqlUpdate(query);
        } finally {
            dbConnection.closeConnect();
        }
        return ok;
    }

    public boolean updateDepartment(Department department) {
        dbConnection = new ConnectDB();
        boolean ok = false;
        try {
            String query = "UPDATE Departments SET departmentName = '" + department.getDepartmentName()
                    + "', departmentLeader = '" + department.getDepartmentLeader() + "' WHERE departmentId = '"
                    + department.getDepartmentId() + "'";
            ok = dbConnection.sqlUpdate(query);
        } finally {
            dbConnection.closeConnect();
        }
        return ok;
    }

    public boolean deleteDepartment(Department department) {
        dbConnection = new ConnectDB();
        boolean ok = false;
        try {
            String query = "UPDATE Departments SET deleteStatus = 1 WHERE departmentId = '" + department.getDepartmentId() + "'";
            ok = dbConnection.sqlUpdate(query);
        } finally {
            dbConnection.closeConnect();
        }
        return ok;
    }

    public Department getDepartmentById(String departmentId) {
        dbConnection = new ConnectDB();
        Department department = null;
        try {
            String query = "SELECT * FROM Departments WHERE departmentId = '" + departmentId + "'";
            ResultSet rs = dbConnection.sqlQuery(query);

            if (rs.next()) {
                String departmentName = rs.getString("departmentName");
                String departmentLeader = rs.getString("departmentLeader");
                boolean deleteStatus = rs.getBoolean("deleteStatus");
                department = new Department(departmentId, departmentName, departmentLeader, deleteStatus);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng Departments");
        } finally {
            dbConnection.closeConnect();
        }
        return department;
    }
}
