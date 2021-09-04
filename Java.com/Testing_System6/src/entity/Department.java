package entity;

import Backend.Checkerror;

import java.util.ArrayList;

public class Department extends Position {
   public static  ArrayList<Position> array = new ArrayList<Position>();
    private String hometown;
    @Override
    public String toString() {
        return super.toString() + " : " + "hometown"   +   " | "   +   hometown;
    }

    public String getHometown() {
        return hometown;
    }

    public Department(int id, String name,String hometown) {
        super(id, name);
        this.hometown=hometown;
    }

    public static void deparment() {
        System.out.println("Input Information For department");
        System.out.println("Input your hometown");
        String hometown = Checkerror.checkstring();
        System.out.println("Do you want to Input another position");
        System.out.println("=====================================");
        while (true) {
            System.out.println("1.Yes");
            System.out.println("2.No");
            int input = Checkerror.Checkint();
            switch (input) {
                case 1:
                    System.out.println("Input your name");
                    String name = Checkerror.checkstring();
                    System.out.println("Input your id");
                    int id = Checkerror.Checkint();
                    Department department = new Department(id,name,hometown);
                    array.add(department);
                    for (int i = 0; i < array.size(); i++) {
                        System.out.println("information  about Department and position " + " | " + array.get(i).toString());
                    }

                case 2:
                  return;
            }


        }
    }
}
