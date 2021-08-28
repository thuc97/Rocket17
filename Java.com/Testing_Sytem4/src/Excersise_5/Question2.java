package Excersise_5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Excersise_5.Công_nhân.Leval;
import Excersise_5.Kỹ_Sư.work;
import Excersise_5.Nhân_viên.cong_viec;
import Excersise_5.can_bo.Gender;

public class Question2 {
	public static ArrayList<can_bo> arraylist = new ArrayList<can_bo>();
	public static ArrayList<Nhân_viên> array = new ArrayList<Nhân_viên>();
	public static ArrayList<Công_nhân> arrayl = new ArrayList<Công_nhân>();
	public static ArrayList<Kỹ_Sư> arrayl2 = new ArrayList<Kỹ_Sư>();
	private Gender gender;
	private Gender gender1;
	public static Scanner sc = new Scanner(System.in);

	public void Newperson() {
		while (true) {
			System.out.println("Please choose Options========");
			System.out.println("1.Add new worker=============");
			System.out.println("2.Add new Engineer===========");
			System.out.println("3.Add new Empployee==========");
			System.out.println("4.Exit==========");
			System.out.println("\n");
			int add = sc.nextInt();
			switch (add) {
			case 1:
				System.out.println("Add Name");
				String name = sc.nextLine();
				name = sc.nextLine();
				System.out.println("Add Age");
				int Age = sc.nextInt();
				System.out.println("Add Address");
				String Address = sc.nextLine();
				Address = sc.nextLine();
				System.out.println("Choose Gender");
				Gender gender = null;
				int gende;
				do {
					gende = sc.nextInt();
					if (gende > 3) {
						System.out.println(" Please Try Again");
					}
				} while (gende > 3);
				switch (gende) {
				case 1:
					gender = Gender.MALE;
					break;
				case 2:
					gender = Gender.FEAMLE;
					break;
				case 3:
					gender = Gender.UNKNOW;
					break;
				}

				System.out.println("Choose Level");
				System.out.println("1.Level 1");
				System.out.println("2.Level 2");
				System.out.println("3.Level 3");
				Leval level1 = null;
				int b;
				do {
					b = sc.nextInt();
					if (b > 3) {
						System.out.println(" Please Try Again");
					}
				} while (b > 3);
				switch (b) {
				case 1:
					level1 = Leval.ONE;
					break;

				case 2:
					level1 = Leval.TWO;
					break;
				case 3:
					level1 = Leval.THREE;
					break;
				}

				Công_nhân congnhan = new Công_nhân(name, Age, Address, gender, level1);
				arraylist.add(congnhan);
				arrayl.add(congnhan);

				break;
			case 2:
				System.out.println("2.Add new Engineer");
				System.out.println("Add Name");
				String name1 = sc.nextLine();
				name1 = sc.nextLine();
				System.out.println("Add Age");
				int Age1 = sc.nextInt();
				System.out.println("Add Address");
				String Address1 = sc.nextLine();
				Address1 = sc.nextLine();
				System.out.println("Choose Gender");
				Gender gender2 = null;
				int gende1;
				do {
					gende1 = sc.nextInt();
					if (gende1 > 3) {
						System.out.println(" Please Try Again");
					}
				} while (gende1 > 3);
				switch (gende1) {
				case 1:
					gender2 = Gender.MALE;
					break;
				case 2:
					gender2 = Gender.FEAMLE;
					break;
				case 3:
					gender2 = Gender.UNKNOW;
					break;
				}
				System.out.println("Choose Career");
				System.out.println("1.ELECTRICAL");
				System.out.println("2.INFORMATION");
				int h = sc.nextInt();
				work work1 = null;
				switch (h) {
				case 1:
					work1 = work.ELECTRICAL;
					break;
				case 2:
					work1 = work.INFORMATION;
					break;
				}
				Kỹ_Sư kysu = new Kỹ_Sư(name1, Age1, Address1, gender2, work1);
				arraylist.add(kysu);
				arrayl2.add(kysu);
				break;
			case 3:
				
				System.out.println("3.Add new Employee");
				System.out.println("Add Name");
				String name2 = sc.nextLine();
				name2 = sc.nextLine();
				System.out.println("Add Age");
				int Age2 = sc.nextInt();
				System.out.println("Add Address");
				String Address2 = sc.nextLine();
				Address1 = sc.nextLine();
				System.out.println("Choose Gender");
				Gender gender3 = null;
				int gende3 = sc.nextInt();

				switch (gende3) {

				case 1:

					gender3 = Gender.MALE;

					break;
				case 2:
					gender3 = Gender.FEAMLE;
					break;
				case 3:
					gender3 = Gender.UNKNOW;
					break;
				}

				System.out.println("Choose work");
				cong_viec cong = null;
				int nhap = sc.nextInt();

				switch (nhap) {

				case 1:

					cong = cong_viec.PLAYGAME;
//					Nhân_viên nv1 = new Nhân_viên(name2, Age2, Address2, gender3, cong);
//					arraylist.add(nv1);
//					array.add(nv1);
					break;
				case 2:
					cong = cong_viec.SOCCER;
//					Nhân_viên nv2 = new Nhân_viên(name2, Age2, Address2, gender3, cong);
//					arraylist.add(nv2);
//					array.add(nv2);
					break;

				}

				Nhân_viên nv = new Nhân_viên(name2, Age2, Address2, gender3, cong);
				arraylist.add(nv);
				array.add(nv);
				break;
			default:
				return;
			}

		}
	}
	
	public void show() {
		while (true) {

			System.out.println("Please choose Options=========");
			System.out.println("1.Show Infor Worker===========");
			System.out.println("2.Show Infor Engineer=========");
			System.out.println("3.Show Infor Employee=========");
			System.out.println("4.Exit===============");
			int t = sc.nextInt();

			for (Công_nhân Công_nhân : arrayl) {
				if (t == 1) {
					System.out.println(Công_nhân);
				} else if (t == 2) {

					for (Kỹ_Sư Kỹ_Sư : arrayl2) {

						System.out.println(Kỹ_Sư);

					}
				} else if (t == 3) {
					for (Nhân_viên nhân_viên : array) {

						System.out.println(nhân_viên);

					}
				} else {
					break;

				}
			}
			return;
		}

	}

	public void findinformation() {
		while (true) {
			System.out.println("Please choose Options===========");
			System.out.println("1.Find out Infor Worker=========");
			System.out.println("2.Find out Infor Engineer=======");
			System.out.println("3.Find out Infor Employee=======");
			System.out.println("4.Exit=======");
			int k = sc.nextInt();
			System.out.println("1.Inputn Infor to Find out");
			String c = sc.nextLine();
			c = sc.nextLine();
			boolean timthay = false;
			if (k == 1) {
				for (Công_nhân Công_nhân : arrayl) {

					if (Công_nhân.getAddress().equals(c)) {
						timthay = true;
						System.out.println(Công_nhân.toString());
					}

					if (k == 2) {
						for (Kỹ_Sư Kỹ_Sư : arrayl2) {

							if (Kỹ_Sư.getAddress().equals(c)) {
								timthay = true;
								System.out.println(Kỹ_Sư);
							}

							if (k == 3) {
								for (Nhân_viên nhân_viên : array) {

									if (nhân_viên.getAddress().equals(c)) {
										timthay = true;
										System.out.println(nhân_viên);
									}

									else if (timthay == false) {

										System.out.println("Cannot Find any Inform Please Try Again");
										

									}
									break;
								}

							}

						}

					}

				}

			}
			return;
		}
	}

	public void Delete() {
		System.out.println(" Please input inform to delete");
		boolean have = false;
		int g = sc.nextInt();
		for (int i = 0; i < arraylist.size(); i++) {
			if (g == arraylist.get(i).getAge()) {
				arraylist.remove(i);
				have = true;
				break;
			} else if (!have) {
				System.out.println("Can Found inform Please Try Again");

			}

		}

	}
}
