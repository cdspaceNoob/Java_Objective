package lib.service.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeService {
	
	public static String getNow() {
		Date date = new Date();
		String pattern = "HH시 mm분 ss초입니다";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String now = formatter.format(date);
		
		return now;
	}//getNow()

}
