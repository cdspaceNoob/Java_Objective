package lesson.day0715.objective;

// 얘가 하나의 공이다 
public class LottoBall {
	// ball의 정보
	// 번호 정보 
	// 선택된 적이 있는지 
	private int number;
	private boolean selected;
	
	// 생성자 
	public LottoBall(int number){
		this.number = number;
	}
	
	
	public int getNumber() {
		return this.number;
	}
	
	
//	public void setNumber(int number) {
//		this.number = number;
//	}
	
	
	public boolean isSelected() {
		return this.selected;
	}
	
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
