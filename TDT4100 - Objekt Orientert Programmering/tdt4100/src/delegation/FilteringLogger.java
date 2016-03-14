package delegation;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;

public class FilteringLogger implements ILogger {
    private List<String> severities;
    private String logMessage, format = "%s: %s (%s)";
    private OutputStream stream;

    public FilteringLogger(ILogger logger, String... severities) {
        Collections.addAll(this.severities, severities);
    }

    public boolean isLogging(String severity) {
        return this.severities.contains(severity);
    }

    public void setIsLogging(String severity, boolean value) {

        if (value && !this.severities.contains(severity)) {
            this.severities.add(severity);
        }
    }

    @Override
    public void log(String severity, String message, Exception exception) {
        logMessage = String.format(format, severity, message, exception);

        try {
            stream.write(logMessage.getBytes());
        } catch (IOException err) {
            System.out.println("Error: " + err.getMessage());
        }
    }
}
