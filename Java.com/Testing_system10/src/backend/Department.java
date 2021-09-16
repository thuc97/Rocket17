package backend;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Department {
    public Department(int departmentID) {

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
    public void getListDepartment() throws
            ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        String sql = "SELECT * FROM Department";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Department> listDep = new ArrayList<Department>();
        while (resultSet.next()) {
            Department dep = new Department(resultSet.getInt("DepartmentID"));
            Department dep1 = new Department(resultSet.getInt("DepartmentName"));
            listDep.add(dep);
            listDep.add(dep1);
            for (int i = 0; i <listDep.size() ; i++) {
                System.out.println(listDep.get(i));
            }
        }
    }
}

