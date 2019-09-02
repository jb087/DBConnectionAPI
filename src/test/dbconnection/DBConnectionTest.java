package dbconnection;

import org.junit.Test;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTest {

    @Test
    public void shouldConnectToDB() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/measurement";
        String login = "root";
        String password = "";

        DriverManager.getConnection(url, login, password);
    }
}
