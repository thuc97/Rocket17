package Backend.BussinessLayer;

import Backend.RepositoryLayer.RepositoryDepartment;
import entity.Department;

import java.sql.SQLException;
import java.util.List;

public class ServiceDepartment {
    private RepositoryDepartment repositoryDepartment;

    public ServiceDepartment() {
        repositoryDepartment = new RepositoryDepartment();
    }

//    public void CreatableDepatment() throws SQLException, ClassNotFoundException {
//        repositoryDepartment.CreatableDepatment();
//    }

    public List<Department> getlissdepartment() throws SQLException, ClassNotFoundException {
        return repositoryDepartment.getlissdepartment();
    }

    public void getDepByID() throws SQLException, ClassNotFoundException {
        repositoryDepartment.getDepByID();

    }

    public void insert () throws SQLException, ClassNotFoundException {
         repositoryDepartment.insert();
    }
    public void updatedeparment() throws SQLException, ClassNotFoundException {
        repositoryDepartment.updatedeparment();
    }
    public void delete() throws SQLException, ClassNotFoundException {
        repositoryDepartment.delete();
    }
    public  void callProcedure() throws SQLException, ClassNotFoundException {
        repositoryDepartment.callProcedure();
    }
    public void functions() throws SQLException, ClassNotFoundException {
        repositoryDepartment.functions();
    }
}
