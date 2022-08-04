package proto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	public static Connection getStConnection() {
		Connection con = null;
		String driver = "org.mariadb.jdbc.Driver";
		String jdbcURL = "jdbc:mariadb://127.0.0.1:3306/test";
		String id = "voyager";
		String pwd = "1234";
		
		try {
			Class.forName(driver);
			try {
				con = DriverManager.getConnection(jdbcURL, id, pwd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;	
	}//getStConnection()
	
	public static Connection getBookConnection() {
		Connection con = null;
		String driver = "org.mariadb.jdbc.Driver";
		String jdbcURL = "jdbc:mariadb://127.0.0.1:3306/test";
		String id = "voyager";
		String pwd = "1234";
		
		try {
			Class.forName(driver);
			try {
				con = DriverManager.getConnection(jdbcURL, id, pwd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;	
	}
	
}
