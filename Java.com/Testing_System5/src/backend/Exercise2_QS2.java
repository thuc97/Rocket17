package backend;

import entity.vti.Student2;

import java.util.Scanner;

public class Exercise2_QS2 {
public Scanner sc = new Scanner(System.in);	
public void question2() {
	while(true) {
		Student2 student=new Student2 ();
		System.out.println("Please Choose Options");
		System.out.println("1.Add Information=====");
		System.out.println("2.Show Information");
		System.out.println("3.Exit=============");
		int input =sc.nextInt();
		switch(input) {
		
		case 1:
			student.input_information();
			break;
		case 2:
			student.show_information();
			break;
		case 3:
			System.exit(1);
			default :
				System.out.println("Out of values Try Again");
				break;
		}
		
	}
}		
	
	public static void main(String[] args) {
	
		
	}
	
	
}
