package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
    String driver = "org.mariadb.jdbc.Driver";
    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;
    
//    public JdbcTest(){
//        try {
//            Class.forName(driver);
//            con = DriverManager.getConnection(
//                    "jdbc:mariadb://127.0.0.1:3306/sqlcook",
//                    "voyager",
//                    "1234");
//            
//            if( con != null ) {
//                System.out.println("DB 접속 성공");
//                con.close();
//            }
//            
//        } catch (ClassNotFoundException e) { 
//            System.out.println("드라이버 로드 실패");
//        } catch (SQLException e) {
//            System.out.println("DB 접속 실패");
//            e.printStackTrace();
//        }
//    }
    
    
	public void connectMaria() throws ClassNotFoundException, SQLException {
		String driver = "org.mariadb.jdbc.Driver";
		String jdbcURL = "jdbc:mysql://localhost:3306/sample";
		String id = "voyager";
		String pwd = "1234";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbcURL,id,pwd);
		if(con!=null) {
			System.out.println("connected");
			con.close();
		} else {
			System.out.println("fail");
		}
		
	}
	
    
    public boolean InsertData(String data) throws SQLException {
    	boolean flag = false;
    	String[] temp = data.split(",");
    	
    	String sql = "insert into gisa values("+temp[0]+", "+temp[1]+", "+temp[2]+", "+temp[3]+", "+temp[4]+ ","+Integer.parseInt(temp[5].trim())
    				+","+Integer.parseInt(temp[6].trim())+","+Integer.parseInt(temp[7])+")";
    	Connection con = this.getConnection();  
    	Statement stmt = con.createStatement(); 
    	int affectedCount = stmt.executeUpdate(sql);
    	if(affectedCount > 0) {
    		flag = true;
    	}
    	return flag;
    }
    
    
    public Connection getConnection() {
		Connection con= null;
		String driver = "org.mariadb.jdbc.Driver";
		String jdbcURL = "jdbc:mariadb://127.0.0.1:3306/sample";
		String id = "voyager";
		String pwd = "1234";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(jdbcURL,id,pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		JdbcTest dbcon = new JdbcTest();
//		Connection con= null;
//		String driver = "org.mariadb.jdbc.Driver";
//		String jdbcURL = "jdbc:mariadb://127.0.0.1:3306/sample";
//		String id = "root";
//		String pwd = "1234";
//		String data = "990001, addx, 17, 29, 16, 49, 43154CAC\n";
//		
//		try {
//			boolean flag = dbcon.InsertData(data);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		JDBCTest test = new JDBCTest();
		
		JdbcTest test = new JdbcTest();
		
		try {
			test.connectMaria();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
