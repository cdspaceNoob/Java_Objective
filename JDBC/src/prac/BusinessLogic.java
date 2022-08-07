package prac;

import java.sql.SQLException;

public class BusinessLogic {
	
	// 테이블 생성하기(고정 / statement 사용) 
	public boolean createTable() throws SQLException {
		boolean flag = false;
		DAO dao = new DAO();
		flag = dao.createTable();
		return flag;
	}//createTable
	
	// 데이터 입력하기(PreparedStatement 사용) 
	public boolean insertToy(String name, String manufacturing, int price) throws SQLException {
		boolean flag = false;
		DAO dao = new DAO();
		flag = dao.insertToy(name, manufacturing, price);
		return flag;
	}
}
