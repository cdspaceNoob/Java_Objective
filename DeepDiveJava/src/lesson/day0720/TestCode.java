package lesson.day0720;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestCode {
	/* field */
	
	/* constructor */
	
	/* method */ 
	public void testDate() {
		Date date = new Date();
		System.out.println(date);
		System.out.println(date.toString());
		
		String pattern = "yyyy년이 밝았습니다\n오늘은 MM월 dd일이고요\n현 시각은 HH시 mm분 ss초입니다";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String now = sdf.format(date);
		System.out.println(now);
	}/* end method: testDate() */



}/* END CLASS */


