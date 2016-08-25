package interfaces;

//import interfaces.Card;
//import interfaces.CardContainer;
//import interfaces.CardDeck;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import junit.framework.TestCase;
import no.hal.jex.jextest.extensions.JextestExtensions;
import no.hal.jex.runtime.JExercise;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@JExercise(description = "Tests interfaces.CardDeck")
@SuppressWarnings("all")
public class CardDeckTest extends TestCase {
    private CardDeck deck;

    private CardDeck _init_deck() {
        CardDeck _cardDeck = new CardDeck(2);
        return _cardDeck;
    }

    private Card s1;

    private Card _init_s1() {
        Card _card = new Card('S', 1);
        return _card;
    }

    private Card s2;

    private Card _init_s2() {
        Card _card = new Card('S', 2);
        return _card;
    }

    private Card h1;

    private Card _init_h1() {
        Card _card = new Card('H', 1);
        return _card;
    }

    private Card h2;

    private Card _init_h2() {
        Card _card = new Card('H', 2);
        return _card;
    }

    private Card d1;

    private Card _init_d1() {
        Card _card = new Card('D', 1);
        return _card;
    }

    private Card d2;

    private Card _init_d2() {
        Card _card = new Card('D', 2);
        return _card;
    }

    private Card c1;

    private Card _init_c1() {
        Card _card = new Card('C', 1);
        return _card;
    }

    private Card c2;

    private Card _init_c2() {
        Card _card = new Card('C', 2);
        return _card;
    }

    private Collection<Card> expected;

    private Collection<Card> _init_expected() {
        return Collections.<Card>unmodifiableList(CollectionLiterals.<Card>newArrayList(this.s1, this.s2, this.h1, this.h2, this.d1, this.d2, this.c1, this.c2));
    }

    @Override
    protected void setUp() {
        deck = _init_deck();
        s1 = _init_s1();
        s2 = _init_s2();
        h1 = _init_h1();
        h2 = _init_h2();
        d1 = _init_d1();
        d2 = _init_d2();
        c1 = _init_c1();
        c2 = _init_c2();
        expected = _init_expected();

    }

    private void testCards(final CardContainer it, final Collection<Card> expected) {
        int _size = expected.size();
        int _cardCount = it.getCardCount();
        JextestExtensions.operator_assertEquals(_size, _cardCount);
        final Iterator<Card> expectedIt = expected.iterator();
        int i = 0;
        while (expectedIt.hasNext()) {
            {
                final Card expectedCard = expectedIt.next();
                final Card actualCard = it.getCard(i);
                char _suit = expectedCard.getSuit();
                char _suit_1 = actualCard.getSuit();
                JextestExtensions.operator_assertEquals(_suit, _suit_1);
                int _face = expectedCard.getFace();
                int _face_1 = actualCard.getFace();
                JextestExtensions.operator_assertEquals(_face, _face_1);
                i = (i + 1);
            }
        }
    }

    private void testCards(final Iterable<Card> actual, final Iterator<Card> expected) {
        final Iterator<Card> actualIt = actual.iterator();
        while (expected.hasNext()) {
            {
                boolean _hasNext = actualIt.hasNext();
                TestCase.assertTrue(_hasNext);
                final Card expectedCard = expected.next();
                final Card actualCard = actualIt.next();
                char _suit = expectedCard.getSuit();
                char _suit_1 = actualCard.getSuit();
                JextestExtensions.operator_assertEquals(_suit, _suit_1);
                int _face = expectedCard.getFace();
                int _face_1 = actualCard.getFace();
                JextestExtensions.operator_assertEquals(_face, _face_1);
            }
        }
    }

    @JExercise(tests = "CardDeck(int);java.util.Iterator<interfaces.Card> iterator()", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>deck.iterator</li>\n\t\t</ul>\n")
    public void testCardContainer() {
        _transition_exprAction__cardContainer_transitions0_actions0();
        _test__cardContainer_transitions0_effect_state();

    }

    @JExercise(tests = "CardDeck(int);java.util.Iterator<interfaces.Card> iterator()", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>deck.iterator</li>\n\t\t</ul>\n")
    public void testDeckIterator() {
        _transition_exprAction__deckIterator_transitions0_actions0();
        _test__deckIterator_transitions0_effect_state();

    }

    private void _transition_exprAction__cardContainer_transitions0_actions0() {
        try {

            this.deck.iterator();
        } catch (junit.framework.AssertionFailedError error) {
            fail("deck.iterator failed: " + error.getMessage());
        }

    }

    private void _test__cardContainer_transitions0_effect_state() {
        _test__cardContainer_transitions0_effect_state_objectTests0_test(deck);

    }

    private void _test__cardContainer_transitions0_effect_state_objectTests0_test(final CardDeck it) {
        try {

            this.testCards(it, this.expected);
        } catch (junit.framework.AssertionFailedError error) {
            fail("testCards(expected) failed after deck.iterator: " + error.getMessage());
        }

    }

    private void _transition_exprAction__deckIterator_transitions0_actions0() {
        try {

            this.deck.iterator();
        } catch (junit.framework.AssertionFailedError error) {
            fail("deck.iterator failed: " + error.getMessage());
        }

    }

    private void _test__deckIterator_transitions0_effect_state() {
        _test__deckIterator_transitions0_effect_state_objectTests0_test(deck);

    }

    private void _test__deckIterator_transitions0_effect_state_objectTests0_test(final CardDeck it) {
        try {

            Iterator<Card> _iterator = this.expected.iterator();
            this.testCards(it, _iterator);
        } catch (junit.framework.AssertionFailedError error) {
            fail("testCards(expected.iterator) failed after deck.iterator: " + error.getMessage());
        }

    }

    public static void main(final String[] args) {
        no.hal.jex.standalone.JexStandalone.main(CardDeckTest.class);
    }
}
