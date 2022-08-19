package lib.service.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	public static Connection getConnection() {
		Connection con = null;
		String driver	="org.mariadb.jdbc.Driver";
		String url		="jdbc:mariadb://127.0.0.1:3306/test";
		String id		="voyager";
		String pw		="1234";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}//getConnection()

}
