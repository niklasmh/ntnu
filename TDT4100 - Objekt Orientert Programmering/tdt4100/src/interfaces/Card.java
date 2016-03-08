package interfaces;

public class Card {
    private char color;
    private int val;
    private static final String LEGAL_SUITS = "SHDC";

    public Card () {
        this('S', 1);
    }

    public Card (char color, int val) {

        if (!LEGAL_SUITS.contains("" + color)) {
            throw new IllegalArgumentException("Må inneholder riktig type kort");
        }

        if (val <= 0 || val > 13) {
            throw new IllegalArgumentException("Må være et kort mellom 1-13");
        }

        this.color = color;
        this.val = val;
    }

    public char getSuit () {
        return this.color;
    }

    public int getFace () {
        return this.val;
    }

    @Override
    public String toString () {
        return String.format("%s%d", this.color, this.val);
    }
}
