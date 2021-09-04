package Backend;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;
public class Checkerror {
    public static int Checkint() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                int input = Integer.parseInt(scanner.next());
                if (input >= 0) {
                    return input;
                }
                if (input < 0) {
                    System.out.println("Input number graeter 0");
                }
            } catch (Exception e) {
                System.out.println(" Input a number Not String");
            }
        }
    }


    public static float inputfloat() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                return Float.parseFloat(scanner.next());
            } catch (Exception e) {
                System.out.println("Input number is data type  Float");
            }

        }
    }

    public static String checkstring() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Input Datatype String not Number");
            }
        }
    }

    public static LocalDate inputLocalDate() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Input Date");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String local = scanner.next().trim();
            try {
                if (simpleDateFormat.parse(local) != null) {
                    LocalDate lc = LocalDate.parse(local);
                    return lc;
                }
            } catch (Exception e) {
                System.out.println("Try Again");
            }
        }
    }
    public static Double inputdouble() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                return Double.parseDouble(scanner.next());
            } catch (Exception e) {
                System.out.println("Input number is data type  Double");
            }

        }
    }




}