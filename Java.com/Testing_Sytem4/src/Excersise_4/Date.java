package Excersise_4;
public class Date {
private int day;
private int month;
private int year;
public int getDay() {
	return day;
}
public void setDay(int day) {
	this.day = day;
}
public int getMonth() {
	return month;
}
public void setMonth(int month) {
	this.month = month;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
@Override
public String toString() {
	return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
}
public Date(int day, int month, int year) {
	super();
	this.day = day;
	this.month = month;
	this.year = year;
}
	
public boolean 	isleapyear() {
	year=this.year;
	
if(year%4==0) {
	return true;
}	
if(year%100==0)	{
	return false;
}
else {
	return false;
}
}
	
		

}
