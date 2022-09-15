package mvc.prac.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/* config: Servers/../context.xml/<Resource/> 
 * upload: Servers/../context.xml/server.xml
 * */

public class ConnectionManager {
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Context initCtx = new InitialContext();
			Context ctx 	= (Context)initCtx.lookup("java:/comp/env");
			DataSource ds	= (DataSource)ctx.lookup("jdbc/mariadb");
			con 			= ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}//getConnection()
	
	public static void closeConnection(ResultSet rs, Statement stmt, Connection con) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//close ResultSet
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//close Statement
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//close Connection
	}//closeConnection()
	
}/* END OF ConnectionManager */
