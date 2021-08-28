package backend;

import entity.vti.Student;

import java.util.Random;
import java.util.Scanner;

public class Exercise2_QS1 {
	public static Scanner sc = new Scanner(System.in);

	public void question1() {
//		Random rd =new Random ();
//		int i =rd.nextInt();
//
//		Student[] stu = new Student[10];
//		for ( i=1 ;i<10 ;i++) {
//			int j =rd.nextInt(3);
//			int  group =j +1;
//			stu[0] = new Student("Nguyen van A"+i, 20+i ,+ group);
//			System.out.println(	stu[0]);
//		}
			Student[] stu = new Student[10];
		stu[0] = new Student("Nguyen van A", 20, 1);
		stu[1] = new Student("Nguyen van B", 21, 2);
		stu[2] = new Student("Nguyen van C", 22, 3);

		stu[3] = new Student("Nguyen van D", 23, 4);
		stu[4] = new Student("Nguyen van E", 24, 2);
		stu[5] = new Student("Nguyen van F", 25, 6);

		stu[6] = new Student("Nguyen van J", 26, 7);
		stu[7] = new Student("Nguyen van K", 27, 1);
		stu[8] = new Student("Nguyen van L", 28, 9);
		stu[9] = new Student("Nguyen van M", 29, 2);

while (true) {
		System.out.println("Please choose Options");
		System.out.println("1.Attendance Class");
		System.out.println("2.Group 1 Studing ");
		System.out.println("3.Group 2 Clean Rooms");
		System.out.println("4.Exit================");
		int input = sc.nextInt();
		switch (input) {
		case 1:
			System.out.println("Attendance Class====");
			for (Student student : stu) {
				student.diemdanh();
			}
			System.out.println("=================");
			break;
		case 2:
			System.out.println("Group 1 Studing=====");
			for (Student student : stu) {
				if (student.getGroup() == 1) {
					student.hocbai();
				}
			}
			System.out.println("=================");
			break;
		case 3:
			System.out.println("Group 2 Clean Rooms===");

			for (Student student : stu) {
				if (student.getGroup() == 2) {
					student.donvesinh();
				}
			}
			System.out.println("=================");
			break;
		case 4:
			System.exit(1);
			break;
			default :
				System.out.println("Out of Values Please Try Again");
				break;

		}

		

	}

}
}