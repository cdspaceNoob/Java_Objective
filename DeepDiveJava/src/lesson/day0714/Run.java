package lesson.day0714;

public class Run {

	public static void main(String[] args) {
		
//		Month9 var_Month9 = new Month9();
//		var_Month9.viewMonth();
//		
//		System.out.println("\n");
//		
//		NbN var_NbN = new NbN();
//		var_NbN.viewNbN(2);
//		
//		System.out.println("\n");
//		
//		Summary var_sm = new Summary();
//		var_sm.viewSum();
//		
//		System.out.println("\n");
//		
//		var_sm.viewSummary();
		
		BasicCode bs = new BasicCode();
//		bs.testWhile();
		boolean flag = bs.isPrimeNumber(7);
		if (flag) {
			System.out.println("소수");
		} else {
			System.out.println("소수 아닙니다");
		}
	}

}
