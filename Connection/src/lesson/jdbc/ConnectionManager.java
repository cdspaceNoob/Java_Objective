package lesson.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	
	public static Connection getConnection() {
		Connection con= null;
		String driver = "org.mariadb.jdbc.Driver";
		String jdbcURL = "jdbc:mariadb://127.0.0.1:3306/sample";
		String id = "voyager";
		String pwd = "1234";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(jdbcURL,id,pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}/* end getConnection() */

}
