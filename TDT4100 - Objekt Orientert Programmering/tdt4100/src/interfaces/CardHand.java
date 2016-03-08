package interfaces;

import java.util.*;

public class CardHand {
    private List<Card> hand = new ArrayList<Card>();

    public CardHand () {

    }

    public int getCardCount () {
        return hand.size();
    }

    public Card getCard (int n) {

        if (n < 0 || n >= getCardCount()) {
            throw new IllegalArgumentException(String.format("Can't get card number %d when the deck starts from 0 and ends at %d", n, getCardCount()));
        }

        return hand.get(n);
    }

    public void addCard (Card card) {
        hand.add(card);
    }

    public Card play (int n) {
        Card pick = hand.get(n);

        hand.remove(n);

        return pick;
    }

    private Iterator<Card> iterator () {
        return hand.iterator();
    }
}
