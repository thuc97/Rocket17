package Excersise_5;

public class can_bo {

	private String name;
	private int Age;
	private  String Address;
	private Gender gender;
	enum  Gender  {
	MALE , FEAMLE, UNKNOW	
	}

	
public 	can_bo ( String name,int Age,String Address, Gender gender) {
	
	this.name=name;
	this.Age=Age;
	this.Address=Address;
	this.gender=gender;
}
	
	


public String toString()	{	
	return "Name:" +  name +"\n" +"Age:" + Age +"\n" +"Address:" + Address +"\n"+ "Gender:"+ gender;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public int getAge() {
	return Age;
}


public void setAge(int age) {
	Age = age;
}


public String getAddress() {
	return Address;
}


public void setAddress(String address) {
	Address = address;
}


public Gender getGender() {
	return gender;
}


public void setGender(Gender gender) {
	this.gender = gender;
}
	
	
}
