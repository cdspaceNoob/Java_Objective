package day;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class CsvReader {
	
	public static ArrayList<BookVO> BookReader() throws IOException, SQLException {
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		File file = new File("./book.csv");
		// ↓↓↓
		boolean flag = file.exists();
		if(flag) {
		FileReader fr = new FileReader(file);
		// ↓↓↓
		BufferedReader br = new BufferedReader(fr);
		// ↓↓↓
		String line = null;
		while((line=br.readLine()) != null) {
			 list.add(new BookVO(line));
		}
		
		csvInsert.BookInsert(list);
		br.close();
		fr.close();
		} else {
		System.out.println("file not exist");
		}
		return list;
	}
	
	public static ArrayList<StudentVO> StudentReader() throws IOException, SQLException {
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();
		File file = new File("./student.csv");
		// ↓↓↓
		boolean flag = file.exists();
		if(flag) {
		FileReader fr = new FileReader(file);
		// ↓↓↓
		BufferedReader br = new BufferedReader(fr);
		// ↓↓↓
		String line = null;
		while((line=br.readLine()) != null) {
			list.add(new StudentVO(line));
		}
		
		csvInsert.StudentInsert(list);
		br.close();
		fr.close();
		} else {
		System.out.println("file not exist");
		}
		return list;
	}
}
