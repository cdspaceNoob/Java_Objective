package lesson.day0718.game;
import java.util.Random;

import lesson.day0715.practice.lotto.Ball;

public class Com {
	/* field */
	private Ball[] balls;
	
	public Ball[] createBall() {
		Ball[] balls_10 = new Ball[10];
		Ball ball = null;
		int ballNumber = 1;
		for(int i=0; i<10; i++) {
			ball = new Ball(ballNumber);
			balls_10[i] = ball;
			ballNumber += 1;
		}
		this.balls = balls_10;
		return balls;
	}
	
	// choose ball one by one
	public Ball getOne() {
		Ball ball = null;
		Random r = new Random();
		while(true) {
			int index = r.nextInt(10);
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
	public Ball[] getFour() {
		Ball[] selectedBalls = new Ball[4];
		for(int i=0; i<4; i++) {
			selectedBalls[i] = this.getOne();
		}
		return selectedBalls;
		}
	}
	
	

	
	
		
	

