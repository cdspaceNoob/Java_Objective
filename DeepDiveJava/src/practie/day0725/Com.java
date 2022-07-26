package practie.day0725;

import java.util.ArrayList;
import java.util.Random;

public class Com {
	/* 게임이 시작되면 네 자리의 중복되지 않는 숫자 볼 배합 생성 */
	/* getter로 가져갈 수 있게 해주기 */
	
	/* field */
	// 0부터 9까지 숫자를 여기서 뽑을 것임 
	private ArrayList<Integer> Number;
	// 여기는 네 자리의 숫자가 저장될 것임 
	private int[] comNumber;
	
	/* method */
	/* getter */
	public int[] getComNumber() {
		return this.comNumber;
	}
	
	/* 숫자 생성 시작 */
	public void makeComNumber() {
		// 0부터 9까지 숫자 상자 만들기 
		for(int i=0; i<10; i++) {
			this.Number.add(i);
		}
		// 여기서 랜덤 인덱스의 숫자 선택하여
		// comNumber 배열에 4회 넣을 것임
		for(int i=0; i<4; i++) {
			Random r = new Random();
			int index = r.nextInt(10);
			comNumber[i] = Number.get(index);		
		}
	}
	
	
	
	
	
	
	
	
}

	
	
	
	
	

