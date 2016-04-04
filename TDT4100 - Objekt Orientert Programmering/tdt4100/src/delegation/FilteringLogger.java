package delegation;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FilteringLogger implements ILogger {
    private List<String> severities;
    //private String logMessage, format = "%s: %s (%s)";
    private OutputStream stream;
    private ILogger logger;

    public FilteringLogger(ILogger logger, String... severities) {
        //super();
        //Collections.addAll(this.severities, severities);
        this.severities = new ArrayList<>(Arrays.asList(severities));
        this.logger = logger;
    }

    public boolean isLogging(String severity) {
        return this.severities.contains(severity);
    }

    public void setIsLogging(String severity, boolean value) {

        if (value && !this.severities.contains(severity)) {
            this.severities.add(severity);
        } else if (!value) {
            this.severities.remove(severity);
        }
    }

    @Override
    public void log(String severity, String message, Exception exception) {
        //logMessage = String.format(format, severity, message, exception);
        if (isLogging(severity)) {
            logger.log(severity, message, exception);
        }
    }
}
