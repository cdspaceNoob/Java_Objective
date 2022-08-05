package proto;

public class StudentVO {
	/* field */
	private int stdNo;
	private String stdName;
	private String stdMajor;
	private int stdAge;
	
	/* constructor */
	public StudentVO(String data) {
		String[] temp = data.split(",");
		stdNo = Integer.parseInt(temp[0].trim());
		stdName = temp[1].trim();
		stdMajor = temp[2].trim();
		stdAge = Integer.parseInt(temp[3].trim());
	}

	
	public int getStdNo() {
		return stdNo;
	}

	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getStdMajor() {
		return stdMajor;
	}

	public void setMajor(String major) {
		this.stdMajor = major;
	}

	public int getStdAge() {
		return stdAge;
	}

	public void setStdAge(int age) {
		this.stdAge = age;
	}/* getter setter */
	
	
	/* metohds */
	public void takeBook() {
		LibBusiness lb = new LibBusiness();
		
	}
	
	
	/* method */
}
