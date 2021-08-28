package Excersise_5;

public class Công_nhân extends can_bo{

public Công_nhân(String name, int Age, String Address, Excersise_5.can_bo.Gender gender,Leval level) {
		super(name, Age, Address, gender);
		this.level=level;
		
		// TODO Auto-generated constructor stub
	}
public Leval level;
 enum Leval {
	ONE, TWO ,THREE
}

@Override
	public String toString() {
	
		return super.toString() + "\n" + "Level:" + level;
	}




}
