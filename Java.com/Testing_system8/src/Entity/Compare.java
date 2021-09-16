package Entity;

import java.util.ArrayList;
import java.util.List;

public class Compare implements Comparable<Compare> {
    public static ArrayList<Compare> array = new ArrayList<>();
    private int id;
    private String name;

    public static void main(String[] args) {
        array.add(new Compare(5, "thuc"));
        array.add(new Compare(9, "An"));
        array.add(new Compare(1, "hai"));
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i).toString());

        }

    }

    @Override
    public String toString() {
        return "Compare{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Compare(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Compare o) {
       return this.name.compareTo(o.getName());
    }
}

