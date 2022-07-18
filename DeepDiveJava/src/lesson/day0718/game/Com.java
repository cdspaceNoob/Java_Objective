package lesson.day0718.game;
import java.util.Random;

public class Com {
	/* field */
	private Ball[] balls;
	
	// choose ball one by one
	public Ball getBall() {
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
	public Ball[] selectedBalls2() {
		Ball[] selectedBalls = new Ball[4];
		for(int i=0; i<4; i++) {
			selectedBalls[i] = this.getBall();
		}
		return selectedBalls;
		}
	}
	
	

	
	
		
	

