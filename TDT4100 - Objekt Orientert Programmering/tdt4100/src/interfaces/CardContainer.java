package interfaces;

public interface CardContainer extends Iterable<Card> {
    public int getCardCount();

    public Card getCard(int n) throws IllegalArgumentException;
}
