package lesson.day0720;

import java.util.ArrayList;

public class CollectionCode {
	public void testList() {
		// ArrayList: 가변형 배열 - 길이가 알아서 조절되는 
		ArrayList arrList = new ArrayList();
			// 추가
		arrList.add(Integer.valueOf(1));
		arrList.add(Integer.valueOf(2));
		arrList.add(Integer.valueOf(30));
		int size = arrList.size();
		System.out.println(size);
		/* arrList는 객체이므로 캐스팅 필요 */
		Integer intObj = (Integer)arrList.get(0);
	}
}
