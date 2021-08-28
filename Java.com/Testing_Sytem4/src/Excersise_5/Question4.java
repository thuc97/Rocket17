package Excersise_5;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Question4 {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Book> arraybook = new ArrayList<Book>();
	public static ArrayList<Book> arraymgz = new ArrayList<Book>();
	public static ArrayList<News> arraynews = new ArrayList<News>();

	public static void Addinform() {
		while (true) {
			System.out.println("1.Add new Book ========");
			System.out.println("2.Add new Magazine=====");
			System.out.println("3.Add new News ========");
			System.out.println("4.Exit ========");
			int ad = sc.nextInt();
			switch (ad) {
			case 1:
				System.out.println("Add Code====");
				String Code = sc.nextLine();
				Code = sc.nextLine();
				System.out.println("Add ProducerName====");
				String ProducerName = sc.nextLine();
				ProducerName = sc.nextLine();
				System.out.println("Add Quantity====");
				int Quantity = sc.nextInt();
				System.out.println("Add AuthorName====");
				String AuthorName = sc.nextLine();
				AuthorName = sc.nextLine();
				System.out.println("Add NumberPage====");
				int NumberPage = sc.nextInt();
				Book book = new Book(Code, ProducerName, Quantity, AuthorName, NumberPage);
				arraybook.add(book);
				break;
			case 2:
				System.out.println("Add Code====");
				String Code1 = sc.nextLine();
				Code1 = sc.nextLine();
				System.out.println("Add ProducerName====");
				String ProducerName1 = sc.nextLine();
				ProducerName1 = sc.nextLine();
				System.out.println("Add Quantity====");
				int Quantity1 = sc.nextInt();
				System.out.println("Add AuthorName====");
				String AuthorName1 = sc.nextLine();
				AuthorName1 = sc.nextLine();
				System.out.println("Add NumberPage====");
				int NumberPage1 = sc.nextInt();
				System.out.println("Add LaunchNumber====");
				int LaunchNumber = sc.nextInt();
				int launchMonth;
				do {
					System.out.println("Add launchMonth====");
					launchMonth = sc.nextInt();
					if (launchMonth > 12) {
						System.out.println("Out of Values");
					}
				} while (launchMonth > 12);
				Magazine mgz = new Magazine(Code1, ProducerName1, Quantity1, AuthorName1, NumberPage1, LaunchNumber,
						launchMonth);
				arraymgz.add(mgz);
				break;
			case 3:
				System.out.println("Add Code====");
				String Code2 = sc.nextLine();
				Code2 = sc.nextLine();
				System.out.println("Add ProducerName====");
				String ProducerName2 = sc.nextLine();
				ProducerName2 = sc.nextLine();
				System.out.println("Add Quantity====");
				int Quantity2 = sc.nextInt();
				System.out.println("Add AuthorName====");
				String AuthorName2 = sc.nextLine();
				AuthorName2 = sc.nextLine();
				System.out.println("Add NumberPage====");
				int NumberPage2 = sc.nextInt();
				System.out.println("Add LaunchDays====");
				int LaunchDays;
				do {
					System.out.println("Add LaunchDays====");
					LaunchDays = sc.nextInt();
					if (LaunchDays > 31) {
						System.out.println("Out of Values");
					}
				} while (LaunchDays > 31);
				News nw = new News(Code2, ProducerName2, Quantity2, AuthorName2, NumberPage2, LaunchDays);
				arraynews.add(nw);
				break;
			case 4:
				return;
			default:
				System.out.println("Out of Values Try Again");
				break;

			}
		}
	}

	public static void showinform() {
		while (true) {
			System.out.println("Please choose Options ========");
			System.out.println("1.Show infor about Boooks ========");
			System.out.println("2.Show infor about Magazines=====");
			System.out.println("3.Show infor about News========");
			System.out.println("4.Exit ========");
			int show = sc.nextInt();
			switch (show) {
			case 1:
				System.out.println("1.Show infor about Boooks ========");
				for (Book book : arraybook) {
					System.out.println(book.toString());
				}
				break;
			case 2:
				System.out.println("2.Show infor about Magazines=====");
				for (Book book : arraymgz) {
					System.out.println(book.toString());
				}

				break;
			case 3:
				System.out.println("3.Show infor about News========");
				for (Book book : arraynews) {
					System.out.println(book.toString());
				}
				break;
			case 4:
				return;
			default:
				System.out.println("Out of Values Try Again");
				break;
			}
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	public static void FindInform() {
		while (true) {
			System.out.println("Please choose Options ========");
			System.out.println("1.Find infor about Boooks ========");
			System.out.println("2.Find infor about Magazines=====");
			System.out.println("3.Find infor about News========");
			System.out.println("4.Exit ========");
			int find = sc.nextInt();
			switch (find) {
			case 1:
				System.out.println("Input inform to Looking for");
				int dele = sc.nextInt();
				for (Book book : arraybook) {
					if (book.getQuantity() == (dele)) {
						System.out.println(book.toString());
					} else {
						System.out.println("Cannot find Any Inform");
						break;
					}
				}
			case 2:
				System.out.println("Input inform to Looking for");
				int mgz = sc.nextInt();
				for (int i = 0; i < arraymgz.size(); i++) {
					if (arraymgz.get(i).getNumberPage() == mgz) {
						System.out.println(arraymgz.get(i).toString());
					} else {
						System.out.println("Cannot find Any Inform");
						break;
					}
				}
			case 3:
				System.out.println("Input inform to Looking for");
				String nw = sc.nextLine();
				nw = sc.nextLine();
				for (News nwe : arraynews) {
					if (nwe.getAuthorName().equals(nw)) {

						System.out.println(nwe.toString());
					} else {
						System.out.println("Cannot find Any Inform");
						break;
					}
				}
			case 4:
				return;
			default:
				System.out.println("Out of Values Try Again");
				break;
			}
		}

	}

	public void delete() {
		while(true) {
		System.out.println("Please choose Options ========");
		System.out.println("1.Delete infor about Boooks ========");
		System.out.println("2.Delete infor about Magazines=====");
		System.out.println("3.Delete infor about News========");
		System.out.println("4.Exit ========");
		int delete = sc.nextInt();
		switch (delete) {

		case 1:
			System.out.println("1.Delete infor about Boooks ========");
			System.out.println("Input inform to delete ========");
			int dl = sc.nextInt();
			for (int i = 0; i < arraybook.size(); i++) {
				if (arraybook.get(i).getNumberPage() == dl) {
					arraybook.remove(i);
				//	System.out.println(arraybook.toString());
				}
			}
			break;
		case 2:
			System.out.println("1.Delete infor about Magazine ========");
			System.out.println("Input inform to delete ========");
			String st = sc.nextLine();
			st = sc.nextLine();
			for (int i = 0; i < arraymgz.size(); i++) {
				if (arraymgz.get(i).getAuthorName().equals(st)) {
					arraymgz.remove(i);
					//System.out.println(arraymgz.toString());
				}
			}
			break;
		case 3:

			System.out.println("1.Delete infor about Magazine ========");
			System.out.println("Input inform to delete ========");
			int nw = sc.nextInt();
			for (int i = 0; i < arraynews.size(); i++) {
				if (arraynews.get(i).getNumberPage() == nw) {
					arraynews.remove(i);
					//System.out.println(arraynews.toString());
				}
			}
			break;
		case 4:
			return;
		default:
			System.out.println("Out of values  Try Again");
			break;
		}

	}
}
}