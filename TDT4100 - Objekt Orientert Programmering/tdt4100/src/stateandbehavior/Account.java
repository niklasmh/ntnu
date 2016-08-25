package stateandbehavior;

public class Account {
	public double balance;
	public double interestRate;
	
	public Account() {
		balance = 0;
		interestRate = 15.5;
	}
	
	public Account(double b, double ir) {
		if (b > 0 && ir > 0) {
			balance = b;
			interestRate = ir;
		}
	}
	
	public void deposit(double depositAmount) {
		if (depositAmount > 0) {
			balance += depositAmount;
		}
	}
	
	public void addInterest() {
		balance *= 1. + interestRate/100;
	}
	
	public void setInterestRate(double rate) {
		interestRate = rate;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public String toString() {
		return "Kontoen har " + balance 
				+ " i balanse og " + interestRate 
				+ " i interesse rate.";
	}
	
	public static void main(String[] args) {
		Account account = new Account();
		account.deposit(100);
		System.out.println(account);
		account.addInterest();
		System.out.println(account);
	}
}