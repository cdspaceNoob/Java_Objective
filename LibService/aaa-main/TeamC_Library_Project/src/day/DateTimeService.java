package day;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateTimeService {

	// 현재 날짜를 반환 
	public static String getNow() {

		// 경우에 따라 날짜, 시간, 날짜+시간 정보를 제공한다.
		String now = null;
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		// Date()를 사용하면 영문으로 날짜를 리턴하는데
		// 이걸 SimpleDateFormat으로 지정한 패턴에 맞게 변환해준다
		// 패턴화된 날짜 = SimpleDateFormat(pattern).format(new Date());
		now = sdf.format(new Date());

		return now;
	}//getNow()
	
	// 파라미터 now에 day만큼을 더하는 메서드 
	public static String calDate(String now, int day) {
		String result = null;
		Date date = null;
		//Calendar는 추상클래스이므로 객체를 생성할 수 없다 
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// simpleDateFormat.parse(): 유효한 날짜 형식인지 체크 
			date = sdf.parse(now);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cal.setTime(date);
		cal.add(Calendar.DATE, day);
		result = sdf.format(cal.getTime());
		return result;
	}
	

}