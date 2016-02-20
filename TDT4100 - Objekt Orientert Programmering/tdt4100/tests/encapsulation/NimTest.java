package encapsulation;

import encapsulation.Nim;
import junit.framework.TestCase;
import no.hal.jex.runtime.JExercise;

@JExercise(description = "Tests encapsulation.Nim")
@SuppressWarnings("all")
public class NimTest extends TestCase {
  private Nim nim;
  
  private Nim _init_nim() {
    Nim _nim = new Nim(5);
    return _nim;
  }
  
  @Override
  protected void setUp() {
    nim = _init_nim();
    
  }
  
  private boolean isValidMove(final Nim game, final int pieces, final boolean legal) {
    boolean _and = false;
    boolean _and_1 = false;
    boolean _isValidMove = game.isValidMove(pieces, 0);
    boolean _equals = (legal == _isValidMove);
    if (!_equals) {
      _and_1 = false;
    } else {
      boolean _isValidMove_1 = game.isValidMove(pieces, 1);
      boolean _equals_1 = (legal == _isValidMove_1);
      _and_1 = _equals_1;
    }
    if (!_and_1) {
      _and = false;
    } else {
      boolean _isValidMove_2 = game.isValidMove(pieces, 2);
      boolean _equals_2 = (legal == _isValidMove_2);
      _and = _equals_2;
    }
    return _and;
  }
  
  @JExercise(tests = "Nim(int)", description = "<h3>Konstrukt\u00F8r</h3>Tests \n\t\tinitialization\n")
  public void testConstructor() {
    _test__constructor_transitions0_effect_state(nim);
    
  }
  
  @JExercise(tests = "Nim(int);void removePieces(int,int)", description = "<h3>Fjerning av brikker</h3>Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>Fjerner brikker: removePieces(3, 0), removePieces(2, 1), removePieces(1, 2)</li>\n\t\t<li>Fjerner negativt antall: removePieces(-1, 0)</li>\n\t\t<li>Fjerner for f\u00E5 brikker: removePieces(0, 0)</li>\n\t\t<li>Fjerner for mange brikker: removePieces(6, 0)</li>\n\t\t</ul>\n")
  public void testRemovePieces() {
    _transition_exprAction__removePieces_transitions0_actions0(nim);
    _transition_exprAction__removePieces_transitions0_actions1(nim);
    _transition_exprAction__removePieces_transitions0_actions2(nim);
    _test__removePieces_transitions0_effect_state(nim);
    try {
      _transition_exprAction__removePieces_transitions1_actions0(nim);
      fail("IllegalArgumentException should be thrown after removePieces(-1, 0)");
    } catch (Exception e) {
      assertTrue("IllegalArgumentException should be thrown after removePieces(-1, 0)", e instanceof IllegalArgumentException);
    }
    try {
      _transition_exprAction__removePieces_transitions2_actions0(nim);
      fail("IllegalArgumentException should be thrown after removePieces(0, 0)");
    } catch (Exception e_1) {
      assertTrue("IllegalArgumentException should be thrown after removePieces(0, 0)", e_1 instanceof IllegalArgumentException);
    }
    try {
      _transition_exprAction__removePieces_transitions3_actions0(nim);
      fail("IllegalArgumentException should be thrown after removePieces(6, 0)");
    } catch (Exception e_2) {
      assertTrue("IllegalArgumentException should be thrown after removePieces(6, 0)", e_2 instanceof IllegalArgumentException);
    }
    
  }
  
  @JExercise(tests = "Nim(int);void removePieces(int,int)", description = "<h3>Avsluttet spill</h3>Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>Fjerner brikker: removePieces(5, 0)</li>\n\t\t<li>Fjerner brikker etter avsluttet spill : removePieces(5, 0)</li>\n\t\t</ul>\n")
  public void testGameOver() {
    _test__gameOver_transitions0_effect_state(nim);
    _transition_exprAction__gameOver_transitions1_actions0(nim);
    _test__gameOver_transitions1_effect_state(nim);
    try {
      _transition_exprAction__gameOver_transitions2_actions0(nim);
      fail("IllegalStateException should be thrown after removePieces(5, 0)");
    } catch (Exception e) {
      assertTrue("IllegalStateException should be thrown after removePieces(5, 0)", e instanceof IllegalStateException);
    }
    
  }
  
  @JExercise(tests = "Nim(int);void removePieces(int,int)", description = "<h3>Gyldige trekk</h3>Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>Avslutter spillet: removePieces(5, 0)</li>\n\t\t</ul>\n")
  public void testIsValidMove() {
    _test__isValidMove_transitions0_effect_state(nim);
    _transition_exprAction__isValidMove_transitions1_actions0(nim);
    _test__isValidMove_transitions1_effect_state(nim);
    
  }
  
  private void _test__constructor_transitions0_effect_state(final Nim it) {
    _test__constructor_transitions0_effect_state_objectTests0_test(nim);
    
  }
  
  private void _test__constructor_transitions0_effect_state_objectTests0_test(final Nim it) {
    
    int _pile = it.getPile(0);
    assertEquals("getPile(0) == 5 failed", 5, _pile);
    
    int _pile_1 = it.getPile(1);
    assertEquals("getPile(1) == 5 failed", 5, _pile_1);
    
    int _pile_2 = it.getPile(2);
    assertEquals("getPile(2) == 5 failed", 5, _pile_2);
    
  }
  
  private void _transition_exprAction__removePieces_transitions0_actions0(final Nim it) {
    try {
      
      it.removePieces(3, 0);
      } catch (junit.framework.AssertionFailedError error) {
      fail("removePieces(3, 0) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__removePieces_transitions0_actions1(final Nim it) {
    try {
      
      it.removePieces(2, 1);
      } catch (junit.framework.AssertionFailedError error) {
      fail("removePieces(2, 1) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__removePieces_transitions0_actions2(final Nim it) {
    try {
      
      it.removePieces(1, 2);
      } catch (junit.framework.AssertionFailedError error) {
      fail("removePieces(1, 2) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__removePieces_transitions0_effect_state(final Nim it) {
    _test__removePieces_transitions0_effect_state_objectTests0_test(nim);
    
  }
  
  private void _test__removePieces_transitions0_effect_state_objectTests0_test(final Nim it) {
    
    int _pile = it.getPile(0);
    assertEquals("getPile(0) == 2 failed after removePieces(3, 0) ,removePieces(2, 1) ,removePieces(1, 2)", 2, _pile);
    
    int _pile_1 = it.getPile(1);
    assertEquals("getPile(1) == 3 failed after removePieces(3, 0) ,removePieces(2, 1) ,removePieces(1, 2)", 3, _pile_1);
    
    int _pile_2 = it.getPile(2);
    assertEquals("getPile(2) == 4 failed after removePieces(3, 0) ,removePieces(2, 1) ,removePieces(1, 2)", 4, _pile_2);
    
  }
  
  private void _transition_exprAction__removePieces_transitions1_actions0(final Nim it) {
    try {
      
      it.removePieces((-1), 0);
      } catch (junit.framework.AssertionFailedError error) {
      fail("removePieces(-1, 0) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__removePieces_transitions2_actions0(final Nim it) {
    try {
      
      it.removePieces(0, 0);
      } catch (junit.framework.AssertionFailedError error) {
      fail("removePieces(0, 0) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__removePieces_transitions3_actions0(final Nim it) {
    try {
      
      it.removePieces(6, 0);
      } catch (junit.framework.AssertionFailedError error) {
      fail("removePieces(6, 0) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__gameOver_transitions0_effect_state(final Nim it) {
    _test__gameOver_transitions0_effect_state_objectTests0_test(nim);
    
  }
  
  private void _test__gameOver_transitions0_effect_state_objectTests0_test(final Nim it) {
    
    boolean _isGameOver = it.isGameOver();
    assertTrue("! isGameOver() failed", (!_isGameOver));
    
  }
  
  private void _transition_exprAction__gameOver_transitions1_actions0(final Nim it) {
    try {
      
      it.removePieces(5, 0);
      } catch (junit.framework.AssertionFailedError error) {
      fail("removePieces(5, 0) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__gameOver_transitions1_effect_state(final Nim it) {
    _test__gameOver_transitions1_effect_state_objectTests0_test(nim);
    
  }
  
  private void _test__gameOver_transitions1_effect_state_objectTests0_test(final Nim it) {
    
    int _pile = it.getPile(0);
    assertEquals("getPile(0) == 0 failed after removePieces(5, 0)", 0, _pile);
    
    assertTrue("isGameOver() failed after removePieces(5, 0)", it.isGameOver());
    
  }
  
  private void _transition_exprAction__gameOver_transitions2_actions0(final Nim it) {
    try {
      
      it.removePieces(5, 0);
      } catch (junit.framework.AssertionFailedError error) {
      fail("removePieces(5, 0) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__isValidMove_transitions0_effect_state(final Nim it) {
    _test__isValidMove_transitions0_effect_state_objectTests0_test(nim);
    
  }
  
  private void _test__isValidMove_transitions0_effect_state_objectTests0_test(final Nim it) {
    
    boolean _isValidMove = this.isValidMove(it, 2, true);
    assertTrue("isValidMove(2, true) failed", _isValidMove);
    
    boolean _isValidMove_1 = this.isValidMove(it, (-2), false);
    assertTrue("isValidMove(-2, false) failed", _isValidMove_1);
    
    boolean _isValidMove_2 = this.isValidMove(it, 0, false);
    assertTrue("isValidMove(0, false) failed", _isValidMove_2);
    
    assertTrue("isValidMove(6, false) failed", this.isValidMove(it, 6, false));
    
  }
  
  private void _transition_exprAction__isValidMove_transitions1_actions0(final Nim it) {
    try {
      
      it.removePieces(5, 0);
      } catch (junit.framework.AssertionFailedError error) {
      fail("removePieces(5, 0) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__isValidMove_transitions1_effect_state(final Nim it) {
    _test__isValidMove_transitions1_effect_state_objectTests0_test(nim);
    
  }
  
  private void _test__isValidMove_transitions1_effect_state_objectTests0_test(final Nim it) {
    
    assertTrue("isValidMove(2, false) failed after removePieces(5, 0)", this.isValidMove(it, 2, false));
    
  }
  
  public static void main(final String[] args) {
    no.hal.jex.standalone.JexStandalone.main(NimTest.class);
  }
}
