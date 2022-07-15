package lesson.day0715.objective;

import java.util.Random;

public class LottoMachine {
	// 6개의 공을 선택하기 
	
	// 공 배열을 만든다 
	// 같은 패키지 내에 존재하므로 사용 가능하다 
	private LottoBall[] balls;
	
	// 기본 생성자와 동일하다 
	public LottoMachine() {
		
	}
	
	// 머신 세팅 
	public void setBalls(LottoBall[] balls) {
		
	}
	
	public LottoBall[] getBalls() {
		return this.balls;
	}
	
	// 6개의 공 선택하기 
	public void selectBalls() {
		// 선택된 6개의 공 번호 출력 
		LottoBall[] selectedBalls = new LottoBall[6];
		for (int i = 0; i < 6-1; i++) {
			selectedBalls[i] = this.getBall();
		}
		for (int i = 0; i < selectedBalls.length; i++) {
			System.out.print(selectedBalls[i].getNumber()+" ");
		}
		System.out.print("입니다");
	}
	
	
	// 하나씩 뽑기 
	private LottoBall getBall() {
		LottoBall ball = null;
		Random r = new Random();
		while(true) {
			int index = r.nextInt(45);
			ball = balls[index];
			if(!ball.isSelected()) {
				break;
			}
		
		}
		ball.setSelected(true);
		return ball;
	}
}
