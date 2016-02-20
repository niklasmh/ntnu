package stateandbehavior;

import no.hal.jex.runtime.JExercise;
import no.hal.jex.standalone.JexStandalone;
import junit.framework.TestCase;

@JExercise(
		tests="", // We don't want to test this element as a whole, since we can test the parts.
		description="A class that counts from a start value up or down to an end value. " +
				"The counting is constrained by the values provided to constructor and performed by the count() method."
)
public class UpOrDownCounterTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	private void testCount(UpOrDownCounter counter, int end, int delta) {
		boolean result = true;
		while (delta > 0 ? counter.getCounter() < end : counter.getCounter() > end) {
			assertTrue("Before reaching the end value, the count() method should return true. ", result);
			int i = counter.getCounter();
			result = counter.count();
			int expected = i + delta;
			assertEquals("When counting from " + i + " the result should be " + expected + ". ", expected, counter.getCounter());
		}
		assertFalse("When reaching the end value, the count method should return false. ", result);
		assertEquals("After reaching the end value, the counter should not change. ", end, counter.getCounter());
		assertFalse("After reaching the end value, the count() method should return false. ", counter.count());
		assertEquals("After reaching the end value, the counter should not change. ", end, counter.getCounter());
	}
	
	@JExercise(
			tests="UpOrDownCounter(int,int)",
			description="A constructor that initializes the UpOrDownCounter class with the provided start and end value. " +
					"After initialization the counter should be the start value. "
	)
	public void testUpOrDownCounter() {
		UpOrDownCounter counter13 = new UpOrDownCounter(1, 3);
		assertEquals("After instantiating an UpOrDownCounter the counter should be the start value. ", 1, counter13.getCounter());
		UpOrDownCounter counter31 = new UpOrDownCounter(3, 1);
		assertEquals("After instantiating an UpOrDownCounter the counter should be the start value. ", 3, counter31.getCounter());
	}
//	@JExercise(
//			tests="UpOrDownCounter(int,int)",
//			description="A constructor that initializes the UpOrDownCounter class with the provided start and end value. " +
//					"If the start and end values are equal, an IllegalArgumentException should be thrown. "
//			)
//	public void testUpOrDownCounterWithException() {
//		Exception iae = null;
//		try {
//			new UpOrDownCounter(0, 0);
//			fail("When the start and end values are equal an IllegalArgumentException should be thrown. ");
//		} catch (Exception e) {
//			iae = e;
//		}
//		assertTrue("When the start and end values are equal an IllegalArgumentException should be thrown, ", iae instanceof IllegalArgumentException);
//	}
	
	@JExercise(
			tests="boolean count()",
			description="A method that steps the counter, unless it has reached the end value. " +
					"The method returns true as long as the counter has not reached the end value, and false otherwise. " +
					"This test checks that it properly steps upwards, when the end value is larger than the start value."
	)
	public void testCountUp() {
		UpOrDownCounter counter13 = new UpOrDownCounter(1, 3);
		testCount(counter13, 3, 1);
	}
	@JExercise(
			tests="boolean count()",
			description="A method that steps the counter, unless it has reached the end value. " +
					"The method returns true as long as the counter has not reached the end value, and false otherwise. " +
					"This test checks that it properly steps downwards, when the end value is smaller than the start value."
			)
	public void testCountDown() {
		UpOrDownCounter counter31 = new UpOrDownCounter(3, 1);
		testCount(counter31, 1, -1);
	}

	//

	public static void main(String[] args) {
		JexStandalone.main(UpOrDownCounterTest.class);
	}
}
