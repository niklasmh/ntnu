package code;

public class MatrixSolver {
	
	public static void main(String[] args) {/**/
		Matrix m1 = new Matrix(new double[][]{
			{1,		0,		-2},
			{-3,	1,		4},
			{2,		-3,		4}
		});
		
		Matrix m2 = new Matrix(new double[][]{
			{0,		4,		1},
			{5,		-3,		0},
			{2,		3,		1}
		});

		Matrix m3 = new Matrix(new double[][]{
			{6,		0,		0,		5},
			{1,		7,		2,		-5},
			{2,		0,		0,		0},
			{8,		3,		1,		8}
		});
		
		System.out.println(m3.abs());
		/** /

		Matrix m1 = new Matrix(new double[][] {
			{2, -3},
			{-4, 6}
		});

		Matrix m2 = new Matrix(new double[][] {
			{8, 4},
			{5, 5}
		});

		Matrix m3 = new Matrix(new double[][] {
			{5, -2},
			{3, 1}
		});

		System.out.println(m1.multiply(m2));
		System.out.println(m1.multiply(m3));
		/**/
	}
}
