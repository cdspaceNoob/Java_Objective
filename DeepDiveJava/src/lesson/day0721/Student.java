package lesson.day0721;

public class Student {
	private String name;
	private int sno;
	
	public Student(String name, int sno) {
		this.name = name;
		this.sno = sno;
	}
	
	
	public String getName() {
		return this.name;
	}
	public int getSno() {
		return this.sno;
	}
	/* end getter */
	
	public void setName(String name) {
		this.name = name;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	/* end setter */
	
}
