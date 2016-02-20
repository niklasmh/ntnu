package encapsulation;

import no.hal.jex.runtime.JExercise;
import no.hal.jex.standalone.JexStandalone;
import junit.framework.TestCase;

@JExercise(
	description="A Calculator must contain two double fields for first and second operand, a char for operand and methods for setting these fields and calculating the result."
)
public class CalculatorTest extends TestCase {

	Calculator calculator;

	protected void setUp() throws Exception {
		super.setUp();
		calculator = new Calculator();
	}

	@JExercise(
		tests="void setFirstOperand(double);double getFirstOperand()",
		description="The setFirstOperand(double) method takes an operand as its only argument, and sets this to the firstOperand field. The getFirstOperand() method returns this field."
	)
	public void testSetGetFirstOperand() {
		calculator.setFirstOperand(0);
		assertEquals(calculator.getFirstOperand(), 0.0);
		calculator.setFirstOperand(-5.0);
		assertEquals(calculator.getFirstOperand(), -5.0);
		calculator.setFirstOperand(5.0);
		assertEquals(calculator.getFirstOperand(), 5.0);
	}
	
	@JExercise(
			tests="void setSecondOperand(double);double getSecondOperand()",
			description="The setSecondOperand(double) method takes an operand as its only argument, and sets this to the secondOperand field. The getSecondOperand() method returns this field."
			)
	public void testSetGetSecondOperand() {
		calculator.setSecondOperand(0);
		assertEquals(calculator.getSecondOperand(), 0.0);
		calculator.setSecondOperand(-5.0);
		assertEquals(calculator.getSecondOperand(), -5.0);
		calculator.setSecondOperand(5.0);
		assertEquals(calculator.getSecondOperand(), 5.0);
	}
	
	@JExercise(
		tests="void setOperator(char);char getOperator()",
		description="The setOperator(char) method takes an operator as its only argument, and sets this to the operator field. The getOperator() method returns this field."
	)
	public void testSetGetOperator() {
		calculator.setOperator('+');
		assertEquals(calculator.getOperator(), '+');

		calculator.setOperator('-');
		assertEquals(calculator.getOperator(), '-');
		
		calculator.setOperator('*');
		assertEquals(calculator.getOperator(), '*');
		
		calculator.setSecondOperand(5);
		calculator.setOperator('/');
		assertEquals(calculator.getOperator(), '/');
		boolean caught = false;
		try {
			calculator.setOperator('X');			
		} catch (IllegalArgumentException e) {
			caught = true;
		}
		assertTrue("Setting an illegal operator should throw exception.", caught);
	}
	
	@JExercise(
			tests="double calculateResult()",
			description="The calculateResult() method computes the result based on the operands and the operator stored in the calculator."
	)
	public void testCalculateResult() {
		calculator.setFirstOperand(5.0);
		calculator.setSecondOperand(4.0);
		
		boolean caught = false;
		try {
			calculator.calculateResult();
		} catch (IllegalStateException e) {
			caught = true;
		}
		assertTrue("calculateResult should throw IllegalStateException if called with no operator set.", caught);
		
		calculator.setOperator('+');
		assertEquals(calculator.calculateResult(), 5.0 + 4.0);

		calculator.setOperator('-');
		assertEquals(calculator.calculateResult(), 5.0 - 4.0);

		calculator.setOperator('*');
		assertEquals(calculator.calculateResult(), 5.0 * 4.0);

		calculator.setOperator('/');
		assertEquals(calculator.calculateResult(), 5.0 / 4.0);

		calculator.setOperator('%');
		assertEquals(calculator.calculateResult(), 5.0 % 4.0);
		
		caught = false;
		try {
			calculator.setSecondOperand(0);
			calculator.setOperator('/');
			calculator.calculateResult();
		} catch (IllegalStateException e) {
			caught = true;
		}
		assertTrue("calculateResult should throw IllegalStateException if the calculation is division by 0.", caught);
	}

	public static void main(String[] args) {
		JexStandalone.main(CalculatorTest.class);
	}
}