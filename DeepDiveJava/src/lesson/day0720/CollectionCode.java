package lesson.day0720;

import java.util.ArrayList;

public class CollectionCode {
	public void testList() {
		// ArrayList: 가변형 배열 - 길이가 알아서 조절되는 배열
		// Collection - List의 한 형태 
		// ArrayList arrList = new ArrayList();
		ArrayList<Integer> arrList = new ArrayList<Integer>(); 
		/* 
		 * Generic(제너릭) 객체를 저장하는 데에 있어, 저장할 객체의 타입을 결정하는 문법 
		 * 자료 타입 결정과는 다르다 
		 * 배열이라면 int[]라고 써주면 된다
		 * 그럼 비슷한 거 아닌가요?
		 * 비슷하다
		 * 그 배열에서 가변형만 추가된 거 아닌가요?
		 * 맞습니다
		 * 타입을 결정하는 것은 동일하나, 그 길이를 바꿀 수 있다는 점에 큰 차이가 있다
		 */
		
		/* 박싱된 포장 객체에서 기본 타입의 값을 얻어내기
		 * 변수명 = obj.포장클래스이름Value();
		 */
		
		/* 추가: 박싱 사용 - Primitive타입값을 포장해주는 것 (Wrapper 객체 생성)
		 * 포장클래스이름 변수이름 = 포장클래스이름.valueOf(기본타입값 또는 문자열)
		 */
		arrList.add(Integer.valueOf(1));	// 원칙(boxing)
		arrList.add(1);						// 허용(auto-boxing) 
		arrList.add(Integer.valueOf(2));
		arrList.add(Integer.valueOf(30));
		//arrList.add(String.valueOf("man")); 제너릭으로 인해 컴파일 에러 발생(String타입) 
		int size = arrList.size();
		
		System.out.println(size);
		
		/* arrList는 객체이므로 캐스팅 필요 */
		Integer intObj = (Integer)arrList.get(0);
		
		/* 언박싱 사용 
		 * 변수이름 = obj.포장클래스이름Value();
		 */
		int intVal = intObj.intValue();
		System.out.println(intVal);
		
		/* 변경 */ 
		arrList.set(2, Integer.valueOf(3));	// 원칙(unboxing)
		arrList.set(2, 3);					// 허용(auto-unboxing)
		intObj = (Integer)arrList.get(2);
		intVal = intObj.intValue();			// 원칙(unboxing) 
		
			// 삭제 
		intObj = arrList.remove(3);
		System.out.println("제거된 값은: "+intObj);
		
		
		System.out.println(intVal);
			// 크기 
		for(int i=0; i<arrList.size(); i++) {
			intObj = (Integer)arrList.get(i);
			intVal = intObj.intValue();		// 원칙(unboxing)
			
			System.out.println(intVal);
		}
	}
}
