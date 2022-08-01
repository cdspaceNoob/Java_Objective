package repeat.code01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class GisaDAO {
	
	
	public boolean insertData(ArrayList<StudentVO> list) throws SQLException {
		boolean flag = false;
	
		//connection
		Connection con = ConnectionManager.getConnection();
		
		//Query: 여기서 '?'는 placeHolder(ToBeDetermined) 
		String sql = "insert into gisa values(?,?,?,?,?,?,?,?,?,?,?)";
		
		//PreparedStatement 사용하는 이유는? -> 쿼리가 준비 되었다(특정한 쿼리만 적용되는 통로)
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		//StudentVO vo = null;
		int affectedCount = 0;
		
		for(StudentVO vo : list) {
		//placeHolder에 넣을 값들을 정해준다 
			vo = list.get(0);
			pstmt.setInt(0, vo.getStdNo());
			pstmt.setString(1, vo.getEmail());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getMath());
			pstmt.setInt(4, vo.getEng());
			pstmt.setInt(5, vo.getSci());
			pstmt.setInt(6, vo.getHist());
			pstmt.setInt(7, vo.getTotal());
			pstmt.setString(8, vo.getMgrCode());
			pstmt.setString(9, vo.getAccCode());
			pstmt.setString(10, vo.getLocCode());
			affectedCount = pstmt.executeUpdate();
		}//end for
		
		if(affectedCount > 0) {
			flag = true;
		}
		
		pstmt.close();
		con.close();
		
		return flag;
	}
	
	
	
	
}
