package Excersise_4;

public class Acount {
private int id;
private String name;
private int balance;
public Acount(int id, String name, int balance) {
	super();
	this.id = id;
	this.name = name;
	this.balance = balance;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}
	
public int credit(int amount) {
return this.balance += amount;
}

public int debit(int amount) {
return this.balance -= amount;
}	
	
	
	
	

}
