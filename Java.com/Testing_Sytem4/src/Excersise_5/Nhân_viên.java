package Excersise_5;



public class Nhân_viên extends can_bo{
	public Nhân_viên(String name, int Age, String Address, Excersise_5.can_bo.Gender gender,cong_viec cong) {
		super(name, Age, Address, gender);
		this.cong=cong;
		// TODO Auto-generated constructor stub
	}
	public  cong_viec cong ;
	public enum cong_viec {
		
		PLAYGAME, SOCCER
	}
	
	
	
	@Override
	public String toString() {

		return super.toString() + "\n"+ "Work:" + cong;
	}
	
}