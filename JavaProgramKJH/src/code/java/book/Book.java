package code.java.book;

import java.util.Date;

public class Book {
	private String author;
	private int price;
	private String title;
	private Date publishDate;
	
	public Book(String author, int price, String title, Date publishDate) {
		this.author = author;
		this.price = price;
		this.title = title;
		this.publishDate = publishDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return author+"\t"+price+"\t"+title+"\t"+DateTimeService.getDateTime(DateTimeService.DATE_ONLY, publishDate);
	}
}
