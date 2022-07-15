package lesson.day0715.objective;

public class Studio {
	
	private LottoMachine machine;
	
	public Studio() {
		machine = new LottoMachine();
	}
	
	public static void main(String[] args) {
		Studio mbc = new Studio();
		mbc.onAir();
	}
	
	public void onAir() {
		machine.setBalls(this.readyBalls());
		machine.startMachine();
	}
	
	public LottoBall[] readyBalls() {
		LottoBall[] balls = new LottoBall[45];
		int ballNumer = 1;
		for(int i=0; i<45; i++) {
			balls[i] = new LottoBall(ballNumer++);	
		}
	return balls;
	}
}
