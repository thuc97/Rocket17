package entity.vti;

public class Person {
	private String name;
	private Gender gender;
	private String address;
	public int birthday;

	public enum Gender {
		MALE, FEMALE, UNKNOWN;
	}

	public Person() {
	}

	public Person(String name, Gender gender, int birthday, String address) {
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", birthday=" + birthday + ", address=" + address + "]";
	}
}




