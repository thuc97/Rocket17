package entity;

import java.util.Scanner;

public class Try_catch {
    public static Scanner sc = new Scanner(System.in);
    private static int number1;
    public static int QS1() {
        while (true) {
            try {
                int number = Integer.parseInt(sc.next());
                if(number!=0) {
                    return number;
                }
                else {
                    System.out.println("số number1 input vào phải khác 0");
                }
            } catch (Exception e) {
                System.out.println("số number1 input vào phải khác 0");
            }
        }
    }
}
