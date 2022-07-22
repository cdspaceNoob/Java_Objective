package lesson.day0722;
/* 데이터 클래스: 정보 은닉성의 규칙을 준수한다 */

public class Student {
	/* 
	 * 파일의 한 줄(11개의 정보)를 표현하는 클래스 설정
	 * stdNo, email, kor, eng, math, sci, hist, 
	 * total ,mgrCode, accCode, localCode 
	 */
	
	/* field */
	int stdNo;
	String email;
	int kor;
	int eng;
	int math;
	int sci;
	int hist;
	int total;
	String mgrCode;
	String accCode;
	String localCode;
	
	/* method */
	/* setters */
	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	};
	public void setEmail(String email) {
		this.email = email;
	};
	public void setKor(int kor) {
		this.kor = kor;
	};
	public void setEng(int eng) {
		this.eng = eng;
	};
	public void setMath(int math) {
		this.math = math;
	};
	public void setSci(int sci) {
		this.sci = sci;
	};
	public void setHist(int hist) {
		this.hist = hist;
	};
	public void setTotal(int total) {
		this.total = total;
	};
	public void setMgrCode(String mgrCode) {
		this.mgrCode = mgrCode;
	};
	public void setAccCode(String accCode) {
		this.accCode = accCode;
	};
	public void setlocalCode(String localCode) {
		this.localCode = localCode;
	};
	
	
	/* getters */
	public int getStdNo() {
		return this.stdNo;
	}	
	public String getEmail() {
		return this.email;
	}
	public int getKor() {
		return this.kor;
	}
	public int getEng() {
		return this.eng;
	}
	public int getMath() {
		return this.math;
	}
	public int getSci() {
		return this.sci;
	}
	public int getHist() {
		return this.hist;
	}
	public int getTotal() {
		return this.total;
	}
	public String getMgrCode() {
		return this.mgrCode;
	}
	public String getAccCode() {
		return this.accCode;
	}
	public String getLocalCode() {
		return this.localCode;
	}
	
	
}
