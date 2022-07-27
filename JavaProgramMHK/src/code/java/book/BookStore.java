package code.java.book;

import java.util.ArrayList;

public class BookStore {
	
	private ArrayList<Book> Books;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/* 열 권의 책을 정리한다 */
	public ArrayList readyBooks() {
		this.Books = new ArrayList();
		Books.add(new Book("박경리", "토지", 150001)); 
		Books.add(new Book("최명희", "혼불", 150002));
		Books.add(new Book("생 텍쥐베리", "어린 왕자", 150003));
		Books.add(new Book("누군가", "부의 추월 차선", 150004));
		Books.add(new Book("데일 카네기", "카네기 인간 관계론", 150005));
		Books.add(new Book("작가", "사피엔스", 150006));
		Books.add(new Book("베르베르", "뇌", 150007));
		Books.add(new Book("일본인", "왜 일하는가", 150008));
		Books.add(new Book("김 훈", "칼의 노래", 150009));
		Books.add(new Book("무라카미 하루키", "상실의 시대", 150010));
		return Books;
	}
	
	
	/* 한 줄에 한 권의 모든 정보를 출력 / 각 정보는 일정한 간격 */
	public void displayBooks() {
		ArrayList bookList = this.readyBooks();
		for(int i = 0; i < bookList.size(); i++) {
			bookList.get(i).toString();
			System.out.println();
		}
	}
	
	/*? toString(), hashCode(), equals()를 반드시 오버라이드? 오버라이드 해야 하는 경우 ?*/
	@Override
	public String toString() {
		/*! 참고: toString() @Override !*/
		//getClass().getName() + '@' + Integer.toHexString(hashCode())
		//return "[author: "+this.author+" / "+"title: "+this.title+" / "+"price: "+this.price+"]";
	}
	
	
	public Book findBooks(String title, int price) {
		
		return null;
	}

}
