package com.vti.entity;
import java.util.ArrayList;
public class Department {
	int id;
	String name;
	public static void main(String[] args) {
		ArrayList<Department> aray = new ArrayList<Department>();
		Department[] dp = new Department[3];
		dp[0] = new Department(2, "Sale");
		aray.add(dp[0]);
		dp[1] = new Department(2, "Maketing");
		aray.add(dp[1]);
		dp[2] = new Department(2, "Samsung");
		aray.add(dp[2]);
		for (Department department : dp) {
			System.out.println(department);
		}
	}
	public Department() {

	}
	public Department(int id, String name) {
		this.id = 0;
		this.name = name;
	}
	public String toString() {
		return "id" + id + "\n" + "name:" + name;

	}

}