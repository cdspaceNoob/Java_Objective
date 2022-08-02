package lesson.day0802.free;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class Service {
	
	public void soution01() {
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
	}
}
