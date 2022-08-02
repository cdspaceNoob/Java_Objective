package lesson.day0802;
import java.util.Date;
public class DatabaseMain {
	//private GisaDAO dao = null;
	
	//public DatabaseMain(GisaDAO dao) {
	//	this.dao = dao;
	//}
	
	public static void main(String[] args) {
		DatabaseMain db = new DatabaseMain();
		
		/* 받아온 솔루션 실행 */
		db.solve04();
		db.solve03();
		db.solve02();
		db.solve01();
	}/* main */
	
	/* Date type */
	public void Date() {
		Date date = new Date(System.currentTimeMillis());
		
	}
	
	/* 비즈니스 로직 클래스에서 솔루션 받아오기 */
	public void solve04() {
		GisaSolutionService gss = new GisaSolutionService();
		gss.solveQuiz04();	
	}
	
	public void solve03() {
		GisaSolutionService gss = new GisaSolutionService();
		gss.solveQuiz03();	
	}
	
	
	public void solve02() {
		GisaSolutionService gss = new GisaSolutionService();
		gss.solveQuiz02();
	}
	
	
	public void solve01() {
		GisaSolutionService gss = new GisaSolutionService();
		//gss.solveQuiz01();
		gss.solveQuiz01V2();
	}
}
