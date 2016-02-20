package encapsulation;

public class Nim {
	private int[] piles;
	
	public Nim() {
		this(10);
	}
	
	public Nim(int pileSize) {
		piles = new int[]{pileSize, pileSize, pileSize};
	}
	
	public void removePieces(int number, int targetPile) {
		
		if (!isGameOver()) {
			if (isValidMove(number, targetPile) && targetPile >= 0 && targetPile < this.piles.length) {
				if (number >= 1) {
					piles[targetPile] -= number;
				} else {
					throw new IllegalArgumentException("Number is too low");
				}
			} else {
				throw new IllegalArgumentException("Piles does not exist!");
			}
		} else {
			throw new IllegalStateException("Not valid");
		}
	}

	public boolean isValidMove(int number, int targetPile) {
		
		if (!isGameOver() && targetPile >= 0 && targetPile < this.piles.length) {
			
			if (piles[targetPile] >= number && number > 0) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isGameOver() {
		
		for (int i = 0; i < piles.length; i++) {
			if (piles[i] <= 0) {
				return true;
			}
		}
		
		return false;
	}
	
	public int getPile(int targetPile) {
		
		if (targetPile >= 0 && targetPile < piles.length) {
			return piles[targetPile];
		}
		
		return 0;
	}
	
	public String toString() {
		String build = "";
		
		for (int i = 0; i < piles.length; i++) {
			build += "Pile " + i +  ": " + piles[i] + " brikker.\n";
		}
		
		return build;
	}
}