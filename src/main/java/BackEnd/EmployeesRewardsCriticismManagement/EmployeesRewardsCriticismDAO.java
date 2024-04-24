package BackEnd.EmployeesRewardsCriticismManagement;

import BackEnd.ConnectDB.ConnectDB;
import BackEnd.CriticismManagement.CriticismDAO;
import BackEnd.EmployeeManagement.EmployeeDAO;
import BackEnd.RewardManagement.RewardDAO;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmployeesRewardsCriticismDAO {
    ConnectDB connection;

    public EmployeesRewardsCriticismDAO() {
    }

    public ArrayList<EmployeesRewardsCriticism> getAllEmployeesRewardsCriticism() {
        connection = new ConnectDB();
        ArrayList<EmployeesRewardsCriticism> listEmployeeRC = new ArrayList<>();

        try {
            String qry = "SELECT * FROM EmployeesRewardsCriticism";
            ResultSet rs = connection.sqlQuery(qry);

            if (rs != null) {
                while (rs.next()) {
                    String employeeId = rs.getString("employeeId");
                    String rewardId = rs.getString("rewardId");
                    String criticismId = rs.getString("criticismId");
                    int faultCount = rs.getInt("faultCount");
                    int rewardCount = rs.getInt("rewardCount");
                    String createdAt = rs.getString("createdAt") != null ? rs.getString("createdAt")
                            : null;

                    // EmployeesRewardsCriticism erc = new
                    // EmployeesRewardsCriticism(employeeId,criticismId,rewardId,
                    // faultCount,rewardCount,createdAt);
                    EmployeesRewardsCriticism erc = new EmployeesRewardsCriticism(
                            new EmployeeDAO().getEmployeeById(employeeId), new RewardDAO().getRewardById(rewardId),
                            rewardCount, new CriticismDAO().getCriticismById(criticismId), faultCount, createdAt);
                    listEmployeeRC.add(erc);
                }
                rs.close(); // Đóng ResultSet sau khi sử dụng
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng thống kê Khen thưởng - Kỷ Luật");
        } finally {
            connection.closeConnect();
        }

        return listEmployeeRC;
    }

    public ArrayList<EmployeesRewardsCriticism> search(String columnName, String value) {
        connection = new ConnectDB();
        ArrayList<EmployeesRewardsCriticism> listEmployeeRC = new ArrayList<>();

        try {
            String qry = "SELECT * FROM EmployeesRewardsCriticism WHERE " + columnName + " LIKE '%" + value + "%'";
            ResultSet rs = connection.sqlQuery(qry);
            if (rs != null) {
                while (rs.next()) {
                    String employeeId = rs.getString("employeeId");
                    String rewardId = rs.getString("rewardId");
                    String criticismId = rs.getString("criticismId");
                    int faultCount = rs.getInt("faultCount");
                    int rewardCount = rs.getInt("rewardCount");
                    String createdAt = rs.getString("createdAt") != null ? rs.getString("createdAt")
                            : null;
                    listEmployeeRC.add(new EmployeesRewardsCriticism(employeeId, criticismId, rewardId, faultCount,
                            rewardCount, createdAt));
                }
            }
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "-- ERROR! Lỗi tìm dữ liệu " + columnName + " = " + value + " bảng kỷ luật");
        } finally {
            connection.closeConnect();
        }

        return listEmployeeRC;

    }

    public void closeConnection() {
        connection.closeConnect();
    }

    public Boolean addEmployeesRewardsCriticism(EmployeesRewardsCriticism employeesRewardsCriticism) {
        connection = new ConnectDB();
        Boolean ok = false;
        try {
            String query = "INSERT INTO EmployeesRewardsCriticism(employeeId, rewardId, criticismId, faultCount, rewardCount, createdAt) VALUES ('"
                    + employeesRewardsCriticism.getEmployee().getId() + "','"
                    + employeesRewardsCriticism.getReward().getRewardId()
                    + "','" + employeesRewardsCriticism.getCriticism().getCriticismId() + "',"
                    + employeesRewardsCriticism.getFaultCount()
                    + "," + employeesRewardsCriticism.getRewardCount() + ",'" + employeesRewardsCriticism.getCreatedAt()
                    + "')";
            ok = connection.sqlUpdate(query);
        } finally {
            connection.closeConnect();
        }
        return ok;
    }

    public Boolean updateEmployeesRewardsCriticism(EmployeesRewardsCriticism employeesRewardsCriticism) {
        connection = new ConnectDB();
        Boolean ok = false;
        try {
            String query = "UPDATE EmployeesRewardsCriticism SET faultCount = "
                    + employeesRewardsCriticism.getFaultCount()
                    + ", rewardCount = " + employeesRewardsCriticism.getRewardCount() + ", createdAt = '"
                    + employeesRewardsCriticism.getCreatedAt() + "' WHERE employeeId = '"
                    + employeesRewardsCriticism.getEmployee().getId() + "' AND rewardId = '"
                    + employeesRewardsCriticism.getReward().getRewardId() + "' AND criticismId = '"
                    + employeesRewardsCriticism.getCriticism().getCriticismId() + "'";
            ok = connection.sqlUpdate(query);
        } finally {
            connection.closeConnect();
        }
        return ok;
    }

    public Boolean deleteEmployeesRewardsCriticism(EmployeesRewardsCriticism employeesRewardsCriticism) {
        connection = new ConnectDB();
        Boolean ok = false;
        try {
            String query = "DELETE FROM EmployeesRewardsCriticism WHERE employeeId = '"
                    + employeesRewardsCriticism.getEmployee().getId() + "' AND rewardId = '"
                    + employeesRewardsCriticism.getReward().getRewardId() + "' AND criticismId = '"
                    + employeesRewardsCriticism.getCriticism().getCriticismId() + "' AND createdAt = '"
                    + employeesRewardsCriticism.getCreatedAt() + "'";
            ok = connection.sqlUpdate(query);
        } finally {
            connection.closeConnect();
        }
        return ok;
    }
}
