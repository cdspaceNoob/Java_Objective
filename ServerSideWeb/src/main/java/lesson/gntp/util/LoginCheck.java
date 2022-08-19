package lesson.gntp.util;

public class LoginCheck {
	// 여기에 메소드 작성 
	// 메소드 내용: id 및 pw 받아서 boolean 값을 return 
	// 메소드 이름: isMember
	
	private String id;
	private String pw;
	
	public boolean isMemeberCustom(String id, String pw) {
		boolean flag = false;
		if(this.id.equals(id) && this.pw.equals(pw)) {
			flag = true;
		}
		return flag;
	}//isMember()
	
	public boolean isMemeber(String id, String pw) {
		boolean flag = false;
		if(id.equals("user01") && pw.equals("2345")) {
			flag = true;
		}
		return flag;
	}
	
	

}
