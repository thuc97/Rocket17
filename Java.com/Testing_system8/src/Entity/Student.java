package Entity;

import java.time.LocalDate;
import java.util.*;

public class Student {
  public static  Scanner scanner= new Scanner(System.in);
  public static ArrayList<Student> array = new ArrayList<>();
  private int id;
  private String name;
  private int score;
  private String lastname;
  private LocalDate birthday;

  public Student(int id,String lastname, String name, int score,LocalDate birthday) {
    this.id = id;
    this.name = name;
    this.score = score;
    this.lastname = lastname;
    this.birthday=birthday;
  }
  public int getId() {
    return id;
  }

  public LocalDate getBirthday() {
    return birthday;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  public String getLastname() {
    return lastname;
  }


  @Override
  public String toString() {
    return "Student{" +
            "id=" + id +
            ", name='" + name     +             " | "    +
            ", score=" + score    +             " | "    +
           // ", lastname='" + lastname + '\'' +
            ", birthday=" + birthday +
            '}';
  }


  public static void Map() {
    Map<Integer, String> map = new HashMap();
    System.out.println("Input Quantitys");
    int input = Check_error.inputInt();
    for (int i = 0; i < input; i++) {
      System.out.println("input name");
      String name = scanner.nextLine();
      name = scanner.nextLine();
      System.out.println("input id");
      int id = Check_error.inputInt();
      map.put(id, name);
    }
    for (Map.Entry<Integer, String> mapStudent :
            map.entrySet()) {
      System.out.println(mapStudent.getKey() + " || " + mapStudent.getValue());
    }
  }

  public static void input_inform() {
    System.out.println("input Quantitys");
    int number = Check_error.inputInt();
    for (int i = 0; i < number; i++) {
      System.out.println("Input your name");
      String name = scanner.nextLine();
      name = scanner.nextLine();
      String[] s=name.split("\\s");
      String lastname =s[s.length-1];
      System.out.println("Input id");
      int id = Check_error.inputInt();
      System.out.println("Input score");
      int score = Check_error.inputInt();
      System.out.println("Input Your birthday ======= ");
     LocalDate localDate =Check_error.inputLocalDate();
      Student student = new Student(id,lastname,name, score,localDate);
      array.add(student);
    }
  }
  public static void sortbyname() {
    Collections.sort(array, new Comparator<Student>() {
      @Override
      public int compare(Student o1, Student o2) {
     if(o1.getScore()==o2.getScore()){
     return o1.getLastname().compareTo(o2.getLastname());
     }
       if(o1.getLastname().equals(o2.getLastname())){
         return  o1.getBirthday().compareTo(o2.getBirthday());
       }
        return o1.getScore()>o2.getScore()?1:-1;
      }
    });
    for (Student stu : array) {
      System.out.println(stu.toString());
    }
  }
}