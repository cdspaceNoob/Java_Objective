package proto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListDAO {
	
	// 도서 대출 
	public boolean insertList(int stdNo, int bookNo) throws SQLException {
		boolean flag = false;
		
		Connection con = ConnectionManager.getConnection();
		
		// 1. 장부에 기록하기 
		String sql = "insert into list(stdNo, bookNo, dateOut, dateIn, datecheck) values(?, ?, now(), date_add(now(), interval 7 day), NULL);";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, stdNo);
		pstmt.setInt(2, bookNo);
		
		int affectedCount = 0;
		
		affectedCount = pstmt.executeUpdate();
		
		if(affectedCount > 0) {
			flag = true;
		}
		
		pstmt.close();
		con.close();
		
		return flag;
	}
	
	//0) 현재 대출중인 책의 정보, 대출자, 반납일, 연체여부에 대한 정보를 제공
	public ArrayList<ListDAO> getData00(){
		String sql = "";
		return null;
	}
	
	//1) 대출 도서 상위 5위에 대한 정보
	public ArrayList<ListDAO> getData01(){
		String sql = "";
		return null;
	}
	
	//2) 대출자 상위 5위에 대한 정보
	public ArrayList<ListDAO> getData02(){
		String sql = "";
		return null;
	}
	
	//3) 대출기간이 가장 짧은 도서에 대한 정보
	public ArrayList<ListDAO> getData03(){
		String sql = "";
		return null;
	}
	
	//4) 대출반납이 가장 빠른 학생에 대한 정보
	public ArrayList<ListDAO> getData04(){
		String sql = "";
		return null;
	}
	
	//5) 대출을 가장 많이 하는 학과에 대한 정보
	public ArrayList<ListDAO> getData05(){
		String sql = "";
		return null;
	}
	
	//6) 대출반납이 가장 늦은 학과에 대한 정보
	public ArrayList<ListDAO> getData06(){
		String sql = "";
		return null;
	}
	
}
