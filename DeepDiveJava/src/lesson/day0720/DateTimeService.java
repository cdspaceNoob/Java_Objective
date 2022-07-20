package lesson.day0720;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeService {
	/* field */

	
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
	
	
	
	public String getDateTimeV2(DateTimeServiceType type) {
		String now = null;
		
		Date date = new Date();
		
		String pattern = "yyyy년MM월dd일 HH시mm분ss초";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		//now = sdf.format(new Date());
		now = sdf.format(date);
		
		if(type==DateTimeServiceType.DATE_ONLY) {
			String[] temp = now.split(" ");
			now = temp[0];
		}else if(type ==DateTimeServiceType.TIME_ONLY) {
			now = now.split(" ")[1];
		}else if(type ==DateTimeServiceType.DATE_TIME){

		}/* end if */
		return now;
	}/* end getDateTimeV2 */
	
	
	

}/* END CLASS */
