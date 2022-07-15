package lesson.day0715;
import java.util.Random;
public class Reactor {
	
	Random var = new Random();
	
	int arr[] = {0, 0, 0, 0, 0, 0};
	
	
	
	public void Run() {
		setArr();
	}
	
	
	public void setArr() {
		for(int j = 0; j < 6; j++) {
			int num = var.nextInt(45+1);
			boolean flag = false;
			for(int k = 0; k < j+1; k++) {
				if(num==arr[k]) {
					j--;
					break;
				}
			}if(!flag) {
				arr[j]=num;
			}
		}
		getNumbers();
	}
	
	
	
	public void setArr(int index, int number) {
		arr[index] = number;
	}
	
	
	
	public int getArr(int index) {
		return arr[index];
	}
	
	
	
	public void getNumbers() {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	
	
}
