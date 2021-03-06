package Utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Check_error {
    private static Scanner sc = new Scanner(System.in);

    public static int inputInt() {
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                if (number >= 0) {
                    return number;
                }
                if (number < 0) {
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
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String string = sc.nextLine();
                if (!string.equals("")) {
                    return string;
                } else {
                    System.err.println(" String can not Empty Try input Again");
                }
            } catch (Exception e) {
                System.err.println(" String can not input \"[-+^]*\"");
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

    public static String checkfulname() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Full name kh??ng ???????c ch???a k?? t??? ?????c bi???t ==== ");
                String string = sc.nextLine().trim();
                Pattern pattern = Pattern.compile("^[a-zA-Z???????????????????????????????????????????????????????????????????????????????????????????-???\\s]+$");
                if (pattern.matcher(string).find()) {
                    return string;
                } else {
                    System.err.println("Input kh??ng ???????c ch???a k?? t??? ?????c bi???t Try Again");
                }
            } catch (Exception e) {
                System.err.println(" String can not Empty Try input Again");
            }
        }
    }

    public static String checkpasswords_Advanced() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String string = sc.nextLine().trim();
                Pattern Upper = Pattern.compile("^.*[A-Z]{2}+.*$");
                Pattern Lower = Pattern.compile("^.*[a-z]+.*$");
                Pattern number = Pattern.compile("^.*[0-9]+.*$");
                Pattern Lenght = Pattern.compile("^.{8,25}$");
                Pattern Special = Pattern.compile("^.*[#?!@$%^&*-]{2}+.*$");
                if (Upper.matcher(string).find() && Lower.matcher(string).find()
                        && number.matcher(string).find() && Lenght.matcher(string).find()
                        && Special.matcher(string).find()) {
                    return string;
                } else {
                    System.err.println("Input Not Matching Please Try Again");
                }
            } catch (Exception e) {
                System.err.println(" String can not Empty Try input Again");
            }
        }
    }

    public static String checkemail() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Email nh???p theo ?????nh d???ng .... @gmail.com....");
                String string = sc.nextLine().trim();
                Pattern pattern = Pattern.compile("^[a-zA-Z]+[@]+[a-z]+[\\.]+[com\\.]+$");
                if (pattern.matcher(string).find()) {
                    return string;
                } else {
                    System.err.println("Input Not Matching Please Try Again");
                }
            } catch (Exception e) {
                System.err.println(" String can not Empty Try input Again");
            }
        }
    }

    public static String checkpasswords() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("M???t kh???u kh??ng ???????c ch???a k?? t??? ?????c bi???t , ??t nh???t 2 ch??? vi??t hoa v?? c?? ????? d??i 8-20 k?? t??? ");
                String string = sc.nextLine().trim();
                Pattern Upper = Pattern.compile("^[A-Z]{2}+$");
                Pattern number = Pattern.compile("^[a-z???????????????????????????????????????????????????????????????????????????????????????????-???\\s]+$");
                Pattern Lenght = Pattern.compile("^.{8,20}$");
                if (Upper.matcher(string).find()
                        && number.matcher(string).find() && Lenght.matcher(string).find()) {
                    return string;
                } else {
                    System.err.println("Input Not Matching Please Try Again");
                }
            } catch (Exception e) {
                System.err.println(" String can not Empty Try input Again");
            }
        }
    }
}