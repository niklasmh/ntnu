package stateandbehavior;

import no.hal.jex.runtime.JExercise;
import junit.framework.TestCase;

@JExercise(
		description="A Rectangle is a ..."
		)
public class RectangleTest extends TestCase {

	private Rectangle rect;
	
	@Override
	protected void setUp() throws Exception {
		rect = new Rectangle();
	}
	
	private void assertValues(Rectangle rect, int minX, int minY, int maxX, int maxY, int w, int h) {
		assertEquals(minX, rect.getMinX());
		assertEquals(minY, rect.getMinY());
		assertEquals(maxX, rect.getMaxX());
		assertEquals(maxY, rect.getMaxY());
		assertEquals(w, rect.getWidth());
		assertEquals(h, rect.getHeight());
	}
	
	private void assertEmpty(Rectangle rect) {
		assertTrue(rect.isEmpty());
		assertFalse(rect.contains(0, 0));
		assertValues(rect, 0, 0, 0, 0, 0, 0);
	}
	
	@JExercise(tests="Rectangle()", description="Tests the default/empty constructor. This should give an empty Rectangle with min/max x/y values equal to 0.")
	public void testRectangle() {
		assertEmpty(this.rect);
	}

	private void testAdd(Rectangle rect, int x, int y, Boolean expected) {
		boolean result = rect.add(x, y);
		if (expected != null) {
			assertEquals(expected.booleanValue(), result);
		}
		assertFalse(rect.isEmpty());
		assertTrue(rect.contains(x, y));
	}
	
	@JExercise(tests="boolean add(int,int)", description="Tests add(x,y) on an empty Rectangle.")
	public void testAddXYToEmpty() {
		int x = 13, y = -27;
		testAdd(this.rect, x, y, true);
		assertValues(this.rect, x, y, x, y, 1, 1);
	}
	
	@JExercise(tests="boolean add(int,int)", description="Tests add of several points.")
	public void testAddXY() {
		int x1 = 13, y1 = -27;
		int x2 = -11, y2 = 23;
		int x3 = 15, y3 = 33;
		testAdd(this.rect, x1, y1, true);
		assertValues(this.rect, x1, y1, x1, y1, 1, 1);
		testAdd(this.rect, x2, y2, true);
		int minX1X2 = Math.min(x1, x2), minY1Y2 = Math.min(y1, y2);
		int maxX1X2 = Math.max(x1, x2), maxY1Y2 = Math.max(y1, y2);
		assertValues(this.rect, minX1X2, minY1Y2, maxX1X2, maxY1Y2, maxX1X2 - minX1X2 + 1, maxY1Y2 - minY1Y2 + 1);
		testAdd(this.rect, x3, y3, true);
		int minX1X2X3 = Math.min(minX1X2, x3), minY1Y2Y3 = Math.min(minY1Y2, y3);
		int maxX1X2X3 = Math.max(maxX1X2, x3), maxY1Y2Y3 = Math.max(maxY1Y2, y3);
		assertValues(this.rect, minX1X2X3, minY1Y2Y3, maxX1X2X3, maxY1Y2Y3, maxX1X2X3 - minX1X2X3 + 1, maxY1Y2Y3 - minY1Y2Y3 + 1);
	}
	
	@JExercise(tests="boolean add(int,int)", description="Tests add of same point several times.")
	public void testAddSameXY() {
		int x = 13, y = -27;
		testAdd(this.rect, x, y, true);
		assertValues(this.rect, x, y, x, y, 1, 1);
		testAdd(this.rect, x, y, false);
		assertValues(this.rect, x, y, x, y, 1, 1);
	}
	
	@JExercise(tests="boolean add(Rectangle)", description="Tests add(rect) on an empty Rectangle.")
	public void testAddRectangleToEmpty() {
		int x1 = 13, y1 = -27;
		int x2 = -11, y2 = 23;
		Rectangle rect = new Rectangle();
		testAdd(rect, x1, y1, true);
		assertValues(rect, x1, y1, x1, y1, 1, 1);
		testAdd(rect, x2, y2, true);
		int minX1X2 = Math.min(x1, x2), minY1Y2 = Math.min(y1, y2);
		int maxX1X2 = Math.max(x1, x2), maxY1Y2 = Math.max(y1, y2);
		assertValues(rect, minX1X2, minY1Y2, maxX1X2, maxY1Y2, maxX1X2 - minX1X2 + 1, maxY1Y2 - minY1Y2 + 1);

		assertTrue(this.rect.add(rect));
		assertValues(this.rect, minX1X2, minY1Y2, maxX1X2, maxY1Y2, maxX1X2 - minX1X2 + 1, maxY1Y2 - minY1Y2 + 1);
	}
	
	@JExercise(tests="boolean add(Rectangle)", description="Tests add(rect).")
	public void testAddRectangle() {
		int x1 = 13, y1 = -27;
		int x2 = -11, y2 = 23;
		int x3 = 15, y3 = 33;
		testAdd(this.rect, x3, y3, true);
		assertValues(this.rect, x3, y3, x3, y3, 1, 1);
		
		Rectangle rect = new Rectangle();
		testAdd(rect, x1, y1, true);
		assertValues(rect, x1, y1, x1, y1, 1, 1);
		testAdd(rect, x2, y2, true);
		int minX1X2 = Math.min(x1, x2), minY1Y2 = Math.min(y1, y2);
		int maxX1X2 = Math.max(x1, x2), maxY1Y2 = Math.max(y1, y2);
		assertValues(rect, minX1X2, minY1Y2, maxX1X2, maxY1Y2, maxX1X2 - minX1X2 + 1, maxY1Y2 - minY1Y2 + 1);
		
		assertTrue(this.rect.add(rect));
		int minX1X2X3 = Math.min(minX1X2, x3), minY1Y2Y3 = Math.min(minY1Y2, y3);
		int maxX1X2X3 = Math.max(maxX1X2, x3), maxY1Y2Y3 = Math.max(maxY1Y2, y3);
		assertValues(this.rect, minX1X2X3, minY1Y2Y3, maxX1X2X3, maxY1Y2Y3, maxX1X2X3 - minX1X2X3 + 1, maxY1Y2Y3 - minY1Y2Y3 + 1);
	}
	
	@JExercise(tests="boolean add(Rectangle)", description="Tests add(rect) of same Rectangle several times.")
	public void testAddSameRectangle() {
		int x1 = 13, y1 = -27;
		int x2 = -11, y2 = 23;
		Rectangle rect = new Rectangle();
		testAdd(rect, x1, y1, true);
		assertValues(rect, x1, y1, x1, y1, 1, 1);
		testAdd(rect, x2, y2, true);
		int minX1X2 = Math.min(x1, x2), minY1Y2 = Math.min(y1, y2);
		int maxX1X2 = Math.max(x1, x2), maxY1Y2 = Math.max(y1, y2);
		assertValues(rect, minX1X2, minY1Y2, maxX1X2, maxY1Y2, maxX1X2 - minX1X2 + 1, maxY1Y2 - minY1Y2 + 1);

		assertTrue(this.rect.add(rect));
		assertValues(this.rect, minX1X2, minY1Y2, maxX1X2, maxY1Y2, maxX1X2 - minX1X2 + 1, maxY1Y2 - minY1Y2 + 1);
		assertFalse(this.rect.add(rect));
		assertValues(this.rect, minX1X2, minY1Y2, maxX1X2, maxY1Y2, maxX1X2 - minX1X2 + 1, maxY1Y2 - minY1Y2 + 1);
	}
	
	@JExercise(tests="Rectangle union(Rectangle)", description="Tests union(rect).")
	public void testUnion() {
		int x1 = 13, y1 = -27;
		int x2 = -11, y2 = 23;
		int x3 = 15, y3 = 33;
		int x4 = 17, y4 = -33;

		testAdd(this.rect, x3, y3, true);
		assertValues(this.rect, x3, y3, x3, y3, 1, 1);
		testAdd(this.rect, x4, y4, true);
		int minX3X4 = Math.min(x3, x4), minY3Y4 = Math.min(y3, y4);
		int maxX3X4 = Math.max(x3, x4), maxY3Y4 = Math.max(y3, y4);
		assertValues(this.rect, minX3X4, minY3Y4, maxX3X4, maxY3Y4, maxX3X4 - minX3X4 + 1, maxY3Y4 - minY3Y4 + 1);
		
		Rectangle rect = new Rectangle();
		testAdd(rect, x1, y1, true);
		assertValues(rect, x1, y1, x1, y1, 1, 1);
		testAdd(rect, x2, y2, true);
		int minX1X2 = Math.min(x1, x2), minY1Y2 = Math.min(y1, y2);
		int maxX1X2 = Math.max(x1, x2), maxY1Y2 = Math.max(y1, y2);
		assertValues(rect, minX1X2, minY1Y2, maxX1X2, maxY1Y2, maxX1X2 - minX1X2 + 1, maxY1Y2 - minY1Y2 + 1);
		
		int minX = Math.min(minX1X2, minX3X4), minY = Math.min(minY1Y2, minY3Y4);
		int maxX = Math.max(maxX1X2, maxX3X4), maxY = Math.max(maxY1Y2, maxY3Y4);
		Rectangle union1 = this.rect.union(rect);
		assertValues(union1, minX, minY, maxX, maxY, maxX - minX + 1, maxY - minY + 1);
		assertValues(this.rect, minX3X4, minY3Y4, maxX3X4, maxY3Y4, maxX3X4 - minX3X4 + 1, maxY3Y4 - minY3Y4 + 1);
		assertValues(rect, minX1X2, minY1Y2, maxX1X2, maxY1Y2, maxX1X2 - minX1X2 + 1, maxY1Y2 - minY1Y2 + 1);
		Rectangle union2 = rect.union(this.rect);
		assertValues(union2, minX, minY, maxX, maxY, maxX - minX + 1, maxY - minY + 1);
		assertValues(this.rect, minX3X4, minY3Y4, maxX3X4, maxY3Y4, maxX3X4 - minX3X4 + 1, maxY3Y4 - minY3Y4 + 1);
		assertValues(rect, minX1X2, minY1Y2, maxX1X2, maxY1Y2, maxX1X2 - minX1X2 + 1, maxY1Y2 - minY1Y2 + 1);
	}
}
