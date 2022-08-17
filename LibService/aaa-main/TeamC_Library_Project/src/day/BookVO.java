package day;

public class BookVO {
	/* fields */
	private int book_no;
    private String book_name;
    private String writer;
    private int price;
    private String pay_date;	// 구매일 
    private int rsvs_people;	// 예약 인원 
    private String loan_yn;		// 대여 가능 여부 
    
    /* constructor */
    public BookVO() {	
    }
    
    /* constructor: To Database */
    public BookVO(int book_no,String book_name,String writer,int price,String pay_date,int rsvs_people,String loan_yn) {
    	this.book_no = book_no;
    	this.book_name = book_name;
    	this.writer = writer;
    	this.price = price;
    	this.pay_date = pay_date;
    	this.rsvs_people = rsvs_people;
    	this.loan_yn = loan_yn;
    }
    
    /* constructor: From File */
    public BookVO(String data) {
    	String[] temp = data.split(",");
    	this.book_no = Integer.parseInt(temp[0].trim());
    	this.book_name = temp[1].trim();
    	this.writer = temp[2].trim();
    	this.price = Integer.parseInt(temp[3].trim());
    	this.pay_date = temp[4].trim();
    	this.rsvs_people = Integer.parseInt(temp[5].trim());
    	this.loan_yn = temp[6].trim();
    }
    
    
    /* GETTER SETTER */
	public int getBook_no() {
		return book_no;
	}

	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPay_date() {
		return pay_date;
	}

	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}

	public int getRsvs_people() {
		return rsvs_people;
	}

	public void setRsvs_people(int rsrv_people) {
		this.rsvs_people = rsrv_people;
	}

	public String getLoan_yn() {
		return loan_yn;
	}

	public void setLoan_yn(String loan_yn) {
		this.loan_yn = loan_yn;
	}
}
