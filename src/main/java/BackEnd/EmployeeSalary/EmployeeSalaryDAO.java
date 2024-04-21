package BackEnd.EmployeeSalary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BackEnd.ConnectDB.ConnectDB;
import BackEnd.EmployeeManagement.EmployeeBUS;
import BackEnd.EmployeeManagement.EmployeeDAO;

public class EmployeeSalaryDAO {
    ConnectDB dbConnection;

    public EmployeeSalaryDAO() {
    }

    public ArrayList<EmployeeSalary> getAllEmployeeSalary() {
        ArrayList<EmployeeSalary> employeeSalaryList = new ArrayList<>();
        dbConnection = new ConnectDB();
        try {
            String query = "SELECT * FROM EmployeeSalaries";
            ResultSet rs = dbConnection.sqlQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    String employeeId = rs.getString("employeeId"),
                            createdAt = rs.getString("createdAt");
                    double insurance = rs.getDouble("insurance"),
                            netSalary = rs.getDouble("netSalary");
                    boolean deleteStatus = rs.getBoolean("deleteStatus");
                    employeeSalaryList.add(new EmployeeSalary(new EmployeeDAO().getEmployeeById(employeeId), insurance,
                            netSalary, createdAt, deleteStatus));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng Degrees");
        } finally {
            dbConnection.closeConnect();
        }
        return employeeSalaryList;
    }

    public Boolean addEmployeeSalary(EmployeeSalary employeeSalary) {
        dbConnection = new ConnectDB();
        Boolean ok = false;
        try {
            String query = "INSERT INTO EmployeeSalaries (employeeId, insurance, netSalary, createdAt, deleteStatus) VALUES ('"
                    + employeeSalary.getEmployee().getId() + "', " + employeeSalary.getInsurance() + ", "
                    + employeeSalary.getNetSalary() + ", '" + employeeSalary.getCreatedAt() + "', "
                    + employeeSalary.getDeleteStatus() + ")";
            ok = dbConnection.sqlUpdate(query);
        } finally {
            dbConnection.closeConnect();
        }
        return ok;
    }

    public Boolean updateEmployeeSalary(EmployeeSalary employeeSalary) {
        dbConnection = new ConnectDB();
        Boolean ok = false;
        try {
            String query = "UPDATE EmployeeSalaries SET insurance = " + employeeSalary.getInsurance() + ", netSalary = "
                    + employeeSalary.getNetSalary() + ", createdAt = '" + employeeSalary.getCreatedAt()
                    + "', deleteStatus = " + employeeSalary.getDeleteStatus() + " WHERE employeeId = '"
                    + employeeSalary.getEmployee().getId() + "'";
            ok = dbConnection.sqlUpdate(query);
        } finally {
            dbConnection.closeConnect();
        }
        return ok;
    }

    public Boolean deleteEmployeeSalary(EmployeeSalary employeeSalary) {
        dbConnection = new ConnectDB();
        Boolean ok = false;
        try {
            String query = "UPDATE EmployeeSalaries SET deleteStatus = 1 WHERE employeeId = '"
                    + employeeSalary.getEmployee().getId() + "'";
            ok = dbConnection.sqlUpdate(query);
        } finally {
            dbConnection.closeConnect();
        }
        return ok;
    }

    public EmployeeSalary getEmployeeSalaryById(String employeeId) {
        dbConnection = new ConnectDB();
        EmployeeSalary employeeSalary = null;
        try {
            String query = "SELECT * FROM EmployeeSalaries WHERE employeeId = '" + employeeId + "'";
            ResultSet rs = dbConnection.sqlQuery(query);
            if (rs.next()) {
                employeeSalary = new EmployeeSalary(new EmployeeBUS().getEmployeeById(rs.getString("employeeId")),
                        rs.getDouble("insurance"),
                        rs.getDouble("netSalary"), rs.getString("createdAt"),
                        rs.getBoolean("deleteStatus"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnect();
        }

        return employeeSalary;
    }
}
