package Excersise_5;
public class Kỹ_Sư extends can_bo {
	public Kỹ_Sư(String name, int Age, String Address, Excersise_5.can_bo.Gender gender, work doe) {
		super(name, Age, Address, gender);
		this.doe=doe;
	
		// TODO Auto-generated constructor stub
	}
public  work doe;
 enum work {
	 ELECTRICAL,INFORMATION;
}

@Override
public String toString() {
	
	return super.toString() + "\n"+ "Work:" +doe;
}



}


	
	
	

