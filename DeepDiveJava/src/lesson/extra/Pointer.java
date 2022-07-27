package lesson.extra;

public class Pointer {
	private int x;
	private int y;
	
	public Pointer(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return x+" "+y;
	}
	
	// 가지고 있는 값이 같은지 
	@Override
	public boolean equals(Object obj) {
		boolean flag = false;
		Pointer p = (Pointer)obj;
		if(p.getX()==x && p.getY()==y) {
			flag = true;
		}
		return flag;
	}
	
	// 동일한 객체인지 (참조하는 주소값이 동일한지)
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
