package mvc.prac.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import mvc.prac.dao.BookDAO;
import mvc.prac.utils.ConnectionManager;
import mvc.prac.vo.BookVO;

public class BookService {
	
	// 도서 등록 
	public BookVO insertBook(ServletRequestContext req) throws Exception {
		BookVO book = null;
		BookDAO dao = new BookDAO();
		
		/* 파일 업로드에 관련된 설정은 DisFileItemFactory 클래스를 사용한다 */
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		/* 파일 경로는 절대경로를 사용해준다 */
		String imagePath 	= "/users/voyager/eclipse-workspace/eclipse-java/Mvc/src/main/webapp/images";
		String attachPath	= "/users/voyager/eclipse-workspace/eclipse-java/Mvc/src/main/webapp/download";
		/* 파일 경로 및 최대 크기를 factory에 설정 */
		factory.setRepository(new File(imagePath));
		factory.setSizeThreshold(1024*1024);
		
		/* 파일에 대한 설정을 매개변수로하여 ServletFileUpload 객체를 사용: 업로드 구현 */
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> list = upload.parseRequest(req);	// parseRequest는 매개변수를 FileItem형 리스트로 파싱
		
		book = new BookVO(); // book 객체를 생성하고 리턴할 준비
		
		/* FileItem 리스트를 Iterator로 읽으면서 File필드와 Form필드를 구별하고 해당 값을 지정한다 */
		for(FileItem item : list) {
			if(item.isFormField()) { 					// 만약 item이 File이 아닌 Form필드라면?
				String fieldName = item.getFieldName(); // form 태그에 종속된 input 태그의 name 속성을 받는다
				if(fieldName.equals("book_title")) {	// input 태그의 name 속성 값이 book_title이라면?
					book.setBook_title(item.getString("utf-8"));
				} else if(fieldName.equals("book_author")) {
					book.setBook_author(item.getString("utf-8"));
				} else if(fieldName.equals("book_price")) {
					book.setBook_price(Integer.parseInt(item.getString("utf-8")));
				}
			} else {									// 만약 item이 Form필드가 아닌 File이라면?
				String fName = item.getFieldName();
				if(fName.equals("book_image")) {
					String temp = item.getName();		// 실제 파일의 이름을 받는다 
					System.out.println("이미지파일명은: "+temp);
					
					/* 경로에 포함된 특수문자를 처리하고, 파일명만 남겨서 DB에 넣기 위한 가공 작업 */
					int index = temp.lastIndexOf("/");	// macOS: '/' 단위, windows: '\\' 단위 
					String fileName = temp.substring(index+1);
					System.out.println("book_image로 저장될 내용은: "+fileName);
					book.setBook_image(fileName);
					
					/* 파일의 경로를 지정해주고 그 위치에 업로드 실행 */
					File filePath = new File(imagePath+"/"+fileName);
					item.write(filePath);
				} else if(fName.equals("book_attachment")) {
					String temp = item.getName();
					System.out.println("첨부파일명은: "+temp);
					
					int index = temp.lastIndexOf("/");
					String attachName = temp.substring(index+1);
					System.out.println("book_attach로 저장될 내용은: "+attachName);
					book.setBook_attachment(attachPath);
					
					File filePath = new File(attachPath+"/"+attachName);
					item.write(filePath);
				}
			}
		}
		boolean flag = dao.insertBook(book);
		if(flag==false) {
			System.out.println("BookDAO insertBook Fail");
		}
		return book;
	}//insertBook()
	
	// 도서 리스트 조회 
	public ArrayList<BookVO> selectAll() throws SQLException{
		ArrayList<BookVO> list  = new ArrayList<BookVO>();
		
		String sql		 		= "select * from library";
		Connection con 			= ConnectionManager.getConnection();
		PreparedStatement stmt  = con.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			BookVO book = new BookVO();
			book.setBook_title(rs.getString("book_title"));
			book.setBook_author(rs.getString("book_author"));
			book.setBook_price(rs.getInt("book_price"));
			book.setBook_image(rs.getString("book_image"));
			book.setBook_attachment(rs.getString("book_attachment"));
			list.add(book);
		}
		
		return list;
	}//selectAll()
	
	// 다운로드 서비스 실행 
	public void download(String fileName, HttpServletResponse resp) throws IOException {
		File download = new File("/users/voyager/eclipse-workspace/eclipse-java/Mvc/src/main/webapp/download/"+fileName);
		fileName = new String(fileName.getBytes("utf-8"), "ISO-8859-1");
		
		resp.setContentType("text/html; charset=utf-8");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setHeader("Content-Disposition", fileName);
		
		FileInputStream fstream = new FileInputStream(download);
		OutputStream ostream 	= resp.getOutputStream();
		byte[] buffer 			= new byte[256];
		
		int len = 0;
		
		while((len=fstream.read(buffer)) != -1) {
			ostream.write(buffer, 0, len);
		}
		ostream.close();
		fstream.close();
	}//download()
	
}
