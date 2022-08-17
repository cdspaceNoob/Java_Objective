package day;


import java.sql.SQLException;
import java.util.ArrayList;

public class BorrowBook {
	/* fields */
	StudentVO student;
	BookVO book;
	static LibraryDAO dao = new LibraryDAO();
	DateTimeService dts = new DateTimeService();

	/* constructor */
	public BorrowBook(int stdNo, int bookNo) throws SQLException {
		student = dao.selectStudent(stdNo);
		book = dao.selectBook(bookNo);
	}
	
	
	/* methods */
	
	// 학생이 대출정지상태인지 확인
	public boolean checkSuspention() {
		boolean flag = false;
		// 정지기간 칼럼값을 susDate에 할당  
		String susDate = student.getStop_date();
		if (susDate.equals("0") ) {
			flag = false;
			System.out.println("연체 기간이 없습니다");
			// 정지기간 값이 존재한다면 
			// String인 연체일을 Integer로 parse - 현재 날짜 얻어오기: 0보다 크면 연체한 것 
		} else if ((Integer.parseInt(susDate) - Integer.parseInt(DateTimeService.getNow())) > 0){

			//System.out.println(Integer.parseInt(susDate));
			//System.out.println(Integer.parseInt(DateTimeService.getNow()));
			System.out.println("연체 기간이 있습니다");
			flag = true;
		}
		System.out.println("false이면 연체기간이 없습니다: "+flag);
		return flag;
	}

	// 학생의 미반납도서 중 연체도서가 있는지
	public boolean checkUnreturnBook() {
		boolean flag = false; // 초깃값은 연체도서 없음으로 시작 
		String match = "[^0-9]";
		ArrayList<LoanVO> list = new ArrayList<LoanVO>();
		try {
			// 학번으로 대출 장부 조회 -> 한 행씩 저장된 대출 기록을 ArrayList에 받음  
			list = dao.selectRentalBook(student.getStd_no());
			for (LoanVO vo : list) {
				
				// 실제 반납일 - 현재 날짜 
				//System.out.println("asd"+vo.getExp_return_date().replaceAll(match, ""));
				System.out.println("반납일-현재날짜: "+(Integer.parseInt(vo.getExp_return_date().replaceAll(match, "")) - Integer.parseInt(DateTimeService.getNow().replaceAll(match, ""))));
				if (Integer.parseInt(vo.getExp_return_date().replaceAll(match, "")) - Integer.parseInt(DateTimeService.getNow().replaceAll(match, "")) < 0) {
					//연체도서 있으면 true;
					
					flag = true;
					System.out.println("flag check if문 :"+flag);
					return flag;
				}
			}
			System.out.println("flag check if문 통과 :"+flag);
			return flag;
			//System.out.println(list.get(0).getExp_return_date().replaceAll(match, ""));
			//System.out.println("getnow"+Integer.parseInt(DateTimeService.getNow().replaceAll(match, "")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	

	// 학생이 빌린 도서가 5권 인지? (최대 대여 도서 수량)
	public boolean checkBorrowable() {
		boolean flag = false;
		if (student.getLoan_cnt() < 5) {
			flag = true;
		}
		return flag; //true이면 대출 가능 5권 미만 대출 
	}

	// 학생이 빌리려는 도서가 도서관에 있는지?
	public boolean checkHaveBook() {
		boolean flag = false;
		if (book.getLoan_yn().toUpperCase().equals("Y")) {
			flag = true; // true이면 대출 가능 
		}
		return flag;
	}

	// 도서 대여 실행
	public boolean borrowConfirm() {
		boolean flag = false;
		// 현재 날짜 받아오기 -> 대출일로 설정  
		String loanDate = dts.getNow();
		// 현재 날짜 +7일 -> 반납 예정일 설정 
		String returnDate = dts.calDate(loanDate, 7);
		ArrayList<LoanVO> list = new ArrayList<LoanVO>();
		LoanVO vo = new LoanVO(1, loanDate, returnDate, student.getStd_no(),book.getBook_no(),"","N");
		list.add(vo);
		//대출 장부 한 줄 만들어 놓음 
		
		try {
			// 대출장부에 만들어 놓은 한 줄 입력
			dao.insertRentalBook(list);
			// 반납여부 N으로 변경 
			dao.updateRentalBook("N", book.getBook_no());
			// 학생의 대출 권수 추가
			dao.updateStudentRentalCnt(student.getStd_no());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	// 도서 대여 취소
	public void borrowCancel() {

	}

}
