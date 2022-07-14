package lesson.day0714;

public class BasicCode {
	public void testWhile() {
		int number = 123125;
		int total = 0;
		
		boolean isStop = false;
		
		while(!isStop) {
			int splitNumber = number % 10;
			System.out.println(splitNumber);
			total += splitNumber;
			number = number/10;
			
			if(number == 0) {
				isStop=true;
			}
		}
		System.out.println(total);
	}

}
