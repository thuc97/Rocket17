package Hoc_Record;

import java.util.ArrayList;
import java.util.Scanner;

public class Generic <T> extends  Number {
    public static Scanner scanner= new Scanner(System.in);
    private T id;
    private String name;
    public Generic(){

    }

    public Generic(T id, String name) {
        this.id = id;
        this.name = name;
    }

    public T getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(T id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        check();
    }

    public static  void check() {
//        Generic<Float> employy = new Generic<Float>(1.5F, "thuc");
//        Generic<Integer> employy1 = new Generic<Integer>(1, "trung");
//        Generic<Double> employy2 = new Generic<Double>(10000.0, "thuc");


        Generic generic= new Generic();
        generic.print(1,"thuc");
        generic.print(1.5,"trung");
        generic.print(15555.0555,"chinh");
    }
    <T>  void print(T a, T b){
        System.out.println(a);
        System.out.println(b);

    }
    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}
