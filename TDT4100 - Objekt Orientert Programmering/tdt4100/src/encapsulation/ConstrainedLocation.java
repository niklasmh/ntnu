package encapsulation;

public class ConstrainedLocation {
	// Private
	private int x, y, minX, minY, maxX, maxY;
	
	// Public
	public ConstrainedLocation() {
		x = 0;
		y = 0;
		minX = 0;
		minY = 0;
		maxX = 10;
		maxY = 10;
	}
	
	public ConstrainedLocation(int x, int y, int minX, int minY, int maxX, int maxY) {
		this.x = x;
		this.y = y;
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
	}
	
	public void up() {
		if (isValidCoordinates(x, y-1)) {
			y--;
		}
	}
	
	public void down() {
		if (isValidCoordinates(x, y+1)) {
			y++;
		}
	}
	
	public void left() {
		if (isValidCoordinates(x-1, y)) {
			x--;
		}
	}
	
	public void right() {
		if (isValidCoordinates(x+1, y)) {
			x++;
		}
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean isValidCoordinates(int x, int y) {
		return (x <= maxX && x >= minX && y <= maxY && y >= minY);
	}
}