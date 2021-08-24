package Testing_System3;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Acount {
		public int id;
		public String email;
		public String userName;
		public String fullName;
	    public LocalDate createdate;


public Acount (int id,String email, String userName,String fullName, LocalDate createdate) {
	this.email=email;
	this.id=id;
	this.userName=userName;
	this.fullName=fullName;
	this.createdate=createdate;
}

public Acount() {
	// TODO Auto-generated constructor stub
}

public String toString() {
return "id:"+id + "email:"+ email+ "username:" +userName+ "fullname:" +fullName+ "creatdate:" +createdate;
}


public void hocbai() {
	System.out.println("nhap mon há»?c");
	Scanner sc=new Scanner (System.in);
	String nhap=sc.nextLine();
	System.out.println(" nhap diem tb");
	int dtb=sc.nextInt();
			
	
	
}
}
