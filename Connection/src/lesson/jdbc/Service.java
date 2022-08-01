package lesson.jdbc;

import java.sql.SQLException;

public class Service {
	
	
	public int solution() throws SQLException {
		String sql = "select max(kor+eng) from gisa where loccode = 'b'";
		GisaDAO d = new GisaDAO();
		int result = d.select(sql);
		return result;
	}
	
	
	public int solution2() throws SQLException {
		String sql = "select sum(total)+sum("
				+ "case "
				+ "when acccode='a' then 5 "
				+ "when acccode='b' then 10 "
				+ "when acccode='c' then 15 "
				+ "end) as 'Eng + math score' from gisa where eng+math >= 120;";
		GisaDAO d = new GisaDAO();
		int result = d.select(sql);
		return result;
	}
	
	
	public int solution3() throws SQLException {
		String sql = "select count(*) from (select mgrCode from gisa where kor+loccode >=50)x where mgrCode != 'c'";
		GisaDAO d = new GisaDAO();
		int result = d.select(sql);
		return result;
	}
	
	
	public int solution4() throws SQLException {
		String sql = "select count(*) from\n"
				+ "     (\n"
				+ "     select * from gisa where acccode != 'c'\n"
				+ "     ) x\n"
				+ "     where kor+(case loccode "
				+ "when 'a' then 5 "
				+ "when 'b' then 10 "
				+ "when 'c' then 15 "
				+ "end)  >= 50;";
		GisaDAO d = new GisaDAO();
		int result = d.select(sql);
		return result;
	}
	
}
