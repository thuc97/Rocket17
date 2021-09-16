package entity;
public class Department {
 private int DepartmentID ;
 private  String Departmentname;

    public Department(int departmentID, String departmentname) {
        DepartmentID = departmentID;
        Departmentname = departmentname;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public String getDepartmentname() {
        return Departmentname;
    }

    public void setDepartmentID(int departmentID) {
        DepartmentID = departmentID;
    }

    public void setDepartmentname(String departmentname) {
        Departmentname = departmentname;
    }

    @Override
    public String toString() {
        return "Department{" +
                "DepartmentID=" + DepartmentID +
                ", Departmentname='" + Departmentname + '\'' +
                '}';
    }
}
