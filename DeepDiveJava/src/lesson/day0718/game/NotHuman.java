package lesson.day0718.game;
import java.util.Random;
public class NotHuman {
	/* field */
	private int[] numNh;
	
	public NotHuman() {
		this.numNh  = new int[4];
	}
	
	/* method */
	public void abc() {	
		Random r = new Random();
		RanNum rn = new RanNum();
		rn = null;
		int[] box = new int[10];
		for(int i=0; i<4; i++) {
			while(true) {
				int temp = r.nextInt(10);
				box[i] = temp;
				if()
			}
		}
	}
}
