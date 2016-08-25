package delegation;

import java.io.IOException;
import java.io.OutputStream;

public class StreamLogger implements ILogger {
    private String logMessage, format = "%s: %s (%s)";
    private OutputStream stream;

    public StreamLogger(OutputStream stream) {
        super();
        this.stream = stream;
    }

    public void setFormatString(String formatString) {
        this.format = formatString;
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
