package sudoku;

public class Board {
	private int height, width;
	private Field[] board;
	
	public Board () {
		this(".....2..38.273.45....6..87.9.8..5367..6...1..4513..9.8.84..3....79.512.62..8.....");
	}
	
	public Board (String board) {
		width = 9;
		height = 9;
		this.board = StrToFields(board);
	}
	
	public Field[] StrToFields(String str) {
		String[] chars = str.split("");
		Field[] fields = new Field[chars.length];
		
		for (int i = 0; i < chars.length; i++) {
			
			if (chars[i].matches("\\.")) {
				fields[i] = new Field(0, 2);
			} else {
				fields[i] = new Field(Integer.parseInt(chars[i]), 1);
			}
		}
		
		return fields;
	}
	
	public boolean setField(int x, int y, int val) {
		
		if (validField(x, y)) {
			board[x + y*width].setField(val);
			
			return true;
		}
		
		return false;
	}
	
	public int getField(int x, int y) {
		return board[x + y*width].getVal();
	}
	
	public int getFieldType(int x, int y) {
		return board[x + y*width].getType();
	}
	
	public boolean validField(int x, int y) {
		return (board[x + y*width].getType() != 1);
	}
	
	public int conflict(int x, int y) {
		
		for(int i = 0; i < width; i++) {
			
			if (i != x && board[x + y*width].getVal() == board[i + y*width].getVal()) {
				return 1;
			}
		}
		
		for(int i = 0; i < height; i++) {
			
			if (i != y && board[x + y*width].getVal() == board[x + i*width].getVal()) {
				return 2;
			}
		}
		
		for(int i = 0, posY = (y/3)*3; i < height/3; i++) {
			
			for(int j = 0, posX = (x/3)*3; j < width/3; j++) {
				
				if (j+posX != x && i+posY != y && board[j+posX + (i+posY)*width].getVal() == board[x + y*width].getVal()) {
					return 3;
				}
				// System.out.println("x:"+j+",y:"+i+",px:"+posX+",py:"+posY+",board:"+board[j+posX + (i+posY)*width]+",piece:"+board[x + y*width]);
			}
		}
		
		return 0;
	}
	
	public boolean isGameOver() {
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				if (conflict(x, y) != 0 || board[x + y*width].getVal() == 0) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public String toString() {
		String print = "  +-------------+-------------+-------------+\n";
		
		for(int y = 0; y < height; y++) {
			print += y + " |";
			
			for(int x = 0; x < width; x++) {
				print += " " + board[x + y*width].toString();
				
				if (board[x + y*width].getType() == 2 && board[x + y*width].getVal() != 0) {
					print += (conflict(x, y) != 0 ? "*" : " ");
				}
				
				if ((x+1)%3 == 0) {
					print += " |";
				}
			}
			
			print += "\n";
			
			if ((y+1)%3 == 0) {
				print += "  +-------------+-------------+-------------+\n";
			}
		}
		
		print += "     a   b   c     d   e   f     g   h   i";
		
		return print;
	}
}
