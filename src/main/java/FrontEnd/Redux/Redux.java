package FrontEnd.Redux;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BackEnd.ConnectDB.ConnectDB;
import BackEnd.DegreeManagement.Degree;
import BackEnd.DegreeManagement.DegreeBUS;
import BackEnd.DepartmentManagement.Department;
import BackEnd.DepartmentManagement.DepartmentBUS;
import BackEnd.EmployeeManagement.Employee;
import BackEnd.EmployeeManagement.EmployeeBUS;
import BackEnd.PositionManagement.Position;
import BackEnd.PositionManagement.PositionBUS;
import BackEnd.SpecialtyManagement.Specialty;
import BackEnd.SpecialtyManagement.SpecialtyBUS;
import BackEnd.AccountManagement.Account;
import BackEnd.AccountManagement.AccountBUS;
public class Redux {

    public static ConnectDB dbConnection;

    public static boolean isLoggedIn = false;
    public static boolean isAdmin = false;
    public static String userId = "";
    public static String username = "";
    public static Account currentAccount;

    public static ArrayList<Degree> degreeList;
    public static ArrayList<Position> positionList;
    public static ArrayList<Specialty> specialtyList;
    public static ArrayList<Employee> employeeList;
    public static ArrayList<Department> departmentList;
    public static ArrayList<Account> accountList;

    public static void getAllEmployees() {
        employeeList = new EmployeeBUS().getEmployeeList();
    }

    public static void getAllDegrees() {
        degreeList = new DegreeBUS().getDegreeList();
    }

    public static void getAllPositions() {
        positionList = new PositionBUS().getPositionList();
    }

    public static void getAllSpecialties() {
        specialtyList = new SpecialtyBUS().getSpecialtyList();
    }

    public static void getAllDepartments() {
        departmentList = new DepartmentBUS().getDepartmentList();
    }
  
    public static void getAllAccount() {
        accountList = new AccountBUS().getAccountList();
    }

    public static void handleLogin(String username, String password) {
        dbConnection = new ConnectDB();
        try {
            String query = "SELECT * FROM Account WHERE username = '" + username + "' AND password = '"
                    + password + "'";
            ResultSet rs = dbConnection.sqlQuery(query);

            if (rs.next()) {
                // User is authenticated
                userId = rs.getString("userId");
                Redux.username = rs.getString("username");
                isAdmin = userId.contains("ADM");
                isLoggedIn = true;

                
                JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
            } else {
                // Authentication failed
                JOptionPane.showMessageDialog(null, "Đăng nhập thất bại!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng Account");
        } finally {
            dbConnection.closeConnect();
        }
    }
}