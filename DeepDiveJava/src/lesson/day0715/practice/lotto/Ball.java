package lesson.day0715.practice.lotto;

public class Ball {
	// 공 객체는 정보를 가지고 있다: 공 번호와 선택되었는지 여부  
	private int number;
	private boolean isSelected;
	
	// 필드를 바탕으로 생성자 정해주기: 공 번호는 사후 조작될 수 없어야만 한다 
	public Ball(int number) {
		this.number = number;
	}
	
	// 기계 객체가 너 뭐하는 놈이니 말을 걸어왔을 때 대답할 수 있어야 한다 
	// 이게 내 번호다 
	public int getNumber() {
		return this.number;
	}
	// 이건 내가 호명되었는지 아니 되었는지에 관한 거다 
	public boolean isSelected() {
		return this.isSelected;
	}
	
	// 기계 객체가 '너 호명됐다' 알려주면 받아적어 놓아야 한다 
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	
}
