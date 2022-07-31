package practice.exception;

public class CatchCaseByCase {
	public static void main(String[] args) {
		try {
			String data1 = args[0];
			String data2 = args[1];
			int intVal1 = Integer.parseInt(data1);
			int intVal2 = Integer.parseInt(data2);
			int result = intVal1 + intVal2;
			System.out.println(data1+"+"+data2+"="+result);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("매개값 수가 부족합니다");
		} catch(NumberFormatException e) {
			System.out.println("숫자로 변환할 수 없습니다");
		} finally {
			System.out.println("다시 실행하세요");
		}
	}
}
