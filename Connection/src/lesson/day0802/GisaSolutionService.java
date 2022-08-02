package lesson.day0802;

import java.sql.SQLException;
import java.util.ArrayList;

public class GisaSolutionService {
	
	
	public void solveQuiz01() {
	/* 문제 해결을 위한 데이터셋을 DAO에 요청 */
		GisaDAO dao = new GisaDAO();
		try {
			ArrayList<StudentVO> list = dao.selectQuiz01Data("b");
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
			System.out.println(list.get(4).getStdNo());
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
