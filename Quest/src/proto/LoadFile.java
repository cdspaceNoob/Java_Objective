package proto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadFile {
	
	public ArrayList<StudentVO> getStudentFile() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<StudentVO> list = null;
		list = new ArrayList<StudentVO>();

		File file = new File("./Studentlist.csv");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line= null;
		StudentVO vo = null;
		while((line=br.readLine())!=null) { 
			//System.out.println(line);
			vo = new StudentVO(line);
			list.add(vo);
		}
		br.close();
		fr.close();
		return list;
	}/* END getStudentFile() */
	
	public ArrayList<BookVO> getBookFile() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<BookVO> list = null;
		list = new ArrayList<BookVO>();

		File file = new File("./Booklist.csv");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line= null;
		BookVO vo = null;
		while((line=br.readLine())!=null) { 
			//System.out.println(line);
			vo = new BookVO(line);
			list.add(vo);
		}
		br.close();
		fr.close();
		return list;
	}/* END getBookFile() */
}
