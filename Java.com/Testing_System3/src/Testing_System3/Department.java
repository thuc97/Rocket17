package Testing_System3;

import java.time.LocalDate;

public class Department implements Comparable<Department> {

	
	public int  id;
	public String  name;
	public String email;
	


	public Department(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;

	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}




	@Override
	public int compareTo(Department other) {
		// TODO Auto-generated method stub
		
		if (other==null ) {		
			return -1;		
		}
		
		else if(id<other.id)    {
			
	      return -1;
			
		}
		
		else if (id>other.id){
			
		      return 1;	
		} 	
		return 0;
	}

	
	@Override
	public String toString() {
      
       String kq =" ";
       kq += "id:"+id+"\n";
       kq += "name:"+name+"\n";	   
       kq += "email:"+email+"\n";
     
       
       
		
		
		return  kq;
	} 
	

	
	@Override
	public boolean equals(Object obj) {
	
	if (obj==null) {
		return false;	
	}
		
	Department dep1 =(Department) obj;
	
	if(name.equals(obj)) {
		return true;
	}
		
		
		return false;

	
	
	}
}
