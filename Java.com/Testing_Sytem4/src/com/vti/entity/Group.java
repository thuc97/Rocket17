package com.vti.entity;
import java.time.LocalDate;

public class Group {
int id;
public String  groupName;
public Account creatorID;
public LocalDate  createDate;
public Account [] accounts;	
public String [] usernames;
public String account;

public Group(){
}

public Group (String  groupName ,Account creatorID,LocalDate  createDate, Account[] accounts ) {
this.groupName=	groupName;
this.creatorID=creatorID;
this.accounts=accounts;
this.createDate=createDate;
}

public Group (String  groupName ,Account creatorID, String []  usernames,LocalDate  createDate ) {
this.groupName=	groupName;
this.creatorID=creatorID;
Account[] accounts1 = new Account[ usernames.length];
for (int i=0 ; i< usernames.length;i++ ) {
	accounts1 [i]=new Account( usernames [i]);
}
this.createDate=createDate;
}
};







