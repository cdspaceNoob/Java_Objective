package mvc.prac.vo;

public class BookVO {

	private int book_seq;
	private String book_title;
	private String book_author;
	private int book_price;
	private String book_image;
	private String book_attachment;
	
	/* Constructor */
	public BookVO() {
		
	}

	/* Constructor */
	public BookVO(int book_seq, String book_title, String book_author, int book_price, String book_image,
			String book_attachment) {
		super();
		this.book_seq 		 = book_seq;
		this.book_title 	 = book_title;
		this.book_author 	 = book_author;
		this.book_price 	 = book_price;
		this.book_image 	 = book_image;
		this.book_attachment = book_attachment;
	}

	/* getter setter */
	public int getBook_seq() {
		return book_seq;
	}

	public void setBook_seq(int book_seq) {
		this.book_seq = book_seq;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public int getBook_price() {
		return book_price;
	}

	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}

	public String getBook_image() {
		return book_image;
	}

	public void setBook_image(String book_image) {
		this.book_image = book_image;
	}

	public String getBook_attachment() {
		return book_attachment;
	}

	public void setBook_attachment(String book_attachment) {
		this.book_attachment = book_attachment;
	}
	
}/* END OF BookVO */
