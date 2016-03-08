package interfaces;

import interfaces.Card;
import interfaces.CardContainer;
import interfaces.CardHand;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import junit.framework.TestCase;
import no.hal.jex.jextest.extensions.JextestExtensions;
import no.hal.jex.runtime.JExercise;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@JExercise(description = "Tests interfaces.CardHand")
@SuppressWarnings("all")
public class CardHandTest extends TestCase {
  private CardHand hand;
  
  private CardHand _init_hand() {
    return new CardHand();
    
  }
  
  private Card s1;
  
  private Card _init_s1() {
    Card _card = new Card('S', 1);
    return _card;
  }
  
  private Card c2;
  
  private Card _init_c2() {
    Card _card = new Card('C', 2);
    return _card;
  }
  
  private Collection<Card> expected;
  
  private Collection<Card> _init_expected() {
    return Collections.<Card>unmodifiableList(CollectionLiterals.<Card>newArrayList(this.s1, this.c2));
  }
  
  @Override
  protected void setUp() {
    hand = _init_hand();
    s1 = _init_s1();
    c2 = _init_c2();
    expected = _init_expected();
    
  }
  
  private boolean operator_assertEquals(final CardContainer it, final Collection<Card> expected) {
    boolean _xblockexpression = false;
    {
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
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  private boolean operator_assertEquals(final Iterable<Card> actual, final Iterator<Card> expected) {
    boolean _xblockexpression = false;
    {
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
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  @JExercise(tests = "CardHand();void addCard(interfaces.Card);java.util.Iterator<interfaces.Card> iterator()", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>hand.addCard(s1), hand.addCard(c2), hand.iterator</li>\n\t\t</ul>\n")
  public void testCardContainer() {
    _transition_exprAction__cardContainer_transitions0_actions0();
    _transition_exprAction__cardContainer_transitions0_actions1();
    _transition_exprAction__cardContainer_transitions0_actions2();
    _test__cardContainer_transitions0_effect_state();
    
  }
  
  @JExercise(tests = "CardHand();void addCard(interfaces.Card);java.util.Iterator<interfaces.Card> iterator()", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>hand.addCard(s1), hand.addCard(c2), hand.iterator</li>\n\t\t</ul>\n")
  public void testHandIterator() {
    _transition_exprAction__handIterator_transitions0_actions0();
    _transition_exprAction__handIterator_transitions0_actions1();
    _transition_exprAction__handIterator_transitions0_actions2();
    _test__handIterator_transitions0_effect_state();
    
  }
  
  private void _transition_exprAction__cardContainer_transitions0_actions0() {
    try {
      
      this.hand.addCard(this.s1);
      } catch (junit.framework.AssertionFailedError error) {
      fail("hand.addCard(s1) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__cardContainer_transitions0_actions1() {
    try {
      
      this.hand.addCard(this.c2);
      } catch (junit.framework.AssertionFailedError error) {
      fail("hand.addCard(c2) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__cardContainer_transitions0_actions2() {
    try {
      
      this.hand.iterator();
      } catch (junit.framework.AssertionFailedError error) {
      fail("hand.iterator failed: " + error.getMessage());
    }
    
  }
  
  private void _test__cardContainer_transitions0_effect_state() {
    _test__cardContainer_transitions0_effect_state_objectTests0_test();
    
  }
  
  private void _test__cardContainer_transitions0_effect_state_objectTests0_test() {
    
    assertTrue("hand ?= expected failed after hand.addCard(s1) ,hand.addCard(c2) ,hand.iterator", this.operator_assertEquals(
      this.hand, this.expected));
    
  }
  
  private void _transition_exprAction__handIterator_transitions0_actions0() {
    try {
      
      this.hand.addCard(this.s1);
      } catch (junit.framework.AssertionFailedError error) {
      fail("hand.addCard(s1) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__handIterator_transitions0_actions1() {
    try {
      
      this.hand.addCard(this.c2);
      } catch (junit.framework.AssertionFailedError error) {
      fail("hand.addCard(c2) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__handIterator_transitions0_actions2() {
    try {
      
      this.hand.iterator();
      } catch (junit.framework.AssertionFailedError error) {
      fail("hand.iterator failed: " + error.getMessage());
    }
    
  }
  
  private void _test__handIterator_transitions0_effect_state() {
    _test__handIterator_transitions0_effect_state_objectTests0_test();
    
  }
  
  private void _test__handIterator_transitions0_effect_state_objectTests0_test() {
    
    Iterator<Card> _iterator = this.expected.iterator();
    assertTrue("hand ?= expected.iterator failed after hand.addCard(s1) ,hand.addCard(c2) ,hand.iterator", this.operator_assertEquals(
      this.hand, _iterator));
    
  }
  
  public static void main(final String[] args) {
    no.hal.jex.standalone.JexStandalone.main(CardHandTest.class);
  }
}
