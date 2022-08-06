package prac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	public static Connection getConnection() {
		Connection con = null;
		String driver = "org.mariadb.jdbc.Driver";
		String jdbcURL = "jdbc:mariadb://127.0.0.1:3306/jdbc";
		String id = "voyager";
		String pwd = "1234";
		
		try {
			Class.forName(driver);
			try {
				con = DriverManager.getConnection(jdbcURL, id, pwd);
				System.out.println("Connected...");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Connection Failed");
				e.printStackTrace();	// 예외 발생 시 내용 출력 
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection Failed. Check Driver or URL");
			e.printStackTrace();		// 예외 발생 시 내용 출력
		}
		
		return con;	
	}//getConnection()
	
}