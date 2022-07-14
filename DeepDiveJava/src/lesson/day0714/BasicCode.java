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
	
	
	public void testWhile02() {
		// 소수 판별 
		int number = 10;
		boolean a = (number % 2) > 0;
		boolean b = (number % 3) > 0;
		if (a==true && b==true) {
			System.out.println("소수입니다");
		} else {
			System.out.println("소수가 아닙니다");
		}
	}
	
	
	public boolean isPrimeNumber(int input) {
		int number = input;
		int checker = 1;
		int counter = 0;
		while(true) {

			if(number%checker==0) {
				counter += 1;
			}
			checker++;
			if(checker==number+1) {
				break;
			}
		}
		if (counter == 2) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public void testWhile01(int input) {
		int number = input;
		int checker = 1;
		int counter = 0;
		while(true) {

			if(number%checker==0) {
				counter += 1;
			}
			checker++;
			if(checker==number+1) {
				break;
			}
		}
		if (counter == 2) {
			System.out.println("소수입니다");
		} else {
			System.out.println("소수가 아닙니다");
		}
	}

}
