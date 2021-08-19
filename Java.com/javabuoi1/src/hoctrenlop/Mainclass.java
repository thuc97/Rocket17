package hoctrenlop;

import java.time.LocalDate;

import hoctrenlop.Position.positionName;

public class Mainclass {

	public static void main(String[] args) {
		// creat depatment
		Department dp=new Department ();
		dp.id=1;
		dp.name="samsung";
		
		Department dp2=new Department ();
		dp2.id=2;
		dp2.name="nissan";
		
		Department dp3=new Department ();
		dp3.id=3;
		dp3.name="vietnam";
	   
		
		// create position
		Position ps1=new Position ();
		ps1.id=1;
		ps1.name =positionName.DEV;
		
		
		Position ps2=new Position ();
		ps2.id=1;
		ps2.name =positionName.PM;
		
		Position ps3=new Position ();
		ps3.id=1;
		ps3.name =positionName.SCRUM_MASTER;
		
	   // create acount 
		
		Account ac1= new Account();
        ac1.fullNames ="nguyen van a";
        ac1.email="a@gamail.com";
        ac1.id=1;
        ac1.department=dp2;
        ac1.position=ps1;
        ac1.createDate=LocalDate.now();
		
	/// print thông tin :
        
    	System.out.println("thông tin phòng ban 1 là :" +"\n"+"id:" +dp.id +"\n"+"name:"+dp.name);
	
    	System.out.println("thông tin Position 1 là:" +"\n"+"id:" +ps1.id +"\n"+"name:"+ps1.name); 
    	System.out.println("thông tin Acount 1 là :" +"\n"+"id:" + ac1.fullNames +"\n"+"mail:"+ ac1.email+"\n"+"id:" +   ac1.id
    			+"\n"+"depatment:" +    dp2.id +"\n"+"position:"+ ps1.id +"\n"+"creat:" +  LocalDate.now() );
		
	}
}
