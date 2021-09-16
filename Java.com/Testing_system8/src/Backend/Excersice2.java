package Backend;

import Entity.Check_error;
import Entity.Student;

public class Excersice2 {
    public static void QS1() {
        while (true) {
            System.out.println("Please choose Options");
            System.out.println("-------------------");
            System.out.println("|1.Input Inform   |");
            System.out.println("|2.Sort Inform    |");
            System.out.println("|3.Exit ========  |");
            System.out.println("-------------------");
            int input = Check_error.inputInt();
            switch (input) {
                case 1:
                    Student.input_inform();
                    break;
                case 2:
                    Student.sortbyname();
                    break;
                case 3:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Out ò values Try Again");
                    break;
            }

        }
    }
}