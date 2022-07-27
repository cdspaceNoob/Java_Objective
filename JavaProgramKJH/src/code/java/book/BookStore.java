package code.java.book;

import java.util.ArrayList;
import java.util.Date;

public class BookStore {
	private ArrayList<Book> bookshelf;
	
	public BookStore() {
		bookshelf = new ArrayList<Book>();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookStore bs = new BookStore();
		bs.readyBooks();
		ArrayList<Book> result = bs.findBooks(0);
		//bs.displayBooks(result);
		result = bs.findBooks("");
		//bs.displayBooks(result);
	}
	
	public void readyBooks() {
		bookshelf.add(new Book("신용권",27000,"혼공 자바",new Date(2022-1900,6,1)));
		this.displayBooks(bookshelf);
	}
	
	public void displayBooks(ArrayList<Book> bookshelf) {
		for(Book book : bookshelf) {
			System.out.println(book);
		}
	}
	
	public ArrayList<Book> findBooks(String title){
		ArrayList<Book> books = null;
		
		
		return books;
	}
	
	public ArrayList<Book> findBooks(int price){
		ArrayList<Book> books = null;
		
		
		return books;
	}

}
