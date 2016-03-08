package interfaces;

import java.util.Comparator;

public class CardComparator implements Comparator {
    private char[] suits = {'S', 'H', 'D', 'C'};
    private int ess;
    private char trumf;

    public CardComparator (boolean ess, char trumf) {
        this.ess = ess;
        this.trumf = trumf;
    }

    public int compare (Card first, Card second) {
        int firstSuit = 0, secondSuit = 0, i, pos;

        for(i = 0; i < suits.length; i++) {
            firstSuit = (suits[i] == first.getSuit() ? i : firstSuit);
            secondSuit = (suits[i] == second.getSuit() ? i : secondSuit);
        }

        firstSuit = (trumf == first.getSuit() ? suits.length : firstSuit);
        secondSuit = (trumf == second.getSuit() ? suits.length : secondSuit);

        pos = firstSuit - secondSuit;

        if (pos == 0) {
            int firstFace = first.getFace(), secondFace = second.getFace();

            firstFace = (firstFace == 1 ? 14 : firstFace);
            secondFace = (secondFace == 1 ? 14 : secondFace);

            return firstFace - secondFace;
        }

        return pos;
    }
}
