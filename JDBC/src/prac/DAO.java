package prac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {

	// 테이블 생성 
	public boolean createTable() throws SQLException {
		boolean flag = false;
		
		String sql = "create table toys (";
				sql+= "No int auto_increment primary key not null, ";
				sql+= "name varchar(20) not null, ";
				sql+= "manufacturing varchar(20) not null, ";
				sql+= "price int not null ";
				sql+= ")";
				
		Connection con = ConnectionManager.getConnection();
		Statement stmt = con.createStatement();
		int affectedCount = stmt.executeUpdate(sql);
		
		System.out.println("쿼리의 반환값은 :"+affectedCount);
		
		if(affectedCount == 0) {
			flag = true;
		}
		
		stmt.close();
		con.close();
		
		return flag;
	}//createTable()
	
	
	// Toy 테이블에 레고드 insert
	public boolean insertToy(String name, String manufacturing, int price) throws SQLException {
		boolean flag = false;
		
		String sql = "insert into toys (name, manufacturing, price) ";
				sql+= "values(";
				sql+= "?, ";
				sql+= "?, ";
				sql+= "? ";
				sql+= ");";
				
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, name);
		pstmt.setString(2, manufacturing);
		pstmt.setInt(3, price);
		
		int affectedCount = pstmt.executeUpdate();
		
		if(affectedCount > 0) {
			flag = true;
		}
		
		pstmt.close();
		con.close();
		
		return flag;
	}//insertToy()
	
}
