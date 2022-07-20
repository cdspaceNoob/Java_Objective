package lesson.day0720;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeService {
	/* field */
	public static final int DATE_ONLY = 0;
	public static final int TIME_ONLY = 1;
	public static final int DATE_TIME = 2;
	
	/* constructor */
	
	/* method */
	public String getDateTime(int type) {
		String now = null;
		
		Date date = new Date();
		
		String pattern = "yyyy년MM월dd일 HH시mm분ss초";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		//now = sdf.format(new Date());
		now = sdf.format(date);
		
		if(type==0) {
			String[] temp = now.split(" ");
			now = temp[0];
		}else if(type ==1) {
			now = now.split(" ")[1];
		}else if(type ==2){

		}/* end if */
		
		
		
		return now;
	}/* end getDateTime */

}/* END CLASS */
