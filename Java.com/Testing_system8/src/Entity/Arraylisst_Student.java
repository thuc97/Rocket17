package Entity;

import java.util.*;

public class Arraylisst_Student implements Comparable<Arraylisst_Student> {
    public  static  Scanner scanner= new Scanner(System.in);

    public static List<Arraylisst_Student> arraylisst = new ArrayList<>();
  //  public static List<Arraylisst_Student> studentCopies = new ArrayList<>();

    private String name;
    public static int i = 1;
    private int id;


    public Arraylisst_Student(String name) {
        this.name = name;
        this.id = i;
        i++;
    }




    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }


    public String toString() {
        return "Arraylisst_Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }




    public static void Input_information() {
        System.out.println("Input your name");
        String name =scanner.nextLine();

        Arraylisst_Student student = new Arraylisst_Student(name);
        arraylisst.add(student);
        System.out.println("====================== ");
    }


    public static void show_information() {
        System.out.println("Lengh_of student======= ");
        System.out.println(arraylisst.size());
        System.out.println("====================== ");
        System.out.println("Get student  4 ");
        System.out.println(arraylisst.get(4));
        System.out.println("====================== ");
        System.out.println("Add more at first position ======== ");
        System.out.println("input name student to add ");
        String input = scanner.nextLine();

        arraylisst.add(0, new Arraylisst_Student(input));
        System.out.println("Name After Added");
        for (int j = 0; j < arraylisst.size(); j++) {
            System.out.println(arraylisst.get(j).toString());
        }
        System.out.println("====================== ");
        System.out.println("Add more at the End of position ======== ");
        System.out.println("input name student to add ");
        String input2 = scanner.nextLine();

        arraylisst.add(new Arraylisst_Student(input2));
        System.out.println("Name After Added=======");
        for (int j = 0; j < arraylisst.size(); j++) {
            System.out.println(arraylisst.get(j).toString());
        }
        System.out.println("====================== ");
        System.out.println("Reverse Arraylist ");
        Collections.reverse(arraylisst);
        for (int j = 0; j < arraylisst.size(); j++) {
            System.out.println(arraylisst.get(j).toString());
        }
        System.out.println("====================== ");
    }

    public static void fidn_id() {
        for (int j = 0; j < arraylisst.size(); j++) {
            System.out.println(arraylisst.get(j).toString());
        }
            System.out.println("input  to looking for");
            String input3 = scanner.nextLine();
            for (Arraylisst_Student stu : arraylisst) {
                if (stu.getName().equals(input3)) {
                    System.out.println(stu.toString());
                } else {
                    System.out.println("cannot find candidate");
                }
            }
        }


    public static void delete() {

        System.out.println("input  to delete");
        int delete = Check_error.inputInt();
        for (int j = 0; j < arraylisst.size(); j++) {
            if (arraylisst.get(j).getId() == delete) {
                arraylisst.remove(j).getName();
            }
            System.out.println(arraylisst.get(j).toString());
        }
        System.out.println("====================== ");
    }
    public static void duplicated() {
        System.out.println("Các sinh viên trùng tên: ");
        for (int i = 0; i < arraylisst.size(); i++) {
            for (int k = i + 1; k < arraylisst.size(); k++) {
                if
                (arraylisst.get(i).getName().equals(arraylisst.get(k).getName())) {
                    System.out.println(arraylisst.get(i).toString());
                }
            }
        }
        System.out.println("====================== ");
    }

    public static void add_all() {
        System.out.println("Add all Student ");
        //studentCopies.addAll(arraylisst);
        Collections.sort(arraylisst);
//     for (int j = 0; j < studentCopies.size() ; j++) {
//         System.out.println(studentCopies.get(j).toString2());
//     }
        for (Arraylisst_Student array : arraylisst) {
            System.out.println(array.toString());
        }
    }

    @Override
    public int compareTo(Arraylisst_Student o)
    {
       return this.name.compareTo(o.getName());
    }
}
