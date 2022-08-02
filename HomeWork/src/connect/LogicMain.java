package connect;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LogicMain {
	public static void main(String[] args) {
		
	}
	
	private ArrayList<VO> getFileData() throws IOException{
		ArrayList<VO> arrList = new ArrayList<VO>();
		
		File file = new File("./Abc1115.csv");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String line = null;
		VO vo = null;
		
		while((line=br.readLine())!=null) {
			vo = new VO(line);
			arrList.add(vo);
		}
		if(arrList.size() > 0) {
			System.out.println("file read");
		}
		br.close();
		fr.close();
		
		return arrList;
	}/* end of method getFileData() */
	
	
	
	
}/*end this class*/

