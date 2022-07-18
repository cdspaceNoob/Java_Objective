package lesson.day0718.game;
import java.util.Scanner;
public class Human {
	/* field */
	private int[] numArr;
	
	public Human() {
		this.numArr = new int[4];
	}
	
	/* method */
	public void setNumArr() {
		Scanner sc = new Scanner(System.in);
		int temp = sc.nextInt();
		this.numArr[0] = temp/1000;
		this.numArr[1] = temp%1000/100;
		this.numArr[2] = temp%100/10;
		this.numArr[3] = temp%10;
	}
	
	public int[] getNumArr() {
		return this.numArr;
	}
	
	
}
