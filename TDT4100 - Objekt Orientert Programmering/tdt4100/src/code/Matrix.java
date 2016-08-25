package code;

public class Matrix {
	private double[][] matrix, setMatrix;
	
	public Matrix () {
		this(new double[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}});
	}
	
	public Matrix (double[][] matrix) {
		
		if (matrix.length > 0) {
			
			if (matrix[0].length > 1) {
				this.matrix = matrix;
				this.setMatrix = new double[matrix.length][matrix[0].length];
			} else {
				throw new IllegalArgumentException("The matrix has to contain at least 2 columns");
			}
		} else {
			throw new IllegalArgumentException("The matrix can't be empty.");
		}
	}
	
	public double[][] getMatrix () {
		return matrix;
	}
	
	public int getMatrixRows () {
		return matrix[0].length;
	}
	
	public int getMatrixColumns () {
		return matrix.length;
	}
	
	public double[] getRow (int row) {
		return matrix[row];
	}
	
	public boolean setRow (int row, double[] data) {
		
		if (row >= 0 && this.matrix.length > row && data.length == this.matrix[0].length) {
			matrix[row] = data;
			
			return true;
		}
		
		return false;
	}
	
	public boolean switchRows (int row1, int row2) {
		double[] oldRow = this.matrix[row1];
		
		setRow(row1, this.matrix[row2]);
		setRow(row2, oldRow);
		
		return true;
	}
	
	public int[] getCellWidth () {
		int[] widths = new int[getMatrixColumns()];
		int rows = getMatrixRows();
		
		for(int y = 0; y < rows; y++) {
			
			for(int x = 0; x < widths.length; x++) {
				widths[x] = Math.max(widths[x], letterWidth(getField(x, y)));
			}
		}
		
		return widths;
	}
	
	public int letterWidth (double number) {
		return String.valueOf(number).length();
	}
	
	public double[][] setMatrix (double[][] matrix) {
		this.matrix = matrix;
		
		return this.matrix;
	}
	
	public double getField (int x, int y) {
		
		if (y >= 0 && y < this.matrix.length && x >= 0 && x < this.matrix[0].length) {
			return this.matrix[y][x];
		}
		
		throw new IllegalArgumentException("Can't find field in matrix. Try to check columns and rows first.");
	}

	public boolean setField (int x, int y, double val) {
		
		if (x >= 0 && x < this.matrix.length && y >= 0 && y < this.matrix.length) {
			this.matrix[y][x] = val;
			
			return true;
		}
		
		return false;
	}
	
	public Matrix multiply (Matrix matrix) {
		
		if (matrix.getMatrixColumns() != getMatrixRows() || matrix.getMatrixRows() != getMatrixColumns()) {
			throw new IllegalArgumentException("Can't multiply matrices.");
		}
		
		double[][] buildMatrix = new double[getMatrixColumns()][getMatrixRows()];
		
		for (int y = 0; y < getMatrixRows(); y++) {
			
			for (int x = 0; x < getMatrixColumns(); x++) {
				buildMatrix[y][x] = 0;
				
				for (int i = 0; i < getMatrixColumns(); i++) {
					buildMatrix[y][x] += matrix.getField(x, i) * getField(i, y);
				}
			}
		}
		
		return new Matrix(buildMatrix);
	}
	
	public double abs () {
		return abs(this);
	}
	
	public double abs (Matrix matrix) {
		double sum = 0, part = 0;
		
		for (int i = 0; i < matrix.getMatrixColumns(); i++) {
			
			part = 1;
			
			for (int j = 0; j < matrix.getMatrixRows(); j++) {
				part *= matrix.getField((i + j) % matrix.getMatrixColumns(), j);
			}
			
			sum += part;
		}
		
		for (int i = 0; i < matrix.getMatrixColumns(); i++) {
			
			part = 1;
			
			for (int j = 0; j < matrix.getMatrixRows(); j++) {
				part *= matrix.getField((i + j) % matrix.getMatrixColumns(), matrix.getMatrixRows() - j - 1);
			}
			
			sum -= part;
		}
		
		return sum;
	}
	
	public Matrix invers (Matrix matrix) {
		double[][] newMatrix = new double[matrix.getMatrixRows()][matrix.getMatrixColumns()];

		for (int y = 0; y < newMatrix.length; y++) {

			for (int x = 0; x < newMatrix[0].length; x++) {

			}
		}
		
		return new Matrix(newMatrix);
	}
	
	public boolean step () {
		double initVal = getField(0, 0);
		int y = 0, x = 0;
		
		while (initVal == 0) {
			
			if (y > this.matrix.length) {
				y = 0;
				x++;
			}
			
			initVal = getField(x, ++y);
		}
		
		for (; x < getMatrixColumns(); x++) {
			setField(x, y, getField(x, y)/initVal);
		}
		
		switchRows(0, y);
		
		return false;
	}
	
	public String toString () {
		String build = "--";

		int cols = getMatrixColumns(),
			rows = getMatrixRows(),
			cellWidth[] = getCellWidth(),
			col = 0;
		
		for (int x = 0; x < cols; x++) {
			col = cellWidth[x] - (x == cols - 1 ? 2 : 0);
			
			build += "  ";
			
			for (int i = 0; i < col; i++) {
				build += " ";
			}
		}
		
		build += "--\n";
		
		for (int y = 0; y < rows; y++) {
			
			build += "|";
			
			for (int x = 0; x < cols; x++) {
				double num = getField(x, y);
				col = cellWidth[x] - letterWidth(num);
				
				for (int i = 0; i < col; i++) {
					build += " ";
				}
				
				build += " " + num + " ";
			}
			
			build += "|\n";
		}
		
		build += "--";
		
		for (int x = 0; x < cols; x++) {
			col = cellWidth[x] - (x == cols - 1 ? 2 : 0);
			
			build += "  ";
			
			for (int i = 0; i < col; i++) {
				build += " ";
			}
		}
		
		build += "--\n";
		
		return build;
	}
}
