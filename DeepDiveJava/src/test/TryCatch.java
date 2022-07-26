package test;

public class TryCatch {
	int intVal;
	String strVal;
			
	public static void main(String[] args) {
		TryCatch tc = new TryCatch();
		int result;
		tc.intVal = 3;
		tc.strVal = "ok";
		try {
			boolean flag = (tc.intVal > tc.strVal); 
		}catch{
			System.out.println("incorrect");
		}
	}
}
