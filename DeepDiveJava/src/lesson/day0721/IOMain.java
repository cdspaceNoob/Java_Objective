package lesson.day0721;

import java.io.FileNotFoundException;
import java.io.IOException;

public class IOMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IOMain main = new IOMain();
		main.test1();
	}
	
	public void test1() {
		CodeIO ci = new CodeIO();
		try {
			ci.readFile();
		}catch(FileNotFoundException fe){
			System.out.println("file not exitst");
		}catch(IOException ie) {
			System.out.println("failed to read file");
		}
				
	}

}
