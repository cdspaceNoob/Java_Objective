package lesson.gntp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	public static Connection getConnection() {
		Connection con = null;
		String driver = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://127.0.0.1:3306/sample";
		String id = "voyager";
		String pwd = "1234";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,id,pwd);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void closeConnection() {
		
	}
}
