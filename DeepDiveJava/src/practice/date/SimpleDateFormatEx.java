package practice.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatEx {
	public static void main(String[] args) {
		Date dt = new Date();
		System.out.println("포맷 지정 전: " + dt);
		
		String datePattern = "yyyy년 MM월 dd일";
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
		
		String newDatePattern = sdf.format(dt);
		
		System.out.println("포맷 지정 후: " + newDatePattern);
	}
}
