package interfaces;

import java.util.Iterator;

public class CardContainerIterator implements Iterator<Card> {
    private CardContainer cardContainer;
    private int position;

    public CardContainerIterator(CardContainer cardContainer) {
        this.cardContainer = cardContainer;
        this.position = 0;
    }

    public boolean hasNext () {
        return cardContainer.getCardCount() < position;
    }

    public Card next () {
        return cardContainer.getCard(position++);
    }
}
