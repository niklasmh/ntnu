package delegation;

import com.google.common.base.Objects;
import delegation.ILogger;
import delegation.StreamLogger;
import java.io.ByteArrayOutputStream;
import junit.framework.TestCase;
import no.hal.jex.runtime.JExercise;

@JExercise(description = "Tests delegation.StreamLogger")
@SuppressWarnings("all")
public class StreamLoggerTest extends TestCase {
  private String formatString;
  
  private String _init_formatString() {
    return "%s: %s (%s)";
  }
  
  private ByteArrayOutputStream stream;
  
  private ByteArrayOutputStream _init_stream() {
    ByteArrayOutputStream _byteArrayOutputStream = new ByteArrayOutputStream();
    return _byteArrayOutputStream;
  }
  
  private StreamLogger logger;
  
  private StreamLogger _init_logger() {
    StreamLogger _streamLogger = new StreamLogger(this.stream);
    return _streamLogger;
  }
  
  @Override
  protected void setUp() {
    formatString = _init_formatString();
    stream = _init_stream();
    logger = _init_logger();
    
  }
  
  private boolean operator_equals(final ByteArrayOutputStream stream, final String content) {
    String _string = stream.toString();
    String _trim = _string.trim();
    String _trim_1 = content.trim();
    return Objects.equal(_trim, _trim_1);
  }
  
  @JExercise(tests = "StreamLogger(java.io.OutputStream);void log(String,String,Exception)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>Logger infomelding: logger.log(ILogger.INFO, \"En melding ble logget!\", null)</li>\n\t\t</ul>\n")
  public void testLog() {
    _transition_exprAction__log_transitions0_actions0();
    _test__log_transitions0_effect_state();
    
  }
  
  @JExercise(tests = "StreamLogger(java.io.OutputStream);void setFormatString(String);void log(String,String,Exception)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>Logger unntak: logger.setFormatString(formatString), logger.log(ILogger.INFO, \"En melding ble logget!\", exception)</li>\n\t\t</ul>\n")
  public void testLogException() {
    IllegalStateException exception = _init__logException_exception();
    _transition_exprAction__logException_transitions0_actions0(exception);
    _transition_exprAction__logException_transitions0_actions1(exception);
    _test__logException_transitions0_effect_state(exception);
    
  }
  
  @JExercise(tests = "StreamLogger(java.io.OutputStream);void setFormatString(String);void log(String,String,Exception)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>Logger infomelding med spesifisert format: logger.setFormatString(formatString), logger.log(ILogger.INFO, \"En melding ble logget!\", exception)</li>\n\t\t</ul>\n")
  public void testLogWithFormat() {
    IllegalStateException exception = _init__logWithFormat_exception();
    _transition_exprAction__logWithFormat_transitions0_actions0(exception);
    _transition_exprAction__logWithFormat_transitions0_actions1(exception);
    _test__logWithFormat_transitions0_effect_state(exception);
    
  }
  
  private void _transition_exprAction__log_transitions0_actions0() {
    try {
      
      this.logger.log(ILogger.INFO, "En melding ble logget!", null);
      } catch (junit.framework.AssertionFailedError error) {
      fail("logger.log(ILogger.INFO, \"En melding ble logget!\", null) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__log_transitions0_effect_state() {
    _test__log_transitions0_effect_state_objectTests0_test();
    
  }
  
  private void _test__log_transitions0_effect_state_objectTests0_test() {
    
    String _string = this.stream.toString();
    boolean _contains = _string.contains("En melding ble logget!");
    assertTrue("stream.toString().contains(\"En melding ble logget!\") failed after logger.log(ILogger.INFO, \"En melding ble logget!\", null)", _contains);
    
    String _string_1 = this.stream.toString();
    assertTrue("stream.toString().contains(ILogger.INFO) failed after logger.log(ILogger.INFO, \"En melding ble logget!\", null)", _string_1.contains(ILogger.INFO));
    
  }
  
  private IllegalStateException _init__logException_exception() {
    IllegalStateException _illegalStateException = new IllegalStateException();
    return _illegalStateException;
  }
  
  private void _transition_exprAction__logException_transitions0_actions0(final IllegalStateException exception) {
    try {
      
      this.logger.setFormatString(this.formatString);
      } catch (junit.framework.AssertionFailedError error) {
      fail("logger.setFormatString(formatString) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__logException_transitions0_actions1(final IllegalStateException exception) {
    try {
      
      this.logger.log(ILogger.INFO, "En melding ble logget!", exception);
      } catch (junit.framework.AssertionFailedError error) {
      fail("logger.log(ILogger.INFO, \"En melding ble logget!\", exception) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__logException_transitions0_effect_state(final IllegalStateException exception) {
    _test__logException_transitions0_effect_state_objectTests0_test(exception);
    
  }
  
  private void _test__logException_transitions0_effect_state_objectTests0_test(final IllegalStateException exception) {
    
    String _format = String.format(this.formatString, ILogger.INFO, "En melding ble logget!", exception);
    assertTrue("stream == String.format(formatString, ILogger.INFO, \"En melding ble logget!\", exception) failed after logger.setFormatString(formatString) ,logger.log(ILogger.INFO, \"En melding ble logget!\", exception)", this.operator_equals(
      this.stream, _format));
    
  }
  
  private IllegalStateException _init__logWithFormat_exception() {
    IllegalStateException _illegalStateException = new IllegalStateException();
    return _illegalStateException;
  }
  
  private void _transition_exprAction__logWithFormat_transitions0_actions0(final IllegalStateException exception) {
    try {
      
      this.logger.setFormatString(this.formatString);
      } catch (junit.framework.AssertionFailedError error) {
      fail("logger.setFormatString(formatString) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__logWithFormat_transitions0_actions1(final IllegalStateException exception) {
    try {
      
      this.logger.log(ILogger.INFO, "En melding ble logget!", exception);
      } catch (junit.framework.AssertionFailedError error) {
      fail("logger.log(ILogger.INFO, \"En melding ble logget!\", exception) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__logWithFormat_transitions0_effect_state(final IllegalStateException exception) {
    _test__logWithFormat_transitions0_effect_state_objectTests0_test(exception);
    
  }
  
  private void _test__logWithFormat_transitions0_effect_state_objectTests0_test(final IllegalStateException exception) {
    
    String _format = String.format(this.formatString, ILogger.INFO, "En melding ble logget!", exception);
    assertTrue("stream == String.format(formatString, ILogger.INFO, \"En melding ble logget!\", exception) failed after logger.setFormatString(formatString) ,logger.log(ILogger.INFO, \"En melding ble logget!\", exception)", this.operator_equals(
      this.stream, _format));
    
  }
  
  public static void main(final String[] args) {
    no.hal.jex.standalone.JexStandalone.main(StreamLoggerTest.class);
  }
}
