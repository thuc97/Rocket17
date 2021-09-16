package entity;

public class Position2 {
    private int id;
    private  String name;
private  String firstname;
private String author_ID;
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public Position2() {

    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setAuthor_ID(String author_ID) {
        this.author_ID = author_ID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
