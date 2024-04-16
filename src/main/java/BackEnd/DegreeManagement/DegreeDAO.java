package BackEnd.DegreeManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import BackEnd.ConnectDB.ConnectDB;

public class DegreeDAO {

    ConnectDB dbConnection;

    public DegreeDAO() {
    }

    public ArrayList<Degree> getAllDegree() {
        ArrayList<Degree> listDegree = new ArrayList<>();
        dbConnection = new ConnectDB();
        try {
            String query = "SELECT * FROM Degrees";
            ResultSet rs = dbConnection.sqlQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    String degreeId = rs.getString("degreeId"),
                            degreeName = rs.getString("degreeName");
                    listDegree.add(new Degree(degreeId, degreeName));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng nhân viên");
        } finally {
            dbConnection.closeConnect();
        }
        return listDegree;
    }

    public Boolean addNewDegree(Degree degree) {
        dbConnection = new ConnectDB();
        Boolean ok = false;
        try {
            String query = "INSERT INTO Degrees VALUES ('" + degree.getDegreeId() + "', '" + degree.getDegreeName()
                    + "', '" + degree.getDeleteStatus() + "')";
            ok = dbConnection.sqlUpdate(query);
        } finally {
            dbConnection.closeConnect();
        }
        return ok;
    }

    public Boolean updateDegree(Degree degree) {
        dbConnection = new ConnectDB();
        Boolean ok = false;
        try {
            String query = "UPDATE Degrees SET degreeName = '" + degree.getDegreeName() + "' WHERE degreeId = '"
                    + degree.getDegreeId() + "'";
            ok = dbConnection.sqlUpdate(query);
        } finally {
            dbConnection.closeConnect();
        }
        return ok;
    }

    public Boolean deleteDegree(Degree degree) {
        dbConnection = new ConnectDB();
        Boolean ok = false;
        try {
            String query = "UPDATE Degrees SET deleteStatus = 1 WHERE degreeId = '" + degree.getDegreeId() + "'";
            ok = dbConnection.sqlUpdate(query);
        } finally {
            dbConnection.closeConnect();
        }
        return ok;
    }
}
