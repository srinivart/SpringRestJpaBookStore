package book;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Books {
	private @Id @GeneratedValue Long id;
	private String title;
	private String author;
	private String genre;
	private double price;
	private int year;
	
	
	public Books() {
	}


	public Books(String title, String author, String genre, double price, int year) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.price = price;
		this.year = year;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	  @Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof Books))
	      return false;
	    Books books = (Books) o;
	    return Objects.equals(this.title, books.title) && Objects.equals(this.author, books.author);     
	  }
	
	  @Override
	  public int hashCode() {
	    return Objects.hash(this.title, this.author);
	  }
	  @Override
	  public String toString() {
	    return "Books{" + "title=" + this.title + ", author='" + this.author + '\'' + ", genre='" + this.genre + '\'' + '}';
	  }

}
