package guest.pack.vo;

public class GuestbookVO {
	
	/* field */
	private int 	seq;
	private String 	user_id;
	private String 	title;
	private String 	content;
	private String 	dateTime;
	private int 	read_count;
	
	/* constructor */
	public GuestbookVO() {
		
	}
	
	public GuestbookVO(int seq, String user_id, String title, String content, String dateTime, int read_count) {
		this.seq 		= seq;
		this.user_id 	= user_id;
		this.title 		= title;
		this.content	= content;
		this.dateTime 	= dateTime;
		this.read_count = read_count;
	}
	
	/* getter setter */
	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public int getRead_count() {
		return read_count;
	}
	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}/* end of getter setter */
	
	
}
