package encapsulation;

import encapsulation.ConstrainedLocation;
import junit.framework.TestCase;
import no.hal.jex.runtime.JExercise;

@JExercise(description = "Tests encapsulation.ConstrainedLocation")
@SuppressWarnings("all")
public class ConstrainedLocationTest extends TestCase {
  private ConstrainedLocation location;
  
  private ConstrainedLocation _init_location() {
    ConstrainedLocation _constrainedLocation = new ConstrainedLocation(0, 0, (-2), (-2), 2, 2);
    return _constrainedLocation;
  }
  
  @Override
  protected void setUp() {
    location = _init_location();
    
  }
  
  @JExercise(tests = "ConstrainedLocation(int,int,int,int,int,int);ConstrainedLocation()", description = "<h3>Konstrukt\u00F8r</h3>Tests \n\t\tinitialization\n")
  public void testEmptyConstructor() {
    ConstrainedLocation emptyConstructorLocation = _init__emptyConstructor_emptyConstructorLocation();
    _test__emptyConstructor_transitions0_effect_state(location, emptyConstructorLocation);
    
  }
  
  @JExercise(tests = "ConstrainedLocation(int,int,int,int,int,int)", description = "<h3>Konstrukt\u00F8r med startposisjon (2, 3) og begrensninger</h3>Tests \n\t\tinitialization\n")
  public void testConstrainingConstructor() {
    ConstrainedLocation constrainingConstructorLocation = _init__constrainingConstructor_constrainingConstructorLocation();
    _test__constrainingConstructor_transitions0_effect_state(location, constrainingConstructorLocation);
    
  }
  
  @JExercise(tests = "ConstrainedLocation(int,int,int,int,int,int);void left()", description = "<h3>Venstre</h3>Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>Flytter til venstre: left</li>\n\t\t<li>Flytter forbi begrensning: left, left</li>\n\t\t</ul>\n")
  public void testLeft() {
    _transition_exprAction__left_transitions0_actions0(location);
    _test__left_transitions0_effect_state(location);
    _transition_exprAction__left_transitions1_actions0(location);
    _transition_exprAction__left_transitions1_actions1(location);
    _test__left_transitions1_effect_state(location);
    
  }
  
  @JExercise(tests = "ConstrainedLocation(int,int,int,int,int,int);void right()", description = "<h3>H\u00F8yre</h3>Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>Flytter til h\u00F8yre: right</li>\n\t\t<li>Flytter forbi begrensning: right, right</li>\n\t\t</ul>\n")
  public void testRight() {
    _transition_exprAction__right_transitions0_actions0(location);
    _test__right_transitions0_effect_state(location);
    _transition_exprAction__right_transitions1_actions0(location);
    _transition_exprAction__right_transitions1_actions1(location);
    _test__right_transitions1_effect_state(location);
    
  }
  
  @JExercise(tests = "ConstrainedLocation(int,int,int,int,int,int);void up()", description = "<h3>Opp</h3>Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>Flytter opp: up</li>\n\t\t<li>Flytter forbi begrensning: up, up</li>\n\t\t</ul>\n")
  public void testUp() {
    _transition_exprAction__up_transitions0_actions0(location);
    _test__up_transitions0_effect_state(location);
    _transition_exprAction__up_transitions1_actions0(location);
    _transition_exprAction__up_transitions1_actions1(location);
    _test__up_transitions1_effect_state(location);
    
  }
  
  @JExercise(tests = "ConstrainedLocation(int,int,int,int,int,int);void down()", description = "<h3>Ned</h3>Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>Flytter ned: down</li>\n\t\t<li>Flytter forbi begrensning: down, down</li>\n\t\t</ul>\n")
  public void testNed() {
    _transition_exprAction__ned_transitions0_actions0(location);
    _test__ned_transitions0_effect_state(location);
    _transition_exprAction__ned_transitions1_actions0(location);
    _transition_exprAction__ned_transitions1_actions1(location);
    _test__ned_transitions1_effect_state(location);
    
  }
  
  @JExercise(tests = "ConstrainedLocation(int,int,int,int,int,int)", description = "<h3>Validering av koordinater</h3>Tests \n\t\tinitialization\n")
  public void testIsValidCoordinates() {
    _test__isValidCoordinates_transitions0_effect_state(location);
    
  }
  
  private ConstrainedLocation _init__emptyConstructor_emptyConstructorLocation() {
    ConstrainedLocation _constrainedLocation = new ConstrainedLocation();
    return _constrainedLocation;
  }
  
  private void _test__emptyConstructor_transitions0_effect_state(final ConstrainedLocation it, final ConstrainedLocation emptyConstructorLocation) {
    _test__emptyConstructor_transitions0_effect_state_objectTests0_test(emptyConstructorLocation, emptyConstructorLocation);
    
  }
  
  private void _test__emptyConstructor_transitions0_effect_state_objectTests0_test(final ConstrainedLocation it, final ConstrainedLocation emptyConstructorLocation) {
    
    int _x = it.getX();
    assertEquals("x == 0 failed", 0, _x);
    
    int _y = it.getY();
    assertEquals("y == 0 failed", 0, _y);
    
  }
  
  private ConstrainedLocation _init__constrainingConstructor_constrainingConstructorLocation() {
    ConstrainedLocation _constrainedLocation = new ConstrainedLocation(2, 3, (-5), (-5), 5, 5);
    return _constrainedLocation;
  }
  
  private void _test__constrainingConstructor_transitions0_effect_state(final ConstrainedLocation it, final ConstrainedLocation constrainingConstructorLocation) {
    _test__constrainingConstructor_transitions0_effect_state_objectTests0_test(constrainingConstructorLocation, constrainingConstructorLocation);
    
  }
  
  private void _test__constrainingConstructor_transitions0_effect_state_objectTests0_test(final ConstrainedLocation it, final ConstrainedLocation constrainingConstructorLocation) {
    
    int _x = it.getX();
    assertEquals("x == 2 failed", 2, _x);
    
    int _y = it.getY();
    assertEquals("y == 3 failed", 3, _y);
    
  }
  
  private void _transition_exprAction__left_transitions0_actions0(final ConstrainedLocation it) {
    try {
      
      it.left();
      } catch (junit.framework.AssertionFailedError error) {
      fail("left failed: " + error.getMessage());
    }
    
  }
  
  private void _test__left_transitions0_effect_state(final ConstrainedLocation it) {
    _test__left_transitions0_effect_state_objectTests0_test(location);
    
  }
  
  private void _test__left_transitions0_effect_state_objectTests0_test(final ConstrainedLocation it) {
    
    int _x = it.getX();
    assertEquals("x == -1 failed after left", (-1), _x);
    
    int _y = it.getY();
    assertEquals("y == 0 failed after left", 0, _y);
    
  }
  
  private void _transition_exprAction__left_transitions1_actions0(final ConstrainedLocation it) {
    try {
      
      it.left();
      } catch (junit.framework.AssertionFailedError error) {
      fail("left failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__left_transitions1_actions1(final ConstrainedLocation it) {
    try {
      
      it.left();
      } catch (junit.framework.AssertionFailedError error) {
      fail("left failed: " + error.getMessage());
    }
    
  }
  
  private void _test__left_transitions1_effect_state(final ConstrainedLocation it) {
    _test__left_transitions1_effect_state_objectTests0_test(location);
    
  }
  
  private void _test__left_transitions1_effect_state_objectTests0_test(final ConstrainedLocation it) {
    
    int _x = it.getX();
    assertEquals("x == -2 failed after left ,left", (-2), _x);
    
    int _y = it.getY();
    assertEquals("y == 0 failed after left ,left", 0, _y);
    
  }
  
  private void _transition_exprAction__right_transitions0_actions0(final ConstrainedLocation it) {
    try {
      
      it.right();
      } catch (junit.framework.AssertionFailedError error) {
      fail("right failed: " + error.getMessage());
    }
    
  }
  
  private void _test__right_transitions0_effect_state(final ConstrainedLocation it) {
    _test__right_transitions0_effect_state_objectTests0_test(location);
    
  }
  
  private void _test__right_transitions0_effect_state_objectTests0_test(final ConstrainedLocation it) {
    
    int _x = it.getX();
    assertEquals("x == 1 failed after right", 1, _x);
    
    int _y = it.getY();
    assertEquals("y == 0 failed after right", 0, _y);
    
  }
  
  private void _transition_exprAction__right_transitions1_actions0(final ConstrainedLocation it) {
    try {
      
      it.right();
      } catch (junit.framework.AssertionFailedError error) {
      fail("right failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__right_transitions1_actions1(final ConstrainedLocation it) {
    try {
      
      it.right();
      } catch (junit.framework.AssertionFailedError error) {
      fail("right failed: " + error.getMessage());
    }
    
  }
  
  private void _test__right_transitions1_effect_state(final ConstrainedLocation it) {
    _test__right_transitions1_effect_state_objectTests0_test(location);
    
  }
  
  private void _test__right_transitions1_effect_state_objectTests0_test(final ConstrainedLocation it) {
    
    int _x = it.getX();
    assertEquals("x == 2 failed after right ,right", 2, _x);
    
    int _y = it.getY();
    assertEquals("y == 0 failed after right ,right", 0, _y);
    
  }
  
  private void _transition_exprAction__up_transitions0_actions0(final ConstrainedLocation it) {
    try {
      
      it.up();
      } catch (junit.framework.AssertionFailedError error) {
      fail("up failed: " + error.getMessage());
    }
    
  }
  
  private void _test__up_transitions0_effect_state(final ConstrainedLocation it) {
    _test__up_transitions0_effect_state_objectTests0_test(location);
    
  }
  
  private void _test__up_transitions0_effect_state_objectTests0_test(final ConstrainedLocation it) {
    
    int _x = it.getX();
    assertEquals("x == 0 failed after up", 0, _x);
    
    int _y = it.getY();
    assertEquals("y == -1 failed after up", (-1), _y);
    
  }
  
  private void _transition_exprAction__up_transitions1_actions0(final ConstrainedLocation it) {
    try {
      
      it.up();
      } catch (junit.framework.AssertionFailedError error) {
      fail("up failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__up_transitions1_actions1(final ConstrainedLocation it) {
    try {
      
      it.up();
      } catch (junit.framework.AssertionFailedError error) {
      fail("up failed: " + error.getMessage());
    }
    
  }
  
  private void _test__up_transitions1_effect_state(final ConstrainedLocation it) {
    _test__up_transitions1_effect_state_objectTests0_test(location);
    
  }
  
  private void _test__up_transitions1_effect_state_objectTests0_test(final ConstrainedLocation it) {
    
    int _x = it.getX();
    assertEquals("x == 0 failed after up ,up", 0, _x);
    
    int _y = it.getY();
    assertEquals("y == -2 failed after up ,up", (-2), _y);
    
  }
  
  private void _transition_exprAction__ned_transitions0_actions0(final ConstrainedLocation it) {
    try {
      
      it.down();
      } catch (junit.framework.AssertionFailedError error) {
      fail("down failed: " + error.getMessage());
    }
    
  }
  
  private void _test__ned_transitions0_effect_state(final ConstrainedLocation it) {
    _test__ned_transitions0_effect_state_objectTests0_test(location);
    
  }
  
  private void _test__ned_transitions0_effect_state_objectTests0_test(final ConstrainedLocation it) {
    
    int _x = it.getX();
    assertEquals("x == 0 failed after down", 0, _x);
    
    int _y = it.getY();
    assertEquals("y == 1 failed after down", 1, _y);
    
  }
  
  private void _transition_exprAction__ned_transitions1_actions0(final ConstrainedLocation it) {
    try {
      
      it.down();
      } catch (junit.framework.AssertionFailedError error) {
      fail("down failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__ned_transitions1_actions1(final ConstrainedLocation it) {
    try {
      
      it.down();
      } catch (junit.framework.AssertionFailedError error) {
      fail("down failed: " + error.getMessage());
    }
    
  }
  
  private void _test__ned_transitions1_effect_state(final ConstrainedLocation it) {
    _test__ned_transitions1_effect_state_objectTests0_test(location);
    
  }
  
  private void _test__ned_transitions1_effect_state_objectTests0_test(final ConstrainedLocation it) {
    
    int _x = it.getX();
    assertEquals("x == 0 failed after down ,down", 0, _x);
    
    int _y = it.getY();
    assertEquals("y == 2 failed after down ,down", 2, _y);
    
  }
  
  private void _test__isValidCoordinates_transitions0_effect_state(final ConstrainedLocation it) {
    _test__isValidCoordinates_transitions0_effect_state_objectTests0_test(location);
    
  }
  
  private void _test__isValidCoordinates_transitions0_effect_state_objectTests0_test(final ConstrainedLocation it) {
    
    boolean _isValidCoordinates = it.isValidCoordinates(0, 0);
    assertTrue("isValidCoordinates(0, 0) failed", _isValidCoordinates);
    
    boolean _isValidCoordinates_1 = it.isValidCoordinates((-1), 5);
    assertTrue("! isValidCoordinates(-1, 5) failed", (!_isValidCoordinates_1));
    
  }
  
  public static void main(final String[] args) {
    no.hal.jex.standalone.JexStandalone.main(ConstrainedLocationTest.class);
  }
}
