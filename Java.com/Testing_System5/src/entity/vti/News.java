package entity.vti;

import java.util.Arrays;

public class News implements Inews {
	private int Id;
	private String Title;
	private int Publicdate;
	private String Author;
	private String Content;
	private float AverageRate;
	private float[] rates;



	public News(int id, String title, int publicdate, String author, String content, float averageRate, float[] rates) {
		super();
		Id = id;
		Title = title;
		Publicdate = publicdate;
		Author = author;
		Content = content;
		AverageRate = averageRate;
		this.rates = rates;
	}

	public int getID() {
		return Id;
	}

	public String getTitle() {
		return Title;
	}

	public int getPublicdate() {
		return Publicdate;
	}

	public String getAuthor() {
		return Author;
	}

	public String getContent() {
		return Content;
	}

	public float getAverageRate() {
		return AverageRate;
	}

	@Override
	public void Display() {
		System.out.println("Title:" + Title);
		System.out.println("publishdate:" + Publicdate);
		System.out.println("avergare:" + AverageRate);

	}

	@Override
	public float calculate() {
		AverageRate = (float) ((rates[0] + rates[1] + rates[2]) / 3);
		return AverageRate;

	}

	@Override
	public String toString() {
		return "News [Id=" + Id + ", Title=" + Title + ", Publicdate=" + Publicdate + ", Author=" + Author
				+ ", Content=" + Content + ", AverageRate=" + AverageRate + ", rates=" + Arrays.toString(rates) + "]";
	}

}
