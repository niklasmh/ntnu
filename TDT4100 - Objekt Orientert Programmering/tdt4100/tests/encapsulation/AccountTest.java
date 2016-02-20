package encapsulation;

import no.hal.jex.runtime.JExercise;
import no.hal.jex.standalone.JexStandalone;
import junit.framework.TestCase;

@JExercise(
	description="An Account must contain two double fields, balance and interestRate, and methods for getting balance as well as depositing and withdrawing amounts."
)
public class AccountTest extends TestCase {

	private double epsilon = 0.000001d;
	
	Account account;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		account = new Account(100, 5);
	}
	
	@JExercise(
			tests="Account(double, double)",
			description="The Account(double, double) constructor sets the state to argument values if positive, otherwise cast an IllegalArgumentException."
	)
	public void testAccount() {
		account = new Account(100, 5);
		assertEquals(100.0d, account.getBalance(), epsilon);
		assertEquals(5.0d, account.getInterestRate(), epsilon);
		try {
			account = new Account(-1, 5);
			fail("Creating Account with negative balance should throw an IllegalArgumentException.");
		} catch (Exception e) {
			assertEquals(100.0d, account.getBalance(), epsilon);
			assertEquals(5.0d, account.getInterestRate(), epsilon);	
			assertTrue("Exception should be IllegalArgumentException.", e instanceof IllegalArgumentException);
		}
		
		try {
			account = new Account(100, -1);
			fail("Creating Account with negative interestRate should throw an IllegalArgumentException.");
		} catch (Exception e) {
			assertEquals(100.0d, account.getBalance(), epsilon);
			assertEquals(5.0d, account.getInterestRate(), epsilon);
			assertTrue("Exception should be IllegalArgumentException.", e instanceof IllegalArgumentException);
		}
	}
	
	@JExercise(
			tests="void setInterestRate(double)",
			description="The setInterestRate(double) method sets the interest rate to the input argument, given that the argument is positive "
	)
	public void testSetInterestRate() {
		account.setInterestRate(7);
		assertEquals(7.0d, account.getInterestRate(), epsilon);
		try {
			account.setInterestRate(-2);
			fail("Setting a negative interestRate should result throw exception.");
		} catch (Exception e) {
			assertEquals(7.0d, account.getInterestRate(), epsilon);
		}
	}
	

	@JExercise(
		tests="void deposit(double)",
		description="The deposit(double) method takes an amount as its only argument, and adds it to the balance."
	)
	public void testDeposit() {
		account.deposit(100);
		assertEquals(200.0d, account.getBalance(), epsilon);
	}
	
	@JExercise(
			tests="void deposit(double)",
			description="The deposit(double) method should ignore negative amounts and throw an IllegalArgumentException if so"
	)
	public void testDepositNegativeAmount() {
		try {
			account.deposit(-50);
			fail("deposit should throw an IllegalArgumentException when given negative amounts.");
		} catch (Exception e) {
			assertEquals("deposit should ignore negative amounts.", 100.0d, account.getBalance(), epsilon);
			assertTrue("Exception should be IllegalArgumentException.", e instanceof IllegalArgumentException);
		}
	}
	
	@JExercise(
			tests="void withdraw(double)",
			description="The withdraw(double amount) method withdraws the amount from the balance."
	)
	public void testWithdraw() {
		try {
			account.withdraw(50);
			assertEquals(50.0d, account.getBalance(), epsilon);
		} catch (Exception e){
			fail();
		}
	}
	
	@JExercise(
			tests="void withdraw(double)",
			description="The withdraw(double amount) method should throw an IllegalStateException if the amount is larger than the current balance."
	)
	public void testWithdrawTooLargeAmount() {
		try {
			account.withdraw(150);
			fail("Expected IllegalStateException here");
		} catch (Exception e){
			assertEquals(100.0d, account.getBalance(), epsilon);
			assertTrue(e instanceof IllegalStateException);
		}
	}

	public static void main(String[] args) {
		JexStandalone.main(AccountTest.class);
	}
}