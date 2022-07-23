package lesson.day0720.lottov2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
//로직 처리
public class LottoMachine {
	// 6개의 공을 선택하는 것
	
	
	/* field */
	/* 모든 공이 담긴 상자의 이름이 balls */
	private ArrayList<LottoBall> balls;
	
	
	
	/* constructor */
	public LottoMachine() {
		
	}
	
	
	
	/* methods */
	public void setBalls(ArrayList<LottoBall> balls) {
		this.balls = balls;
	}
	// 아래getter는 사용하지 않음. 단지 정보은닉성을 구성하는 방법을 보여주는 예임
	//public ArrayList<LottoBall> getBalls() {
	//	return this.balls;
	//}
	
	
	public void startMachine() {
		List<LottoBall> balls = null;
		try {
			balls = this.selectBalls();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//balls를 오름차순으로 정렬
		/* Collections.sort는 두 번째 인자로 Comparator 인터페이스를 받을 수 있도록 정해져있다 */
		/* Comparator는 interface: 반드시 구현해야 한다 */
		/* compare(T o1, T o2)를 구현해준다 */
		/* 여기서는 익명객체로 구현되었다 */
		/* 내림차순으로 구현한다면 new Comparator<T>().reversed()로 써주면 된다 */
		Collections.sort(balls, new Comparator<LottoBall>() {
			@Override
			public int compare(LottoBall o1, LottoBall o2) {
				// TODO Auto-generated method stub
				return o1.getNumber() - o2.getNumber();
			}
		}
		);
		
		//출력
		System.out.println("이번주 로또 당첨번호는 >>> ");
		for(LottoBall ball : balls) {
			System.out.print(ball+" ");
		}
		System.out.println(" 입니다.");
	}
	
	
	private void shufflueBalls() {
		//볼을 섞는 코드
		/* .shuffle 메소드는 Collections 클래스에 정의되어 있음 */
		Collections.shuffle(balls);
	}
	
	
	private List<LottoBall> selectBalls() throws InterruptedException {
		// 선택된 6개의 볼을 출력한다.
		List<LottoBall> selectedBalls = new ArrayList<LottoBall>();
		for(int i=0;i<6;i++) {
			this.shufflueBalls();
			selectedBalls.add(this.getBall());
			Thread.sleep(1000);
		}
				
		return selectedBalls;
	}
	
	
	private LottoBall getBall() {
		LottoBall ball = null;
		Random r = new Random();
		int index = r.nextInt(balls.size());
		ball = balls.remove(index);
		System.out.println(ball+"번 공이 뽑혔습니다.");
		return ball;
	}
}

