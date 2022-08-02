package lesson.day0802;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	public static Connection getConnection(){
		String driver = "org.mariadb.jdbc.Driver";
		String jdbcURL = "jdbc:mariadb://127.0.0.1:3306/sample";
		String id = "voyager";
		String pwd = "1234";
		Connection con = null;
		
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
	}/* getConnection() */
}
