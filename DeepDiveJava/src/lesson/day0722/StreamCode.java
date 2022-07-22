package lesson.day0722;

import java.io.BufferedReader;
import java.io.File;
// import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import lesson.day0720.DateTimeService;
import lesson.day0720.DateTimeServiceType;

public class StreamCode {
	
	public void readFile() throws IOException {
		System.out.println("readFile");
		
		// 파일의 기본 정보만 가진 상태(파일 겉면). 예: 이름, 확장자, 크기, 위치 등... 
		File file = new File("./Abc1115.csv");
		
		// 파일의 실제 내용(Content)을 읽고자 한다. 
		// 그러나 file의 정체를 모르기 때문에 예외 발생 가능성이 있다. 
		// 따라서, 여기서 throws ExcpetionName 을 메서드에 붙여서 처리한다.
		// 이로 인해 던져지는 예외유형은, 이 메서드를 호출하는 스크립트에서 try로 처리한다.
		FileReader fr = new FileReader(file);	 
		
		// 한 줄씩 읽기. fileReader는 content를 가지고 있다. content를 읽는다.
		BufferedReader br = new BufferedReader(fr); 
		String line = null;
		
		while((line=br.readLine())!=null){
			System.out.println(line);
		}
		br.close(); // 나중에 열린 스트림을 먼저 닫는다 
		fr.close(); 
	}/* end readFile() */
	
	
	public void writeFile() throws IOException {
		// 없는 파일이면 알아서 생성해준다.
		File file = new File("./writeTest.txt");
		
		// IOException이 발생한다. 위의 readFile과 같은 원리다. (파일의 무결성 문제)
		// 일단 예외를 던져 둔다. 
		// 파일을 만들어두기만 한 상태이며 content는 존재하지 않는다. 
		FileWriter fw = new FileWriter(file); 
		
		// PrintWriter로 content를 작성할 수 있다. 
		// 파라미터에는 content를 넣을 파일 객체를 넣는다. 
		PrintWriter pw = new PrintWriter(fw);
		
		DateTimeService dts = new DateTimeService();
		//pw.println("hello");
		
		// 준비된 PrintWriter로 파라미터 내의 content를 대상 객체 내부에 작성한다. 
		pw.println(dts.getDateTimeV2(DateTimeServiceType.DATE_ONLY));
		
		pw.close();
		fw.close();
	}/* end wirteFile() */
	
	
	public void readAndWriteFile() throws IOException {
		// 읽을 파일 정하기. 
		File fromFile = new File("./Abc1115.csv");
		File toFile = new File("./test.txt");
		
		// 파일에서 내용 읽어들이는 스트림 생성. 
		FileReader frFrom = new FileReader(fromFile);	
		// 내용을 읽어들일 스트림 생성. 
		BufferedReader brFrom = new BufferedReader(frFrom); 
		
		// 내용을 작성하는 스트림 생성.
		FileWriter fwFrom = new FileWriter(toFile);
		// 작성한 내용을 내보내는 스트림 생성. 
		PrintWriter pwFrom = new PrintWriter(fwFrom);
		
		String line = null;
		
		// 내용을 읽어들이는 스트림에서 한 줄씩 읽는 메소드 선택.
		while((line=brFrom.readLine())!=null){
			// 내용을 내보내는 스트림에서 내용을 내보낸 후 한 줄을 띄우는 메소드 선택. 
			pwFrom.println(line);
		}
		frFrom.close();
		fwFrom.close();
		pwFrom.close();
		brFrom.close();
	}/* end readAndWriteFile*/
	
	
}
