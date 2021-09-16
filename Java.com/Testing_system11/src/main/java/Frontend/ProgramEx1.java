package Frontend;
import Backend.PresentationLayer.ControlerPosition;
import Utils.Check_error;
import java.sql.SQLException;
import java.util.Scanner;

public class ProgramEx1 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        while (true) {
            ControlerPosition controler =new ControlerPosition();
            System.out.println("--------------------------|");
            System.out.println("Please choose  Options == |");
            System.out.println("|1.Create Table           |");
            System.out.println("|2.Read_information       |");
            System.out.println("|3.Insert_information     |");
            System.out.println("|4.Updates_position       |");
            System.out.println("|5.Delete_position        |");
            System.out.println("|6.Find_position          |");
            System.out.println("|7.Exit                   |");
            System.out.println("--------------------------|");
            int choose = Check_error.inputInt();
            switch (choose) {
                case 1:
                   controler.creatable();
                    break;
                case 2:
                   controler.getlissposition();
                    break;
                case 3:
                   controler.insertsposition();
                    break;
                case 4:
                   controler.updatesposition();
                    break;
                case 5:
                   controler.deleteposition();
                    break;
                case 6:
                   controler.findposition();
                    break;
                case 7:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Out of values Try Again ===   ");
            }
        }
    }
}