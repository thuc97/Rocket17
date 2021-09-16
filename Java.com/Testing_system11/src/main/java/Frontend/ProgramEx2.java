package Frontend;
import Backend.PresentationLayer.ControlerDepartment;
import Backend.PresentationLayer.ControlerPosition;
import Utils.Check_error;
import java.sql.SQLException;
import java.util.Scanner;

public class ProgramEx2 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        while (true) {
            ControlerDepartment controler =new  ControlerDepartment();
            System.out.println("+-------------------------+");
            System.out.println("|Please choose  Options ==|");
            System.out.println("|1.Create Table           |");
            System.out.println("|2.Getlist information    |");
            System.out.println("|3.Insert information     |");
            System.out.println("|4.Updates Department     |");
            System.out.println("|5.Find_Information       |");
            System.out.println("|6.Delete Department      |");
            System.out.println("|7.Call Procedure         |");
            System.out.println("|8.Call Functions         |");
            System.out.println("|9.Exit ----------        |");
            System.out.println("+-------------------------+");
            int choose = Check_error.inputInt();
            switch (choose) {
                case 1:
                   // controler.CreatableDepatment();
                    break;
                case 2:
                    controler.getlissdepartment();
                    break;
                case 3:
                 controler.insert();
                    break;
                case 4:
                   controler.updatedeparment();
                    break;
                case 5:
                    controler.getDepByID();
                    break;
                case 6:
                    controler.delete();
                    break;
                case 7:
                    controler.callProcedure();
                    break;
                case 8:
                    controler.functions();
                    break;
                case 9:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Out of values Try Again ===   ");
                    break;
            }
        }
    }
}

