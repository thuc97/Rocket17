package entity;

import java.util.Scanner;

public class Mymath {
public Scanner sc= new Scanner(System.in);
	public final float PI=3.14f;
	public void sum(int a) {
		while (true) {
			System.out.println("Input number a");
			int k = sc.nextInt();
			System.out.println("Sum of number inputted" + " | " + (k + PI));
		}
}
}