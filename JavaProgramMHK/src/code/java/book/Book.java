package code.java.book;

import java.util.ArrayList;
//import java.util.Date;
/* date 형식의 데이터 입력할 줄 모름! */

public class Book {
	
	/* field */
	private String author;
	private String title;
	private int price;
	//private Date publishDate;
	/* date 형식의 데이터 입력할 줄 모름! */
	
	/* 필드값은 모두 생성자에서 구체적으로 초기화한다 */
	/* constructor */
	Book(String author, String title, int price) {
		this.author = author;
		this.title = title;
		this.price =  price;
		//this.publishDate = publishDate;
		/* date 형식의 데이터 입력할 줄 모름! */
	}
	
	
	/* method */
	
	
	/* getter */
	public String getAuthor() {
		return this.author;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	
	
	
	

}
