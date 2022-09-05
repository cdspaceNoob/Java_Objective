package guest.pack.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeService {
	public static String getNow() {
		Date date = new Date();
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String now = sdf.format(date);
		return now;
	}
}
