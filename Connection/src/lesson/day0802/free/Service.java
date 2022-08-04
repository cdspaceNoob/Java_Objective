package lesson.day0802.free;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class Service {
	
	
	public void solution03() {
		DAO dao = new DAO();
		try {
			ArrayList<VO> list = dao.getData03(120);
			int total = 0;
			for(VO vo : list) {
				int point = 20;
				if(vo.getMgrCode().equals("A")) {
					point = 5;
				}else if(vo.getMgrCode().equals("B")) {
					point = 15;
				}
				total = total + vo.getTotal() + point;
			}//end for
		System.out.println("The total score is... "+total);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}/* solution03() */
	
	
	
	
	public void solution01() {
		/* DAO에 ResultSet 요청 */
		DAO dao = new DAO();
		try {
			ArrayList<VO> list = dao.getData01("B");
			
		/* 받은 ResultSet으로 문제 해결 */
			Collections.sort(list, new Comparator());
			System.out.println("fifth's StudentNo is... "+list.get(4).getStdNo());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}/* solution01() */
}/* END OF BUISNESS CLASS */
