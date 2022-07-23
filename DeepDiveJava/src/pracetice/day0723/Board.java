package pracetice.day0723;

public class Board {
	/* field */
	String subject;
	String content;
	String writer;
	
	/* constructor */
	public Board(String subject, String content, String writer) {
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}
	
	public String getSub() {
		return this.subject;
	}
}
