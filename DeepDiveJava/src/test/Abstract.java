package test;

public class Abstract {
	
	
	public abstract class Abs{
		int a;
		int b;
		
		public void abs() {
			
		}
	}
	
	
	public class Bcd extends Abs{
		@Override
		public void abs() {
			System.out.println(a+b);
		}
	}
	

	
}
