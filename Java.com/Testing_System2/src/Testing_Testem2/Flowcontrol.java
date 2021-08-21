package Testing_Testem2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import Testing_Testem2.Position.positionName;

public class Flowcontrol {
	private static boolean Result;

	public static void main(String[] args) {

		// Create department
		Department dep1 = new Department();
		dep1.id = 1;
		dep1.name = "sale";

		Department dep2 = new Department();
		dep2.id = 2;
		dep2.name = "marketing";

		Department dep3 = new Department();
		dep3.id = 3;
		dep3.name = "kaka";

		// Create Position
		Position pos1 = new Position();
		pos1.id = 1;
		pos1.name = Position.positionName.DEV;
		Position pos2 = new Position();
		pos2.id = 2;
		pos2.name = Position.positionName.TEST;
		Position pos3 = new Position();
		pos3.id = 3;
		pos3.name = Position.positionName.PM;

		// Create Group

		Group gp1 = new Group();
		gp1.id = 1;
		gp1.groupName = "sam sung";
		gp1.createDate = LocalDate.of(2009, 03, 04);

		Group gp2 = new Group();
		gp2.id = 2;
		gp2.groupName = "samsong";
		gp2.createDate = LocalDate.of(2008, 03, 04);

		Group gp3 = new Group();
		gp3.id = 3;
		gp3.groupName = "samsa";
		gp3.createDate = LocalDate.of(2009, 04, 04);

		// create Account

		Account ac1 = new Account();
		ac1.id = 1;
		ac1.email = "toan@gmai.com";
		ac1.usernames = "kuku";
		ac1.fullNames = "le van toan";
		ac1.department = dep1;
		ac1.position = pos1;
		ac1.createDate = LocalDate.of(2011, 12, 05);

		Account ac2 = new Account();
		ac2.id = 2;
		ac2.email = "lan@gmai.com";
		ac2.usernames = "kuka";
		ac2.fullNames = "le van lan";
		ac2.department = dep2;
		ac2.position = pos2;
		ac2.createDate = LocalDate.of(2011, 12, 05);

		Account ac3 = new Account();
		ac3.id = 3;
		ac3.email = "chung@gmai.com";
		ac3.usernames = "luku";
		ac3.fullNames = "do van toan";
		ac3.department = dep3;
		ac3.position = pos3;
		ac3.createDate = LocalDate.of(2010, 12, 05);

		// Create TypeQuestion

		TypeQuestion type1 = new TypeQuestion();
		type1.id = 1;
		type1.Name = TypeQuestion.typeName.MULTIPLE_CHOICE;

		TypeQuestion type2 = new TypeQuestion();
		type2.id = 2;
		type2.Name = TypeQuestion.typeName.ESSAY;

		// Create CategoryQuestion

		CategoryQuestion cata1 = new CategoryQuestion();
		cata1.id = 1;
		cata1.name = "content";

		CategoryQuestion cata2 = new CategoryQuestion();
		cata2.id = 2;
		cata2.name = "mark";

		// Create Exam

		Exam ex1 = new Exam();
		ex1.id = 10;
		ex1.code = "A";
		ex1.title = "Hoc hanh";
		ex1.category = cata1;
		ex1.creator = ac2;
		ex1.duration = 60;
		ex1.createDate = new Date();

		Exam ex2 = new Exam();
		ex2.id = 9;
		ex2.code = "B";
		ex2.title = "thit hanh";
		ex2.category = cata2;
		ex2.duration = 90;
		ex2.creator = ac1;
		ex2.createDate = new Date();

		// Create Question
		Question qs1 = new Question();
		qs1.id = 1;
		qs1.content = " lich su";
		qs1.category = cata1;
		qs1.type = type1;
		qs1.creator = ac1;
		qs1.createDate = new Date();

		Question qs2 = new Question();
		qs2.id = 2;
		qs2.content = " lich toan";
		qs2.category = cata2;
		qs2.type = type2;
		qs2.creator = ac2;
		qs2.createDate = new Date();

		// Create Answer
		Answer as1 = new Answer();
		as1.id = 1;
		as1.content = "ok";
		as1.questionID = qs1;
		as1.isCorrect = false;

		Answer as2 = new Answer();
		as2.id = 2;
		as2.content = "oke";
		as2.questionID = qs2;
		as2.isCorrect = true;

		Question[] questionOfExam1 = { qs1 };
		ex1.questions = questionOfExam1;

		Question[] questionOfExam2 = { qs2 };
		ex2.questions = questionOfExam2;

		Exam[] examOfquestion2 = { ex1 };
		qs1.exams = examOfquestion2;

		Exam[] examOfquestion1 = { ex2 };
		qs2.exams = examOfquestion1;

		Account[] accountsofGroup = { ac1, ac2 };
		gp1.accounts = accountsofGroup;

		Account[] accountsofGroup2 = { ac1, ac3 };
		gp2.accounts = accountsofGroup2;

		Account[] accountsofGroup3 = { ac1, ac3 };
		gp3.accounts = accountsofGroup3;

		Group[] groupOfacount1 = { gp1, gp2 };
		ac1.groups = groupOfacount1;

		Group[] groupOfacount2 = { gp3, gp2 };
		ac2.groups = groupOfacount2;

		Group[] groupOfacount3 = { gp1, gp3 };
		ac3.groups = groupOfacount3;

		// Exercise 1 (Optional): Flow Control

//////--------------------------------------------------------------------------		
/////---------------------------------------------------------------------------		
		System.out.println("Excersise1:");
		System.out.println("Questions1:");
		if (ac2.department == null) {

			System.out.println("Nhan vien nay chua co Group");
		} else {

			System.out.println("Phong ban cua nhan vien nay la:" + ac2.department.name);
		}

		System.out.println("2:");

		if (ac2.groups == null) {
			System.out.println("Nhan vien nay chua co group");

		} else if (ac2.groups.length == (1) || ac2.groups.length == (2)) {

			System.out.println("Group cua nhan vien nay la:" + "javafressher" + "C#Fresher");
		}

		else if (ac2.groups.length >= 3) {

			System.out.println("nhan vien nay rat quan trong");
		}

		else {
			System.out.println("nhan vien nay la nguoi hong chuyen");
		}

		System.out.println("Question5");

		if (ac2.groups == null) {
			System.out.println("khong co acount nao");

		}
		int slacount = gp1.accounts.length;

		switch (slacount) {
		case 1:
			System.out.println(" nhom co 1 thanh vien");
			break;
		case 2:
			System.out.println(" nhom co 2 thanh vien");
			break;
		case 3:
			System.out.println("nhom co 3  thanh vien");
			break;
		default:
			break;

		}

		System.out.println("Question 8 :   FORECH");
		for (Account group : accountsofGroup3) {

			System.out.println("Email:" + group.email + "\n" + "Fullname:" + group.fullNames);
		}

		System.out.println("Question 10 :   FOR");

		Account[] Array = { ac1, ac2 };
		for (int i = 0; i < Array.length; i++) {
			System.out.println("Thông tin account thứ " + (i + 1) + "la");

			System.out.println("Email: " + Array[i].email);
			System.out.println("Full name: " + Array[i].fullNames);
			System.out.println("Phòng ban: " + Array[i].department.name);
		}

		System.out.println("Question 14 :  ");
		Account[] Array2 = { ac1, ac2, ac3 };
		for (int i = 0; i < Array2.length; i++) {
			if (Array2[i].id < 4) {
				System.out.println("Thông tin account thứ " + (i + 1) + "la");
				System.out.println("Email: " + Array2[i].email);
				System.out.println("Full name: " + Array2[i].fullNames);
				System.out.println("Phòng ban: " + Array2[i].department.name);
			}
		}

		System.out.println(" Excersise 2:");
		System.out.println(" Question1:");
		int i = 5;
		System.out.printf("%d%n", i);

		System.out.println(" Question2:");
		int t = 100000000;
		System.out.printf(Locale.ITALY, "%,d%n", t);
		System.out.println(" Question3:");
		float a = 5.567098f;
		System.out.printf("%5.4f%n", a);
		System.out.println(" Question5:");
		String pattern = "dd/MM/yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);

		System.out.println(" Excersise 3:");

		String pattern1 = "yyyy-MM";
		simpleDateFormat = new SimpleDateFormat(pattern1);
		for (Exam exam : examOfquestion2) {
			date = simpleDateFormat.format(exam.createDate);
			System.out.println(exam.code + ": " + date);
		}
		String pattern3 = "yyyy";
		simpleDateFormat = new SimpleDateFormat(pattern);
		for (Exam exam : examOfquestion2) {
			date = simpleDateFormat.format(exam.createDate);
			System.out.println(exam.code + ": " + date);
		}
		System.out.println(" Excersise 4----Random number:");

		/// Question 3: Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó
		/// in ngẫu nhiên ra tên của 1 bạn
		System.out.println(" Excersise 4----Random number:");
		System.out.println("Question3:");
		String[] AC = { "A", "B", "C", "D", "E" };
		Random ran = new Random();
		int k = ran.nextInt(AC.length);
		System.out.println("tên Random là :" + AC[k]);
		System.out.println("Question7:");

		int v = ran.nextInt((999 - 100 + 1) + 100);
		System.out.println(v);

		System.out.println(" Excersise 5----Random number:");
		
	}		
		private static void question1() {
			Scanner sc = new Scanner(System.in);
			System.out.println("M�?i bạn nhập vào 3 số nguyên");
			System.out.println("Nhập vào số 1: ");
			int a = sc.nextInt();
			System.out.println("Nhập vào số 2: ");
			int b = sc.nextInt();
			System.out.println("Nhập vào số 3: ");
			int c = sc.nextInt();
			System.out.println("Bạn vừa nhập vào các số: " + a + " " + b +" " + c);
			}	
		
		
		//Question 3: Viết lệnh cho phép ngư�?i dùng nhập h�? và tên
		private static void question3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------Question 3");
		System.out.println("M�?i bạn nhập vào H�?: ");
		String s1 = sc.next();
		System.out.println("M�?i bạn nhập vào Tên: ");
		String s2 = sc.next();
		System.out.println("Fullname của bạn là:" + s1 + " " + s2);
		}
		
		private static void question5() {
			Scanner sc = new Scanner(System.in);
			System.out.println("M�?i bạn nhập vào thông tin account cần tạo") ;
			Account acc = new Account();
			System.out.println("Nhập ID: ");
			acc.id = sc.nextInt();
			System.out.println("Nhập email: ");
			acc.email = sc.next();
			System.out.println("Nhập userName: ");
			acc.usernames = sc.next();
			System.out.println("Nhập fullName: ");
			acc.fullNames = sc.next();
			//	System.out.println("Nhập position (Nhập các số từ 1 đến 4 tương 
			//ứng với: 1.Dev, 2.Test, 3.Scrum_Master, 4.PM): ");
			int posNum = sc.nextInt();
			switch (posNum) {
			case 1:
			Position pos1 = new Position();
			pos1.name = positionName.DEV;
			acc.position = pos1;
			break;
			case 2:
			Position pos2 = new Position();
			pos2.name = positionName.TEST;
			acc.position = pos2;
			break;
			case 3:
			Position pos3 = new Position();
			pos3.name = positionName.SCRUM_MASTER;
			acc.position = pos3;
			break;
			case 4:
			Position pos4 = new Position();
			pos4.name = positionName.PM;
			acc.position = pos4;
			break;
			}
			System.out.println("Thông tin Acc vừa nhập, ID: " + acc.id + 
			"Email: " + acc.email + " UserName: " + acc.usernames + " FullName: " + acc.fullNames + "Position: " + acc.position.name);
		
		}		
			
			private static void question6() {
				Scanner sc = new Scanner(System.in);
				System.out.println("M�?i bạn nhập vào thông tin Department cân tạo"); 
				Department dep = new Department();
				System.out.println("Nhập ID: ");
				dep.id = sc.nextInt();
				System.out.println("Nhập Name: ");
				dep.name = sc.next();
				System.out.println("Thông tin Department vừa nhập, ID: " + dep.id
				+ " Name: " + dep.name);
				}

		
			private static void question8() {
			System.out.println("Question 8: Viết chương trình thực hiện theo flow");
			
			Scanner sc = new Scanner(System.in);
			int choose;
			while (true) {
			System.out.println("M�?i bạn ch�?n chức năng");
			System.out.println("Tạo Acount");
			System.out.println("Tạo department");
			choose = sc.nextInt();
			if (choose == 1 || choose == 2) {
			switch (choose) {
			case 1:
			question5();
			break;
			case 2:
			question6();
			break;
			}
			return;
			} else {
			System.out.println("Nhập lại: ");
			}
			}
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
