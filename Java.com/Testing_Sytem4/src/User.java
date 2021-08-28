
public abstract class  User {
// bài tập về tính kế thừa 
	
private String name;
private int    age;
private String hometown;

    ///public User ( String name, int age,String hometown       ) {
	
    //	this.name =name;
	//this.age=age;
	//this.hometown=hometown;
     //}

public  void doing() {
	System.out.println( " tao dang học bài");
	} 


public String getName() {
	return name;
	
}

public void setName (String name) {
	
	this.name=name;
	
}
}