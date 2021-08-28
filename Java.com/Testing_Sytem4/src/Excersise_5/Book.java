package Excersise_5;

import java.time.Month;
import java.time.Year;

public class Book {
	private String Code;
	private String ProducerName;
	private int Quantity;
	private String AuthorName;
	private int NumberPage;
	

	@Override
	public String toString() {
		return "Book [Code=" + Code + ", ProducerName=" + ProducerName + ", Quantity=" + Quantity + ", AuthorName="
				+ AuthorName + ", NumberPage=" + NumberPage + "]";
	}

	public String getCode() {
		return Code;
	}

	public String getProducerName() {
		return ProducerName;
	}

	public int getQuantity() {
		return Quantity;
	}

	public String getAuthorName() {
		return AuthorName;
	}

	public int getNumberPage() {
		return NumberPage;
	}

	public Book(String code, String producerName, int quantity, String authorName, int numberPage) {
		super();
		Code = code;
		ProducerName = producerName;
		Quantity = quantity;
		AuthorName = authorName;
		NumberPage = numberPage;
	}

}
