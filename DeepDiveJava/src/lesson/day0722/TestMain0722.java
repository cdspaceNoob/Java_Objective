package lesson.day0722;
import java.io.IOException;
public class TestMain0722 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestMain0722 tm0722 = new TestMain0722();
		tm0722.streaming();
		}/* end main */
	
	
	public void streaming(){
		StreamCode sc = new StreamCode();
		try {
//			sc.readFile(); // 메서드를 호출하는 곳은 여기고, 메서드의 IOException을 처리해야 한다
			 sc.readAndWriteFile();
		}catch(IOException ie){
			System.out.println("파일 호출에 문제가 있습니다");
		}
		//sc.readFile(); // 메서드를 호출하는 곳은 여기고, 메서드의 IOException을 처리해야 한다 
	}
	
	
	
}	


