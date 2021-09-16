package Entity;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class Check_error { private static Scanner sc = new Scanner(System.in);
    public static int inputInt() {
        while (true) {
            try {
              int number = Integer.parseInt(sc.next());
                if(number>=0 ) {
                        return  number;
                }
                if(number<0){
                    System.out.println(" Please Input Number >0 Please Try Again");
                }
            } catch (Exception e) {
                System.err.println("Invalided Number Try Again");
            }
        }
    }
    public Float inputFloat() {
        while (true) {
            try {
                return Float.parseFloat(sc.next());
            } catch (Exception e) {
                System.err.println("Input have to Data_type Float ");
            }
        }
    }
    public static Double inputDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.next());
            } catch (Exception e) {
                System.err.println("Input have to Data_type Double ");
            }
        }
    }
    public static String inputString() {
        while (true) {
                String string = sc.nextLine().trim();
                if (!string.equals("")) {
                    return string;
                } else {
                    System.err.println(" String can not Empty Try input Again");
                }
            }
        }

    public static LocalDate inputLocalDate() {
        System.out.println("Input datatype yyyy-MM-dd");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        while (true) {
            String localdate = sc.next().trim();
            try {
                if (format.parse(localdate) != null) {
                    LocalDate lc = LocalDate.parse(localdate);
                    return lc;
                }
            } catch (Exception e) {
                System.err.println("Not format Data type Try again");
            }
        }


    }


}


