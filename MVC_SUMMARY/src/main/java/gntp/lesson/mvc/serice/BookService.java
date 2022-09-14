package gntp.lesson.mvc.serice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
				if(name.equals("bookImage")) {
					String temp = item.getName();						// 실제 파일 이름
					System.out.println("temp:"+temp);
					// 특수문자(\) 처리 - windows
					int index = temp.lastIndexOf("/");
					String fileName = temp.substring(index+1);
					System.out.println(fileName);
					book.setBook_image(fileName);
					
//					boolean flag = dao.insertBook(book);
//					if(flag == true) {
						File filePath = new File(path+"/"+fileName);
						item.write(filePath);
//					}
					
				} else if(name.equals("bookAttach")) {
					String temp = item.getName();						// 실제 파일 이름
					String download = "/users/voyager/eclipse-workspace/eclipse-java/MVC_SUMMARY/src/main/webapp/download";
					factory.setRepository(new File(download));
					System.out.print("download temp: " + download);
					// 특수문자(\) 처리 - windows
					int index = temp.lastIndexOf("/");
					String fileName = temp.substring(index+1);
					System.out.println("download fileName:" + fileName);
					book.setBook_attachment(fileName);
					
//					boolean flag = dao.insertBook(book);
//					if(flag == true) {
						File filePath = new File(download+"/"+fileName);
						item.write(filePath);
//					}
				}
			}
		}
		return book;
	}//registBook()
	
	public void download(String fileName, HttpServletResponse resp) throws IOException {
		File download = new File("/users/voyager/eclipse-workspace/eclipse-java/MVC_SUMMARY/src/main/webapp/download/" + fileName);
		fileName = new String(fileName.getBytes("utf-8"), "ISO-8859-1");
		
		resp.setContentType("text/html; charset=utf-8");
		resp.setHeader("Cache-Control", "no-cache");
		resp.addHeader("Content-Disposition", "attachment; filename=" + fileName);
		
		FileInputStream fstream = new FileInputStream(download);
		OutputStream ostream = resp.getOutputStream();
		byte[] buffer = new byte[256];
		
		int len = 0;
		
		while((len=fstream.read(buffer)) != -1){
			ostream.write(buffer, 0, len);
		}
		ostream.close();
		fstream.close();
	}
}
