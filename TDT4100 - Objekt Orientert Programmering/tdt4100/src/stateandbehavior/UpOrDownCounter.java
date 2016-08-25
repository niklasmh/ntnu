package stateandbehavior;

public class UpOrDownCounter {
	int counter, start, end;
	
	public UpOrDownCounter(int start, int end) {
		if (start == end) {
			throw new IllegalArgumentException("Start og slutt kan ikke være like"); 
		}
		this.start = start;
		this.start = counter;
		this.end = end;
	}
	
	public int getCounter() {
		return this.counter;
	}
	
	public boolean count() {
		//this.counter += (this.start < this.end ? 1 : -1);
		return (this.counter == this.end);
	}
}