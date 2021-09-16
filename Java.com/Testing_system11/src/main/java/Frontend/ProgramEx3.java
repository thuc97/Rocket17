package Frontend;
import Backend.PresentationLayer.ControlerDepartment;
import java.sql.SQLException;
public class ProgramEx3 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ControlerDepartment controlerDepartment = new ControlerDepartment();
        controlerDepartment.callProcedure();

    }
}
