package sudoku;

import java.util.Scanner;

public class Sudoku {
	public int attempts;
	
	public Sudoku () {
		attempts = 0;
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Brett (ingenting blir default brett):");
		
		String board = scan.nextLine();
		
		Board b;
		
		if (board.matches("[1-9.]{81,}")) {
			System.out.println("Sukksess i å importere brett:\n");
			b = new Board(board.substring(0, 81));
		} else if (board.length() > 0) {
			System.out.println("Kunne ikke lage brett, du får nå default:\n");
			b = new Board();
		} else {
			System.out.println("Du får nå default:\n");
			b = new Board();
		}
		
		System.out.println(b);
		
		/* Trying to brute force until a solution is found. * /
		System.out.println("L�se selv? (blank - ja)");
		boolean human = (scan.nextLine().length() == 0);
		/**/
		boolean human = true;
		/**/
		
		while (!b.isGameOver()) {
			
			if (human) {
				System.out.println(b);
				System.out.println("\n\nEndre felt (f.eks. g 1 5):");
				
				int posX, posY, val;
				
				while (true) {
					String posXChar = scan.next();
					posX = (int)posXChar.charAt(0) - 97;
					posY = scan.nextInt();
					val = scan.nextInt();
					
					System.out.println(posXChar + ", " + posY + ", " + val);
					
					if (posX >= 0 && posX < 9) {
						
						if (posY >= 0 && posY < 9) {
							
							if (val >= 0 && val <= 9) {
								break;
							} else {							
								System.out.println("Not a valid value. Must be between 0-9.");
							}
						} else {
							System.out.println("Not a valid y-position. Must be between 0-8.");
						}
					} else {
						System.out.println("Not a valid x-position. Must be a-i.");
					}
				}
				
				b.setField(posX, posY, val);
			}/* AI * / else {
				
				for(int x = 0; x < 9; x++) {
					
					for(int y = 0; y < 9; y++) {
						
						int j = 0, i = (b.getField(x, y)+1)%9;
						
						if (b.getField(x, y) == 0) {
							while (j < 9) {
								j++;
								b.setField(x, y, j);
								
								if (b.conflict(x, y) == 0) {
									break;
								}
							}
							
							if (b.conflict(x, y) != 0) {
								x -= 2;
								
								if (x < 0) {
									y -= 1;
									x = 8;
								}
							}
						}
					}
				}
				System.out.println(b);
			}
			/**/
		}
		
		System.out.println("Du vant!!! Spillet avsluttes her.");
	}
}
