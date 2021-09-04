package entity;

import java.util.Scanner;

public class Position {
    private  String input;
    private  int id;
    private String name;

    public Position(String input) {
        this.input=input;
    }

    //    public  Position(){
//
//    }
public static void main(String[] args) {

}
    public Position(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Position() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }






    }






