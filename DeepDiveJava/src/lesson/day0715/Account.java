package lesson.day0715;

public class Account {
	private int balance;
	
	// Getter
	public int getBalance() {
		return this.balance;
	}
	
	// Setter
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	// 입금 Method
	public void deposit(int amount) {
		this.balance += amount;
	}
	
	// 출금 Method
	public void withdraw(int amount) {
		this.balance -= amount;
	}

}
