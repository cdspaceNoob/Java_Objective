package lesson.jdbc;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseMain {
	public static void main(String[] args) {
		DatabaseMain main = new DatabaseMain();
		/* 1. 파일의 데이터를 쭈욱 받아 놓고(MAIN) // 2. insert 쿼리를 사용한다(DAO) */
		//ArrayList<StudentVO> list = main.getFileData(); 예외 발생하므로 try-catch
//		try {
//			ArrayList<StudentVO> list = main.getFileData();
//			main.testInsert(list);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		/* insert into */
//		main.testInsert();
		
//		/* delete where */
//		try {
//			main.testDelete();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}/* delete where end */
		
		/* delete all */
//		try {
//			main.testDeleteAll();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}/* end delete all */
		
//		ArrayList<StudentVO> list = null;
//		try {
//			list = main.getFileData();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			main.testInsert(list);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			main.solve();
			main.solve2();
			main.solve3();
			main.solve4();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
		
		
	/* methods */
	
	public void solve() throws SQLException {
		Service s = new Service();
		int rs = s.solution();
		System.out.println("result: "+rs);
	}
	
	public void solve2() throws SQLException {
		Service s = new Service();
		int rs = s.solution2();
		System.out.println("result: "+rs);
	}
	
	public void solve3() throws SQLException {
		Service s = new Service();
		int rs = s.solution3();
		System.out.println("result: "+rs);
	}
	
	public void solve4() throws SQLException {
		Service s = new Service();
		int rs = s.solution4();
		System.out.println("result: "+rs);
	}
	
	
	
	private ArrayList<StudentVO> getFileData() throws IOException  {
		// TODO Auto-generated method stub
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();
		// 파일의 기본 정보만 가진 상태(파일 겉면). 예: 이름, 확장자, 크기, 위치 등... 
		File file = new File("./Abc1115.csv");
		
		// 파일의 실제 내용(Content)을 읽고자 한다. 
		// 그러나 file의 정체를 모르기 때문에 예외 발생 가능성이 있다. 
		// 따라서, 여기서 throws ExcpetionName 을 메서드에 붙여서 처리한다.
		// 이로 인해 던져지는 예외유형은, 이 메서드를 호출하는 스크립트에서 try로 처리한다.
		FileReader fr = new FileReader(file);	 
		
		// 한 줄씩 읽기. fileReader는 content를 가지고 있다. content를 읽는다.
		BufferedReader br = new BufferedReader(fr); 
		
		String line = null;
		StudentVO vo = null;
		while((line=br.readLine())!=null){
			vo = new StudentVO(line);
			list.add(vo);
			}
		if(list.size()>0) {
			System.out.println("Its read");
		}
		br.close(); // 나중에 열린 스트림을 먼저 닫는다 
		fr.close(); 
		return list;
	}
	
	
	/* DAO 객체를 생성하고 Insert작업 수행 */
	public void testInsert(ArrayList<StudentVO> list) throws SQLException {
		GisaDAO dao = new GisaDAO();
		boolean flag = dao.InsertData(list);
		if(flag) {
			System.out.println("insert OK");
		} else {
			System.out.println("insert Failed");
		}
	}
	
	/* DAO 객체를 생성하고 개별 데이터를 하드 코딩 형태로 입력 */
	public void testInsert() {
		String data = "990001, addx, 17, 29, 16, 49, 43,154,C,A,C";
		GisaDAO dao = new GisaDAO();
		StudentVO vo = new StudentVO(data);
		
		try {
			boolean flag = dao.InsertData(vo);
			if(flag) {
				System.out.println("insert ok");
			} else {
				System.out.println("insert failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}/* end testInsert()*/
	
	public void testDelete() throws SQLException {
		GisaDAO dao = new GisaDAO();
		boolean flag = dao.DeleteData(990002); // insert와 다르게 이번엔 main에서 예외 처리
		if(flag) {
			System.out.println("Query OK");
		} else {
			System.out.println("Query Failed");
		}
	}/* end testDelete()*/
	
	
	public void testDeleteAll() throws SQLException {
		GisaDAO dao = new GisaDAO();
		boolean flag = dao.DeleteData(); // insert와 다르게 이번엔 main에서 예외 처리
		if(flag) {
			System.out.println("Query OK");
		} else {
			System.out.println("Query Failed");
		}
	}/* end testDeleteAll()*/
}
