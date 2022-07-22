package lesson.day0721;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CodeIO {
	public void readFile() throws FileNotFoundException, IOException {
		File file = new File("./Abc1115.csv");
		/* file has no contents data */
		boolean flag = file.exists();
		if(flag) {
			System.out.println("file exists");
			long size = file.length();
			String name = file.getName();
			System.out.println(size+","+name);
			
			/* read contents data */
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
			br.close(); /* 나중에 열린 것을 먼저 닫는다 */ 
			fr.close();
		}else {
			System.out.println("no file exists");
		}
	}
}
