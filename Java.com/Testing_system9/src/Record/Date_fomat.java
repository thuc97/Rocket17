package Record;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Date_fomat {
    public static Scanner scanner =new Scanner(System.in);
    public static void main(String[] args) throws ParseException {
        date_format();
    }
    public static void date_format() {
SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy/MM/dd");
String date = simpleDateFormat.format(new Date());
        System.out.println(date);
    }
 public static void warning(){
Date date =new Date(2018,4,7);



 }

}
