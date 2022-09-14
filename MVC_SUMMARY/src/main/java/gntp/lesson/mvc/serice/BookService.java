package gntp.lesson.mvc.serice;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import gntp.lesson.mvc.dao.BookDAO;
import gntp.lesson.mvc.vo.BookVO;

public class BookService {
	
	public BookVO registBook(ServletRequestContext req) throws Exception {
		BookVO book = null;
		BookDAO dao = new BookDAO();
		DiskFileItemFactory factory = new DiskFileItemFactory();	
//		String path = "/users/voyager/images";
		String path = "/users/voyager/eclipse-workspace/eclipse-java/MVC_SUMMARY/src/main/webapp/images";
		factory.setRepository(new File(path));						
		factory.setSizeThreshold(1024*1024);						
		ServletFileUpload upload = new ServletFileUpload(factory);	
		List<FileItem> list = upload.parseRequest(req); 			
		book = new BookVO();
		for(FileItem item : list) {
			if(item.isFormField()) {
				String fieldName = item.getFieldName(); 			 
				if(fieldName.equals("bookTitle")) {
					book.setBook_title(item.getString("utf-8"));
				} else if(fieldName.equals("bookAuthor")) {
					book.setBook_author(item.getString("utf-8"));
				} else if(fieldName.endsWith("bookPrice")) {
					book.setBook_price(Integer.parseInt(item.getString("utf-8")));
				}
			} else {
				String name = item.getFieldName();
				String temp = item.getName();						// 실제 파일 이름
				System.out.println("temp:"+temp);
				// 특수문자(\) 처리 
				int index = temp.lastIndexOf("/");
				String fileName = temp.substring(index+1);
				System.out.println(fileName);
				book.setBook_image(fileName);
				
//				boolean flag = dao.insertBook(book);
//				if(flag) {
					File filePath = new File(path+"/"+fileName);
					item.write(filePath);
//				}
			}
		}
		return book;
	}//registBook()
}
