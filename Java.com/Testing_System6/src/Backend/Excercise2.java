package Backend;

import entity.Acount;
import entity.Department;
import entity.Try_catch;

import java.util.Scanner;

public class Excercise2 {
    public void Qs1() {
        Try_catch try_catch = new Try_catch();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Please Choose Options");
            System.out.println("1.Input Information ");
            System.out.println("2.Exit");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Input number a");
                 int a =Checkerror.Checkint();
                    System.out.println("Input number b");
                    int b = sc.nextInt();
                    try {
                        if (a != 0 || b != 0) {
                            System.out.println(Excercise2.check(a, b));
                        }
                    } catch (Exception e) {
                        System.out.println("Cannot divide 0");
                    } finally {
                        System.out.println("Ahiiiiiiiii");
                    }
                    break;
                case 2:
                    break;
            }

        }

    }

    public static float check(float a, float b) {
        return a / b;
    }

    public void QS3() {
        Scanner sc = new Scanner(System.in);
        int[] numbers = {1, 2, 3, 4};
        try {
            System.out.println(numbers[6]);
        } catch (Exception e) {
            System.out.println("try again");
        }

    }

    public void QS4() {
        Department[] department = new Department[3];
        try {
            System.out.println(department[6]);
        } catch (Exception e) {
            System.out.println("try again");
        }
    }

    public void QS5() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Please Choose Options");
            System.out.println("1.Input Information ");
            System.out.println("2.Exit");
            int input = Checkerror.Checkint();
            switch (input) {
                case 1:
                    System.out.println("Input a number ");
                    int number =Checkerror.Checkint();
                    break;
                case 2:
                   break;
            }
        }
    }

/// Question 6,7,8 dã làm trong Class  Check Error
public void QS9(){
        Department.deparment();

}

public void QS11() throws Exception {
    Acount.checkAge();

}
    public void QS12()  {
        Acount.chekage2();

    }
}