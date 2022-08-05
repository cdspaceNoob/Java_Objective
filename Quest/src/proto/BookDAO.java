package proto;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookDAO {
		public boolean insertBookData(ArrayList<BookVO> list) throws SQLException {
			boolean flag = false;
			int affectedCount = 0;
			Connection con = ConnectionManager.getConnection();
			Statement stmt = null;
			
			for(BookVO vo : list) {
				String sql = "insert into book values ("+vo.getbookNo()+",'"+vo.getTitle()+"', '"+vo.getAuthor()+"',"+vo.getPrice()+",'"+vo.getinDate()+"'"+");";
				stmt = con.createStatement();
				affectedCount = stmt.executeUpdate(sql);
			}
			
			stmt.close();
			con.close();
	
			if(affectedCount > 0) {
				flag = true;
			}
			return flag;
		}// insertBookData()

		//0) 현재 대출중인 책의 정보, 대출자, 반납일, 연체여부에 대한 정보를 제공
		public ArrayList<BookDAO> getData00(){
			String sql = "";
			return null;
		}
		
		//1) 대출 도서 상위 5위에 대한 정보
		public ArrayList<BookDAO> getData01(){
			String sql = "";
			return null;
		}
		
		//2) 대출자 상위 5위에 대한 정보
		public ArrayList<BookDAO> getData02(){
			String sql = "";
			return null;
		}
		
		//3) 대출기간이 가장 짧은 도서에 대한 정보
		public ArrayList<BookDAO> getData03(){
			String sql = "";
			return null;
		}
		
		//4) 대출반납이 가장 빠른 학생에 대한 정보
		public ArrayList<BookDAO> getData04(){
			String sql = "";
			return null;
		}
		
		//5) 대출을 가장 많이 하는 학과에 대한 정보
		public ArrayList<BookDAO> getData05(){
			String sql = "";
			return null;
		}
		
		//6) 대출반납이 가장 늦은 학과에 대한 정보
		public ArrayList<BookDAO> getData06(){
			String sql = "";
			return null;
		}
	
	
}
