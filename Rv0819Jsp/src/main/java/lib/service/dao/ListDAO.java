
package lib.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lib.service.util.ConnectionManager;

public class ListDAO {
	BookDAO bdao = new BookDAO();

	//책 대여 대출 
	public void transactionBorrow(String title, String StdNo) {

			BookDAO bdao = new BookDAO();
			
			try {
				// 해당 도서를 보유 중인지 
				boolean inShelf = bdao.isInShelf(title);
				System.out.println("inShelf is: "+inShelf);
				if (inShelf == true) {
					boolean isModified = modifyInShelfN(title);
					if(isModified == true) {
						System.out.println("정상 대출 되었습니다.");
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 대여하려는 학생이 5권 이상 대여했는지
			
			// 조건 맞으면 
			// 책 객체의 보유 여부 속성값을 N으로 바꾸기 

					
				// 책 객체의 대여 일자 속성값을 set now()로
				// 선수 작업: 리스트 객체에 책 객체의 대여 일자 속성을 FK로 추가 
				
				// 책 객체의 반납 예정 일자 속성값을 set now()+7로
				// 선수 작업: 리스트 객체에 책 객체의 반납 예정 일자 속성을 FK로 추가  
				
				// 속성 추가: 실제 반납된 일자 
	}
			

	
	// 도서 객체 내용 변경: 도서 대출 또는 대여 가능 여부 변경(Y:가능 N:불가능)  
	public boolean modifyInShelfN(String title) throws SQLException {
		boolean flag = false;
		String sqlToN = "update book set inshelf = 'N' where title=?;";
		String yn = null;
		
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		pstmt = con.prepareStatement(sqlToN);
		pstmt.setString(1, title);		
		
		ResultSet rs = pstmt.executeQuery();
		// 도서를 보유 중이라면 InShelf 속성 변경(도서관 밖으로 나가는 거니까 N으로) 
			while(rs.next()) {
				yn = rs.getString("inshelf");
				if(yn=="N") {
					flag = true;
					System.out.println(title+"의 inshelf 속성이 N으로 변경되었습니다.");
					return flag;
				}else {
					System.out.println("갱신에 실패했습니다. DAO를 확인해주세요.");
					System.out.println("yn is: "+yn);
				}
			}
		rs.close();
		pstmt.close();
		con.close();
		return flag;
	}//modifyInShelf()
	
	// 도서 객체 내용 변경: 도서 대출 또는 대여 가능 여부 변경(Y:가능 N:불가능)  
	public boolean modifyInShelfY(String title) throws SQLException {
		boolean flag = false;
		String sqlToY = "update book set inshelf = 'Y' where title=?;";
		String yn = null;
		
		// 도서를 보유 중인지 체크해서 
		boolean isInShelf = bdao.isInShelf(title);
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		pstmt = con.prepareStatement(sqlToY);
		pstmt.setString(1, title);		
		
		ResultSet rs = pstmt.executeQuery();
		// 도서를 보유 중이라면 InShelf 속성 변경(도서관 밖으로 나가는 거니까 N으로) 
		if(isInShelf == true) {
			while(rs.next()) {
				yn = rs.getString("inshelf");
				
				if(yn=="N") {
					flag = true;
					System.out.println(title+"의 inshelf 속성이 N으로 변경되었습니다.");
				}else {
					System.out.println("갱신에 실패했습니다. DAO를 확인해주세요.");
					System.out.println("yn is: "+yn);
				}
			}
//		}else if(isInShelf == false) {
//			pstmt = con.prepareStatement(sqlToY);
//			pstmt.setString(1, title);	
//			
//			ResultSet rs = pstmt.executeQuery();
//			while(rs.next()) {
//				yn = rs.getString("inshelf");
//			}
//			
//			if(yn=="Y") {
//				System.out.println(title+"의 inshelf 속성이 Y로 변경되었습니다.");
//			}else {
//				System.out.println("갱신에 실패했습니다. DAO를 확인해주세요.");
//			}
//			rs.close();
		}
		rs.close();
		pstmt.close();
		con.close();
		return flag;
	}//modifyInShelf()
	
}//end of DAO
