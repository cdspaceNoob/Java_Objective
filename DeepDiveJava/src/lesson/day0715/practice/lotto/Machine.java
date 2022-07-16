package lesson.day0715.practice.lotto;

public class Machine {
	/* filed */
	private Ball[] balls;
	
	
	/* methods */
	
	// create 45 balls
	public Ball[] insertBalls() {
		Ball[] balls = new Ball[45];
		Ball ball = null;
		for(int i=0; i<balls.length; i++) {
			ball = new Ball(i+1);
			balls[i] = ball;
		}
		this.balls = balls;
		return balls;
	}
	
	// create selected box of 6 chosen balls
	public void selectedBalls() {
		Ball[] selectedBalls = new Ball[6];
		for(int i=0; i<6; i++) {
			
		}
	}
	
	
	
	
	
}