package BackEnd.EmployeeSalary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BackEnd.ConnectDB.ConnectDB;
import BackEnd.CriticismManagement.Criticism;
import BackEnd.EmployeeManagement.Employee;
import BackEnd.EmployeeManagement.EmployeeBUS;
import BackEnd.EmployeeManagement.EmployeeDAO;
import BackEnd.EmployeesRewardsCriticismManagement.EmployeesRewardsCriticism;
import BackEnd.RewardManagement.Reward;

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
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng EmployeeSalaries");
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
                    + (employeeSalary.getDeleteStatus() ? 1 : 0) + ")";
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
            String query = "SELECT * FROM EmployeeSalaries ES WHERE ES.employeeId = '" + employeeId
                    + "' AND (MONTH(ES.createdAt) = MONTH(GETDATE()) AND (YEAR(ES.createdAt) = YEAR(GETDATE())))";
            ResultSet rs = dbConnection.sqlQuery(query);
            if (rs.next()) {
                employeeSalary = new EmployeeSalary(new EmployeeBUS().getEmployeeById(rs.getString("employeeId")),
                        rs.getDouble("insurance"),
                        rs.getDouble("netSalary"), rs.getString("createdAt"),
                        rs.getBoolean("deleteStatus"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnect();
        }

        return employeeSalary;
    }

    public ArrayList<Object> getSalaryDetail(String employeeId) {
        ArrayList<Object> salaryDetail = new ArrayList<>();
        dbConnection = new ConnectDB();
        try {
            String query = "SELECT E.id, S.baseSalary, P.positionSalaryAllowance, ERC.rewardId, R.rewardName, ERC.rewardCount, R.reward, ERC.criticismId, C.criticismName, ERC.faultCount, C.judgement"
                    +
                    " FROM Employees E" +
                    " INNER JOIN Specialties S on E.specialtyId = S.specialtyId" +
                    " INNER JOIN Positions P on E.positionId = P.positionId" +
                    " INNER JOIN EmployeesRewardsCriticism ERC on E.id = ERC.employeeId" +
                    " INNER JOIN Rewards R on ERC.rewardId = R.rewardId" +
                    " INNER JOIN Criticism C on ERC.criticismId = C.criticismId" +
                    " LEFT JOIN EmployeeSalaries ES on E.id = ES.employeeId" +
                    " WHERE E.id NOT LIKE 'ADM%' AND E.id = '" + employeeId
                    + "' AND E.deleteStatus = 0  AND (MONTH(ERC.createdAt) = MONTH(GETDATE()) AND (YEAR(ERC.createdAt) = YEAR(GETDATE())));";
            ResultSet rs = dbConnection.sqlQuery(query);
            if (rs != null) {
                String empId = "";
                int baseSalary = 0;
                double positionSalaryAllowance = 0;
                ArrayList<EmployeesRewardsCriticism> employeesRewardsCriticismList = new ArrayList<>();
                while (rs.next()) {
                    empId = rs.getString("id");
                    baseSalary = rs.getInt("baseSalary");
                    positionSalaryAllowance = rs.getDouble("positionSalaryAllowance");

                    String rewardId = rs.getString("rewardId"),
                            rewardName = rs.getString("rewardName");
                    int rewardCount = rs.getInt("rewardCount"),
                            reward = rs.getInt("reward");

                    String criticismId = rs.getString("criticismId"),
                            criticismName = rs.getString("criticismName");
                    int faultCount = rs.getInt("faultCount"),
                            judgement = rs.getInt("judgement");

                    Reward employeeReward = new Reward(rewardId, rewardName, reward);
                    Criticism employeeCriticism = new Criticism(criticismId, criticismName, judgement);
                    Employee employee = new Employee(empId);
                    EmployeesRewardsCriticism employeesRewardsCriticism = new EmployeesRewardsCriticism(employee,
                            employeeReward, rewardCount, employeeCriticism, faultCount);
                    employeesRewardsCriticismList.add(employeesRewardsCriticism);
                }
                salaryDetail.add(empId);
                salaryDetail.add(baseSalary);
                salaryDetail.add(positionSalaryAllowance);
                salaryDetail.add(employeesRewardsCriticismList);

            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "-- ERROR! Lỗi đọc dữ liệu bảng các bảng Employees, Specialties, Positions, EmployeesRewardsCriticism, Rewards, Criticism, EmployeeSalaries");
        } finally {
            dbConnection.closeConnect();
        }
        return salaryDetail;
    }

    public ArrayList<EmployeeSalary> getEmployeeSalariesByEmployeeId(String employeeId) {
        ArrayList<EmployeeSalary> employeeSalaries = new ArrayList<>();
        dbConnection = new ConnectDB();
        try {
            String query = "SELECT * FROM EmployeeSalaries WHERE employeeId = '" + employeeId + "'";
            ResultSet rs = dbConnection.sqlQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    String createdAt = rs.getString("createdAt");
                    double insurance = rs.getDouble("insurance");
                    double netSalary = rs.getDouble("netSalary");
                    boolean deleteStatus = rs.getBoolean("deleteStatus");
                    employeeSalaries.add(new EmployeeSalary(new EmployeeDAO().getEmployeeById(employeeId), insurance,
                            netSalary, createdAt, deleteStatus));
                }
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng EmployeeSalaries");
        } finally {
            dbConnection.closeConnect();
        }
        return employeeSalaries;
    }
}
