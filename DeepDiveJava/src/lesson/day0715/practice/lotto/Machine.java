package lesson.day0715.practice.lotto;
import java.util.Random;
public class Machine {
	/* filed */
	private Ball[] balls;
	
	
	/* methods */
	
	// create 45 balls
	public Ball[] insertBalls() {
		Ball[] balls_45 = new Ball[45];
		Ball ball = null;
		int ballNumber = 1;
		for(int i=0; i<45; i++) {
			ball = new Ball(ballNumber);
			balls_45[i] = ball;
			ballNumber += 1;
		}
		this.balls = balls_45;
		return balls;
	}
	
	
	// choose ball one by one
	public Ball getBall() {
		Ball ball = null;
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
	
	
	// create selected ball box of 6 chosen
	// echo number
	public void selectedBalls() {
		Ball[] selectedBalls = new Ball[6];
		for(int i=0; i<6; i++) {
			selectedBalls[i] = this.getBall();
		}
		System.out.println("당첨 번호");
		for (int i = 0; i<selectedBalls.length; i++) {
			System.out.print(selectedBalls[i].getNumber()+" | ");
		}
	}
	
	public void startMachine() {
		this.selectedBalls();
	}
	
	
	
	
	
}