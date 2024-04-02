package BackEnd.ConnectDB;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DB_URL = "jdbc:sqlserver://KAGAMI\\SQLEXPRESS01:1433;databaseName=QLNV;encrypt=true;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASSWORD = "123456789";

    public Connection createConnection() throws NoSuchAlgorithmException {
        System.out.println("Creating SQL Server DataBase Connection");
        Connection connection = null;
        try {
            // Provide the java database driver
            Class.forName(JDBC_DRIVER);
            // Provide URL, database and credentials according to your database
            // .getConnection ("url/namadatabase, user, password")
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
        if (connection != null) {
            System.out.println("Connection created successfully..");
        } else {
            System.out.println("Connection created failed..");
        }
        return connection;
    }
}
