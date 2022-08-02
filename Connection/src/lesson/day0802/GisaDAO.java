package lesson.day0802;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GisaDAO {
	/* 비즈니스 클래스에서 요청받은 데이터 조회 및 결과셋 반환 */
	
	
	
	
	/* 첫 번째 문제에 대해 요청 받은 데이터 조회 및 결과셋 반환 */
	//public ArrayList<StudentVO> selectQuiz01Data() throws SQLException{	
	public ArrayList<StudentVO> selectQuiz01Data(String code) throws SQLException{	
		// 0. Prepared 사용을 위한 sql 작성
		String sql = "select * from gisa where loccode = ?";
		ArrayList list = new ArrayList<StudentVO>();
		
		// 1. Connection 
		Connection con = ConnectionManager.getConnection();
		
		// 2. Connection내 통로 생성 
		PreparedStatement pstmt = con.prepareStatement(sql);
		//pstmt.setString(1, "b");
		pstmt.setString(1, code);
		
		// 3. Connection내 생성된 통로를 통해 query 전송 및 결과셋 받아오기  
		ResultSet rs = pstmt.executeQuery();
		
		// 4. 받은 결과셋 ArrayList에 정리 
		StudentVO vo = null;
		while(rs.next()) {
			// 생성자 호출하여 객체 생성 
			vo = new StudentVO(rs.getInt(1), rs.getString(2), rs.getInt(3),
					rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7),
					rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11));
			
			// 생성한 객체를 ArrayList<StudentVO>에 저장 
			list.add(vo);
		}
		// 5. 절차 종료 후 커넥션 닫기 
		rs.close();
		pstmt.close();
		con.close();
		
		return list;
	}/* selectQuiz01Data */





}/* end */
