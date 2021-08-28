package Excersise_5;

import java.util.Scanner;

public class Program_Question4 {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			Question4 qs4 = new Question4();
			System.out.println("Please choose Options");
			System.out.println("1.Add new Inform");
			System.out.println("2.Show Information");
			System.out.println("3.Find Information");
			System.out.println("4.Delete Information");
			System.out.println("5.Exit Program");
			System.out.println("\n");
			int Q4 = sc.nextInt();
				switch (Q4) {
				case 1:
					qs4.Addinform();					
					break;
				case 2:
					qs4.showinform();
					break;
				case 3:
					qs4.FindInform();
					break;
				case 4:
					qs4.delete();
					break;
				case 5:
					System.exit(1);
				break;
				default:
					System.out.println("Out of values Try Again");
					break;
				}
			}
		}

	}
