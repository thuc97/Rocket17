package Excersise_4;
public class Student {
	private int Id;
	private String Name;
	private String Hometown;
	private float score;
	public Check check ;
	public enum Check {
		Yếu,Khá,Giỏi, TB
	}

	public Student(int Id, String Name, String Hometown, float score,Check check ) {
		super();
		this.Id = Id;
		this.Name = Name;
		this.Hometown = Hometown;
		this.score = score;
		this.check=check;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public void plusScore(float score) {
		this.score = this.score + score;

	}

	@Override
	public String toString() {
		return "Student [Id=" + Id + ", Name=" + Name + ", Hometown=" + Hometown + ", score=" + score + ", check="
				+ check + "]";
	}

	
	

		
		
	}
