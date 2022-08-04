package proto;

public class BookVO {
	/* field */
	private int bookNo;
	private String title;
	private String author;
	private int price;
	private String inDate;
	
	/* constructor */
	public BookVO(String data){
		String[] temp = data.split(",");
		bookNo = Integer.parseInt(temp[0].trim());
		title = temp[1].trim();
		author = temp[2].trim();
		price = Integer.parseInt(temp[3].trim());
		inDate = temp[4].trim();
	}

	public int getbookNo() {
		return bookNo;
	}

	public void setbookNo(int number) {
		this.bookNo = number;
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
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getinDate() {
		return inDate;
	}

	public void setinDate(String buyDate) {
		this.inDate = buyDate;
	}/* getter setter */
	
	
	
}
