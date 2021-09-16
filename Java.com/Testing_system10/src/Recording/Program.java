package Recording;

import java.sql.*;
import java.util.Scanner;

public class Program {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //    Roll_Back();
              Read_Stament();
             Insert_Stament();
        update_stament();
  //     Create_Table_Stament();
        delete_Stament();
        //    Call_proceduce();
  //      Create_Proceduce();

    }
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/Testingsystem?autoReconnect=true&useSSL=false&characterEncoding=latin1\n";
        String username = "root";
        String passwords = "34567890123";
        //register the driver class with DriverManager
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Step2 : get a database connecttion
        //        Connection connection = DriverManager.getConnection(url, username, passwords);
        return DriverManager.getConnection(url, username, passwords);
        //    System.out.println("conect ok");
    }
    public static void Read_Stament() throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        String sql = "SELECT id , username , email FROM `user`";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("username"));
            System.out.println(resultSet.getString("email"));
            System.out.println("Results check Mysql");
        }
    }

    public static void Insert_Stament() throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        //     INSERT INTO DATABASE  Gán giá trị mặc định .
        String sql2 = "INSERT INTO `group`   (`name`,author_ID)" +
                "VALUES              ('kkk',8)";
        Statement statement = connection.createStatement();
        int resultSet = statement.executeUpdate(sql2);
        System.out.println("Effected rows : " + resultSet);

// INSERT INTO DATABASE  để người dùng nhập vào values theo mong muốn
        String sql3 = "INSERT INTO `group`   (`name`,author_ID)" +
                "VALUES              (   ? , ?   )";
        PreparedStatement preparedStatement = connection.prepareStatement(sql3);
        System.out.println("input name to insert");
        String name = scanner.next();
        System.out.println("input author_id to insert");
        int author_ID = scanner.nextInt();
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, author_ID);
        int resultSet2 = preparedStatement.executeUpdate();
        System.out.println("Effected rows : " + resultSet2);
    }

    public static void update_stament() throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        String sql4 = "UPDATE `user`" + "SET `password` =?" + "WHERE `gender`= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql4);
        System.out.println("input password to update");
        String password = scanner.next();
        System.out.println("input ifrom to change");
        String gender = scanner.next();
        preparedStatement.setString(1, password);
        preparedStatement.setString(2, gender);
        int resultupdate = preparedStatement.executeUpdate();
        System.out.println(" Efected Row : " + resultupdate);
    }

    public static void Create_Table_Stament() throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String mysql = "DROP TABLE IF EXISTS `Position2`";
        statement.executeUpdate(mysql);
        System.out.println("Dropped table");
        String sql = "CREATE TABLE Position2 " +
                "(id INT UNSIGNED not NULL, " +
                " name VARCHAR(255), " +
                " positioname VARCHAR(255), " +
                " PRIMARY KEY ( id ))";
        statement.executeUpdate(sql);
        System.out.println("Created table in given database...");
        String sql5 = "INSERT INTO Position2  (id,`name`,positioname)" +
                "VALUES              (   1 , 'thuc' , 'sale'  )";
        String sql6 = "INSERT INTO Position2  (id,`name`,positioname)" +
                "VALUES              (   2 , 'hung' , 'MKT'  )";
        String sql7 = "INSERT INTO Position2  (id,`name`,positioname)" +
                "VALUES              (   6 , 'Tung' , 'hhhh'  )";
        Statement statement2 = connection.createStatement();
        int resultSet = statement2.executeUpdate(sql5);
        int resultSet2 = statement2.executeUpdate(sql6);
        int resultSet3 = statement2.executeUpdate(sql7);
        System.out.println("Effected rows : " + resultSet + resultSet2 + resultSet3);
    }

    public static void delete_Stament() throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String delete = "DELETE   FROM  Position2   WHERE `id`= 1";
        int Rs = statement.executeUpdate(delete);
        System.out.println("Effected rows : " + Rs);

    }

    public static void Call_proceduce() throws SQLException, ClassNotFoundException {
        //gọi bằng gán giá trị trực tiếp
        Connection connection = getConnection();
        String sql = "{CALL Gender_user ('M')}";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("lastName"));
        }
        // yêu cầu người dùng nhập trực tiếp
        String sql1 = "{CALL Gender_user (?)}";
        System.out.println("nhap gender");
        String gender = scanner.next();
        CallableStatement callableStatement = connection.prepareCall(sql1);
        callableStatement.setString(1, gender);
        ResultSet resultSet1 = callableStatement.executeQuery();
        while (resultSet1.next()) {
            System.out.println(resultSet1.getString("lastName"));
        }
    }

    public static void Create_Proceduce() throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String Drop = " DROP PROCEDURE IF EXISTS Lastname_user";
        statement.executeUpdate(Drop);
        String Create = "CREATE PROCEDURE Lastname_user (IN nhap VARCHAR(50))"
                + "BEGIN"
                + "SELECT gender"
                + "FROM `user`"
                + "WHERE lastName=nhap"
                + "END;";
        int resultSet2 = statement.executeUpdate(Create);
        System.out.println("Effected rows" +  resultSet2 );
    }
    public static void Roll_Back() throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        connection.setAutoCommit(false);
        try {
            Read_Stament();
            Insert_Stament();
            connection.commit();
            System.out.println("transaction committed");
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
            System.out.println("Transaction roll back");
        }
        connection.setAutoCommit(true);
        connection.close();


    }
}
