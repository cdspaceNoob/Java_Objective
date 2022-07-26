package test;

class AutoUnboxing {
	public static void main(String[] args){
			/* Integer 객체 생성: 값은 10 */
			//Integer i = new Integer(10);
			Integer intVal = Integer.valueOf(10);
	
			/* Wrapper 클래스 타입을 원시 타입의 변수로 할당 */
			int intI = intVal;

			System.out.println("Value of i: " + intVal);
			System.out.println("Vluae of intI: " + intI);
			
			System.out.println("Type of i: " + intVal.getClass().getName());
			//System.out.println("Type of intI: " + intI.getName()); // Cannot invoke getName() on the primitive type int
	}
}