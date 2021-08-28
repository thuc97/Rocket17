package Excersise_5;

import java.util.Scanner;

public class Program_Question2 {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Question2 demo = new Question2();
		while (true) {
			System.out.println("Please choose Options");
			System.out.println("1.Add new Person");
			System.out.println("2.Show Information");
			System.out.println("3.Delete Information");
			System.out.println("4.Find Information");
			System.out.println("5.Exit Program");
			System.out.println("\n");
			int a = sc.nextInt();

			switch (a) {
			case 1:

				demo.Newperson();
				break;

			case 2:

				demo.show();
				break;

			case 3:

				demo.Delete();
				break;

			case 4:
				demo.findinformation();
				break;
			default:
				System.out.println("Exited See you Later");
				break;
			}
		}
	}
}