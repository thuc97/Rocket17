package entity.vti;

import java.util.ArrayList;
import java.util.Scanner;

public class Student2 extends Person {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Person> array = new ArrayList<Person>();
	public static ArrayList<Person> array2 = new ArrayList<Person>();
	private int Code;
	private Average average;
	private String Email;

	private enum Average {
		WEAK, MEDIUM, GOOD
	}

	public Student2() {
	}

	public Student2(String name, Gender gender, int birthday, String address, int code, Average average, String email) {
		super(name, gender, birthday, address);
		Code = code;
		this.average = average;
		Email = email;
	}

	@Override
	public String toString() {
		return super.toString() +    "|"   +   "Code"   +   Code    +   "|"   + "average"    +     average +   "|"   + "Email "   +    Email;
	}

	public  void input_information() {
		while (true) {
			System.out.println("Please Choose Options");
			System.out.println("1.Input Information about person=====");
			System.out.println("2.Input Information about Student=====");
			System.out.println("3.Exit==============");
			int number = sc.nextInt();
			switch (number) {
				case 1:
					System.out.println("Input YourName=====");
					String name = sc.nextLine();
					name = sc.nextLine();
					System.out.println("Input YourGender=====");
					System.out.println("1.Male");
					System.out.println("2.Female");
					System.out.println("3.Unknown");
					Gender gender = null;
					int input = sc.nextInt();
					switch (input) {
						case 1:
							gender = Gender.MALE;
							break;

						case 2:
							gender = Gender.FEMALE;
							break;
						case 3:
							gender = Gender.UNKNOWN;
							break;
					}
					System.out.println("Input Your Address");
					String address = sc.nextLine();
					address = sc.nextLine();


					System.out.println("Input Your birthday");
					int birthday = sc.nextInt();
					Person per = new Person(name, gender, birthday, address);
					array.add(per);
					break;
				case 2:
					System.out.println("2.Input Information about Student=====");
					System.out.println("Input YourName=====");
					String name2 = sc.nextLine();
					name2 = sc.nextLine();
					System.out.println("Input YourGender=====");
					System.out.println("1.Male");
					System.out.println("2.Female");
					System.out.println("3.Unknown");
					Gender gender2 = null;
					int input2 = sc.nextInt();
					switch (input2) {
						case 1:
							gender2 = Gender.MALE;
							break;

						case 2:
							gender2 = Gender.FEMALE;
							break;
						case 3:
							gender2 = Gender.UNKNOWN;
							break;
					}
					System.out.println("Input Your Address");
					String address2 = sc.nextLine();
					address2 = sc.nextLine();
					System.out.println("Input Your birthday");
					int birthday2 = sc.nextInt();
					System.out.println("Input Your code");
					int code = sc.nextInt();
					System.out.println("Input Your Average ");
					Average average = null;
					int check = sc.nextInt();
					if (check < 5) {
						average = Average.WEAK;
					}
					if (check > 5 && check < 8) {
						average = Average.MEDIUM;
					} else {
						average = Average.GOOD;
					}

					System.out.println("Input Your email ");
					String email = sc.nextLine();
					email = sc.nextLine();
					Student2 student2 = new Student2(name2, gender2, birthday2, address2, code, average, email);
					array2.add(student2);
					break;
				case 3:
					return;
				default:
					System.out.println("Out of values Try Again");
					break;

			}
		}
	}

	public void show_information() {
		while (true) {

			System.out.println("Please Choose Options");
			System.out.println("1.Show Information about person=====");
			System.out.println("2.Show  Information about Student=====");
			System.out.println("3.Exit=====");
			int show = sc.nextInt();
			switch (show) {
				case 1:
					for (int i = 0; i < array.size(); i++) {
						System.out.println(array.get(i).toString());

					}

					break;
				case 2:
					for (int i = 0; i < array2.size(); i++) {
						System.out.println(array2.get(i).toString());

					}
					break;
				case 3:
					return;
				default:
					System.out.println("Out of values Try Again");
					break;

			}


		}

	}
}