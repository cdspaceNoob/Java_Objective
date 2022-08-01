package lesson.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GisaDAO {
	
	public int select(String q) throws SQLException {
		int result = 0;
		Connection con = ConnectionManager.getConnection();
		PreparedStatement statement = con.prepareStatement(q);
		ResultSet rs = statement.executeQuery();
		if(rs.next()) {
			result = rs.getInt(1);
		}
		rs.close();
		statement.close();
		return result;
	}
	
	
	
	
	
	
	/* 개별 객체를 받을 때 insert 방식 */
    public boolean InsertData(StudentVO vo) throws SQLException {
    	boolean flag = false;
    	//String[] temp = data.split(",");
    	
    	String sql = "insert into gisa values("+vo.getStdNo()+", "+vo.getEmail()+", "+vo.getKor()+", "+vo.getMath()+ ","+vo.getEng()
    				+","+vo.getSci()+","+vo.getHist()+","+vo.getMgrCode()+","+vo.getAccCode()+","+vo.getLocCode()+");";
    	Connection con = ConnectionManager.getConnection();  
    	Statement stmt = con.createStatement(); 
    	int affectedCount = stmt.executeUpdate(sql);
    	
    	con.close();
    	
    	if(affectedCount > 0) {
    		flag = true;
    	}
    	return flag;
    }/* end InsertData */
    
    /* 객체 리스트를 받을 때 insert 방식 */
    public boolean InsertData(ArrayList<StudentVO> list) throws SQLException {
    	boolean flag = false;
    	int affectedCount = 0;

    	/* 문 열기 */
    	Connection con = ConnectionManager.getConnection();
    	
    	/* 길 닦기 */
    	// 여러 개의 데이터를 반복문으로 넣을 때는 반복문 안에서 길을 닦아주자 

    	/* 통로 미리 명시하기 */
    	Statement stmt = null;
    	/* 쿼리 던지기 */
    	for(StudentVO vo : list) {
    		String sql = "insert into gisa values (" + vo.getStdNo() + "," + vo.getEmail() + "," + vo.getKor() + "," + vo.getMath() + "," +vo.getEng() + "," +
    	vo.getSci() + "," +vo.getHist() + "," + vo.getTotal() + "," + vo.getMgrCode() + "," + vo.getAccCode() + "," + vo.getLocCode()+");";
    	/* 길 닦기 */
    	// 위에서 명시한 길바닥 사용해서 보낸다 
    	stmt = con.createStatement();
    	// 길바닥에서 파라미터의 쿼리 실행
    	affectedCount += stmt.executeUpdate(sql);
    	}
    	
    	/* 문 닫기 */
    	stmt.close();
    	con.close();
    	
    	/* 결과 보고 */
    	if(affectedCount>0) {
    		flag = true;
    	}
    	
    	/* return */
    	return flag;
    }
    
    
    public boolean DeleteData(int stdNo) throws SQLException {
    	boolean flag = false;
    	
    	/* 던질 쿼리 작성 */
    	String sql = "delete from gisa where std_no ="+stdNo+";";
    	
    	/* 문 열기 */
    	Connection con = ConnectionManager.getConnection();
    	
    	/* 길 닦기 */
    	Statement stmt = con.createStatement();
    	
    	/* 작성해둔 쿼리 던지기 */
    	int affectedCount = stmt.executeUpdate(sql);
    	
    	/* 결과 확인 */
    	if (affectedCount > 0){
    		flag = true;
    	}
    	
    	/* 문 닫기 */
    	// 후에 열린 것부터 닫아준다 
    	stmt.close();
    	con.close();
    	
    	return flag;
    }/* end DeleteData */
    
    
    public boolean DeleteData() throws SQLException {
    	boolean flag = false;
    	
    	/* 던질 쿼리 작성 */
    	String sql = "delete from gisa";
    	
    	/* 문 열기 */
    	Connection con = ConnectionManager.getConnection();
    	
    	/* 길 닦기 */
    	Statement stmt = con.createStatement();
    	
    	/* 작성해둔 쿼리 던지기 */
    	int affectedCount = stmt.executeUpdate(sql);
    	
    	/* 결과 확인 */
    	if (affectedCount > 0){
    		flag = true;
    	}
    	
    	/* 문 닫기 */
    	// 후에 열린 것부터 닫아준다 
    	stmt.close();
    	con.close();
    	
    	return flag;
    }/* end DeleteAll */
    
    
}/* end of this class */
