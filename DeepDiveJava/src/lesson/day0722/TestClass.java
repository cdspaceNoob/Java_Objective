package lesson.day0722;

import java.io.IOException;

public class TestClass {
	/* 문제를 푸는 장소 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestClass tc = new TestClass();
		try {
			tc.startSolvingQuiz();
		}catch(IOException ie) {
			System.out.println("문제가 있습니다");
		}
		
	}
	
	public void startSolvingQuiz() throws IOException {
		QuizSolution qs = new QuizSolution();
		qs.readyTestData();
		qs.solveQuiz1();
		qs.solveQuiz2();
		qs.solveQuiz3();
	}
	
}
