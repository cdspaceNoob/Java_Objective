package practie.day0725;

public class Stadium {

	/* field */
	private int[] comNumber;
	
	public static void main(String[] args) {
		/* 스타디움 객체 생성 */
		/* 스타디움 객체가 게임을 시작 */
		/* 로직 클래스 객체 생성 및 메서드 호출 */
		Stadium st = new Stadium();
		Com com = new Com();
		com.makeComNumber();
		st.comNumber = com.getComNumber();
	}
	
	/* method */
	
	

}
