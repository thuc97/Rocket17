package Excersise_4;

import java.util.ArrayList;
import java.util.Scanner;

import Excersise_4.Student.Check;

public class Excersice4 {
public static Scanner sc = new Scanner(System.in);
public static ArrayList<Student> array = new ArrayList<Student>();	
	public void Addinform() {	
		
		try {
			System.out.println("Add Student Name ======");
			String Name = sc.nextLine();
			Name = sc.nextLine();
			System.out.println("Add Student Id ========");
			int Id = sc.nextInt();
			System.out.println("Add Student Hometown ===");
			String Hometown = sc.nextLine();
			Hometown = sc.nextLine();
			System.out.println("Add Student Score ======");
			float score = sc.nextFloat();
			 Check check=null;
			if (score <= 4) {
				check= Check.Yếu;
			} if (score <= 6) {
				check= Check.TB;
			}
			 if (score <= 8) {
				check= Check.Khá;
			} else {
				check= Check.Giỏi;
			
			}
			Student stu = new Student(Id, Name, Hometown, score,check);
			array.add(stu);	
		} catch (Exception e) {	
		System.out.println("Please Check Error And Try Again");	
		}
	}
	
	public void showinfor() {
		for (Student student : array) {
			System.out.println("Inform about Student");
			System.out.println(student.toString());
		}

}
}