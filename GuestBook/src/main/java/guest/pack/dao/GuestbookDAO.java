package guest.pack.dao;

import java.sql.Connection;

import guest.pack.util.ConnectionManager;
import guest.pack.vo.GuestbookVO;

public class GuestbookDAO {
	public boolean insertOne(GuestbookVO book) {
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();
		if(con!=null) {
			System.out.println("connected");
		}else {
			System.out.println("connection fail");
		}
		return flag;
	}
}
