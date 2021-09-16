package Backend.RepositoryLayer;

import Utils.Check_error;
import Utils.JDBCUtils;
import entity.Position2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepositoryPosition {
    private JDBCUtils jdbcUtils;
    public static Scanner scanner = new Scanner(System.in);

    public RepositoryPosition() {

        jdbcUtils = new JDBCUtils();
    }

    public void creatable() throws SQLException, ClassNotFoundException {
        Connection connection = jdbcUtils.getConnection();
        Statement statement = connection.createStatement();
        String mysql = "DROP TABLE IF EXISTS `Position2`";
        statement.executeUpdate(mysql);
        System.out.println("Dropped table");
        String sql = "CREATE TABLE Position2 " +
                "(id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(255));";

        statement.executeUpdate(sql);
        System.out.println("Created table in given database...");
        String sql5 = "INSERT INTO Position2  (`name`)" +
                "VALUES                       ('thuc')";
        String sql6 = "INSERT INTO Position2  (`name` )" +
                "VALUES                        ('hung')";
        String sql7 = "INSERT INTO Position2  (`name`)" +
                "VALUES                        ('Tung')";
        Statement statement2 = connection.createStatement();
        int resultSet = statement2.executeUpdate(sql5);
        int resultSet2 = statement2.executeUpdate(sql6);
        int resultSet3 = statement2.executeUpdate(sql7);
        System.out.println("Effected rows : " + resultSet + resultSet2 + resultSet3);
        System.out.println("Create Table  Successfully");
        System.out.println("========================================");

    }

    public List<Position2> getlissposition() throws SQLException, ClassNotFoundException {
        List<Position2> arrayListposition = new ArrayList<>();
        System.out.println("Read Information about Position2 ====== ");
        Connection connection = jdbcUtils.getConnection();
        String sql = "SELECT * FROM Position2";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Position2 position = new Position2(resultSet.getInt("id"), resultSet.getString("name"));
            arrayListposition.add(position);
        }
        jdbcUtils.disconnect();
        return arrayListposition;
    }

    public void insertsposition() throws SQLException, ClassNotFoundException {
        Connection connection = jdbcUtils.getConnection();
        String sql3 = "INSERT INTO `Position2` (name)" +
                "VALUES              (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql3);
        System.out.println("input Quantity to insert");
        int number = Check_error.inputInt();
        for (int i = 0; i < number; i++) {
            System.out.println("input postionname to insert");
            String name = Check_error.inputString();
            preparedStatement.setString(1, name);
            int resultSet = preparedStatement.executeUpdate();
            System.out.println("Effected rows : " + resultSet);
        }
//        System.out.println(getlissposition().toString() + "\n");
//        System.out.println("========================================");
    }

    public void updatesposition() throws SQLException, ClassNotFoundException {
// cách 1 : gán giá trị trực tiếp
// System.out.println("After Update =======  ");
        Connection connection = jdbcUtils.getConnection();
//        String sql = " UPDATE `Position2`" +
//                "SET `name` = 'trunghip'" +
//                "WHERE id = 3;";
//    PreparedStatement preparedStatement = connection.prepareStatement(sql);
//    int rs =preparedStatement.executeUpdate();
//        System.out.println("Effect row "   +    rs);
//
//        System.out.println(getlissposition().toString() + "\n");
//        System.out.println("========================================");
//    }
// cách 2 : yêu cầu User nhập vào
        String sql = " UPDATE `Position2`" +
                "SET `name` = 'trunghip'" +
                "WHERE id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("input id to Update ==  ");
        int id = Check_error.inputInt();
        preparedStatement.setInt(1, id);
        int results = preparedStatement.executeUpdate();
//        System.out.println("After Update =======  ");
//        System.out.println(getlissposition().toString() + "\n");
    }

    public void deleteposition() throws SQLException, ClassNotFoundException {
        List<Position2> arrayListposition = new ArrayList<>();
        Connection connection = jdbcUtils.getConnection();
        String sql = "DELETE FROM `Position2` " +
                "WHERE id = ? ;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("input id to delete ");
        int id = Check_error.inputInt();
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        }
//        System.out.println("After Delete =======  ");
//        System.out.println(getlissposition().toString() + "\n");

    public void findposition() throws SQLException, ClassNotFoundException {
        while (true) {
            System.out.println("Please choose Options ");
            System.out.println("1.Find By Id ");
            System.out.println("2.Find By Name ");
            System.out.println("3.Exit === ");
            int choose = Check_error.inputInt();
            switch (choose) {
                case 1:
                    Connection connection = jdbcUtils.getConnection();
                    String sql = "SELECT * FROM `Position2` " +
                            "WHERE id = ? ;";
                    System.out.println("input Id to find ");
                    int id = Check_error.inputInt();
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        Position2 position = new Position2(resultSet.getInt("id"), resultSet.getString("name"));
                        System.out.println(position);
                    }
                    break;
                case 2:
                    Connection connection1 = jdbcUtils.getConnection();
                    String sql1 = "SELECT * FROM `Position2` " +
                            "WHERE name = ? ;";
                    System.out.println("input name to find ");
                    String name = Check_error.inputString();
                    PreparedStatement preparedStatement1 = connection1.prepareStatement(sql1);
                    preparedStatement1.setString(1, name);
                    ResultSet resultSet2 = preparedStatement1.executeQuery();
                    while (resultSet2.next()) {
                        Position2 position = new Position2(resultSet2.getInt("id"), resultSet2.getString("name"));
                        System.out.println(position);
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Out of values Try Again ===   ");
                    break;
            }
        }
    }


}