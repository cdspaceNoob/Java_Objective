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
		try {
			// 해당 도서를 보유 중인지 
			//boolean inInShelf = bdao.isInShelf(title);
			
			// 대여하려는 학생이 5권 이상 대여했는지
			boolean cntBorrow = bdao.selectCntBorrow(title);
			
			// 조건 맞으면 
//			if(inInShelf==true && cntBorrow==true) {
			if(cntBorrow==true) {
				// 책 객체의 보유 여부 속성값을 N으로 바꾸기 
				this.modifyInShelf(title);
				
				// 책 객체의 대여 일자 속성값을 set now()로
				// 선수 작업: 리스트 객체에 책 객체의 대여 일자 속성을 FK로 추가 
				
				// 책 객체의 반납 예정 일자 속성값을 set now()+7로
				// 선수 작업: 리스트 객체에 책 객체의 반납 예정 일자 속성을 FK로 추가  
				
				// 속성 추가: 실제 반납된 일자 
			}
			System.out.println("책 " + title + "은(는) "+ StdNo+ "님께 정상적으로 대출 되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("뭔가 잘못되었읍니다.");
		}
	}//transactionBorrow()
	
	// 도서 객체 내용 변경: 도서 대출 또는 대여 가능 여부 변경(Y:가능 N:불가능)  
	public void modifyInShelf(String title) throws SQLException {
		String rTitle = "%" + title + "%";
		String sqlToN = "update book set inshelf = 'N' where title=?;";
		String sqlToY = "update book set inshelf = 'Y' where title=?;";
		String yn = null;
		
		// 도서를 보유 중인지 체크해서 
		boolean isInShelf = bdao.isInShelf(rTitle);
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		// 도서를 보유 중이라면 InShelf 속성 변경(도서관 밖으로 나가는 거니까 N으로) 
		if(isInShelf == true) {
			pstmt = con.prepareStatement(sqlToN);
			pstmt.setString(1, rTitle);		
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				yn = rs.getString("inshelf");
			}
			
			if(yn=="N") {
				System.out.println(title+"의 inshelf 속성이 N으로 변경되었습니다.");
			}else {
				System.out.println("갱신에 실패했습니다. DAO를 확인해주세요.");
			}
			rs.close();
		}else if(isInShelf == false) {
			pstmt = con.prepareStatement(sqlToY);
			pstmt.setString(1, rTitle);	
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				yn = rs.getString("inshelf");
			}
			
			if(yn=="Y") {
				System.out.println(title+"의 inshelf 속성이 Y로 변경되었습니다.");
			}else {
				System.out.println("갱신에 실패했습니다. DAO를 확인해주세요.");
			}
			rs.close();
		}
		pstmt.close();
		con.close();
	}//modifyInShelf()
	
}//end of DAO
