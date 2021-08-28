package entity.vti;

public class Student implements IStudent {
	private int id;
	private String name;
	private int group;

	public Student(String name, int id, int group) {
		this.name = name;
		this.id = id;
		this.group = group;
	}

	public Student(int group) {
		// TODO Auto-generated constructor stub
		this.group = group;
	}

	@Override
	public void diemdanh() {
		System.out.println(name + "  " + "diem danh");

	}

	@Override
	public void hocbai() {
		System.out.println(name + " " + " dang hoc bai");

	}

	@Override
	public void donvesinh() {
		System.out.println(name + " " + " dang don ve sinh");

	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getGroup() {
		return group;
	}

	public String toString() {
		return "ID: " + id + "\n" + "Name: " + name + "\n" + "Group: " + group;

	}

}
