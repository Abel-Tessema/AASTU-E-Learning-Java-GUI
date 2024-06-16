package exceptions;

public class IncorrectPasswordException extends Exception {
    @Override
    public String getMessage() {
        return "Incorrect old password. Please try again.";
    }
}
