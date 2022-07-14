package lesson.day0714;

public class NbN {
	public void viewNbN(int number) {
		int step = number;
		for (int i = 1; i < 9+1; i++) {
			System.out.println(step+"*"+i+"="+(step*i));
		}
	}
}
