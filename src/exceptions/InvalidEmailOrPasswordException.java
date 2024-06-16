package exceptions;

public class InvalidEmailOrPasswordException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid email or password. Please try again.";
    }
}
