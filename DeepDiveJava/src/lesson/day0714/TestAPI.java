package lesson.day0714;

import java.util.Random;

public class TestAPI {
	public void TestAPI() {
	Random var = new Random();
		for(int i=0; i<6+1; i++) {
			int number = var.nextInt(45); /* 출력의 범위는 0 <= number <45 */
			System.out.println(number);
		}
	}
}
