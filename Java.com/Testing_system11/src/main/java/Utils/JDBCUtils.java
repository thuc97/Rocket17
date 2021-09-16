package Utils;

import entity.Position2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JDBCUtils {
    private Connection connection;
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null || connection.isClosed()) {
            String url = "jdbc:mysql://localhost:3306/Testingsystem?autoReconnect=true&useSSL=false&characterEncoding=latin1\n";
            String username = "root";
            String passwords = "34567890123";
            Class.forName("com.mysql.cj.jdbc.Driver");
            //        Connection connection = DriverManager.getConnection(url, username, passwords);
            connection = DriverManager.getConnection(url, username, passwords);
            //    System.out.println("conect ok");
        }
        return connection;
    }
    public void disconnect() throws SQLException {
        if (connection != null && connection.isClosed()) {
            connection.close();
        }
    }
}

