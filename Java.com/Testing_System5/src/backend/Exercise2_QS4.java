package backend;

import entity.vti.MyMath;

import java.util.Scanner;

public class Exercise2_QS4 {
public void question4() {
	Scanner sc =new Scanner(System.in);
	MyMath my =new MyMath();
	System.out.println("Questions 4: ");
	System.out.println("mời bạn chọn chức năng");
	System.out.println("1.Tính tổng 2 số nguyên theo int");
	System.out.println("2.Tính tổng 2 số thực");
	System.out.println("3.Tính tổng 2 số nguyên theo dạng byte");
	int chucnang =sc.nextInt();
	if(chucnang==1) {
	System.out.println("mời bạn nhập số nguyên thứ nhất");
	int nhap =sc.nextInt();
	System.out.println("mời bạn nhập số nguyên thứ hai");
	int nhap2=sc.nextInt();
	System.out.println("tổng 2 số nguyên vừa nhập là :" +my.sumsonguyen(nhap, nhap2) );

}	
	else if (chucnang==2) {
		
		System.out.println("mời bạn nhập số nguyên thứ nhất");
		float nhap1 =sc.nextFloat();
		System.out.println("mời bạn nhập số nguyên thứ hai");
		float nhap2 =sc.nextFloat();
		System.out.println("tổng 2 số nguyên vừa nhập là :" +my.sumsothuc(nhap1, nhap2) );	
		
		}
		
		
	else {
		
		
		System.out.println("mời bạn nhập số định dạng byte thứ nhất");
	    byte nhap1 =(byte) sc.nextFloat();
		System.out.println("mời bạn nhập số nguyên thứ hai");
		 byte nhap2 =(byte) sc.nextFloat();
		System.out.println("tổng 2 số  vừa nhập là :" +my.sumbyte(nhap1, nhap2) );		
	}
	
	
	
	
	
}
}