package stateandbehavior;

public class Location {
	public int x;
	public int y;
	
	public void up() {
		y--;
	}
	
	public void down() {
		y++;
	}
	
	public void left() {
		x--;
	}
	
	public void right() {
		x++;
	}
	
	public static void main(String[] args) {
		Location loc = new Location();
		System.out.println(loc.x); // 0, 0
		loc.up();
		System.out.println(loc.x);
		loc.right();
		System.out.println(loc.x);
		loc.down();
		System.out.println(loc.x);
		loc.left();
		System.out.println(loc.x); // 0, 0
	}
}
