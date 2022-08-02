package lesson.day0802;

public class DatabaseMain {
	public static void main(String[] args) {
		DatabaseMain db = new DatabaseMain();
		
		/* 받아온 솔루션 실행 */
		db.solve01();
	}/* main */
	
	/* 비즈니스 로직 클래스에서 솔루션 받아오기 */
	public void solve01() {
		GisaSolutionService gss = new GisaSolutionService();
		gss.solveQuiz01();
	}
}
