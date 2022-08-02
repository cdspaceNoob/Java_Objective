package lesson.day0802;

import java.util.Comparator;

public class StudentComparator implements Comparator<StudentVO> {

	@Override
	public int compare(StudentVO o1, StudentVO o2) {
		// TODO Auto-generated method stub
		int result = o2.getQuiz01Data() - o1.getQuiz01Data();
		
		
		// 같다면 학번 높은 사람이 먼저다 
		if(result == 0) {
			result = o2.getStdNo() - o1.getStdNo();
		}
		
		return result;
	}

}
