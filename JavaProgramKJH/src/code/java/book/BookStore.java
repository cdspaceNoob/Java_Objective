package code.java.book;

import java.util.ArrayList;
import java.util.Date;

public class BookStore {
	
	/* field */
	private ArrayList<Book> bookshelf;
	
	/* constructor */
	public BookStore() {
		bookshelf = new ArrayList<Book>();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookStore bs = new BookStore();
		bs.readyBooks();
		ArrayList<Book> result = bs.findBooks(0);
		//bs.displayBooks(result);
		result = bs.findBooks("노인과 바다");
		result = bs.findBooks(1057000);
		//bs.displayBooks(result);
	}/* end main */
	
	
	/* method */
	public void readyBooks() {
		bookshelf.add(new Book("신용권",27000,"혼공 자바",new Date(2022-1900,6,1)));
		bookshelf.add(new Book("헤밍웨이",37000,"노인과 바다",new Date(2022-1900,6,2)));
		bookshelf.add(new Book("옮긴이",27500,"누가 내 치즈를 옮겼을까",new Date(2022-1900,6,3)));
		bookshelf.add(new Book("김 훈",47000,"칼의 노래",new Date(2022-1900,6,4)));
		bookshelf.add(new Book("베르베르",27900,"파피용",new Date(2022-1900,6,5)));
		bookshelf.add(new Book("에리히 프롬",107000,"사랑의 기술",new Date(2022-1900,6,6)));
		bookshelf.add(new Book("생 텍쥐베리",1057000,"어린 왕자",new Date(2022-1900,6,7)));
		bookshelf.add(new Book("지은이",27050,"60일 간의 세계 일주",new Date(2022-1900,6,8)));
		bookshelf.add(new Book("귀도 반 로섬",127000,"파이썬",new Date(2022-1900,6,9)));
		bookshelf.add(new Book("제임스 고슬링",7727000,"자 바",new Date(2022-1900,6,10)));
		this.displayBooks(bookshelf);
	}/* end readyBooks */
	
	
	public void displayBooks(ArrayList<Book> bookshelf) {
		for(Book book : bookshelf) {
			System.out.println(book);
		}
		System.out.println();
	}/* end displayBooks */
	
	
	public ArrayList<Book> findBooks(String title){
		ArrayList<Book> books = bookshelf;
		for(Book book : books) {
			if(book.getTitle()==title) {
				System.out.println("제목으로 찾은 결과입니다: "+book);
			}
		}
		return books;
	}/* end findBooks by title */
	
	
	public ArrayList<Book> findBooks(int price){
		ArrayList<Book> books = bookshelf;
		for(Book book : books) {
			if(book.getPrice()==price) {
				System.out.println("가격으로 찾은 결과입니다: "+book);
			}
		}
		return books;
	}/* end findBooks by price */

}
