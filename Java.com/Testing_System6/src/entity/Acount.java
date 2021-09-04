package entity;

import Backend.Checkerror;
import entity.Position;


import java.util.ArrayList;
import java.util.Scanner;


public class Acount {
    public static Scanner sc = new Scanner(System.in);

    public int id;
    public String email;
//			public String userName;
//			public String fullName;
//		    public LocalDate createdate;

    public Acount(int id, String email) {
        this.email = email;
        this.id = id;
//		this.userName=userName;
//		this.fullName=fullName;
//		this.createdate=createdate;
    }


    public static void checkAge() throws Exception {
        System.out.println("Input number");
        int input = sc.nextInt();
        if (input > 0) {
            System.out.println(input);
        } else {
            throw new Exception("\"The age must \n" +
                    "be greater than 0");
        }
    }

    public static void chekage2() {
        System.out.println("input number");
        while (true) {
            int input2 = Checkerror.Checkint();
            try {
                if (input2 > 18) {
                    System.out.println("Results :" + " | " + input2);
                } else {
                    System.out.println("Age have to >18 , Try Again");
                }
            } catch (Exception e) {
                System.out.println("Age have to >18 , Try Again");
            }

        }
    }

}

	

