package backend;

import entity.vti.Admissions;

import java.util.Scanner;

public class Excercise1_QS2 {
	public static Scanner scanner = new Scanner(System.in);
	public void QS2(){
		Admissions admissions = new Admissions();
		while(true) {
		System.out.println("Moi ban chon chuc nang: \n" +"1: Add new candidates... \n"+"2: Show info... \n"
							+"3: Search with code... \n" + "4: Exit programe");
		int option = Integer.parseInt(scanner.nextLine());
		switch (option) {
		case 1: {
			admissions.addNewCandidate();
			break;
		}
		case 2: {
			admissions.showInfo();
			break;
		}
		case 3: {
			admissions.searchWithCode();
			break;
		}
		case 4: {
			System.exit(1);
			break;
		}
		default:
			System.out.println("Ban chon sai chuc nang vui long chon lai");
			break;
		}
	}}
}