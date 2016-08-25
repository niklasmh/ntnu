package delegation;

import java.util.HashMap;
import java.util.Map;

public class DistributingLogger implements ILogger {
    private Map<String, ILogger> loggers = new HashMap<String, ILogger>();
    private ILogger errorLogger, warningLogger, infoLogger;

    public DistributingLogger (ILogger errorLogger, ILogger warningLogger, ILogger infoLogger) {
        setLogger(ILogger.ERROR, errorLogger);
        setLogger(ILogger.WARNING, warningLogger);
        setLogger(ILogger.INFO, infoLogger);
    }

    public void setLogger(String severity, ILogger logger) {
        this.loggers.put(severity, logger);
    }

    @Override
    public void log(String severity, String message, Exception exception) {
        ILogger logger = loggers.get(severity);

        if (logger != null) {
            logger.log(severity, message, exception);
        }
    }
}
