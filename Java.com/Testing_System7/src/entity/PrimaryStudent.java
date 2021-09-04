package entity;
public final class PrimaryStudent extends Student {
	public String input;

	public PrimaryStudent(int Id, String name) {
		super(Id, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PrimaryStudent{" +
				"input='" + input + '\'' +
				'}';
	}

	public PrimaryStudent(String input) {
		this.input=input;

	}

}
