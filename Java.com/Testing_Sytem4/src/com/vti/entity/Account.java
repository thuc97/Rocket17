package com.vti.entity;
import java.time.LocalDate;

public class Account  {

	 Group[] groups ;
	public String fullNames;
	public String email;
	public String usernames;
	public int id;
	public Department department;
	public Position position;
	public LocalDate createDate;
	private String usernames2;
	
	
	public Account() {
		
	}	

	public Account(int id, String email, String userNames, String fullNames) {
	this.id = id;
	this.email = email;
	this.usernames = userNames;
	this.fullNames = fullNames;
		};
	
	public   Account (int id, String email, String userNames, String fullNames,Position position) {
		
	this.id = id;
	this.email = email;
	this.usernames = userNames;
	this.fullNames = fullNames;
	this.position= position;	
	this.createDate=LocalDate.now();	
	};

	public   Account (int id, String email, String userNames, String fullNames,Position position,LocalDate createDate) {
		
	this.id = id;
	this.email = email;
	this.usernames = userNames;
	this.fullNames = fullNames;
	this.position= position;	
	this.createDate=createDate;
	
	

	}

	public Account(String  usernames) {
		this.usernames=usernames;
	}
};
