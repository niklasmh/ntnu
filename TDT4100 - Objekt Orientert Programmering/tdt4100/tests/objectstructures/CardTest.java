package objectstructures;

import junit.framework.TestCase;
import no.hal.jex.runtime.JExercise;
import objectstructures.Card;

@JExercise(description = "Tests objectstructures.Card")
@SuppressWarnings("all")
public class CardTest extends TestCase {
  private Card c;
  
  private Card _init_c() {
    return null;
  }
  
  @Override
  protected void setUp() {
    c = _init_c();
    
  }
  
  private boolean operator_equals(final Character c, final String s) {
    boolean _and = false;
    int _length = s.length();
    boolean _equals = (_length == 1);
    if (!_equals) {
      _and = false;
    } else {
      char _charAt = s.charAt(0);
      boolean _equals_1 = ((c).charValue() == _charAt);
      _and = _equals_1;
    }
    return _and;
  }
  
  @JExercise(tests = "Card(char,int)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>c = new Card(\'S\', 1)</li>\n\t\t<li>c = new Card(\'S\', 13)</li>\n\t\t<li>c = new Card(\'H\', 1)</li>\n\t\t<li>c = new Card(\'H\', 13)</li>\n\t\t<li>c = new Card(\'D\', 1)</li>\n\t\t<li>c = new Card(\'D\', 13)</li>\n\t\t<li>c = new Card(\'C\', 1)</li>\n\t\t<li>c = new Card(\'C\', 13)</li>\n\t\t<li>c = new Card(\'X\', 1)</li>\n\t\t<li>c = new Card(\'S\', 0)</li>\n\t\t<li>c = new Card(\'C\', 14)</li>\n\t\t</ul>\n")
  public void testConstructor() {
    _transition_exprAction__constructor_transitions0_actions0(c);
    _test__constructor_transitions0_effect_state(c);
    _transition_exprAction__constructor_transitions1_actions0(c);
    _test__constructor_transitions1_effect_state(c);
    _transition_exprAction__constructor_transitions2_actions0(c);
    _test__constructor_transitions2_effect_state(c);
    _transition_exprAction__constructor_transitions3_actions0(c);
    _test__constructor_transitions3_effect_state(c);
    _transition_exprAction__constructor_transitions4_actions0(c);
    _test__constructor_transitions4_effect_state(c);
    _transition_exprAction__constructor_transitions5_actions0(c);
    _test__constructor_transitions5_effect_state(c);
    _transition_exprAction__constructor_transitions6_actions0(c);
    _test__constructor_transitions6_effect_state(c);
    _transition_exprAction__constructor_transitions7_actions0(c);
    _test__constructor_transitions7_effect_state(c);
    try {
      _transition_exprAction__constructor_transitions8_actions0(c);
      fail("IllegalArgumentException should be thrown after c = new Card('X', 1)");
    } catch (Exception e) {
      assertTrue("IllegalArgumentException should be thrown after c = new Card('X', 1)", e instanceof IllegalArgumentException);
    }
    try {
      _transition_exprAction__constructor_transitions9_actions0(c);
      fail("IllegalArgumentException should be thrown after c = new Card('S', 0)");
    } catch (Exception e_1) {
      assertTrue("IllegalArgumentException should be thrown after c = new Card('S', 0)", e_1 instanceof IllegalArgumentException);
    }
    try {
      _transition_exprAction__constructor_transitions10_actions0(c);
      fail("IllegalArgumentException should be thrown after c = new Card('C', 14)");
    } catch (Exception e_2) {
      assertTrue("IllegalArgumentException should be thrown after c = new Card('C', 14)", e_2 instanceof IllegalArgumentException);
    }
    
  }
  
  @JExercise(tests = "Card(char,int)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>c = new Card(\'S\', 1)</li>\n\t\t<li>c = new Card(\'S\', 13)</li>\n\t\t<li>c = new Card(\'H\', 1)</li>\n\t\t<li>c = new Card(\'H\', 13)</li>\n\t\t<li>c = new Card(\'D\', 1)</li>\n\t\t<li>c = new Card(\'D\', 13)</li>\n\t\t<li>c = new Card(\'C\', 1)</li>\n\t\t<li>c = new Card(\'C\', 13)</li>\n\t\t</ul>\n")
  public void testToString() {
    _transition_exprAction__toString_transitions0_actions0(c);
    _test__toString_transitions0_effect_state(c);
    _transition_exprAction__toString_transitions1_actions0(c);
    _test__toString_transitions1_effect_state(c);
    _transition_exprAction__toString_transitions2_actions0(c);
    _test__toString_transitions2_effect_state(c);
    _transition_exprAction__toString_transitions3_actions0(c);
    _test__toString_transitions3_effect_state(c);
    _transition_exprAction__toString_transitions4_actions0(c);
    _test__toString_transitions4_effect_state(c);
    _transition_exprAction__toString_transitions5_actions0(c);
    _test__toString_transitions5_effect_state(c);
    _transition_exprAction__toString_transitions6_actions0(c);
    _test__toString_transitions6_effect_state(c);
    _transition_exprAction__toString_transitions7_actions0(c);
    _test__toString_transitions7_effect_state(c);
    
  }
  
  private void _transition_exprAction__constructor_transitions0_actions0(final Card it) {
    try {
      
      Card _card = new Card('S', 1);
      this.c = _card;
      } catch (junit.framework.AssertionFailedError error) {
      fail("c = new Card('S', 1) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__constructor_transitions0_effect_state(final Card it) {
    _test__constructor_transitions0_effect_state_objectTests0_test(c);
    
  }
  
  private void _test__constructor_transitions0_effect_state_objectTests0_test(final Card it) {
    
    char _suit = it.getSuit();
    boolean _equals = this.operator_equals(Character.valueOf(_suit), "S");
    assertTrue("suit == 'S' failed after c = new Card('S', 1)", _equals);
    
    int _face = it.getFace();
    assertEquals("face == 1 failed after c = new Card('S', 1)", 1, _face);
    
  }
  
  private void _transition_exprAction__constructor_transitions1_actions0(final Card it) {
    try {
      
      Card _card = new Card('S', 13);
      this.c = _card;
      } catch (junit.framework.AssertionFailedError error) {
      fail("c = new Card('S', 13) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__constructor_transitions1_effect_state(final Card it) {
    _test__constructor_transitions1_effect_state_objectTests0_test(c);
    
  }
  
  private void _test__constructor_transitions1_effect_state_objectTests0_test(final Card it) {
    
    char _suit = it.getSuit();
    boolean _equals = this.operator_equals(Character.valueOf(_suit), "S");
    assertTrue("suit == 'S' failed after c = new Card('S', 13)", _equals);
    
    int _face = it.getFace();
    assertEquals("face == 13 failed after c = new Card('S', 13)", 13, _face);
    
  }
  
  private void _transition_exprAction__constructor_transitions2_actions0(final Card it) {
    try {
      
      Card _card = new Card('H', 1);
      this.c = _card;
      } catch (junit.framework.AssertionFailedError error) {
      fail("c = new Card('H', 1) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__constructor_transitions2_effect_state(final Card it) {
    _test__constructor_transitions2_effect_state_objectTests0_test(c);
    
  }
  
  private void _test__constructor_transitions2_effect_state_objectTests0_test(final Card it) {
    
    char _suit = it.getSuit();
    boolean _equals = this.operator_equals(Character.valueOf(_suit), "H");
    assertTrue("suit == 'H' failed after c = new Card('H', 1)", _equals);
    
    int _face = it.getFace();
    assertEquals("face == 1 failed after c = new Card('H', 1)", 1, _face);
    
  }
  
  private void _transition_exprAction__constructor_transitions3_actions0(final Card it) {
    try {
      
      Card _card = new Card('H', 13);
      this.c = _card;
      } catch (junit.framework.AssertionFailedError error) {
      fail("c = new Card('H', 13) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__constructor_transitions3_effect_state(final Card it) {
    _test__constructor_transitions3_effect_state_objectTests0_test(c);
    
  }
  
  private void _test__constructor_transitions3_effect_state_objectTests0_test(final Card it) {
    
    char _suit = it.getSuit();
    boolean _equals = this.operator_equals(Character.valueOf(_suit), "H");
    assertTrue("suit == 'H' failed after c = new Card('H', 13)", _equals);
    
    int _face = it.getFace();
    assertEquals("face == 13 failed after c = new Card('H', 13)", 13, _face);
    
  }
  
  private void _transition_exprAction__constructor_transitions4_actions0(final Card it) {
    try {
      
      Card _card = new Card('D', 1);
      this.c = _card;
      } catch (junit.framework.AssertionFailedError error) {
      fail("c = new Card('D', 1) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__constructor_transitions4_effect_state(final Card it) {
    _test__constructor_transitions4_effect_state_objectTests0_test(c);
    
  }
  
  private void _test__constructor_transitions4_effect_state_objectTests0_test(final Card it) {
    
    char _suit = it.getSuit();
    boolean _equals = this.operator_equals(Character.valueOf(_suit), "D");
    assertTrue("suit == 'D' failed after c = new Card('D', 1)", _equals);
    
    int _face = it.getFace();
    assertEquals("face == 1 failed after c = new Card('D', 1)", 1, _face);
    
  }
  
  private void _transition_exprAction__constructor_transitions5_actions0(final Card it) {
    try {
      
      Card _card = new Card('D', 13);
      this.c = _card;
      } catch (junit.framework.AssertionFailedError error) {
      fail("c = new Card('D', 13) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__constructor_transitions5_effect_state(final Card it) {
    _test__constructor_transitions5_effect_state_objectTests0_test(c);
    
  }
  
  private void _test__constructor_transitions5_effect_state_objectTests0_test(final Card it) {
    
    char _suit = it.getSuit();
    boolean _equals = this.operator_equals(Character.valueOf(_suit), "D");
    assertTrue("suit == 'D' failed after c = new Card('D', 13)", _equals);
    
    int _face = it.getFace();
    assertEquals("face == 13 failed after c = new Card('D', 13)", 13, _face);
    
  }
  
  private void _transition_exprAction__constructor_transitions6_actions0(final Card it) {
    try {
      
      Card _card = new Card('C', 1);
      this.c = _card;
      } catch (junit.framework.AssertionFailedError error) {
      fail("c = new Card('C', 1) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__constructor_transitions6_effect_state(final Card it) {
    _test__constructor_transitions6_effect_state_objectTests0_test(c);
    
  }
  
  private void _test__constructor_transitions6_effect_state_objectTests0_test(final Card it) {
    
    char _suit = it.getSuit();
    boolean _equals = this.operator_equals(Character.valueOf(_suit), "C");
    assertTrue("suit == 'C' failed after c = new Card('C', 1)", _equals);
    
    int _face = it.getFace();
    assertEquals("face == 1 failed after c = new Card('C', 1)", 1, _face);
    
  }
  
  private void _transition_exprAction__constructor_transitions7_actions0(final Card it) {
    try {
      
      Card _card = new Card('C', 13);
      this.c = _card;
      } catch (junit.framework.AssertionFailedError error) {
      fail("c = new Card('C', 13) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__constructor_transitions7_effect_state(final Card it) {
    _test__constructor_transitions7_effect_state_objectTests0_test(c);
    
  }
  
  private void _test__constructor_transitions7_effect_state_objectTests0_test(final Card it) {
    
    char _suit = it.getSuit();
    boolean _equals = this.operator_equals(Character.valueOf(_suit), "C");
    assertTrue("suit == 'C' failed after c = new Card('C', 13)", _equals);
    
    int _face = it.getFace();
    assertEquals("face == 13 failed after c = new Card('C', 13)", 13, _face);
    
  }
  
  private void _transition_exprAction__constructor_transitions8_actions0(final Card it) {
    try {
      
      Card _card = new Card('X', 1);
      this.c = _card;
      } catch (junit.framework.AssertionFailedError error) {
      fail("c = new Card('X', 1) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__constructor_transitions9_actions0(final Card it) {
    try {
      
      Card _card = new Card('S', 0);
      this.c = _card;
      } catch (junit.framework.AssertionFailedError error) {
      fail("c = new Card('S', 0) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__constructor_transitions10_actions0(final Card it) {
    try {
      
      Card _card = new Card('C', 14);
      this.c = _card;
      } catch (junit.framework.AssertionFailedError error) {
      fail("c = new Card('C', 14) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__toString_transitions0_actions0(final Card it) {
    try {
      
      Card _card = new Card('S', 1);
      this.c = _card;
      } catch (junit.framework.AssertionFailedError error) {
      fail("c = new Card('S', 1) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__toString_transitions0_effect_state(final Card it) {
    _test__toString_transitions0_effect_state_objectTests0_test(c);
    
  }
  
  private void _test__toString_transitions0_effect_state_objectTests0_test(final Card it) {
    
    String _string = it.toString();
    assertEquals("toString == 'S1' failed after c = new Card('S', 1)", "S1", _string);
    
  }
  
  private void _transition_exprAction__toString_transitions1_actions0(final Card it) {
    try {
      
      Card _card = new Card('S', 13);
      this.c = _card;
      } catch (junit.framework.AssertionFailedError error) {
      fail("c = new Card('S', 13) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__toString_transitions1_effect_state(final Card it) {
    _test__toString_transitions1_effect_state_objectTests0_test(c);
    
  }
  
  private void _test__toString_transitions1_effect_state_objectTests0_test(final Card it) {
    
    String _string = it.toString();
    assertEquals("toString == 'S13' failed after c = new Card('S', 13)", "S13", _string);
    
  }
  
  private void _transition_exprAction__toString_transitions2_actions0(final Card it) {
    try {
      
      Card _card = new Card('H', 1);
      this.c = _card;
      } catch (junit.framework.AssertionFailedError error) {
      fail("c = new Card('H', 1) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__toString_transitions2_effect_state(final Card it) {
    _test__toString_transitions2_effect_state_objectTests0_test(c);
    
  }
  
  private void _test__toString_transitions2_effect_state_objectTests0_test(final Card it) {
    
    String _string = it.toString();
    assertEquals("toString == 'H1' failed after c = new Card('H', 1)", "H1", _string);
    
  }
  
  private void _transition_exprAction__toString_transitions3_actions0(final Card it) {
    try {
      
      Card _card = new Card('H', 13);
      this.c = _card;
      } catch (junit.framework.AssertionFailedError error) {
      fail("c = new Card('H', 13) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__toString_transitions3_effect_state(final Card it) {
    _test__toString_transitions3_effect_state_objectTests0_test(c);
    
  }
  
  private void _test__toString_transitions3_effect_state_objectTests0_test(final Card it) {
    
    String _string = it.toString();
    assertEquals("toString == 'H13' failed after c = new Card('H', 13)", "H13", _string);
    
  }
  
  private void _transition_exprAction__toString_transitions4_actions0(final Card it) {
    try {
      
      Card _card = new Card('D', 1);
      this.c = _card;
      } catch (junit.framework.AssertionFailedError error) {
      fail("c = new Card('D', 1) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__toString_transitions4_effect_state(final Card it) {
    _test__toString_transitions4_effect_state_objectTests0_test(c);
    
  }
  
  private void _test__toString_transitions4_effect_state_objectTests0_test(final Card it) {
    
    String _string = it.toString();
    assertEquals("toString == 'D1' failed after c = new Card('D', 1)", "D1", _string);
    
  }
  
  private void _transition_exprAction__toString_transitions5_actions0(final Card it) {
    try {
      
      Card _card = new Card('D', 13);
      this.c = _card;
      } catch (junit.framework.AssertionFailedError error) {
      fail("c = new Card('D', 13) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__toString_transitions5_effect_state(final Card it) {
    _test__toString_transitions5_effect_state_objectTests0_test(c);
    
  }
  
  private void _test__toString_transitions5_effect_state_objectTests0_test(final Card it) {
    
    String _string = it.toString();
    assertEquals("toString == 'D13' failed after c = new Card('D', 13)", "D13", _string);
    
  }
  
  private void _transition_exprAction__toString_transitions6_actions0(final Card it) {
    try {
      
      Card _card = new Card('C', 1);
      this.c = _card;
      } catch (junit.framework.AssertionFailedError error) {
      fail("c = new Card('C', 1) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__toString_transitions6_effect_state(final Card it) {
    _test__toString_transitions6_effect_state_objectTests0_test(c);
    
  }
  
  private void _test__toString_transitions6_effect_state_objectTests0_test(final Card it) {
    
    String _string = it.toString();
    assertEquals("toString == 'C1' failed after c = new Card('C', 1)", "C1", _string);
    
  }
  
  private void _transition_exprAction__toString_transitions7_actions0(final Card it) {
    try {
      
      Card _card = new Card('C', 13);
      this.c = _card;
      } catch (junit.framework.AssertionFailedError error) {
      fail("c = new Card('C', 13) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__toString_transitions7_effect_state(final Card it) {
    _test__toString_transitions7_effect_state_objectTests0_test(c);
    
  }
  
  private void _test__toString_transitions7_effect_state_objectTests0_test(final Card it) {
    
    String _string = it.toString();
    assertEquals("toString == 'C13' failed after c = new Card('C', 13)", "C13", _string);
    
  }
  
  public static void main(final String[] args) {
    no.hal.jex.standalone.JexStandalone.main(CardTest.class);
  }
}
