
public class Student extends User {
int id;
String name;
private byte age;
 public Student ( String name, int id, byte age){
	this.id=id;
	this.name=name;
	this.age=age;
}

 public byte getAge(int tuoicauban) { 
	 
	return age;
	 
 } 
	 public void setAge(byte age ) {
		this.age=age; 	
	 }
	 
public String insertName(String name) {
	
	return name;
}

@Override
public void doing() {
	
}	

public void an() {
	System.out.println("tao dang ăn");
}	


	 }
