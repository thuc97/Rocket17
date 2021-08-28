package Excersise_4;

import java.util.Scanner;

public class Program {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Excersice4 ex = new Excersice4();
		while (true) {
			System.out.println("Please choose options");
			System.out.println("1.Add inform student");
			System.out.println("2.Show inform about Student");
			System.out.println("3.Exited");
				int h = sc.nextInt();
				switch (h) {
				case 1:
					ex.Addinform();
					break;
				case 2:
					ex.showinfor();
					break;
				case 3:
					System.out.println("Exited See You Later");
					System.exit(1);
					break;
					default :
						System.out.println("Out of values Try Again");
						break;
				}
			
		}

	}
}
