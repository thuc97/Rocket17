package Backend.PresentationLayer;
import Backend.BussinessLayer.ServiceDepartment;
import entity.Department;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ControlerDepartment {
    private ServiceDepartment serviceDepartment;

    public ControlerDepartment() {
        serviceDepartment = new ServiceDepartment();

    }

//    public void CreatableDepatment() throws SQLException, ClassNotFoundException {
//        serviceDepartment.CreatableDepatment();
//    }

    public List<Department> getlissdepartment() throws SQLException, ClassNotFoundException {
        ServiceDepartment servicedp = new ServiceDepartment();
        List<Department> departmentList = servicedp.getlissdepartment();
        for (Department dp : departmentList) {
            System.out.println(dp.toString());
        }
        return departmentList;
    }

    public void getDepByID() throws SQLException, ClassNotFoundException {
        serviceDepartment.getDepByID();

    }

    public void insert() {
        do {
            try {
                serviceDepartment.insert();
                break;
            } catch (SQLException e) {
                System.out.println("Dupplicated");
            } catch (ClassNotFoundException e) {
                System.out.println("Can not find Class ");
            }
        } while (true);
    }

    public void updatedeparment() {
        do {
            try {
                serviceDepartment.updatedeparment();
                break;
            } catch (SQLException e) {
                System.out.println("Id NOT FOUND ON System Try Again === ");
            } catch (ClassNotFoundException e) {
                System.out.println("Can not find Class ");
            }
        } while (true);
    }

    public void delete() {
        do {
            try {
                serviceDepartment.delete();
                break;
            } catch (SQLException e) {
                System.out.println("Id NOT FOUND ON System Try Again === ");
            } catch (ClassNotFoundException e) {
                System.out.println("Can not find Class ");
            }
        } while (true);
    }

    public void callProcedure() throws SQLException, ClassNotFoundException {
        serviceDepartment.callProcedure();
    }

    public void functions() {
        do {
            try {
                serviceDepartment.functions();
                break;
            } catch (SQLException e) {
                System.out.println("Id NOT FOUND ON System Try Again === ");
            } catch (ClassNotFoundException e) {
                System.out.println("Can not find Class ");
            }
        } while (true);
    }
}