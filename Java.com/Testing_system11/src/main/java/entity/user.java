package entity;
public class user {
    private String lastName;
    private String gender;

    public user(String lastName, String gender) {
        this.lastName = lastName;
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "user{" +
                "lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
