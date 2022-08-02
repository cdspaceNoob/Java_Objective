package lesson.day0802;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class GisaSolutionService {
	
	public void solveQuiz04() {
		GisaDAO dao = new GisaDAO();
		try {
			ArrayList<StudentVO> list = dao.selectQuiz04Data("A","B");
			//StudentVO vo = null;
			//int total = 0;
			//int count = 0;
			//int codeVal = 0;

			
			
			int count = 0;
			for(StudentVO vo : list) {
				int point = 15; 
				if(vo.getLocCode().equals("A")) {
					point = 5;
				}else if(vo.getLocCode().equals("B")) {
					point = 10;
				}
				if(vo.getKor()+point>=50) {
					count++;
				}
			}//end for
			System.out.println("Count of Total over 50 is... "+count);	
			
			
			
			
			/*
			for(int i = 0; i < list.size(); i++) {
				vo = list.get(i);
				String code = vo.getLocCode();
				
				switch(code) {
				case "a": codeVal = 5;
				break;
				case "b": codeVal = 10;
				break;
				case "c": codeVal = 15;
				break;
				}
				total = vo.getKor() + codeVal;
				if(total > 50) {
					count++;
				}
			}// end for
			*/
		//System.out.println("Count of Total over 50 is... "+count);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void solveQuiz03() {
		GisaDAO dao = new GisaDAO();
		try {
			ArrayList<StudentVO> list = dao.selectQuiz03Data(120);
			//StudentVO vo = null;
			//int total = 0;
			//int codeVal = 0;
			
			
			int sum = 0;
			for(StudentVO vo : list) {
				int point = 20; 
				if(vo.getAccCode().equals("A")) {
					point = 5;
				}else if(vo.getAccCode().equals("B")) {
					point = 15;
				}
				sum = sum + vo.getTotal() + point;
			}//end for
			System.out.println("Sum of Records is.. "+sum);
			
			
			/*
			for(int i = 0; i < list.size(); i++) {
				vo = list.get(i);
				String code = vo.getMgrCode();
				switch(code) {
				case "a": codeVal = 5;
				break;
				case "b": codeVal = 15;
				break;
				case "c": codeVal = 20;
				break;
				}
				total = total + list.get(0).getTotal() + codeVal;
			}//end for
			*/
		//System.out.println("Sum of Records is.. "+total);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}/* solveQuiz03 */
	
	
	public void solveQuiz02() {
		/* 문제 해결을 위한 데이터셋을 DAO에 요청 */
		GisaDAO dao = new GisaDAO();
		try {
			ArrayList<StudentVO> list = dao.selectQuiz01Data("B");
			//System.out.println(list.size()); // 크기 확인 
			
			/* 1번 문제: 국어+영어 점수를 ASC로 정렬하시오 */
			StudentVO vo1 = null;
			StudentVO vo2 = null;
			StudentVO temp = null;
			for(int i = 0; i < list.size()-1; i++) {
				for( int j = i+1; j < list.size(); j++) {
						vo1 = list.get(i);
						vo2 = list.get(j);
						
						if(vo1.getQuiz01Data() < vo2.getQuiz01Data()) {
							temp = vo1;
							list.set(i,  vo2);
							list.set(j,  temp);
						}/* vo1.getQuiz01Data() < vo2.getQuiz01Data */
						
						if(vo1.getQuiz01Data() == vo2.getQuiz01Data()) {
							if(vo1.getStdNo() < vo2.getStdNo()) {
								temp = vo1;
								list.set(i,  vo2);
								list.set(j,  temp);
							}
						}/* getQuiz01Data == getQuiz02Data */
					}/*end Inner for */
				}/* end Outer for */
			//this.printList(list);
			System.out.println("Maximum Score of KOR+ENG is... "+list.get(0).getQuiz01Data());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}/* solveQuiz02 */
	
	
	
	public void solveQuiz01V2() {
	/* 문제 해결을 위한 데이터셋을 DAO에 요청 */
		GisaDAO dao = new GisaDAO();
		try {
			ArrayList<StudentVO> list = dao.selectQuiz01Data("B"); 
			// list 처리 로직을 사용(Collections methods)
			
			/* 정렬(sorting) 클래스 */
			Collections.sort(list, new StudentComparator());
			//this.printList(list);
			System.out.println("fifth's Student No is ... "+list.get(4).getStdNo());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}/* solveQuiz01 */
	
	
	
	
	
	
	
	
	public void solveQuiz01() {
	/* 문제 해결을 위한 데이터셋을 DAO에 요청 */
		GisaDAO dao = new GisaDAO();
		try {
			ArrayList<StudentVO> list = dao.selectQuiz01Data("B");
			//System.out.println(list.size()); // 크기 확인 
			
			/* 1번 문제: 국어+영어 점수를 ASC로 정렬하시오 */
			StudentVO vo1 = null;
			StudentVO vo2 = null;
			StudentVO temp = null;
			for(int i = 0; i < list.size()-1; i++) {
				for( int j = i+1; j < list.size(); j++) {
						vo1 = list.get(i);
						vo2 = list.get(j);
						
						if(vo1.getQuiz01Data() < vo2.getQuiz01Data()) {
							temp = vo1;
							list.set(i,  vo2);
							list.set(j,  temp);
						}/* vo1.getQuiz01Data() < vo2.getQuiz01Data */
						
						if(vo1.getQuiz01Data() == vo2.getQuiz01Data()) {
							if(vo1.getStdNo() < vo2.getStdNo()) {
								temp = vo1;
								list.set(i,  vo2);
								list.set(j,  temp);
							}
						}/* getQuiz01Data == getQuiz02Data */
					}/*end Inner for */
				}/* end Outer for */
			//this.printList(list);
			System.out.println("Fifth Student No is... "+list.get(4).getStdNo());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}/* solveQuiz01 */




	public void printList(ArrayList<StudentVO> list) {
		for(StudentVO vo : list) {
			System.out.println(vo);
		}
	}


}/*end*/
