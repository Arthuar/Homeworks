package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnect {
    public static final String url = "jdbc:mysql://localhost:3306/hw8";
    public static final String userName = "root";
    public static final String pass = "Dikun19091988";

    public Connection getMyDbConnect() throws SQLException {
        Connection connection = DriverManager.getConnection(url, userName, pass);
        return connection;
    }

}
