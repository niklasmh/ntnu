package delegation;

import com.google.common.base.Objects;
import java.io.ByteArrayOutputStream;
import junit.framework.TestCase;
import no.hal.jex.runtime.JExercise;

@JExercise(description = "Tests delegation.FilteringLogger")
@SuppressWarnings("all")
public class FilteringLoggerTest extends TestCase {
  private String formatString;
  
  private String _init_formatString() {
    return "%s: %s (%s)";
  }
  
  private ByteArrayOutputStream stream;
  
  private ByteArrayOutputStream _init_stream() {
    ByteArrayOutputStream _byteArrayOutputStream = new ByteArrayOutputStream();
    return _byteArrayOutputStream;
  }
  
  private StreamLogger subLogger;
  
  private StreamLogger _init_subLogger() {
    StreamLogger _streamLogger = new StreamLogger(this.stream);
    return _streamLogger;
  }
  
  @Override
  protected void setUp() {
    formatString = _init_formatString();
    stream = _init_stream();
    subLogger = _init_subLogger();
    
  }
  
  private boolean operator_equals(final ByteArrayOutputStream stream, final String content) {
    String _string = stream.toString();
    String _trim = _string.trim();
    String _trim_1 = content.trim();
    return Objects.equal(_trim, _trim_1);
  }
  
  @JExercise(tests = "FilteringLogger(delegation.ILogger,String[])", description = "Tests \n\t\tinitialization\n")
  public void testFilteringLoggerNoSeverities() {
    FilteringLogger logger = _init__FilteringLoggerNoSeverities_logger();
    _test__FilteringLoggerNoSeverities_transitions0_effect_state(logger);
    
  }
  
  @JExercise(tests = "FilteringLogger(delegation.ILogger,String[])", description = "Tests \n\t\tinitialization\n")
  public void testFilteringLoggerErrorAndInfo() {
    FilteringLogger logger = _init__FilteringLoggerErrorAndInfo_logger();
    _test__FilteringLoggerErrorAndInfo_transitions0_effect_state(logger);
    
  }
  
  @JExercise(tests = "FilteringLogger(delegation.ILogger,String[]);void setIsLogging(String,boolean)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>logger.setIsLogging(ILogger.ERROR, true)</li>\n\t\t</ul>\n")
  public void testFilteringLoggerWarningSetIsLoggingError() {
    FilteringLogger logger = _init__FilteringLoggerWarningSetIsLoggingError_logger();
    _test__FilteringLoggerWarningSetIsLoggingError_transitions0_effect_state(logger);
    _transition_exprAction__FilteringLoggerWarningSetIsLoggingError_transitions1_actions0(logger);
    _test__FilteringLoggerWarningSetIsLoggingError_transitions1_effect_state(logger);
    
  }
  
  @JExercise(tests = "FilteringLogger(delegation.ILogger,String[]);void log(String,String,Exception)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>Logger med alvorlighetsgrad ERROR: subLogger.setFormatString(formatString), logger.log(ILogger.ERROR, \"Noe er feil!\", exception)</li>\n\t\t</ul>\n")
  public void testErrorLogging() {
    IllegalStateException exception = _init__errorLogging_exception();
    FilteringLogger logger = _init__errorLogging_logger();
    _transition_exprAction__errorLogging_transitions0_actions0(exception, logger);
    _transition_exprAction__errorLogging_transitions0_actions1(exception, logger);
    _test__errorLogging_transitions0_effect_state(exception, logger);
    
  }
  
  @JExercise(tests = "FilteringLogger(delegation.ILogger,String[]);void log(String,String,Exception)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>Logger med alvorlighetsgrad INFO: subLogger.setFormatString(formatString), logger.log(ILogger.INFO, \"Noe er feil!\", exception)</li>\n\t\t</ul>\n")
  public void testInfoToErrorLogger() {
    IllegalStateException exception = _init__infoToErrorLogger_exception();
    FilteringLogger logger = _init__infoToErrorLogger_logger();
    _transition_exprAction__infoToErrorLogger_transitions0_actions0(exception, logger);
    _transition_exprAction__infoToErrorLogger_transitions0_actions1(exception, logger);
    _test__infoToErrorLogger_transitions0_effect_state(exception, logger);
    
  }
  
  private FilteringLogger _init__FilteringLoggerNoSeverities_logger() {
    FilteringLogger _filteringLogger = new FilteringLogger(this.subLogger);
    return _filteringLogger;
  }
  
  private void _test__FilteringLoggerNoSeverities_transitions0_effect_state(final FilteringLogger logger) {
    _test__FilteringLoggerNoSeverities_transitions0_effect_state_objectTests0_test(logger);
    
  }
  
  private void _test__FilteringLoggerNoSeverities_transitions0_effect_state_objectTests0_test(final FilteringLogger logger) {
    
    boolean _isLogging = logger.isLogging(ILogger.INFO);
    boolean _not = (!_isLogging);
    assertTrue("! logger.isLogging(ILogger.INFO) failed", _not);
    
    boolean _isLogging_1 = logger.isLogging(ILogger.WARNING);
    boolean _not_1 = (!_isLogging_1);
    assertTrue("! logger.isLogging(ILogger.WARNING) failed", _not_1);
    
    boolean _isLogging_2 = logger.isLogging(ILogger.ERROR);
    assertTrue("! logger.isLogging(ILogger.ERROR) failed", (!_isLogging_2));
    
  }
  
  private FilteringLogger _init__FilteringLoggerErrorAndInfo_logger() {
    FilteringLogger _filteringLogger = new FilteringLogger(this.subLogger, ILogger.ERROR, ILogger.INFO);
    return _filteringLogger;
  }
  
  private void _test__FilteringLoggerErrorAndInfo_transitions0_effect_state(final FilteringLogger logger) {
    _test__FilteringLoggerErrorAndInfo_transitions0_effect_state_objectTests0_test(logger);
    
  }
  
  private void _test__FilteringLoggerErrorAndInfo_transitions0_effect_state_objectTests0_test(final FilteringLogger logger) {
    
    boolean _isLogging = logger.isLogging(ILogger.INFO);
    assertTrue("logger.isLogging(ILogger.INFO) failed", _isLogging);
    
    boolean _isLogging_1 = logger.isLogging(ILogger.WARNING);
    boolean _not = (!_isLogging_1);
    assertTrue("! logger.isLogging(ILogger.WARNING) failed", _not);
    
    assertTrue("logger.isLogging(ILogger.ERROR) failed", logger.isLogging(ILogger.ERROR));
    
  }
  
  private FilteringLogger _init__FilteringLoggerWarningSetIsLoggingError_logger() {
    FilteringLogger _filteringLogger = new FilteringLogger(this.subLogger, ILogger.WARNING);
    return _filteringLogger;
  }
  
  private void _test__FilteringLoggerWarningSetIsLoggingError_transitions0_effect_state(final FilteringLogger logger) {
    _test__FilteringLoggerWarningSetIsLoggingError_transitions0_effect_state_objectTests0_test(logger);
    
  }
  
  private void _test__FilteringLoggerWarningSetIsLoggingError_transitions0_effect_state_objectTests0_test(final FilteringLogger logger) {
    
    boolean _isLogging = logger.isLogging(ILogger.INFO);
    boolean _not = (!_isLogging);
    assertTrue("! logger.isLogging(ILogger.INFO) failed", _not);
    
    boolean _isLogging_1 = logger.isLogging(ILogger.WARNING);
    assertTrue("logger.isLogging(ILogger.WARNING) failed", _isLogging_1);
    
    boolean _isLogging_2 = logger.isLogging(ILogger.ERROR);
    assertTrue("! logger.isLogging(ILogger.ERROR) failed", (!_isLogging_2));
    
  }
  
  private void _transition_exprAction__FilteringLoggerWarningSetIsLoggingError_transitions1_actions0(final FilteringLogger logger) {
    try {
      
      logger.setIsLogging(ILogger.ERROR, true);
      } catch (junit.framework.AssertionFailedError error) {
      fail("logger.setIsLogging(ILogger.ERROR, true) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__FilteringLoggerWarningSetIsLoggingError_transitions1_effect_state(final FilteringLogger logger) {
    _test__FilteringLoggerWarningSetIsLoggingError_transitions1_effect_state_objectTests0_test(logger);
    
  }
  
  private void _test__FilteringLoggerWarningSetIsLoggingError_transitions1_effect_state_objectTests0_test(final FilteringLogger logger) {
    
    boolean _isLogging = logger.isLogging(ILogger.INFO);
    boolean _not = (!_isLogging);
    assertTrue("! logger.isLogging(ILogger.INFO) failed after logger.setIsLogging(ILogger.ERROR, true)", _not);
    
    boolean _isLogging_1 = logger.isLogging(ILogger.WARNING);
    assertTrue("logger.isLogging(ILogger.WARNING) failed after logger.setIsLogging(ILogger.ERROR, true)", _isLogging_1);
    
    assertTrue("logger.isLogging(ILogger.ERROR) failed after logger.setIsLogging(ILogger.ERROR, true)", logger.isLogging(ILogger.ERROR));
    
  }
  
  private IllegalStateException _init__errorLogging_exception() {
    IllegalStateException _illegalStateException = new IllegalStateException();
    return _illegalStateException;
  }
  
  private FilteringLogger _init__errorLogging_logger() {
    FilteringLogger _filteringLogger = new FilteringLogger(this.subLogger, ILogger.ERROR);
    return _filteringLogger;
  }
  
  private void _transition_exprAction__errorLogging_transitions0_actions0(final IllegalStateException exception, final FilteringLogger logger) {
    try {
      
      this.subLogger.setFormatString(this.formatString);
      } catch (junit.framework.AssertionFailedError error) {
      fail("subLogger.setFormatString(formatString) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__errorLogging_transitions0_actions1(final IllegalStateException exception, final FilteringLogger logger) {
    try {
      
      logger.log(ILogger.ERROR, "Noe er feil!", exception);
      } catch (junit.framework.AssertionFailedError error) {
      fail("logger.log(ILogger.ERROR, \"Noe er feil!\", exception) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__errorLogging_transitions0_effect_state(final IllegalStateException exception, final FilteringLogger logger) {
    _test__errorLogging_transitions0_effect_state_objectTests0_test(exception, logger);
    
  }
  
  private void _test__errorLogging_transitions0_effect_state_objectTests0_test(final IllegalStateException exception, final FilteringLogger logger) {
    
    String _format = String.format(this.formatString, ILogger.ERROR, "Noe er feil!", exception);
    assertTrue("stream == String.format(formatString, ILogger.ERROR, \"Noe er feil!\", exception) failed after subLogger.setFormatString(formatString) ,logger.log(ILogger.ERROR, \"Noe er feil!\", exception)", this.operator_equals(
      this.stream, _format));
    
  }
  
  private IllegalStateException _init__infoToErrorLogger_exception() {
    IllegalStateException _illegalStateException = new IllegalStateException();
    return _illegalStateException;
  }
  
  private FilteringLogger _init__infoToErrorLogger_logger() {
    FilteringLogger _filteringLogger = new FilteringLogger(this.subLogger, ILogger.ERROR);
    return _filteringLogger;
  }
  
  private void _transition_exprAction__infoToErrorLogger_transitions0_actions0(final IllegalStateException exception, final FilteringLogger logger) {
    try {
      
      this.subLogger.setFormatString(this.formatString);
      } catch (junit.framework.AssertionFailedError error) {
      fail("subLogger.setFormatString(formatString) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__infoToErrorLogger_transitions0_actions1(final IllegalStateException exception, final FilteringLogger logger) {
    try {
      
      logger.log(ILogger.INFO, "Noe er feil!", exception);
      } catch (junit.framework.AssertionFailedError error) {
      fail("logger.log(ILogger.INFO, \"Noe er feil!\", exception) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__infoToErrorLogger_transitions0_effect_state(final IllegalStateException exception, final FilteringLogger logger) {
    _test__infoToErrorLogger_transitions0_effect_state_objectTests0_test(exception, logger);
    
  }
  
  private void _test__infoToErrorLogger_transitions0_effect_state_objectTests0_test(final IllegalStateException exception, final FilteringLogger logger) {
    
    assertTrue("stream == \"\" failed after subLogger.setFormatString(formatString) ,logger.log(ILogger.INFO, \"Noe er feil!\", exception)", this.operator_equals(
      this.stream, ""));
    
  }
  
  public static void main(final String[] args) {
    no.hal.jex.standalone.JexStandalone.main(FilteringLoggerTest.class);
  }
}