package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataForConnection {
    private static final String user = "postgres";
    private static final String password = "1qazxsw2";
    private static final String url = "jdbc:postgresql://localhost:5432/skypro";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
