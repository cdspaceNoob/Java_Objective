package prac;

import java.sql.SQLException;

public class JdbcMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JdbcMain main = new JdbcMain();
		
		//main.createTable();
		main.insertToy("watergun", "LockheedMatin", 1500000);
	}//main();

	
	// 테이블 생성하기 
	public void createTable() {
		BusinessLogic bl = new BusinessLogic();
		try {
			boolean flag = bl.createTable();
			if(flag) {
				System.out.println("테이블 생성에 성공했습니다");
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("테이블 생성에 실패했습니다");
			e.printStackTrace();
		}
	}// getTable();
	
	
	// 레코드 입력하기 
	public void insertToy(String name, String manufacturing, int price) {
		BusinessLogic bl = new BusinessLogic();
		try {
			boolean flag = bl.insertToy(name, manufacturing, price);
			if(flag) {
				System.out.println("레코드 삽입에 성공했습니다");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("레코드 삽입에 실패했습니다");
			e.printStackTrace();
		}
	}// insertToy();
	
	
}
