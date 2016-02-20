package encapsulation;

public class Account {
	private double balance, interestRate;
	
	public Account() {
	}
	
	public Account(double b, double ir) {
		if (b > 0 && ir > 0) {
			balance = b;
			interestRate = ir;
		} else {
			throw new IllegalArgumentException("Both deposit and rate must be positive.");
		}
	}
	
	public void deposit(double depositAmount) {
		if (depositAmount > 0) {
			balance += depositAmount;
		} else {
			throw new IllegalArgumentException("Deposit can just add positive numbers.");
		}
	}
	
	public void addInterest() {
		balance *= 1. + interestRate/100;
	}
	
	public void setInterestRate(double rate) {
		if (rate > 0) {
			interestRate = rate;
		} else {
			throw new IllegalArgumentException("Rate must be positive.");
		}
	}
	
	void withdraw(double withdrawAmount) {
		if (withdrawAmount > 0) {
			if (this.balance >= withdrawAmount) {
				this.balance -= withdrawAmount;
			} else {
				throw new IllegalStateException("Beløpet går negativt.");
			}
		} else {
			throw new IllegalArgumentException("Kan ikke trekke ifra negativt. Bruk deposit hvis du skal legge til.");
		}
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