package Backend;
import entity.MyMat;
import entity.PrimaryStudent;
import entity.Student2;

import java.util.ArrayList;
import java.util.Scanner;

public class Excersice1 {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Student2> array = new ArrayList<Student2>();
	public static ArrayList<Student2> array2 = new ArrayList<Student2>();
	public static ArrayList<Student2> array3 = new ArrayList<Student2>();
	public static void QS1() {
//		======== CÁCH 1 ==================
//		System.out.println("Question 1:");
//		Student[] stu = new Student[3];
//		stu[0] = new Student(1, "Thuc", "DHCN");
//		stu[1] = new Student(2, "Thức", "DHCN");
//		stu[2] = new Student(3, "Thức", "DHCN");
//		for (int i = 0; i < stu.length; i++) {
//			System.out.println(stu[i].toString());
//		}
//		System.out.println("\n");
//		Student.colleage = "DHBK";
//		for (int i = 0; i < stu.length; i++) {
//			System.out.println(stu[i].toString());
//		}
		System.out.println("\n");
 // ======== Cách 2 =======================
		while (true) {
			System.out.println("Please Choose Options");
			System.out.println("1.Input Information ");
			System.out.println("2.Show Inform After Changing");
			System.out.println("3.Exit=========");
			int	input = Check_error.inputInt();
			switch (input) {
			case 1:
				System.out.println("Input your Id=====");
				int Id = Check_error.inputInt();
				System.out.println("Input your Name======");
				String Name = Check_error.inputString();
				//Name = sc.nextLine();
			    System.out.println("Input your colleague ======");
				String colleague = sc.nextLine();
				Student2 stud = new Student2(Id, Name,colleague );
				array.add(stud);
				System.out.println(stud.toString2());
				System.out.println("=====================");
				break;
			case 2:
				Student2.colleague = "DHBK";
				for (Student2 student : array) {
					System.out.println(student.toString2());
					System.out.println("=====================");
				}
				break;
			case 3:
				System.exit(1);
			default :
				System.out.println("Out of values Please Try Again");
				break;
			}

		}

	}
	public void QS2() {
		 while (true) {
		System.out.println("Please Choose Options");
		System.out.println("1.Student fund payment ");
		System.out.println("2.Sum fund payment");
		System.out.println("3.List Student fund payment");
		System.out.println("4.List Student Using Money");
		System.out.println("5.Exit=========");
			 int input = Check_error.inputInt();
				switch (input) {
				case 1:
					System.out.println("Input your Id=====");
					int Id2 = Check_error.inputInt();
					System.out.println("Input your Name======");
					String Name2 = sc.nextLine();
					Name2 = sc.nextLine();
					System.out.println("Input Money======");
					int moneyGroup = 0;
					moneyGroup =  Check_error.inputInt();
					Student2 student = new Student2(Id2, Name2, moneyGroup);
					array2.add(student);
					break;
				case 2:
					int sum = 0;
					for (Student2 studt : array2) {
						sum += studt.getMoneyGroup();
					}
					System.out.println(sum);
					break;
				case 3:
					for (Student2 student2 : array2) {
						System.out.println(student2.toString2());
					}
					break;
				case 4:
					int sum2 = 0;
					for (Student2 studt : array2) {
						sum2 += studt.getMoneyGroup();
					}
					System.out.println("Input money to buy car====");
					int Id3 =  Check_error.inputInt();
					System.out.println("Input money to buy ball======");
					int Name3 =  Check_error.inputInt();
					System.out.println("Input money to buy chopstick ======");
					int moneyGroup1 =  Check_error.inputInt();
					System.out.println("Số dư còn lại là " + (sum2 - (Id3 + Name3 + moneyGroup1)));
					break;
				case 5:
					return;
				default:
					System.out.println("Out of values Please Try Again");
					break;

				}

			}
		}


	public  void QS3() {
		System.out.println("Input Number a");
		int a =  Check_error.inputInt();
		System.out.println("Input Number b");
		int b = Check_error.inputInt();
		System.out.println("Min of a and b :" + MyMat.min(a, b));
		System.out.println("Sum of a and b :" + MyMat.sum(a, b));
	}

	public static void QS4() {
		System.out.println("Input colleague ned to change");
		Student2.setColleague(sc.nextLine());
		System.out.println("information after changing :" + Student2.getColleague() );
	}

	public  void QS5() {
		while (true) {
			System.out.println("Please Choose Options");
			System.out.println("1.Input StudentNames");
			System.out.println("2.Student Quantity");
			System.out.println("3.Exit=========");
			int input = Check_error.inputInt();
			switch(input) {
			case 1:
				System.out.println("Input StudentName======");
				Student2 student5 = new Student2();
				student5 .setName(sc.next());
				array3.add(student5 );
				break;

			case 2:
				for(int i = 0; i < array3.size(); i++) {
				}
				System.out.println("Quantity Student After input " + array3.size());
				for (Student2 student : array3) {
					System.out.println(student.getName());
				}
				break;
			case 3:
				System.exit(1);
				break;
			default:
				System.out.println("Out of values Try Again");
				return;
			}

		}
	}
	public  void QS6() {
			String input =sc.nextLine();
			PrimaryStudent[] primary_Student = new PrimaryStudent[4];
			for (int i = 0; i < primary_Student.length; i++) {
				primary_Student[i] = new PrimaryStudent(input);
				System.out.println(primary_Student[i]);
				}
			System.out.println("Quantity Student :" +  " | " + primary_Student.length);
		}
			}



