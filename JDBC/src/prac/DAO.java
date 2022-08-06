package prac;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {

	public boolean createTable() throws SQLException {
		boolean flag = false;
		
		String sql = "create table toys (";
				sql+= "No int primary key not null, ";
				sql+= "name varchar(20) not null, ";
				sql+= "manufacturing varchar(20) not null, ";
				sql+= "price int not null ";
				sql+= ")";
				
		Connection con = ConnectionManager.getConnection();
		Statement stmt = con.createStatement();
		int affectedCount = stmt.executeUpdate(sql);
		
		System.out.println("쿼리의 반환값은 :"+affectedCount);
		
		if(affectedCount == -1) {
			flag = true;
		}
		
		return flag;
	}
}
