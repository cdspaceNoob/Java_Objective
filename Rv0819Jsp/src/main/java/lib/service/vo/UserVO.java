package lib.service.vo;

public class UserVO {
	/* fields */
	private int stdNo;
	private String stdName;
	private String major;
	private int age;
	
	/* constructor */
	public UserVO(int stdNo, String stdName, String major, int age) {
		this.stdNo   = stdNo;
		this.stdName = stdName;
		this.major 	 = major;
		this.age 	 = age;
	}
	
	
	/* getter setter */
	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}
	public int getStdNo() {
		return this.stdNo;
	}
	
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdName() {
		return this.stdName;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	public String getMajor() {
		return this.major;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return this.age;
	}
}
