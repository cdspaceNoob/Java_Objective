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
		DiskFileItemFactory factory = new DiskFileItemFactory();	// 그냥 파일 업로드할 때 쓰는 거임(약속)
		String path = "./images";
		factory.setRepository(new File(path));						// 그냥 파일 업로드할 때 약속된 거 잡아주는 거임
		factory.setSizeThreshold(1024*1024);						// 그냥 파일 업로드할 때 약속된 거 잡아주는 거임
		ServletFileUpload upload = new ServletFileUpload(factory);	// 그냥 파일 업로드할 때 쓰는 거임(약속2)
		List<FileItem> list = upload.parseRequest(req); 			// Fileitem은 form의 input태그 그 자체 및 속성들을 의미한다
		book = new BookVO();
		for(FileItem item : list) {
			if(item.isFormField()) {
				String fieldName = item.getFieldName(); 			// FieldName은 form의 name 속성을 의미 
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
				System.out.println(temp);
				// 특수문자(\) 처리 
				int index = temp.lastIndexOf("\\");
				String fileName = temp.substring(index+1);
				System.out.println(fileName);
				book.setBook_image(fileName);
				
				boolean flag = dao.insertBook(book);
				if(flag) {
					File filePath = new File(path+"\\"+fileName);
					item.write(filePath);
				}
			}
		}
		return book;
	}//registBook()
}
