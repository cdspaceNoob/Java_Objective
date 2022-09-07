package gntp.lesson.board.vo;

public class BoardVO {
	private int seq;
	private int write_seq;
	private String current_seq;
	private String title;
	private String content;
	private int read_count;
	private String next_seq;
	private String write_date;
	private String user_id;
	
	public BoardVO() {
		
	}

	public BoardVO(int seq, int write_seq, String current_seq, String title, String content, int read_count,
			String next_seq, String write_date, String user_id) {
		super();
		this.seq = seq;
		this.write_seq = write_seq;
		this.current_seq = current_seq;
		this.title = title;
		this.content = content;
		this.read_count = read_count;
		this.next_seq = next_seq;
		this.write_date = write_date;
		this.user_id = user_id;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getWrite_seq() {
		return write_seq;
	}

	public void setWrite_seq(int write_seq) {
		this.write_seq = write_seq;
	}

	public String getCurrent_seq() {
		return current_seq;
	}

	public void setCurrent_seq(String current_seq) {
		this.current_seq = current_seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRead_count() {
		return read_count;
	}

	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}

	public String getNext_seq() {
		return next_seq;
	}

	public void setNext_seq(String next_seq) {
		this.next_seq = next_seq;
	}

	public String getWrite_date() {
		return write_date;
	}

	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
}
