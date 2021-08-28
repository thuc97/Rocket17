import java.util.ArrayList;
import java.util.List;

public class programbai4 {


public static void main (String []args) {
	   List<Student>ac1  =new ArrayList<Student >();
		ac1.add(new Student("nguyen",20,(byte) 21));
		ac1.add(new Student("nguyen",20,(byte) 21));
		ac1.add(new Student("nguyen",20,(byte) 21));
		System.out.println(ac1.size()); 
		for (Student student : ac1) {
			System.out.println(student.name);
			if(student instanceof User)
			((Student)student).an();
			
			
			
		}
	 
 }
 }


	
