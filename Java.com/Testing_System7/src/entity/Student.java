package entity;
public class Student {
private final int Id =5;
private String Name;

public Student(int Id, String name) {
	Name = name;
}

	public Student() {

	}

	public final void Studying() {
	System.out.println("Actions :" + Name + "is studying ");
}
}		

