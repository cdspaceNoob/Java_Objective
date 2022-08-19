package lesson.gntp.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeService {
	public String getNow() {
		Date now = new Date(); // 현재 날짜 및 시각 now 변수에 할당 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초"); // 포맷 설정 
		String time = formatter.format(now); // 받아온 현재 날짜 및 시각이 할당된 now를 format에 넣고 돌리기 
		return time;
	}
}
