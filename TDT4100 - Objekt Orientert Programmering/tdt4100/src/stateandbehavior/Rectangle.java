package stateandbehavior;

import java.lang.Math;

public class Rectangle {
	int X1 = 0, Y1 = 0, X2 = 0, Y2 = 0;
	
	public boolean add(int x, int y) {
		
		boolean changed = false;
		
		if (x < getMinX()) {
			
			if (X1 < X2) {
				X1 = x;
			} else {
				X2 = x;
			}
			
			changed = true;
		}
		
		if (y < getMinY()) {
			
			if (Y1 < Y2) {
				Y1 = y;
			} else {
				Y2 = y;
			}
			
			changed = true;
		}
		
		if (x > getMaxX()) {
			
			if (X1 > X2) {
				X1 = x;
			} else {
				X2 = x;
			}
			
			changed = true;
		}
		
		if (y > getMaxY()) {
			
			if (Y1 > Y2) {
				Y1 = y;
			} else {
				Y2 = y;
			}
			
			changed = true;
		}
		
		return changed;
	}
	
	public boolean add(Rectangle rect) {
		
		int x1 = rect.getMinX(),
			x2 = rect.getMaxX(),
			y1 = rect.getMinY(),
			y2 = rect.getMaxY();
		
		return (add(x1, y1) || add(x1, y2) || add(x2, y2) || add(x2, y1)); 
	}
	
	public int getMinX() {
		return Math.min(X1, X2);
	}
	
	public int getMaxX() {
		return Math.max(X1, X2);
	}
	
	public int getMinY() {
		return Math.min(Y1, Y2);
	}
	
	public int getMaxY() {
		return Math.max(Y1, Y2);
	}
	
	public int getWidth() {
		return Math.abs(X2 - X1);
	}
	
	public int getHeight() {
		return Math.abs(Y2 - Y1);
	}
	
	public boolean isEmpty() {
		return ((X2-X1) * (Y2-Y1) == 0);
	}
	
	public Rectangle union (Rectangle rect) {
		return rect;
	}
	
	public boolean contains(int x, int y) {
		
		if (x > getMinX() && x < getMaxX()) {
			if (y > getMinY() && y < getMaxY()) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean contains(Rectangle rect) {
		
		if (isEmpty()) {
			return false;
		}
		
		int x1 = rect.getMinX(),
			x2 = rect.getMaxX(),
			y1 = rect.getMinY(),
			y2 = rect.getMaxY();
		
		if (contains(x1, y1) && contains(x1, y2)
			&& contains(x2, y2) && contains(x2, y1)) {
			return true;
		}
		
		return false;
	}
}