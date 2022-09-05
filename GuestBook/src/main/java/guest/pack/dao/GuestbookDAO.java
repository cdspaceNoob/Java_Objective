package guest.pack.dao;

import java.sql.Connection;

import guest.pack.util.ConnectionManagerV2;
import guest.pack.vo.GuestbookVO;

public class GuestbookDAO {
	public boolean insertOne(GuestbookVO book) {
		boolean flag = false;
		Connection con = ConnectionManagerV2.getConnection();
		if(con!=null) {
			System.out.println("connected");
		}else {
			System.out.println("connection fail");
		}
		return flag;
	}
}
