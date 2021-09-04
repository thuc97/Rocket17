package entity;

public class Student2 {
	private int Id;
	private String Name;
	public static String colleague ;
	public float moneyGroup;
	public Student2() {
	}
	public Student2(int id, String name, float moneyGroup) {
		this.Id = id;
		this.Name = name;
		this.moneyGroup = moneyGroup;
	}
	public Student2(int id, String name, String colleague ) {
		this.Id = id;
		this.Name = name;
		this.colleague ="DHCN";
	}
	public String toString() {
		return "Student{" +
				"Id=" + Id +
				", Name='" + Name + '\'' +
				", moneyGroup=" + moneyGroup +
				'}';
	}
	public String toString2() {
		return "Student{" +
				"Id=" + Id +
				", Name='" + Name + '\'' +
				", colleague=" + colleague  +
				'}';
	}

	public int getId() {
		return Id;
	}

	public String getName() {
		return Name;
	}

	public static String getColleague() {
		return colleague;
	}

	public float getMoneyGroup() {
		return moneyGroup;
	}
	public static void setColleague(String colleague) {
		Student2.colleague = colleague;
	}

	public void setName(String name) {
		Name = name;
	}
}
