package Backend.RepositoryLayer;

import Utils.Check_error;
import Utils.JDBCUtils;
import entity.Department;

import javax.security.auth.login.LoginContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryDepartment {
    private JDBCUtils jdbcUtils;

    public RepositoryDepartment() {
        jdbcUtils = new JDBCUtils();
    }

//    public void CreatableDepatment() throws SQLException, ClassNotFoundException {
//        Connection connection = jdbcUtils.getConnection();
//        Statement statement = connection.createStatement();
//        String mysql = "DROP TABLE IF EXISTS Department";
//        statement.executeUpdate(mysql);
//        System.out.println("Dropped table");
//        String sql = "CREATE TABLE  Department" +
//                "(DepartmentID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY ," +
//                " Departmentname VARCHAR(255) UNIQUE);";
//        statement.executeUpdate(sql);
//        String sql3 = "INSERT INTO Department (Departmentname)" +
//                "VALUES              (?)";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql3);
//        System.out.println("Inpurt Quantity To Insert ==== ");
//        int number = Check_error.inputInt();
//        for (int i = 0; i < number; i++) {
//            System.out.println("Input Departmentname ");
//            String Departmentname = Check_error.inputString();
//            preparedStatement.setString(1, Departmentname);
//            int resultSet = preparedStatement.executeUpdate();
//            System.out.println("Effected rows : " + resultSet);
//            System.out.println("+ --------------------------------- +");
//        }
//    }

    public List<Department> getlissdepartment() throws SQLException, ClassNotFoundException {
        List<Department> arrayListdepartment = new ArrayList<>();
        System.out.println("Read Information about Department ====== ");
        Connection connection = jdbcUtils.getConnection();
        String sql = "SELECT * FROM Department";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Department department = new Department(resultSet.getInt("DepartmentID"), resultSet.getString("Departmentname"));
            arrayListdepartment.add(department);
        }
        jdbcUtils.disconnect();
        System.out.println("+ --------------------------------- +");
        return arrayListdepartment;
    }


    public Department getDepByID() throws SQLException,
            ClassNotFoundException {
        Connection connection = jdbcUtils.getConnection();
        String sql = "SELECT * FROM Department WHERE DepartmentID = ?";
        PreparedStatement preStatement = connection.prepareStatement(sql);
        while (true) {
            System.out.println("Input DepartmentID TO Find ");
            int DepartmentID = Check_error.inputInt();
            preStatement.setInt(1, DepartmentID);
            ResultSet result = preStatement.executeQuery();
            if (result.next()) {
                Department dep = new
                        Department(result.getInt("DepartmentID"), result.getNString("DepartmentName"));
                System.out.println(dep);
                break;
            } else {
                System.out.println("Cannot find Inform Try Again ");
                // jdbcUtils.disconnect();
            }
        }
        return null;
    }

    public void insert() throws SQLException, ClassNotFoundException {
        Connection connection = jdbcUtils.getConnection();
        String sql3 = "INSERT INTO Department (Departmentname)" +
                "VALUES              (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql3);
        while (true) {
            System.out.println("+---------------------------------------+");
            System.out.println("|Please choose Options                  |");
            System.out.println("|1.Inpurt Departmentname To Insert ==== |");
            System.out.println("|2. Thoát ====                          |");
            System.out.println("+---------------------------------------+");
            int choose = Check_error.inputInt();
            switch (choose) {
                case 1:
                    System.out.println("Input Departmentname ");
                    String Departmentname = Check_error.inputString();
                    preparedStatement.setString(1, Departmentname);
                    int resultSet = preparedStatement.executeUpdate();
                    if (resultSet == 1) {
                        System.out.println("Insert Successfully ==== ");

                    } else {
                        System.out.println("Dupplicated");
                    }
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Out of values Try Again");
                    break;
            }
        }
    }
    public void updatedeparment() throws SQLException, ClassNotFoundException {
        Connection connection = jdbcUtils.getConnection();
        String sql = "UPDATE Department  " +
                "SET Departmentname ='oke'" +
                "WHERE DepartmentID = ? ;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        while (true) {
            System.out.println("+---------------------------------------+");
            System.out.println("|Please choose Options                  |");
            System.out.println("|1.Inpurt DepartmentID To Update   ==== |");
            System.out.println("|2.Exit ====                            |");
            System.out.println("+---------------------------------------+");
            int choose = Check_error.inputInt();
            switch (choose) {
                case 1:
                    System.out.println("Input DepartmentID ");
                    int DepartmentID = Check_error.inputInt();
                    preparedStatement.setInt(1, DepartmentID);
                    int resultSet = preparedStatement.executeUpdate();
                    if (resultSet == 1) {
                        System.out.println("Update Successfully ==== ");
                    } else {
                        System.out.println("Id NOT FOUND ON System Try Again === ");
                    }
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Out of values Try Again");
                    break;

            }
        }
    }

    public void delete() throws SQLException, ClassNotFoundException {
        Connection connection = jdbcUtils.getConnection();
        System.out.println("+--------------------------------+");
        System.out.println("|Please choose Options           |");
        System.out.println("|1.Delete By ID ====             |");
        System.out.println("|2.Delete By Name ====           |");
        System.out.println("|3.Exit  ====                    |");
        System.out.println("+--------------------------------+");
        int choose = Check_error.inputInt();
        String sql = "DELETE FROM Department  " +
                "WHERE DepartmentID = ? ;";
        String sql1 = "DELETE FROM Department  " +
                "WHERE Departmentname = ? ;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
        while (true) {
            switch (choose) {
                case 1:
                    System.out.println("Inpurt DepartmentID");
                    int DepartmentID = Check_error.inputInt();
                    preparedStatement.setInt(1, DepartmentID);
                    int resultSet = preparedStatement.executeUpdate();
                    if (resultSet == 1) {
                        System.out.println("Delete Successfully ==== ");
                        return;
                    } else {
                        System.out.println("Id NOT FOUND ON System Try Again === ");
                    }
                    break;
                case 2:
                    System.out.println("|Inpurt DepartmentName ");
                    String Departmentname = Check_error.inputString();
                    preparedStatement1.setString(1, Departmentname);
                    int resultSet2 = preparedStatement1.executeUpdate();
                    if (resultSet2 == 1) {
                        System.out.println("Delete Successfully ==== ");
                        return;
                    } else {
                        System.out.println("Departmentname NOT FOUND ON System Try Again === ");
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Out of values Try Again");
                    break;
            }
        }
    }

    public void callProcedure() throws SQLException, ClassNotFoundException {
        Connection connection = jdbcUtils.getConnection();
        String sql1 = "{CALL  Dpintform  (?)}";
        while (true) {
            System.out.println("+---------------------------------------+");
            System.out.println("|Please choose Options                  |");
            System.out.println("|1.Inpurt Information To looking for ---|");
            System.out.println("|2.Exit ====                            |");
            System.out.println("+---------------------------------------+");
            int choose = Check_error.inputInt();
            switch (choose) {
                case 1:
                    System.out.println("+--Input Information----- +");
                    String Departmentname = Check_error.checkemail();
                    CallableStatement callableStatement = connection.prepareCall(sql1);
                    callableStatement.setString(1, Departmentname);
                    ResultSet resultSet = callableStatement.executeQuery();
                    while (resultSet.next()) {
                        Department department = new Department(resultSet.getInt("DepartmentID"), resultSet.getString("Departmentname"));
                        System.out.println(department);
                    }
                    if (!resultSet.next()) {
                        System.out.println("Can not find Inform Try Again ");

                    }
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Out of values Try Again");
                    break;
            }

        }
    }
    public void functions() throws SQLException, ClassNotFoundException {
        Connection connection = jdbcUtils.getConnection();
        String sql1 = "{CALL  Deleteform  (?)}";
        while (true) {
            System.out.println("+---------------------------------------+");
            System.out.println("|Please choose Options                  |");
            System.out.println("|1.Inpurt Information To looking for ---|");
            System.out.println("|2.Exit ====                            |");
            System.out.println("+---------------------------------------+");
            int choose = Check_error.inputInt();
            switch (choose) {
                case 1:
                    System.out.println("+--Input Information----- +");
                    int DepartmentID = Check_error.inputInt();
                    CallableStatement callableStatement = connection.prepareCall(sql1);
                    callableStatement.setInt(1,DepartmentID );
                   int rs= callableStatement.executeUpdate();
                   if(rs==1){
                       System.out.println("Delete Successfully");
                   }
                   else{
                       System.out.println("Try Again ------ + ");
                   }
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Out of values Try Again");
                    break;
            }

        }
    }

}

