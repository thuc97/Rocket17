package Excersise_5;
public class News extends Book {
public News(String code, String producerName, int quantity, String authorName, int numberPage,int LaunchDays) {
		super(code, producerName, quantity, authorName, numberPage);
		this.LaunchDays=LaunchDays;
		// TODO Auto-generated constructor stub
	}
private int LaunchDays;
@Override
public String toString() {
	return super.toString() + "News [LaunchDays=" + LaunchDays + "]";
}
public int getLaunchDays() {
	return LaunchDays;
}

}
