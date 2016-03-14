package delegation;

public interface ILogger {
    public String ERROR = "error", WARNING = "warning", INFO = "info";
    public void log(String severity, String message, Exception exception);
}
