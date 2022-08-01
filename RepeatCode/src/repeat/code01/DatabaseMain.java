package repeat.code01;

import java.util.ArrayList;

public class DatabaseMain {
	public static void main(String[] args) {

	}
	
	/* 준비한 데이터(by getReadFile)를 데이터 접근 객체에게 처리 요청 */
	public void InsertDataAll() {
		/* 메인에서는 객체 생성과 호출 정도만 / 로직은 나머지 메서드에서 처리해준다 */
		ArrayList<StudentVO> list = this.getReadFile();
		GisaDAO dao = new GisaDAO();
	}
	
	private ArrayList<StudentVO> getReadFile(){
		return null;
	}
	
	
}
