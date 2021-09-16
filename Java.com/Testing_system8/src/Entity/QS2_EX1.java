package Entity;

import java.util.*;

public class QS2_EX1 implements  Comparable<QS2_EX1>{
    private int id;
    public static int i = 1;
    private String name;
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<QS2_EX1> arrayList = new ArrayList<>();
    public static Stack<QS2_EX1> stack = new Stack<>();
    public static Set<Object> set = new HashSet<Object>();
    public static List<Object> list = new ArrayList<Object>(set) {
    };

    public QS2_EX1(String name) {
        this.id = i++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public  String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "QS2_EX1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void Stack() {
        System.out.println("Input Quantity student=====");
        int number = Check_error.inputInt();
        for (int j = 0; j < number; j++) {
            System.out.println("Input your name");
            String name = Check_error.inputString();
            QS2_EX1 qs2_ex1 = new QS2_EX1(name);
            stack.push(qs2_ex1);
        }
    }

    public static void big() {
        Iterator<QS2_EX1> iterator = stack.iterator();
//    while (iterator.hasNext()){
//        QS2_EX1 qs2_ex1= iterator.next();
//        System.out.println(qs2_ex1);
//    }
        //stack.peek();
         stack.pop();
        for (QS2_EX1 qs2_ex1 : stack) {
            System.out.println(qs2_ex1);
        }
    }

    public static void Que() {
        Queue<QS2_EX1> qs2_ex1s = new LinkedList<>(stack);
        qs2_ex1s.peek();
        for (QS2_EX1 qs2:qs2_ex1s ) {
            System.out.println(qs2);

        }
    }
public static  void QS4(){
    System.out.println("Input Quantity student=====");
    int number = Check_error.inputInt();
    for (int j = 0; j < number; j++) {
        System.out.println("Input your name");
        String name = Check_error.inputString();
        QS2_EX1 qs2_ex1 = new QS2_EX1(name);
        set.add(qs2_ex1.getName());
    }
    System.out.println("Dupplicated  ignored ========");
   // Collections.sort(list);
    for (Object qs4:set ) {
        System.out.println(qs4);
    }
}
    @Override
    public int compareTo(QS2_EX1 o) {
        return this.name.compareTo(o.getName());
    }
}


