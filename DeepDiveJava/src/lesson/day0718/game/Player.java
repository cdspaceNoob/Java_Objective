package lesson.day0718.game;

import java.util.Scanner;

public class Player {
	/* field */
	private int[] number;
	private boolean isContinue;
	
	
	/* method */
	public void setNumber() {
		Scanner sc = new Scanner(System.in);
		int temp = sc.nextInt();
		number[0] = temp / 1000;
		number[1] = temp % 1000 / 100;
		number[2] = temp % 100 / 10;
		number[3] = temp % 10;
	}
	
	public int[] getNumber() {
		int[] playerNumber = this.number;
		return playerNumber;
	}
	
	
	public void setContinue() {
		Scanner sc = new Scanner(System.in);
		int checker = sc.nextInt();
		if (checker==0) {
			this.isContinue = false;
		}else if(checker==1){
			this.isContinue = true;
		}
	}
	
	public boolean isContinue() {
		return this.isContinue;
	}
	
}
