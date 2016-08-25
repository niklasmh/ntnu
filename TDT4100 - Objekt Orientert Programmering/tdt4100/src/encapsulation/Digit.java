package encapsulation;

public class Digit {
	// Private
	private int numberSystem, number;
	
	// Public
	public Digit(int system) {
		if (system > 0) {
			this.numberSystem = system;
		} else {
			this.numberSystem = 10;
			throw new IllegalArgumentException("Base must be positive.");
		}
		
		this.number = 0;
	}
	
	public int getValue() {
		return this.number;
	}
	
	public int getBase() {
		return this.numberSystem;
	}
	
	public boolean increment() {
		this.number++;
		
		if (this.number >= numberSystem) {
			this.number = 0;
			return true;
		}
		
		return false;
	}
	
	public String toString() {
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		return chars.charAt(this.number) + "";
	}
	
	public static void main(String[] args) {
		Digit d = new Digit(16);
		d.increment();
		System.out.println(d.getValue());
		System.out.println(d);
		d.number = 9;
		System.out.println(d.getValue());
		System.out.println(d);
		d.increment();
		System.out.println(d.getValue());
		System.out.println(d);
	}
}