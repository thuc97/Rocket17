package Backend;
import java.io.File;
import java.util.Scanner;


public class Excercise3 {
    public static Scanner sc=new Scanner (System.in);
    public static void main(String[] args) {
        QS1 ();
    }
    public static  void QS1 (){
    System.out.println("Input file Path to check ");
    File file =new File(sc.nextLine());
    System.out.println(file.exists()? "File exists()" : "file not exists()");
}



}



