package objectstructures;

import java.util.Collection;
import java.util.Collections;
import junit.framework.TestCase;
import no.hal.jex.jextest.extensions.JextestExtensions;
import no.hal.jex.runtime.JExercise;
import objectstructures.Card;
import objectstructures.CardDeck;
import objectstructures.CardHand;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@JExercise(description = "Tests objectstructures.CardDeck")
@SuppressWarnings("all")
public class CardDeckTest extends TestCase {
  private CardDeck deck;
  
  private CardDeck _init_deck() {
    CardDeck _cardDeck = new CardDeck(2);
    return _cardDeck;
  }
  
  @Override
  protected void setUp() {
    deck = _init_deck();
    
  }
  
  private boolean operator_assertEquals(final CardDeck it, final Collection<String> toStrings) {
    boolean _xblockexpression = false;
    {
      int _cardCount = it.getCardCount();
      int _size = toStrings.size();
      boolean _assertEquals = JextestExtensions.operator_assertEquals(_cardCount, _size);
      boolean _not = (!_assertEquals);
      if (_not) {
        return false;
      }
      int i = 0;
      for (final String toString : toStrings) {
        {
          final Card card = it.getCard(i);
          char _suit = card.getSuit();
          String _valueOf = String.valueOf(_suit);
          int _face = card.getFace();
          String _plus = (_valueOf + Integer.valueOf(_face));
          boolean _assertEquals_1 = JextestExtensions.operator_assertEquals(_plus, toString);
          boolean _not_1 = (!_assertEquals_1);
          if (_not_1) {
            return false;
          }
          i = (i + 1);
        }
      }
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  @JExercise(tests = "CardDeck(int)", description = "Tests \n\t\tinitialization\n")
  public void testConstructor() {
    _test__constructor_transitions0_effect_state(deck);
    
  }
  
  @JExercise(tests = "CardDeck(int);void shufflePerfectly()", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>shufflePerfectly</li>\n\t\t</ul>\n")
  public void testShufflePerfectly() {
    _transition_exprAction__shufflePerfectly_transitions0_actions0(deck);
    _test__shufflePerfectly_transitions0_effect_state(deck);
    
  }
  
  @JExercise(tests = "CardDeck(int);void deal(objectstructures.CardHand,int)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>deal(hand, 3)</li>\n\t\t</ul>\n")
  public void testDeal() {
    CardHand hand = _init__deal_hand();
    _transition_exprAction__deal_transitions0_actions0(deck, hand);
    _test__deal_transitions0_effect_state(deck, hand);
    
  }
  
  private void _test__constructor_transitions0_effect_state(final CardDeck it) {
    _test__constructor_transitions0_effect_state_objectTests0_test(deck);
    
  }
  
  private void _test__constructor_transitions0_effect_state_objectTests0_test(final CardDeck it) {
    
    assertTrue("deck ?= #[\"S1\", \"S2\", \"H1\", \"H2\", \"D1\", \"D2\", \"C1\", \"C2\"] failed", this.operator_assertEquals(
      this.deck, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("S1", "S2", "H1", "H2", "D1", "D2", "C1", "C2"))));
    
  }
  
  private void _transition_exprAction__shufflePerfectly_transitions0_actions0(final CardDeck it) {
    try {
      
      it.shufflePerfectly();
      } catch (junit.framework.AssertionFailedError error) {
      fail("shufflePerfectly failed: " + error.getMessage());
    }
    
  }
  
  private void _test__shufflePerfectly_transitions0_effect_state(final CardDeck it) {
    _test__shufflePerfectly_transitions0_effect_state_objectTests0_test(deck);
    
  }
  
  private void _test__shufflePerfectly_transitions0_effect_state_objectTests0_test(final CardDeck it) {
    
    assertTrue("deck ?= #[\"S1\", \"D1\", \"S2\", \"D2\", \"H1\", \"C1\", \"H2\", \"C2\"] failed after shufflePerfectly", this.operator_assertEquals(
      this.deck, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("S1", "D1", "S2", "D2", "H1", "C1", "H2", "C2"))));
    
  }
  
  private CardHand _init__deal_hand() {
    return new CardHand();
    
  }
  
  private void _transition_exprAction__deal_transitions0_actions0(final CardDeck it, final CardHand hand) {
    try {
      
      it.deal(hand, 3);
      } catch (junit.framework.AssertionFailedError error) {
      fail("deal(hand, 3) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__deal_transitions0_effect_state(final CardDeck it, final CardHand hand) {
    _test__deal_transitions0_effect_state_objectTests0_test(deck, hand);
    
  }
  
  private void _test__deal_transitions0_effect_state_objectTests0_test(final CardDeck it, final CardHand hand) {
    
    assertTrue("deck ?= #[\"S1\", \"S2\", \"H1\", \"H2\", \"D1\"] failed after deal(hand, 3)", this.operator_assertEquals(
      this.deck, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("S1", "S2", "H1", "H2", "D1"))));
    
  }
  
  public static void main(final String[] args) {
    no.hal.jex.standalone.JexStandalone.main(CardDeckTest.class);
  }
}
