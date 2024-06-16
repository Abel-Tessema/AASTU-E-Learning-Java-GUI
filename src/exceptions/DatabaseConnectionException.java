package exceptions;

public class DatabaseConnectionException extends Exception {
    @Override
    public String getMessage() {
        return "Connection error. Please try again.";
    }
}
