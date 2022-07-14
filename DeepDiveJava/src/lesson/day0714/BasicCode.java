package lesson.day0714;

public class BasicCode {
	public void testWhile() {
		int number = 123125;
		int total = 0;
		
		while(true) {
			int splitNumber = number % 10;
			System.out.println(splitNumber);
			total += splitNumber;
			number = number/10;
			
			if(number == 0) {
				break;
			}
		}
		System.out.println(total);
	}

}
