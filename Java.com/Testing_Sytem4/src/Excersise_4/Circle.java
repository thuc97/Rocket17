package Excersise_4;

public class Circle {
private double radius =1.0;	
private String color="red";
private double Area;
public Circle() {
		
}
public double getRadius() {
	return radius;
}
public void setRadius(double radius) {
	this.radius = radius;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public double getArea() {
	return Area;
}
public void setArea(double area) {
	Area = area;
}
public Circle( double  radius) {
	this.radius=radius;
}
public Circle( double  radius ,String color) {
	this.radius=radius;
	this.color=color;
}	

}
