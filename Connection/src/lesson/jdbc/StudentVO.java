package lesson.jdbc;

public class StudentVO {
	/* field */
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
	
	/* constructor */
	public StudentVO(String data) {
		String[] temp = data.split(",");
			stdNo = Integer.parseInt(temp[0].trim());
			email = "'"+temp[1].trim()+"'";
			kor = Integer.parseInt(temp[2].trim());
			math = Integer.parseInt(temp[3].trim());
			eng = Integer.parseInt(temp[4].trim());
			sci = Integer.parseInt(temp[5].trim());
			hist = Integer.parseInt(temp[6].trim());
			total = Integer.parseInt(temp[7].trim());
			mgrCode = "'"+temp[8].trim()+"'";
			accCode = "'"+temp[9].trim()+"'";
			locCode = "'"+temp[10].trim()+"'";
	}
	
	/* Getter & Setter */
	public int getStdNo() {
		return stdNo;
	}

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
	}
	
	/* methods */
	
}
