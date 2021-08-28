package backend;

import entity.vti.Hinhchunhat;
import entity.vti.hinhvuong;

public class Exercise2_QS3 {
public void questions3() {
	System.out.println("Question 3:" + "Tính chu vi và diện tích hình chữ nhật");

	Hinhchunhat hcn = new Hinhchunhat();
	int rs = hcn.Tinhchuvi(5,7);
	hcn.Tinhchuvi(5,7);
	System.out.println("chu vi hcn là :"+  rs);
	
	hinhvuong hv = new hinhvuong();
	int kq = hcn.dientich(5);
	hcn.dientich(5);
	System.out.println("diện tích hình vuong là" + " " + kq);	
}
}
