package lesson.day0722;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class QuizSolution {
	// 문제를 풀기 위한 준비 작업 및 실행 
	private ArrayList<Student> testData;
	
	public void readyTestData() throws IOException {
		this.testData = new ArrayList<>();
		File file = new File("./Abc1115.csv");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		Student student = null;
		while((line=br.readLine())!=null) {
			student = new Student();
			String[] splitedLine = line.split(",");
			student.setStdNo(Integer.parseInt(splitedLine[0].trim()));
			student.setEmail(splitedLine[1].trim());
			student.setKor(Integer.parseInt(splitedLine[2].trim()));
			student.setEng(Integer.parseInt(splitedLine[3].trim()));
			student.setMath(Integer.parseInt(splitedLine[4].trim()));
			student.setSci(Integer.parseInt(splitedLine[5].trim()));
			student.setHist(Integer.parseInt(splitedLine[6].trim()));
			student.setTotal(Integer.parseInt(splitedLine[7].trim()));
			student.setMgrCode(splitedLine[8].trim());
			student.setAccCode(splitedLine[9].trim());
			student.setlocalCode(splitedLine[10].trim());
			testData.add(student);
		}
		br.close();
		fr.close();
	}/* readyTestData() */
	
	
	
	public void solveQuiz1() throws IOException {
		ArrayList<Student> quiz1 = new ArrayList<Student>();
		for(int i=0; i<testData.size(); i++) {
			if(testData.get(i).getLocalCode().equals("B")) {
				quiz1.add(testData.get(i));
			}
		}
		
		int min = quiz1.get(0).getKor()+quiz1.get(0).getEng();
//		System.out.println("min is: "+min);
		for (int i=0; i<quiz1.size(); i++) {
			if(min > quiz1.get(i).getKor()+quiz1.get(i).getEng()) {
				min = quiz1.get(i).getKor()+quiz1.get(i).getEng();
			}
		}
		int fifth = (quiz1.get(4).getKor()+quiz1.get(4).getEng());
//		System.out.println("fifth is: "+fifth);
		
		for (int i=0; i<quiz1.size(); i++) {
			if(fifth == quiz1.get(i).getKor()+quiz1.get(i).getEng()) {
				boolean isFifth;
				isFifth = quiz1.get(4).getStdNo() < quiz1.get(i).getStdNo();
				if(!isFifth) {
					Student temp = quiz1.get(4);
					quiz1.set(4, quiz1.get(i));
					quiz1.set(i, temp);
				}
			}
		}
//		int intFifth = quiz1.get(4).getStdNo();
		
		/* 정상 해답 */
		this.writeAnswer(1, String.valueOf(quiz1.get(4).getStdNo()));
	}/* end solveQuiz1 */
	
	
	
	public void solveQuiz2() throws IOException {
		ArrayList<Student> quiz2 = new ArrayList<Student>();
		for(Student student : testData) {
			if(student.getLocalCode().equals("B")) {
				quiz2.add(student);
			}
		}
		
		int max = quiz2.get(0).getKor()+quiz2.get(0).getEng();
		for (Student student : quiz2) {
			if(max < student.getKor()+student.getEng()) {
				max = student.getKor()+student.getEng();
			}
		}
		this.writeAnswer(2, String.valueOf(max));
	}/* end solveQuiz2 */
	
	
	
	public void solveQuiz3() throws IOException {
		ArrayList<Student> quiz3 = new ArrayList<Student>();
		for(int i=0; i<testData.size(); i++) {
			if(testData.get(i).getKor()+testData.get(i).getEng() >= 120) {
				quiz3.add(testData.get(i));
			}
		}
		int total = 0;
		for(int i=0; i<quiz3.size(); i++) {
			total = quiz3.get(i).getEng()+quiz3.get(i).getMath();
			switch(quiz3.get(i).getMgrCode()) {
			case "A": total +=5;
			break;
			case "B": total +=15;
			break;
			case "C": total +=20;
			}
		}
		this.writeAnswer(3, String.valueOf(total));
		
	}/* end solveQuiz3 */
	
	
	
	public void solveQuiz4() {
		
	}/* end solveQuiz4 */
	
	
	
	private void writeAnswer(int quizNumber, String answer) throws IOException {
		File file = new File("Ans"+quizNumber+".txt");
		FileWriter fw = new FileWriter(file);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(answer);
		pw.close();
		fw.close();
		System.out.println(quizNumber+"번 문제 해답을 저장했습니다");
	}/* end writeAnswer */
}
