package test;

public class DataType {
	public static void main(String[] args) {
		byte a0 = 0;
		short a1 = 0;
		char a2 = 0;
		int a4 = 0;
		long a5 = 0;
		float a6 = 0;
		double a7 = 0;
		
		//wrapper는 읽기 전용이다 valueOf로 한 번 마들어 놓으면 변경할 수 없다 

		Integer a = new Integer(4);
		String str = new String("this is str");
		Short s = new Short((short) 5);
	}

}
