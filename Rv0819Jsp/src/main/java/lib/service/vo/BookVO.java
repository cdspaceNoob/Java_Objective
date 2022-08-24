package lib.service.vo;

public class BookVO {
	/* fields */
	private int bookNo;
	private String title;
	private String author;
	private int price;
	private String date;
	
	/* constructor */
	public BookVO(int bookNo, String title, String author, int price, String date) {
		this.bookNo = bookNo;
		this.title 	= title;
		this.author = author;
		this.price 	= price;
		this.date 	= date;
	}
	
	
	/* getter and setter */
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
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
	public int getPrice() {
		return this.price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}//getter and setter 
	
	@Override
	public String toString() {
		return String.format("%s %s %s %s %s", bookNo, title, author, price, date);
	}
	
	
} 
