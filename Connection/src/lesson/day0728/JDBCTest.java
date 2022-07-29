package lesson.day0728;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {
	JDBCTest test = new JDBCTest();


public void connectMaria() throws ClassNotFoundException, SQLException {
	String driver ="org.mariadb.jdbc.Driver";
	String JdbcURL = "jdbc:mariadb://127.0.0.1:3306/sqlcook";
	String id = "voyager";
	String pwd = "1234";
	
	Class.forName(driver);
	Connection con = DriverManager.getConnection(JdbcURL, id, pwd);
	if(con != null) {
		System.out.println("connected");
	}
	
	}
}