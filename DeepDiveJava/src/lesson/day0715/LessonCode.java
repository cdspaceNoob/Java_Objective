package lesson.day0715;

import java.util.Random;

public class LessonCode {
	
	public void checkSameNumber() {
		Random var = new Random();
		
		// 중복 허용 
		/*
		for(int i = 0; i < 6; i++) {
			int number = var.nextInt(45);
			System.out.println(number);
		}
		*/
		
		// 중복 제거
		int[] intArr = {0, 0, 0, 0, 0, 0};
		for(int j = 0; j < 6; j++) {
			int num = var.nextInt(45+1);
			boolean flag = false;
			for(int k = 0; k < j+1; k++) {
				if(num==intArr[k]) {
					j--;
					break;
				} 
			} if(!flag) {
				intArr[j] = num;
			}
		} 
		for(int l = 0; l < 6; l++) {
			System.out.println(intArr[l]);
		}
		
	}

}
