package lesson.day0802.free;

public class JdbcMain {
	public static void main(String[] args) {
		JdbcMain main = new JdbcMain();
		main.callService03();
		main.callService01();
	}/* end Main */
	
	
	public void callService03() {
		Service serv = new Service();
		serv.solution03();
	}
	
	
	
	public void callService01() {
		Service serv = new Service();
		serv.solution01();
	}






}/* end JdbcMain*/
