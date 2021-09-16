package Backend;

import Entity.Arraylisst_Student;
import Entity.Check_error;
import Entity.QS2_EX1;

import java.util.Scanner;

public class Excercise1 {
    public static Scanner scanner = new Scanner(System.in);

    public static void QS1() {
        while (true) {
            System.out.println("Please choose Options");
            System.out.println("1.Input your name");
            System.out.println("2.show information");
            System.out.println("3.Exit=============");
            int input = Check_error.inputInt();
            switch (input) {
                case 1:
                    Arraylisst_Student.Input_information();
                    break;
                case 2:
                    Arraylisst_Student.show_information();
                    Arraylisst_Student.fidn_id();
                    Arraylisst_Student.delete();
                    Arraylisst_Student.duplicated();
                    Arraylisst_Student.add_all();
                    break;
                default:
                    break;
            }
        }

    }

    public static void QS2() {

        while (true) {
            System.out.println("Please choose Options");
            System.out.println("1.Input inform");
            System.out.println("2.show information");
            System.out.println("3.Exit=============");
            int input = Check_error.inputInt();
            switch (input) {
                case 1:
                    QS2_EX1.Stack();

                    break;
                case 2:
                    QS2_EX1.big();
                    QS2_EX1.Que();
            }

        }
    }
    public static void QS4() {

        while (true) {
            System.out.println("Please choose Options");
            System.out.println("1.Input inform");
            System.out.println("2.Exit  ===========");
            int input = Check_error.inputInt();
            switch (input) {
                case 1:
                    QS2_EX1.QS4();

                    break;
                case 2:
                    break;
            }

        }
    }


}