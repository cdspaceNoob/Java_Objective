package lesson.day0718.game;

public class Ball {
	private int ballNumber;
	private boolean isSelected;
	
	public int getNumber() {
		return this.ballNumber;
	}
	
	public boolean isSelected() {
		return this.isSelected;
	}
	
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
}
