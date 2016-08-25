package encapsulation;

public class Calculator {
	// Private variables
	private double firstOperand, secondOperand;
	private char operator;
	public static final String LEGAL_OPERATORS = "+-/*%";
	
	public Calculator() {
		// Constructor
	}
	
	public void setFirstOperand(double val) {
		this.firstOperand = val;
	}
	
	public void setSecondOperand(double val) {
		this.secondOperand = val;
	}
	
	public void setOperator(char operator) {
		if (operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '%') {
			this.operator = operator;
		} else {
			throw new IllegalArgumentException("Must be a +, -, *, / og % operator.");
		}
	}
	
	public double getFirstOperand() {
		return this.firstOperand;
	}
	
	public double getSecondOperand() {
		return this.secondOperand;
	}
	
	public char getOperator() {
		return this.operator;
	}
	
	public double calculateResult() {
		if (!LEGAL_OPERATORS.contains("" + operator)) {
			throw new IllegalStateException("Husk operator!");
		}
		
		double val1 = this.firstOperand, val2 = this.secondOperand;
		
		switch (this.operator) {
			case '+': return val1 + val2;
			case '-': return val1 - val2;
			case '*': return val1 * val2;
			case '/': if (val2 != 0 ) { return val1 / val2; }
			else { throw new IllegalStateException("Devided by zero"); }
			case '%': return val1 % val2;
			default: return 0;
		}
	}
	
	public String toString() {
		return this.firstOperand + " "
				+ this.operator + " "
				+ this.secondOperand + " = "
				+ calculateResult();
	}
}