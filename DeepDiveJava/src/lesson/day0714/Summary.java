package lesson.day0714;
import java.util.Scanner;

public class Summary {

	
	// 숫자 입력 받아놓는 메소드 
	public int numReceiver() {
		int number = 0;
		try (Scanner var = new Scanner(System.in)) {
			number = var.nextInt();
		}
		return number;
	}
	
	
	// 결과를 출력해주는 메소드 
	public void printer(int result) {
		System.out.println(result);
	}
	
	
	// 1부터 100까지 합계를 연산하고 그 결과를 가지는 메소드 
	public int returnSum() {
		int sum = 0;
		for(int i = 1; i < 100+1; i++) {
			sum += i;
		}
		return sum;
	}
	
	
	// returnSum의 반환값을 출력하는 메소드 
	public void viewSum() {
		int result = this.returnSum();
		this.printer(result);
//		System.out.println(result);
	}
	
	
	// numReceiver를 호출하여 값을 받고 합계를 연산하고 그 결과를 가지는 메소드 
	public int returnSummary() {
		int n = this.numReceiver();
		int sum_summary = 0;
		for (int i = 0; i < n; i++) {
			sum_summary += i;
		}
		return sum_summary;
	}
	
	
	// returSummary의 반환값을 출력하는 메소드 
	public void viewSummary() {
		int result = this.returnSummary();
		this.printer(result);
//		System.out.println(result);
	}
	
	
	
	

}
