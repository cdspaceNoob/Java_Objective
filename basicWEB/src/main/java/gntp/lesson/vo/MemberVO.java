package gntp.lesson.vo;

import java.sql.Timestamp;

public class MemberVO {
	/* fields */
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Timestamp joinDate;
	
	/* constructor */
	public MemberVO(String id, String pwd, String name, String email, Timestamp joinDate) {
		this.id 		= id;
		this.pwd 		= pwd;
		this.name 		= name;
		this.email 		= email;
		this.joinDate	= joinDate;
	}
	
	/* getter setter */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}// getter setter
	
	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s, %s", id, pwd, name, email, joinDate);
	}
}
