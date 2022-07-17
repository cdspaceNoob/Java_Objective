package lesson.day0715.practice.lotto;

public class Studio {
	private Machine machine;
	public Studio(){
		machine = new Machine();
	}
	public static void main(String[] args) {
		Studio studio = new Studio();
		studio.setMachine();
	}
	
	
	public void setMachine() {
		machine.insertBalls();
		machine.startMachine();
	}
	
	
	

}
