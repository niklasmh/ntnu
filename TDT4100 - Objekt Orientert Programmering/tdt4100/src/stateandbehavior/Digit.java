package stateandbehavior;

public class Digit {
	public int numberSystem, number;
	
	public Digit(int system) {
		this.numberSystem = (system > 0 ? system : 0);
		this.number = 0;
	}
	
	public int getValue() {
		return this.number;
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