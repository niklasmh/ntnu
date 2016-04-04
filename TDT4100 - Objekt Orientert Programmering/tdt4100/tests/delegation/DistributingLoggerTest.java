package delegation;

import com.google.common.base.Objects;
import java.io.ByteArrayOutputStream;
import junit.framework.TestCase;
import no.hal.jex.runtime.JExercise;

@JExercise(description = "Tests delegation.DistributingLogger")
@SuppressWarnings("all")
public class DistributingLoggerTest extends TestCase {
  private String formatString;
  
  private String _init_formatString() {
    return "%s: %s (%s)";
  }
  
  private ByteArrayOutputStream infoStream;
  
  private ByteArrayOutputStream _init_infoStream() {
    ByteArrayOutputStream _byteArrayOutputStream = new ByteArrayOutputStream();
    return _byteArrayOutputStream;
  }
  
  private ByteArrayOutputStream warnStream;
  
  private ByteArrayOutputStream _init_warnStream() {
    ByteArrayOutputStream _byteArrayOutputStream = new ByteArrayOutputStream();
    return _byteArrayOutputStream;
  }
  
  private ByteArrayOutputStream errorStream;
  
  private ByteArrayOutputStream _init_errorStream() {
    ByteArrayOutputStream _byteArrayOutputStream = new ByteArrayOutputStream();
    return _byteArrayOutputStream;
  }
  
  private ByteArrayOutputStream newInfoStream;
  
  private ByteArrayOutputStream _init_newInfoStream() {
    ByteArrayOutputStream _byteArrayOutputStream = new ByteArrayOutputStream();
    return _byteArrayOutputStream;
  }
  
  private StreamLogger infoLogger;
  
  private StreamLogger _init_infoLogger() {
    StreamLogger _streamLogger = new StreamLogger(this.infoStream);
    return _streamLogger;
  }
  
  private StreamLogger warnLogger;
  
  private StreamLogger _init_warnLogger() {
    StreamLogger _streamLogger = new StreamLogger(this.warnStream);
    return _streamLogger;
  }
  
  private StreamLogger errorLogger;
  
  private StreamLogger _init_errorLogger() {
    StreamLogger _streamLogger = new StreamLogger(this.errorStream);
    return _streamLogger;
  }
  
  private DistributingLogger logger;
  
  private DistributingLogger _init_logger() {
    DistributingLogger _distributingLogger = new DistributingLogger(this.errorLogger, this.warnLogger, this.infoLogger);
    return _distributingLogger;
  }
  
  @Override
  protected void setUp() {
    formatString = _init_formatString();
    infoStream = _init_infoStream();
    warnStream = _init_warnStream();
    errorStream = _init_errorStream();
    newInfoStream = _init_newInfoStream();
    infoLogger = _init_infoLogger();
    warnLogger = _init_warnLogger();
    errorLogger = _init_errorLogger();
    logger = _init_logger();
    
  }
  
  private boolean operator_equals(final ByteArrayOutputStream stream, final String content) {
    String _string = stream.toString();
    String _trim = _string.trim();
    String _trim_1 = content.trim();
    return Objects.equal(_trim, _trim_1);
  }
  
  @JExercise(tests = "DistributingLogger(delegation.ILogger,delegation.ILogger,delegation.ILogger);void log(String,String,Exception)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>Skriver en melding til INFO: infoLogger.formatString = formatString, logger.log(ILogger.INFO, \"Dette er en info-melding.\", null)</li>\n\t\t</ul>\n")
  public void testLogToInfo() {
    _transition_exprAction__logToInfo_transitions0_actions0();
    _transition_exprAction__logToInfo_transitions0_actions1();
    _test__logToInfo_transitions0_effect_state();
    
  }
  
  @JExercise(tests = "DistributingLogger(delegation.ILogger,delegation.ILogger,delegation.ILogger);void log(String,String,Exception)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>Skriver en melding til WARNING: warnLogger.formatString = formatString, logger.log(ILogger.WARNING, \"Dette er en advarsel.\", null)</li>\n\t\t</ul>\n")
  public void testLogToWarn() {
    _transition_exprAction__logToWarn_transitions0_actions0();
    _transition_exprAction__logToWarn_transitions0_actions1();
    _test__logToWarn_transitions0_effect_state();
    
  }
  
  @JExercise(tests = "DistributingLogger(delegation.ILogger,delegation.ILogger,delegation.ILogger);void log(String,String,Exception)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>Skriver en melding til ERROR: errorLogger.formatString = formatString, logger.log(ILogger.ERROR, \"Dette er en feilmelding.\", exception)</li>\n\t\t</ul>\n")
  public void testLogToError() {
    Exception exception = _init__logToError_exception();
    _transition_exprAction__logToError_transitions0_actions0(exception);
    _transition_exprAction__logToError_transitions0_actions1(exception);
    _test__logToError_transitions0_effect_state(exception);
    
  }
  
  @JExercise(tests = "DistributingLogger(delegation.ILogger,delegation.ILogger,delegation.ILogger);void log(String,String,Exception);void setLogger(String,delegation.ILogger)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>Skriver til INFO.: infoLogger.formatString = formatString, logger.log(ILogger.INFO, \"Dette er en info-melding.\", null)</li>\n\t\t<li>Bytter INFO-logger.: newInfoLogger.formatString = formatString, logger.setLogger(ILogger.INFO, newInfoLogger), logger.log(ILogger.INFO, \"Dette er en den andre info-meldingen.\", null)</li>\n\t\t</ul>\n")
  public void testChangeInfoLogger() {
    StreamLogger newInfoLogger = _init__changeInfoLogger_newInfoLogger();
    _transition_exprAction__changeInfoLogger_transitions0_actions0(newInfoLogger);
    _transition_exprAction__changeInfoLogger_transitions0_actions1(newInfoLogger);
    _test__changeInfoLogger_transitions0_effect_state(newInfoLogger);
    _transition_exprAction__changeInfoLogger_transitions1_actions0(newInfoLogger);
    _transition_exprAction__changeInfoLogger_transitions1_actions1(newInfoLogger);
    _transition_exprAction__changeInfoLogger_transitions1_actions2(newInfoLogger);
    _test__changeInfoLogger_transitions1_effect_state(newInfoLogger);
    
  }
  
  private void _transition_exprAction__logToInfo_transitions0_actions0() {
    try {
      
      this.infoLogger.setFormatString(this.formatString);
      } catch (junit.framework.AssertionFailedError error) {
      fail("infoLogger.formatString = formatString failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__logToInfo_transitions0_actions1() {
    try {
      
      this.logger.log(ILogger.INFO, "Dette er en info-melding.", null);
      } catch (junit.framework.AssertionFailedError error) {
      fail("logger.log(ILogger.INFO, \"Dette er en info-melding.\", null) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__logToInfo_transitions0_effect_state() {
    _test__logToInfo_transitions0_effect_state_objectTests0_test();
    
  }
  
  private void _test__logToInfo_transitions0_effect_state_objectTests0_test() {
    
    String _format = String.format(this.formatString, ILogger.INFO, "Dette er en info-melding.", null);
    boolean _equals = this.operator_equals(
      this.infoStream, _format);
    assertTrue("infoStream == String.format(formatString, ILogger.INFO, \"Dette er en info-melding.\", null) failed after infoLogger.formatString = formatString ,logger.log(ILogger.INFO, \"Dette er en info-melding.\", null)", _equals);
    
    boolean _equals_1 = this.operator_equals(
      this.warnStream, "");
    assertTrue("warnStream == \"\" failed after infoLogger.formatString = formatString ,logger.log(ILogger.INFO, \"Dette er en info-melding.\", null)", _equals_1);
    
    assertTrue("errorStream == \"\" failed after infoLogger.formatString = formatString ,logger.log(ILogger.INFO, \"Dette er en info-melding.\", null)", this.operator_equals(
      this.errorStream, ""));
    
  }
  
  private void _transition_exprAction__logToWarn_transitions0_actions0() {
    try {
      
      this.warnLogger.setFormatString(this.formatString);
      } catch (junit.framework.AssertionFailedError error) {
      fail("warnLogger.formatString = formatString failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__logToWarn_transitions0_actions1() {
    try {
      
      this.logger.log(ILogger.WARNING, "Dette er en advarsel.", null);
      } catch (junit.framework.AssertionFailedError error) {
      fail("logger.log(ILogger.WARNING, \"Dette er en advarsel.\", null) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__logToWarn_transitions0_effect_state() {
    _test__logToWarn_transitions0_effect_state_objectTests0_test();
    
  }
  
  private void _test__logToWarn_transitions0_effect_state_objectTests0_test() {
    
    boolean _equals = this.operator_equals(
      this.infoStream, "");
    assertTrue("infoStream == \"\" failed after warnLogger.formatString = formatString ,logger.log(ILogger.WARNING, \"Dette er en advarsel.\", null)", _equals);
    
    String _format = String.format(this.formatString, ILogger.WARNING, "Dette er en advarsel.", null);
    boolean _equals_1 = this.operator_equals(
      this.warnStream, _format);
    assertTrue("warnStream == String.format(formatString, ILogger.WARNING, \"Dette er en advarsel.\", null) failed after warnLogger.formatString = formatString ,logger.log(ILogger.WARNING, \"Dette er en advarsel.\", null)", _equals_1);
    
    assertTrue("errorStream == \"\" failed after warnLogger.formatString = formatString ,logger.log(ILogger.WARNING, \"Dette er en advarsel.\", null)", this.operator_equals(
      this.errorStream, ""));
    
  }
  
  private Exception _init__logToError_exception() {
    IllegalStateException _illegalStateException = new IllegalStateException();
    return _illegalStateException;
  }
  
  private void _transition_exprAction__logToError_transitions0_actions0(final Exception exception) {
    try {
      
      this.errorLogger.setFormatString(this.formatString);
      } catch (junit.framework.AssertionFailedError error) {
      fail("errorLogger.formatString = formatString failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__logToError_transitions0_actions1(final Exception exception) {
    try {
      
      this.logger.log(ILogger.ERROR, "Dette er en feilmelding.", exception);
      } catch (junit.framework.AssertionFailedError error) {
      fail("logger.log(ILogger.ERROR, \"Dette er en feilmelding.\", exception) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__logToError_transitions0_effect_state(final Exception exception) {
    _test__logToError_transitions0_effect_state_objectTests0_test(exception);
    
  }
  
  private void _test__logToError_transitions0_effect_state_objectTests0_test(final Exception exception) {
    
    boolean _equals = this.operator_equals(
      this.infoStream, "");
    assertTrue("infoStream == \"\" failed after errorLogger.formatString = formatString ,logger.log(ILogger.ERROR, \"Dette er en feilmelding.\", exception)", _equals);
    
    boolean _equals_1 = this.operator_equals(
      this.warnStream, "");
    assertTrue("warnStream == \"\" failed after errorLogger.formatString = formatString ,logger.log(ILogger.ERROR, \"Dette er en feilmelding.\", exception)", _equals_1);
    
    String _format = String.format(this.formatString, ILogger.ERROR, "Dette er en feilmelding.", exception);
    assertTrue("errorStream == String.format(formatString, ILogger.ERROR, \"Dette er en feilmelding.\", exception) failed after errorLogger.formatString = formatString ,logger.log(ILogger.ERROR, \"Dette er en feilmelding.\", exception)", this.operator_equals(
      this.errorStream, _format));
    
  }
  
  private StreamLogger _init__changeInfoLogger_newInfoLogger() {
    StreamLogger _streamLogger = new StreamLogger(this.newInfoStream);
    return _streamLogger;
  }
  
  private void _transition_exprAction__changeInfoLogger_transitions0_actions0(final StreamLogger newInfoLogger) {
    try {
      
      this.infoLogger.setFormatString(this.formatString);
      } catch (junit.framework.AssertionFailedError error) {
      fail("infoLogger.formatString = formatString failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__changeInfoLogger_transitions0_actions1(final StreamLogger newInfoLogger) {
    try {
      
      this.logger.log(ILogger.INFO, "Dette er en info-melding.", null);
      } catch (junit.framework.AssertionFailedError error) {
      fail("logger.log(ILogger.INFO, \"Dette er en info-melding.\", null) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__changeInfoLogger_transitions0_effect_state(final StreamLogger newInfoLogger) {
    _test__changeInfoLogger_transitions0_effect_state_objectTests0_test(newInfoLogger);
    
  }
  
  private void _test__changeInfoLogger_transitions0_effect_state_objectTests0_test(final StreamLogger newInfoLogger) {
    
    String _format = String.format(this.formatString, ILogger.INFO, "Dette er en info-melding.", null);
    assertTrue("infoStream == String.format(formatString, ILogger.INFO, \"Dette er en info-melding.\", null) failed after infoLogger.formatString = formatString ,logger.log(ILogger.INFO, \"Dette er en info-melding.\", null)", this.operator_equals(
      this.infoStream, _format));
    
  }
  
  private void _transition_exprAction__changeInfoLogger_transitions1_actions0(final StreamLogger newInfoLogger) {
    try {
      
      newInfoLogger.setFormatString(this.formatString);
      } catch (junit.framework.AssertionFailedError error) {
      fail("newInfoLogger.formatString = formatString failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__changeInfoLogger_transitions1_actions1(final StreamLogger newInfoLogger) {
    try {
      
      this.logger.setLogger(ILogger.INFO, newInfoLogger);
      } catch (junit.framework.AssertionFailedError error) {
      fail("logger.setLogger(ILogger.INFO, newInfoLogger) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__changeInfoLogger_transitions1_actions2(final StreamLogger newInfoLogger) {
    try {
      
      this.logger.log(ILogger.INFO, "Dette er en den andre info-meldingen.", null);
      } catch (junit.framework.AssertionFailedError error) {
      fail("logger.log(ILogger.INFO, \"Dette er en den andre info-meldingen.\", null) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__changeInfoLogger_transitions1_effect_state(final StreamLogger newInfoLogger) {
    _test__changeInfoLogger_transitions1_effect_state_objectTests0_test(newInfoLogger);
    
  }
  
  private void _test__changeInfoLogger_transitions1_effect_state_objectTests0_test(final StreamLogger newInfoLogger) {
    
    String _format = String.format(this.formatString, ILogger.INFO, "Dette er en info-melding.", null);
    boolean _equals = this.operator_equals(
      this.infoStream, _format);
    assertTrue("infoStream == String.format(formatString, ILogger.INFO, \"Dette er en info-melding.\", null) failed after newInfoLogger.formatString = formatString ,logger.setLogger(ILogger.INFO, newInfoLogger) ,logger.log(ILogger.INFO, \"Dette er en den andre info-meldingen.\", null)", _equals);
    
    String _format_1 = String.format(this.formatString, ILogger.INFO, "Dette er en den andre info-meldingen.", null);
    assertTrue("newInfoStream == String.format(formatString, ILogger.INFO, \"Dette er en den andre info-meldingen.\", null) failed after newInfoLogger.formatString = formatString ,logger.setLogger(ILogger.INFO, newInfoLogger) ,logger.log(ILogger.INFO, \"Dette er en den andre info-meldingen.\", null)", this.operator_equals(
      this.newInfoStream, _format_1));
    
  }
  
  public static void main(final String[] args) {
    no.hal.jex.standalone.JexStandalone.main(DistributingLoggerTest.class);
  }
}