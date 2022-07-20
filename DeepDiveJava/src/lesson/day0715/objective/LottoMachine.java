package lesson.day0715.objective;

import java.util.ArrayList;
import java.util.Random;

public class LottoMachine {
	// 6개의 공을 선택하기 
	
	// 공 배열을 만든다 
	// 같은 패키지 내에 존재하므로 사용 가능하다 
	private ArrayList<LottoBall> balls;
	
	// 기본 생성자와 동일하다 
	public LottoMachine() {
		
	}
	
	/* 스튜디오 readyBalls에서 만든, 공이 45개 들어있는 배열을 여기에 넣는다 */
	public void setBalls(ArrayList<LottoBall> balls) {
		/* 
		 * 선언해둔 balls 변수에 readayBalls에서 만든 배열이 들어간다
		 * 스튜디오에서 준비해둔 공들을 추첨 기계로 넣는 상황을 연상 
		 */
		this.balls = balls;
	}
	
	public ArrayList<LottoBall> getBalls() {
		return this.balls;
	}
	
	public void startMachine() {
		this.selectBalls();
	}
	
	// 6개의 공 선택하기 
	private void selectBalls() {
		/* 당첨공 6개를 보관할 배열을 생성 */ 
		ArrayList<LottoBall> selectedBalls = new ArrayList<LottoBall>();
		
		/* 6회 반복 추첨을 시작 */
		for (int i = 0; i < 6; i++) {
			/* 당첨공 6개를 보관할 배열에 getBall()메소드의 반환값 넣기 */ 
			selectedBalls.add(this.getBall());
		}
		
		/* 당첨공 보관 배열에 있는 객체에 접근하여 당첨공의 번호를 모니터에 출력 */
		for (int i = 0; i < selectedBalls.size(); i++) {
			System.out.print(selectedBalls.get(i)+" ");
		}
		System.out.print("입니다");
	}
	
	
	// 하나씩 뽑기 
	private LottoBall getBall() {
		/* 주소를 저장해둘 변수 ball 선언 */
		LottoBall ball = null;
		/* 랜덤 추첨을 위해 랜덤 객체 생성 */
		Random r = new Random();
		while(true) {
			/* 랜덤 객체로 번호를 생성하고 생성된 번호를 index에 할당 */ 
			int index = r.nextInt(45);
			/* 추첨상자에서 랜덤 인덱스에 해당하는 공의 주소를 ball에 할당 */
			ball = balls.get(index);
			
			/* 
			 * 해당 공이 추첨된 적이 없다면(무작위로 만들어진 수가 중복이 아니라면)
			 * 반복을 종료한다 
			 */
			if(!ball.isSelected()) {
				break;
			}
		
		}
		/* 중복이 아닌 공이기 때문에, 이제는 이거 뽑으면 중복이야 하고 체크해준다 */
		ball.setSelected(true);
		/* 이렇게 뽑아서 표시해둔 공 객체의 주소를 반환한다 */
		return ball;
	}
}
