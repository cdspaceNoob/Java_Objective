package repeat.code01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	public static Connection getConnection() {
		Connection con = null;
		String driver = "org.mariadb.jdbc.Driver";
		String jdbcURL = "jdbc:mariadb://127.0.0.1:3306/sample";
		String id = "voyager";
		String pwd = "1234";
		
		/* 클래스 로더를 통해 드라이버(클래스)를 호출한다 */
		//Class.forName(driver); 예외 발생하므로 아래에서 처리(ClassNotFoundException) 
		
		try {
			Class.forName(driver);
			/* DriverManager를 통해 Connection 획득 */
			con = DriverManager.getConnection(jdbcURL, id, pwd);
			// 예외 발생하므로 아래에서 처리(SQLException)
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
