package lesson.day0715.objective;

import java.util.Random;
/* V2
 * 공 섞기
 * 추첨 시 공이 밖으로 빠져 나오도록 코드 작성
 * 공 번호를 오름차순으로 정렬하기
 */
public class StudioV2 {
	
   /* 필
	* private로 반환타입이 클래스 변수를 생성했습니다 
	* private로 둔 까닭은 이 클래스 파일에서만 접근할 수 있게 하여 
	* 안정성을 높인 것입니다 
	* 이 변수에는 해당 클래스의 주소가 들어가게 될 것입니다
	* 클래스는 참조타입이고 참조타입의 변수는 객체의 번지수를 가지기 때문입니다   
    */
	private LottoMachine machine;
	
	/* 생성자 */
	public StudioV2() {
		/* 
		 * 클래스를 인스턴스로 만들 때, 초깃값을 잡아주는 생성자 영역입니다 
		 * 같은 패키지 내에 로또머신이 존재하므로 이렇게 객체를 생성할 수 있습니다
		 * 위에서 선언해둔, 반환타입이 로또머신 클래스인 변수에 
		 * 로또 머신 객체를 생성하고 그 주소를 넣어둡니다 
		 */  
		machine = new LottoMachine();
	}
	
	/* 엔트리 포인트: 메인함수 */
	public static void main(String[] args) {
		/* mbc라는 이름의 스튜디오 객체를 생성합니다 */
		StudioV2 mbc = new StudioV2();
		/* 스튜디오 객체가 가지고 있는 onAir()메소드를 실행합니다 */
		mbc.onAir();
	}
	
	/* 메소드 */
	public void onAir() {
		/* 
		 * 위의 생성자에서 machine이라는 변수에 로또머신 객체를 만들어 뒀습니다
		 * (변수 machine에는 로또머신 객체의 주소가 들어가있습니다) 
		 * 로또 머신 객체가 가진 메소드 setBalls()의 매개변수를  
		 * 이 클래스(스튜디오)의 redayBalls()메소드의 리턴값으로 하고 
		 * 메소드를 실행합니다  
		 */
		machine.setBalls(this.readyBalls());
		
		/* 생성해둔 머신객체가 가진 startMachine() 메소드를 실행합니다 */
		machine.startMachine();
	}
	
	/* 메소드 */
	/* 반환타입이 로또공 클래스의 배열인 메소드를 정의합니다 */
	public LottoBall[] readyBalls() {
		/*
		 * []의 의미는 객체를 여러개 담아둘 공간을 만들겠다는 뜻입니다 
		 * 헷갈린다면 []를 제외하고 생각해보면 간단합니다  
		 */
		LottoBall[] balls = new LottoBall[45];
		
		/* 
		 * 클래스 로또공으로 객체를 45개 만들어야 합니다 
		 * 하나씩 만들기엔 너무 많은 반복작업이 필요하므로
		 * 반복문을 사용합니다
		 */
		int ballNumer = 1;
		// false로 배열 초깃값 설정
		boolean[] numbers = new boolean[45];
		for(int i=0; i<46; i++) {
			numbers[i] = false;
		}
		// 인덱스가 공번호, 인덱스는 랜덤으로 생성(1~45), 배열의 해당 인덱스값은 true, true면 반복
		Random r = new Random();
		
		for(int j=0; j<46; j++) {
			while(true) {
				int index = r.nextInt(45);
				if(!numbers[index]) {
					continue;
				}
				balls[j] = new LottoBall(index+1);
			}
			
			
		}
		
		
		//for(int i=0; i<45; i++) {
			
			/* 
			 * 방금위에 만들어둔 로또공 클래스를 담을 공간 balls에
			 * new 연산자를 이용하여 로또공 객체를 생성하고
			 * 로또공 객체를 balls안에 보관합니다
			 * LottoBall(여기의 숫자)는
			 * 로또공 객체를 생성하기 위해 필요한 매개변수입니다 
			 * 클래스 LottoBall의 생성자를 보면 ballNumber를
			 * 매개변수로 함을 확인할 수 있습니다 
			 */
			//balls[i] = new LottoBall(ballNumer++);	
		//}
	/* 이렇게 45개의 로또공이 만들어지고, balls라는 배열에 저장됩니다
	 * 이 배열을 리턴합니다 
	 */
	return balls;
	}
}
