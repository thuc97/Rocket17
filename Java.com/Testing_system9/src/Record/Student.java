package Record;

public class Student {
    private int id;
    public static int i = 1;
    private String name;

    public Student(String name) {
        this.id = i;
        this.name = name;
        i++;
    }

    /**
     *
     * @deprecated replaced by (@link # getidd (student))
     */
    @Deprecated
    public int getId() {
        return getId();

    }
    public String getidd() {
        return "MSV :" + id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }
}
