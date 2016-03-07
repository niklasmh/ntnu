package code;

public class MatrixSolver {
	
	public static void main(String[] args) {
		Matrix m1 = new Matrix(new double[][]{
			{1,		2,		3},
			{4,		5,		6},
			{7,		8,		1}
		});
		
		Matrix m2 = new Matrix(new double[][]{
			{9,		8,		7},
			{6,		5,		4},
			{3,		2,		1}
		});
		
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m1.multiply(m2));
		System.out.println(m1.abs());
		System.out.println(m1.abs(m1));
	}
}
