package BackEnd.EmployeeManagement;
import BackEnd.ConnectDB.ConnectDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BackEnd.ConnectDB.ConnectDB;
import BackEnd.DegreeManagement.DegreeDAO;
import BackEnd.DepartmentManagement.Department;
import BackEnd.PositionManagement.PositionDAO;
import BackEnd.SpecialtyManagement.SpecialtyDAO;

public class EmployeeDAO {

    ConnectDB dbConnection;

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
    

    public ArrayList<Employee> getAllEmployee() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        dbConnection = new ConnectDB();
        try {
            String query = "SELECT * FROM Employees WHERE id NOT LIKE 'ADM%'";
            ResultSet rs = dbConnection.sqlQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    String id = rs.getString("id"),
                            fullName = rs.getString("fullName"),
                            gender = rs.getString("gender"),
                            birthDate = rs.getString("birthDate"),
                            phoneNumber = rs.getString("phoneNumber"),
                            ethnicGroup = rs.getString("ethnicGroup"),
                            type = rs.getString("type"),
                            religion = rs.getString("religion"),
                            degreeId = rs.getString("degreeId"),
                            nation = rs.getString("nation"),
                            positionId = rs.getString("positionId"),
                            specialtyId = rs.getString("specialtyId");
                    boolean employStatus = rs.getBoolean("employStatus"),
                            deleteStatus = rs.getBoolean("deleteStatus");

                    employeeList.add(
                            new Employee(id, fullName, gender, birthDate, phoneNumber, ethnicGroup, type, religion,
                                    new DegreeDAO().getDegreeById(degreeId), nation,
                                    new PositionDAO().getPositionById(positionId), new Department(),
                                    new SpecialtyDAO().getSpecialtyById(specialtyId), employStatus, deleteStatus));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng Employees");
        } finally {
            dbConnection.closeConnect();
        }
        return employeeList;
    }

    public Boolean addNewEmployee(Employee employee) {
        dbConnection = new ConnectDB();
        Boolean ok = false;
        try {
            String query = "INSERT INTO Employees (id, fullName, gender, birthDate, phoneNumber, ethnicGroup, type, religion, degreeId, nation, positionId, departmentId, specialtyId, employStatus, deleteStatus) VALUES ('"
                    + employee.getId() + "', '"
                    + employee.getFullName() + "', '"
                    + employee.getGender() + "', '"
                    + employee.getBirthDate() + "', '"
                    + employee.getPhoneNumber() + "', '"
                    + employee.getEthnicGroup() + "', '"
                    + employee.getType() + "', '"
                    + employee.getReligion() + "', '"
                    + employee.getDegree().getDegreeId() + "', '"
                    + employee.getNation() + "', '"
                    + employee.getPosition().getPositionId() + "', '"
                    + employee.getDepartment().getDepartmentId() + "', '"
                    + employee.getSpecialty().getSpecialtyId() + "', '"
                    + employee.getEmployStatus() + "', '"
                    + employee.getDeleteStatus() + "')";
            ok = dbConnection.sqlUpdate(query);
        } finally {
            dbConnection.closeConnect();
        }
        return ok;
    }

    public Boolean updateEmployee(Employee employee) {
        dbConnection = new ConnectDB();
        Boolean ok = false;
        try {
            String query = "UPDATE Employees SET fullName = '" + employee.getFullName()
                    + "', gender = '" + employee.getGender()
                    + "', birthDate = '" + employee.getBirthDate()
                    + "', phoneNumber = '" + employee.getPhoneNumber()
                    + "', ethnicGroup = '" + employee.getEthnicGroup()
                    + "', type = '" + employee.getType()
                    + "', religion = '" + employee.getReligion()
                    + "', degreeId = '" + employee.getDegree().getDegreeId()
                    + "', nation = '" + employee.getNation()
                    + "', positionId = '" + employee.getPosition().getPositionId()
                    + "', specialtyId = '" + employee.getSpecialty().getPositionId()
                    + "', employStatus = '" + employee.getEmployStatus()
                    + "', deleteStatus = '" + employee.getDeleteStatus()
                    + "' WHERE id = '"
                    + employee.getId() + "'";
            ;
            ok = dbConnection.sqlUpdate(query);
        } finally {
            dbConnection.closeConnect();
        }
        return ok;
    }

    public Boolean deleteEmployee(Employee employee) {
        dbConnection = new ConnectDB();
        Boolean ok = false;
        try {
            String query = "UPDATE Employees SET deleteStatus = 1, employStatus = 0 WHERE id = '"
                    + employee.getId()
                    + "'";
            ok = dbConnection.sqlUpdate(query);
        } finally {
            dbConnection.closeConnect();
        }
        return ok;
    }

    public Employee getEmployeeById(String id) {
        dbConnection = new ConnectDB();
        Employee employee = null;
        try {
            String query = "SELECT * FROM Employees WHERE id = '" + id + "'";
            ResultSet rs = dbConnection.sqlQuery(query);

            if (rs.next()) {
                String fullName = rs.getString("fullName"),
                        gender = rs.getString("gender"),
                        birthDate = rs.getString("birthDate"),
                        phoneNumber = rs.getString("phoneNumber"),
                        ethnicGroup = rs.getString("ethnicGroup"),
                        type = rs.getString("type"),
                        religion = rs.getString("religion"),
                        degreeId = rs.getString("degreeId"),
                        nation = rs.getString("nation"),
                        positionId = rs.getString("positionId"),
                        specialtyId = rs.getString("specialtyId");

                employee = new Employee(id, fullName, gender, birthDate, phoneNumber, ethnicGroup, type, religion,
                        new DegreeDAO().getDegreeById(degreeId), nation,
                        new PositionDAO().getPositionById(positionId), new Department(),
                        new SpecialtyDAO().getSpecialtyById(specialtyId));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng Employees");
        } finally {
            dbConnection.closeConnect();
        }
        return employee;
    }
}
