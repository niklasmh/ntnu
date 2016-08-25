package interfaces;

import java.util.*;

public class CardDeck implements CardContainer {
    private List<Card> deck = new ArrayList<Card>();
    private char suits[] = new char[]{'S', 'H', 'D', 'C'};

    public CardDeck () {
        this(13);
    }

    public CardDeck (int n) {

        if (n < 1) {
            throw new IllegalArgumentException("Can't push 0 or less cards to the deck.");
        }

        if (n > 13) {
            throw new IllegalArgumentException("Can't push 13 or more cards to each of the suits.");
        }

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < n; i++) {
                deck.add(new Card(suits[j], i + 1));
            }
        }
    }

    public int getCardCount () {
        return deck.size();
    }

    public Card getCard (int n) {

        if (n < 0 || n >= getCardCount()) {
            throw new IllegalArgumentException(String.format("Can't get card number %d when the deck starts from 0 and ends at %d", n, getCardCount()));
        }

        return deck.get(n);
    }

    public void deal (CardHand hand, int i) {

        for (int x = 0; x < i; x++) {
            hand.addCard(deck.get(getCardCount() - 1));
            deck.remove(getCardCount() - 1);
        }
    }

    public List<Card> shufflePerfectly () {
        List<Card> newDeck = new ArrayList<Card>();

        for (int i = 0, j = getCardCount()/2; i < getCardCount()/2; i++, j++) {
            newDeck.add(deck.get(i));
            newDeck.add(deck.get(j));
        }

        deck = newDeck;

        return newDeck;
    }

    public Iterator<Card> iterator () {
        return deck.iterator();
    }
}
