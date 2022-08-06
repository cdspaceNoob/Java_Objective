package prac;

import java.sql.SQLException;

public class JdbcMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JdbcMain main = new JdbcMain();
		main.getTable();
	}//main

	
	
	public void getTable() {
		DAO dao = new DAO();
		try {
			dao.createTable();
			System.out.println("테이블 생성에 성공했습니다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("테이블 생성에 실패했습니다");
			e.printStackTrace();
		}
	}// getTable()
}
