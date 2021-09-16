package Recoding;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Repository {
    private JDBCUtils jdbcUtils;
    public static Scanner scanner = new Scanner(System.in);
    public Repository() {

        jdbcUtils = new JDBCUtils();
    }
    public List<Group> getlissGroup() throws SQLException, ClassNotFoundException {
        List<Group> arrayList = new ArrayList<>();
        Connection connection = jdbcUtils.getConnection();
        String sql = "SELECT id,name  FROM `group`";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Group group = new Group(resultSet.getInt("id"),resultSet.getString("name"));
            arrayList.add(group);
        }
        jdbcUtils.disconnect();
        return arrayList;
    }

}