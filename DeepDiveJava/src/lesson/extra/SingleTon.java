package lesson.extra;

// 객체가 딱 하나만 필요하다면 다른 데서 접근하게 할 필요 없이 그냥 하나만 생성하면 된다 
// 그래서 싱글톤 쓴다 


public class SingleTon {
// 내부적으로만 사용할 껍데기 하나 만들어 놓고 
	private static SingleTon singleObj;
	
// 외부에서 생성자 접근 안 되도록 만든다 
//	private static SingleTon singleObj = new SingleTon();
	private SingleTon() {
	}
	
// 이 객체가 존재하지 않을 때 하나만 존재할 수 있도록 만든다 	
	public static SingleTon getInstance() {
		if(singleObj == null) {
			singleObj = new SingleTon();
		}
		return singleObj;
	}
	
	
	
}
