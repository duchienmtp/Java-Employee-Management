package BackEnd.EmployeesRewardsCriticismManagement;
import BackEnd.ConnectDB.ConnectDB;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;
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
               LocalDate createdAt = rs.getDate("createdAt") != null ? rs.getDate("createdAt").toLocalDate() : null;

               EmployeesRewardsCriticism  erc = new EmployeesRewardsCriticism(employeeId,criticismId,rewardId, faultCount,rewardCount,createdAt);
                listEmployeeRC.add(erc);
            }
            rs.close(); // Đóng ResultSet sau khi sử dụng
        }
    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng thống kê Khen thưởng - Kỷ Luật");
    } finally {
        connection.closeConnect();
    }
    
          return listEmployeeRC ;
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
               LocalDate createdAt = rs.getDate("createdAt") != null ? rs.getDate("createdAt").toLocalDate() : null;              
                   listEmployeeRC.add(new EmployeesRewardsCriticism(employeeId,criticismId,rewardId, faultCount,rewardCount,createdAt));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi tìm dữ liệu " + columnName + " = " + value + " bảng kỷ luật");
        } finally {
            connection.closeConnect();
        }

        return listEmployeeRC;
        
    }



    public void closeConnection() {
        connection.closeConnect();
    }
    

   
}
