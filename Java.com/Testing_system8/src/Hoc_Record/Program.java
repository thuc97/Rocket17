package Hoc_Record;

import java.util.*;

public class Program {
    public static Scanner sc = new Scanner(System.in);
    public static List<Program> arrayList = new ArrayList<Program>();
    private int id;
    public static int count = 1;
    public String name;

    public static void main(String[] args) {
        // array();
       //   QS1();
        //  Set();
        // Iterator();
        //   Map();
        //  generic();
        // nhap();
        interraator();
    }

    public static void array() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(9);
        numbers.add(5);
        numbers.add(0);
        numbers.add(0, 4);
        numbers.add(5, 4);


        // numbers.clear();
        //  numbers.remove(1);
        // cach 2 :  numbers = Arrays.asList(1, 2, 3, 9, 5);
        for (Integer interger : numbers) {
            System.out.println(interger);
        }
//        System.out.println(numbers.size());
//        System.out.println(numbers.get(4));
    }

    public Program(String name) {
        this.name = name;
        this.id = count;
        count++;
    }


    @Override
    public String toString() {
        return "Program{" +
               // "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public static void QS1() {
        while (true) {
            System.out.println("Please choose Options");
            System.out.println("|| 1.Input  Inform ||");
            System.out.println("|| 2.show          || ");
            System.out.println("|| 3.Exit          || ");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("|| 1.Input name ||");
                    String name = sc.next();
                    Program program = new Program(name);
                    arrayList.add(program);
                    break;
                case 2:
                    arrayList.sort(Comparator.comparing(Program ::getName));
                    for (int i = 0; i <arrayList.size() ; i++) {
                        System.out.println(arrayList.get(i).toString());
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Out of values ");
                    break;
            }
        }
    }
    public static void Set() {
        HashSet<String> numbers = new HashSet<>();
        numbers.add("thuc");
        numbers.add("thuc");
        numbers.add("trung");
        numbers.add("hai");
        numbers.add("hai");
        for (String interger : numbers) {
            System.out.println(interger);
        }
    }

    public static void Iterator() {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(2);
        numbers.add(2);
        numbers.add(9);
        numbers.add(9);
        numbers.add(5);
        Iterator<Integer> integerIterator = numbers.iterator();
        System.out.println(integerIterator.next());
        System.out.println(integerIterator.next());
        System.out.println(integerIterator.next());
        System.out.println(integerIterator.next());


    }

    public static void Map() {
// Student (id,name);
        HashMap<Integer, String> students = new HashMap<>();
        students.put(1, "Nguyen A");
        students.put(2, "Nguyen B");
        students.put(3, "Nguyen C");
        System.out.println(students.get(2));
// Has map mục đích dùng Key để tìm kiếm các giá trị khác

    }
    public static void generic() {
        Generic.check();
    }
    public static void nhap() {
        System.out.println("nhap name");
        String string = sc.nextLine();
        Program[] programs = new Program[5];
        for (int i = 0; i < programs.length; i++) {
            programs[i] = new Program(string);
            System.out.println(programs[i]);
        }
    }
    public static void interraator() {
        Set<Object>set= new HashSet<Object>();
        while (true) {
            System.out.println("lua chon");
            System.out.println("1. input name");
            System.out.println("2. show");
            System.out.println("3. muon den som");
            System.out.println("4. sinhvienconlai");
            int inputt = sc.nextInt();
            switch (inputt) {
                case 1:
                    System.out.println("Nhập số sinh viên muốn tạo: ");
                    int num2 = sc.nextInt();
                    for (int i = 0; i < num2; i++) {
                        System.out.println("nhap name");
                        String nhap =sc.nextLine();
                       Program program=new Program( nhap);
                       set.add(program.getName());
                    }
                    break;
                case 2:
                Iterator<Object>iterator= set.iterator();
                    for ( Object  ob:set ) {
                        System.out.println(ob.toString());
                    }

















                    break;

                case 3:
                    break;

            }
        }
    }
    }
