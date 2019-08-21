package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String args[]) {
        String url = "jdbc:mysql://localhost:3306/measurement";
        String login = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            Statement statement = connection.createStatement();
            statement.execute("SELECT * FROM temperature");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
