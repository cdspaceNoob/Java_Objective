package lesson.day0802;

public class StudentVO {
	/* fields */
	private int stdNo;
	private String email;
	private int kor;
	private int math;
	private int eng;
	private int sci;
	private int hist;
	private int total;
	private String mgrCode;
	private String accCode;
	private String locCode;
	public int getStdNo() {
		return stdNo;
	}
	
	/* constructor */
	public StudentVO() {
		
	}
	
	/* constructor */
	public StudentVO(int stdNo, String email, int kor, int eng, int math, int sci, int hist, int total, 
			String mgrCode, String accCode, String locCode) {
		//super(); 생략해도 가장 먼저 호출된다  
		this.stdNo = stdNo;
		this.email = email;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
		this.sci = sci;
		this.hist = hist;
		this.total = total;
		this.mgrCode = mgrCode;
		this.accCode = accCode;
		this.locCode = locCode;
	}

	/* Getter & Setter */
	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getSci() {
		return sci;
	}
	public void setSci(int sci) {
		this.sci = sci;
	}
	public int getHist() {
		return hist;
	}
	public void setHist(int hist) {
		this.hist = hist;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getMgrCode() {
		return mgrCode;
	}
	public void setMgrCode(String mgrCode) {
		this.mgrCode = mgrCode;
	}
	public String getAccCode() {
		return accCode;
	}
	public void setAccCode(String accCode) {
		this.accCode = accCode;
	}
	public String getLocCode() {
		return locCode;
	}
	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}/* end of Getter & Setter */
	
	/* methods */
	public int getQuiz01Data() {
		return this.kor + this.eng;
	}


	@Override
	public String toString() {
		return "stdno="+this.getStdNo()+", "+"Quiz01 result ="+this.getQuiz01Data();
	}
	
}/* end */
