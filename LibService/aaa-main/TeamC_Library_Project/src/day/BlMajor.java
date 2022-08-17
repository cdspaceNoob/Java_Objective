package day;

import java.sql.SQLException;
import java.util.ArrayList;

public class BlMajor {
	
	//최다 대출 학과 TOP 5
	public void majorFreq() throws SQLException {
		ArrayList<String> list = new ArrayList<String>();
		BlMajorDAO majorDAO = new BlMajorDAO(); 
		list = majorDAO.selectCountMajor();
		System.out.println("학과별 총 대출 횟수 TOP5");
		for(int i=0; i<5; i++) {
			System.out.println(list.get(i));
		}
	}//majorFreq()
	
	
	public void majorLazy() throws SQLException {
		ArrayList<String> list = new ArrayList<String>();
		BlMajorDAO majorDAO = new BlMajorDAO(); 
		list = majorDAO.selectReturnMajor();
		System.out.println("학과별 평균 대출 기간 TOP5");
		for(int i=0; i<5; i++) {
			System.out.println(list.get(i));
		}
	}//majorLazy()
	
}
