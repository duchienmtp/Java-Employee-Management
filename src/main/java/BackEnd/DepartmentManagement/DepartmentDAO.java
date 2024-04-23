package BackEnd.DepartmentManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import BackEnd.EmployeeManagement.Employee;
import BackEnd.ConnectDB.ConnectDB;

public class DepartmentDAO {

    private ConnectDB dbConnection;

    public DepartmentDAO() {
        dbConnection = new ConnectDB();
    }

    public ArrayList<Department> getAllDepartments() {
        ArrayList<Department> departmentList = new ArrayList<>();
        String query = "SELECT * FROM Departments";
        try {
            Connection connection = dbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Department department = new Department();
                department.setDepartmentId(rs.getString("departmentId"));
                department.setDepartmentName(rs.getString("departmentName"));
                department.setDepartmentLeaderName(rs.getString("departmentLeader"));
                department.setDeleteStatus(rs.getBoolean("deleteStatus"));
                departmentList.add(department);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentList;
    }
    public ArrayList<Department> getEmployeesInDepartments() {
        ArrayList<Department> departmentList = new ArrayList<>();
        String query = """
                       SELECT Departments.*, Employees.id, Employees.fullName
                       FROM Departments
                       LEFT JOIN Employees ON Departments.departmentId = Employees.departmentId;""";
        try {
            Connection connection = dbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Department department = new Department();
                Employee employee = new Employee();
                employee.setId(rs.getString("id"));
                employee.setFullName(rs.getString("fullName"));
                department.setDepartmentId(rs.getString("departmentId"));
                department.setDepartmentName(rs.getString("departmentName"));
                department.setDepartmentLeaderName(rs.getString("departmentLeader"));
                department.setDeleteStatus(rs.getBoolean("deleteStatus"));
                departmentList.add(department);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentList;
    }

    public Department getDepartmentById(String departmentId) {
        Department department = null;
        String query = "SELECT * FROM Departments WHERE departmentId=?";
        try {
            Connection connection = dbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, departmentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                department = new Department();
                department.setDepartmentId(rs.getString("departmentId"));
                department.setDepartmentName(rs.getString("departmentName"));
                department.setDepartmentLeaderName(rs.getString("departmentLeader"));
                department.setDeleteStatus(rs.getBoolean("deleteStatus"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    public boolean addNewDepartment(Department department) {
        boolean success = false;
        String query = "INSERT INTO Departments (departmentId, departmentName, departmentLeader, deleteStatus) VALUES (?, ?, ?, ?)";
        try {
            Connection connection = dbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, department.getDepartmentId());
            ps.setString(2, department.getDepartmentName());
            ps.setString(3, department.getDepartmentLeaderName());
            ps.setBoolean(4, department.isDeleteStatus());
            int rowsAffected = ps.executeUpdate();
            success = rowsAffected > 0;
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }


    public boolean updateDepartment(Department department) {
        boolean success = false;
        String query = "UPDATE Departments SET departmentName=?, departmentLeader=?, deleteStatus=? WHERE departmentId=?";
        try {
            Connection connection = dbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, department.getDepartmentName());
            ps.setString(2, department.getDepartmentLeaderName());
            ps.setBoolean(3, department.isDeleteStatus());
            ps.setString(4, department.getDepartmentId());
            int rowsAffected = ps.executeUpdate();
            success = rowsAffected > 0;
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    public boolean deleteDepartment(Department department) {
        boolean success = false;
        String query = "DELETE FROM Departments WHERE departmentId=?";
        try {
            Connection connection = dbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, department.getDepartmentId());
            int rowsAffected = ps.executeUpdate();
            success = rowsAffected > 0;
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
    
}
