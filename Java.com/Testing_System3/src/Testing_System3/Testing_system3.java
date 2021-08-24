package Testing_System3;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



public class Testing_system3 {

	private static Object Date;

	public static void main(String[] args) {
		 Ex1();
		 Ex2();
		// Ex3();
		Ex4();
	}

	public static void Ex1() {

		System.out.println("Question1:");
		float ac1 = 4240.5f;
		float ac2 = 10970.055f;
		int a = (int) ac1;
		int b = (int) ac2;
		System.out.println("ac1:" + ac1 + "\n" + "ac2:" + ac2);

		System.out.println("Question2 :");
		Random ran = new Random();
		int c = ran.nextInt(99999);
		if (c <= 9999) {
			c = c * 10;
		}
		System.out.println(c);

		System.out.println("Question3:");
		int d = ran.nextInt(99999);
		String k = String.valueOf(d);
		System.out.println(k.substring(3));

		System.out.println("Question4 :");
		System.out.println("nhap so nguyen thu nhat");
		Scanner sc = new Scanner(System.in);
		int e = sc.nextInt();
		System.out.println("nhap so nguyen thu 2");
		int r = sc.nextInt();
		System.out.println(" thuong cua 2 so la:" + e / r);
	}

	public static void Ex2() {
		Acount[] array = new Acount[5];
		for (int i = 0; i < array.length; i++) {
			array[i] = new Acount();
			array[i].id = i;
			array[i].fullName = "Nguyen van A" + i;
			System.out.println("Thông tin" + i + " | " + array[i].id);
		}
	}

	public static void Ex3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Question1:");
		Integer t = 5000;
		float y = t.floatValue();
		System.out.printf("%2.2f", y);
		System.out.println("\n");
		System.out.println("Question2:");
		String a = "123456";
		int b = Integer.parseInt(a);
		System.out.println(a);
		System.out.println("Question3:");
		Integer p = 123456;
		int s = p.intValue();
		System.out.println(s);

	}

	public static void Ex4() {

		System.out.println("Question1:");
		Scanner sc = new Scanner(System.in);
		System.out.println("nhập chuỗi kí tự");
		String f = sc.nextLine();
		int count = f.length();
		System.out.println(count);

		System.out.println("Question2:");
		System.out.println("nhập chuỗi kí tự thứ nhất");
		String g = sc.nextLine();
		System.out.println("nhập chuỗi kí tự thứ 2");
		String j = sc.nextLine();
		System.out.println("2 chuỗi sau khi nối là:" + g + j);
		System.out.println("Question3:");
		System.out.println("nhập ten");
		String l=sc.nextLine();
		char z=l.toUpperCase().charAt(0);
		String name=l.substring(1);
		String fullname =z+name;
		System.out.println(fullname );

		System.out.println("Question4:");
		System.out.println("nhập ten");
		String k=sc.nextLine();
		char[] vh=k.toCharArray();
		for (int i = 0; i < vh.length; i++) {
			
			System.out.println("ki tự thứ:" +i +"là" +vh[i]);
		}

		System.out.println("Question5:");
		System.out.println("nhap  h�? của bạn là gì");
		String th=sc.nextLine();
		System.out.println("nhap Tên của bạn");
		String ten=sc.nextLine();
		System.out.println("Full name của bạn là :" +  th +  ten );

		System.out.println("Question6:");
		System.out.println("nhập Full name của bạn:");
		String full=sc.nextLine();
		String[] s=full.split("\\s");
		String fistname =s[0];
		String lastname =s[s.length-2];
		String midname =s[s.length-1];
		String fullname1 =fistname +lastname+midname;
		System.out.println("Tên là:" + fistname +"\n" + "H�? là :" + lastname +"\n" + "tên đệm :" +midname  );

		System.out.println("Question7:");
		System.out.println("nhập Full name của bạn:");
		String tach = sc.nextLine();
		String[] v = tach.split("\\v");
		for (String string : v) {
			String fist = string.substring(0, 1).toUpperCase();
			String latname = string.substring(1);
			System.out.println(fist + latname);

			System.out.println("Question8:");
			String[] group = { "java", "1", "2" };
			for (String string2 : v) {
				if (string2.contains("java")) {
					System.out.println(string2.contains("java"));
				}

			}

			System.out.println("Question9 :");

			String[] group2 = { "java", "1", "2" };
			for (String string4 : v) {

				if (string4.equals("java")) {
					System.out.println(string4);
				}
			}

		}

		System.out.println("Question10 :");

		System.out.println("nhập chuỗi 1");
		String s1 = sc.nextLine();
		String input = s1.trim();
		System.out.println("nhập chuỗi 2");
		String s2 = sc.nextLine();
		StringBuilder str = new StringBuilder(input);
		System.out.println(str.reverse().toString());

		if (s2.equals(str.reverse().toString())) {
			System.out.println("2 chuỗi là đảo ngược của nhau");
		} else {
			System.out.println("2 chuỗi ko phải đảo ngược của nhau");
		}
		System.out.println("\n");
		System.out.println("Question 11 :");
		System.out.println("nhập chuỗi");
		String nhap = sc.nextLine();
		int countt = 0;
		for (int i = 0; i < nhap.length(); i++) {
			if ('a' == nhap.charAt(i)) {
				countt++;
			}
		}
		System.out.println("số kí tự a trong chuỗi là " + count);
		System.out.println("\n");
		System.out.println("Question 12 :");
		System.out.println("nhập chuỗi");
		String rever = sc.nextLine();
		String nhp = rever.trim();
		StringBuilder stri = new StringBuilder(nhap);
		System.out.println("chuỗi đảo ngược là :" + stri.reverse().toString());
		System.out.println("\n");
		System.out.println("Question 13:");
		String stt = sc.nextLine();
		if (stt.contains("[0-9]")) {
			System.out.println("cos chua ki tu");
		}
		System.out.println("Question 14 :");
		System.out.println("nhập chuỗi để replace");
		String replac = sc.nextLine();
		String after = replac.replace("e", "a");
		System.out.println(after);
		System.out.println("\n");
		System.out.println("Question 15 :");
		System.out.println("nhập chuỗi");
		String nhapchuoi = sc.nextLine();
		String[] n = nhapchuoi.split("\n");
		for (String string : n) {
			StringBuilder strig = new StringBuilder(string);
			System.out.println(strig.reverse().toString());

		}
		System.out.println("\n");
		
        ArrayList<Department>dp= new  ArrayList<Department>();
		Department[] depat = new Department[5];
		depat[0] = new Department(2, "nguyen van trung", "@gmail");
		dp.add(depat[0]);
		depat[1] = new Department(2, "nguyen van hai", "@gmail");
		dp.add(depat[1]);
		depat[2] = new Department(2, "le trung thanh", "@gmail");
		dp.add(depat[2]);
		dp.sort(Comparator.comparing(Department::getName));	
		for (Department department : dp) {
			System.out.println(department);
		}
	
		
		
	
	

	
	}

}
