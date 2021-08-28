package backend;

import entity.vti.News;

import java.util.ArrayList;
import java.util.Scanner;

public class Excercise1_QS1 {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<News> array = new ArrayList<News>();
	public  void QS1(){
while (true) {
		System.out.println("Please Choose Options");
		System.out.println("1.InsertNew ");
		System.out.println("2.View listnews");
		System.out.println("3.Average news");
		System.out.println("4.Exit=========");
		int view = sc.nextInt();
		switch (view) {
		case 1:
			System.out.println("1.InsertNew ");
			System.out.println("Input ID");
			int Id = sc.nextInt();
			System.out.println("Input Title");
			String Title = sc.nextLine();
			Title = sc.nextLine();
			System.out.println("InputPublishDate");
			int Publicdate = sc.nextInt();
			System.out.println("Input Author");
			String Author = sc.nextLine();
			Author = sc.nextLine();
			System.out.println("Input Content");
			String Content = sc.nextLine();
			Content = sc.nextLine();
			System.out.println("Input Average");
			float AverageRate=sc.nextFloat();
			System.out.println("Input Rates1");
			float rate1 = sc.nextFloat();
			System.out.println("Input Rates2");
			float rate2 = sc.nextFloat();
			System.out.println("Input Rates3");
			float rate3 = sc.nextFloat();
			float[] rates = { rate1, rate2, rate3 };
			News nw = new News(Id, Title, Publicdate, Author, Content,AverageRate,rates);
			array.add(nw);
			break;
		case 2:
			for (News n : array) {
				System.out.println(n.toString());
			}

			break;
		case 3:
			for (News n : array) {
				System.out.println(n.calculate());
			}
			break;
			
		case 4 :
			System.exit(1);
		break;
		default :
			System.out.println("Out of values Try Again");
			break;
			
		}	

		}
	}
	}
