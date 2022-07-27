package code.java.book;

import java.util.ArrayList;
import java.util.Date;

public class Book {
	/* field */
	private String author;
	private String title;
	private int price;
	//private Date publishDate;
	
	/* 필드값은 모두 생성자에서 구체적으로 초기화한다 */
	
	/* constructor */
	private Book(String author, String title, int price) {
		this.author = author;
		this.title = title;
		this.price =  price;
		//this.publishDate = publishDate;
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
	
	
	/* 열 권의 책을 정리한다 */
	public ArrayList readyBooks() {
		ArrayList bookList = new ArrayList();
		bookList.add(new Book("박경리", "토지", 150001)); 
		bookList.add(new Book("최명희", "혼불", 150002));
		bookList.add(new Book("생 텍쥐베리", "어린 왕자", 150003));
		bookList.add(new Book("누군가", "부의 추월 차선", 150004));
		bookList.add(new Book("데일 카네기", "카네기 인간 관계론", 150005));
		bookList.add(new Book("작가", "사피엔스", 150006));
		bookList.add(new Book("베르베르", "뇌", 150007));
		bookList.add(new Book("일본인", "왜 일하는가", 150008));
		bookList.add(new Book("김 훈", "칼의 노래", 150009));
		bookList.add(new Book("무라카미 하루키", "상실의 시대", 150010));
		return bookList;
	}
	
	
	/* 한 줄에 한 권의 모든 정보를 출력 / 각 정보는 일정한 간격: (\n)으로 하기 */
	public void displayBooks() {
		ArrayList bookList = this.readyBooks();
		for(int i = 0; i < bookList.size(); i++) {
			bookList.get(i).toString();
		}
	}
	
	/*? toString(), hashCode(), equals()를 반드시 오버라이드? 오버라이드 해야 하는 경우 ?*/
	@Override
	public String toString() {
		
		//getClass().getName() + '@' + Integer.toHexString(hashCode())
		return null;
	}
	
	
	public Book findBooks(String title, int price) {
		return null;
	}
	
	

}
