package interfaces;

import interfaces.Card;
import interfaces.CardContainerIterator;
import interfaces.CardDeck;
import java.util.Collections;
import java.util.Iterator;
import junit.framework.TestCase;
import no.hal.jex.jextest.extensions.JextestExtensions;
import no.hal.jex.runtime.JExercise;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@JExercise(description = "Tests interfaces.CardContainerIterator")
@SuppressWarnings("all")
public class CardContainerIteratorTest extends TestCase {
  private CardContainerIterator cardContainerIterator;
  
  private CardContainerIterator _init_cardContainerIterator() {
    CardDeck _cardDeck = new CardDeck(2);
    CardContainerIterator _cardContainerIterator = new CardContainerIterator(_cardDeck);
    return _cardContainerIterator;
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
  
  @Override
  protected void setUp() {
    cardContainerIterator = _init_cardContainerIterator();
    s1 = _init_s1();
    s2 = _init_s2();
    h1 = _init_h1();
    h2 = _init_h2();
    d1 = _init_d1();
    d2 = _init_d2();
    c1 = _init_c1();
    c2 = _init_c2();
    
  }
  
  private static void testCards(final Iterator<Card> actual, final Iterator<Card> expected) {
    while (expected.hasNext()) {
      {
        boolean _hasNext = actual.hasNext();
        TestCase.assertTrue(_hasNext);
        final Card expectedCard = expected.next();
        final Card actualCard = actual.next();
        char _suit = expectedCard.getSuit();
        char _suit_1 = actualCard.getSuit();
        JextestExtensions.operator_assertEquals(_suit, _suit_1);
        int _face = expectedCard.getFace();
        int _face_1 = actualCard.getFace();
        JextestExtensions.operator_assertEquals(_face, _face_1);
      }
    }
  }
  
  @JExercise(tests = "CardContainerIterator(interfaces.CardContainer)", description = "Tests \n\t\tinitialization\n")
  public void testCardContainerIterator() {
    _test__cardContainerIterator_transitions0_effect_state();
    
  }
  
  private void _test__cardContainerIterator_transitions0_effect_state() {
    _test__cardContainerIterator_transitions0_effect_state_objectTests0_test();
    
  }
  
  private void _test__cardContainerIterator_transitions0_effect_state_objectTests0_test() {
    try {
      
      Iterator<Card> _iterator = Collections.<Card>unmodifiableList(CollectionLiterals.<Card>newArrayList(this.s1, this.s2, this.h1, this.h2, this.d1, this.d2, this.c1, this.c2)).iterator();
      CardContainerIteratorTest.testCards(this.cardContainerIterator, _iterator);
      } catch (junit.framework.AssertionFailedError error) {
      fail("testCards(cardContainerIterator, #[s1, s2, h1, h2, d1, d2, c1, c2].iterator) failed: " + error.getMessage());
    }
    
  }
  
  public static void main(final String[] args) {
    no.hal.jex.standalone.JexStandalone.main(CardContainerIteratorTest.class);
  }
}
