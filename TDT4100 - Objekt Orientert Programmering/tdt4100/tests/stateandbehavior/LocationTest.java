package stateandbehavior;

import junit.framework.TestCase;
import no.hal.jex.runtime.JExercise;

@JExercise(description = "Tests stateandbehavior.Location")
@SuppressWarnings("all")
public class LocationTest extends TestCase {
  private Location location;
  
  @Override
  protected void setUp() {
    location = new Location();
    
  }
  
  @JExercise(tests = "Location()", description = "<h3>Konstrukt\u00F8r</h3>Tests \n\t\tinitialization\n")
  public void testConstructor() {
    _test__constructor_transitions0_effect_state(location);
    
  }
  
  @JExercise(tests = "Location();void left()", description = "<h3>Venstre</h3>Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>Flytter til venstre: left</li>\n\t\t</ul>\n")
  public void testLeft() {
    _transition_exprAction__left_transitions0_actions0(location);
    _test__left_transitions0_effect_state(location);
    
  }
  
  @JExercise(tests = "Location();void right()", description = "<h3>H\u00F8yre</h3>Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>Flytter til h\u00F8yre: right</li>\n\t\t</ul>\n")
  public void testRight() {
    _transition_exprAction__right_transitions0_actions0(location);
    _test__right_transitions0_effect_state(location);
    
  }
  
  @JExercise(tests = "Location();void up()", description = "<h3>Opp</h3>Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>Flytter opp: up</li>\n\t\t</ul>\n")
  public void testUp() {
    _transition_exprAction__up_transitions0_actions0(location);
    _test__up_transitions0_effect_state(location);
    
  }
  
  @JExercise(tests = "Location();void down()", description = "<h3>Ned</h3>Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>Flytter ned: down</li>\n\t\t</ul>\n")
  public void testNed() {
    _transition_exprAction__ned_transitions0_actions0(location);
    _test__ned_transitions0_effect_state(location);
    
  }
  
  private void _test__constructor_transitions0_effect_state(final Location it) {
    _test__constructor_transitions0_effect_state_objectTests0_test(location);
    
  }
  
  private void _test__constructor_transitions0_effect_state_objectTests0_test(final Location it) {
    
    assertEquals("x == 0 failed", 0, it.x);
    
    assertEquals("y == 0 failed", 0, it.y);
    
  }
  
  private void _transition_exprAction__left_transitions0_actions0(final Location it) {
    try {
      
      it.left();
      } catch (junit.framework.AssertionFailedError error) {
      fail("left failed: " + error.getMessage());
    }
    
  }
  
  private void _test__left_transitions0_effect_state(final Location it) {
    _test__left_transitions0_effect_state_objectTests0_test(location);
    
  }
  
  private void _test__left_transitions0_effect_state_objectTests0_test(final Location it) {
    
    assertEquals("x == -1 failed after left", (-1), it.x);
    
    assertEquals("y == 0 failed after left", 0, it.y);
    
  }
  
  private void _transition_exprAction__right_transitions0_actions0(final Location it) {
    try {
      
      it.right();
      } catch (junit.framework.AssertionFailedError error) {
      fail("right failed: " + error.getMessage());
    }
    
  }
  
  private void _test__right_transitions0_effect_state(final Location it) {
    _test__right_transitions0_effect_state_objectTests0_test(location);
    
  }
  
  private void _test__right_transitions0_effect_state_objectTests0_test(final Location it) {
    
    assertEquals("x == 1 failed after right", 1, it.x);
    
    assertEquals("y == 0 failed after right", 0, it.y);
    
  }
  
  private void _transition_exprAction__up_transitions0_actions0(final Location it) {
    try {
      
      it.up();
      } catch (junit.framework.AssertionFailedError error) {
      fail("up failed: " + error.getMessage());
    }
    
  }
  
  private void _test__up_transitions0_effect_state(final Location it) {
    _test__up_transitions0_effect_state_objectTests0_test(location);
    
  }
  
  private void _test__up_transitions0_effect_state_objectTests0_test(final Location it) {
    
    assertEquals("x == 0 failed after up", 0, it.x);
    
    assertEquals("y == -1 failed after up", (-1), it.y);
    
  }
  
  private void _transition_exprAction__ned_transitions0_actions0(final Location it) {
    try {
      
      it.down();
      } catch (junit.framework.AssertionFailedError error) {
      fail("down failed: " + error.getMessage());
    }
    
  }
  
  private void _test__ned_transitions0_effect_state(final Location it) {
    _test__ned_transitions0_effect_state_objectTests0_test(location);
    
  }
  
  private void _test__ned_transitions0_effect_state_objectTests0_test(final Location it) {
    
    assertEquals("x == 0 failed after down", 0, it.x);
    
    assertEquals("y == 1 failed after down", 1, it.y);
    
  }
  
  public static void main(final String[] args) {
    no.hal.jex.standalone.JexStandalone.main(LocationTest.class);
  }
}
