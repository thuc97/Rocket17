package Excersise_5;

import java.time.LocalDate;
import java.time.Month;

public class Magazine extends Book {
	public Magazine (String code, String producerName, int quantity, String authorName, int numberPage, int LaunchNumber,int launchMonth) {
		super(code, producerName, quantity, authorName, numberPage);
		this.LaunchNumber=LaunchNumber;
		this.launchMonth=launchMonth;
		// TODO Auto-generated constructor stub
	}		
private int LaunchNumber;
private int launchMonth;
@Override
public String toString() {
	return super.toString() +"Magazine [LaunchNumber=" + LaunchNumber + ", launchMonth=" + launchMonth + "]";
}
public int getLaunchNumber() {
	return LaunchNumber;
}
public int getLaunchMonth() {
	return launchMonth;
}
}
